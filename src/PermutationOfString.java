import java.util.Scanner;

public class PermutationOfString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = new String(scanner.nextLine());
        char[] s = input.toCharArray();
        char[] ketQua = new char[100];
        for (int i = 0; i < 99; i++) {
            ketQua[i] = '0';
        }
        xepChu(ketQua, 0, s);
    }

    public static void xepChu(char[] ketQua, int viTri, char[] input) {
        for (int i = 0; i < input.length; i++) {
            if (ketQua[i] == '0') {
                ketQua[i] = input[viTri];
                if (viTri + 1 < input.length) {
                    xepChu(ketQua, viTri + 1, input);
                    for (int j = 0; j < input.length; j++) {
                        if (ketQua[j] == input[viTri]) ketQua[j] = '0';
                    }
                }
            }
        }
        boolean check = true;
        for (int i = 0; i < input.length; i++) {
            if (ketQua[i] == '0') {
                check = false;
                break;
            }
        }
        if (check) for (int i = 0; i < input.length; i++) {
            System.out.print(ketQua[i]);
        }
        System.out.print(" ");
        for (int i = 0; i < input.length; i++) {
            if (ketQua[i] == input[viTri]) ketQua[i] = '0';
        }
    }
}
