package rocks.zipcodewilmington.cashier;

import java.lang.reflect.Array;
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
        return result.toArray((TypeOfObject[]) new Object[result.size() - 1]);
    }


    public static <TypeOfObject> TypeOfObject[] removeFirstt(TypeOfObject[] array, TypeOfObject valueToRemove) {
        List<TypeOfObject> result = new ArrayList<>();
        boolean firstOccurrenceHasBeenRemoved = false;
        for (TypeOfObject value : array) {
            boolean shouldBeRemoved = value.equals(valueToRemove);
            if (shouldBeRemoved) {
                if (!firstOccurrenceHasBeenRemoved) {
                    result.add(value);
                    firstOccurrenceHasBeenRemoved = true;
                }
            }
        }
        TypeOfObject[] resultArray = Arrays.copyOf(array, array.length - 1);
        return result.toArray(resultArray);
    }


    public static <TypeOfObject> TypeOfObject[] removeFirst(TypeOfObject[] array, TypeOfObject valueToRemove) {
        array = array.clone();
        int size = array.length;
        for (int i = 0; i < size; i++) {
            TypeOfObject currentValue = array[i];
            if (!currentValue.equals(valueToRemove)) {
                continue;
            }
            size--;
            System.arraycopy(array, i + 1, array, i, size - i);

        }
        return array;
    }

    public static <TypeOfObject> TypeOfObject[] merge(TypeOfObject[]... arrays) {
        int totalLen = 0;
        for (TypeOfObject[] arr : arrays) {
            totalLen += arr.length;
        }
        TypeOfObject[] all = (TypeOfObject[]) Array.newInstance(
                arrays.getClass().getComponentType().getComponentType(), totalLen);
        int copied = 0;
        for (TypeOfObject[] arr : arrays) {
            System.arraycopy(arr, 0, all, copied, arr.length);
            copied += arr.length;
        }
        return all;
    }

    public static <T> T[] toArray(List<T> list) {
        T[] toR = (T[]) Array.newInstance(list.get(0).getClass(), list.size());
        for (int i = 0; i < list.size(); i++) {
            toR[i] = list.get(i);
        }
        return toR;
    }

    public static <TypeOfObject> TypeOfObject[] toArray(TypeOfObject[] array, Integer length) {
        return (TypeOfObject[]) Array.newInstance(array.getClass().getComponentType(), length);
    }

    public static <TypeOfObject> TypeOfObject[] replace(TypeOfObject[] array, TypeOfObject valueToReplace, TypeOfObject... valuesToReplaceWith) {
        array = removeElement(array, valueToReplace);
        return null; // TODO
    }

    public static <TypeOfObject> TypeOfObject[] replaceFirst(TypeOfObject[] array, TypeOfObject valueToReplace, TypeOfObject... valuesToReplaceWith) {
        array = removeFirst(array, valueToReplace);
        return null; // TODO
    }
}
