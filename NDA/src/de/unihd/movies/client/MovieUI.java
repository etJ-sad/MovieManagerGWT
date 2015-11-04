/**
 * @Version 3.3.99:release
 */

package de.unihd.movies.client;


import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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

    public final TextBox tbox = new TextBox();
    public final ListBox lbox = new ListBox();
    
    int ids = manager.CONTACTS.size();
    
    
    // --
    
    //(table,10,140);
	public void setTable(){
		
		final CellTable<Movie> table = new CellTable<Movie>();
	    final ListDataProvider<Movie> dataProvider = new ListDataProvider<Movie>(getList());
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
	    TextColumn<Movie> languageColumn = new TextColumn<Movie>() {
		      @Override
		      public String getValue(Movie object) {
		        return object.getLanguage();
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
	    
	    
	    //-

	    table.setRowCount(getList().size());

	    dataProvider.addDataDisplay(table);

	    final SingleSelectionModel<Movie> selectionModel = new SingleSelectionModel<Movie>();
	    table.setSelectionModel(selectionModel);

	    Button btn = new Button("delete entry");
	    btn.addClickHandler(new ClickHandler() {

	        @Override
	        public void onClick(ClickEvent event) {
	            Movie selected = selectionModel.getSelectedObject();
	            if (selected != null) {
	                dataProvider.getList().remove(selected);
	            }
	        }
	    });

	    RootPanel.get().add(table);
	    RootPanel.get().add(btn);

	}

	private LinkedList<Movie> getList() {
	    LinkedList<Movie> list = new LinkedList<Movie>();
		
				list.add(new Movie (1,	"Star Wars I",	166, "English", "First Film new Trilogy", "space"));
				list.add(new Movie (1,	"Star Wars I",	166, "English", "First Film new Trilogy", "space"));
				list.add(new Movie (3,	"Star Wars III",211, "English", "Three Film new Trilogy", "space"));
				list.add(new Movie (4,	"Star Wars IV",	149, "English", "First Film old Trilogy", "space"));
				list.add(new Movie (5,	"Star Wars V",	154, "English", "Second Film old Trilogy", "space"));
				list.add(new Movie (6,	"Star Wars VI",	171, "English", "Three Film old Trilogy", "space"));  
				
	    return list;
	}
	
	//(addButton,10,100);
	public void addButton(){
		Button addButton = new Button("Add movie", new ClickHandler() {
			public void onClick(ClickEvent event) {
				table.setRowData(ids, manager.EMPTY);
				ids ++;
				}
	      });
		
	    RootPanel.get().add(addButton,10,100);
	}
	
	//(delButton,100,100);
	public void delButton(){

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

