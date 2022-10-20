public class Snorlax extends Humungosaur{
	private String espece;
	
	public Snorlax(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		espece="";
	}
	
	
	public Snorlax(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		espece="";
	}
	
	public Snorlax(){
		super();
		espece="";
	}
	
	public String toString(){
		return nom;
	}
	
	public String getId(){
		return espece+" "+nom+ " (" + pv + "/" + pvmax + "pv, " + attaque + " att, Niv. " + niveau +")";
	}
	
	public void talent (){
		pv = pv + (int)(pvmax*0.1);
		if (pv > pvmax)
			pv = pvmax;
	}
}
