package rocks.zipcodewilmington.cashier;

import java.util.*;

/**
 * @author Vijay Kumar : email kumar.vijay@gmail.com
 * Distributed under Apache 2.0 License
 * <p>
 * The following class contains the final result after running the coin change
 * function.
 */

public class Cashier {
    private final Set<Integer> validCoinValues;

    public Cashier(Set<Integer> validCoinValues) {
        this.validCoinValues = validCoinValues;
    }

    public Cashier(Integer... validCoinValues) {
        // enforces descending of our set
        this(new TreeSet<>(Collections.reverseOrder()));
        this.validCoinValues.addAll(Arrays.asList(validCoinValues));
    }

    public Cashier() {
        this(1, 5, 10, 25);
    }

    public Integer[][] getSetOfValidChanges(int targetChange) {
        List<Integer[]> listOfArrayOfCoinsWhichSumToTarget = new ArrayList<>();
        ChangeComplementer cc = new ChangeComplementer(validCoinValues);
        Integer[] arrayOfCoinsWhichSumToTarget = cc.getOptimalComplementArray(targetChange);
        listOfArrayOfCoinsWhichSumToTarget.add(arrayOfCoinsWhichSumToTarget);
        return listOfArrayOfCoinsWhichSumToTarget.stream().toArray(Integer[][]::new);
    }
}
