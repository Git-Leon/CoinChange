package rocks.zipcodewilmington;

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
    public void testChangeOf51() {
        Cashier cashier = new Cashier();
        Integer[][] actual = cashier.getSetOfValidChanges(51);

        System.out.println(Arrays.toString(actual));
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
