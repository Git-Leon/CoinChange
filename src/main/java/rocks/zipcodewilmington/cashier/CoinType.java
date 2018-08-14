package rocks.zipcodewilmington.cashier;

/**
 * @author leon on 8/9/18.
 */
public enum CoinType {
    QUARTER(25),
    DIME(10),
    NICKLE(5),
    PENNY(1);

    private final int centValue;

    CoinType(int centValue) {
        this.centValue = centValue;
    }

    public int getCentValue() {
        return centValue;
    }
}
