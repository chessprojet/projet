package projet.classes;

// Classe Case

public class Case {
	
	private int NumCase;			// Numéro de la case
	private boolean EtatCase;		// Etat de la case : occupée (true) ou libre (false)
	private Piece p;				// Objet Pièce
	
	
	// Constructeur de la Case
	public Case(int numero) {
			this.NumCase=numero;
			this.EtatCase=false;
	}
	
	// Getter de la Pièce associée à la Case
	public Piece getP() {
	    return this.p;
	}
	
	// Setter de la Pièce associée à la Case
	public void setP(Piece pie) {
	    this.p = pie;
	    this.EtatCase=true;
	}
	
	// Getter du numéro de la Case
	public int getNumCase() {
		return this.NumCase;
	}

	// Setter du numéro de la Case
	public void setNumCase(int numCase) {
		this.NumCase = numCase;
	}
	
	// Getter de l'état de la Case
	public boolean isEtatCase() {
		return this.EtatCase;
	}

	// Setter de l'état de la Case
	public void setEtatCase(boolean etatCase) {
		this.EtatCase = etatCase;
		if (etatCase==false){this.p=null;};
	}
	
	// Méthode pour l'affichage de la pièce sur la case ou de son innocupation
	public String toString() {
		if (EtatCase==false)
			return "O";
		else 
			return p.toString();
	}
		
}
