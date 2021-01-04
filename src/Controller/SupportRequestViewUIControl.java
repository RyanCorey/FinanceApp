package Controller;

import Communication.SupportRequest;
import Communication.SupportRequestList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author group 2
 */
public class SupportRequestViewUIControl implements Initializable {

    @FXML
    private Label dateText;
    @FXML
    private Label nameText;
    @FXML
    private Label emailText;
    @FXML
    private Button returnToSupportRequestListButton;
    @FXML
    private TextArea supportRequestText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void returnToSupportRequestListButtonClicked(ActionEvent event) {
        EFinance.EFinanceFX.switchScene(getClass(), "/View/SupportRequestListUI.fxml", "Support Request List | eFinance", event);
    }
    
    public void populate(SupportRequest selectedSupportRequest, SupportRequestList supportRequestList) {
        this.dateText.setText(selectedSupportRequest.getRequestDate().toString());
        this.nameText.setText(selectedSupportRequest.getContactName());
        this.emailText.setText(selectedSupportRequest.getContactEmail());
        this.supportRequestText.setText(selectedSupportRequest.getRequest()); 
    }
    
}
