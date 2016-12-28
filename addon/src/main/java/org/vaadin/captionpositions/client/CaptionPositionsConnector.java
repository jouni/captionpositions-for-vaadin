package org.vaadin.captionpositions.client;

import org.vaadin.captionpositions.CaptionPositions;

import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.client.ui.orderedlayout.AbstractOrderedLayoutConnector;
import com.vaadin.client.ui.orderedlayout.CaptionPosition;
import com.vaadin.shared.Connector;
import com.vaadin.shared.ui.Connect;

@Connect(CaptionPositions.class)
public class CaptionPositionsConnector extends AbstractExtensionConnector {

	private static final long serialVersionUID = 5877776519115352083L;
	private AbstractOrderedLayoutConnector target;

	@Override
	protected void extend(ServerConnector target) {
		this.target = (AbstractOrderedLayoutConnector) target;
	}

	@Override
	public CaptionPositionsState getState() {
		return (CaptionPositionsState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);

		for (Connector c : getState().captionPositions.keySet()) {
			CaptionPosition pos = CaptionPosition.valueOf(getState().captionPositions.get(c).name());
			ComponentConnector connector = (ComponentConnector) c;

			// Only try to position captions which are managed by this layout
			if (target.getChildComponents().contains(c)) {
				target.getWidget().getSlot(connector.getWidget()).setCaptionPosition(pos);
			}

		}
	}

}
