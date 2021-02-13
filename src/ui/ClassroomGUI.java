package ui;

import java.io.IOException;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;

import model.Classroom;

public class ClassroomGUI {
	
	private Classroom classroom;
		
	@FXML
    private Pane mainPane;
	
	//login
	@FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXTextField txtPassword;
    
    //register
    @FXML
    private JFXTextField txtUsernameSignUp;

    @FXML
    private JFXTextField txtFile;

    @FXML
    private JFXPasswordField txtPasswordSignUp;

    @FXML
    private JFXDatePicker txtDateSignUp;

    @FXML
    private ChoiceBox<?> txtBrowserChoice;
	
	public ClassroomGUI(Classroom cr) {
		classroom = cr;
	}
	
	//login methods
	@FXML
	public void logIn(ActionEvent event) {

    }

    @FXML
	public void showSignUp(ActionEvent event) throws IOException {
	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
    	fxmlLoader.setController(this);
    	Parent registerPane = fxmlLoader.load();
    	
    	mainPane.getChildren().setAll(registerPane);
    }
    
    //register methods
    @FXML
    public void createAccount(ActionEvent event) {

    }

    @FXML
    public void showLogIn(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
    	fxmlLoader.setController(this);
    	Parent logInPane = fxmlLoader.load();
    	
    	mainPane.getChildren().setAll(logInPane);
    }

}
