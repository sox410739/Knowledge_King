package server;

public class accountData {
	private String account;
	private String password;
	private String name;
	private int level;
	private int exp;
	private int money;
	private int character;
	
	public accountData(String acc, String pas) {
		account = acc;
		password = pas;
		name = "¹C«È";
		level = 1;
		exp = 0;
		money = 200;
		character = 1;
	}
	
	public accountData(String input) {
		String[] data = input.split(" ");
		account = data[0];
		password = data[1];
		name = data[2];
		level = Integer.parseInt(data[3]);
		exp = Integer.parseInt(data[4]);
		money = Integer.parseInt(data[5]);
		character = Integer.parseInt(data[6]);
	}
	
	public String forTxt() {
		String temp = new String(account + " " + password + " " + name + " " + level + " " + exp + " " + money + " "  + character + "\r\n");
		return temp;
	}
	
	public String forPassenge() {
		String temp = new String(account + " " + password + " " + name + " " + level + " " + exp + " " + money + " " + character);
		return temp;
	}
	
	public String getAccount() {
		return account;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getExp() {
		return exp;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getCharacter() {
		return character;
	}
}
