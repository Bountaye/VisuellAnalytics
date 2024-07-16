package visuell_analytics.model.util;

import java.util.Comparator;

import visuell_analytics.model.item.Item;

public class SortById implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		return o1.getId().compareTo(o2.getId());
	}

}
