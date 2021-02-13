package model;

import java.io.File;
import java.util.ArrayList;

public class UserAccount {
	
	private String userName;
	private String password;
	
	private File photo;
	
	private String gender;
	private ArrayList<String> carrers;
	
	private String birthday;
	private String favBrowser;
	
	public UserAccount( String usrName, String passwd, String pathPhoto, 
						String gnder, ArrayList<String> carrs, String bthday,
						String favBrwser) {
		
		setUserName(usrName);
		setPassword(passwd);
		setPhoto(pathPhoto);
		setGender(gnder);
		setCarrers(carrs);
		setBirthday(bthday);
		setFavBrowser(favBrwser);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(String pathPhoto) {
		this.photo = new File(pathPhoto);
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ArrayList<String> getCarrers() {
		return carrers;
	}

	public void setCarrers(ArrayList<String> carrers) {
		this.carrers = carrers;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getFavBrowser() {
		return favBrowser;
	}

	public void setFavBrowser(String favBrowser) {
		this.favBrowser = favBrowser;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
