package org.ragna.kalin.ch02.ts;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
* The annotation @WebService signals that this is the
* SEI (Service Endpoint Interface). @WebMethod signals 
* that each method is a service operation.
*
* The @SOAPBinding annotation impacts the under-the-hood
* construction of the service contract, the WSDL
* (Web Services Definition Language) document. Style.RPC
* simplifies the contract and makes deployment easier.
*/
@WebService
// @SOAPBinding(style = Style.RPC)
// Style.DOCUMENT takes effect
public interface TimeServer {
	@WebMethod 
	@WebResult(partName = "time_response") 
	// replaces * return * in original WSDL
	String getTimeAsString();

	@WebMethod 
	@WebResult(partName = "time_response")
	long getTimeAsElapsed();
	
}
