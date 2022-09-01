package com.example.hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DiagnosisController implements Initializable {

    @FXML
    private TextArea complainText,doctorText,medicineText;

    @FXML
    private BorderPane rootborderpane;

    @FXML
    private DatePicker admindate,disdate;

    @FXML
    private TextField statusText,ADdateText,ADtimeText,DIdateText,DItimeText;

    @FXML
    private Label noticeLabel;

    public void registerDiagnosis(){
        DatabaseController connectNow = new DatabaseController();
        Connection connectDB = connectNow.getConnection();

        String complain= complainText.getText();
        String status= statusText.getText();
        String ADdate= admindate.getValue().format(DateTimeFormatter.ofPattern("yy-MM-dd"));
        String ADtime= ADtimeText.getText();
        String doctor= doctorText.getText();
        String medication= medicineText.getText();
        String DIdate= admindate.getValue().format(DateTimeFormatter.ofPattern("yy-MM-dd"));
        String DItime= DItimeText.getText();

        String insertFields= "INSERT INTO diagnosis(complaint,status,admissionD,admissionT,doctorR,medication,dischargeD,dischargeT) VALUES('";
        String insertValues= complain+"','"+status+"','"+ADdate+"','"+ADtime+"','"+doctor+"','"+medication+"','"+DIdate+"','"+DItime+"')";
        String insertToRegister= insertFields+insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            noticeLabel.setText("successful");
            //createSupplier();
            BorderPane borderpane= FXMLLoader.load(getClass().getResource("parent.fxml"));
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

    public void submitButtonOnAction(ActionEvent event) {
        registerDiagnosis();
    }
}
