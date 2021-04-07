import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {

        int[] result = countingSoft(new int[]{3, 1, 1, 2, 1, 3, 2, 3, 2, 1});

        System.out.println(Arrays.toString(result));
    }

    static int[] countingSoft(int[] numbers){

        int maxNum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxNum) {
                maxNum = numbers[i];
            }
        }
        int[] numbersCount = new int[maxNum + 1];
        int[] result = new int[numbers.length];

        for (int index = 0; index < numbers.length; index++) {
            int num = numbers[index];
            numbersCount[num]++;
        }
        for (int index = 1; index < numbersCount.length; index++) {
            numbersCount[index] += numbersCount[index - 1];
        }
        for (int index = 0; index < numbers.length; index++) {
            int num = numbers[index];
            numbersCount[num]--;
            int pos = numbersCount[num];
            result[pos] = num;
        }
        return result;
    }
}
