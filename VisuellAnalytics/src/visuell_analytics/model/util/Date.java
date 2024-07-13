package visuell_analytics.model.util;

/**
 * Keeps track of date in 3 integers dd/mm/yyyy
 * keeps track of days since date
 * really a POJO for the most part
 */
public class Date {

	private int day;
	private int month;
	private int year;
	/** Number of days since this date*/
	private int daysSince;
	/** Days passed since 1st jan 2015 */
	private static final int today = (int) (System.currentTimeMillis() / 86400000 - 16436);
	private static final int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};

	public Date(int day, int month, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
		setDaysSince(day, month, year);
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the daysSince
	 */
	public int getDaysSince() {
		return daysSince;
	}

	/**
	 * @param day the day to set
	 */
	private void setDay(int day) {
		this.day = day;
	}

	/**
	 * @param month the month to set
	 */
	private void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @param year the year to set
	 */
	private void setYear(int year) {
		this.year = year;
	}

	/**
	 * @param daysSince the daysSince to set
	 */
	private void setDaysSince(int day, int month, int year) {
		int tempYear = year-2015;
		int leapDays = tempYear/4;
		int totalDays = tempYear*365 + monthsToDays(month) + day + leapDays;
		this.daysSince = today - totalDays;
	}

	private int monthsToDays(int month) {
		int val = 0;
		for (int i = 1; i < month; i++) {
			val+= months[i];
		}
		return val;
	}
	
	public boolean isAfter(Date other) {
		return daysSince < other.getDaysSince();
	}

}
