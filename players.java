import java.util.Scanner;

public class Joueur extends Dresseur{
	protected String att; //correspond à l'attaque choisie
	protected int nombreVictoires;
	protected int nombreDefaites;
	
	public Joueur(String nom, int x, int y){
		super(nom,x,y);
		this.estJoueur=true;
		att="";
		nombreVictoires=0;
		nombreDefaites=0;
		argent=500;
	}
	
	
	
	public Joueur(int x, int y, int niveau){
		super(x,y,niveau);
		this.estJoueur=true;
		att="";
		nombreVictoires=0;
		nombreDefaites=0;
		this.nom="Joueur";
		argent=500;
	}
	
	
	
	public Joueur(String nom) {
		super(nom);
		this.estJoueur=true;
		att="";
		nombreVictoires=0;
		nombreDefaites=0;
		argent=500;
	}
	
	
	public Joueur(int x, int y) {
		super(x,y);
		this.estJoueur=true;
		att="";
		nombreVictoires=0;
		nombreDefaites=0;
		argent=500;
	}
	
	
	
	public Joueur() {
		super();
		this.estJoueur=true;
		att="";
		nombreVictoires=0;
		nombreDefaites=0;
		argent=500;
	}
	
	
	public void lireAttaqueClavier(){
		Pokemon []tab=pokemons;
		Scanner attaque = new Scanner(System.in);
		this.att = attaque.next();
		
	}
	
	public void combat (Dresseur adversaire) {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		
		System.out.println ("\n\n"+this + " affronte " + adversaire);
		boolean termine = false;
		int pokemonNum = 0, pokemonNumAdv = 0;
		Dresseur vainqueur = null;
		boolean b=false;
		
		for(int i=0;i<this.pokemons.length;i++){ // Deparalyse tous les Pokemon du joueur pour éviter de commencer un nouveau combat avec un Pokemon paralysé
			if(!(this.pokemons[i]==null))
				this.pokemons[i].paralyse=0;
		}
		
		
		
		while (!termine) {
			
			 // Permet de passer à un Pokemon non KO si le ou les premiers Pokemon sont KO, lors du début d'un combat
			
			if(b==false){
				while(pokemons[pokemonNum].estKO()){
					if(pokemons[pokemonNum+1]!=null)
					pokemonNum++;
					else
						break;
				}
				b=true;
			}
			
			
			
			do{	
				System.out.println ("\n\n\n\n\n\n\n\n\n\t\t\t"+this.pokemons[pokemonNum].getId()+"\t\t\tVS\t\t\t"+adversaire.pokemons[pokemonNumAdv].getId()+"\n\n\n\n\n\n\n\n\n");
				pokemons[pokemonNum].afficheAttaques();
				this.lireAttaqueClavier();	
			}while(!((pokemons[pokemonNum]).estAttaqueValide(att)));
			
			
			
			System.out.print("\033[H\033[2J");
			System.out.flush();
			
			String attaque1=att;
			System.out.println("\n\nVous avez choisi : " + att);
			String attaque2=adversaire.pokemons[pokemonNumAdv].attaquesDisponibles[(int)(Math.random()*adversaire.pokemons[pokemonNumAdv].nbAttaques)];
			
			Pokemon.combat(pokemons[pokemonNum], adversaire.pokemons[pokemonNumAdv], attaque1,attaque2);
			if (pokemons[pokemonNum].estKO()) {
				System.out.println (this.pokemons[pokemonNum] + " est KO ");
				pokemonNum++;
			}
			if (adversaire.pokemons[pokemonNumAdv].estKO()) {
				System.out.println (adversaire.pokemons[pokemonNumAdv] + " est KO ");
				pokemonNumAdv++;
			}
			if (pokemonNum == nbPokemons) {
				termine = true;
				if (pokemonNumAdv != adversaire.nbPokemons) {
					vainqueur = adversaire;
					nombreDefaites+=1;
					
					if(nombreDefaites==1)
						System.out.println("\n\n\t\t\t\t\t\t\t        1ere defaite de "+this);
				
					else if(nombreDefaites==2)
						System.out.println("\n\n\t\t\t\t\t\t\t        2de defaite de "+this);
					else
						System.out.println("\n\n\t\t\t\t\t\t\t        "+nombreDefaites+"e defaite de "+this);
				}
				
				else if (pokemonNumAdv == adversaire.nbPokemons) 
					System.out.println("\n\n\t\t\t\t\t\t\t\t        Egalite!");
			}
			else if (pokemonNumAdv == adversaire.nbPokemons) {
			termine = true;
			vainqueur = this;
			adversaire.vaincu=true;
			nombreVictoires+=1; // +1 pour le Nb de victoires du joueur
			argent+=(int)(adversaire.argent*0.5);
			
			if(nombreVictoires==1)
				System.out.println("\n\n\t\t\t\t\t\t\t        1ere victoire de "+this);
				
			else if(nombreVictoires==2)
				System.out.println("\n\n\t\t\t\t\t\t\t        2de victoire de "+this);
			else
				System.out.println("\n\n\t\t\t\t\t\t\t        "+nombreVictoires+"e victoire de "+this);
			
			}
		}
		//infirmerie(); // Le joueur doit désormais passer à l'infirmerie pour utiliser un Pokemon ayant été mis KO
		adversaire.infirmerie();
	}
	
	
	
	
}
