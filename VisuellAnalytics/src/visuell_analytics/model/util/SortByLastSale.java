package visuell_analytics.model.util;

import java.util.Comparator;

import visuell_analytics.model.item.Item;

public class SortByLastSale implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		return Integer.compare(o2.getLastSaleAge(), o1.getLastSaleAge());
	}

}
