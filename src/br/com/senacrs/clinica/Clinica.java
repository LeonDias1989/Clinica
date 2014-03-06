package br.com.senacrs.clinica;

import java.util.Scanner;

import br.com.senacrs.clinica.actions.MainAction;

public class Clinica {
	
	public Clinica(){}
	
	public static void main(String[] args) {
		try {
			new Clinica().run(args);
		} catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
		System.exit(0);
	}
	
	private void run(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		new MainAction(sc).menu();
		sc.close();
	}

}
