package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connections.JDBCCon;
import dao.ProspectDao;

public class ProspectDaoImpl extends ProspectDao {
	private String readNIC="SELECT * FROM `customer` WHERE `NIC`=?;";
	private String write="INSERT INTO `customer` (`Name`, `NIC`) VALUES (?, ?);";

	@Override
	public void inser(ProspectDaoImpl prospectdaoimpl) {
		JDBCCon newj=new JDBCCon();
		Connection conn= newj.get_connection();		
		try {
			PreparedStatement statement = conn.prepareStatement(this.write);
			statement.setString(1, prospectdaoimpl.getName());
			statement.setString(2, prospectdaoimpl.getNIC());
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Prospect Saved");
			}
			else {
				System.out.println("Prospect Save fail");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public ResultSet select(ProspectDaoImpl prospectdaoimpl) {
		ResultSet result=null;	
		JDBCCon newj=new JDBCCon();
		Connection conn= newj.get_connection();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(this.readNIC);
			statement.setString(1, prospectdaoimpl.getNIC());
			result = statement.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
		
	}

}
