package model;

import java.util.ArrayList;

public class Classroom {

	private ArrayList<UserAccount> accounts;
	
	public Classroom() {
		setAccounts(new ArrayList<UserAccount>());
	}

	public ArrayList<UserAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<UserAccount> accounts) {
		this.accounts = accounts;
	}
	
	public void addAccount( String usrName, String passwd, String pathPhoto, 
							String gnder, ArrayList<String> carrs, String bthday,
							String favBrwser) {
		
		UserAccount account = new UserAccount(usrName, passwd, pathPhoto, gnder, carrs, bthday, favBrwser);
		accounts.add(account);
		System.out.println(accounts);
	}
	
}
