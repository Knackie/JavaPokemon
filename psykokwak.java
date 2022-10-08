public class psykokwak extends Water{
	private String espece;
	
	public psykokwak(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		espece="psykokwak";
	}
	
	
	public psykokwak(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		espece="psykokwak";
	}
	
	public psykokwak(){
		super();
		espece="psykokwak";
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