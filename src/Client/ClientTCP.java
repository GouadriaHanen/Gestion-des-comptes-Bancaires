package Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTCP {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		String hostname ="127.0.0.1";
		int port=6789 ;
		String msg ; ;
		String msgRcv ;
		
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in)) ;
		Socket ClientSocket = new Socket(hostname,port) ;
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
		while(true) {
		PrintWriter outToServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(ClientSocket.getOutputStream())),true);
		msg=inFromClient.readLine();
		outToServer.println(msg);
		msgRcv=inFromServer.readLine();
		System.out.println(msgRcv);
		//ClientSocket.close();
		}
		
		

	}

}
