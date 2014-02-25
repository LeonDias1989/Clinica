package br.com.senacrs.clinica.library;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ActionController {

	protected Scanner sc = null;
	protected static PrintStream out = null;
	
	public ActionController(Scanner sc){
		this.sc = sc;
		if(ActionController.out == null)
			ActionController.out = System.out;
	}
	
	protected void pause(){
		try {
			out.println("Precione Enter para continuar");
			System.in.read();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
