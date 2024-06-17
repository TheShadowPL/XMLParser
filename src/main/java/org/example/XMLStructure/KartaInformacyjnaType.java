package org.example.XMLStructure;

import jakarta.xml.bind.annotation.*;

import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "karta_informacyjnaType", propOrder = {
    "link",
    "id",
    "data",
    "skrotOrganizacja",
    "komponentSrodowiska",
    "typKarty",
    "rodzajKarty",
    "nrWpisu",
    "znakSprawy",
    "daneWnioskodawcy"
})
//@XmlRootElement(name="bip.poznan.pl")
public class KartaInformacyjnaType {

    @XmlElement(required = true)
    protected String link;
    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String data;
    @XmlElement(name = "skrot_organizacja", required = true)
    protected String skrotOrganizacja;
    @XmlElement(name = "komponent_srodowiska", required = true)
    protected String komponentSrodowiska;
    @XmlElement(name = "typ_karty", required = true)
    protected String typKarty;
    @XmlElement(name = "rodzaj_karty", required = true)
    protected String rodzajKarty;
    @XmlElement(name = "nr_wpisu", required = true)
    protected String nrWpisu;
    @XmlElement(name = "znak_sprawy", required = true)
    protected String znakSprawy;
    @XmlElement(name = "dane_wnioskodawcy", required = true)
    protected String daneWnioskodawcy;

    public String getLink() {
        return link;
    }

    public void setLink(String value) {
        this.link = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getData() {
        return data;
    }

    public void setData(String value) {
        this.data = value;
    }

    public String getSkrotOrganizacja() {
        return skrotOrganizacja;
    }

    public void setSkrotOrganizacja(String value) {
        this.skrotOrganizacja = value;
    }

    public String getKomponentSrodowiska() {
        return komponentSrodowiska;
    }

    public void setKomponentSrodowiska(String value) {
        this.komponentSrodowiska = value;
    }

    public String getTypKarty() {
        return typKarty;
    }

    public void setTypKarty(String value) {
        this.typKarty = value;
    }

    public String getRodzajKarty() {
        return rodzajKarty;
    }

    public void setRodzajKarty(String value) {
        this.rodzajKarty = value;
    }

    public String getNrWpisu() {
        return nrWpisu;
    }

    public void setNrWpisu(String value) {
        this.nrWpisu = value;
    }

    public String getZnakSprawy() {
        return znakSprawy;
    }

    public void setZnakSprawy(String value) {
        this.znakSprawy = value;
    }

    public String getDaneWnioskodawcy() {
        return daneWnioskodawcy;
    }

    public void setDaneWnioskodawcy(String value) {
        this.daneWnioskodawcy = value;
    }

}
