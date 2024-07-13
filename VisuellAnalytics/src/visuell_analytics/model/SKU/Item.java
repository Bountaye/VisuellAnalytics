package visuell_analytics.model.SKU;

import visuell_analytics.model.util.SalesList;

public class Item {
	private String id;
	private int inventory;
	private float costPrice;
	private SalesList<Sale> sales = new SalesList<Sale>();

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
	
	/** TODO DECIDE FORMULA
	 * 
	 * @return death index modelled by (FORMULA)
	 */
	public float getDeathIndex() {
		return 0;
	}
}
