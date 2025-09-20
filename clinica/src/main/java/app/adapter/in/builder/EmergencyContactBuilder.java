package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.adapter.in.validators.EmergencyContactInputValidator;
import app.domain.model.EmergencyContact;

@Component
public class EmergencyContactBuilder {

    @Autowired
    private EmergencyContactInputValidator validator;

    public EmergencyContact build(String firstName, String lastName, String relationship, String phone, String patientDocument) throws Exception {
        EmergencyContact contact = new EmergencyContact();
        contact.setFirstName(validator.validateFirstName(firstName));
        contact.setLastName(validator.validateLastName(lastName));
        contact.setRelationship(validator.validateRelationship(relationship));
        contact.setPhone(validator.validatePhone(phone));
        contact.setPatientDocument(validator.validatePatientDocument(patientDocument));
        return contact;
    }
}