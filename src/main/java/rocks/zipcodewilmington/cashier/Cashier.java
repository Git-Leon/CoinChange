package rocks.zipcodewilmington.cashier;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Vijay Kumar : email kumar.vijay@gmail.com
 * Distributed under Apache 2.0 License
 * <p>
 * The following class contains the final result after running the coin change
 * function.
 */

public class Cashier {
    private final Set<Integer> coinSet;

    public Cashier(Set<Integer> coinSet) {
        this.coinSet = coinSet;
    }

    public Cashier(Integer... coinArray) {
        // enforces descending of our set
        this(new TreeSet<>(Collections.reverseOrder()));
        coinSet.addAll(Arrays.asList(coinArray));
    }

    public Cashier() {
        this(1, 5, 10, 25);
    }

    public Integer[][] getSetOfValidChanges(int targetChange) {
        Deque<Integer> coinStack = coinSet.stream().collect(Collectors.toCollection(LinkedList::new));

        List<Integer[]> listOfArrayOfCoinsWhichSumToTarget = new ArrayList<>();
        while (!coinStack.isEmpty()) {
            List<Integer> listOfCoinsWhichSumToTarget = new ArrayList<>();
            int currentChange = targetChange;
            for (Integer currentLargestCoin : coinStack) {
                while (currentLargestCoin <= currentChange) {
                    listOfCoinsWhichSumToTarget.add(currentLargestCoin);
                    currentChange -= currentLargestCoin;
                }
            }
            coinStack.pop();
            Integer[] arrayOfCoinsWhichSumToTarget = listOfCoinsWhichSumToTarget.stream().toArray(Integer[]::new);
            listOfArrayOfCoinsWhichSumToTarget.add(arrayOfCoinsWhichSumToTarget);
        }
        return listOfArrayOfCoinsWhichSumToTarget.stream().toArray(Integer[][]::new);
    }
}
