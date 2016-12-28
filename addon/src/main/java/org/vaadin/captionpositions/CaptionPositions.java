package org.vaadin.captionpositions;

import org.vaadin.captionpositions.client.CaptionPosition;
import org.vaadin.captionpositions.client.CaptionPositionsState;

import com.vaadin.server.AbstractExtension;
import com.vaadin.shared.Connector;
import com.vaadin.ui.AbstractOrderedLayout;

public class CaptionPositions extends AbstractExtension {

	private static final long serialVersionUID = 7728706628069199155L;

	@Override
	protected CaptionPositionsState getState() {
		return (CaptionPositionsState) super.getState();
	}

	public CaptionPositions(AbstractOrderedLayout layout) {
		super(layout);
	}
	
	/**
	 * Set the caption position of a component. The component doesn’t have to be in the layout when you call this method.
	 * 
	 * @param component The component whose caption to position
	 * @param captionPosition The position of the caption
	 */
	public void setCaptionPosition(Connector component, CaptionPosition captionPosition) {
		getState().captionPositions.put(component, captionPosition);
	}

}
