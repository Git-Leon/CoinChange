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

    public Integer[][] getSetOfValidChange(int targetChange) {
        List<Integer[]> listOfArrayOfCoinsWhichSumToTarget = new ArrayList<>();
        ChangeComplementer cc = new ChangeComplementer(validCoinValues);
        Integer[] arrayOfCoinsWhichSumToTarget = cc.getOptimalComplementArray(targetChange);
        listOfArrayOfCoinsWhichSumToTarget.add(arrayOfCoinsWhichSumToTarget);
        for (Integer coinToRemove : arrayOfCoinsWhichSumToTarget) {
            arrayOfCoinsWhichSumToTarget = ArrayUtils.removeFirst(arrayOfCoinsWhichSumToTarget, coinToRemove);
            cc = new ChangeComplementer(validCoinValues, arrayOfCoinsWhichSumToTarget);
            Integer[] arrayToMerge = cc.getOptimalComplementArray(coinToRemove);
            arrayOfCoinsWhichSumToTarget = ArrayUtils.merge(arrayOfCoinsWhichSumToTarget, arrayToMerge);
            listOfArrayOfCoinsWhichSumToTarget.add(arrayOfCoinsWhichSumToTarget);

        }
        return listOfArrayOfCoinsWhichSumToTarget.stream().toArray(Integer[][]::new);
    }


    public Integer[][] getSetOfValidChanges(final int targetChange) {
        List<Integer[]> listOfArrayOfCoinsWhichSumToTarget = new ArrayList<>();
        ChangeComplementer cc = new ChangeComplementer(validCoinValues);

        final Integer[] optimalSolution = cc.getOptimalComplementArray(targetChange);
        listOfArrayOfCoinsWhichSumToTarget.add(optimalSolution);
        for (Integer coin : optimalSolution) {
            Integer[] nextOptimalSolution  = ArrayUtils.removeFirst(optimalSolution, coin); // TODO - Fix removeFirst
            nextOptimalSolution = ArrayUtils.merge(nextOptimalSolution , simplify(coin));
            listOfArrayOfCoinsWhichSumToTarget.add(nextOptimalSolution);
        }
        return listOfArrayOfCoinsWhichSumToTarget.stream().toArray(Integer[][]::new);
    }

    private Integer[] simplify(Integer coin) {
        List<Integer> validCoinList = new ArrayList<>();
        validCoinList.addAll(validCoinValues);
        validCoinList.remove(coin);

        return new ChangeComplementer(validCoinList).getOptimalComplementArray(coin);
    }
}
