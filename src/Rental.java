class Rental {
    private final Movie movie;
    private final int daysRented;
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        double charge = 0;
        switch (movie.getPriceCode()) {
            case REGULAR:
                charge += 2;
                if (daysRented > 2)
                    charge += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                charge += daysRented * 3;
                break;
            case CHILDRENS:
                charge += 1.5;
                if (daysRented > 3)
                    charge += (daysRented - 3) * 1.5;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + movie.getPriceCode());
        }
        return charge;
    }
}