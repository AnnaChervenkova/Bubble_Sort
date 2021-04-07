import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {

        int[] result = radixSort(new int[]{3213, 1322, 123, 221, 9731, 233, 92, 23, 9, 85181});

        System.out.println(Arrays.toString(result));
    }

    static int kthDigit(int num, int k){

        int tenOnKth = (int) Math.pow(10, k-1);
        return (num / tenOnKth) % 10;
    }

    static int[] countingSort(int[] numbers, int digit){
        int[] numbersCount = new int[10];
        int[] result = new int[numbers.length];

        for (int index = 0; index < numbers.length; index++) {
            int num = kthDigit(numbers[index], digit);
            numbersCount[num]++;
        }
        for (int index = 1; index < numbersCount.length; index++) {
            numbersCount[index] += numbersCount[index - 1];
        }
        for (int index = numbers.length - 1; index >= 0 ; index--) {
            int num = numbers[index];
            int numDigit = kthDigit(num, digit);
            numbersCount[numDigit]--;
            int pos = numbersCount[numDigit];
            result[pos] = num;
        }
        return result;
    }

    static int getMaxNum(int numbers[]){
        int max = numbers[0];
        for (int index = 1; index < numbers.length; index++) {
            if (numbers[index] > max) {
                max = numbers[index];
            }
        }
        return max;
    }

    static int getNumOfDigit(int num){
        int digitCount = 0;
        while (num > 0) {
            num /= 10;
            digitCount++;
        }
        return digitCount;
    }

    static int[] radixSort(int[] numbers){
        int maxDigit = getNumOfDigit(getMaxNum(numbers));

        for (int digit = 1; digit <= maxDigit; digit++) {
            numbers = countingSort(numbers, digit);
        }
        return numbers;
    }
}
