package de.uhd.bookexample.client.filter;

import de.uhd.bookexample.client.Movie;

/**
 * A filter for {@link Movie}. The filter is valid if the title of a book
 * contains the filter text.
 * */
public class MovieFilter implements IFilter<Movie> {

	@Override
	public boolean isValid(Movie value, String filter) {
		return value.getName().toLowerCase().contains(filter.toLowerCase());
	}

}
