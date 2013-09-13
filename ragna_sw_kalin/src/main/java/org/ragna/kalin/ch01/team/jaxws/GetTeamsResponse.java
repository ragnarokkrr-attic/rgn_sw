
package org.ragna.kalin.ch01.team.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getTeamsResponse", namespace = "http://team.ch01.kalin.ragna.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTeamsResponse", namespace = "http://team.ch01.kalin.ragna.org/")
public class GetTeamsResponse {

    @XmlElement(name = "return", namespace = "")
    private List<org.ragna.kalin.ch01.team.Team> _return;

    /**
     * 
     * @return
     *     returns List<Team>
     */
    public List<org.ragna.kalin.ch01.team.Team> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<org.ragna.kalin.ch01.team.Team> _return) {
        this._return = _return;
    }

}
