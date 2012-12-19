package projet.classes;

// Classe Partie

import java.util.ArrayList;
import java.util.Scanner;

public class Partie {
	
    private Joueur j1;
    private Joueur j2;
    private Echiquier echiquierPartie;

    	
    
    // Constructeur
    public Partie(Joueur j1, Joueur j2, Echiquier echiquierPartie) {
    	this.j1 = j1;
    	this.j2 = j2;
    	this.echiquierPartie = echiquierPartie;	
    }

    // Getter du Joueur 1 de la Partie
    public Joueur getJ1() {
        return this.j1;
    }

    // Setter du Joueur 1 de la Partie
    public void setJ1(Joueur j1) {
        this.j1 = j1;
    }

    // Getter du Joueur 2 de la Partie
    public Joueur getJ2() {
        return this.j2;
    }

    // Setter du Joueur 1 de la Partie
    public void setJ2(Joueur j2) {
        this.j2 = j2;
    }

    // Getter de l'Echiquier de la Partie
    public Echiquier getEchiquierPartie() {
        return this.echiquierPartie;
    }

    // Setter de l'Echiquier de la Partie
    public void setEchequierPartie(Echiquier echiquierPartie) {
        this.echiquierPartie = echiquierPartie;
    }
    
    // Méthode pour lancer la Partie
   
    /* public void lancerPartie(){
    	boolean finDePartie=false;
    	while ( finDePartie==false)
		{
    		System.out.println("Choisir une case avec une pièce"); // Prendre ca en compte les execptions ici
    		//Essai sur une case avec un pion
    		deplacerPiece((echiquierPartie.getPlateau())[56], man.getJ());
    		man.incrementerTour();
    		if (man.getJ()==j1)
    			man.associerJoueur(j2);
    		else
    			man.associerJoueur(j1);
    		finDePartie=true;
		}
    }*/
	
    // Méthode pour déplacer une pièce
	public void deplacerPiece(Piece p,Joueur blanc) {
		Case c=new Case(p.isCase());
		c.setP(p);
    	
    	
    	
    	
    	// Déplacements possibles pour le pion
    	if (c.getP().getClass().getName()=="projet.classes.Pion") {
    		
    		if (blanc==j1) {
    			if (echiquierPartie.getPlateau()[c.getNumCase()-8].isEtatCase()==false) {
    				deplacement.add(-8);
    				nbsoldir.add(1);
    			}
    			if (echiquierPartie.getPlateau()[c.getNumCase()-7].isEtatCase()==true) {
    				deplacement.add(-7);
    				nbsoldir.add(1);
    			}
    			if (echiquierPartie.getPlateau()[c.getNumCase()-9].isEtatCase()==true) {
    				deplacement.add(-9);
    				nbsoldir.add(1);
    			}	
    		}
    		
    		else {
    			if (echiquierPartie.getPlateau()[c.getNumCase()+8].isEtatCase()==false) {
    				deplacement.add(8);
    				nbsoldir.add(1);
    			}
    			if (echiquierPartie.getPlateau()[c.getNumCase()+7].isEtatCase()==true) {
    				deplacement.add(7);
    				nbsoldir.add(1);
    			}
    			if (echiquierPartie.getPlateau()[c.getNumCase()+9].isEtatCase()==true) {
    				deplacement.add(9);
    				nbsoldir.add(1);
    			}
    		}
    	}
    	
    	// Déplacements possibles pour le cavalier
    	if (c.getP().getClass().getName()=="projet.classes.Cavalier") {
    		deplacement.add(17);
    		deplacement.add(15);
    		deplacement.add(-17);
    		deplacement.add(-15);
    		deplacement.add(10);
    		deplacement.add(6);
    		deplacement.add(-10);
    		deplacement.add(-6);
    		for (int i=0; i<deplacement.size();i++) {
    			nbsoldir.add(1);
    		}  
    	}
    	
    	// Déplacements possibles pour le fou
    	if (c.getP().getClass().getName()=="projet.classes.Fou") {
    		int w=c.getNumCase();
    		/*
    		 * ddroite = possibilité de se déplacer dans la diagonale montante droite
    		 * mdroite = possibilité de se déplacer dans la diagonale descendante droite
    		 * dgauche = possibilité de se déplacer dans la diagonale montante gauche
    		 * mgauche = possibilité de se déplacer dans la diagonale descendante gauche
    		 * 
    		 * */
    		boolean ddroite = true, dgauche = true, mgauche = true, mdroite = true;
    		nbsoldir.add(0); nbsoldir.add(0); nbsoldir.add(0); nbsoldir.add(0);
    		
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
    				mdroite=false; deplacement.add(9*pos); nbsoldir.set(0,nbsoldir.get(0)+1);
    			}
    			if (mdroite==true) {
    				deplacement.add(9*pos); nbsoldir.set(0,nbsoldir.get(0)+1);
    			}
    		}
    		
    		// Teste tous les déplacements possibles dans la diagonale descendante gauche pour ne pas sortir de l'échiquier
    		for (int pos=1; pos<8; pos++) {
    			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
    			if (w+7*pos%8==7 && mgauche==false) {
    				mgauche=false;deplacement.add(7*pos);nbsoldir.set(1,nbsoldir.get(1)+1);
    			}
    			if (mgauche==true) {
    				deplacement.add(7*pos); nbsoldir.set(1,nbsoldir.get(1)+1);
    			}	
    		}
    		
    		// Teste tous les déplacements possibles dans la diagonale montante droite pour ne pas sortir de l'échiquier
    		for (int pos=1;pos<8;pos++) {
    			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
    			if (w-7*pos%8==7 && ddroite==true) {
    				ddroite=false;deplacement.add(-7*pos); nbsoldir.set(2,nbsoldir.get(2)+1);
    			}
    			if (ddroite==true) {
    				deplacement.add(-7*pos); nbsoldir.set(2,nbsoldir.get(2)+1);
    			}
    		}
    		
    		// Teste tous les déplacements possibles dans la diagonale montante gauche pour ne pas sortir de l'échiquier
    		for (int pos=1;pos<8;pos++) {
    			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
    			if (w-9*pos%8==0 && dgauche==true) {
    				dgauche=false;deplacement.add(-9*pos); nbsoldir.set(3,nbsoldir.get(3)+1);
    			}
    			if (dgauche==true) {
    				deplacement.add(-9*pos); nbsoldir.set(3,nbsoldir.get(3)+1);
    			}
    		}
    	}
    	
    	
    	// Déplacements possibles pour la tour
    	if (c.getP().getClass().getName()=="projet.classes.Tour"){
    		int w=c.getNumCase();
    		/*
    		 * gauche = possibilité de se déplacer à gauche
    		 * droite = possibilité de se déplacer droite
    		 * 
    		 * */
    		boolean droite = true, gauche = true;
    		nbsoldir.add(0); nbsoldir.add(0); nbsoldir.add(0); nbsoldir.add(0);
    		
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
    				deplacement.add(pos);
    				nbsoldir.set(0,nbsoldir.get(0)+1);
    			}
    			if (droite==true) {
    				deplacement.add(pos);
    				nbsoldir.set(0,nbsoldir.get(0)+1);
    			}
    		}
    		
    		// Teste tous les déplacements possibles vers la gauche pour ne pas sortir de l'échiquier
    		for (int pos=1;pos<=8;pos++) {
    			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
    			if (w-pos%8==0) {
    				gauche=false;
    				deplacement.add(-pos);
    				nbsoldir.set(1,nbsoldir.get(1)+1);
    			}
    			if (gauche==true) {
    				deplacement.add(-pos);
    				nbsoldir.set(1,nbsoldir.get(1)+1);
    			}
    		}
    		// Ajoute les déplacements vers le haut et le bas
    		// L'interdiction de sortir de l'échiquier est géré plus bas ( pos<0 et pos>64)
    		for (int pos=1; pos<=8; pos++) {
    			deplacement.add(-8*pos);
    			nbsoldir.set(2,nbsoldir.get(2)+1);
    		}
    		for (int pos=1; pos<=8; pos++) {
    			deplacement.add(8*pos);
    			nbsoldir.set(3,nbsoldir.get(3)+1);
    		}
    	}
    	
    	// Déplacements possibles pour la reine
    	if (c.getP().getClass().getName()=="projet.classes.Reine") {
    		int w=c.getNumCase();
    		/*
    		 * gauche = possibilité de se déplacer à gauche
    		 * droite = possibilité de se déplacer droite
    		 * 
    		 * */
    		boolean droite = true, gauche = true;
    		nbsoldir.add(0); nbsoldir.add(0); nbsoldir.add(0); nbsoldir.add(0);
    		
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
    				deplacement.add(pos);
    				nbsoldir.set(0,nbsoldir.get(0)+1);
    			}
    			if (droite==true) {
    				deplacement.add(pos);
    				nbsoldir.set(0,nbsoldir.get(0)+1);
    			}
    		}
    		
    		// Teste tous les déplacements possibles vers la gauche pour ne pas sortir de l'échiquier
    		for (int pos=1;pos<=8;pos++) {
    			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
    			if (w-pos%8==0) {
    				gauche=false;
    				deplacement.add(-pos);
    				nbsoldir.set(1,nbsoldir.get(1)+1);
    			}
    			if (gauche==true) {
    				deplacement.add(-pos);
    				nbsoldir.set(1,nbsoldir.get(1)+1);
    			}
    		}
    		// Ajoute les déplacements vers le haut et le bas
    		// L'interdiction de sortir de l'échiquier est géré plus bas ( pos<0 et pos>64)
    		for (int pos=1; pos<=8; pos++) {
    			deplacement.add(-8*pos);
    			nbsoldir.set(2,nbsoldir.get(2)+1);
    		}
    		for (int pos=1; pos<=8; pos++) {
    			deplacement.add(8*pos);
    			nbsoldir.set(3,nbsoldir.get(3)+1);
    		}
    		
    		/*
    		 * ddroite = possibilité de se déplacer dans la diagonale montante droite
    		 * mdroite = possibilité de se déplacer dans la diagonale descendante droite
    		 * dgauche = possibilité de se déplacer dans la diagonale montante gauche
    		 * mgauche = possibilité de se déplacer dans la diagonale descendante gauche
    		 * 
    		 * */
    		boolean ddroite = true, dgauche = true, mgauche = true, mdroite = true;
    		nbsoldir.add(0); nbsoldir.add(0); nbsoldir.add(0); nbsoldir.add(0);
    		
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
    				mdroite=false; deplacement.add(9*pos); nbsoldir.set(0,nbsoldir.get(0)+1);
    			}
    			if (mdroite==true) {
    				deplacement.add(9*pos); nbsoldir.set(0,nbsoldir.get(0)+1);
    			}
    		}
    		
    		// Teste tous les déplacements possibles dans la diagonale descendante gauche pour ne pas sortir de l'échiquier
    		for (int pos=1; pos<8; pos++) {
    			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
    			if (w+7*pos%8==7 && mgauche==false) {
    				mgauche=false;deplacement.add(7*pos);nbsoldir.set(1,nbsoldir.get(1)+1);
    			}
    			if (mgauche==true) {
    				deplacement.add(7*pos); nbsoldir.set(1,nbsoldir.get(1)+1);
    			}	
    		}
    		
    		// Teste tous les déplacements possibles dans la diagonale montante droite pour ne pas sortir de l'échiquier
    		for (int pos=1;pos<8;pos++) {
    			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
    			if (w-7*pos%8==7 && ddroite==true) {
    				ddroite=false;deplacement.add(-7*pos); nbsoldir.set(2,nbsoldir.get(2)+1);
    			}
    			if (ddroite==true) {
    				deplacement.add(-7*pos); nbsoldir.set(2,nbsoldir.get(2)+1);
    			}
    		}
    		
    		// Teste tous les déplacements possibles dans la diagonale montante gauche pour ne pas sortir de l'échiquier
    		for (int pos=1;pos<8;pos++) {
    			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
    			if (w-9*pos%8==0 && dgauche==true) {
    				dgauche=false;deplacement.add(-9*pos); nbsoldir.set(3,nbsoldir.get(3)+1);
    			}
    			if (dgauche==true) {
    				deplacement.add(-9*pos); nbsoldir.set(3,nbsoldir.get(3)+1);
    			}
    		}
    	}
			
			
    	// Déplacements possibles pour le roi
    	if (c.getP().getClass().getName()=="projet.classes.Roi"){
    		int w=c.getNumCase();
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
    public int deplacementPossible(Piece p,Joueur blanc){	
    	// On regarde tous les déplacements possibles (concerne toutes les pièces)
    	ArrayList<Integer> deplacementPossible = new ArrayList<Integer>();
    	int deplacementChoisi=0;
    	ArrayList<Integer> nbsoldir=p.getNbsoldir();
    	ArrayList<Integer> deplacement=p.getDeplacement();
    	int somme=0;
    	Case c=echiquierPartie.getPlateau()[p.isCase()];
    	for (int i=0;i<nbsoldir.size();i++)
    	{
    		boolean nopresent=true;
    		int pos=0;
    		while(nbsoldir.get(i)>pos) {
    			
    			// Si le déplacement sur en-dehors de l'échiquier
    			if (c.getNumCase()+deplacement.get(pos+somme)<0 || c.getNumCase()+deplacement.get(pos+somme)>64) {
    				nopresent=false;
    			}
    			
    			else {
    				if (echiquierPartie.getPlateau()[c.getNumCase()+deplacement.get(pos+somme)].isEtatCase()==true) {
    					for (int pos2=0;pos2<16;pos2++) {
    						// Si le déplacement est sur une pièce nous appartient
    						if(echiquierPartie.getPlateau()[c.getNumCase()+deplacement.get(pos+somme)].getNumCase()==echiquierPartie.getPlateau()[blanc.getPiece()[pos2].isCase()].getNumCase()) {
    							nopresent=false;
    						}
    					}
    					
    					// Si le déplacement est sur une pièce adverse, on peut la capturer mais on ne peut pas aller plus loin
    					if (nopresent==true) {
    						nopresent=false;
    						deplacementPossible.add(deplacement.get(pos+somme));    				
    					}
    				}
    			}
    			
    			// Si le déplacement n'est sur aucune pièce, on peut aller plus loin
    			if(nopresent==true) {
    				deplacementPossible.add(deplacement.get(pos+somme));
    			}
    			
    			pos++;
    			
    		}
    		somme=somme+nbsoldir.get(i);
    	}
    	// On affiche les différents déplacements possibles
    	for (int pos1=0;pos1<deplacementPossible.size();pos1++){
    		System.out.println("Choix "+pos1+" : ");
    		System.out.println(c.getNumCase()+deplacementPossible.get(pos1));
    	}
    	
    	Scanner sc=new Scanner(System.in);
		return deplacementChoisi=sc.nextInt()-c.getNumCase();
    }
    
    public void DeplacementChoisi(int deplacementChoisi,Piece p){	
    	Case c=echiquierPartie.getPlateau()[p.isCase()];
		
		if (echiquierPartie.getPlateau()[c.getNumCase()+deplacementChoisi].isEtatCase()==false) {
			echiquierPartie.getPlateau()[c.getNumCase()+deplacementChoisi].setEtatCase(true);
			echiquierPartie.getPlateau()[c.getNumCase()+deplacementChoisi].setP(c.getP());
			echiquierPartie.getPlateau()[c.getNumCase()+deplacementChoisi].getP().setCase(c.getNumCase()+deplacementChoisi);
			echiquierPartie.getPlateau()[c.getNumCase()].setP(null);
			echiquierPartie.getPlateau()[c.getNumCase()].setEtatCase(false);
		}
		else
		{
			echiquierPartie.getPlateau()[c.getNumCase()+deplacementChoisi].getP().setEtat(false);
			echiquierPartie.getPlateau()[c.getNumCase()+deplacementChoisi].getP().setCase(65);
			echiquierPartie.getPlateau()[c.getNumCase()+deplacementChoisi].setEtatCase(true);
			echiquierPartie.getPlateau()[c.getNumCase()+deplacementChoisi].setP(c.getP());
			echiquierPartie.getPlateau()[c.getNumCase()+deplacementChoisi].getP().setCase(c.getNumCase()+deplacementChoisi);
			echiquierPartie.getPlateau()[c.getNumCase()].setP(null);
			echiquierPartie.getPlateau()[c.getNumCase()].setEtatCase(false);
		}
		
		p.setCase(p.isCase()+deplacementChoisi);
    			
    }

	// Méthode pour connaître si le roi est en échec
	public boolean estEnEchec(Joueur noir) {
		boolean estpasechec=false;
		int pos=1;
		
		// On regarde sur la hauteur montante
		while(pos*8+noir.getPiece()[3].isCase()<=63 && estpasechec==false) {
			if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+pos*8].isEtatCase()==true) {
				for (int k=0;k<16;k++) {
					// Si on a une pièce allié en face, pas d'échec
					if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+pos*8].getNumCase()==noir.getPiece()[k].isCase()) {
						estpasechec=true;
					}
				}
				// Si on a une reine ou une tour adverse en face, échec
				if (estpasechec==false && (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+pos*8].getP().getClass().getName()=="projet.classes.Reine"  ||  echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+pos*8].getP().getClass().getName()=="projet.classes.Tour" )) {
					return true;
				}
			}
				pos++;
		}
		
		estpasechec=false;
		
		// On regarde sur la hauteur descendante
		while(-pos*8+noir.getPiece()[3].isCase()>=0 && estpasechec==false) {
				if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-pos*8].isEtatCase()==true) {
					for (int k=0;k<16;k++) {
						// Si on a une pièce allié en face, pas d'échec
						if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-pos*8].getNumCase()==noir.getPiece()[k].isCase()) {
							estpasechec=true;
						}
					}
					// Si on a une reine ou une tour adverse en face, échec
					if (estpasechec==false && (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-pos*8].getP().getClass().getName()=="projet.classes.Reine"  ||  echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-pos*8].getP().getClass().getName()=="projet.classes.Tour" )) {
						return true;
					}
				}
				pos++;
			}

		estpasechec=false;
		
		// On regarde sur le côté droit
		while(pos+noir.getPiece()[3].isCase()%8!=0 && estpasechec==false) {
			if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+pos].isEtatCase()==true) {
				for (int k=0;k<16;k++){
					// Si on a une pièce allié à droite, pas d'échec
					if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+pos].getNumCase()==noir.getPiece()[k].isCase()) {
						estpasechec=true;
					}
				}
				// Si on a une reine ou une tour adverse à droite, échec
				if (estpasechec==false && (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+pos].getP().getClass().getName()=="projet.classes.Reine"  ||  echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+pos].getP().getClass().getName()=="projet.classes.Tour" )) {
					return true;
				}
			}
		}
		
		estpasechec=false;
		
		// On regarde sur le côté gauche
		while(pos+noir.getPiece()[3].isCase()%8!=7 && estpasechec==false) {
			if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+pos].isEtatCase()==true) {
				for (int k=0;k<16;k++){
					// Si on a une pièce allié à gauche, pas d'échec
					if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+pos].getNumCase()==noir.getPiece()[k].isCase()) {
						estpasechec=true;
					}
				}
				// Si on a une reine ou une tour adverse à gauche, échec
				if (estpasechec==false && (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+pos].getP().getClass().getName()=="projet.classes.Reine"  ||  echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+pos].getP().getClass().getName()=="projet.classes.Tour" )) {
					return true;
				}
			}
		}
		
		estpasechec=false;
		
		// On regarde sur la diagonale descendante droite
		while((9*pos+noir.getPiece()[3].isCase()<=63 && 9*pos+noir.getPiece()[3].isCase()%8!=0) && estpasechec==false) {
			if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+9*pos].isEtatCase()==true) {
				for (int k=0;k<16;k++) {
					// Si on a une pièce allié dans la diagonale, pas d'échec
					if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+9*pos].getNumCase()==noir.getPiece()[k].isCase()) {
						estpasechec=true;
					}
				}
				// Si on a une reine ou un fou adverse dans la diagonale, échec
				if (estpasechec==false && ( echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+9*pos].getP().getClass().getName()=="projet.classes.Reine"  ||  echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+9*pos].getP().getClass().getName()=="projet.classes.Fou" )) {
					return true;
				}
			}
			pos++;
		}
		
		estpasechec=false;
		
		// On regarde sur la diagonale descendante gauche
		while((7*pos+noir.getPiece()[3].isCase()<=63 && 7*pos+noir.getPiece()[3].isCase()%8!=7) && estpasechec==false) {
			if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+7*pos].isEtatCase()==true) {
				for (int k=0;k<16;k++) {
					// Si on a une pièce allié dans la diagonale, pas d'échec
					if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+7*pos].getNumCase()==noir.getPiece()[k].isCase()) {
						estpasechec=true;
					}
				}
				// Si on a une reine ou un fou adverse dans la diagonale, échec
				if (estpasechec==false && ( echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+7*pos].getP().getClass().getName()=="projet.classes.Reine"  ||  echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+9*pos].getP().getClass().getName()=="projet.classes.Fou" )) {
					return true;
				}
			}
			pos++;
		}
		
		estpasechec=false;
		
		// On regarde sur la diagonale montante droite
		while((-7*pos+noir.getPiece()[3].isCase()<=63 && -7*pos+noir.getPiece()[3].isCase()%8!=0) && estpasechec==false) {
			if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-7*pos].isEtatCase()==true) {
				for (int k=0;k<16;k++) {
					// Si on a une pièce allié dans la diagonale, pas d'échec
					if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-7*pos].getNumCase()==noir.getPiece()[k].isCase()) {
						estpasechec=true;
					}
				}
				// Si on a une reine ou un fou adverse dans la diagonale, échec
				if (estpasechec==false && ( echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-7*pos].getP().getClass().getName()=="projet.classes.Reine"  ||  echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+9*pos].getP().getClass().getName()=="projet.classes.Fou" )) {
					return true;
				}
			}
			pos++;
		}
		
		estpasechec=false;
		
		// On regarde sur la diagonale descendante gauche
		while((-9*pos+noir.getPiece()[3].isCase()<=63 && -9*pos+noir.getPiece()[3].isCase()%8!=7) && estpasechec==false) {
			if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-9*pos].isEtatCase()==true) {
				for (int k=0;k<16;k++) {
					// Si on a une pièce allié dans la diagonale, pas d'échec
					if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-9*pos].getNumCase()==noir.getPiece()[k].isCase()) {
						estpasechec=true;
					}
				}
				// Si on a une reine ou un fou adverse dans la diagonale, échec
				if (estpasechec==false && ( echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-9*pos].getP().getClass().getName()=="projet.classes.Reine"  ||  echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+9*pos].getP().getClass().getName()=="projet.classes.Fou" )) {
					return true;
				}
			}
			pos++;
		}
		
		estpasechec=false;
		
		// On regarde le cas des pions
		if (noir==j1) {
			// On regarde dans la diagonale montante gauche s'il y a un pion
			if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-9].getP().getClass().getName()=="projet.classes.Pion") {
				for (int w=8;w<15;w++) {
					// Si on a une pièce allié dans la diagonale à côté, pas d'échec
					if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-9].getNumCase()==noir.getPiece()[w].isCase()) {
						estpasechec=true;
					}
				}
				// Sinon, c'est un pion adverse, donc échec
				if (estpasechec==false) {
					return true;
				}
			}
			
			// On regarde dans la diagonale montante droite s'il y a un pion
			if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-7].getP().getClass().getName()=="projet.classes.Pion") {
				for (int w=8;w<15;w++) {
					// Si on a une pièce allié dans la diagonale à côté, pas d'échec
					if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-7].getNumCase()==noir.getPiece()[w].isCase()) {
						estpasechec=true;
					}
				}
				// Sinon, c'est un pion adverse, donc échec
				if (estpasechec==false) {
					return true;
				}
			}
		}
		
		else {
			// On regarde dans la diagonale descendante droite s'il y a un pion
			if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+9].getP().getClass().getName()=="projet.classes.Pion") {
				for (int w=8;w<15;w++) {
					// Si on a une pièce allié dans la diagonale à côté, pas d'échec
					if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+9].getNumCase()==noir.getPiece()[w].isCase()) {
						estpasechec=true;
					}
				}
				// Sinon, c'est un pion adverse, donc échec
				if (estpasechec==false) {
					return true;
				}
			}
						
			// On regarde dans la diagonale descendante gauche s'il y a un pion
			if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+7].getP().getClass().getName()=="projet.classes.Pion") {
				for (int w=8;w<15;w++) {
					// Si on a une pièce allié dans la diagonale à côté, pas d'échec
					if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+7].getNumCase()==noir.getPiece()[w].isCase()) {
						estpasechec=true;
					}
				}
				// Sinon, c'est un pion adverse, donc échec
				if (estpasechec==false) {
					return true;
				}
			}
		}
		
		estpasechec=false;
		
		// On regarde le cas des cavaliers
		
		if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+6].isEtatCase()==true && (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+6].getP().isCase()!=noir.getPiece()[1].isCase() && echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+6].getP().isCase()!=noir.getPiece()[6].isCase())) {
			return true;
		}
		if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-6].isEtatCase()==true && (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-6].getP().isCase()!=noir.getPiece()[1].isCase() && echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-6].getP().isCase()!=noir.getPiece()[6].isCase())) {
			return true;
		}
		if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+10].isEtatCase()==true && (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+10].getP().isCase()!=noir.getPiece()[1].isCase() && echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+10].getP().isCase()!=noir.getPiece()[6].isCase())) {
			return true;
		}
		if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-10].isEtatCase()==true && (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-10].getP().isCase()!=noir.getPiece()[1].isCase() && echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-10].getP().isCase()!=noir.getPiece()[6].isCase())) {
			return true;
		}
		if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+15].isEtatCase()==true && (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+15].getP().isCase()!=noir.getPiece()[1].isCase() && echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+15].getP().isCase()!=noir.getPiece()[6].isCase())) {
			return true;
		}
		if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-15].isEtatCase()==true && (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-15].getP().isCase()!=noir.getPiece()[1].isCase() && echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-15].getP().isCase()!=noir.getPiece()[6].isCase())) {
			return true;
		}
		if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+17].isEtatCase()==true && (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+17].getP().isCase()!=noir.getPiece()[1].isCase() && echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()+17].getP().isCase()!=noir.getPiece()[6].isCase())) {
			return true;
		}
		if (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-17].isEtatCase()==true && (echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-17].getP().isCase()!=noir.getPiece()[1].isCase() && echiquierPartie.getPlateau()[noir.getPiece()[3].isCase()-17].getP().isCase()!=noir.getPiece()[6].isCase())) {
			return true;
		}
		return false;
	}
}
  