package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import dao.impl.ProspectDaoImpl;
import dao.impl.TrialDaoImpl;

public class TrialDom {
	
	public void FindRental(ProspectDaoImpl prospectDaoImpl) {
		TrialDaoImpl trialDaoImpl= new TrialDaoImpl();
		LocalDate date = LocalDate.now();
		trialDaoImpl.setDate(date.toString());
		trialDaoImpl.setcNIC(prospectDaoImpl.getNIC());
		String input;
		System.out.print(trialDaoImpl.getcNIC());
		Scanner s2= new Scanner(System.in);
		//Loan amount
		System.out.print("Enter Loan Amount : Rs.");
		input=s2.nextLine();
		while(!this.validatendouble(input)) {
			System.out.print("Enter Loan Amount : Rs.");
			input=s2.nextLine();
		}
		trialDaoImpl.setLoanAmount(new BigDecimal(input));
		//Number of periods
		System.out.print("Enter Repayment Period in months : ");
		input=s2.nextLine();
		while(!this.validatenint(input)) {
			System.out.print("Enter Repayment Period in months : ");
			input=s2.nextLine();
		}
		trialDaoImpl.setNoOfPeiriods(Integer.parseInt(input));
		
		//Interest Rate
		System.out.print("Enter Annum Interest Rate : ");
		input=s2.nextLine();
		while(!this.validatendouble(input)) {
			System.out.print("Enter Annum Interest Rate : ");
			input=s2.nextLine();
		}
		//convert to percentage
		trialDaoImpl.setInterestRate(Double.parseDouble(input)/100);
		BigDecimal x1, x2, x3;
		x1=new BigDecimal(trialDaoImpl.getInterestRate()/12).multiply(trialDaoImpl.getLoanAmount());
		x2=new BigDecimal((1-(1/Math.pow((1+trialDaoImpl.getInterestRate()/12), trialDaoImpl.getNoOfPeiriods()))));
		x3=x1.divide(x2,2, RoundingMode.CEILING);
		trialDaoImpl.setRentelAmount(x3);
		
		//save trail
		trialDaoImpl.insert(trialDaoImpl);
		
		//output
		System.out.println("");
		System.out.println("Loan Amount : Rs."+trialDaoImpl.getLoanAmount());
		System.out.println("Repayment Period : "+trialDaoImpl.getNoOfPeiriods()+" months");
		System.out.println("Annum Interest Rate : "+trialDaoImpl.getInterestRate()*100+"%");
		System.out.println("Rental Value : Rs."+trialDaoImpl.getRentelAmount());
		//trialDaoImpl.Printtable(trialDaoImpl.loanAmount, trialDaoImpl.noOfPeriods, trialDaoImpl.intrestRate,Math.round(trialDaoImpl.rental*100)/100.00);
	}
	public boolean validatendouble(String number) {
		boolean validate=true;
		int size =number.length();
		for(int index=0;index<size;index++) {
			char numberchar=number.charAt(index);
			if (numberchar=='0'||numberchar=='1'||numberchar=='2'||numberchar=='3'||numberchar=='4'||numberchar=='5'||numberchar=='6'||numberchar=='7'||numberchar=='8'||numberchar=='9'||numberchar=='.') {
				
			}
			else {
				validate=false;
				System.out.println("Wrong input");
				break;
			}
		}
		
		return validate;
	}
	
	public boolean validatenint(String number) {
		boolean validate=true;
		int size =number.length();
		for(int index=0;index<size;index++) {
			char numberchar=number.charAt(index);
			if (numberchar=='0'||numberchar=='1'||numberchar=='2'||numberchar=='3'||numberchar=='4'||numberchar=='5'||numberchar=='6'||numberchar=='7'||numberchar=='8'||numberchar=='9') {
				
			}
			else {
				validate=false;
				System.out.println("Wrong input");
				break;
			}
		}
		
		return validate;
	}

	public void printTrile() {
		TrialDaoImpl t2= new TrialDaoImpl();
		System.out.println("_____________________________________________________________________________________________");
		System.out.println("| Customer name | Date \t     | Loan Amount | No Of Periouds | Interest Rate | Rentel Amount |");
		System.out.println("_____________________________________________________________________________________________");
		ResultSet result =  t2.select();
		try {
			while (result.next()){
				System.out.println("| "+result.getString(1)+" \t| "+result.getString(2)+" | "+result.getString(3)+"    | "+result.getString(4)+" \t    | "+result.getString(5)+"%2 \t    | "+result.getString(6)+" \t    |");
			}
			System.out.println("_____________________________________________________________________________________________");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
