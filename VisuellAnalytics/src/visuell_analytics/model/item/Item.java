package visuell_analytics.model.item;

import visuell_analytics.model.util.SalesList;

public class Item {
	// TODO implement function that takes in a percent for the cost price to be and
	// returns the probability the item will sell given the cost price needs to be
	// that percentage of the sale based on price average and standard deviation
	// from saleslist using apache normal distribution function
	private String id;
	private int inventory;
	private float costPrice;
	private float deathIndex;
	private SalesList sales = new SalesList();

	public Item(String id, int inventory, float sittingRate) {
		setId(id);
		setInventory(inventory);
		setRate(sittingRate);
	}

	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public float getRate() {
		return costPrice;
	}

	public void setRate(float rate) {
		costPrice = rate;
	}

	public boolean equals(Item other) {
		return other.getId().equals(id);
	}

	public void addSale(Sale sale) {
		sales.add(sale);
	}

	public Sale getLastSale() {
		return sales.getLastSale();
	}

	public float getAvgMonthlyRevenue() {
		return sales.getRevenuePerMonthAvg();
	}

	public void calculateSalesList() {
		sales.calculate();
		// TODO INSERT FORMULA FOR DEATHINDEX HERE
	}

	/**
	 * @return death index modelled by (FORMULA)
	 */
	public float getDeathIndex() {
		return deathIndex;
	}

//	@Override
//	public int compareTo(Item o) {
//		return id.compareTo(o.getId());
//	}

}
