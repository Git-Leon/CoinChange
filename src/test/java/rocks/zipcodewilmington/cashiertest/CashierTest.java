package rocks.zipcodewilmington.cashiertest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.zipcodewilmington.cashier.Cashier;
import rocks.zipcodewilmington.cashier.ChangeComplementer;

import java.util.*;

/**
 * @author leon on 8/9/18.
 */
public class CashierTest {
    private Cashier cashier;

    @Before
    public void setup() {
        this.cashier = new Cashier();
    }
    @Test
    public void testChangeOf51() {
        Integer[][] actual = cashier.getSetOfValidChanges(51);
        System.out.println(Arrays.deepToString(actual));
    }

    @Test
    public void testSimplify25() {
        // Given
        Integer givenCoin = 25;
        Integer[] expected = {10, 10, 5};

        // When
        Integer[] actual = cashier.simplify(givenCoin);

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testSimplify10() {
        // Given
        Integer givenCoin = 10;
        Integer[] expected = {5, 5};

        // When
        Integer[] actual = cashier.simplify(givenCoin);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSimplify5() {
        // Given
        Integer givenCoin = 5;
        Integer[] expected = {1, 1, 1, 1, 1};

        // When
        Integer[] actual = cashier.simplify(givenCoin);

        // Then
        Assert.assertEquals(expected, actual);
    }
}
