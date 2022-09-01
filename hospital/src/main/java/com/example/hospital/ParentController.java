package com.example.hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ParentController implements Initializable {

    @FXML
    private TextField ffText,flText,fcText,faText,mfText,mlText,mcText,maText;

    @FXML
    private Label noticeLabel;

    public void submitButtonOnAction(ActionEvent event) {
        if(ffText.getText().isBlank()==false && mfText.getText().isBlank()==false){
            registerParent();
        }
        else{
            noticeLabel.setText("Please enter right credentials");
        }
    }
    public void registerParent(){
        DatabaseController connectNow = new DatabaseController();
        Connection connectDB = connectNow.getConnection();

        String fatherFN = ffText.getText();
        String fatherLN = flText.getText();
        Integer fatherC= Integer.valueOf(fcText.getText());
        String fatherA= faText.getText();
        String motherFN= mfText.getText();
        String motherLN= mlText.getText();
        Integer motherC = Integer.valueOf(mcText.getText());
        String motherA= maText.getText();



        String insertFields= "INSERT INTO parent(fatherFirstName,fatherLastName,fatherContact,fatherAddress,motherFirstName,motherLastName,motherContact,motherAddress) VALUES('";
        String insertValues= fatherFN+"','"+fatherLN+"','"+fatherC+"','"+fatherA+"','"+motherFN+"','"+motherLN+"','"+motherC+"','"+motherA+"')";
        String insertToRegister= insertFields+insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            noticeLabel.setText("successful");
            //createContact();

        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void createContact(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("contact.fxml"));
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
