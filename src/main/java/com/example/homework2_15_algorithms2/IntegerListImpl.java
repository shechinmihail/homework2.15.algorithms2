package com.example.homework2_15_algorithms2;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class IntegerListImpl implements IntegerList {

    private Integer[] integerList;

    private final int size;

    public IntegerListImpl(int size) {
        this.integerList = new Integer[size];
        this.size = size;
    }

    @Override
    public Integer add(Integer item) {
        sizeExtension();
        if (item == null) {
            throw new RuntimeException();
        }
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] == null) {
                integerList[i] = item;
                return item;
            }
        }
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        sizeExtension();
        if (index > integerList.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Массив заполнен!");
        }
        if (item == null) {
            throw new RuntimeException("Введите данные!");
        }
        for (int i = integerList.length - 1; i >= 0; i--) {
            if (i > index) {
                integerList[i] = integerList[i - 1];
            }
        }
        integerList[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index >= integerList.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Нет такого индекса");
        }
        if (item == null) {
            throw new RuntimeException("Введите данные!");
        }
        integerList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        if (item == null) {
            throw new RuntimeException("Введите данные!");
        }
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i].equals(item)) {
                throw new IllegalArgumentException();
            } else {
                return integerList[i] = null;
            }
        }
        return null;
    }

    @Override
    public Integer remove(int index) {
        return integerList[index] = null;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] integersCopy = toArray();
        if (item == null) {
            throw new RuntimeException("Введите данные!");
        }
        sortSelection(integersCopy);
        return binarySearch(integersCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] != null && integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = integerList.length - 1; i >= 0; i--) {
            if (integerList[i] != null && integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        return integerList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new RuntimeException("Введите данные!");
        }
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] != null && otherList.get(i) != null) {
                if (!integerList[i].equals(otherList.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int size() {
        int startSize = 0;
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] != null) {
                startSize++;
            }
        }
        return startSize;
    }

    @Override
    public boolean isEmpty() {
        int startSize = 0;
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] != null) {
                startSize++;
            }
        }
        return startSize == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(integerList, null);
    }

    @Override
    public Integer[] toArray() {
        Integer[] integers = new Integer[integerList.length];
        for (int i = 0; i < integerList.length; i++) {
            integers[i] = integerList[i];
        }
        return integers;
    }

    @Override
    public String toString() {
        return "IntegerListImpl{" +
                "integerList=" + Arrays.toString(integerList) +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerListImpl that = (IntegerListImpl) o;
        return size == that.size && Arrays.equals(integerList, that.integerList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(integerList);
        return result;
    }

    private void sizeExtension() {
        if (size == integerList.length) {
            grow();
        }
    }

    public static Integer[] toRandomArrey() {
        Integer[] integers = new Integer[100000];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = new Random().nextInt(1000);
        }
        return integers;
    }

    // Пузырьковая сортировка
    public static void sortBubble(Integer[] integers) {
        for (int i = 0; i < integers.length - 1; i++) {
            for (int j = 0; j < integers.length - 1 - i; j++) {
                if (integers[j] > integers[j + 1]) {
                    swapElements(integers, j, j + 1);
                }
            }
        }
    }

    // Сортировка выбором
    public static void sortSelection(Integer[] integers) {
        for (int i = 0; i < integers.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < integers.length; j++) {
                if (integers[j] < integers[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(integers, i, minElementIndex);
        }
    }

    // Сортировка вставкой
    public static void sortInsertion(Integer[] integers) {
        for (int i = 1; i < integers.length; i++) {
            int temp = integers[i];
            int j = i;
            while (j > 0 && integers[j - 1] >= temp) {
                integers[j] = integers[j - 1];
                j--;
            }
            integers[j] = temp;
        }
    }

    private void sort(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void quickSort(Integer[] arr, int indexA, int indexB) {
        if (indexA < indexB) {
            int partitionIndex = partition(arr, indexA, indexB);

            quickSort(arr, indexA, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, indexB);
        }
    }

    private static int partition(Integer[] arr, int indexA, int indexB) {
        int pivot = arr[indexB];
        int i = (indexA - 1);

        for (int j = indexA; j < indexB; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, indexB);
        return i + 1;
    }

    private static boolean binarySearch(Integer[] integers, Integer item) {
        int min = 0;
        int max = integers.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == integers[mid]) {
                return true;
            }

            if (item < integers[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void grow() {
        integerList = Arrays.copyOf(integerList, size + size / 2);
    }

    public static void main(String[] args) {
        System.out.println("Первый прогон:");
        Integer[] integers1 = IntegerListImpl.toRandomArrey();
        Integer[] integers2 = IntegerListImpl.toRandomArrey();
        Integer[] integers3 = IntegerListImpl.toRandomArrey();
        long start1 = System.currentTimeMillis();
        sortBubble(integers1);
        System.out.println("Пузырьковая сортировка " + (System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        sortSelection(integers2);
        System.out.println("Сортировка выбором " + (System.currentTimeMillis() - start2));
        long start3 = System.currentTimeMillis();
        sortInsertion(integers3);
        System.out.println("Сортировка вставкой " + (System.currentTimeMillis() - start3));

        System.out.println("Второй прогон:");
        Integer[] integers4 = IntegerListImpl.toRandomArrey();
        Integer[] integers5 = IntegerListImpl.toRandomArrey();
        Integer[] integers6 = IntegerListImpl.toRandomArrey();
        long start5 = System.currentTimeMillis();
        sortSelection(integers5);
        System.out.println("Сортировка выбором " + (System.currentTimeMillis() - start5));
        long start6 = System.currentTimeMillis();
        sortInsertion(integers6);
        System.out.println("Сортировка вставкой " + (System.currentTimeMillis() - start6));
        long start4 = System.currentTimeMillis();
        sortBubble(integers4);
        System.out.println("Пузырьковая сортировка " + (System.currentTimeMillis() - start4));

        System.out.println("Третий прогон:");
        Integer[] integers7 = IntegerListImpl.toRandomArrey();
        Integer[] integers8 = IntegerListImpl.toRandomArrey();
        Integer[] integers9 = IntegerListImpl.toRandomArrey();
        long start9 = System.currentTimeMillis();
        sortInsertion(integers9);
        System.out.println("Сортировка вставкой " + (System.currentTimeMillis() - start9));
        long start7 = System.currentTimeMillis();
        sortBubble(integers7);
        System.out.println("Пузырьковая сортировка " + (System.currentTimeMillis() - start7));
        long start8 = System.currentTimeMillis();
        sortSelection(integers8);
        System.out.println("Сортировка выбором " + (System.currentTimeMillis() - start8));
        /**
         * Сортировка выбором самая быстрая из трех прогонов
         */
    }
}
