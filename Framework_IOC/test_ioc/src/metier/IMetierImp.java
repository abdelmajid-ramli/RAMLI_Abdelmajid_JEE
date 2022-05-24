package metier;

import dao.IDAO;

public class IMetierImp implements IMetier{
	
	private IDAO dao;

	@Override
	public void show() {
		System.out.println(dao.address());
	}
	
	public void setDao(IDAO dao2) {
		this.dao=dao2;
	}

}
