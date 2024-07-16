package visuell_analytics.model.item;

import visuell_analytics.model.util.Date;

/**
 * One sale event, maintains date, quantity, price (and item?)
 */
public class Sale {
	private String itemId;
	private Date date;
	private int quantity;
	private float price;
	private float gross;
	private int saleAge;
//	private Sale current;

	public Sale(String itemId, Date date, int quantity, float price) {
		setItemId(itemId);
		setDate(date);
		setQuantity(quantity);
		setPrice(price);
		this.gross = price * quantity;
//		current = new Sale();
//		current.setItem(item);
//		current.setDate(date);
//		current.setQuantity(quantity);
//		current.setPrice(price);
//		current.gross = price * quantity;
//		item.addSale(current);
	}
	public Sale() {
		
	}

	//TODO is this needed?
//	public void addToItem(Item item) {
//		item.addSale(this);
//	}
	
	/**
	 * @return the item
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	
	public float getGross() {
		return gross;
	}

	/**
	 * @param item the item to set
	 */
	private void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * @param date the date to set
	 */
	private void setDate(Date date) {
		this.date = date;
		this.saleAge = date.getDaysSince();
	}

	/**
	 * @param quantity the quantity to set
	 */
	private void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @param price the price to set
	 */
	private void setPrice(float price) {
		this.price = price;
	}

	/**
	 * Returns the number of days since sale took place
	 * 
	 * @return
	 */
	public int getSaleAge() {
		return saleAge;
	}

	public boolean isAfter(Sale other) {
		return saleAge < other.getSaleAge();
	}
}
