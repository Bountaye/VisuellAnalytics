package visuell_analytics.model.util;

import java.util.ArrayList;

import visuell_analytics.model.item.Sale;

import java.lang.StrictMath;

/**
 * Maintains a list of sales, automatically sorted by date. Index 0 is the
 * oldest sale.
 * 
 * @param <Sale>
 */
public class SalesList {
	/** The list that will stores the elements in array form */
	private ArrayList<Sale> list;
	/** The size of the list */
	private float grossAvg;
	private float timeAvg;
	private float priceAvg;
	private float priceStDev;
	private float quantityAvg;
	private float revenuePerMonthAvg;
	private float quantityPerMonthAvg;

	public SalesList() {
		list = new ArrayList<Sale>();
	}

	/**
	 * Automatically sorts sale into place by date.
	 * 
	 * @param sale
	 */
	public void add(Sale sale) {
		if (list.size() == 0) {
			list.add(sale);
			return;
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			if (sale.isAfter(list.get(i))) {
				list.add(i + 1, sale);
				return;
			}
		}
		list.add(0, sale);
	}

	public void calculate() {
		// Initializing fields
		grossAvg = 0;
		priceAvg = 0;
		priceStDev = 0;
		quantityAvg = 0;
		timeAvg = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			// Adding values to variables
			grossAvg += list.get(i).getGross();
			priceAvg += list.get(i).getPrice();
			quantityAvg += list.get(i).getPrice();
			// Adding time differences
			timeAvg += (list.get(i).getSaleAge() - list.get(i + 1).getSaleAge());
		}
		// Adding last value and averaging variables
		grossAvg = (grossAvg + list.get(list.size() - 1).getPrice()) / list.size();
		quantityAvg = (quantityAvg + list.get(list.size() - 1).getQuantity()) / list.size();
		// Averaging time
		timeAvg = timeAvg / (list.size() - 1);
		// Adding squares of differences for priceStDev
		for (int i = 0; i < list.size(); i++) {
			priceStDev += square(list.get(i).getPrice() - priceAvg);
		}
		// Dividing by number and squarerooting for priceStDev
		priceStDev = (float) StrictMath.sqrt(priceStDev / list.size());
		// Multiplying gross avg into sales per month
		revenuePerMonthAvg = (float) (grossAvg * 30.5/timeAvg);
		// Multiplying quantity avg into sales per month
		quantityPerMonthAvg = (float) (quantityAvg * 30.5/timeAvg);
	}

	private float square(float input) {
		return input * input;
	}

	/**
	 * Checks whether the list is empty or not
	 * 
	 * @return the boolean answer of whether the list is empty or not
	 */
	public boolean isEmpty() {
		return list.size() == 0;
	}

	/**
	 * This method is responsible for a keep a count of how many elements are there
	 * in the list
	 * 
	 * @return the total number of elements in the list
	 */
	public int size() {
		return list.size();
	}

	/**
	 * @return the grossAvg
	 */
	public float getGrossAvg() {
		return grossAvg;
	}

	/**
	 * @return the timeAvg
	 */
	public float getTimeAvg() {
		return timeAvg;
	}

	/**
	 * @return the priceAvg
	 */
	public float getPriceAvg() {
		return priceAvg;
	}

	/**
	 * @return the priceStDev
	 */
	public float getPriceStDev() {
		return priceStDev;
	}

	/**
	 * @return the quantityAvg
	 */
	public float getQuantityAvg() {
		return quantityAvg;
	}
	
	public Sale getLastSale() {
		return list.get(list.size()-1);
	}
	
	public int getLastSaleAge() {
		return list.get(list.size()-1).getSaleAge();
	}
	
	public Sale getSale(int idx) {
		return list.get(idx);
	}

	public float getRevenuePerMonthAvg() {
		return revenuePerMonthAvg;
	}

	public float getQuantityPerMonthAvg() {
		return quantityPerMonthAvg;
	}
}
