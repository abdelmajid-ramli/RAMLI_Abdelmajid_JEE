package framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dao.IDAO;
import metier.IMetier;

public class App {
	Object object;
	public App() {
		/*Class classDAO=Class.forName(daoName);
		Class classMetier=Class.forName(metierName);
		
		IDAO dao=(IDAO)classDAO.newInstance();
		IMetier metier=(IMetier)classMetier.newInstance();
		
		Method method=classMetier.getMethod("setDao", IDAO.class);
		method.invoke(metier, dao);
		System.out.println(metier.calcul());*/
	}
	
	public Object createClass(String name,String name2) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class className=Class.forName(name);
		Class className2=Class.forName(name2);
		
		Object obj1=className.newInstance();
		Object obj2=className2.newInstance();
		
		Class[] test=className.getInterfaces();
		
		//System.out.println(className2.getDeclaredFields()[0].toString().split(" ")[1]);
		
		
		String str=className2.getDeclaredFields()[0].toString().split(" ")[1];
		//String str="dao.IDAO";
		int position;
		
		for(position=0;position<test.length;position++) {
			if(test[position].getName().equals(str)) {
				break;
			}
		}
		

		Method method=className2.getMethod("setDao", test[position]);
		method.invoke(obj2, obj1);
		
		return obj2;
		//return className.newInstance();
	}

}
