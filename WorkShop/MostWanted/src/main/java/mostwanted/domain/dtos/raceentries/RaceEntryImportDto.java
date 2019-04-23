package mostwanted.domain.dtos.raceentries;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "race-entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceEntryImportDto {

    @XmlAttribute(name = "has-finished")
    private boolean hastFinished;

    @XmlAttribute(name = "finish-time")
    private Double finishTime;

    @XmlAttribute(name = "car-id")
    private Integer carId;

    @XmlElement(name = "racer")
    private String racer;

    public RaceEntryImportDto() {
    }

    public boolean isHastFinished() {
        return this.hastFinished;
    }

    public void setHastFinished(boolean hastFinished) {
        this.hastFinished = hastFinished;
    }

    public Double getFinishTime() {
        return this.finishTime;
    }

    public void setFinishTime(Double finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getCarId() {
        return this.carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getRacer() {
        return this.racer;
    }

    public void setRacer(String racer) {
        this.racer = racer;
    }
}
