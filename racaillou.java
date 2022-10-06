public class Racaillou extends Terre{
	private String espece;
	
	public Racaillou(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		espece="Racaillou";
	}
	
	
	public Racaillou(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		espece="Racaillou";
	}
	
	public Racaillou(){
		super();
		espece="Racaillou";
	}
	
	public String toString(){
		return nom;
	}
	
	public String getId(){
		return espece+" "+nom+ " (" + pv + "/" + pvmax + "pv, " + attaque + " att, Niv. " + niveau +")";
	}
	
	public void talent (){}

	public void subire (Pokemon adversaire, int degats) {
		if(Math.random()<0.7){
			degats=(int)(degats*0.85);
			super.subire(adversaire,degats);
		}
		else{
			degats=(int)(degats*0.0);
			super.subire(adversaire,degats);
		}
	}
}
