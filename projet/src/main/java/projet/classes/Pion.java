package projet.classes;

//Classe Pion

public class Pion extends Piece {
 
	// Constructeur du Pion
	public Pion() {	
		super();				// Permet de manipuler les données de la "superclasse"
	}
	public Pion(int c) {	
		super();
		this.CasePlace=c;
	}
	
	// Méthode pour l'affichage du Pion sur la case
	public String toString() {
		return "P";
	}
	@Override
	public void deplacer(Partie pa,Joueur blanc){
		this.deplacement.clear();
		this.nbsoldir.clear();
		if (blanc==pa.getJ1()) {
			if (pa.getEchiquierPartie().getPlateau()[this.CasePlace-8].isEtatCase()==false) {
				this.deplacement.add(-8);
				this.nbsoldir.add(1);
			}
			if (pa.getEchiquierPartie().getPlateau()[this.CasePlace-7].isEtatCase()==true && this.CasePlace%8!=7) {
				this.deplacement.add(-7);
				this.nbsoldir.add(1);
			}
			if (pa.getEchiquierPartie().getPlateau()[this.CasePlace-9].isEtatCase()==true && CasePlace%8!=0) {
				this.deplacement.add(-9);
				this.nbsoldir.add(1);
			}	
		}
		
		else {
			if (pa.getEchiquierPartie().getPlateau()[this.CasePlace+8].isEtatCase()==false) {
				this.deplacement.add(8);
				this.nbsoldir.add(1);
			}
			if (pa.getEchiquierPartie().getPlateau()[this.CasePlace+7].isEtatCase()==true && CasePlace%8!=0) {
				this.deplacement.add(7);
				this.nbsoldir.add(1);
			}
			if (pa.getEchiquierPartie().getPlateau()[this.CasePlace+9].isEtatCase()==true && CasePlace%8!=7) {
				this.deplacement.add(9);
				this.nbsoldir.add(1);
			}
		}
	}
}