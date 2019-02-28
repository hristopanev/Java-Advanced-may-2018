package hotelReservation;

public class ReservationDetails {
    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private DiscountType type;

    public ReservationDetails(double pricePerDay, int numberOfDays, Season season, DiscountType type) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.type = type;
    }

    public double getPricePerDay() {
        return this.pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getNumberOfDays() {
        return this.numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Season getSeason() {
        return this.season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public DiscountType getType() {
        return this.type;
    }

    public void setType(DiscountType type) {
        this.type = type;
    }
}
