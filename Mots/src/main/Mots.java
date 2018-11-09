package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/***
 * 
 * @author JCV
 * 
 * L'enoncé se trouve dans la video.
 * Ameliorer le tirage des lettres
 *
 */
public class Mots {
	public static Random rnd = new Random();
	static {
		rnd.setSeed(new Date().getTime());
	}
	/**
	 * Recupere le fichier des 300000 mots dans une liste de String
	 * 
	 * @return une liste de 300000 String
	 * @throws Exception
	 */
	public static List<String> fromFile() throws Exception {
		List<String> list = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("mots/liste.de.mots.francais.frgut.txt"),StandardCharsets.ISO_8859_1));
			while(true) {
				String s = br.readLine();
				if (s == null) {
					break;
				}
				if (s.trim().length() == 0) {
					continue;
				}
				list.add(s);
			}
		} finally {
			br.close();
		}
		return list;
	}
	
	
	public static Inter getInter(List<Inter> linter,char c) {
		for (Inter inter:linter) {
			if (inter.getCarac() == c) {
				return inter;
			}
		}
		return null;
	}
	public static boolean letterGood(String mot,char c,int nb) {
		// pas de lettres double au debut
		if ((mot.length() == 1) && (mot.charAt(0) == c)) {
			return false;
		}
		//pas de lettres double à la fin
		if ((mot.length() == (nb-1)) && (mot.charAt(nb-2) == c)) {
			return false;
		}
		
		// pas plus de 2 lettres identiques
		if (mot.length() >= 2) {
			int len = mot.length()-1;
			if ((mot.charAt(len) == c) &&  (c ==  mot.charAt(len-1))) {
				return false;
			}
		}
		return true;
	}
	public static String getMot(Map<Character, List<Inter>> map,int nbLettres) {
		//first letter
		String sb = "";
		int nb = map.keySet().size();
		int pos = (int)(rnd.nextDouble()*(double)nb);
		char c = new ArrayList<>(map.keySet()).get(pos);
		sb += c;
		char currentC = c; 
		// other letter
		for (int i = 1 ; i < nbLettres ; i++) {
			double val = rnd.nextDouble();
			System.out.println(""+val);
			List<Inter> l = map.get(currentC);
			char lastC = 0;
			boolean done = false;
			for (Inter inter:l) {
				lastC = inter.getCarac();
				Double percen = inter.getValue();
				if (val < percen) {
					if (letterGood(sb,lastC,nbLettres)) {
						currentC = lastC;
						sb += currentC;
						done = true;
					} else {
						i--;
						continue;
					}
					break;
				}
			}
			// si pas trouvé on prend la plus grosse proba
			if (!done) {
				if (letterGood(sb,lastC,nbLettres)) {
					currentC = lastC;
					sb += currentC;
				} else {
					i--;
					continue;
				}
			}
		}
		return sb;
	}
	public static String toCharStandard(String s) {
		s = s.replace("é", "e");
		s = s.replace("è", "e");
		s = s.replace("ê", "e");
		s = s.replace("ë", "e");
		s = s.replace("à", "a");
		s = s.replace("ä", "a");
		s = s.replace("â", "a");
		s = s.replace("ï", "i");
		s = s.replace("î", "i");
		s = s.replace("ö", "o");
		s = s.replace("ô", "o");
		s = s.replace("ù", "u");
		s = s.replace("ü", "u");
		s = s.replace("û", "u");
		s = s.replace("ç", "c");
		
		return s;
	}
	
	public static void main(String[] args) throws Exception {
		List<String> mots = fromFile();
		// virer les mots composés et les passer en minuscules
		mots = mots.stream().filter(p -> !p.contains("-")).map(p -> p.toLowerCase()).collect(Collectors.toList());
		// virer les caracteres speciaux
		mots = mots.stream().map(p -> toCharStandard(p)).collect(Collectors.toList());
		
		// remplir les structures avec au final les occurences de chaque caractere suivant un caractere donné
		Map<Character, List<Inter>> map = new HashMap<>();
		for (String mot:mots) {
			for (int i=0 ; i < mot.length()-1; i++) {
				char c = mot.charAt(i);
				List<Inter> linter = map.get(c);
				if (linter == null) {
					linter = new ArrayList<>(); 
					map.put(c, linter);
				}
				char next = mot.charAt(i+1);
				Inter inter = getInter(linter, next);
				if (inter == null) {
					inter = new Inter(next,0.0);
					linter.add(inter);
				}
				inter.setValue(inter.getValue()+1);
			}
		}
		
		// sort (le plus faible d'abord)
		for (Character c:map.keySet()) {
			List<Inter> linter = map.get(c);
			Collections.sort(linter, new Comparator<Inter>() {
			    @Override
			    public int compare(Inter lhs, Inter rhs) {
			    	return (int)(lhs.getValue() - rhs.getValue()); 
			    }
			});
		}
		
		// stat à partir des valeurs
		for (Character c:map.keySet()) {
			List<Inter> linter = map.get(c);
			double max = 0;
			for (Inter inter:linter) {
				max += inter.getValue();
			}
			for (Inter inter:linter) {
				inter.setValue(inter.getValue()/max);
			}
		}
		
		// affichage probas
		for (Character c:map.keySet()) {
			System.out.print("<"+c+"> ");
			List<Inter> linter = map.get(c);
			for (Inter inter:linter) {
				System.out.print(inter.getCarac()+"("+inter.getValue()+")");
			}
			System.out.println();
		}
		
		// créer 40 mots de 8 lettres
		for (int i = 0 ; i < 50 ; i++) {
			System.out.println(getMot(map, 8).toUpperCase());
		}
	}
}
