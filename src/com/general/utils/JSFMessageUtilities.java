package com.general.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;



public class JSFMessageUtilities {

	public static void addErrorMessage(String messageToDisplay) {
		addMessage(FacesMessage.SEVERITY_ERROR, messageToDisplay);
	}

	public static void addInfoMessage(String messageToDisplay) {
		addMessage(FacesMessage.SEVERITY_INFO, messageToDisplay);

	}

	public static void addMessage(FacesMessage.Severity severity,
			String messageToDisplay) {
		FacesContext
				.getCurrentInstance()
				.getCurrentInstance()
				.addMessage("",
						new FacesMessage(severity, messageToDisplay, ""));

	}



}
