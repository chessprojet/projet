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
	
	public void Deplacer(){
		int w=CasePlace;
		/*
		 * gauche = possibilité de se déplacer à gauche
		 * droite = possibilité de se déplacer droite
		 * ddroite = possibilité de se déplacer dans la diagonale montante droite
		 * mdroite = possibilité de se déplacer dans la diagonale descendante droite
		 * dgauche = possibilité de se déplacer dans la diagonale montante gauche
		 * mgauche = possibilité de se déplacer dans la diagonale descendante gauche
		 * 
		 * */
		boolean droite = true, ddroite = true, mdroite = true, gauche = true, dgauche = true, mgauche = true;
		
		// Ajout de 8 valeurs par défaut dans la liste du nombre des directions possibles
		for (int i=0; i<8; i++) {
			nbsoldir.add(0);
		}
		
		// Si la pièce est à gauche de l'échiquier
		if (w%8==0) {
			gauche = false;
			mgauche = false;
			dgauche = false;
		}
		
		// Si la pièce est à droite de l'échiquier
		if (w%8==7) {
			droite = false;
			mdroite = false;
			ddroite = false;
		}
		
		if (droite==true) {
			deplacement.add(1);
			nbsoldir.set(0,nbsoldir.get(0)+1);
		}
		
		if (gauche==true) {
			deplacement.add(-1);
			nbsoldir.set(1,nbsoldir.get(1)+1);
		}
		
		// Ajoute les déplacements vers le haut et le bas
		// L'interdiction de sortir de l'échiquier est géré plus bas (pos<0 et pos>64)
		
		deplacement.add(-8);
		nbsoldir.set(2,nbsoldir.get(2)+1);

		deplacement.add(8);
		nbsoldir.set(3,nbsoldir.get(3)+1);
		
		// Ajoute les déplacements vers les différentes diagonales
		
		// Diagonale descendante droite
		if (mdroite==true) {
			deplacement.add(9);
			nbsoldir.set(4,nbsoldir.get(4)+1);
		}
		
		// Diagonale descendante gauche
		if (mgauche==true) {
			deplacement.add(7);
			nbsoldir.set(5,nbsoldir.get(5)+1);
		}
		
		// Diagonale montante droite
		if (ddroite==true) {
			deplacement.add(-9);
			nbsoldir.set(6,nbsoldir.get(6)+1);
		}
		
		// Diagonale montante gauche
		if (dgauche==true) {
			deplacement.add(-7);
			nbsoldir.set(7,nbsoldir.get(7)+1);
		}
		
		// Si la pièce est à gauche de l'échiquier
		if (w%8==0) {
			mgauche=false; dgauche=false;
		}
		
		// Si la pièce est à droite de l'échiquier
		if (w%8==7) {
			mdroite=false; ddroite=false;
		}  
	}
	
}