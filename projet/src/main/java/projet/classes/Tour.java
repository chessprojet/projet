package projet.classes;

//Classe Tour

public class Tour extends Piece {

	// Constructeur de la Tour
	public Tour() {	
		super();				// Permet de manipuler les données de la "superclasse"
	}

	// Méthode pour l'affichage de la Tour sur la case
	public String toString() {
		return "T";
	}
	
	public void Deplacer(){
    		int w=CasePlace;
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
	}