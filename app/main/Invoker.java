package main;

import model.ManagementClass;

public class Invoker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagementClass mc = ManagementClass.getInstance();
		mc.importLiftData();
		System.out.println("here");
	}

}
