package rocks.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcodewilmington.cashier.Cashier;

import java.util.Arrays;

/**
 * @author leon on 8/7/18.
 */
//@SuppressWarnings("all")
public class TestSetOf1AgainstN {
    @Test
    public void testSetOf1Against1() {
        // Given
        int penny = 1;
        int oneCent = 1;
        Cashier cca = new Cashier(penny);
        Integer[][] expectedSolution = new Integer[][] {
                { penny }
        };

        // When
        Integer[][] actualSolution = cca.getSetOfValidChanges(oneCent);


        // Then
        String actual = Arrays.deepToString(actualSolution);
        String expected = Arrays.deepToString(expectedSolution);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetOf1Against5() {
        // Given
        int penny = 1;
        int fiveCents = 5;
        Cashier cca = new Cashier(penny);
        Integer[][] expectedSolution = new Integer[][] {
                { penny, penny, penny, penny, penny }
        };

        // When
        Integer[][] actualSolution = cca.getSetOfValidChanges(fiveCents);


        // Then
        String actual = Arrays.deepToString(actualSolution);
        String expected = Arrays.deepToString(expectedSolution);

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testSetOf1Against3() {
        // Given
        int penny = 1;
        int threeCents = 3;
        Cashier cca = new Cashier(penny);
        Integer[][] expectedSolution = new Integer[][] {
                { penny, penny, penny }
        };

        // When
        Integer[][] actualSolution = cca.getSetOfValidChanges(threeCents);


        // Then
        String actual = Arrays.deepToString(actualSolution);
        String expected = Arrays.deepToString(expectedSolution);

        Assert.assertEquals(expected, actual);
    }


}
