package rocks.zipcodewilmington.arrayutils;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcodewilmington.cashier.ArrayUtils;

import java.util.stream.IntStream;

/**
 * @author leon on 8/14/18.
 */
public class MergeTest {
    @Test
    public void testIntegerMerge() {
        // Given
        Integer[] array1 = {1,2,3,4,5};
        Integer[] array2 = {5,6,7,8,9};
        Integer[] expected = {1,2,3,4,5,5,6,7,8,9};

                // When
        Integer[] actual = ArrayUtils.merge(array1, array2);

        Assert.assertEquals(expected, actual);
    }
}
