package projet.classes;


import java.io.*;


public class deserializerManche {
	private Partie Part;

	public deserializerManche(Partie p){
		this.Part=p;
	}
	
	public String deserializ(Manche man){
		try {
			FileInputStream fichier = new FileInputStream("Partie"+Part.getJ1()+Part.getJ2()+man.getNumTour()+".ser");
			ObjectInputStream ois = new ObjectInputStream(fichier);
			String str=(String) ois.readObject();
			return str;
			}
		catch (java.io.IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
