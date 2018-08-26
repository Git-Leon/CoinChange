package rocks.zipcodewilmington.cashiertest;

/**
 * @author leon on 8/26/18.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.zipcodewilmington.cashier.Cashier;
import rocks.zipcodewilmington.cashier.CashierWilhem;

import java.util.Arrays;

/**
 * @author leon on 8/9/18.
 */
public class WilhemCashierTest {
    private CashierWilhem cashier;

    @Before
    public void setup() {
        this.cashier = new CashierWilhem(51);
    }

    @Test
    public void testChangeOf51() {
        String[][] actual = cashier.getSetOfValidChanges();
        System.out.println(Arrays.deepToString(actual));
    }

}