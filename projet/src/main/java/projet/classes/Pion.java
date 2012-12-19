package projet.classes;

//Classe Pion

public class Pion extends Piece {
 
	// Constructeur du Pion
	public Pion() {	
		super();				// Permet de manipuler les données de la "superclasse"
	}
 
	// Méthode pour l'affichage du Pion sur la case
	public String toString() {
		return "P";
	}
 
}