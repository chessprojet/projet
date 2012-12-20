package projet.classes;


import java.io.*;


public class serializerManche {
	private Partie Part;

	public serializerManche(Partie p){
		this.Part=p;
	}
	
	public void serializ(Manche man){
		try {
			FileOutputStream fichier = new FileOutputStream("Partie"+Part.getJ1()+Part.getJ2()+man.getNumTour()+".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fichier);
			oos.writeObject(this.Part.getEchiquierPartie().getPlateau().toString());
			oos.flush();
			oos.close();
			}
		catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
}
