package movies.client.filter;

import movies.web.model.Season;


public class SeasonsFilter implements IFilter<Season> {
	@Override
	public boolean isValid(Season value, String filter) {
		return value.getTitle().toLowerCase().contains(filter.toLowerCase());
	}


}
