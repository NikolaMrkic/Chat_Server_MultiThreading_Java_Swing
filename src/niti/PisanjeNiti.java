package niti;

import java.io.PrintWriter;

import domen.AktivniKlijenti;

public class PisanjeNiti extends Thread{
	public class PisanjeNit extends Thread {
		private PrintWriter pw;
		private AktivniKlijenti ak;
		public PisanjeNit(PrintWriter pw, AktivniKlijenti ak) {
			super();
			this.pw = pw;
			this.ak = ak;
			start();
		}
		public void run(){
			String poruka;
			while(!(poruka=ak.getPoruka()).equals("izlaz")){
				
				pw.println(poruka);
				System.out.println("Stigso sam u nekaPoruka Nit pisaznje server "+poruka);
			}
		}
		
		


	}
}
