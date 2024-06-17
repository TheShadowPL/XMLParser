package org.example.XMLStructure;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "karty_informacyjneType", propOrder = {
    "start",
    "stop",
    "size",
    "totalSize",
    "items"
})
public class KartyInformacyjneType {

    @XmlElement(required = true)
    protected String start;
    @XmlElement(required = true)
    protected String stop;
    @XmlElement(required = true)
    protected String size;
    @XmlElement(name = "total_size", required = true)
    protected String totalSize;
    @XmlElement(required = true)
    protected ItemsType items;

    public String getStart() {
        return start;
    }

    public void setStart(String value) {
        this.start = value;
    }


    public String getStop() {
        return stop;
    }

    public void setStop(String value) {
        this.stop = value;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String value) {
        this.size = value;
    }

    public String getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(String value) {
        this.totalSize = value;
    }

    public ItemsType getItems() {
        return items;
    }

    public void setItems(ItemsType value) {
        this.items = value;
    }

}
