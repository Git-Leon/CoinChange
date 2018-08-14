package rocks.zipcodewilmington.cashier;

import java.util.*;

/**
 * @author leon on 8/9/18.
 */
public class ChangeComplementer {
    private final Iterable<Integer> validCoinValues;
    private final Collection<Integer> currentCoinList;

    public ChangeComplementer(Iterable<Integer> validCoinValues, Collection<Integer> currentCoinList) {
        Set<Integer> orderedValidCoins = new TreeSet<>(Collections.reverseOrder());
        validCoinValues.forEach(coin -> orderedValidCoins.add(coin));
        orderedValidCoins.add(1); // ensures there is a denomination of 1

        this.validCoinValues = orderedValidCoins;
        this.currentCoinList = currentCoinList;
    }


    public ChangeComplementer(Iterable<Integer> validCoinValues, Integer... currentCoinList) {
        this(validCoinValues, new ArrayList<>(Arrays.asList(currentCoinList)));
    }

    public ChangeComplementer(Iterable<Integer> validCoinValues) {
        this(validCoinValues, new ArrayList<>());
    }

    public Collection<Integer> getOptimalComplementList(final int targetChange) {
        int currentBalanceRemaining = targetChange;
        for (Integer currentLargestCoin : validCoinValues) {
            while (currentLargestCoin <= currentBalanceRemaining) {
                int currChangeVal = getCurrentChangeValue();
                currentBalanceRemaining = targetChange - currChangeVal;
                if (currentLargestCoin <= currentBalanceRemaining) {
                    currentCoinList.add(currentLargestCoin);
                }
            }
        }
        return currentCoinList;
    }


    public Integer[] getOptimalComplementArray(int targetChange) {
        return getOptimalComplementList(targetChange).stream().toArray(Integer[]::new);
    }


    public int getCurrentChangeValue() {
        return currentCoinList.stream().mapToInt(Integer::intValue).sum();
    }
}
