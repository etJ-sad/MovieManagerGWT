package movies.emfstore.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import movies.emfstore.util.EMFStoreTransaction;
import movies.emfstore.util.ModelComparator;
import movies.emfstore.util.ModelTransformer;
import movies.web.model.Episode;
import movies.web.model.Movie;
import movies.web.model.Season;
import movies.web.model.Series;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.Workspace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreClientUtil;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;

public class EMFStoreClientHandler implements Runnable {

	protected Socket clientSocket = null;

	private Usersession usersession;
	private Workspace workspace;
	private List<ProjectInfo> remoteProjectList;
	private ProjectSpace projectSpace;
	private Project project;

	public EMFStoreClientHandler(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		try {
			ObjectInputStream inStream = new ObjectInputStream(
					clientSocket.getInputStream());
			ObjectOutputStream outStream = new ObjectOutputStream(
					clientSocket.getOutputStream());

			EMFStoreTransaction trx = (EMFStoreTransaction) inStream
					.readObject();

			usersession = EMFStoreClientUtil.createUsersession("super",
					"super", "localhost", 8080);
			workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
			remoteProjectList = workspace.getRemoteProjectList(usersession);

			if (remoteProjectList.isEmpty()) {
				workspace.createRemoteProject(usersession, "Movies-Test",
						"Test project for movies");
			}

			projectSpace = workspace.checkout(usersession,
					remoteProjectList.get(0));
			project = projectSpace.getProject();

			Object receivedObject = trx.getObjectToSend();

			switch (trx.getRequestToPerform()) {
			case GET_MOVIES:
				outStream.writeObject(getAllMovies());
				break;
			case LOAN_MOVIE:
				outStream.writeObject(handleLoanMovie(receivedObject));
				break;
			case RETURN_MOVIE:
				outStream.writeObject(handleReturnMovie(receivedObject));
				break;
			case GET_EPISODES:
				outStream.writeObject(getEpisodesFromSeason(receivedObject));
				break;
			case LOAN_EPISODE:
				outStream.writeObject(handleLoanEpisode(receivedObject));
				break;
			case RETURN_EPISODE:
				outStream.writeObject(handleReturnEpisode(receivedObject));
				break;
			case GET_SEASONS:
				outStream.writeObject(getSeasonsFromSeries(receivedObject));
				break;
			case LOAN_SEASON:
				outStream.writeObject(handleLoanSeason(receivedObject));
				break;
			case RETURN_SEASON:
				outStream.writeObject(handleReturnSeason(receivedObject));
				break;
			case GET_SERIES:
				outStream.writeObject(getAllSeries());
				break;
			case LOAN_SERIES:
				outStream.writeObject(handleLoanSeries(receivedObject));
				break;
			case RETURN_SERIES:
				outStream.writeObject(handleReturnSeries(receivedObject));
				break;
			}

			// CleanUp
			inStream.close();
			outStream.close();

			workspace.deleteProjectSpace(projectSpace);
			usersession.logout();

		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		} catch (EmfStoreException e) {
			e.printStackTrace();
		}
	}

	private Boolean handleReturnSeries(Object object) {
		if (!(object instanceof Series)) {
			return new Boolean(false);
		}

		Series seriesToReturn = (Series) object;

		List<EObject> modelElements = getAllModelElements();
		for (EObject element : modelElements) {
			if (!(element instanceof movies.Series)) {
				continue;
			}
			movies.Series series = (movies.Series) element;
			if (series.getTitle().equalsIgnoreCase(seriesToReturn.getTitle())) {
				if (series.getBroadcastedBy().equalsIgnoreCase(
						seriesToReturn.getBroadcastedBy())) {
					if (series.getStudio().equalsIgnoreCase(
							seriesToReturn.getStudio())) {
						if (series.getProductionCountry().equalsIgnoreCase(
								seriesToReturn.getProductionCountry())) {
							if (series.isLoaned()) {
								series.setLoaned(false);
								series.setLoanedUntil(null);
								project.addModelElement(series);
								try {
									projectSpace.commit();
								} catch (EmfStoreException e) {
									e.printStackTrace();
									return new Boolean(false);
								}
								break;
							} else {
								return new Boolean(false);
							}
						}
					}
				}
			}
		}

		return new Boolean(true);
	}

	private Boolean handleLoanSeries(Object object) {
		if (!(object instanceof Series)) {
			return new Boolean(false);
		}

		Series seriesToLoan = (Series) object;

		List<EObject> modelElements = getAllModelElements();
		for (EObject element : modelElements) {
			if (!(element instanceof movies.Series)) {
				continue;
			}

			movies.Series series = (movies.Series) element;

			if (series.getTitle().equalsIgnoreCase(seriesToLoan.getTitle())) {
				if (series.getBroadcastedBy().equalsIgnoreCase(
						seriesToLoan.getBroadcastedBy())) {
					if (series.getStudio().equalsIgnoreCase(
							seriesToLoan.getStudio())) {
						if (series.getProductionCountry().equalsIgnoreCase(
								seriesToLoan.getProductionCountry())) {
							if (!series.isLoaned()) {
								series.setLoaned(true);
								series.setLoanedUntil(seriesToLoan
										.getLoanedUntil());
								project.addModelElement(series);
								try {
									projectSpace.commit();
								} catch (EmfStoreException e) {
									e.printStackTrace();
									return new Boolean(false);
								}
								break;
							} else {
								return new Boolean(false);
							}
						}
					}
				}
			}
		}

		return new Boolean(true);
	}

	private Boolean handleReturnEpisode(Object object) {
		if (!(object instanceof Episode)) {
			return new Boolean(false);
		}

		Episode episodeToReturn = (Episode) object;

		List<EObject> modelElements = getAllModelElements();
		for (EObject element : modelElements) {
			if (!(element instanceof movies.Episode)) {
				continue;
			}
			movies.Episode episode = (movies.Episode) element;
			if (episode.getTitle().equalsIgnoreCase(episodeToReturn.getTitle())) {
				if (episode.getTime() == episodeToReturn.getTime()) {
					if (episode.isLoaned()) {
						episode.setLoaned(false);
						episode.setLoanedUntil(null);
						if (episode.getSeason() != null) {
							if (episode.getSeason().getSeries() != null) {
								project.addModelElement(episode.getSeason()
										.getSeries());
							} else {
								project.addModelElement(episode.getSeason());
							}
						} else {
							project.addModelElement(episode);
						}
						try {
							projectSpace.commit();
						} catch (EmfStoreException e) {
							e.printStackTrace();
							return new Boolean(false);
						}
						break;
					} else {
						return new Boolean(false);
					}
				}
			}
		}

		return new Boolean(true);
	}

	private Boolean handleLoanEpisode(Object object) {
		if (!(object instanceof Episode)) {
			return new Boolean(false);
		}

		Episode episodeToLoan = (Episode) object;

		List<EObject> modelElements = getAllModelElements();
		for (EObject element : modelElements) {
			if (!(element instanceof movies.Episode)) {
				continue;
			}

			movies.Episode episode = (movies.Episode) element;

			if (episode.getTitle().equalsIgnoreCase(episodeToLoan.getTitle())) {
				if (episode.getTime() == episodeToLoan.getTime()) {
					if (!episode.isLoaned()) {
						episode.setLoaned(true);
						episode.setLoanedUntil(episodeToLoan.getLoanedUntil());
						if (episode.getSeason() != null) {
							if (episode.getSeason().getSeries() != null) {
								project.addModelElement(episode.getSeason()
										.getSeries());
							} else {
								project.addModelElement(episode.getSeason());
							}
						} else {
							project.addModelElement(episode);
						}
						try {
							projectSpace.commit();
						} catch (EmfStoreException e) {
							e.printStackTrace();
							return new Boolean(false);
						}
						break;
					} else {
						return new Boolean(false);
					}
				}
			}
		}

		return new Boolean(true);
	}

	private List<Season> getSeasonsFromSeries(Object object) {
		if (!(object instanceof Series)) {
			return new ArrayList<Season>();
		}

		Series series = (Series) object;
		return series.getSeasons();
	}

	private Boolean handleReturnSeason(Object object) {
		if (!(object instanceof Season)) {
			return new Boolean(false);
		}

		Season seasonToReturn = (Season) object;

		List<EObject> modelElements = getAllModelElements();
		for (EObject element : modelElements) {
			if (!(element instanceof movies.Season)) {
				continue;
			}
			movies.Season season = (movies.Season) element;
			if (season.getTitle().equalsIgnoreCase(seasonToReturn.getTitle())) {
				if (season.getBroadcastedBy().equalsIgnoreCase(
						seasonToReturn.getBroadcastedBy())) {
					if (season.getProductionCountry().equalsIgnoreCase(
							season.getProductionCountry())) {
						if (season.getRating().ordinal() == seasonToReturn
								.getRating().ordinal()) {
							if (season.isLoaned()) {
								season.setLoaned(false);
								season.setLoanedUntil(null);
								if (season.getSeries() != null) {
									project.addModelElement(season.getSeries());
								} else {
									project.addModelElement(season);
								}
								try {
									projectSpace.commit();
								} catch (EmfStoreException e) {
									e.printStackTrace();
									return new Boolean(false);
								}
								break;
							} else {
								return new Boolean(false);
							}
						}
					}
				}
			}
		}

		return new Boolean(true);
	}

	private Boolean handleLoanSeason(Object object) {
		if (!(object instanceof Season)) {
			return new Boolean(false);
		}

		Season seasonToLoan = (Season) object;

		List<EObject> modelElements = getAllModelElements();
		for (EObject element : modelElements) {
			if (!(element instanceof movies.Season)) {
				continue;
			}

			movies.Season season = (movies.Season) element;

			if (season.getTitle().equalsIgnoreCase(seasonToLoan.getTitle())) {
				if (season.getBroadcastedBy().equalsIgnoreCase(
						seasonToLoan.getBroadcastedBy())) {
					if (season.getProductionCountry().equalsIgnoreCase(
							season.getProductionCountry())) {
						if (season.getRating().ordinal() == seasonToLoan
								.getRating().ordinal()) {
							if (!season.isLoaned()) {
								season.setLoaned(true);
								season.setLoanedUntil(seasonToLoan
										.getLoanedUntil());
								if (season.getSeries() != null) {
									project.addModelElement(season.getSeries());
								} else {
									project.addModelElement(season);
								}
								try {
									projectSpace.commit();
								} catch (EmfStoreException e) {
									e.printStackTrace();
									return new Boolean(false);
								}
								break;
							} else {
								return new Boolean(false);
							}
						}
					}
				}
			}
		}

		return new Boolean(true);
	}

	private List<Episode> getEpisodesFromSeason(Object object) {
		if (!(object instanceof Season)) {
			return new ArrayList<Episode>();
		}

		Season season = (Season) object;
		return season.getEpisodes();
	}

	private Boolean handleReturnMovie(Object object) {
		if (!(object instanceof Movie)) {
			return new Boolean(false);
		}

		Movie movieToReturn = (Movie) object;

		List<EObject> modelElements = getAllModelElements();
		for (EObject element : modelElements) {
			if (!(element instanceof movies.Movie)) {
				continue;
			}
			movies.Movie movie = (movies.Movie) element;
			if (ModelComparator.compare(movieToReturn, movie)) {
				if (movie.isLoaned()) {
					movie.setLoaned(false);
					movie.setLoanedUntil(null);
					project.addModelElement(movie);
					try {
						projectSpace.commit();
					} catch (EmfStoreException e) {
						e.printStackTrace();
						return new Boolean(false);
					}
					break;
				} else {
					return new Boolean(false);
				}
			}
		}

		return new Boolean(true);
	}

	private Boolean handleLoanMovie(Object object) {
		if (!(object instanceof Movie)) {
			return new Boolean(false);
		}

		Movie movieToLoan = (Movie) object;

		List<EObject> modelElements = getAllModelElements();
		for (EObject element : modelElements) {
			if (!(element instanceof movies.Movie)) {
				continue;
			}

			movies.Movie movie = (movies.Movie) element;

			if (ModelComparator.compare(movieToLoan, movie)) {
				if (!movie.isLoaned()) {
					movie.setLoaned(true);
					movie.setLoanedUntil(movieToLoan.getLoanedUntil());
					project.addModelElement(movie);
					try {
						projectSpace.commit();
					} catch (EmfStoreException e) {
						e.printStackTrace();
						return new Boolean(false);
					}
					break;
				} else {
					return new Boolean(false);
				}
			}
		}

		return new Boolean(true);
	}

	private List<Movie> getAllMovies() {
		List<Movie> result = new ArrayList<Movie>();
		List<EObject> modelElements = getAllModelElements();
		for (EObject o : modelElements) {
			if (o instanceof movies.Movie) {
				if (!(o instanceof movies.Episode)) {
					result.add(new ModelTransformer()
							.transform((movies.Movie) o));
				}
			}
		}
		return result;
	}

	private List<Series> getAllSeries() {
		List<Series> result = new ArrayList<Series>();
		List<EObject> modelElements = getAllModelElements();
		for (EObject o : modelElements) {
			if (o instanceof movies.Series) {
				result.add(new ModelTransformer().transform((movies.Series) o));
			}
		}
		return result;
	}

	private List<EObject> getAllModelElements() {
		List<EObject> allModelElements = new ArrayList<EObject>();
		TreeIterator<EObject> ti = project.eAllContents();
		while (ti.hasNext()) {
			allModelElements.add(ti.next());
		}
		return allModelElements;
	}

}
