package com.jhu.cvrg.guid.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.jhu.cvrg.portal.resourcerequest.validators.GuidValidator")
public class GuidValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {

		if(component.getId().equals("menuStudy")){
			validateMenu("Study", value);
		}
		if(component.getId().equals("menuSite")){
			validateMenu("Site", value);
		}
	}
	
	private void validateMenu(String name, Object value){
		int val = Integer.parseInt(value.toString());
		
		if(val == 0){
			FacesMessage message = new FacesMessage("No " + name + " Selected", "Please select a " + name + ".");
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			throw new ValidatorException(message);
		}
	}

}
