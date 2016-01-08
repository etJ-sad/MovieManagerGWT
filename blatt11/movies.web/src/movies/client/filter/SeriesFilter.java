package movies.client.filter;

import movies.web.model.Series;

public class SeriesFilter implements IFilter<Series> {
	@Override
	public boolean isValid(Series value, String filter) {
		return value.getTitle().toLowerCase().contains(filter.toLowerCase());
	}

}
