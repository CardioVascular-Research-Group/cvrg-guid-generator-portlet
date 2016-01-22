package com.jhu.cvrg.guid.listener;

import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class GuidGeneratorPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent pe) {

		if (pe.getPhaseId() == PhaseId.PROCESS_VALIDATIONS) {

			FacesContext facesContext = FacesContext.getCurrentInstance();
			Iterator<FacesMessage> messages = facesContext.getMessages();
			while (messages.hasNext()) {
				FacesMessage message = messages.next();
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				reformatMessage(message);
			}
		}
	}

	private void reformatMessage(FacesMessage message) {

		if(message.getSummary().equals("Regex Pattern not matched")){
			message.setDetail("Please enter a valid date (mm/dd/yyyy)");
		}

		String[] messageElements = message.getSummary().split(":");

		if (messageElements.length > 1) {
			message.setSummary("Please enter a value.");
		}
	}

	@Override
	public void beforePhase(PhaseEvent pe) {

	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.ANY_PHASE;
	}

}
