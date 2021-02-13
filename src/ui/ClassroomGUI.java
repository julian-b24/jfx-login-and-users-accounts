package ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import model.Classroom;
import model.UserAccount;

public class ClassroomGUI {
	
	private Classroom classroom;
		
	@FXML
    private Pane mainPane;
	
	//login
	@FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField  txtPassword;
    
    //register
    @FXML
    private JFXTextField txtUsernameSignUp;

    @FXML
    private JFXTextField txtFile;

    @FXML
    private JFXPasswordField txtPasswordSignUp;
    
    @FXML
    private JFXRadioButton bttnMale;

    @FXML
    private JFXRadioButton bttnFemale;

    @FXML
    private JFXRadioButton bttnOther;
    
    @FXML
    private JFXCheckBox softwCheck;

    @FXML
    private JFXCheckBox telemCheck;

    @FXML
    private JFXCheckBox indusCheck;

    @FXML
    private JFXDatePicker txtDateSignUp;

    @FXML
    private ChoiceBox<String> txtBrowserChoice;
    
    //account list
    @FXML
    private TableView<?> tableView;

    @FXML
    private ImageView imgvPhoto;

    @FXML
    private Label txtUserNameLabel;
	
	public ClassroomGUI(Classroom cr) {
		classroom = cr;
	}
	
	//login methods
	@FXML
	public void logIn(ActionEvent event) {
		
		String userName = txtUserName.getText();
		String password = txtPassword.getText();
		
		if(isAbleToLogIn(userName, password)) {
			//showList();
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Log in incorrect");
			alert.setHeaderText("An error has occurred!");
			alert.setContentText("The username and/or the password given are incorrect");
		}

    }

    @FXML
	public void showSignUp(ActionEvent event) throws IOException {
	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
    	fxmlLoader.setController(this);
    	Parent registerPane = fxmlLoader.load();
    	
    	mainPane.getChildren().setAll(registerPane);
    	
    	txtBrowserChoice.getItems().add("FireFox");
    	txtBrowserChoice.getItems().add("Edge");
    	txtBrowserChoice.getItems().add("Chrome");
    }
    
    //register methods
    @FXML
    public void createAccount(ActionEvent event) {
    	
    	String userName = txtUsernameSignUp.getText();
    	String password = txtPasswordSignUp.getText();
    	String photoPath = txtFile.getText();
    	String gender = getGender();
    	ArrayList<String> careers = getCarrers();
    	String date = txtDateSignUp.toString();
    	String favBrowser = txtBrowserChoice.getValue().toString();
    	
    	// Warning in case at least one field is equal to "" and the user is not added to the list of users
    	if(userName.equals("") || password.equals("") || photoPath.equals("") || gender.equals("") || careers.isEmpty() || date.equals("") || favBrowser.equals("")) {
    		
    		Alert warning = new Alert(AlertType.WARNING);
    		warning.setTitle("Warning!");
    		warning.setHeaderText("We have an issue creating your account");
    		warning.setContentText("You must fill each field in the form");
    		
    	} else {
    		
    		if(classroom.getAccounts().size() > 0) {
        		
        		boolean equal = false;
        		int i = 0;
        		while(i < classroom.getAccounts().size() || !equal) {
        			
        			if(classroom.getAccounts().get(i).getUserName().equals(userName)) {
        				equal = true;
        			}	
        			i++;
        		}
        		
        		if(!equal) {
        			classroom.addAccount(userName, password, photoPath, gender, careers, date, favBrowser); //add career
        			showSuccesDialog();
        			
        		} else {
        			Alert alert = new Alert(AlertType.ERROR);
        			alert.setTitle("Error creating the account");
        			alert.setHeaderText("We have an issue creating your account");
        			alert.setContentText("The username that you entered already exists!");
        			
        			alert.showAndWait();
        		}
        		
        	} else {
        		classroom.addAccount(userName, password, photoPath, gender, careers, date, favBrowser); //add career 
        		showSuccesDialog();
        	}
    	}
    }

    @FXML
    public void showLogIn(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
    	fxmlLoader.setController(this);
    	Parent logInPane = fxmlLoader.load();
    	
    	mainPane.getChildren().setAll(logInPane);
    }
    
    @FXML
    void browseFile(ActionEvent event) {
    	
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Resource File");
    	
    	File fileChoosed = fileChooser.showOpenDialog(null);
    	txtFile.setText(fileChoosed.getAbsolutePath());
    	
    }
    
    public String getGender() {
    	
    	String gender = "";
    	
    	if (bttnMale.isSelected()) {
    		gender = bttnMale.getText();
    	}
    	
    	if (bttnFemale.isSelected()) {
    		gender = bttnFemale.getText();
    	}
    	
    	if (bttnOther.isSelected()) {
    		gender = bttnOther.getText();
    	}
    	
    	return gender;
    }
    
    public ArrayList<String> getCarrers() {
    	
    	ArrayList<String> carrers = new ArrayList<String>();
    	
    	if (softwCheck.isSelected()) {
    		carrers.add(softwCheck.getText());
    	}
    	
    	if (telemCheck.isSelected()) {
    		carrers.add(telemCheck.getText());
    	}
    	
    	if (indusCheck.isSelected()) {
    		carrers.add(indusCheck.getText());
    	}
    	
    	return carrers;
    }
    
    public void showSuccesDialog() {
    	
    	Alert succes = new Alert(AlertType.INFORMATION);
		succes.setTitle("Account created");
		succes.setHeaderText(null);
		succes.setContentText("The new account has been created!");

		succes.showAndWait();
		cleanFields();
    }
    
    public void cleanFields() {
    	
    	txtUsernameSignUp.setText("");
    	txtPasswordSignUp.setText("");
    	txtFile.setText("");
    	txtDateSignUp.setValue(null);
    	
    	bttnMale.setSelected(false);
    	bttnFemale.setSelected(false);
    	bttnOther.setSelected(false);
    	
    	softwCheck.setSelected(false);
    	telemCheck.setSelected(false);
    	indusCheck.setSelected(false);
    }
    
    public boolean isAbleToLogIn(String userName, String password) {
    	
    	boolean able = false;
    	
    	if(classroom.getAccounts().size() > 0) {
    		for (UserAccount account : classroom.getAccounts()) {
        		
        		if(account.getUserName().equals(userName) && account.getPassword().equals(password)) {
        			able = true;
        		}
        	}
    	}
    	
    	return able;
    }

}
