package kontroler;


import java.util.ArrayList;

import main.ServerForma;
import niti.NitSlanjeKlijent;

public class Kontroler {
	
	public static Kontroler instanca;
	private String text;
	private ServerForma sf;
	ArrayList<NitSlanjeKlijent>klijent = new ArrayList<>();
	
	public static Kontroler getInstanca(){
		
		if(instanca == null){
			
			instanca = new Kontroler();
		}
		
		return instanca;
	}
	
	public void posaljiPodatke(String string){
		this.text=string;
	}
	
	public void postaviFormu(ServerForma serverForma){
		this.sf=serverForma;
	}
	
	

	public void prikaziPodatke(String string) {
		// TODO Auto-generated method stub
		sf.postaviTekst(text+"\n");
	}
	
	public void dodajNovogklijenta(NitSlanjeKlijent nitSlanjeKlijent){
		System.out.println("Dodavanje novog klijenta ");
		klijent.add(nitSlanjeKlijent);
	}
	
	public void obavestiOstale(String string,NitSlanjeKlijent nitSlanjeKijent){
		
		for(NitSlanjeKlijent kl : klijent){
			System.out.println("Nit obavesti ostale "+kl+" novi String  "+ string);
			if(!kl.equals(nitSlanjeKijent)){
				kl.posalji(string);
			}
		}
		posaljiPodatke("Klijent [" + nitSlanjeKijent.getImeKlijenta() + nitSlanjeKijent.getAddress() + "] " + string);
	}

}
