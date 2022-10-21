public class Snorlax extends normal{
	private String espece;
	
	public Snorlax(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		espece="Snorlax";
	}
	
	
	public Snorlax(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		espece="Snorlax";
	}
	
	public Snorlax(){
		super();
		espece="Snorlax";
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
