package movies.client.filter;

import movies.web.model.Episode;

public class EpisodesFilter implements IFilter<Episode> {
	@Override
	public boolean isValid(Episode value, String filter) {
		return value.getTitle().toLowerCase().contains(filter.toLowerCase());
	}

}
