package cardealer.domain.dtos;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartImportRootDTO {

    @XmlElement(name = "part")
    private PartImportDTO[] partImportDTOS;

    public PartImportRootDTO() {
    }


    public PartImportDTO[] getPartImportDTOS() {
        return this.partImportDTOS;
    }

    public void setPartImportDTOS(PartImportDTO[] partImportDTOS) {
        this.partImportDTOS = partImportDTOS;
    }
}
