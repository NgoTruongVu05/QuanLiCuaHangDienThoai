import java.util.Scanner;

public class MENU_DSNV {
    Scanner inp = new Scanner(System.in);

    public void menu(DSNV dsnv) {
        while (true) {
            int luachon;
            IN_MENU inmenu1 = new IN_MENU();
            luachon = inmenu1.menu("Nhan Vien", true);
            switch (luachon) {
                case 0 -> {
                    System.out.println("Thoat chuong trinh.");
                    dsnv.luuFile();
                    return;
                }
                case 1 -> dsnv.them();
                case 2 -> {
                    System.out.printf("Nhap ID Nhan Vien: ");
                    String tempIdnv = inp.nextLine();
                    dsnv.capNhat(tempIdnv);
                }
                case 3 -> {
                    System.out.printf("Nhap ID Nhan Vien: ");
                    String tempIdnv = inp.nextLine();
                    dsnv.xoa(tempIdnv);
                }
                case 4 -> {
                    System.out.printf("Nhap ID Nhan Vien: ");
                    String tempIdnv = inp.nextLine();
                    dsnv.timKiem(tempIdnv);
                }
                case 5 -> dsnv.hienThi();
                case 6 -> dsnv.SX_Soluong();
                case 7 -> dsnv.SX_Ten();
                case 8 -> dsnv.XUAT();
                default -> System.out.println("Nhap sai, vui long nhap lai.");
            }
        }
    }
}
