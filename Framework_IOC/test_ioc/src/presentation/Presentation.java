package presentation;

import java.lang.reflect.InvocationTargetException;

import dao.IDAO;
import framework.App;
import metier.IMetier;

public class Presentation {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		App app=new App();
		/*IDAO dao=(IDAO)app.createClass("dao.IdaoImp");
		System.out.println(dao.address());*/
		
		IMetier metier=(IMetier)app.createClass("dao.IdaoImp","metier.IMetierImp");
		metier.show();
	}

}
