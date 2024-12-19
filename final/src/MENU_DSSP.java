import java.util.Scanner;

public class MENU_DSSP {
    Scanner inp = new Scanner(System.in);

    public void menu(DSSP dssp) {
        while (true) {
            int luachon;
            IN_MENU inmenu1 = new IN_MENU();
            luachon = inmenu1.menu("San Pham", true);
            switch (luachon) {
                case 0 -> {
                    System.out.println("Thoat chuong trinh.");
                    dssp.luuFile();
                    return;
                }
                case 1 -> dssp.them();
                case 2 -> {
                    System.out.printf("Nhap ID San Pham: ");
                    String tempIDsp = inp.nextLine();
                    dssp.capNhat(tempIDsp);
                }
                case 3 -> {
                    System.out.printf("Nhap ID San Pham: ");
                    String tempIDsp = inp.nextLine();
                    dssp.xoa(tempIDsp);
                }
                case 4 -> {
                    System.out.printf("Nhap ID San Pham: ");
                    String tempIDsp = inp.nextLine();
                    dssp.timKiem(tempIDsp);
                }
                case 5 -> dssp.hienThi();
                case 6 -> dssp.SX_Soluong();
                case 7 -> dssp.SX_Ten();
                case 8 -> dssp.XUAT();
                default -> System.out.println("Nhap sai, vui long nhap lai.");
            }
        }
    }
}
