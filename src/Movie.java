public class Movie {
    private final String title;
    private PriceCode priceCode;

    public Movie(String title, PriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public PriceCode getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(PriceCode priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return priceCode.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return priceCode.getFrequentRenterPoints(daysRented);
    }
}