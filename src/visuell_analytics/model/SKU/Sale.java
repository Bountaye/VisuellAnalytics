package visuell_analytics.model.SKU;

import visuell_analytics.model.util.Date;

/**
 * One sale event, maintains date, quantity, price (and item?)
 */
public class Sale {
	// TODO add sale to SKU when creating sale. does sale need an SKU field?
	private SKU item;
	private Date date;
	private int quantity;
	private float price;
	private float gross;
	private int saleAge;

	public Sale(SKU item, Date date, int quantity, float price) {
		setItem(item);
		setDate(date);
		setQuantity(quantity);
		setPrice(price);
		this.gross = price * quantity;
	}

	/**
	 * @return the item
	 */
	public SKU getItem() {
		return item;
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
	private void setItem(SKU item) {
		this.item = item;
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
