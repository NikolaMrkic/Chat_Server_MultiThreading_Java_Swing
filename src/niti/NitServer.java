package niti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

import javax.swing.JTextArea;

import kontroler.Kontroler;

public class NitServer extends Thread implements AdresaPort	{
	
	private JTextArea ta;
	

	public NitServer(JTextArea textArea) {
		// TODO Auto-generated constructor stub
		this.ta=textArea;
	}

	
	public void run(){
		
		try {
			
			ServerSocket ss = new ServerSocket(PORT);
			while(true){
				
				Kontroler.getInstanca().posaljiPodatke(" Server Konektovan : "+"\n"+"*********************"+"\n"+" Spreman sam da prihvatim klijente.");
				Kontroler.getInstanca().prikaziPodatke("ServerKontktovan "+"\n" +"Spreman sam da prihvatim klijente");
				while(true){
					System.out.println("Cekam novog klijenta");
		
					Socket s=ss.accept();
					NitSlanjeKlijent nsk=new NitSlanjeKlijent(s) ;
					
					nsk.start();
					System.out.println("Konektovan je klijent");
				
				}
			}
		}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		
	}

	}
