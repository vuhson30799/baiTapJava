public class checkReverseNumber {
    public static void main (String args[]){
        int number = 0;
        for (int i = 100000; i < 200000; i++) {
            if (checkReverseNumber(i)) System.out.println(i);
        }
    }
    public static boolean checkReverseNumber (int number){

        // cách làm phổ thông

        /*char[] numberArr = new char[50];
        int i = 0;
        while (number != 0){
            numberArr[i] = (char) (number % 10 + 48);
            number /= 10;
            i++;
        }
        for (int j = 0; j <= (i-1)/2 ; j++) {
            if (numberArr[j] != numberArr[i-1-j]) return false;
        }
        return true;*/

        // Use method of String
        StringBuilder numberStr = new StringBuilder();
        numberStr.append(number);
        if (numberStr.equals(numberStr.reverse())) return true;
        return false;

    }
}
