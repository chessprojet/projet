package projet.classes;

//Classe Reine

public class Reine extends Piece {

	// Constructeur de la Reine
	public Reine() {	
		super();				// Permet de manipuler les données de la "superclasse"
	}

	// Méthode pour l'affichage de la Reine sur la case
	public String toString() {
		return "Q";
	}
	@Override
	public void deplacer(Partie pa,Joueur blanc){
		this.deplacement.clear();
		this.nbsoldir.clear();
		int w=CasePlace;
		/*
		 * gauche = possibilité de se déplacer à gauche
		 * droite = possibilité de se déplacer droite
		 * 
		 * */
		
		boolean droite = true, gauche = true;
		this.nbsoldir.add(0); this.nbsoldir.add(0); this.nbsoldir.add(0); this.nbsoldir.add(0);
		
		// Si la pièce est à gauche de l'échiquier
		if (w%8==0) {
			gauche = false;
		}
		
		// Si la pièce est à droite de l'échiquier
		if (w%8==7) {
			droite = false;
		}
		
		// Teste tous les déplacements possibles vers la droite pour ne pas sortir de l'échiquier
		for (int pos=1;pos<=8;pos++) {
			
			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
			if (w+pos%8==7) {
				droite=false;
				this.deplacement.add(pos);
				this.nbsoldir.set(0,this.nbsoldir.get(0)+1);
			}
			if (droite==true) {
				this.deplacement.add(pos);
				this.nbsoldir.set(0,this.nbsoldir.get(0)+1);
			}
		}
		
		// Teste tous les déplacements possibles vers la gauche pour ne pas sortir de l'échiquier
		for (int pos=1;pos<=8;pos++) {
			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
			if (w-pos%8==0) {
				gauche=false;
				this.deplacement.add(-pos);
				this.nbsoldir.set(1,this.nbsoldir.get(1)+1);
			}
			if (gauche==true) {
				this.deplacement.add(-pos);
				this.nbsoldir.set(1,this.nbsoldir.get(1)+1);
			}
		}
		// Ajoute les déplacements vers le haut et le bas
		// L'interdiction de sortir de l'échiquier est géré plus bas ( pos<0 et pos>64)
		for (int pos=1; pos<=8; pos++) {
			this.deplacement.add(-8*pos);
			this.nbsoldir.set(2,this.nbsoldir.get(2)+1);
		}
		for (int pos=1; pos<=8; pos++) {
			this.deplacement.add(8*pos);
			this.nbsoldir.set(3,this.nbsoldir.get(3)+1);
		}
		
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
			if (w+9*pos%8==0 && mdroite==false) {
				mdroite=false; this.deplacement.add(9*pos); this.nbsoldir.set(4,this.nbsoldir.get(4)+1);
			}
			if (mdroite==true) {
				this.deplacement.add(9*pos); this.nbsoldir.set(4,this.nbsoldir.get(4)+1);
			}
		}
		
		// Teste tous les déplacements possibles dans la diagonale descendante gauche pour ne pas sortir de l'échiquier
		for (int pos=1; pos<8; pos++) {
			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
			if (w+7*pos%8==7 && mgauche==false) {
				mgauche=false;this.deplacement.add(7*pos);this.nbsoldir.set(5,this.nbsoldir.get(5)+1);
			}
			if (mgauche==true) {
				this.deplacement.add(7*pos); this.nbsoldir.set(5,this.nbsoldir.get(5)+1);
			}	
		}
		
		// Teste tous les déplacements possibles dans la diagonale montante droite pour ne pas sortir de l'échiquier
		for (int pos=1;pos<8;pos++) {
			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
			if (w-7*pos%8==7 && ddroite==true) {
				ddroite=false;this.deplacement.add(-7*pos); this.nbsoldir.set(6,this.nbsoldir.get(6)+1);
			}
			if (ddroite==true) {
				this.deplacement.add(-7*pos); this.nbsoldir.set(6,this.nbsoldir.get(6)+1);
			}
		}
		
		// Teste tous les déplacements possibles dans la diagonale montante gauche pour ne pas sortir de l'échiquier
		for (int pos=1;pos<8;pos++) {
			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
			if (w-9*pos%8==0 && dgauche==true) {
				dgauche=false;this.deplacement.add(-9*pos); this.nbsoldir.set(7,this.nbsoldir.get(7)+1);
			}
			if (dgauche==true) {
				this.deplacement.add(-9*pos); this.nbsoldir.set(7,this.nbsoldir.get(7)+1);
			}
		}
	}
}