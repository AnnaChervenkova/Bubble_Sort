import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] numbers = {12, 43, 22, 52, 1, 32, 5};
        selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    static void selectionSort(int[] numbers){

        int start = 0;
        int end = numbers.length - 1;

        for (int sortedCount = 1; sortedCount < numbers.length / 2; sortedCount++) {
            int maxIndex = start;
            int minIndex = start;

            for (int index = start; index < end; index++) {
                if (numbers[index] > numbers[maxIndex]) {
                    maxIndex = index;
                }
                if (numbers[index] < numbers[minIndex]){
                    minIndex = index;
                }
            }
            int temp = numbers[maxIndex];
            numbers[maxIndex] = numbers[numbers.length - sortedCount];
            numbers[numbers.length - sortedCount] = temp;

            if (minIndex == end) {
                minIndex = maxIndex;
            }
            temp = numbers[minIndex];
            numbers[minIndex] = numbers[start];
            numbers[start] = temp;
            end--;
            start++;
        }
    }
}
