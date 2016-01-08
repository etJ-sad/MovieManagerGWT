package movies.client.ui.dialogs;

//Message dialog for Errors and Other messages
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;


public class MessageDialog extends DialogBox {

	public MessageDialog(String Message) {
		setGlassEnabled(true);
		setAnimationEnabled(true);

		VerticalPanel panel = new VerticalPanel();

		panel.add(new Label(Message));

		Button closeButton = new Button("Close");
		closeButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MessageDialog.this.hide();
			}
		});

		panel.add(closeButton);

		setWidget(panel);
	}

}
