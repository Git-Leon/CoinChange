package rocks.zipcodewilmington;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.zipcodewilmington.cashier.Cashier;

import java.util.Arrays;

import static rocks.zipcodewilmington.cashier.CoinValues.NICKLE;
import static rocks.zipcodewilmington.cashier.CoinValues.PENNY;

/**
 * @author leon on 8/7/18.
 */
public class TestSetOf1And5AgainstN {
    private Cashier cashier;

    @Before
    public void setup() {
        this.cashier = new Cashier(PENNY, NICKLE);
    }

    @Test
    public void testAgainst5() {
        // Given
        int targetChange = 5;
        Integer[][] expectedSolution = new Integer[][] {
                { NICKLE },
                { PENNY, PENNY, PENNY, PENNY, PENNY }
        };

        // When
        Integer[][] actualSolution = cashier.getSetOfValidChanges(targetChange);


        // Then
        String actual = Arrays.deepToString(actualSolution);
        String expected = Arrays.deepToString(expectedSolution);

        Assert.assertEquals(expected, actual);
    }
}
