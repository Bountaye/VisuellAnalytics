package visuell_analytics.model.SKU;

//TODO implement statsArray and refactor java stack to custom statsArray
import java.util.Stack;

public class SKU {
	private String id;
	private int inventory;
	private float sittingRate;
	private Stack<Sale> sales = new Stack<Sale>();

	public SKU(String id, int inventory, float sittingRate) {
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
		return sittingRate;
	}

	public void setRate(float rate) {
		sittingRate = rate;
	}

	public boolean equals(SKU other) {
		return other.getId().equals(id);
	}

	public void addSale(Sale sale) {
		sales.push(sale);
	}
	
	public Sale getLastSale() {
		return sales.peek();
	}
	
	/** TODO DECIDE FORMULA
	 * 
	 * @return death index modelled by (FORMULA)
	 */
	public float getDeathIndex() {
		return 0;
	}
}
