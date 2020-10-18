import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NewPatientInTakeController implements Initializable {

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField streetTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private ComboBox<String> provinceComboBox;

    @FXML
    private DatePicker birthdayDatePicker;

    @FXML
    private Label errMsgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        provinceComboBox.getItems().addAll(Patient.getProvinceList());
        phoneNumberTextField.setPromptText("Enter phone number");
        streetTextField.setPromptText("Enter street address");
        cityTextField.setPromptText("Enter city name");
        provinceComboBox.setPromptText("Select a province");
        birthdayDatePicker.setPromptText("Select birthday");
        errMsgLabel.setText("");
    }

    @FXML
    private void createPatient()
    {
        errMsgLabel.setText("");
        if(fieldsHaveValues()){
            try {
                Patient newPatient = new Patient(
                        firstNameTextField.getText(),
                        lastNameTextField.getText(),
                        phoneNumberTextField.getText(),
                        streetTextField.getText(),
                        cityTextField.getText(),
                        provinceComboBox.getValue(),
                        birthdayDatePicker.getValue()
                );
            } catch (IllegalArgumentException e){
                errMsgLabel.setText(e.getMessage());
            }
        }

    }

    // Returns true if all fields of the form have at least values

    private boolean fieldsHaveValues(){
        StringBuilder msg = new StringBuilder("Please update the field(s): ");

        if(firstNameTextField.getText().isBlank())
            msg.append("first name");

        if(lastNameTextField.getText().isBlank())
            msg.append(msg.length() == 28 ? "last name":", last name");

        if(phoneNumberTextField.getText().isBlank())
            msg.append(msg.length() == 28 ? "phone":", phone");

        if(streetTextField.getText().isBlank())
            msg.append(msg.length() == 28 ? "street address":", street address");

        if(cityTextField.getText().isBlank())
            msg.append(msg.length() == 28 ? "city":", city");

        if(provinceComboBox.getValue() == null)
            msg.append(msg.length() == 28 ? "province":", province");

        if(birthdayDatePicker.getValue() == null)
            msg.append(msg.length() == 28 ? "birthday":", birthday");

        if(msg.length() != 28){
            errMsgLabel.setText(msg.toString());
            return false;
        } else {
            return true;
        }

    }


    @FXML
    private void changeToTableView(ActionEvent event){
        try {
            ArrayList<Patient> patients = DBUtility.getAllPatients();
            for (Patient patient : patients)
                System.out.println(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
