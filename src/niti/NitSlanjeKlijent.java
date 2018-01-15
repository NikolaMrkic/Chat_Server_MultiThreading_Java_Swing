package niti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import domen.AktivniKlijenti;
import kontroler.Kontoler;
import kontroler.Kontroler;

public class NitSlanjeKlijent extends Thread{
	
	private String klijent;
	private Socket s;
	NitSlanjeKlijent(Socket s){
		
		this.s=s;
	}
	public void run(){
		
		
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			try {
				klijent = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("klijnet je "+klijent);
			Kontoler.getInstanca().prikaziPodatke("Klijent [" + klijent + s.getInetAddress() + "] se povezao na server.");
			 Kontoler.getInstanca().dodajNovogKlijenta(this);
			 String poruka = null;
			
			 while(true){
				 System.out.println("\n"+"Poruka od klijenta12 while "+poruka);
				 poruka = in.readLine();
				 System.out.println("\n"+"Poruka od klijenta "+poruka);
				 if(poruka!=null && !poruka.isEmpty()){
					 
					  Kontoler.getInstanca().obavestiOstale(klijent + " kaze: " + poruka, this);
				 }
				 
			 }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
	}
	public void posalji(String poruka) {
        try {
        	System.out.println("Posalji poruku "+poruka);
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            pw.println(poruka);
        } catch (IOException ex) {

        }}
	 public String getAddress() {
	        return s.getInetAddress() + "";
	    }

	    /**
	     * metoda Username korisnika kao string
	     *
	     */
	    public String getImeKlijenta() {
	        return klijent;
	    }

}
