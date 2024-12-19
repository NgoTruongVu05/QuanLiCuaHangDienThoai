import java.util.Scanner;

public class MENU_DSKH {
    Scanner inp = new Scanner(System.in);

    public void menu(DSKH dskh) {
        while (true) {
            int luachon;
            IN_MENU inmenu1 = new IN_MENU();
            luachon = inmenu1.menu("Khach Hang", true);
            switch (luachon) {
                case 0 -> {
                    System.out.println("Thoat chuong trinh.");
                    dskh.luuFile();
                    return;
                }
                case 1 -> dskh.them();
                case 2 -> {
                    System.out.printf("Nhap ID khach hang: ");
                    String tempIDkh = inp.nextLine();
                    dskh.capNhat(tempIDkh);
                }
                case 3 -> {
                    System.out.printf("Nhap ID khach hang: ");
                    String tempIDkh = inp.nextLine();
                    dskh.xoa(tempIDkh);
                }
                case 4 -> {
                    System.out.printf("Nhap ID khach hang: ");
                    String tempIDkh = inp.nextLine();
                    dskh.timKiem(tempIDkh);
                }
                case 5 -> dskh.hienThi();
                case 6 -> dskh.SX_Soluong();
                case 7 -> dskh.SX_Ten();
                case 8 -> dskh.XUAT();
                default -> System.out.println("Nhap sai, vui long nhap lai.");
            }
        }
    }
}
