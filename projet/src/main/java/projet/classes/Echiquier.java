package projet.classes;

import java.util.Scanner;

// Classe Echiquier

public class Echiquier {
	
	public Case plateau[]= new Case[64];		// Création d'un tableau "plateau" de 64 objets Case
	public String variante="";					// Variante du jeu d'échec
	
	// Constructeur de l'Echiquier
	public Echiquier() {
		for (int pos=0;pos<64;pos++)
			this.plateau[pos]=new Case(pos);
	}
	
	// Setter d'une Case associée au plateau de jeu
	public void setCase(Case b,int position) {
		this.plateau[position]=b;
	}
	
	// Getter d'une Case associée au plateau de jeu
	public Case[] getPlateau() {
		return plateau;
	}
	
	// Setter de la variante de jeu
	public void setVariante(String variante) {
		this.variante = variante;
	}
	
	// Getter de la variante de jeu
	public String getVariante() {
		return variante;
	}
	
	// Affichage de l'Echiquier
	public String toString(){
		String a="";
		for (int i=0;i<8;i++)
		{
			for (int g=0;g<8;g++)
			{
				a=a+(plateau[i*8+g]).toString();
			}
			a=a+"\n";
		}
		System.out.println(a);
		return a;
	}
	
	// Méthode du choix de la variante d'échec
	public void choixVariante() {
		System.out.println("A quelle variante voulez-vous jouer ?");
		Scanner sc = new Scanner(System.in);
		int var=sc.nextInt();
		if (var==1) {
			this.variante="Classique";
		}
		if (var==2) {
			this.variante="Chess960";
		}
		if (var==3) {
			this.variante="D-Chess";
		}
	}
	
}