package com.example.hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class PatientDetailController implements Initializable {

    @FXML
    private TextField firstText,lastText,ageText,genderText,addressText;

    @FXML
    private BorderPane rootborderpane;

    @FXML
    private Label noticeLabel;
    public void submitButtonOnAction(ActionEvent event) {
        if(firstText.getText().isBlank()==false && lastText.getText().isBlank()==false){
            registerPatient();
        }
        else{
            noticeLabel.setText("Please enter right credentials");
        }
    }

    public void registerPatient(){
        DatabaseController connectNow = new DatabaseController();
        Connection connectDB = connectNow.getConnection();

        String firstname = firstText.getText();
        String lastname= lastText.getText();
        String age= ageText.getText();
        String gender= genderText.getText();
        String address= addressText.getText();

        String insertFields= "INSERT INTO patient_details(patientFirstName,patientLastName,patientAge,patientGender,patientAddress) VALUES('";
        String insertValues= firstname+"','"+lastname+"','"+age+"','"+gender+"','"+address+"')";
        String insertToRegister= insertFields+insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            noticeLabel.setText("successful");
            //createParent();
            BorderPane borderpane= FXMLLoader.load(getClass().getResource("contact.fxml"));
            rootborderpane.getChildren().setAll(borderpane);
        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void createParent(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("parent.fxml"));
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
}
