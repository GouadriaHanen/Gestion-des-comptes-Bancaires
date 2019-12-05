package Server; 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import Model.Compte;

public class Traitement extends Thread {
	Socket socket ;
	public Traitement(Socket sc) {
		super();
		this.socket = sc;
	}
	
	public void run () {
		try {
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
			PrintWriter outToClient= new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			Compte c = new Compte("", 0.0) ;
			
			while(true) {
				
				String msgClient=inFromClient.readLine();
				String Msg="Reéssez" ;
				
				if(msgClient.startsWith("CONNECT"))
				{ int exist=0 ;
				
				String nom=msgClient.substring(9,msgClient.length());
				for (int i=0;i<ServerTCP.Comptes.size();i++)
				{
					if(ServerTCP.Comptes.get(i).getNom().equals(nom))
					{
						exist=1;
					}
				}
				if (exist==1)
				{
					for (int i=0;i<ServerTCP.Comptes.size();i++)
				{
					if(ServerTCP.Comptes.get(i).getNom().equals(nom))
					{
						c=ServerTCP.Comptes.get(i) ;
					}
				}
				
					Msg="Vous etes connectés";
				}
				else
				{
					
					Msg="le compte n'existe pas "
				}	
				}
				if(msgClient.startsWith("CREATION"))
				{
					int exist=0 ;
					
					String nom=msgClient.substring(9,msgClient.length());
					for (int i=0;i<ServerTCP.Comptes.size();i++)
					{
						if(ServerTCP.Comptes.get(i).getNom().equals(nom))
						{
							exist=1;
						}
					}
					
					
					if (exist==1)
					{
						Msg="Le compte existe deja avec ce nom";
					}
					else
					{
						c=new Compte(nom , 0.0);
						ServerTCP.Comptes.add(c);
						Msg="le compte est créé avec succès!"+nom +": Le num de votre compte est :" +c.getNumcp() ;
					}
					
				}
				if(msgClient.startsWith("SOLDE"))
				{
					double solde = c.getSolde() ;
					Msg="Votre solde est "+ solde ;
				}
				
				if(msgClient.startsWith("CREDIT"))
				{
					String mont=msgClient.substring(7,msgClient.length());
					Double montant=Double.parseDouble(mont);
					c.setSolde(c.getSolde()+montant);
					Msg="compte Crédité avec succès";
							
				}
				
				
				if(msgClient.startsWith("DEBIT"))
				{
					String mont=msgClient.substring(6,msgClient.length());
				    Double montant=Double.parseDouble(mont);
				 if(montant<c.getSolde())
				 {
					 Msg="Compte a debité avec succès" ;
							 c.setSolde(c.getSolde()-montant);
				 }
				 else
				 {
					 Msg="Solde insuffsant" ;
				 }
					
				}
		
			  outToClient.println(Msg);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
