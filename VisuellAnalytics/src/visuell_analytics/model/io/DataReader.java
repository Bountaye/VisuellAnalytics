package visuell_analytics.model.io;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import visuell_analytics.model.item.Item;
import visuell_analytics.model.item.Sale;
import visuell_analytics.model.stockGroup.ItemList;
import visuell_analytics.model.util.Date;

public class DataReader {

	public static ItemList readStkGrpSum(String filename) {
		//TODO exit at grand total
		ItemList all = new ItemList();

		// Try block to check for exceptions
		try {

			// Reading file from local directory
			FileInputStream file = new FileInputStream(
					new File(filename));

			// Create Workbook instance holding reference to
			// .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();

			// Iterating through empty blocks
			for (int i = 0; i < 12; i++) {
				rowIterator.next();
			}

			// Till there is an element condition holds true
			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();

				// For each row, iterate through all the
				// columns
				Iterator<Cell> cellIterator = row.cellIterator();

				String itemId = cellIterator.next().getStringCellValue();
//				int itemQuantity = Integer.parseInt(cellIterator.next().getStringCellValue().split(" ")[0]);
				int itemQuantity = (int) cellIterator.next().getNumericCellValue();
				float itemRate = (float) cellIterator.next().getNumericCellValue();
				all.addItem(new Item(itemId, itemQuantity, itemRate));
				System.out.println("Read stock item: " + itemId);
			}

			// Closing file output streams
			file.close();
			workbook.close();
			return all;
		}

		// Catch block to handle exceptions
		catch (Exception e) {

			// Display the exception along with line number
			// using printStackTrace() method
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	public static ItemList readDayBook(String filename, ItemList all) {

		try {

			FileInputStream file = new FileInputStream(
					new File(filename));

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(1);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();

			// Iterating through empty blocks
			for (int i = 0; i < 9; i++) {
				rowIterator.next();
			}
			Date date = null;
			// Till there is an element condition holds true
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell firstColumn = cellIterator.next();
				String maybeDate = firstColumn.toString();
				System.out.println(maybeDate);
				// If line contains date, it doesn't hold sale information. if it doesn't then
				// sale must be recorded using declared date.
				if (maybeDate.length() > 0) {
					String[] dateArray = maybeDate.split("-");
					for(int i = 0; i < dateArray.length; i++) {
						System.out.println(dateArray[i]);
					}
					date = new Date(Integer.parseInt(dateArray[0]), dateArray[1], Integer.parseInt(dateArray[2]));
				} else {
					String saleId = cellIterator.next().getStringCellValue();
					cellIterator.next();
					cellIterator.next();
					cellIterator.next();
//					int saleQuantity = Integer.parseInt(cellIterator.next().getStringCellValue().split(" ")[0]);
					int saleQuantity = (int) cellIterator.next().getNumericCellValue();
					float saleRate = (float) cellIterator.next().getNumericCellValue() / saleQuantity;
					all.addSale(new Sale(saleId, date, saleQuantity, saleRate));
					System.out.println("Read Sale: " + saleId);
				}

			}

			// Closing file output streams
			file.close();
			workbook.close();
			all.evaluateItems();
			return all;
		}

		// Catch block to handle exceptions
		catch (Exception e) {

			// Display the exception along with line number
			// using printStackTrace() method
			e.printStackTrace();
			return null;
		}
	}
}
