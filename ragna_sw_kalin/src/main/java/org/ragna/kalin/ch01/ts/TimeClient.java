package org.ragna.kalin.ch01.ts;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TimeClient {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		System.getProperties().setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		
		
		URL url = new URL("http://localhost:9876/ts?wsdl");
		
		//Qualified name of the service:
		//	URI (from targetNamespace) + Service name published in WSDL 
		QName qname = new QName("http://ts.ch01.kalin.ragna.org/","TimeServerImplService");
		
		//Create a factory for the service
		Service service = Service.create(url, qname);
		
		//Extract the endpoint interface, the service "port"
		TimeServer eif = service.getPort(TimeServer.class);
		
		
		for (int i = 0; i < 100; i++) {
			System.out.println("Time as string: " + eif.getTimeAsString());
			System.out.println("Time as elapsed: " + eif.getTimeAsElapsed());
			
			
			Thread.sleep(1* 1000);
			
		}
		
	}

}
