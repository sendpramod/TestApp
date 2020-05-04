
public class DecodeMap {
    public static void main(String[] args) {
        String str = "17";
        //System.out.println(decodeData(str.toCharArray(), str.length()));
        //char digits[] = {'1','0'};
        //int n = digits.length;
        // System.out.println("Count is " +
        //         countDecodingDP(digits, n));
    }


    static int countDecodingDP(char digits[],
                               int n) {
        // A table to store results of subproblems
        int count[] = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        if (digits[0] == '0')   //for base condition "01123" should return 0
            return 0;
        for (int i = 2; i <= n; i++) {
            count[i] = 0;

            // If the last digit is not 0,
            // then last digit must add to
            // the number of words
            if (digits[i - 1] > '0')
                count[i] = count[i - 1];

            // If second last digit is smaller
            // than 2 and last digit is smaller
            // than 7, then last two digits
            // form a valid character
            if (digits[i - 2] == '1' ||
                    (digits[i - 2] == '2' &&
                            digits[i - 1] < '7'))
                count[i] += count[i - 2];
        }
        return count[n];
    }


    public static int decodeData(char[] array, int index) {
        System.out.println("Index: " + index);
        if (index == 0) return 1;
        int startIndex = array.length - index;
        System.out.println("Index: " + index + " start index " + startIndex);
        if (array[startIndex] == '0') return 0;
        int result = decodeData(array, index - 1);
        System.out.println("Index: " + index + " res " + result);
        if (startIndex + 1 < array.length && ((array[startIndex] == '1' || array[startIndex] == '2') && array[startIndex + 1] < '7')) {
            result += decodeData(array, index - 2);
            System.out.println("Index2: " + index + " res " + result);
        }
        System.out.println("Index: " + index + " res " + result);
        return result;
    }
}
