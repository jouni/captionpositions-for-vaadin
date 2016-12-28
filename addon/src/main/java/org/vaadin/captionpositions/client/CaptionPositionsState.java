package org.vaadin.captionpositions.client;

import java.util.HashMap;

import com.vaadin.shared.Connector;

public class CaptionPositionsState extends com.vaadin.shared.AbstractComponentState {

	private static final long serialVersionUID = 7872275572312535374L;
	
	public HashMap<Connector, CaptionPosition> captionPositions = new HashMap<Connector, CaptionPosition>();

}
