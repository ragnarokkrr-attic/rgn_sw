
package org.ragna.kalin.ch02.ts.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TimeServerImplService", targetNamespace = "http://ts.ch02.kalin.ragna.org/", wsdlLocation = "http://localhost:9876/ts?wsdl")
public class TimeServerImplService
    extends Service
{

    private final static URL TIMESERVERIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException TIMESERVERIMPLSERVICE_EXCEPTION;
    private final static QName TIMESERVERIMPLSERVICE_QNAME = new QName("http://ts.ch02.kalin.ragna.org/", "TimeServerImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9876/ts?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TIMESERVERIMPLSERVICE_WSDL_LOCATION = url;
        TIMESERVERIMPLSERVICE_EXCEPTION = e;
    }

    public TimeServerImplService() {
        super(__getWsdlLocation(), TIMESERVERIMPLSERVICE_QNAME);
    }

    public TimeServerImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TIMESERVERIMPLSERVICE_QNAME, features);
    }

    public TimeServerImplService(URL wsdlLocation) {
        super(wsdlLocation, TIMESERVERIMPLSERVICE_QNAME);
    }

    public TimeServerImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TIMESERVERIMPLSERVICE_QNAME, features);
    }

    public TimeServerImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TimeServerImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TimeServer
     */
    @WebEndpoint(name = "TimeServerImplPort")
    public TimeServer getTimeServerImplPort() {
        return super.getPort(new QName("http://ts.ch02.kalin.ragna.org/", "TimeServerImplPort"), TimeServer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TimeServer
     */
    @WebEndpoint(name = "TimeServerImplPort")
    public TimeServer getTimeServerImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ts.ch02.kalin.ragna.org/", "TimeServerImplPort"), TimeServer.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TIMESERVERIMPLSERVICE_EXCEPTION!= null) {
            throw TIMESERVERIMPLSERVICE_EXCEPTION;
        }
        return TIMESERVERIMPLSERVICE_WSDL_LOCATION;
    }

}
