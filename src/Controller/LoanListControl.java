/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Loans.Application;
import Loans.ApplicationList;
import java.io.IOException;
import java.math.BigDecimal;
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
 * @author Group 2
 */
public class LoanListControl implements Initializable {

    @FXML
    private TableView<Application> loanTable;

    @FXML
    private TableColumn<Application, Integer> loanNumber;

    @FXML
    private TableColumn<Application, BigDecimal> loanAmount;

    @FXML
    private TableColumn<Application, String> loanStatus;

    @FXML
    private Button returnToMenuButton;

    @FXML
    private Button viewLoanButton;

    private ApplicationList applicationList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Associate table columns with Application fields.
        loanNumber.setMinWidth(100);
        loanNumber.setCellValueFactory(new PropertyValueFactory<>("loanNumber"));

        loanAmount.setMinWidth(100);
        loanAmount.setCellValueFactory(new PropertyValueFactory<>("loanAmount"));

        loanStatus.setMinWidth(100);
        loanStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        this.applicationList = new ApplicationList();

        for (Object o : applicationList.getApplicationList()) {

            Application temp = (Application) o;
            loanTable.getItems().add(temp);

        }
    }

    @FXML
    private void viewLoanClicked(ActionEvent event) throws IOException {

        Application selectedApplication = loanTable.getSelectionModel().getSelectedItem();
        System.out.println(selectedApplication.getLoanNumber());

        //Loads the Create Account UI
        FXMLLoader approvedenyLoader = new FXMLLoader(getClass().getResource("/View/ApproveDenyUI.fxml"));
        Parent approvedenyUI = (Parent) approvedenyLoader.load();
        Stage approvedenyStage = new Stage();
        approvedenyStage.setTitle("Approve/Deny Loan | eFinance");
        approvedenyStage.setScene(new Scene(approvedenyUI));
        approvedenyStage.show();

        // Send account list to the create account controller
        ApproveDenyControl approvedenyController = approvedenyLoader.getController();
        approvedenyController.populate(selectedApplication, applicationList);

        // Close Login UI
        Stage loanListStage = (Stage) viewLoanButton.getScene().getWindow();
        loanListStage.close();
    }

    @FXML
    private void returnToMenuButtonClicked(ActionEvent event) {
        EFinance.EFinanceFX.switchScene(getClass(), "/View/MenuUI.fxml", "Menu | eFinance", event);
    }
}
