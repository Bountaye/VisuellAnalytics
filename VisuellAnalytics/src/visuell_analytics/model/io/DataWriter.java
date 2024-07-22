package visuell_analytics.model.io;

import java.io.FileOutputStream;
import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import visuell_analytics.model.stockGroup.ItemList;

public class DataWriter {
	public static void exportData(ItemList all, String filename) {
		// Creating workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// FIRST SHEET, alphabetic sort
		XSSFSheet sheet = workbook.createSheet("Alphabetic");
		all.sortById();

		// Title row, same for every sheet
		Row titleRow = sheet.createRow(0);
		Cell titleCell = titleRow.createCell(0);
		titleCell.setCellValue("Stock ID");
		titleCell = titleRow.createCell(1);
		titleCell.setCellValue("Death Index");
		titleCell = titleRow.createCell(2);
		titleCell.setCellValue("Days Since Last Sale");
		titleCell = titleRow.createCell(3);
		titleCell.setCellValue("Item Rate");
		titleCell = titleRow.createCell(4);
		titleCell.setCellValue("Inventory");
		titleCell = titleRow.createCell(5);
		titleCell.setCellValue("Average Monthly Quantity Sold");
		titleCell = titleRow.createCell(6);
		titleCell.setCellValue("Average Monthly Revenue");

		// Printing each item on the list
		int rownum = 7;
		for (int i = 0; i < all.size(); i++) {
			Row row = sheet.createRow(rownum++);
			Cell cell = row.createCell(0);
			cell.setCellValue(all.getItem(i).getId());
			cell = row.createCell(1);
			cell.setCellValue(all.getItem(i).getDeathIndex());
			cell = row.createCell(2);
			cell.setCellValue(all.getItem(i).getLastSaleAge());
			cell = row.createCell(3);
			cell.setCellValue(all.getItem(i).getRate());
			cell = row.createCell(4);
			cell.setCellValue(all.getItem(i).getInventory());
			cell = row.createCell(5);
			cell.setCellValue(all.getItem(i).getAvgMonthlyQuantity());
			cell = row.createCell(6);
			cell.setCellValue(all.getItem(i).getAvgMonthlyRevenue());
		}

		// SECOND SHEET, death index sort
		sheet = workbook.createSheet("Death Index");
		all.sortByDeathIndex();

		// Title row, same for every sheet
		titleRow = sheet.createRow(0);
		titleCell = titleRow.createCell(0);
		titleCell.setCellValue("Stock ID");
		titleCell = titleRow.createCell(1);
		titleCell.setCellValue("Death Index");
		titleCell = titleRow.createCell(2);
		titleCell.setCellValue("Days Since Last Sale");
		titleCell = titleRow.createCell(3);
		titleCell.setCellValue("Item Rate");
		titleCell = titleRow.createCell(4);
		titleCell.setCellValue("Inventory");
		titleCell = titleRow.createCell(5);
		titleCell.setCellValue("Average Monthly Quantity Sold");
		titleCell = titleRow.createCell(6);
		titleCell.setCellValue("Average Monthly Revenue");

		// Printing each item on the list
		rownum = 7;
		for (int i = 0; i < all.size(); i++) {
			Row row = sheet.createRow(rownum++);
			Cell cell = row.createCell(0);
			cell.setCellValue(all.getItem(i).getId());
			cell = row.createCell(1);
			cell.setCellValue(all.getItem(i).getDeathIndex());
			cell = row.createCell(2);
			cell.setCellValue(all.getItem(i).getLastSaleAge());
			cell = row.createCell(3);
			cell.setCellValue(all.getItem(i).getRate());
			cell = row.createCell(4);
			cell.setCellValue(all.getItem(i).getInventory());
			cell = row.createCell(5);
			cell.setCellValue(all.getItem(i).getAvgMonthlyQuantity());
			cell = row.createCell(6);
			cell.setCellValue(all.getItem(i).getAvgMonthlyRevenue());
		}

		// THIRD SHEET, last sale sort
		sheet = workbook.createSheet("Last Sale");
		all.sortByLastSale();

		// Title row, same for every sheet
		titleRow = sheet.createRow(0);
		titleCell = titleRow.createCell(0);
		titleCell.setCellValue("Stock ID");
		titleCell = titleRow.createCell(1);
		titleCell.setCellValue("Death Index");
		titleCell = titleRow.createCell(2);
		titleCell.setCellValue("Days Since Last Sale");
		titleCell = titleRow.createCell(3);
		titleCell.setCellValue("Item Rate");
		titleCell = titleRow.createCell(4);
		titleCell.setCellValue("Inventory");
		titleCell = titleRow.createCell(5);
		titleCell.setCellValue("Average Monthly Quantity Sold");
		titleCell = titleRow.createCell(6);
		titleCell.setCellValue("Average Monthly Revenue");

		// Printing each item on the list
		rownum = 7;
		for (int i = 0; i < all.size(); i++) {
			Row row = sheet.createRow(rownum++);
			Cell cell = row.createCell(0);
			cell.setCellValue(all.getItem(i).getId());
			cell = row.createCell(1);
			cell.setCellValue(all.getItem(i).getDeathIndex());
			cell = row.createCell(2);
			cell.setCellValue(all.getItem(i).getLastSaleAge());
			cell = row.createCell(3);
			cell.setCellValue(all.getItem(i).getRate());
			cell = row.createCell(4);
			cell.setCellValue(all.getItem(i).getInventory());
			cell = row.createCell(5);
			cell.setCellValue(all.getItem(i).getAvgMonthlyQuantity());
			cell = row.createCell(6);
			cell.setCellValue(all.getItem(i).getAvgMonthlyRevenue());
		}

		// FOURTH SHEET, price sort
		sheet = workbook.createSheet("Item Rate");
		all.sortByPrice();

		// Title row, same for every sheet
		titleRow = sheet.createRow(0);
		titleCell = titleRow.createCell(0);
		titleCell.setCellValue("Stock ID");
		titleCell = titleRow.createCell(1);
		titleCell.setCellValue("Death Index");
		titleCell = titleRow.createCell(2);
		titleCell.setCellValue("Days Since Last Sale");
		titleCell = titleRow.createCell(3);
		titleCell.setCellValue("Item Rate");
		titleCell = titleRow.createCell(4);
		titleCell.setCellValue("Inventory");
		titleCell = titleRow.createCell(5);
		titleCell.setCellValue("Average Monthly Quantity Sold");
		titleCell = titleRow.createCell(6);
		titleCell.setCellValue("Average Monthly Revenue");

		// Printing each item on the list
		rownum = 7;
		for (int i = 0; i < all.size(); i++) {
			Row row = sheet.createRow(rownum++);
			Cell cell = row.createCell(0);
			cell.setCellValue(all.getItem(i).getId());
			cell = row.createCell(1);
			cell.setCellValue(all.getItem(i).getDeathIndex());
			cell = row.createCell(2);
			cell.setCellValue(all.getItem(i).getLastSaleAge());
			cell = row.createCell(3);
			cell.setCellValue(all.getItem(i).getRate());
			cell = row.createCell(4);
			cell.setCellValue(all.getItem(i).getInventory());
			cell = row.createCell(5);
			cell.setCellValue(all.getItem(i).getAvgMonthlyQuantity());
			cell = row.createCell(6);
			cell.setCellValue(all.getItem(i).getAvgMonthlyRevenue());
		}

		// FIFTH SHEET, inventory sort
		sheet = workbook.createSheet("Inventory");
		all.sortByInventory();

		// Title row, same for every sheet
		titleRow = sheet.createRow(0);
		titleCell = titleRow.createCell(0);
		titleCell.setCellValue("Stock ID");
		titleCell = titleRow.createCell(1);
		titleCell.setCellValue("Death Index");
		titleCell = titleRow.createCell(2);
		titleCell.setCellValue("Days Since Last Sale");
		titleCell = titleRow.createCell(3);
		titleCell.setCellValue("Item Rate");
		titleCell = titleRow.createCell(4);
		titleCell.setCellValue("Inventory");
		titleCell = titleRow.createCell(5);
		titleCell.setCellValue("Average Monthly Quantity Sold");
		titleCell = titleRow.createCell(6);
		titleCell.setCellValue("Average Monthly Revenue");

		// Printing each item on the list
		rownum = 7;
		for (int i = 0; i < all.size(); i++) {
			Row row = sheet.createRow(rownum++);
			Cell cell = row.createCell(0);
			cell.setCellValue(all.getItem(i).getId());
			cell = row.createCell(1);
			cell.setCellValue(all.getItem(i).getDeathIndex());
			cell = row.createCell(2);
			cell.setCellValue(all.getItem(i).getLastSaleAge());
			cell = row.createCell(3);
			cell.setCellValue(all.getItem(i).getRate());
			cell = row.createCell(4);
			cell.setCellValue(all.getItem(i).getInventory());
			cell = row.createCell(5);
			cell.setCellValue(all.getItem(i).getAvgMonthlyQuantity());
			cell = row.createCell(6);
			cell.setCellValue(all.getItem(i).getAvgMonthlyRevenue());
		}

		// SEVENTH SHEET, monthly revenue sort
		sheet = workbook.createSheet("Average Monthly Revenue");
		all.sortByAvgMonthlyRevenue();
		;

		// Title row, same for every sheet
		titleRow = sheet.createRow(0);
		titleCell = titleRow.createCell(0);
		titleCell.setCellValue("Stock ID");
		titleCell = titleRow.createCell(1);
		titleCell.setCellValue("Death Index");
		titleCell = titleRow.createCell(2);
		titleCell.setCellValue("Days Since Last Sale");
		titleCell = titleRow.createCell(3);
		titleCell.setCellValue("Item Rate");
		titleCell = titleRow.createCell(4);
		titleCell.setCellValue("Inventory");
		titleCell = titleRow.createCell(5);
		titleCell.setCellValue("Average Monthly Quantity Sold");
		titleCell = titleRow.createCell(6);
		titleCell.setCellValue("Average Monthly Revenue");

		// Printing each item on the list
		rownum = 7;
		for (int i = 0; i < all.size(); i++) {
			Row row = sheet.createRow(rownum++);
			Cell cell = row.createCell(0);
			cell.setCellValue(all.getItem(i).getId());
			cell = row.createCell(1);
			cell.setCellValue(all.getItem(i).getDeathIndex());
			cell = row.createCell(2);
			cell.setCellValue(all.getItem(i).getLastSaleAge());
			cell = row.createCell(3);
			cell.setCellValue(all.getItem(i).getRate());
			cell = row.createCell(4);
			cell.setCellValue(all.getItem(i).getInventory());
			cell = row.createCell(5);
			cell.setCellValue(all.getItem(i).getAvgMonthlyQuantity());
			cell = row.createCell(6);
			cell.setCellValue(all.getItem(i).getAvgMonthlyRevenue());
		}

		// THIRD SHEET, last sale sort
		sheet = workbook.createSheet("Last Sale");
		all.sortByLastSale();

		// Title row, same for every sheet
		titleRow = sheet.createRow(0);
		titleCell = titleRow.createCell(0);
		titleCell.setCellValue("Stock ID");
		titleCell = titleRow.createCell(1);
		titleCell.setCellValue("Death Index");
		titleCell = titleRow.createCell(2);
		titleCell.setCellValue("Days Since Last Sale");
		titleCell = titleRow.createCell(3);
		titleCell.setCellValue("Item Rate");
		titleCell = titleRow.createCell(4);
		titleCell.setCellValue("Inventory");
		titleCell = titleRow.createCell(5);
		titleCell.setCellValue("Average Monthly Quantity Sold");
		titleCell = titleRow.createCell(6);
		titleCell.setCellValue("Average Monthly Revenue");

		// Printing each item on the list
		rownum = 7;
		for (int i = 0; i < all.size(); i++) {
			Row row = sheet.createRow(rownum++);
			Cell cell = row.createCell(0);
			cell.setCellValue(all.getItem(i).getId());
			cell = row.createCell(1);
			cell.setCellValue(all.getItem(i).getDeathIndex());
			cell = row.createCell(2);
			cell.setCellValue(all.getItem(i).getLastSaleAge());
			cell = row.createCell(3);
			cell.setCellValue(all.getItem(i).getRate());
			cell = row.createCell(4);
			cell.setCellValue(all.getItem(i).getInventory());
			cell = row.createCell(5);
			cell.setCellValue(all.getItem(i).getAvgMonthlyQuantity());
			cell = row.createCell(6);
			cell.setCellValue(all.getItem(i).getAvgMonthlyRevenue());
		}
		try {

			// Writing the workbook
			FileOutputStream out = new FileOutputStream(new File(filename));
			workbook.write(out);

			// Closing file output connections
			out.close();

			// Console message for successful execution of
			// program
			System.out.println(filename + " written successfully on disk.");
		}

		// Catch block to handle exceptions
		catch (Exception e) {

			// Display exceptions along with line number
			// using printStackTrace() method
			e.printStackTrace();
		}
	}
}
