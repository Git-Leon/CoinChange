package rocks.zipcodewilmington.cashier;

/**
 * @author leon on 8/9/18.
 */
public class CoinRoll {
    private int numberOfCoins;

    private CoinRoll(int numberOfCoins) {
        this.numberOfCoins = numberOfCoins;
    }

    public void add(int numberOfCoins) {
        this.numberOfCoins += numberOfCoins;
    }

    public void remove(int numberOfCoins) {
        this.numberOfCoins -= numberOfCoins;
    }

    public int getValue() {
        return numberOfCoins;
    }
}
