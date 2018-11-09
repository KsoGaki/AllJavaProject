package fr.afpa.stage.tools;

import java.io.IOException;

import fr.afpa.stage.tools.Mp3ManagerException;
import fr.afpa.stage.tools.Mp3Manager;

/**
 * 
 * @author 1802448
 *
 *
 * Lire les tags d'un mp3
 */
public class Mp3 {

	public static void main(String[] args)  {
		try {
			Mp3Manager mp = new Mp3Manager("file/muzik.mp3");
			String tag = mp.getTag().trim();
			String titre = mp.getTitle().trim();
			String auteur = mp.getArtist().trim();
			String album = mp.getAlbum().trim();
			String annee = mp.getYear().trim();
			String comment = mp.getComment().trim();
			int style = (int)mp.getGenre().charAt(0);
			System.out.println("Tag: "+tag
							  +"\nTitle: "+titre
							  +"\nArtist: "+auteur
							  +"\nAlbum: "+album
							  +"\nYear: "+annee
							  +"\nComment: "+comment
							  +"\nGenre: "+style
							  + "\n");

			mp.setTitle("Le petit lapin");
			mp.setArtist("Moi-meme");
			mp.setAlbum("Au pays des bestioles");
			mp.setYear("1964");
			mp.setGenre("y");
			mp.write();
			// verifier
			mp.read();
			System.out.println(mp.toString());
			// remettre les valeurs d'origine
			mp.setTitle(titre);
			mp.setArtist(auteur);
			mp.setAlbum(album);
			mp.setYear(annee);
			mp.setGenre((char)style + "");
			mp.write();
			// Reverified
			mp.read();
			System.out.println(mp.toString());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Mp3ManagerException me) {
			me.printStackTrace();
		} finally {
			try {
				Mp3Manager.getRandomAccessFile().close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
