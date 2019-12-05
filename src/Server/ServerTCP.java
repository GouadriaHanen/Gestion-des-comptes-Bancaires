package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ls.LSInput;

import Model.Compte;

public class ServerTCP {
	public static List<Compte> Comptes = new ArrayList<Compte>() ;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int port=6789;
		ServerSocket socket = new ServerSocket(port) ;

		while(true)
		{
			Socket cnnxnSocket = socket.accept();
			Traitement trait= new Traitement(cnnxnSocket) ;
			trait.start();
			
		}
		
		
		
		
		
	}

}
