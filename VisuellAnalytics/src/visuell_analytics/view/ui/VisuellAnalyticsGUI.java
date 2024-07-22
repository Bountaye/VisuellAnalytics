package visuell_analytics.view.ui;

import visuell_analytics.model.io.DataReader;
import visuell_analytics.model.io.DataWriter;
import visuell_analytics.model.stockGroup.ItemList;

public class VisuellAnalyticsGUI {

	public static void main(String[] args) {
		ItemList all = DataReader
				.readStkGrpSum("C:\\Users\\nisha\\git\\VisuellAnalytics\\VisuellAnalytics\\data\\StkGrpSum.xlsx");
		all = DataReader.readDayBook("C:\\Users\\nisha\\git\\VisuellAnalytics\\VisuellAnalytics\\data\\DayBook.xlsx",
				all);
		DataWriter.exportData(all,
				"C:\\Users\\nisha\\git\\VisuellAnalytics\\VisuellAnalytics\\data\\ProcessedData.xlsx");
	}

}
