public class Salameche extends Feu{
	private String espece;
	
	public Salameche(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		espece="Salamèche";
	}
	
	
	public Salameche(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		espece="Salamèche";
	}
	
	public Salameche(){
		super();
		espece="Salamèche";
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
