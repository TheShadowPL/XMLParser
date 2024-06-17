package org.example.XMLStructure;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemsType", propOrder = {
    "kartaInformacyjna"
})
public class ItemsType {

    @XmlElement(name = "karta_informacyjna")
    protected List<KartaInformacyjnaType> kartaInformacyjna;


    public List<KartaInformacyjnaType> getKartaInformacyjna() {
        if (kartaInformacyjna == null) {
            kartaInformacyjna = new ArrayList<KartaInformacyjnaType>();
        }
        return this.kartaInformacyjna;
    }

}
