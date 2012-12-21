package projet.classes;


import java.io.*;


public class serializerManche {
	private Partie Part;

	public serializerManche(Partie p){
		this.Part=p;
	}
	
	public void serializ(int deplacementChoisi){
		try {
			FileOutputStream fichier = new FileOutputStream("Partie"+Part.getJ1()+Part.getJ2()+".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fichier);
			String t="";
			if (0<=deplacementChoisi && deplacementChoisi<8){t="1";}
			if (8<=deplacementChoisi && deplacementChoisi<16){t="2";}
			if (16<=deplacementChoisi && deplacementChoisi<24){t="3";}
			if (24<=deplacementChoisi && deplacementChoisi<32){t="4";}
			if (32<=deplacementChoisi && deplacementChoisi<40){t="5";}
			if (40<=deplacementChoisi && deplacementChoisi<48){t="6";}
			if (48<=deplacementChoisi && deplacementChoisi<56){t="7";}
			if (56<=deplacementChoisi && deplacementChoisi<64){t="8";}
			if (deplacementChoisi%8==1){t="A-"+t;}
			if (deplacementChoisi%8==2){t="B-"+t;}
			if (deplacementChoisi%8==3){t="C-"+t;}
			if (deplacementChoisi%8==4){t="D-"+t;}
			if (deplacementChoisi%8==5){t="E-"+t;}
			if (deplacementChoisi%8==6){t="F-"+t;}
			if (deplacementChoisi%8==7){t="G-"+t;}
			if (deplacementChoisi%8==8){t="I-"+t;}
			oos.writeObject(t);
			oos.flush();
			oos.close();
			}
		catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
}
