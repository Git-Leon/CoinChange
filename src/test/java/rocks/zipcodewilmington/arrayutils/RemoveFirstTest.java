package rocks.zipcodewilmington.arrayutils;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcodewilmington.cashier.ArrayUtils;

import java.util.Arrays;

/**
 * @author leon on 8/14/18.
 */
public class RemoveFirstTest {
@Test
public void removeFirst() {
    // Given
    Integer valToRemove = 5;
    Integer[] input = {1,2,3,valToRemove,4,valToRemove,6,7,8,9};
    Integer[] expected = {1,2,3,4,valToRemove,6,7,8,9};

    // When
    Integer[] actual = ArrayUtils.removeFirst(input, valToRemove);
    System.out.println(Arrays.toString(actual));

    // Then
    Assert.assertEquals(expected, actual);
}
}
