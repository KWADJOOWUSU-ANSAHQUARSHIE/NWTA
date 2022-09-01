package com.example.hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    @FXML
    private Button loginButton,signupButton,forgotButton;

    @FXML
    private Label noticeLabel;

    @FXML
    private BorderPane rootborderpane;

    @FXML
    private TextField idText;

    @FXML
    private PasswordField passwordText;

    public void signupButtonOnAction(ActionEvent event) {
        noticeLabel.setText("Contact administration for account creation");
    }

    public void forgotButtonOnAction(ActionEvent event) {
        noticeLabel.setText("Contact administration to get password changed");
    }
    private void validateLogin() {
        DatabaseController connectNow= new DatabaseController();
        Connection connectDB=connectNow.getConnection();

        String verifyLogin= "SELECT count(1) FROM staff WHERE id='" + idText.getText() + "' AND password='" +passwordText.getText()+ "'";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getInt(1)==1){
                   noticeLabel.setText("Login Successful");
                    //createPatient();
                    BorderPane borderpane= FXMLLoader.load(getClass().getResource("patient-details.fxml"));
                    rootborderpane.getChildren().setAll(borderpane);
                }
                else{
                    noticeLabel.setText("Wrong Login, Retry");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loginButtonOnAction(ActionEvent event) {
        if(idText.getText().isBlank()==false && passwordText.getText().isBlank()==false){
            validateLogin();
        }
        else{
            noticeLabel.setText("Please enter right credentials");
        }
    }

    public void createPatient(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("patient-details.fxml"));
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