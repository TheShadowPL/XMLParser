package org.example.XMLStructure;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bip.poznan.plType", propOrder = {
    "data"
})
@XmlRootElement(name="bip.poznan.pl")
public class BipPoznanPlType {
    @XmlElement(required = true)
    protected DataType data;
    public DataType getData() {
        return data;
    }
    public void setData(DataType value) {
        this.data = value;
    }

}
