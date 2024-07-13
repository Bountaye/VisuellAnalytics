package visuell_analytics.model.util;

import java.util.ArrayList;
import java.lang.StrictMath;
import visuell_analytics.model.SKU.Sale;

/**
 * Maintains a list of sales, automatically sorted by date. Index 0 is the
 * oldest sale.
 * 
 * @param <Sale>
 */
public class SalesList<E> {
	/** The list that will stores the elements in array form */
	private ArrayList<Sale> list;
	/** The size of the list */
	private int size;
	private float grossAvg;
	private float timeAvg;
	private float priceAvg;
	private float priceStDev;
	private float quantityAvg;

	/**
	 * The constructor for the array based stack
	 * 
	 * @param capacity the numerical cap on the number of elements in the list
	 */
	public SalesList() {
		list = new ArrayList<Sale>();
		size = 0;
	}

	/**
	 * Automatically sorts sale into place by date.
	 * 
	 * @param sale
	 */
	public void add(Sale sale) {
		if (size == 0) {
			list.add(sale);
			size++;
			return;
		}
		for (int i = size - 1; i >= 0; i--) {
			if (sale.isAfter(list.get(i))) {
				list.add(i + 1, sale);
				size++;
				return;
			}
		}
		list.add(0, sale);
	}

	public void calculate(int days) {
		// Initializing fields
		grossAvg = 0;
		priceAvg = 0;
		priceStDev = 0;
		quantityAvg = 0;
		timeAvg = 0;
		for (int i = 0; i < size - 1; i++) {
			// Adding values to variables
			grossAvg += list.get(i).getGross();
			priceAvg += list.get(i).getPrice();
			quantityAvg += list.get(i).getPrice();
			// Adding time differences
			timeAvg += (list.get(i).getSaleAge() - list.get(i + 1).getSaleAge());
		}
		// Adding last value and averaging variables
		grossAvg = (grossAvg + list.get(size - 1).getGross()) / size;
		priceAvg = (priceAvg + list.get(size - 1).getPrice()) / size;
		quantityAvg = (quantityAvg + list.get(size - 1).getQuantity()) / size;
		// Averaging time
		timeAvg = timeAvg / (size - 1);
		// Adding squares of differences for priceStDev
		for (int i = 0; i < size; i++) {
			priceStDev += square(list.get(i).getPrice() - priceAvg);
		}
		// Dividing by number and squarerooting for priceStDev
		priceStDev = (float) StrictMath.sqrt(priceStDev / size);
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
		return size == 0;
	}

	/**
	 * This method is responsible for a keep a count of how many elements are there
	 * in the list
	 * 
	 * @return the total number of elements in the list
	 */
	public int size() {
		return size;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
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
}
