package rocks.zipcodewilmington.coinchange;

import java.util.Set;

/**
 * @author leon on 8/6/18.
 */
public class TestNicklePenny {

    public void test15() {
        // Given
        CoinChange cc = new CoinChange(new Integer[]{5,4,3,2,1});

        Set<Integer[]> expectedCoinPermutations = new SetAppender<Integer>()
                .add(5,1) // 5
                .add(4,2) // 4
                .add(4,1,1)
                .add(3,3)
                .add(3,2,1)
                .add(3,1,1,1) // 3
                .add(2,2,2)
                .add(2,1,1,1,1) // 2
                .add(2,2,1,1,1,1)
                .add(1,1,1,1,1,1,1)
                .get();

        // When
        Set<Integer[]> coinPermutations = cc.getPermutations(6);

        // Then

    }
}
