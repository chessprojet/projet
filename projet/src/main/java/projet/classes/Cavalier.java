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
    
    public void Deplacer(){
    	deplacement.add(17);
		deplacement.add(15);
		deplacement.add(-17);
		deplacement.add(-15);
		deplacement.add(10);
		deplacement.add(6);
		deplacement.add(-10);
		deplacement.add(-6);
		for (int i=0; i<deplacement.size();i++) {
			nbsoldir.add(1);
		}  
    }
}