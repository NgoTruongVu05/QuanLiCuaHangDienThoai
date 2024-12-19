import java.util.Scanner;

public class MENU_DSHD {
    Scanner sc = new Scanner(System.in);

    public void TaoHD(DSHD dshd, DSKH dskh, DSNV dsnv, DSSP dssp) {
        boolean run = false;
        HOADON HD = new HOADON();
        boolean fo1 = false;
        boolean fo3 = false;
        System.out.print("Nhap Ma Nhan Vien: ");
        String temp1 = sc.nextLine();
        for (NHANVIEN nv : dsnv.getDs()) {
            if (nv.getIdnv().equals(temp1)) {
                System.out.print("Nhap Ma Khach Hang: ");
                String temp = sc.nextLine();
                for (KHACHHANG kh : dskh.getDs()) {
                    if (kh.getIdkh().equals(temp)) {
                        fo1 = true;
                        run = !dshd.Them(temp, temp1, HD, dshd);
                        while (run) {
                            System.out.print("1.Them san pham.\n2.Thoat.\nNhap lua chon: ");
                            int choice = sc.nextInt();
                            sc.nextLine();
                            if (choice == 1) {
                                boolean fo2 = false;
                                System.out.printf("Nhap ID san pham: ");
                                String IDsptemp = sc.nextLine();
                                for (SANPHAM sp : dssp.getDs()) {
                                    if (sp.getIdSanPham().equals(IDsptemp)) {
                                        fo2 = true;
                                        dshd.ThemChiTiet(IDsptemp, sp.getGia(), HD,dssp);
                                    }
                                }
                                if (!fo2) {
                                    System.out.println("Khong co san pham");
                                }
                            } else if (choice == 2) {
                                kh.setSL_Mua(HD.getTONGSL());
                                kh.setGiamGia(0);
                                nv.setSL_Ban(nv.getSL_Ban()+HD.getTONGSL());
                                dshd.LuuHD(HD,kh.tinhThuong());
                                System.out.println("Thoat chuong trinh.");
                                return;
                            }
                        }
                        if (!fo1) {
                            System.out.println("Khong tim thay khach hang.");
                        }
                    }
                }
            }
        }
        if (!fo3) {
            System.out.println("Khong tim thay nhan vien.");
        }
    }

    public void menu(DSHD dshd, DSKH dskh, DSNV dsnv, DSSP dssp) {
        while (true) {
            int luachon;
            IN_MENU inmenu1 = new IN_MENU();
            luachon = inmenu1.menu("Hoa Don", false);
            switch (luachon) {
                case 0 -> {
                    System.out.println("Thoat chuong trinh.");
                    dshd.luuFile();
                    dskh.luuFile();
                    dssp.luuFile();
                    dsnv.luuFile();
                    return;
                }
                case 1 -> TaoHD(dshd, dskh, dsnv, dssp);
                case 2, 3 -> {
                    System.out.println("Tinh nang dang duoc cap nhat!!!");
                }
                case 4 -> {
                    System.out.printf("Nhap ID Hoa Don: ");
                    int tempIDkh = sc.nextInt();
                    sc.nextLine();
                    dshd.timKiem(tempIDkh);
                }
                case 5 -> dshd.hienThi();
                case 6 -> dshd.SX_Soluong();
                case 7 -> dshd.SX_Ten();
                default -> System.out.println("Nhap sai, vui long nhap lai.");
            }
        }
    }
}