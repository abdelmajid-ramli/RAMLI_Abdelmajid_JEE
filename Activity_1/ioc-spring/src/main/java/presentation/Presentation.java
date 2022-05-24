package presentation;

import dao.DAOIMP;
import metier.MetierIMP;

public class Presentation {

	public static void main(String[] args) {
		
		// version statique
		DAOIMP dao=new DAOIMP();
		MetierIMP metier=new MetierIMP();
		metier.setDao(dao);
		System.out.println("resultat : "+metier.calcul());
		
	}

}
