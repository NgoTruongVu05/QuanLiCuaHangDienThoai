import java.util.Scanner;

public class menu {
    Scanner sc = new Scanner(System.in);

    public void menuchinh(DSHD dshd, DSKH dskh, DSNV dsnv, DSSP dssp) {
        while (true) {
            int choice = 0;
            System.out.print(
                    "\n1. Quan Ly San Pham.\n2. Quan Ly Khach Hang.\n3. Quan Ly Nhan Vien.\n4. Quan Ly Hoa Don.\n0.Thoat chuong trinh.\nNhap lua chon: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 0 ->{
                        System.out.println("Thoat chuong trinh.");
                        return;
                    }
                    case 1 -> {
                        MENU_DSSP menu_DSSP = new MENU_DSSP();
                        menu_DSSP.menu(dssp);
                    }
                    case 2 -> {
                        MENU_DSKH menu_DSKH = new MENU_DSKH();
                        menu_DSKH.menu(dskh);
                    }
                    case 3 -> {
                        MENU_DSNV menu_DSNV = new MENU_DSNV();
                        menu_DSNV.menu(dsnv);
                    }
                    case 4 -> {
                        MENU_DSHD menu_DSHD = new MENU_DSHD();
                        menu_DSHD.menu(dshd, dskh, dsnv, dssp);
                    }
                    default -> {
                        System.out.println("Lua chon khong hop le!!");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Lua chon khong hop le!!!");
            }
        }
    }
}
