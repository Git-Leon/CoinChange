package rocks.zipcodewilmington.coinchange;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author leon on 8/6/18.
 */
public class CoinChange {
    private Set<Integer> coins = new HashSet<>();

    public CoinChange(Iterable<Integer> coinSet) {
        coinSet.forEach(coin -> this.coins.add(coin));
    }

    public CoinChange(Integer[] coinSet) {
        this(Arrays.asList(coinSet));
    }

    public Set<Integer[]> getPermutations(Integer coinSumValue) {
        return null;
    }
}
