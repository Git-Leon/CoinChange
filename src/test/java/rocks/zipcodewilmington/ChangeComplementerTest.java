package rocks.zipcodewilmington;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.zipcodewilmington.cashier.ChangeComplementer;

import java.util.*;

/**
 * @author leon on 8/9/18.
 */
public class ChangeComplementerTest {
    private Stack<Integer> set;

    @Before
    public void setup() {
        this.set = new Stack<>();
        set.add(1);
        set.add(5);
        set.add(10);
        set.add(25);
    }

    @Test
    public void testCurrentCoinList25And25() {
        ChangeComplementer changeComplementer = new ChangeComplementer(set, 25, 25);
        Integer[] expected = {25, 25, 1};
        Integer[] actual = changeComplementer.getOptimalComplementArray(51);

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testCurrentCoinList25() {
        ChangeComplementer changeComplementer = new ChangeComplementer(set, 25);
        Integer[] expected = {25, 25, 1};
        Integer[] actual = changeComplementer.getOptimalComplementArray(51);

        System.out.println(Arrays.toString(actual));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void t() {
        Set set = new TreeSet(Collections.reverseOrder());
        set.add(1);
        set.add(3);
        set.add(9);
        set.add(5);
        set.add(7);

        System.out.println(Arrays.toString(set
                .stream()
                .toArray(Integer[]::new)));
    }
}
