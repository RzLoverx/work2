package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dao.impl.ProspectDaoImpl;


public class ProspectDom {
	
	public void getCustomerData() {
		String input;
		Scanner s1= new Scanner(System.in);
		ProspectDaoImpl p1= new ProspectDaoImpl();		
		//get customer name
		System.out.print("Enter Customer Name : ");
		p1.setName(s1.nextLine());
		
		//get and validate NIC
		System.out.print("Enter NIC Number : ");
		input=s1.nextLine();
		while(!this.validatenNIC(input)) {
			System.out.print("Enter NIC Number : ");
			input=s1.nextLine();
		}

		p1.setNIC(input);
		this.checkIsCustomerAvailabel(p1);
		TrialDom t1Dom =new TrialDom();
		t1Dom.FindRental(p1);
	}
	
	public boolean validatenNIC(String number) {
		boolean validate=true;
		int size =number.length();
		if(size==10) {
			for(int index=0;index<size;index++) {
				char numberchar=number.charAt(index);
				if (numberchar=='0'||numberchar=='1'||numberchar=='2'||numberchar=='3'||numberchar=='4'||numberchar=='5'||numberchar=='6'||numberchar=='7'||numberchar=='8'||numberchar=='9'||numberchar=='v') {		
				}
				else {
					validate=false;
					System.out.println("Wrong input");
					break;
				}
			}
		}
		else {
			validate= false;
		}
		
		return validate;
	}
	public void checkIsCustomerAvailabel(ProspectDaoImpl prospectDaoimpl)  {
		try {
			ResultSet result = prospectDaoimpl.select(prospectDaoimpl);
			if(result.next()) {
				
			}
			else {
				System.out.println("New Customer");
				prospectDaoimpl.inser(prospectDaoimpl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
