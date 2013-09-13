package org.ragna.kalin.ch01.ts;

import javax.xml.ws.Endpoint;

public class TimePublisherMultiThread {

	private Endpoint endpoint;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TimePublisherMultiThread self = new TimePublisherMultiThread();
		self.create_endpoint();
		self.configure_endpoint();
		self.publish();

	}

	private void publish() {
		int port = 8888;
		String url = String.format("http://localhost:%d/ts", port);
		endpoint.publish(url);
		System.out.println("publishing TimeServer on port: " + port);
	}

	private void create_endpoint() {
		endpoint = Endpoint.create(new TimeServerImpl());
	}

	private void configure_endpoint() {
		endpoint.setExecutor(new MyThreadPool());
	}

}
