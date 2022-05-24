package metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.IDAO;

@Component
public class MetierIMP implements IMetier {
	@Autowired
	private IDAO dao;
	
	
	/*
	public MetierIMP(IDAO dao) {
		this.dao = dao;
	}*/

	public double calcul() {
		double data=dao.getData();
		double res=data*2;
		return res;
	}
	
	public void setDao(IDAO dao) {
		this.dao = dao;
	}
	
	

}
