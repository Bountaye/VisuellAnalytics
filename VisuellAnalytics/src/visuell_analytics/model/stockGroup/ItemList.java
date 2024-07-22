package visuell_analytics.model.stockGroup;

import java.util.ArrayList;
import java.util.Collections;

import visuell_analytics.model.item.Item;
import visuell_analytics.model.item.Sale;
import visuell_analytics.model.util.SortById;
import visuell_analytics.model.util.SortByDeathIndex;
import visuell_analytics.model.util.SortByAvgMonthlyRevenue;
import visuell_analytics.model.util.SortByAvgMonthlyQuantity;
import visuell_analytics.model.util.SortByInventory;
import visuell_analytics.model.util.SortByLastSale;
import visuell_analytics.model.util.SortByPrice;

/**
 * Master list of all items
 */
// TODO Make iterable, implement in writer
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
	
	public Item getItem(int idx) {
		return list.get(idx);
	}
	
	public int size() {
		return list.size();
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
	
	public void sortByAvgMonthlyQuantity() {
		Collections.sort(list, new SortByAvgMonthlyQuantity());
	}
	
	public void sortByLastSale() {
		Collections.sort(list, new SortByLastSale());
	}
	
	public void sortByPrice() {
		Collections.sort(list, new SortByPrice());
	}
}
