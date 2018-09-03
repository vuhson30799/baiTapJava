import java.util.Scanner;

public class returnHighestOccurredCharacter {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter String: ");
        String input = new String(scanner.nextLine());
        char[] array = input.toCharArray();
        char aux;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
        int count = 1, i = 0, max = 0;
        int index = 0;
        while (i < array.length-1) {
            while (array[i] == array[i+1]){
                count +=1;
                i ++;
            }
            if (count > max) {
                max = count;
                index = i;
            }
            count = 1;
            i ++;
        }
        System.out.println("Character occur max:" + array[index] + " " + max + " times");
    }

}
