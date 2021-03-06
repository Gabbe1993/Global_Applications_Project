package se.kth.iv1201projekt.integration.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Check if the length of the job type is more than 4 characters
 *
 * @author Gabriel
 */
@FacesValidator("jobTypeValidator")
public class JobTypeValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String param = value.toString();

        if (param.length() < 4) {
            FacesMessage msg = new FacesMessage("Invalid job type: must be more than 4 characters");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
