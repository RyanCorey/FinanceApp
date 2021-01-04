package Controller;

import Communication.SupportRequest;
import Communication.SupportRequestList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author group 2
 */
public class SupportRequestListControl implements Initializable {

    @FXML
    private TableView<SupportRequest> supportRequestTable;
    private TableColumn<?, ?> ID;
    @FXML
    private TableColumn<?, ?> contactName;
    @FXML
    private TableColumn<?, ?> request;
    @FXML
    private Button returnToMenuButton;

    private SupportRequestList supportRequestList;
    @FXML
    private TableColumn<?, ?> requestDate;
    @FXML
    private TableColumn<?, ?> contactEmail;
    @FXML
    private Button viewSupportRequestButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Associate table columns with support request fields.
        requestDate.setMinWidth(100);
        requestDate.setCellValueFactory(new PropertyValueFactory<>("requestDate"));

        contactName.setMinWidth(100);
        contactName.setCellValueFactory(new PropertyValueFactory<>("contactName"));

        contactEmail.setMinWidth(100);
        contactEmail.setCellValueFactory(new PropertyValueFactory<>("contactEmail"));

        request.setMinWidth(100);
        request.setCellValueFactory(new PropertyValueFactory<>("request"));

        this.supportRequestList = new SupportRequestList();

        for (Object o : supportRequestList.getSupportRequestList()) {

            SupportRequest temp = (SupportRequest) o;
            supportRequestTable.getItems().add(temp);

        }
    }

    @FXML
    private void returnToMenuButtonClicked(ActionEvent event) {
        EFinance.EFinanceFX.switchScene(getClass(), "/View/MenuUI.fxml", "Menu | eFinance", event);
    }

    @FXML
    private void viewSupportRequestButtonClicked(ActionEvent event) throws IOException {
        
        SupportRequest selectedSupportRequest = supportRequestTable.getSelectionModel().getSelectedItem();

        //Loads the Support Request View UI
        FXMLLoader supportRequestViewLoader = new FXMLLoader(getClass().getResource("/View/SupportRequestViewUI.fxml"));
        Parent supportRequestViewUI = (Parent) supportRequestViewLoader.load();
        Stage supportRequestViewStage = new Stage();
        supportRequestViewStage.setTitle("View Support Request | eFinance");
        supportRequestViewStage.setScene(new Scene(supportRequestViewUI));
        supportRequestViewStage.show();

        // Send support request list 
        SupportRequestViewUIControl supportRequestViewUIController = supportRequestViewLoader.getController();
        supportRequestViewUIController.populate(selectedSupportRequest, supportRequestList);

        // Close list UI
        Stage supportRequestStage = (Stage) viewSupportRequestButton.getScene().getWindow();
        supportRequestStage.close();
    }

}
