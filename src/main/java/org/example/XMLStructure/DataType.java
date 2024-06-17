package org.example.XMLStructure;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataType", propOrder = {
    "kartyInformacyjne"
})
//@XmlRootElement(name="bip.poznan.pl")
public class DataType {

    @XmlElement(name = "karty_informacyjne", required = true)
    protected KartyInformacyjneType kartyInformacyjne;

    public KartyInformacyjneType getKartyInformacyjne() {
        return kartyInformacyjne;
    }


    public void setKartyInformacyjne(KartyInformacyjneType value) {
        this.kartyInformacyjne = value;
    }

}
