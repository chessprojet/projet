package projet.classes;

import java.util.Scanner;

// Classe Joueur

public class Joueur {
	
    private String nom;						// Nom du Joueur
    private boolean aide;					// Aide : activée (true) ou désactivée (false)
    private Piece piece[]= new Piece[16];	// Création d'un tableau comportant 16 Pièces
    
    
    // Constructeur du Joueur
    public Joueur() {
		this.piece[0]=new Tour();
		this.piece[1]=new Cavalier();
		this.piece[2]=new Fou();
		this.piece[4]=new Reine();
		this.piece[3]=new Roi();
		this.piece[5]=new Fou();
		this.piece[6]=new Cavalier();
		this.piece[7]=new Tour();
		for (int i=8;i<16;i++)
			this.piece[i]=new Pion();
    }
    
    // Getter du nom du Joueur
    public String getNom() {
        return this.nom;
    }
    
    // Setter du nom du Joueur
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    // Getter de l'aide pour le Joueur
    public boolean isAide() {
        return this.aide;
    }
    
    // Setter de l'aide pour le Joueur
    public void setAide(boolean aide) {
        this.aide = aide;
    }
    
    // Getter de la Pièce associée au Joueur
    public Piece[] getPiece() {
        return this.piece;
    }
    
    // Setter de la Pièce associée au Joueur
    public void setPiece(Piece[] piece) {
        this.piece = piece;
    }
    
    // Choix du nom du Joueur
    public void choixNom() {
    	System.out.println("Nom du Joueur");
		Scanner sc = new Scanner(System.in);
		String n=sc.nextLine();
		this.nom=n;
    }
    
    // Choix de l'activation de l'aide
    public void choixAide() {
    	System.out.println("Activation de l'aide ?");
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		if (a==1)
			this.aide=true;
		if (a==2)
			this.aide=false;
    }

    public int choixPieceADeplacer(){
    	System.out.println("piece a deplacer?");
    	for (int pos=0;pos<16;pos++)
    		System.out.print(piece[pos]);
    	Scanner sc=new Scanner(System.in);
    	int pos=sc.nextInt();
    	return pos;
    	
    }

}
