package projet.classes;

//Classe Roi

public class Roi extends Piece {

	// Constructeur du Roi
	public Roi() {	
		super();				// Permet de manipuler les données de la "superclasse"
	}

	// Méthode pour l'affichage du Roi sur la case
	public String toString() {
		return "R";
	}

}