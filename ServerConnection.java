import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Server.Account;

public class ServerConnection implements Runnable{
	
	ServerSocket server = null;
	int serverPort = 2500;
	Account accounts = null;
	//Initializes a server with a specified port
	ServerConnection(int serverPort, Account accounts){
		this.accounts = accounts;
		try {
			this.server = new ServerSocket(serverPort);
		} catch (IOException e) {
			System.out.println("couldn't open a socket on port " + serverPort);
			System.exit(0);
			return;
		}
	}
	
	//Initializes a server with the default 2500 port
	ServerConnection(){
		this.accounts = new Account();
		try {
			this.server = new ServerSocket(serverPort);
		} catch (IOException e) {
			System.out.println("couldn't open a socket on port " + serverPort);
			System.exit(0);
			return;
		}
	}
	public void run(){
		String output = null;
		
		while(true){
			Socket connection = null;
			try {
				connection = server.accept();
			} catch (IOException e) {
				System.out.println("failed to accept new connection");
				continue;
			}
			System.out.println("accepted new connection from: " + connection);
			
			BufferedReader incomingData = null;
			try {
				incomingData = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			} catch (IOException e1) {
				System.out.println("couldn't establish a connection");
				continue;
			}
			
			String sepInput[] = null;
			try {
				sepInput = incomingData.readLine().split("##");
			
				output = processRequest(sepInput);
			} catch (IOException e) {
				System.out.println("couldn't read from connection");
			}
			//test portion
	
			DataOutputStream outgoingData = null;
			try {
				outgoingData = new DataOutputStream(connection.getOutputStream());
				outgoingData.writeBytes(output);
			} catch (IOException e) {
				System.out.println("couldn't send to output stream");
			}
			
			
			
			try {
				incomingData.close();
			
				outgoingData.close();
				connection.close();
			} catch (IOException e) {
				System.out.println("couldn't close connection properly");
			}
		}
	}

	private String processRequest(String[] sepInput) {
		String user = null;
		String password = null;
		Object userAccount = null;
		boolean purchase = false;
		user = sepInput[1];
		password = sepInput[2];
		
			if(sepInput[3].equals("register")){
				//create user account and return true if sucessful
				return "SvrRes##"+user+"##"+accounts.register(user, password);
				
			} else if(sepInput[3].equals("login")){
				//indicate that account exists and log user in
				return "SvrRes##"+user+"##"+accounts.login(user, password);
				
			} else if(sepInput[3].equals("battleReq")){
				//input user credentials, battle mode then army id to get the matched opponent
				String opponent = battleReq(user,password,sepInput[4],sepInput[5]);
				return "SvrRes##"+user+"##"+sepInput[4]+"##"+opponent;
				
			} else if(sepInput[3].equals("battleMove")){
				//input split string and receive a full set of battle instructions
				return "SvrRes##"+user+"##"+battleMove(sepInput);
				
			} else if(sepInput[3].equals("infoReq")){
				//input info request, receive account info
				return "SvrRes##"+user+"##"+infoReq(sepInput);
				
			} else if(sepInput[3].equals("infoReqEcon")){
				//input economy request, receive available units for purchase
				return "SvrRes##"+user+"##"+infoReqEcon(sepInput);
				
			} else if(sepInput[3].equals("purchase")){
				//send a purchase request and receive a true/false result based on price of unit and available resources
				purchase = purchaseUnit(user, password, sepInput[4]);
				return "SvrRes##"+user+"##purchase##"+purchase;

			} else if(sepInput[3].equals("chatUp")){
				//send a message to server
				chatUp(user, password, sepInput[4]);
				return "SvrRes##"+user+"##chatUp##true";
			} else if(sepInput[3].equals("friendOp")){
				//check what operation must be done on the friends list with respect to the owner
				if(sepInput[4].equals("display")){
					//display all friends associated with user
					ArrayList<String> friends = accounts.displayFriends(user);
					String output = "SvrRes##"+user+"##friendOp";
					for(String friend : friends){
						output = output + "##" + friend;
					}
					return output;
				} else if(sepInput[4].equals("add")){
					//add friend relationship to db
					return "SvrRes##"+user+"##friendOp##"+accounts.addFriend(user, sepInput[5]);
				} else if(sepInput[4].equals("delete")){
					//remove friend relationship to db
					return "SvrRes##"+user+"##friendOp##"+accounts.deleteFriend(user, sepInput[5]);
				}
			}
		return null;
	}
}
