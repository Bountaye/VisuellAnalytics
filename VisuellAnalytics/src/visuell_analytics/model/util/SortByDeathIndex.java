package visuell_analytics.model.util;

import java.util.Comparator;

import visuell_analytics.model.item.Item;

public class SortByDeathIndex implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		return Float.compare(o1.getDeathIndex(), o2.getDeathIndex());
	}

}