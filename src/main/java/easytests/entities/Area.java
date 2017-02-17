package easytests.entities;

import java.util.List;

/**
 * @author fortyways
 */
public class Area {

    private Integer id;

    private String name;

    private Float xCoord;

    private Float yCoord;

    private Float width;

    private Float length;

    private List<Dweller> habitants;

    public void setLength(Float length) {
        this.length = length;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public void setxCoord(Float xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(Float yCoord) {
        this.yCoord = yCoord;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getLength() {
        return length;
    }

    public Float getWidth() {
        return width;
    }

    public Float getxCoord() {
        return xCoord;
    }

    public Float getyCoord() {
        return yCoord;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Dweller> getHabitants() {
        return habitants;
    }

    public void setHabitants(List<Dweller> habitants) {
        this.habitants = habitants;
    }
}
