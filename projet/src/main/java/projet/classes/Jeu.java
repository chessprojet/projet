package projet.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;

// Classe Jeu permettant le lancement du jeu

public class Jeu {
	
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
		//}
		
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
		/*final Manche man=new Manche(j2,pa1);
		
		int d=30000;//temps a mettre ici
		
		boolean finDePartie=false;
		while(finDePartie==false){
			if(man.getJ()==j1){
				man.setJ(j2);
			}
			else{
				man.setJ(j1);
			}
			final Manche manprim=man;
			final Joueur j1prim=j1;
			final Joueur j2prim=j2;
			ActionListener calcul=new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
					
				}
				
			};
			javax.swing.Timer t = new javax.swing.Timer(d, calcul);
			t.restart();
			man.jouerManche();
			t.stop();
			boolean finDePartie2=man.finDeManche();
			if (finDePartie2==true){finDePartie=true;}
			man.finDeManche();
		}*/		

		
		// Affichage de l'échiquier

		pa1.getEchiquierPartie().toString();
		}
	}
}