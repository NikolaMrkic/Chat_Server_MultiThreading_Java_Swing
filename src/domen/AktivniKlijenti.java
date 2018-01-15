package domen;

public class AktivniKlijenti {

	private String user;
	private String adresa;
	private String poruka;
	
	public AktivniKlijenti(String user, String adresa){
		super();
		this.adresa=adresa;
		this.user=user;
		this.poruka="";
	}
	
	public AktivniKlijenti(){
		
	}
	
	public String getUser(){
		return user;
	}
	
	public void setUser(String user){
		this.user=user;
	}
	
	public String getAdresa(){
		return adresa;
	}
	
	public void setAdresa(String adresa){
		this.adresa=adresa;
	}
	
	public synchronized String getPoruka(){
		
		try {
			
			wait();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return poruka;
		
	}
	
	public synchronized void setPotuka(String poruka){
		
		this.poruka=poruka;
		notify();
	}
	
		
}
