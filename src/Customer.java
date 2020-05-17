import java.util.ArrayList;
import java.util.List;

class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalCharge = 0;
        int frequentRenterPoints = 0;
        StringBuilder statement = new StringBuilder("Rental Record for " + this.getName() + "\n");
        statement.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        for (Rental rental:rentals) {
            double rentalCharge = rental.getCharge();
            frequentRenterPoints += rental.getFrequentRenterPoints();
            //show figures for this rental
            statement.append("\t").append(rental.getMovie().getTitle()).append("\t").append("\t").append(rental.getDaysRented()).append("\t").append(rentalCharge).append("\n");
            totalCharge += rentalCharge;
        }
        //add footer lines
        statement.append("Amount owed is ").append(totalCharge).append("\n");
        statement.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return statement.toString();
    }

}
    