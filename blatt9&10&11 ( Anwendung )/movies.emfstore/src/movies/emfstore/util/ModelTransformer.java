package movies.emfstore.util;

import movies.web.model.Episode;
import movies.web.model.Gender;
import movies.web.model.Movie;
import movies.web.model.MovieCategory;
import movies.web.model.Performer;
import movies.web.model.Rating;
import movies.web.model.Season;
import movies.web.model.Series;

public class ModelTransformer {

	public Movie transform(movies.Movie movie) {
		Movie m = new Movie();
		m.setTitle(movie.getTitle());
		m.setTitle_orig(movie.getTitle_orig());
		m.setTime(movie.getTime());

		switch (movie.getCategory()) {
		case ACTION:
			m.setCategory(MovieCategory.Action);
			break;
		case ADVENTURE:
			m.setCategory(MovieCategory.Adventure);
			break;
		case COMEDY:
			m.setCategory(MovieCategory.Comedy);
			break;
		case DOCUMENTATION:
			m.setCategory(MovieCategory.Documentation);
			break;
		case DRAMA:
			m.setCategory(MovieCategory.Drama);
			break;
		case FANTASY:
			m.setCategory(MovieCategory.Fantasy);
			break;
		case HORROR:
			m.setCategory(MovieCategory.Horror);
			break;
		case MUSIC:
			m.setCategory(MovieCategory.Music);
			break;
		case ROMANCE:
			m.setCategory(MovieCategory.Romance);
			break;
		case SCIENCE_FICTION:
			m.setCategory(MovieCategory.ScienceFiction);
			break;
		default:
			m.setCategory(MovieCategory.Thriller);
			break;
		}

		switch (movie.getRating()) {
		case ONE:
			m.setRating(Rating.One);
			break;
		case TWO:
			m.setRating(Rating.Two);
			break;
		case THREE:
			m.setRating(Rating.Three);
			break;
		case FOUR:
			m.setRating(Rating.Four);
			break;
		case FIVE:
			m.setRating(Rating.Five);
			break;
		default:
			m.setRating(Rating.Zero);
			break;
		}

		if(movie.getOverallRating() != null) {
			m.setOverallRating(Integer.parseInt(movie.getOverallRating()));
		}
		m.setLastWatchDate(movie.getLastWatchDate());
		m.setLoaned(movie.isLoaned());
		m.setLoanedUntil(movie.getLoanedUntil());

		for (movies.Performer p : movie.getPerformers()) {
			Performer performer = transform(p);
			m.addPerformer(performer);
			performer.addMovie(m);
		}

		m.setImdbUrl(movie.getImdbUrl());
		m.setOfdbID(movie.getOfdbID());
		m.setLoanable(movie.isLoanable());

		return m;
	}

	public Performer transform(movies.Performer performer) {
		Performer p = new Performer();
		p.setName(performer.getName());

		switch (performer.getGender()) {
		case MALE:
			p.setGender(Gender.Male);
			break;
		case FEMALE:
			p.setGender(Gender.Female);
		}

		switch (performer.getRating()) {
		case ONE:
			p.setRating(Rating.One);
			break;
		case TWO:
			p.setRating(Rating.Two);
			break;
		case THREE:
			p.setRating(Rating.Three);
			break;
		case FOUR:
			p.setRating(Rating.Four);
			break;
		case FIVE:
			p.setRating(Rating.Five);
			break;
		default:
			p.setRating(Rating.Zero);
			break;
		}

		p.setOfdbID(performer.getOfdbID());

		return p;
	}

	public Series transform(movies.Series series) {
		Series s = new Series();
		s.setTitle(series.getTitle());
		s.setStudio(series.getStudio());
		s.setBroadcastedBy(series.getBroadcastedBy());
		s.setReleaseDate(series.getReleaseDate());

		for (movies.Season season_mov : series.getSeasons()) {
			Season season = transform(season_mov);
			s.addSeason(season);
			season.setSeries(s);
		}

		switch (series.getRating()) {
		case ONE:
			s.setRating(Rating.One);
			break;
		case TWO:
			s.setRating(Rating.Two);
			break;
		case THREE:
			s.setRating(Rating.Three);
			break;
		case FOUR:
			s.setRating(Rating.Four);
			break;
		case FIVE:
			s.setRating(Rating.Five);
			break;
		default:
			s.setRating(Rating.Zero);
			break;
		}

		s.setProductionCountry(series.getProductionCountry());
		s.setLoanable(series.isLoanable());
		s.setLoaned(series.isLoaned());
		s.setLoanedUntil(series.getLoanedUntil());

		return s;
	}

	public Season transform(movies.Season season) {
		Season s = new Season();
		s.setTitle(season.getTitle());
		s.setReleaseDate(season.getReleaseDate());

		switch (season.getRating()) {
		case ONE:
			s.setRating(Rating.One);
			break;
		case TWO:
			s.setRating(Rating.Two);
			break;
		case THREE:
			s.setRating(Rating.Three);
			break;
		case FOUR:
			s.setRating(Rating.Four);
			break;
		case FIVE:
			s.setRating(Rating.Five);
			break;
		default:
			s.setRating(Rating.Zero);
			break;
		}

		s.setBroadcastedBy(season.getBroadcastedBy());
		s.setProductionCountry(season.getProductionCountry());
		s.setLoanable(season.isLoanable());
		s.setLoaned(season.isLoaned());
		s.setLoanedUntil(season.getLoanedUntil());
		
		for(movies.Episode ep_mov : season.getEpisodes()) {
			Episode ep = transform(ep_mov);
			s.addEpisode(ep);
			ep.setSeason(s);
		}
		
		return s;
	}

	public Episode transform(movies.Episode episode) {
		Episode e = new Episode();

		e.setTitle(episode.getTitle());
		e.setTitle_orig(episode.getTitle_orig());
		e.setTime(episode.getTime());

		switch (episode.getCategory()) {
		case ACTION:
			e.setCategory(MovieCategory.Action);
			break;
		case ADVENTURE:
			e.setCategory(MovieCategory.Adventure);
			break;
		case COMEDY:
			e.setCategory(MovieCategory.Comedy);
			break;
		case DOCUMENTATION:
			e.setCategory(MovieCategory.Documentation);
			break;
		case DRAMA:
			e.setCategory(MovieCategory.Drama);
			break;
		case FANTASY:
			e.setCategory(MovieCategory.Fantasy);
			break;
		case HORROR:
			e.setCategory(MovieCategory.Horror);
			break;
		case MUSIC:
			e.setCategory(MovieCategory.Music);
			break;
		case ROMANCE:
			e.setCategory(MovieCategory.Romance);
			break;
		case SCIENCE_FICTION:
			e.setCategory(MovieCategory.ScienceFiction);
			break;
		default:
			e.setCategory(MovieCategory.Thriller);
			break;
		}

		switch (episode.getRating()) {
		case ONE:
			e.setRating(Rating.One);
			break;
		case TWO:
			e.setRating(Rating.Two);
			break;
		case THREE:
			e.setRating(Rating.Three);
			break;
		case FOUR:
			e.setRating(Rating.Four);
			break;
		case FIVE:
			e.setRating(Rating.Five);
			break;
		default:
			e.setRating(Rating.Zero);
			break;
		}

		if(episode.getOverallRating() != null) {
			e.setOverallRating(Integer.parseInt(episode.getOverallRating()));
		}
		e.setLastWatchDate(episode.getLastWatchDate());
		e.setLoaned(episode.isLoaned());
		e.setLoanedUntil(episode.getLoanedUntil());

		for (movies.Performer p : episode.getPerformers()) {
			Performer performer = transform(p);
			e.addPerformer(performer);
			performer.addMovie(e);
		}

		e.setImdbUrl(episode.getImdbUrl());
		e.setOfdbID(episode.getOfdbID());
		e.setLoanable(episode.isLoanable());

		e.setBroadcastedBy(episode.getBroadcastedBy());
		e.setProductionCountry(episode.getProductionCountry());
		e.getSeason().addEpisode(e);

		return e;
	}
}
