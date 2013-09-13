package org.ragna.kalin.ch01.ts;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DemoSoap {
	private static final String LOCAL_NAME = "TimeRequest";
	private static final String NAMESPACE = "http://ts.ch01.kalin.ragna.org/mysoap/";
	private static final String NAMESPACE_PREFIX = "ms";

	private ByteArrayOutputStream out;
	private ByteArrayInputStream in;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new DemoSoap().request();
	}

	private void request() {
		try {
			// Build a SOAP message to send to an output stream
			SOAPMessage msg = create_soap_message();
			// Inject the appropriate information into the message
			// In this case, only the (optional) message header is used
			// and the body is empty.
			SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
			SOAPHeader hdr = env.getHeader();

			// Add an element to the SOAP header/
			Name lookup_name = create_qname(msg);
			hdr.addHeaderElement(lookup_name).addTextNode("time_request");

			// Simulate sending the SOAP message to a remote system by
			// writing it to BAOS
			out = new ByteArrayOutputStream();
			msg.writeTo(out);

			trace("The sent SOAP message: ", msg);

			SOAPMessage response = process_request();

			extract_contents_and_print(response);

		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void extract_contents_and_print(SOAPMessage msg) {
		try {
			SOAPBody body = msg.getSOAPBody();

			Name lookup_name = create_qname(msg);
			Iterator it = body.getChildElements(lookup_name);
			Node next = (Node) it.next();
			String value = (next == null) ? "Error!" : next.getValue();
			System.out.println("\n\n Return from server: " + value);

		} catch (SOAPException e) {
			e.printStackTrace();
		}
	}

	private SOAPMessage process_request() {
		process_incoming_soap();
		coordinate_streams();
		return create_soap_message(in);
	}

	private SOAPMessage create_soap_message(InputStream in) {
		SOAPMessage msg = null;

		MessageFactory mf;
		try {
			mf = MessageFactory.newInstance();
			msg = mf.createMessage(null, in);

		} catch (SOAPException | IOException e) {
			e.printStackTrace();
		}

		return msg;
	}

	private void process_incoming_soap() {
		try {
			// Copy output stream to input stream to simulate
			// coordinated streams over a network connection.
			coordinate_streams();

			// Create the "received" SOAP message from the
			// input stream.
			SOAPMessage msg = create_soap_message(in);

			// Inspect the SOAP header for the keyword 'time_request'
			// and process the request if the keyword occurs.
			Name lookup_name = create_qname(msg);

			SOAPHeader header;
			header = msg.getSOAPHeader();
			Iterator it = header.getChildElements(lookup_name);
			Node next = (Node) it.next();
			String value = (next == null) ? "Error!" : next.getValue();

			// If SOAP message contains request for the time, create a
			// new SOAP message with the current time in the body.
			if (value.toLowerCase().contains("time_request")) {
				// Extract the body and add the current time as an element.
				String now = new Date().toString();
				SOAPBody body = msg.getSOAPBody();
				body.addBodyElement(lookup_name).addTextNode(now);
				msg.saveChanges();

				// Write to the output stream.
				msg.writeTo(out);
				trace("The received/processed SOAP message: ", msg);
			}

		} catch (SOAPException | IOException e) {
			e.printStackTrace();
		}
	}

	private void coordinate_streams() {
		in = new ByteArrayInputStream(out.toByteArray());
		out.reset();
	}

	private void trace(String m, SOAPMessage msg) {
		System.out.println("\n");
		System.out.println(m);
		try {
			// msg.writeTo(System.out);
			ByteArrayOutputStream docByteOut = new ByteArrayOutputStream();
			msg.writeTo(docByteOut);

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(false);
			dbf.setNamespaceAware(false);
			DocumentBuilder db = dbf.newDocumentBuilder();

			//new String
			Document doc = db.parse(new InputSource(new ByteArrayInputStream(docByteOut.toByteArray())));

			Transformer tf = TransformerFactory.newInstance().newTransformer();
			tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tf.setOutputProperty(OutputKeys.INDENT, "yes");

			Writer out = new StringWriter();
			tf.transform(new DOMSource(doc), new StreamResult(out));

			System.out.println(out.toString());

		} catch (SOAPException | IOException | ParserConfigurationException
				| SAXException | TransformerFactoryConfigurationError
				| TransformerException e) {
			e.printStackTrace();
		}
	}

	private Name create_qname(SOAPMessage msg) {
		Name name = null;
		try {
			SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
			name = env.createName(LOCAL_NAME, NAMESPACE_PREFIX, NAMESPACE);
		} catch (SOAPException e) {
			e.printStackTrace();
		}
		return name;
	}

	private SOAPMessage create_soap_message() {
		SOAPMessage msg = null;

		MessageFactory mf;
		try {
			mf = MessageFactory.newInstance();
			msg = mf.createMessage();
		} catch (SOAPException e) {
			e.printStackTrace();
		}

		return msg;
	}
}
