package de.unihd.movies.client.filter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.Range;

/**
 * This class is an extension of the default {@link ListDataProvider}. Besides
 * the functionality provided by a {@link ListDataProvider}, this class features
 * filtering support.
 * 
 * @author Marcus Seiler
 * */
public class FilteredListDataProvider<T> extends ListDataProvider<T> {

	/**
	 * The filter string
	 * */
	private String filterString = "";

	/**
	 * The filter to use
	 * */
	public final IFilter<T> filter;

	/**
	 * Creates a {@link FilteredListDataProvider} with the given {@link IFilter}
	 * 
	 * @param filter
	 *            The filter to use.
	 * */
	public FilteredListDataProvider(IFilter<T> filter) {
		super();
		this.filter = filter;
	}

	/**
	 * Sets the filter text.
	 * 
	 * @param filter
	 *            The text to filter.
	 * */
	public void setFilter(String filter) {
		this.filterString = filter;
		refresh();
	}

	/**
	 * Resets the current filter text.
	 * */
	public void resetFilter() {
		filterString = null;
		refresh();
	}

	@Override
	protected void updateRowData(int start, List<T> values) {
		if (filterString.isEmpty() || filter == null) {
			// we don't need to filter, so call base class
			super.updateRowData(start, values);
		} else {
			int end = start + values.size();
			if (getDataDisplays().size() == 1) {
				HasData<T> data = getDataDisplays().iterator().next();
				Range range = data.getVisibleRange();
				int curStart = range.getStart();
				int curLength = range.getLength();
				int curEnd = curStart + curLength;
				if (start == curStart || (curStart < end && curEnd > start)) {
					int realStart = curStart < start ? start : curStart;
					int realEnd = curEnd > end ? end : curEnd;
					int realLength = realEnd - realStart;
					List<T> resulted = new ArrayList<T>(realLength);
					for (int i = realStart - start; i < realStart - start
							+ realLength; i++) {
						if (filter.isValid((T) values.get(i), filterString)) {
							resulted.add((T) values.get(i));
						}
					}
					data.setRowData(realStart, resulted);
					data.setRowCount(resulted.size());
				}
			}
		}
	}

}
