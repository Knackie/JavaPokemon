public class registeel extends Acier{
    private String espece;

    public registeel(String nom, int pvmax, int attaque, int x, int y){
        super(nom,pvmax,attaque,x,y);
        espece="Registeel";
    }


    public registeel(String nom, int pvmax, int attaque) {
        super(nom,pvmax,attaque);
        espece="Registeel";
    }

    public registeel(){
        super();
        espece="Registeel";
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
