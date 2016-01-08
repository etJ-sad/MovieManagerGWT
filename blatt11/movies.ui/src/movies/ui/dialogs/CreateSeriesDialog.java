package movies.ui.dialogs;

import movies.Episode;
import movies.MoviesFactory;
import movies.Season;
import movies.Series;
import movies.ui.util.MovieUtil;

import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class CreateSeriesDialog extends TitleAreaDialog{
	
	private Spinner spinner;
	
	private Spinner spinner_1;
	
	private Text seriesName;
	
	public CreateSeriesDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}
	
	protected Control createDialogArea(Composite parent) {
		 parent = new Composite(parent, SWT.NONE); 
		 
		 
		seriesName = new Text(parent, SWT.BORDER);
		seriesName.setBounds(232, 41, 76, 21);
		
		Label lblName = new Label(parent, SWT.NONE);
		lblName.setBounds(34, 44, 55, 15);
		lblName.setText("name:");
		
		Label lblNumberOfSeasons = new Label(parent, SWT.NONE);
		lblNumberOfSeasons.setBounds(34, 76, 137, 15);
		lblNumberOfSeasons.setText("number of Seasons:");
		
		spinner = new Spinner(parent, SWT.BORDER);
		spinner.setBounds(232, 68, 47, 22);
		
		Label lblNumberOfEpisodes = new Label(parent, SWT.NONE);
		lblNumberOfEpisodes.setBounds(34, 106, 176, 15);
		lblNumberOfEpisodes.setText("number of Episodes per Season:");
		
		spinner_1 = new Spinner(parent, SWT.BORDER);
		spinner_1.setBounds(232, 99, 47, 22);
		
		
		
		
		return parent; 
		
	}
	@Override
	protected void okPressed() {
		this.setReturnCode(Window.OK);
		createSeries();
		super.okPressed();
	}

	private void createSeries() {
		new EMFStoreCommand(){
			protected void doRun(){
				Series newSeries = MoviesFactory.eINSTANCE.createSeries();
				newSeries.setTitle(seriesName.getText());
				for(int i =1; i < spinner.getSelection()+1; i++){
					Season newSeason = MoviesFactory.eINSTANCE.createSeason();
					newSeason.setTitle("S" + i);
					MovieUtil.getActiveProject().addModelElement(newSeason);
					for(int a = 1; a < spinner_1.getSelection()+1; a++){
						Episode newEpisode = MoviesFactory.eINSTANCE.createEpisode();
						newSeason.getEpisodes().add(newEpisode);
						newEpisode.setTitle("S"+i+"E"+a);
						MovieUtil.getActiveProject().addModelElement(newEpisode);
					}
					newSeries.getSeasons().add(newSeason);
				}
				MovieUtil.getActiveProject().addModelElement(newSeries);
			}
		}.doRun();
		
	}
	

}
