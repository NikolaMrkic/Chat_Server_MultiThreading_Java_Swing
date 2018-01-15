package niti;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class NitSat extends Thread{

	private JLabel sat;
	
	public NitSat(JLabel labelaSat){
		this.sat=labelaSat;
	}
	
	public void run(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		while(true){
			
			try {
				
				sat.setText(sdf.format(new Date()));
				sleep(1000);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
