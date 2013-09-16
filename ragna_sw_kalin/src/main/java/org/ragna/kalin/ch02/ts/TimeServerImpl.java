package org.ragna.kalin.ch02.ts;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.ragna.kalin.ch02.ts.client.TimeServer;

/**
* The @WebService property endpointInterface links the
* SIB (this class) to the SEI (ch01.ts.TimeServer).
* Note that the method implementations are not annotated
* as @WebMethods.
*/
@WebService(endpointInterface = "org.ragna.kalin.ch02.ts.TimeServer")
public class TimeServerImpl implements TimeServer{

	@Override
	@WebMethod
	public String getTimeAsString() {
		return new Date().toString();
	}

	@Override
	@WebMethod
	public long getTimeAsElapsed() {
		return new Date().getTime();
	}
	
}
