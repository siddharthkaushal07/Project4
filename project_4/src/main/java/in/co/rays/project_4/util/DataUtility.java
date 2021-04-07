package in.co.rays.project_4.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class DataUtility.
 */
public class DataUtility {

	/** Application Date Format. */
	public static final String APP_DATE_FORMAT = "MM/dd/yyyy";

	/** The Constant APP_TIME_FORMAT. */
	public static final String APP_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";
	public static final String SEARCH_DATE_FORMAT = "yyyy-MM-dd";

	/** Date formatter. */
	public static final SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMAT);

	/** The Constant timeFormatter. */
	private static final SimpleDateFormat timeFormatter = new SimpleDateFormat(APP_TIME_FORMAT);
	private static final SimpleDateFormat searchFormatter = new SimpleDateFormat(SEARCH_DATE_FORMAT);

	/**
	 * Trims and trailing and leading spaces of a String.
	 *
	 * @param val
	 *            the val
	 * @return the string
	 */
	public static String getString(String val) {
		if (DataValidator.isNotNull(val)) {
			return val.trim();
		} else {
			return val;
		}
	}

	/**
	 * Converts and Object to String.
	 *
	 * @param val
	 *            the val
	 * @return the string data
	 */
	public static String getStringData(Object val) {
		if (val != null) {
			return val.toString();
		} else {
			return "";
		}
	}

	/**
	 * Converts String into Integer.
	 *
	 * @param val
	 *            the val
	 * @return the int
	 */
	public static int getInt(String val) {
		if (DataValidator.isInteger(val)) {
			return Integer.parseInt(val);
		} else {
			return 0;
		}
	}

	/**
	 * Converts String into Long.
	 *
	 * @param val
	 *            the val
	 * @return the long
	 */
	public static long getLong(String val) {
		if (DataValidator.isLong(val)) {
			return Long.parseLong(val);
		} else {
			return 0;
		}
	}

	/**
	 * Converts String into Date.
	 *
	 * @param val
	 *            the val
	 * @return the date
	 */
	public static Date getDate(String val) {
		Date date=null;
		if(DataValidator.isNotNull(val))
		{
		try {
			date=formatter.parse(val);   //parse always gives value in date format
			
		} catch (ParseException e) {
		
			e.printStackTrace();
		}	 
		}
		return date;
	}
		/*Date date = null;
		try {
			date = formatter.parse(val);
		} catch (Exception e) {

		}
		return date;*/
	

	/**
	 * Converts Date into String.
	 *
	 * @param date
	 *            the date
	 * @return the date string
	 */
	public static String getDateString(Date date) {
		try {
			return formatter.format(date);
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * Gets date after n number of days.
	 *
	 * @param date
	 *            the date
	 * @param day
	 *            the day
	 * @return the date
	 */
	public static Date getDate(Date date, int day) {
		return null;
	}

	/**
	 * Converts String into Time.
	 *
	 * @param val
	 *            the val
	 * @return the timestamp
	 */
	public static Timestamp getTimestamp(String val) {

		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp((timeFormatter.parse(val)).getTime());
		} catch (Exception e) {
			return null;
		}
		return timeStamp;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @param l
	 *            the l
	 * @return the timestamp
	 */
	public static Timestamp getTimestamp(long l) {

		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp(l);
		} catch (Exception e) {
			return null;
		}
		return timeStamp;
	}

	/**
	 * Gets the current timestamp.
	 *
	 * @return the current timestamp
	 */
	public static Timestamp getCurrentTimestamp() {
		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp(new Date().getTime());
		} catch (Exception e) {
		}
		return timeStamp;

	}

	/**
	 * Gets the timestamp.
	 *
	 * @param tm
	 *            the tm
	 * @return the timestamp
	 */
	public static long getTimestamp(Timestamp tm) {
		try {
			return tm.getTime();
		} catch (Exception e) {
			return 0;
		}
	}

	public static Date getSearchDate(String val) {
		Date date = null;
		try {
			date = searchFormatter.parse(val);
		} catch (Exception e) {

		}
		return date; 
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		System.out.println(getInt("124"));
	}

}
