public enum PriceCode {
    REGULAR(0),NEW_RELEASE(1),CHILDRENS(2);

    private final int value;

    PriceCode(int value) {
        this.value = value;
    }
}