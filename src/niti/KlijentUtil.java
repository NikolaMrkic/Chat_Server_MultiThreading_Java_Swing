package niti;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import domen.AktivniKlijenti;

public class KlijentUtil {

	private static HashMap<String, AktivniKlijenti> hm = new HashMap<String, AktivniKlijenti>();

	public synchronized static AktivniKlijenti dodajKolijenta(String user, String adresa) {
		// TODO Auto-generated method stub

		AktivniKlijenti ak = (AktivniKlijenti) hm.get(user);
		System.out.println("Dodajem klijenta ");
		if (ak == null) {

			AktivniKlijenti noviak = new AktivniKlijenti(user, adresa);
			hm.put(user, noviak);
			return noviak;
		} else {

			return null;
		}
	}

	public static String vratiListu() {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		for (String key : hm.keySet())  {
			
			
			sb.append(key);
			sb.append("\n");
        }
		return sb.toString();
	}

	public static void posaljiPorukeSvima(String user, String string) {
		// TODO Auto-generated method stub
		// Iterator iterator = hm.entrySet().iterator();
		 for (String key : hm.keySet())  {

	             
				if(!key.equals(user)){
					
					AktivniKlijenti ak=new AktivniKlijenti();
					ak.setPotuka(string);
				}
	        }
	}



	public synchronized static boolean izbrisiKlijenta(String user) {
		// TODO Auto-generated method stub
		AktivniKlijenti ak = (AktivniKlijenti) hm.get(user);
		if(ak==null){
			
			return false;
		}else{
			
			hm.remove(user);
			return true;
		}

	}
	
	public static void jedan(String user, String poruka){
		
		
		Iterator it = hm.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry vrednsot = (Map.Entry)it.next();
	        String user1=vrednsot.getKey().toString();
	        if(user.equals(user1)){
	        	
	        	
	        	AktivniKlijenti ak=new AktivniKlijenti();
	        	ak.setPotuka(poruka);
	        	break;
	        }
	    
	    
	    
	    }
	}

}
