package rocks.zipcodewilmington.cashier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leon on 8/14/18.
 */
public class ArrayUtils {
    public static <TypeOfObject extends Comparable<?>> TypeOfObject getMaximum(TypeOfObject[] array) {
        TypeOfObject[] newArray = array.clone();
        Arrays.sort(newArray);
        return newArray[newArray.length - 1];
    }

    public static <TypeOfObject extends Comparable<?>> TypeOfObject getMinimum(TypeOfObject[] array) {
        TypeOfObject[] newArray = array.clone();
        Arrays.sort(newArray);
        return newArray[0];
    }

    public static <TypeOfObject> TypeOfObject[] removeElement(TypeOfObject[] array, TypeOfObject valueToRemove) {
        List<TypeOfObject> result = new ArrayList<>();
        for (TypeOfObject value : array) {
            if (!value.equals(valueToRemove)) {
                result.add(value);
            }
        }
        return  result.toArray((TypeOfObject[])new Object[result.size()-1]);
    }


    public static <TypeOfObject> TypeOfObject[] removeFirst(TypeOfObject[] array, TypeOfObject valueToRemove) {
        List<TypeOfObject> result = new ArrayList<>();
        boolean firstRemoved = false;
        for (TypeOfObject value : array) {
            if(!firstRemoved) {
                if (!value.equals(valueToRemove)) {
                    result.add(value);
                    firstRemoved = true;
                }
            }
        }
        return  result.toArray((TypeOfObject[])new Object[result.size()-1]);
    }
}
