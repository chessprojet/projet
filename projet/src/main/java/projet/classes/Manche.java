package projet.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

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
    
    public void jouerManche(boolean finDeManche){
    	int pos=0;
    	int DC=0;
    	int d=0;//definir d le temps de tour : action listener
    	serializerManche sm=new serializerManche(part);
    	do{
    	do{
    		pos=j.choixPieceADeplacer();
    		this.j.getPiece()[pos].deplacer(this.part,this.j);
    		DC=part.ChoixDuDeplacement(this.part.deplacementPossible(this.j.getPiece()[pos],this.j),this.j.getPiece()[pos]);}
    	while(DC==0 || j.getPiece()[pos].isEtat()!=true);
    	Case c=part.getEchiquierPartie().getPlateau()[DC];
    	this.part.deplacementChoisi(DC,this.j.getPiece()[pos]);
    	this.j.getPiece()[pos].setCase(DC);
    	if (this.part.estEnEchec(this.j,0)!=false)
    	{
    		part.getEchiquierPartie().getPlateau()[DC]=c;
    	}
    	}
    	while(this.part.estEnEchec(this.j,0)!=false);// on verife quel'on fini pas en echec et mat a la fin du tour
    	this.part.getEchiquierPartie().toString();
    	sm.serializ(DC);
    	
   
    }

	public void finDeManche() {
		// TODO Auto-generated method stub
		
		this.incrementerTour();
		
		if (j==part.getJ1())
			this.setJ(part.getJ2());
		else
			this.setJ(part.getJ1());
		
	}

 }
