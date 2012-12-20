package projet.classes;

// Classe Manche

public class Manche {

    private int numTour;			// Numéro du tour
    private Joueur j;				// Joueur à qui est associé le tour
    private Partie part;			// Partie à laquelle est associé le tour
    
    // Constructeur de la Manche
    public Manche(Joueur jo,Partie partie) {
    	this.numTour=1;
    	this.j=jo;
    	this.part=partie;
    }
    
    // Getter de la Partie associée
    public Partie getPart() {
		return part;
	}
    
    // Setter de la Partie associée
	public void setPart(Partie part) {
		this.part = part;
	}
	
	// Setter du Joueur associé
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
    
    // Méthode pour incrémenter le tour
    public void incrementerTour() {
    	this.numTour=this.numTour+1;
    }
    
    public void jouerManche(){
    	int pos=0;
    	int DC=0;
    	do{
    	pos=j.choixPieceADeplacer();
    	this.j.getPiece()[pos].deplacer(this.part,this.j);
    	DC=this.part.deplacementPossible(this.j.getPiece()[pos],this.j);}
    	while(DC==0 || j.getPiece()[pos].isEtat()!=true);
    	this.part.deplacementChoisi(DC,this.j.getPiece()[pos]);
    	this.j.getPiece()[pos].setCase(DC);
    	this.part.getEchiquierPartie().toString();
   
    }

 }
