package niti;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextArea;

import domen.AktivniKlijenti;


public class CitanjeNiti extends Thread {
	private BufferedReader br;
	private AktivniKlijenti ak;
	private Socket s;
	private JTextArea ta;
	public CitanjeNiti(BufferedReader br, AktivniKlijenti ak, Socket s, JTextArea ta) {
		super();
		this.br = br;
		this.ak = ak;
		this.s = s;
		this.ta = ta;
		start();
	}
	public void run(){
		
		String poruka = null;
		
		try {
			//while(){
			while(!(poruka=br.readLine()).equals("izlaz")){
				System.out.println("Poruka je "+poruka);
				KlijentUtil.posaljiPorukeSvima(ak.getUser() ,"["+ak.getUser()+"]"+ poruka);
				
					KlijentUtil.jedan(ak.getUser(), poruka);
					KlijentUtil.izbrisiKlijenta(ak.getUser());
					ta.append(KlijentUtil.vratiListu());
					System.out.println("Stigso sam u nekaPoruka Nit citanje server "+poruka);
					
				}
			br.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	
	


