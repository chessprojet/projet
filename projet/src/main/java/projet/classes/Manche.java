package projet.classes;

// Classe Manche

public class Manche {

    private int numTour;			// Numéro du tour
    private Joueur j;				// Joueur à qui est associé le tour
    private Partie part;
    // Constructeur de la Manche
    public Manche(Joueur jo,Partie partie) {
    	this.numTour=1;
    	this.j=jo;
    	this.part=partie;
    }
    
    public Partie getPart() {
		return part;
	}

	public void setPart(Partie part) {
		this.part = part;
	}

	public void setJ(Joueur j) {
		this.j = j;
	}

	// Getter du numéro du tour
    public int getNumTour() {
        return this.numTour;
    }
    
    // Setter du numéro du tour
    public void setNumTour(int num) {
        this.numTour = num;;
    }
    
    // Getter du Joueur associé au tour
    public Joueur getJ() {
        return this.j;
    }
    
    // Setter du Joueur associé au tour
    public void associerJoueur(Joueur jo) {
        this.j = jo;
    }
    
    // Méthode pour incrémenter le tour
    public void incrementerTour() {
    	this.numTour=numTour+1;
    }
    

 }
