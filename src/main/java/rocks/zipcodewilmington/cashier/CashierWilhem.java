package rocks.zipcodewilmington.cashier;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author leon on 8/26/18.
 */
//def main(value):
//        solutions_with_nickles = shift_up(solutions_set, ('ppppp', 'n'))
//        solutions_with_dimes = shift_up(solutions_with_nickles, ('nn', 'd'))
//        solutions_with_quarters = shift_up(solutions_with_dimes, ('ddn', 'q'))
//        solutions_set += solutions_with_nickles + solutions_with_dimes + solutions_with_quarters
//
//        solutions_set = set(solutions_set)
//        print(solutions_set)
//
//        def shift_up(coin_combinations, exchange_rates):
//            shifted_solutions = []
//            for solution in coin_combinations:
//                while exchange_rates[0] in solution:
//                    solution = solution.replace(exchange_rates[0], exchange_rates[1], 1)
//                    # bring all occurances of exchange_rates[1] to the front
//                    solution = (solution.count(exchange_rates[1]) * exchange_rates[1]) + solution.replace(exchange_rates[1], '')
//                    shifted_solutions.append(solution)
//            return shifted_solutions
//
//main(36)
public class CashierWilhem {
    private final String[] solution_set;

    public CashierWilhem(Integer targetValue) {
        this.solution_set = Stream.of("p").limit(targetValue).toArray(String[]::new);
    }


    public String[][] getSetOfValidChanges() {
        Pair<String[], Character> nickleExchange = new Pair<>("ppppp".split(""), 'n');
        Pair<String[], Character> dimeExchange = new Pair<>("nn".split(""), 'd');
        Pair<String[], Character> quarterExchange = new Pair<>("ddn".split(""), 'q');
        String[] solutionsWithNickles = shiftUp(solution_set, nickleExchange);
        String[] solutionsWithDimes = shiftUp(solutionsWithNickles, dimeExchange);
        String[] solutionsWithQuarters = shiftUp(solutionsWithDimes, quarterExchange);
        return new String[][]{solutionsWithNickles, solutionsWithDimes, solutionsWithQuarters};
    }

    private String[] shiftUp(String[] coinCombination, Pair<String[], Character> exchangeRates) {
        List<String> exchangeRatesKey = new ArrayList<>(Arrays.asList(exchangeRates.getKey()));
        String exchangeRatesValue = exchangeRates.getValue().toString();
        List<String> shiftedSolutions = new ArrayList<>();
        for(String solution : coinCombination) {
            while(exchangeRatesKey.contains(solution)) {
                String exchangeRatesKeyAsString = String.join("", exchangeRates.getKey());
                solution = solution.replace(exchangeRatesKeyAsString, exchangeRatesValue);
                shiftedSolutions.add(solution);
            }
        }
        return shiftedSolutions.toArray(new String[0]);

    }
}
