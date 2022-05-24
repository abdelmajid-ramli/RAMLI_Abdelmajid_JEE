package dao;

import org.springframework.stereotype.Component;

@Component("dao")
public class DAOIMP implements IDAO {


	public double getData() {
		System.out.println("version DB");
		double data=5;
		return data;
	}

}
