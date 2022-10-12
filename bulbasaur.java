public class bulbasaur extends feuille {
	private String espece;

	public bulbasaur(String nom, int pvmax, int attaque, int x, int y) {
		super(nom, pvmax, attaque, x, y);
		espece = "bulbasaur";
	}

	public bulbasaur(String nom, int pvmax, int attaque) {
		super(nom, pvmax, attaque);
		espece = "bulbasaur";
	}

	public bulbasaur() {
		super();
		espece = "bulbasaur";
	}

	public String toString() {
		return nom;
	}

	public String getId() {
		return espece + " " + nom + " (" + pv + "/" + pvmax + "pv, " + attaque + " att, Niv. " + niveau + ")";
	}

	public void talent() {
		pv = pv + (int) (pvmax * 0.1);
		if (pv > pvmax)
			pv = pvmax;
	}
}
