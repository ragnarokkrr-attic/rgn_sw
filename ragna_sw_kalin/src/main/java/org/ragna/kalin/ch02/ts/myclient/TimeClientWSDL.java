package org.ragna.kalin.ch02.ts.myclient;

import org.ragna.kalin.ch02.ts.client.TimeServer;
import org.ragna.kalin.ch02.ts.client.TimeServerImplService;

public class TimeClientWSDL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// The TimeServerImplService class is the Java type bound to
		// the service section of the WSDK document
		TimeServerImplService service = new TimeServerImplService();
		
		//The TimeServer interface is the java type bound to 
		// the portType section of the WSDL document
		TimeServer  eif = service.getTimeServerImplPort();

		System.out.println(eif.getTimeAsString());
		System.out.println(eif.getTimeAsElapsed());
	}

}
