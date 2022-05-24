package presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.IDAO;
import metier.IMetier;

public class Presentation2 {

	public static void main(String[] args) {
		// version dynamique
		try {
			Scanner input=new Scanner(new File("src/config.txt"));
			String daoName=input.nextLine();
			String metierName=input.nextLine();
			
			Class classDAO=Class.forName(daoName);
			Class classMetier=Class.forName(metierName);
			
			IDAO dao=(IDAO)classDAO.newInstance();
			IMetier metier=(IMetier)classMetier.newInstance();
			
			Method method=classMetier.getMethod("setDao", IDAO.class);
			method.invoke(metier, dao);
			System.out.println(metier.calcul());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
