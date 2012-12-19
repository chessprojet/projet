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
	
	public void Deplacer(Partie pa,Joueur blanc){
		if (blanc==pa.getJ1()) {
			if (pa.getEchiquierPartie().getPlateau()[CasePlace-8].isEtatCase()==false) {
				deplacement.add(-8);
				nbsoldir.add(1);
			}
			if (pa.getEchiquierPartie().getPlateau()[CasePlace-7].isEtatCase()==true) {
				deplacement.add(-7);
				nbsoldir.add(1);
			}
			if (pa.getEchiquierPartie().getPlateau()[CasePlace-9].isEtatCase()==true) {
				deplacement.add(-9);
				nbsoldir.add(1);
			}	
		}
		
		else {
			if (pa.getEchiquierPartie().getPlateau()[CasePlace+8].isEtatCase()==false) {
				deplacement.add(8);
				nbsoldir.add(1);
			}
			if (pa.getEchiquierPartie().getPlateau()[CasePlace+7].isEtatCase()==true) {
				deplacement.add(7);
				nbsoldir.add(1);
			}
			if (pa.getEchiquierPartie().getPlateau()[CasePlace+9].isEtatCase()==true) {
				deplacement.add(9);
				nbsoldir.add(1);
			}
		}
	}
}