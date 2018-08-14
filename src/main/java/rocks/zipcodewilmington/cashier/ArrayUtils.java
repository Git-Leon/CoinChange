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


    public static <TypeOfObject> TypeOfObject[] removeFirst(TypeOfObject[] array, TypeOfObject valueToRemove) {
        TypeOfObject[] result = Arrays.copyOf(array, array.length - 1);
        List<TypeOfObject> tempList = new ArrayList<>();
        tempList.addAll(Arrays.asList(array));
        tempList.remove(valueToRemove);
        return tempList.toArray(result);
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


    public static <T> int getNumberOfOccurences(T[] objectArray, T value) {
        int occurrences = 0;
        for (T val : objectArray) {
            boolean sameValue = val.equals(value);
            if (sameValue) {
                occurrences++;
            }
        }
        return occurrences;
    }

    public static <T> T[] removeValue(T[] array, T valToRemove) {
        int numberOfOccurrences = ArrayUtils.getNumberOfOccurences(array, valToRemove);
        int newArrayLength = array.length - numberOfOccurrences;
        T[] newArray = Arrays.copyOf(array, newArrayLength); // prevents casting issues

        for (int i = 0, j = 0; j < newArrayLength; i++) {
            T currentValue = array[i];

            if (!currentValue.equals(valToRemove)) {
                newArray[j] = currentValue;
                j++;
            }
        }
        return newArray;
    }


    public static <T> boolean contains(T[] objectArray, T value) {
        return getNumberOfOccurences(objectArray, value) > 0;
    }
}
