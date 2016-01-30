package de.unihd.movies.client.filter;

/**
 * Interface to implement custom filter used for a
 * {@link FilteredListDataProvider}.
 * 
 * @author Marcus Seiler
 * */
public interface IFilter<T> {

	/**
	 * Should return <code>true</code> if and only if parts of the given value
	 * or the value itself contains the filter text.
	 * 
	 * @param value
	 *            The value on which the filter is applied.
	 * @param filter
	 *            The text to filter with.
	 * 
	 * @return <code>True</code> if and only if parts of the given value or the
	 *         value itself contains the filter text, <code>false</code>
	 *         otherwise.
	 * */
	boolean isValid(T value, String filter);

}
