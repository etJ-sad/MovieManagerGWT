/**
 * @Version 3.3.99:release
 */

package de.unihd.movies.client;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;

import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import com.google.gwt.user.client.Window;

import com.google.gwt.user.client.ui.*;





public class MovieUI extends Composite {

	MovieManager manager = new MovieManager();
	
	private VerticalPanel panel;
	
	public final static CellTable<Movie> table = new CellTable<Movie>();
	public final TextCell textCell = new TextCell();
	public final CellList<String> cellList = new CellList<String>(textCell);
	public final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
	public final PushButton addButton = new PushButton("Add movie");
    public final PushButton delButton = new PushButton("Del movie");
    public final TextBox tbox = new TextBox();
    public final ListBox lbox = new ListBox();
	
    //(table,10,140);
	@SuppressWarnings("unchecked")
	public void setTable(){

	    cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
	    cellList.setSelectionModel(selectionModel);
	    
	    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
	      public void onSelectionChange(SelectionChangeEvent event) {
	        String selected = selectionModel.getSelectedObject();
	        if (selected != null) {
	          Window.alert("You selected: " + selected);
	        }
	      }
	    });
	    
	    
	    cellList.setRowCount(manager.LANG.size(), true);
	    cellList.setRowData(0, manager.LANG);
	    RootPanel.get().add(cellList,500,500);
		
		  MovieUI.table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		  ListDataProvider<Movie> dataProvider = new ListDataProvider<Movie>();
		    
		   //id 
		    TextColumn<Movie> idColumn = new TextColumn<Movie>() {
			      @Override
			      public String getValue(Movie object) {
			    	  String buffer = String.valueOf(object.getId());
			    	  return buffer;
			      }
			    }; table.addColumn(idColumn, "id");
		    
			//Name
		    TextColumn<Movie> nameColumn = new TextColumn<Movie>() {
		      @Override
		      public String getValue(Movie object) {
		        return object.getName();
		      }
		       }; table.addColumn(nameColumn, "Name");
		    
		    //Time
		    TextColumn<Movie> timeColumn = new TextColumn<Movie>() {
			      @Override
			      public String getValue(Movie object) {
			    	  String buffer = String.valueOf(object.getTime());
			    	  return buffer;
			      }
			    }; table.addColumn(timeColumn, "Time");
			
			//Language
		    TextColumn languageColumn = new TextColumn() {
			      
	

				
				
				@SuppressWarnings("deprecation")
				@Override
				public Object getValue(Object object) {
					return cellList.getDisplayedItem(0);
				}
			    }; table.addColumn(languageColumn, "Language");
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			
			//Description
		    TextColumn<Movie> descriptionColumn = new TextColumn<Movie>() {
			      @Override
			      public String getValue(Movie object) {
			        return object.getDescription();
			      }
			    }; table.addColumn(descriptionColumn, "Description");
		    
		    
		    //Place
		    TextColumn<Movie> placeColumn = new TextColumn<Movie>() {
		      @Override
		      public String getValue(Movie object) {
		        return object.getPlace();
		      }
		    }; table.addColumn(placeColumn, "Place");
		    
		   
			
		    
		    
		    // setSortable
		    idColumn.setSortable(true);
		    nameColumn.setSortable(true);
		    timeColumn.setSortable(true);
		    languageColumn.setSortable(true);
		    descriptionColumn.setSortable(true);
		    placeColumn.setSortable(true);
		    
		    
		    //dataProvider;
			dataProvider.setList(manager.CONTACTS);
			dataProvider.addDataDisplay(table);

		    //Handler
			ListHandler<Movie> columnSortHandler = new ListHandler<Movie>(
					dataProvider.getList()
			);
	
			// Sorts:
			
			// idColumn sort
			columnSortHandler.setComparator(idColumn, new Comparator<Movie>() {
				@Override
				public int compare(Movie m1, Movie m2) {
					if(m1.getId() > m2.getId()) return 1;
					if(m1.getId() < m2.getId()) return -1;
					return 0;
				};
			});
			
			// nameCoulmn sort	
			columnSortHandler.setComparator(nameColumn, new Comparator<Movie>() {
				@Override
				public int compare(Movie m1, Movie m2) {
					return (m1.getName().compareTo(m2.getName()));
				};
			});
			
			// timeColumn sort
			columnSortHandler.setComparator(timeColumn, new Comparator<Movie>() {
				@Override
				public int compare(Movie m1, Movie m2) {
					if(m1.getId() > m2.getId()) return 1;
					if(m1.getId() < m2.getId()) return -1;
					return 0;
				};
			});
			
			// languageColumn sort
			columnSortHandler.setComparator(languageColumn, new Comparator<Movie>() {
				@Override
				public int compare(Movie m1, Movie m2) {
					return (m1.getName().compareTo(m2.getName()));
				};
			});
			
			// descriptionColumn sort
			columnSortHandler.setComparator(descriptionColumn, new Comparator<Movie>() {
				@Override
				public int compare(Movie m1, Movie m2) {
					return (m1.getName().compareTo(m2.getName()));
				};
			});
			
			// placeColumn Sort
			
			columnSortHandler.setComparator(placeColumn, new Comparator<Movie>() {
				@Override
				public int compare(Movie m1, Movie m2) {
					return (m1.getName().compareTo(m2.getName()));
				};
			});
			
		    // add
		    table.addColumnSortHandler(columnSortHandler);
		    table.getColumnSortList().push(idColumn);
		    table.setRowCount(manager.CONTACTS.size(), true);
		    table.setRowData(0, manager.CONTACTS);
		    RootPanel.get().add(table,10,140);
		    
		    

		
	}
	
	//(addButton,10,100); (delButton,100,100);
	public void setButton(){
		
		addButton.setWidth("65px");
	    delButton.setWidth("65px");
	   	    
	    RootPanel.get().add(addButton,10,100);
	    RootPanel.get().add(delButton,100,100);
	    
	}	
	
	//(tbox,210,100);
	public void setTextBox(){
	      RootPanel.get().add(tbox,210,100);
	}
	
	// NULL
	public void setListBox(){
		lbox.addItem("German");
		lbox.addItem("English");
		lbox.addItem("Spanish");
		lbox.addItem("France");
		panel.add(lbox);
		
	}
	
	public void show() {
		initWidget(panel);
		RootPanel.get("content").add(this);
		this.setVisible(true);
		
	}

}

