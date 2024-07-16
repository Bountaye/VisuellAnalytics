package visuell_analytics.model.util;

import java.util.Comparator;

import visuell_analytics.model.item.Item;

public class SortByInventory implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		return Integer.compare(o1.getInventory(), o2.getInventory());
	}

}