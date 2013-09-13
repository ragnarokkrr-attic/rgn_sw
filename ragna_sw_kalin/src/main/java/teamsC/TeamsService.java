
package teamsC;

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
@WebServiceClient(name = "TeamsService", targetNamespace = "http://team.ch01.kalin.ragna.org/", wsdlLocation = "http://localhost:8888/teams?wsdl")
public class TeamsService
    extends Service
{

    private final static URL TEAMSSERVICE_WSDL_LOCATION;
    private final static WebServiceException TEAMSSERVICE_EXCEPTION;
    private final static QName TEAMSSERVICE_QNAME = new QName("http://team.ch01.kalin.ragna.org/", "TeamsService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8888/teams?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TEAMSSERVICE_WSDL_LOCATION = url;
        TEAMSSERVICE_EXCEPTION = e;
    }

    public TeamsService() {
        super(__getWsdlLocation(), TEAMSSERVICE_QNAME);
    }

    public TeamsService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TEAMSSERVICE_QNAME, features);
    }

    public TeamsService(URL wsdlLocation) {
        super(wsdlLocation, TEAMSSERVICE_QNAME);
    }

    public TeamsService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TEAMSSERVICE_QNAME, features);
    }

    public TeamsService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TeamsService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Teams
     */
    @WebEndpoint(name = "TeamsPort")
    public Teams getTeamsPort() {
        return super.getPort(new QName("http://team.ch01.kalin.ragna.org/", "TeamsPort"), Teams.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Teams
     */
    @WebEndpoint(name = "TeamsPort")
    public Teams getTeamsPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://team.ch01.kalin.ragna.org/", "TeamsPort"), Teams.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TEAMSSERVICE_EXCEPTION!= null) {
            throw TEAMSSERVICE_EXCEPTION;
        }
        return TEAMSSERVICE_WSDL_LOCATION;
    }

}
