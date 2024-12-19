import java.util.Scanner;

class TABLET extends SANPHAM {
    private boolean banPhim;
    private int soLuong;
    Scanner inp = new Scanner(System.in);

    public TABLET() {
        this.banPhim = false;
        soLuong = 0;
        loai="Tablet";
    }

    public TABLET(String idSanPham, String hang, String model, float kichThuoc, float gia, float khoiLuong,
        int dungLuong, int ram, String chip, boolean banPhim, int soLuong) {
        super(idSanPham, hang, model, kichThuoc, gia, khoiLuong, dungLuong, ram, chip);
        this.banPhim = banPhim;
        this.soLuong = soLuong;
        loai="Tablet";
    }

    @Override
    public void nhap(String idSanPham) {
        super.nhap(idSanPham);
        int luachon;
        do {
            System.out.printf("Ban Phim (1. Co, 2. Khong): ");
            luachon = inp.nextInt();
        } while (luachon != 1 && luachon != 2);
        if (luachon == 1)
            banPhim = true;
        else
            banPhim = false;
    }

    @Override
    public void xuat() {
        super.xuat();
        int length1=-15,length2=-50;
        System.out.printf("%" + length1 + "s: %" + length2 + "s\n","Ban phim", (banPhim ? "Co" : "Khong"));
        System.out.printf("%" + length1 + "s: %" + length2 + "d\n","So luong", soLuong);
    }

    public boolean getBanPhim() {
        return banPhim;
    }

    public int getsoLuong() {
        return soLuong;
    }

    public void setsoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}