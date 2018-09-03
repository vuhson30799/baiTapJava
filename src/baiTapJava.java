import java.util.Scanner;

public class baiTapJava {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        chuyenCoSo();
        fibonaci();
//        daoNguocTuTrongChuoi();
//        tinhToHopCnk();
//        phanTichThuaSoNguyenTo();
//        KtraChuoiCon();
    }

    public static void chuyenCoSo() {
        System.out.println("Nhâp số tự nhiên hệ 10");
        int soTuNhien = scanner.nextInt();
        System.out.println("Nhập hệ cơ số cần chuyển đổi: ");
        int heCoSo = 1, viTri = 1;
        int ketQua = 0;

        do {
            heCoSo = scanner.nextByte();
        } while (heCoSo < 1 || heCoSo > 32);

        // chuyển đổi hệ cơ số <10

        while (soTuNhien != 0) {
            ketQua += (soTuNhien % heCoSo) * viTri;
            soTuNhien /= heCoSo;
            viTri *= 10;
        }
        System.out.printf("Kết quả sau khi chuyển từ cơ số 10 -> cơ số %d là : %d", heCoSo, ketQua);


        // tối ưu code bằng class StringBuilder

        StringBuilder chuoiKetQua = new StringBuilder();
        while (soTuNhien != 0) {
            if (heCoSo > 10) {
                if (soTuNhien % heCoSo >= 10) {
                    chuoiKetQua.append((char) (soTuNhien % heCoSo + 55));
                    soTuNhien /= heCoSo;
                } else {
                    chuoiKetQua.append(soTuNhien % heCoSo);
                    soTuNhien /= heCoSo;
                }
            } else {
                chuoiKetQua.append(soTuNhien % heCoSo);
                soTuNhien /= heCoSo;
            }
        }
        chuoiKetQua.reverse();
        System.out.printf("Kết quả sau khi chuyển từ cơ số 10 -> cơ số %d là : %s", heCoSo, chuoiKetQua);
    }

    public static void fibonaci() {
        System.out.println(" Nhập vị trí số fibo cần tính: ");
        int viTriFibo = scanner.nextInt();
        if (viTriFibo == 0) System.out.printf("F%d= 0", viTriFibo);
        else if (viTriFibo == 1 || viTriFibo == 2) System.out.printf("F%d= 1", viTriFibo);
        else System.out.printf("F%d= %d", viTriFibo, fibo(viTriFibo));
    }

    public static int fibo(int viTriFibo) {
        if (viTriFibo == 1) return 1;
        if (viTriFibo == 2) return 1;
        while (viTriFibo >= 1) {
            return (fibo(viTriFibo - 2) + fibo(viTriFibo - 1));
        }
        return 0;
    }

    public static void daoNguocTuTrongChuoi() {

        // dùng các phương thức hàm string

        System.out.println("Nhập chuỗi cần đảo ngược");
        String chuoiNhapVao = new String(scanner.nextLine());
        String[] splittedchuoi = chuoiNhapVao.split(" ");
        StringBuilder chuoiKetQua = new StringBuilder();
        for (int i = 0; i < splittedchuoi.length; i++) {
            StringBuilder build = new StringBuilder(splittedchuoi[i]);
            System.out.print(build.reverse() + " ");
        }

        // dùng cách phổ thông

        char[] stringArr = chuoiNhapVao.toCharArray();
        int endWord = stringArr.length - 1;
        char TrungGian;
        for (int i = stringArr.length - 1; i > 0; i--) {
            if (stringArr[i] == ' ') {
                for (int j = i + 1; j <= (endWord + i + 1) / 2; j++) {
                    TrungGian = stringArr[j];
                    stringArr[j] = stringArr[i + 1 + endWord - j];
                    stringArr[i + 1 + endWord - j] = TrungGian;
                }
                endWord = i - 1;
            }
        }
        for (int i = 0; i < chuoiNhapVao.indexOf(" ") / 2; i++) {
            TrungGian = stringArr[i];
            stringArr[i] = stringArr[chuoiNhapVao.indexOf(" ") - 1 - i];
            stringArr[chuoiNhapVao.indexOf(" ") - 1 - i] = TrungGian;
        }
        for (int i = 0; i < stringArr.length; i++) {
            System.out.print(stringArr[i]);
        }

    }

    public static void tinhToHopCnk() {
        System.out.println("Nhập số nguyên dương n ");
        int n = scanner.nextInt();
        System.out.println("Nhập số nguyên dương k");
        int k = scanner.nextInt();
        System.out.println("Cnk= " + Cnk(n, k));
    }

    public static int Cnk(int n, int k) {
        if (k == n) return 1;
        if (k == 0) return 1;
        return (Cnk(n - 1, k - 1) + Cnk(n - 1, k));
    }

    public static void phanTichThuaSoNguyenTo() {
        System.out.println("Nhập số nguyên dương cân phân tích");
        int input = scanner.nextInt();
        int i = 2, dem = 0;
        while (input != 1) {
            dem = 0;
            if (KtraSoNgTo(i)) {
                while (input % i == 0) {
                    dem += 1;
                    input /= i;
                }
                if (dem != 0) System.out.print(i + "^" + dem + ".");
            }
            i++;
        }
    }


    public static boolean KtraSoNgTo(int number) {
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void KtraChuoiCon (){
        System.out.println("Nhập chuôi cần kiểm tra");
        String chuoiNhapVao = new String(scanner.nextLine());
        System.out.println("Nhập chuỗi bất kì");
        String chuoiCon = new String(scanner.nextLine());
        if (chuoiNhapVao.indexOf(chuoiCon) != -1) System.out.println("chuỗi bất kì là chuỗi con của chuỗi cần kiểm tra");
    }
}
