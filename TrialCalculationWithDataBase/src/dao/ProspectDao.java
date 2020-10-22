package dao;

import java.sql.ResultSet;

import dao.impl.ProspectDaoImpl;

public abstract class ProspectDao {
	
	private String name;
	private String NIC;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNIC() {
		return NIC;
	}
	public void setNIC(String nic) {
		NIC = nic;
	}
	
	public abstract void inser(ProspectDaoImpl prospectdaoimpl);
	public abstract ResultSet select(ProspectDaoImpl prospectdaoimpl);

}
