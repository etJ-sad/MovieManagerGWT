package de.unihd.movies.client.filter;

import de.unihd.movies.client.Movie;

/**
 * A filter for {@link Movie}. The filter is valid if the name of a movie
 * contains the filter text.
 * */
public class MovieFilter implements IFilter<Movie> {

	@Override
	public boolean isValid(Movie value, String filter) {
		return value.getName().toLowerCase().contains(filter.toLowerCase());
	}

}
