package projet.classes;

// Classe Cavalier

public class Cavalier extends Piece {
    
	// Constructeur du Cavalier
	public Cavalier() {	
		super();				// Permet de manipuler les données de la "superclasse"
    }
    
	// Méthode pour l'affichage du Cavalier sur la case
    public String toString() {
    	return "C";
   	}
    @Override
    public void deplacer(Partie pa,Joueur blanc){
    	this.deplacement.clear();
		this.nbsoldir.clear();
    	this.deplacement.add(17);
		this.deplacement.add(15);
		this.deplacement.add(-17);
		this.deplacement.add(-15);
		this.deplacement.add(10);
		this.deplacement.add(6);
		this.deplacement.add(-10);
		this.deplacement.add(-6);
		for (int i=0; i<deplacement.size();i++) {
			this.nbsoldir.add(1);
		}  
    }
}