import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class CustomerTest {

    private final Movie blackPanther = new Movie("Black Panther", PriceCode.REGULAR);
    private final Movie parasite = new Movie("Parasite", PriceCode.NEW_RELEASE);
    private final Movie toyStory = new Movie("Toy Story", PriceCode.CHILDRENS);
    private Rental sunday;
    private Rental thursday;
    private Rental friday;
    private Customer alf;

    @BeforeEach
    public void setUp() {
        sunday = new Rental(blackPanther, 3);
        thursday = new Rental(parasite, 2);
        friday = new Rental(toyStory, 1);

        alf = new Customer("Alf");
    }

    @org.junit.jupiter.api.Test
    public void statementNoRentalTest() {
        String actual = alf.statement();

        String expected = "Rental Record for Alf\n"
                + "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n"
                + "Amount owed is 0.0\n"
                + "You earned 0 frequent renter points";
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void statementAllRentalsTest() {
        alf.addRental(sunday);
        alf.addRental(thursday);
        alf.addRental(friday);

        String actual = alf.statement();

        String expected = "Rental Record for Alf" + "\n"
                + "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n"
                + "\t" + "Black Panther" + "\t" + "\t" + "3" + "\t" + "3.5" + "\n"
                + "\t" + "Parasite" + "\t" + "\t" + "2" + "\t" + "6.0" + "\n"
                + "\t" + "Toy Story" + "\t" + "\t" + "1" + "\t" + "1.5" + "\n"
                + "Amount owed is 11.0" + "\n"
                + "You earned 4 frequent renter points";
        Assertions.assertEquals(expected, actual);
    }

}
