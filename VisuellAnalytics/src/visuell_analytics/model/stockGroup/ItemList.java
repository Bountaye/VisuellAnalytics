package visuell_analytics.model.stockGroup;

import java.util.ArrayList;
import java.util.Collections;

import visuell_analytics.model.item.Item;
import visuell_analytics.model.item.Sale;
import visuell_analytics.model.util.SortById;
import visuell_analytics.model.util.SortByDeathIndex;
import visuell_analytics.model.util.SortByAvgMonthlyRevenue;
import visuell_analytics.model.util.SortByInventory;

/**
 * Master list of all items
 * Maintains item in alphabetical order
 */
public class ItemList {
	private ArrayList<Item> list;
	
	public ItemList() {
		list = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		list.add(item);
	}
	
	public void addSale(Sale sale) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(sale.getItemId())) {
				list.get(i).addSale(sale);
			}
		}
	}
	
	public void evaluateItems() {
		for(int i = 0; i < list.size(); i++) {
			list.get(i).calculateSalesList();
		}
	}
	
	public void sortById() {
		Collections.sort(list, new SortById());
	}
	
	public void sortByDeathIndex() {
		Collections.sort(list, new SortByDeathIndex());
	}
	
	public void sortByAvgMonthlyRevenue() {
		Collections.sort(list, new SortByAvgMonthlyRevenue());
	}
	
	public void sortByInventory() {
		Collections.sort(list, new SortByInventory());
	}
}
