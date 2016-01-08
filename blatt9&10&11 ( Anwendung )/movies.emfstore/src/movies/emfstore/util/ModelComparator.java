package movies.emfstore.util;

import movies.web.model.Movie;

public class ModelComparator {

	public static boolean compare(Movie m1, movies.Movie m2) {

		if (!m1.getTitle().equalsIgnoreCase(m2.getTitle())) {
			return false;
		}

		if (m1.getTime() != m2.getTime()) {
			return false;
		}

		if (m1.getCategory().ordinal() != m2.getCategory().ordinal()) {
			return false;
		}

		if (m1.getRating().ordinal() != m2.getRating().ordinal()) {
			return false;
		}

		if (m1.getPerformers() != null) {
			if (m2.getPerformers() != null) {
				if (m1.getPerformers().size() != m2.getPerformers().size()) {
					return false;
				}
			}
		}

		return true;
	}

}
