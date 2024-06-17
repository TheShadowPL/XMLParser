package org.example.XMLStructure;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {

    private final static QName _BipPoznanPl_QNAME = new QName("", "bip.poznan.pl");

    public ObjectFactory() {
    }

    public BipPoznanPlType createBipPoznanPlType() {
        return new BipPoznanPlType();
    }

    public KartaInformacyjnaType createKartaInformacyjnaType() {
        return new KartaInformacyjnaType();
    }

    public ItemsType createItemsType() {
        return new ItemsType();
    }

    public KartyInformacyjneType createKartyInformacyjneType() {
        return new KartyInformacyjneType();
    }

    public DataType createDataType() {
        return new DataType();
    }

    @XmlElementDecl(namespace = "", name = "bip.poznan.pl")
    public JAXBElement<BipPoznanPlType> createBipPoznanPl(BipPoznanPlType value) {
        return new JAXBElement<BipPoznanPlType>(_BipPoznanPl_QNAME, BipPoznanPlType.class, null, value);
    }

    public DaneWnioskodawcy createDaneWnioskodawcy(String nazwa, String ulica, String miejscowosc) {
        DaneWnioskodawcy daneWnioskodawcy = new DaneWnioskodawcy();
        daneWnioskodawcy.setNazwa(nazwa);
        daneWnioskodawcy.setUlica(ulica);
        daneWnioskodawcy.setMiejscowosc(miejscowosc);
        return daneWnioskodawcy;
    }
}
