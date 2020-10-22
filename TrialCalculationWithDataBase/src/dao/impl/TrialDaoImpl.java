package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connections.JDBCCon;
import dao.TrialDao;

public class TrialDaoImpl extends TrialDao {
	private String readSummary="SELECT customer.Name ,trial.Date ,trial.LoanAmount, trial.NoOfPeiriods ,trial.IR ,trial.Rental FROM customer,trial WHERE customer.NIC=trial.CNIC;";
	private String write="INSERT INTO `trial` (`CNIC`, `Date`, `LoanAmount`, `NoOfPeiriods`, `IR`, `Rental`, `TrialID`) VALUES (?, ?, ?, ?, ?, ?, NULL);";

	@Override
	public void insert(TrialDaoImpl trialDaoImpl) {
		JDBCCon newj=new JDBCCon();
		Connection conn= newj.get_connection();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(this.write);
			statement.setString(1, trialDaoImpl.getcNIC());
			statement.setString(2, trialDaoImpl.getDate());
			statement.setBigDecimal(3, trialDaoImpl.getLoanAmount());
			statement.setInt(4, trialDaoImpl.getNoOfPeiriods());
			statement.setDouble(5, trialDaoImpl.getInterestRate()*100);
			statement.setBigDecimal(6, trialDaoImpl.getRentelAmount());	 
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("");
				System.out.println("Your Trail Calculation is save ");
			}
			else {
				System.out.println("");
				System.out.println("Your Trail Calculation isn't save ");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet select() {
		ResultSet result=null;	
		JDBCCon newj=new JDBCCon();
		Connection conn= newj.get_connection();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(this.readSummary);
			result = statement.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}



}
