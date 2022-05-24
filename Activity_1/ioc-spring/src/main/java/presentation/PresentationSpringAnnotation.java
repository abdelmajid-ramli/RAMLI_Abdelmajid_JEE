package presentation;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import metier.IMetier;

public class PresentationSpringAnnotation {
	
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext("dao","metier");
		IMetier metier=context.getBean(IMetier.class);
		System.out.println(metier.calcul());

	}

}
