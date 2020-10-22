package service.impl;

import java.util.Scanner;

import dao.impl.ProspectDaoImpl;
import dao.impl.TrialDaoImpl;
import domain.ProspectDom;
import domain.TrialDom;

public class Main {

	public static void main(String[] args) {
		String input;
		Scanner s1= new Scanner(System.in);
		ProspectDom pd=new ProspectDom();
		TrialDom td= new TrialDom();
		System.out.println();
		System.out.println("\t | Enter 1 For Do a Trail Calculation");
		System.out.println("\t | Enter 2 For Look Trail Calculation Summary");
		System.out.println("\t | Enter 3 For Do a Exit");
		System.out.println();
		System.out.print("Enter you choice : ");
		input=s1.nextLine();
		int x=1;
		while(x>0) {
			if(input.equals("1")) {
				System.out.println("You select Do a Trail Calculation ");
				pd.getCustomerData();
				System.out.println("");
				
			}
			else if(input.equals("2")) {
				System.out.println("You select Look Trail Calculation Summary ");
				td.printTrile();
				System.out.println("");
				
			}
			else if(input.equals("3")){
				x=-1;
				break;
			}
			else {
				System.out.println("wrong input");
				System.out.println("");
				
			}
			System.out.println("------------------------------- New Sesion -------------------------------------------");
			System.out.println();
			System.out.println("\t | Enter 1 For Do a Trail Calculation");
			System.out.println("\t | Enter 2 For Look Trail Calculation Summary");
			System.out.println("\t | Enter 3 For Do a Exit");
			System.out.println();
			System.out.print("Enter you choice : ");
			input=s1.nextLine();
				
		}
		s1.close();
		System.out.println();
		System.out.println("system off");
	}
}
