package projet.classes;

//Classe Fou

public class Fou extends Piece {
 
	// Constructeur du Fou
	public Fou() {	
		super();				// Permet de manipuler les données de la "superclasse"
 }
 
	// Méthode pour l'affichage du Fou sur la case
	public String toString() {
 		return "F";
	}
	@Override
	public void deplacer(Partie pa,Joueur blanc){
		this.deplacement.clear();
		this.nbsoldir.clear();
		int w=CasePlace;
		/*
		 * ddroite = possibilité de se déplacer dans la diagonale montante droite
		 * mdroite = possibilité de se déplacer dans la diagonale descendante droite
		 * dgauche = possibilité de se déplacer dans la diagonale montante gauche
		 * mgauche = possibilité de se déplacer dans la diagonale descendante gauche
		 * 
		 * */
		boolean ddroite = true, dgauche = true, mgauche = true, mdroite = true;
		this.nbsoldir.add(0); this.nbsoldir.add(0); this.nbsoldir.add(0); this.nbsoldir.add(0);
		
		// Si la pièce est à gauche de l'échiquier
		if (w%8==0) {
			mgauche=false; dgauche=false;
		}
		
		// Si la pièce est à droite de l'échiquier
		if (w%8==7) {
			mdroite=false; ddroite=false;
		}
		
		// Teste tous les déplacements possibles dans la diagonale descendante droite pour ne pas sortir de l'échiquier
		for (int pos=1; pos<8; pos++) {
			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
			if (w+9*pos%8==0 && mdroite==true) {
				mdroite=false; this.deplacement.add(9*pos); this.nbsoldir.set(0,this.nbsoldir.get(0)+1);
			}
			if (mdroite==true) {
				this.deplacement.add(9*pos); this.nbsoldir.set(0,this.nbsoldir.get(0)+1);
			}
		}
		
		// Teste tous les déplacements possibles dans la diagonale descendante gauche pour ne pas sortir de l'échiquier
		for (int pos=1; pos<8; pos++) {
			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
			if (w+7*pos%8==7 && mgauche==true) {
				mgauche=false;this.deplacement.add(7*pos);this.nbsoldir.set(1,this.nbsoldir.get(1)+1);
			}
			if (mgauche==true) {
				this.deplacement.add(7*pos); this.nbsoldir.set(1,this.nbsoldir.get(1)+1);
			}	
		}
		
		// Teste tous les déplacements possibles dans la diagonale montante droite pour ne pas sortir de l'échiquier
		for (int pos=1;pos<8;pos++) {
			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
			if (w-7*pos%8==7 && ddroite==true) {
				ddroite=false;this.deplacement.add(-7*pos); this.nbsoldir.set(2,this.nbsoldir.get(2)+1);
			}
			if (ddroite==true) {
				this.deplacement.add(-7*pos); this.nbsoldir.set(2,this.nbsoldir.get(2)+1);
			}
		}
		
		// Teste tous les déplacements possibles dans la diagonale montante gauche pour ne pas sortir de l'échiquier
		for (int pos=1;pos<8;pos++) {
			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
			if (w-9*pos%8==0 && dgauche==true) {
				dgauche=false;this.deplacement.add(-9*pos); this.nbsoldir.set(3,this.nbsoldir.get(3)+1);
			}
			if (dgauche==true) {
				this.deplacement.add(-9*pos); this.nbsoldir.set(3,this.nbsoldir.get(3)+1);
			}
		}
	}
 
}
