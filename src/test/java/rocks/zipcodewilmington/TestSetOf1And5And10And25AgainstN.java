package rocks.zipcodewilmington;

import org.junit.Test;
import rocks.zipcodewilmington.cashier.Cashier;

import java.util.Arrays;

import static rocks.zipcodewilmington.cashier.CoinValues.*;

/**
 * @author leon on 8/6/18.
 */
public class TestSetOf1And5And10And25AgainstN {
    private Cashier cashier = new Cashier(PENNY, NICKLE, DIME, QUARTER);

    @Test
    public void t() {
        Integer[][] expected = new Integer[][]{
                new Integer[]{QUARTER, QUARTER, PENNY},
                new Integer[]{DIME, DIME, DIME, DIME, DIME, PENNY},
                new Integer[]{NICKLE, NICKLE, NICKLE, NICKLE, NICKLE, NICKLE, NICKLE, NICKLE, NICKLE, NICKLE, PENNY},
                new Integer[]{PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY, PENNY}};


        System.out.println(Arrays.deepToString(cashier.getSetOfValidChanges(51)));
    }


}
