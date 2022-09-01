package com.example.hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ContactController implements Initializable {

    @FXML
    private TextField numberText,number2Text,emailText;

    @FXML
    private BorderPane rootborderpane;

    @FXML
    private Button submitButton;

    @FXML
    private Label noticeLabel;
    public void submitButtonOnAction(ActionEvent event) {
        if (numberText.getText().isBlank() == false) {
            registerContact();
        } else {
            noticeLabel.setText("Please enter right credentials");
        }
    }
    public void registerContact(){
        DatabaseController connectNow = new DatabaseController();
        Connection connectDB = connectNow.getConnection();

        Integer number= Integer.valueOf(numberText.getText());
        Integer number2= Integer.valueOf(number2Text.getText());
        String email= emailText.getText();

        String insertFields= "INSERT INTO patient_contact(patientPhone,patientPhone2,patientEmail) VALUES('";
        String insertValues= number+"','"+number2+"','"+email+"')";
        String insertToRegister= insertFields+insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            noticeLabel.setText("Successful");
            //createDiagnosis();
            BorderPane borderpane= FXMLLoader.load(getClass().getResource("diagnosis.fxml"));
            rootborderpane.getChildren().setAll(borderpane);
        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void createDiagnosis(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("diagnosis.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage stage = new Stage();
            stage.setTitle("Hospital Management System");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
