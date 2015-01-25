package com.tbs.general;

import java.io.Serializable;

public class TBSException extends Exception  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageToDisplay;
	
	
	
	public TBSException() {
		super();
	}
	public TBSException(String messageToDisplay) {
		super();
		this.messageToDisplay = messageToDisplay;
	}
	public String getMessageToDisplay() {
		return messageToDisplay;
	}
	public void setMessageToDisplay(String messageToDisplay) {
		this.messageToDisplay = messageToDisplay;
	}

	
	
}
