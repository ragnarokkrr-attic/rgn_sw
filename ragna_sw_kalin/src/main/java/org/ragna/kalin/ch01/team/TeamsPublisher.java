package org.ragna.kalin.ch01.team;

import javax.xml.ws.Endpoint;

public class TeamsPublisher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int port = 8888;
		String url = String.format("http://localhost:%d/teams", port);

		System.out.println("Publishing Teams on port: " + port);
		
		Endpoint.publish(url, new Teams());
		
	}

}
