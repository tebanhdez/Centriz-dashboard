package cr.centriz.dashboard.dao.clients;

import java.util.Date;

public class Rental {
    private String id;
    private String firstName;
    private String lastName;
    private Date checkouTime;
    private Date checkinTime;
    private int usage;
    private String vehicle;
    private String makeModel;
    private String color;
    private String plate;
    private String checkOutStation;
    private String checkInStation;
    private String previousCheckOutStation;
    private String previousCheckInStation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCheckouTime() {
        return checkouTime;
    }

    public void setCheckouTime(Date checkouTime) {
        this.checkouTime = checkouTime;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getCheckOutStation() {
        return checkOutStation;
    }

    public void setCheckOutStation(String checkOutStation) {
        this.checkOutStation = checkOutStation;
    }

    public String getCheckInStation() {
        return checkInStation;
    }

    public void setCheckInStation(String checkInStation) {
        this.checkInStation = checkInStation;
    }

    public String getPreviousCheckOutStation() {
        return previousCheckOutStation;
    }

    public void setPreviousCheckOutStation(String previousCheckOutStation) {
        this.previousCheckOutStation = previousCheckOutStation;
    }

    public String getPreviousCheckInStation() {
        return previousCheckInStation;
    }

    public void setPreviousCheckInStation(String previousCheckInStation) {
        this.previousCheckInStation = previousCheckInStation;
    }

    @Override
    public String toString() {
        return "Rental [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", checkouTime="
                + checkouTime + ", checkinTime=" + checkinTime + ", usage=" + usage + ", vehicle=" + vehicle
                + ", makeModel=" + makeModel + ", color=" + color + ", plate=" + plate + ", checkOutStation="
                + checkOutStation + ", checkInStation=" + checkInStation + ", previousCheckOutStation="
                + previousCheckOutStation + ", previousCheckInStation=" + previousCheckInStation + "]";
    }

}
