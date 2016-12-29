package org.vaadin.captionposition.demo;

import javax.servlet.annotation.WebServlet;

import org.vaadin.captionpositions.CaptionPositions;
import org.vaadin.captionpositions.client.CaptionPosition;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@Theme("valo")
@Title("CaptionPositions add-on demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
	public static class Servlet extends VaadinServlet {
	}

	final TextField textField = new TextField("Caption");
	final TextArea textArea = new TextArea("Caption");
	
	CaptionPositions captionPositions;
	CaptionPosition currentPosition = CaptionPosition.LEFT;

	@Override
	protected void init(VaadinRequest request) {

		final VerticalLayout layout = new VerticalLayout();

		captionPositions = new CaptionPositions(layout);
		captionPositions.setCaptionPosition(textField, currentPosition);
		captionPositions.setCaptionPosition(textArea, currentPosition);

		textArea.setRequired(true);
		textArea.setComponentError(new UserError("An error just to show the error indicator"));
		textArea.setInputPrompt("Required and error indicators visible");
		textArea.setWidth("20em");

		MenuBar options = createPositionOptions();
		captionPositions.setCaptionPosition(options, CaptionPosition.LEFT);
		
		layout.addComponents(options, new Label(""), textField, textArea);
		setContent(layout);
	}

	Command changePosition = new Command() {

		@Override
		public void menuSelected(MenuItem selectedItem) {
			// Update caption positions
			CaptionPosition newPosition = CaptionPosition.valueOf(selectedItem.getText().toUpperCase());
			captionPositions.setCaptionPosition(textField, newPosition);
			captionPositions.setCaptionPosition(textArea, newPosition);

			// Update MenuBar to show new selection
			for (MenuItem item : selectedItem.getParent().getChildren()) {
				item.setChecked(item == selectedItem);
			}
			selectedItem.getParent().setText(selectedItem.getText());
		}

	};

	String capitalize(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
	}

	MenuBar createPositionOptions() {
		MenuBar options = new MenuBar();
		options.setCaption("Caption position");
		options.addStyleName(ValoTheme.MENUBAR_SMALL);
		
		MenuItem root = options.addItem("", null);
		for (CaptionPosition pos : CaptionPosition.values()) {
			MenuItem option = root.addItem(capitalize(pos.toString()), changePosition);
			option.setCheckable(true);

			if (pos == currentPosition) {
				option.setChecked(true);
				root.setText(capitalize(pos.toString()));
			}
		}
		return options;
	}
}
