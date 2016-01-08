package movies.client.filter;

import movies.web.model.Movie;

public class MovieFilter implements IFilter<Movie> {
	@Override
	public boolean isValid(Movie value, String filter) {
		return value.getTitle().toLowerCase().contains(filter.toLowerCase());
	}

}
