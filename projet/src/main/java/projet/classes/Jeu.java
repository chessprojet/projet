package projet.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Timer;

// Classe Jeu permettant le lancement du jeu

public class Jeu {
	private Partie pa1;
	public Jeu(Partie p){
		this.pa1=p;
	}
	public boolean estEnPat(Joueur noir) {
 		if (this.pa1.estEnEchec(noir, -9)==true && this.pa1.estEnEchec(noir, -8)==true && this.pa1.estEnEchec(noir, -7)==true && this.pa1.estEnEchec(noir, -1)==true && this.pa1.estEnEchec(noir, 1)==true && this.pa1.estEnEchec(noir, 7)==true && this.pa1.estEnEchec(noir, 8)==true && this.pa1.estEnEchec(noir, 9)==true) {
 			for (int k=0;k<15;k++){
 				noir.getPiece()[k].deplacer(pa1, noir);
 				if (k!=3 && pa1.deplacementPossible(noir.getPiece()[k], noir)!=null){return false;}
 			}
 			return true;
 		}
 		else {
 			return false;
 		}
 	}
 	
 	public boolean estEchecMat(Joueur noir) {
 		
 		if (this.pa1.estEnEchec(noir, 0)==true && this.pa1.estEnEchec(noir, -9)==true && this.pa1.estEnEchec(noir, -8)==true && this.pa1.estEnEchec(noir, -7)==true && this.pa1.estEnEchec(noir, -1)==true && this.pa1.estEnEchec(noir, 1)==true && this.pa1.estEnEchec(noir, 7)==true && this.pa1.estEnEchec(noir, 8)==true && this.pa1.estEnEchec(noir, 9)==true) {
 			
 			for (int k=0;k<15;k++){
 				noir.getPiece()[k].deplacer(pa1, noir);
 				if (k!=3){
 					ArrayList<Integer> dp=pa1.deplacementPossible(noir.getPiece()[k], noir);
 					for (int pos=0;pos<dp.size();pos++){
 						if (this.pa1.getEchiquierPartie().getPlateau()[dp.get(pos)].isEtatCase()==false){
 							this.pa1.getEchiquierPartie().getPlateau()[dp.get(pos)].setP(new Pion());
 							if(this.pa1.estEnEchec(noir, 0)==false){
 								this.pa1.getEchiquierPartie().getPlateau()[dp.get(pos)].setEtatCase(false);
 								return false;
 							}
 							this.pa1.getEchiquierPartie().getPlateau()[dp.get(pos)].setEtatCase(false);
 						}
 						else {
 							Piece p=this.pa1.getEchiquierPartie().getPlateau()[dp.get(pos)].getP();
 							this.pa1.getEchiquierPartie().getPlateau()[dp.get(pos)].setEtatCase(false);
 							this.pa1.getEchiquierPartie().getPlateau()[dp.get(pos)].setP(null);
 							if (this.pa1.estEnEchec(noir, 0)==false){
 								this.pa1.getEchiquierPartie().getPlateau()[dp.get(pos)].setP(p);
 								return false;
 							}
 							this.pa1.getEchiquierPartie().getPlateau()[dp.get(pos)].setP(p);
 						}
 					}
 				}
 			}
 			return true;
 		}
 		else {
 			return false;
 		}
 	}
	
	public static void main(String[] args) {
		
		// Choix Lancer Nouvelle Partie ou Règles du jeu ou Quitter
		
		// Lancer Nouvelle Partie à coupler avec l'interface
		
		Joueur j1 = new Joueur();
		Joueur j2 = new Joueur();
		Echiquier e1 = new Echiquier();
		
		// Choix du nom des Joueurs et de l'activation de l'aide
		j1.choixNom();
		j1.choixAide();
		j2.choixNom();
		j2.choixAide();
		System.out.println("Nom du Joueur 1 : "+j1.getNom());
		System.out.println("Aide du Joueur 1 : "+j1.isAide());
		System.out.println("Nom du Joueur 2 : "+j2.getNom());
		System.out.println("Aide du Joueur 2 : "+j2.isAide());
		
		// Choix de la variante
		e1.choixVariante();
		System.out.println("Variante choisie : "+e1.getVariante());
		
		// Création de la Partie
		
		Partie pa1 = new Partie(j1, j2, e1);
		Jeu game=new Jeu(pa1);
		// Mise en place de l'échiquier
		
		/* Variante de jeu : Classique
		 * Placement classique des différentes pièces
		 */
		if (e1.getVariante()=="Classique") {
			
			// Placement des pièces sur les cases
			for (int i=0;i<16;i++)
			{	
				pa1.getEchiquierPartie().getPlateau()[i].setP(pa1.getJ2().getPiece()[i]);
				pa1.getEchiquierPartie().setCase(pa1.getEchiquierPartie().getPlateau()[i], i);
				pa1.getJ2().getPiece()[i].setCase(i);
			}
			
			for (int i=16;i<48;i++)
			{
				pa1.getEchiquierPartie().setCase(pa1.getEchiquierPartie().getPlateau()[i],i);
			}
			
			for (int i=48;i<56;i++)
			{
				pa1.getEchiquierPartie().getPlateau()[i].setP(pa1.getJ1().getPiece()[i-40]);
				pa1.getEchiquierPartie().setCase(pa1.getEchiquierPartie().getPlateau()[i], i);
				pa1.getJ1().getPiece()[i-40].setCase(i);
			}
			
			for (int i=56;i<64;i++)
			{
				pa1.getEchiquierPartie().getPlateau()[i].setP(pa1.getJ1().getPiece()[i-56]);
				pa1.getEchiquierPartie().setCase(pa1.getEchiquierPartie().getPlateau()[i], i);
				pa1.getJ1().getPiece()[i-56].setCase(i);
			}
		}
		
		/* Variante de jeu : Chess960
		 * Placement aléatoire de toutes les pièces pour chaque joueur
		 */
		if (e1.getVariante()=="Chess960") {
			
			// Création d'une liste aléatoire pour gérer le placement aléatoire de toutes les pièces
			ArrayList<Integer> liste = new ArrayList<Integer>();
			for (int i=0;i<16;i++) {
				liste.add(i);
			}
			Collections.shuffle(liste);
			
			// Placement des pièces sur les cases
			for (int i=0;i<16;i++)
			{	
				pa1.getEchiquierPartie().getPlateau()[i].setP(pa1.getJ2().getPiece()[liste.get(i)]);
				pa1.getEchiquierPartie().setCase(pa1.getEchiquierPartie().getPlateau()[i], i);
				pa1.getJ2().getPiece()[liste.get(i)].setCase(i);
			}
			
			for (int i=16;i<48;i++)
			{
				pa1.getEchiquierPartie().setCase(pa1.getEchiquierPartie().getPlateau()[i],i);
			}
			
			for (int i=48;i<56;i++)
			{
				pa1.getEchiquierPartie().getPlateau()[i].setP(pa1.getJ1().getPiece()[liste.get(i-40)]);
				pa1.getEchiquierPartie().setCase(pa1.getEchiquierPartie().getPlateau()[i], i);
				pa1.getJ1().getPiece()[liste.get(i-40)].setCase(i);
			}
			
			for (int i=56;i<64;i++)
			{
				pa1.getEchiquierPartie().getPlateau()[i].setP(pa1.getJ1().getPiece()[liste.get(i-56)]);
				pa1.getEchiquierPartie().setCase(pa1.getEchiquierPartie().getPlateau()[i], i);
				pa1.getJ1().getPiece()[liste.get(i-56)].setCase(i);
			}
		}
		
		/* Variante de jeu : D-Chess
		 * Placement aléatoire de la dernière ligne de pièce pour chaque joueur
		 */
		if (e1.getVariante()=="D-Chess") {
			
			// Création d'une liste aléatoire pour gérer le placement aléatoire des pièces autres que les pions
			ArrayList<Integer> liste = new ArrayList<Integer>();
			for (int i=0;i<8;i++) {
				liste.add(i);
			}
			Collections.shuffle(liste);
			
			// Placement des pièces sur les cases
			for (int i=0;i<8;i++)
			{	
				pa1.getEchiquierPartie().getPlateau()[i].setP(pa1.getJ2().getPiece()[liste.get(i)]);
				pa1.getEchiquierPartie().setCase(pa1.getEchiquierPartie().getPlateau()[i], i);
				pa1.getJ2().getPiece()[liste.get(i)].setCase(i);
			}
			for (int i=8;i<16;i++)
			{	
				pa1.getEchiquierPartie().getPlateau()[i].setP(pa1.getJ2().getPiece()[i]);
				pa1.getEchiquierPartie().setCase(pa1.getEchiquierPartie().getPlateau()[i], i);
				pa1.getJ2().getPiece()[i].setCase(i);
			}
			for (int i=16;i<48;i++)
			{
				pa1.getEchiquierPartie().setCase(pa1.getEchiquierPartie().getPlateau()[i],i);
			}
			
			for (int i=48;i<56;i++)
			{
				pa1.getEchiquierPartie().getPlateau()[i].setP(pa1.getJ1().getPiece()[i-40]);
				pa1.getEchiquierPartie().setCase(pa1.getEchiquierPartie().getPlateau()[i], i);
				pa1.getJ1().getPiece()[i].setCase(i);
			}
			
			for (int i=56;i<64;i++)
			{
				pa1.getEchiquierPartie().getPlateau()[i].setP(pa1.getJ1().getPiece()[liste.get(i-56)]);
				pa1.getEchiquierPartie().setCase(pa1.getEchiquierPartie().getPlateau()[i], i);
				pa1.getJ1().getPiece()[liste.get(i-56)].setCase(i);
			}
		}
		Manche man=new Manche(pa1.getJ1(),pa1);

		int d=30000;//temps a mettre ici
		
		boolean finDePartie=false;
		boolean finDeManche = false;
		while(finDePartie==false){
			/*ActionListener calcul=new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
					man.finDeManche();

				}
				
			};
			javax.swing.Timer t = new javax.swing.Timer(d, calcul);*/
			//t.restart();
			man.jouerManche(finDeManche);
			//t.stop();
			man.finDeManche();
			
			finDePartie=game.estEchecMat(man.getJ());
			/*System.out.println(pa1.estEnEchec(man.getJ(), -9)+"hj");
			System.out.println("po"+ pa1.estEnEchec(man.getJ(), -8));*/
			//System.out.println("ki"+pa1.estEnEchec(man.getJ(), -7));
			/*System.out.println("lpopoo"+pa1.estEnEchec(man.getJ(), -1));
			System.out.println("fddfdfdfd"+pa1.estEnEchec(man.getJ(), 1));
			System.out.println("ppoopopooppo"+pa1.estEnEchec(man.getJ(), 7));
			System.out.println("lpllplplplpl-"+pa1.estEnEchec(man.getJ(), 8));*/
			//System.out.println("tye"+pa1.estEnEchec(man.getJ(), 9));
			if (finDePartie==false){
				finDePartie=game.estEnPat(man.getJ());
			}
			if (finDePartie==false){
				finDeManche=pa1.estEnEchec(man.getJ(),0);
			}
			
			
			
				
				
			}
		//mettre un affichage 
		System.out.println("Voulez-vous revoir la partie ?1.0 2.N");
		Scanner sc=new Scanner(System.in);
		int rep=sc.nextInt();
		if (rep==1){// Affichage de l'échiquier
			String partieJouee="";
			deserializerManche dm=new deserializerManche(pa1);
			for (int g=0;g<man.getNumTour();g--){
				partieJouee=partieJouee+"\n"+dm.deserializ(man);
			System.out.println(dm);
			}
		}
	}
}