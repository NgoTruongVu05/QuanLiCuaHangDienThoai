import java.util.Scanner;

public class KHACHHANG extends NGUOI {
    private String idkh;
    private int SL_Mua, giamGia;
    Scanner sc = new Scanner(System.in);

    public KHACHHANG() {
        idkh = "";
        SL_Mua = giamGia = 0;
    }

    public KHACHHANG(String cccd, String ten, String sdt, String diaChi, int namSinh, int thuong, String idkh,
            int SL_Mua, int giamGia) {
        super(cccd, ten, sdt, diaChi, namSinh, thuong);
        this.idkh = idkh;
        this.SL_Mua = SL_Mua;
        this.giamGia = giamGia;
    }

    public String getIdkh() {
        return idkh;
    }

    public int getSL_Mua() {
        return SL_Mua;
    }

    public void setSL_Mua(int SL_Mua) {
        this.SL_Mua += SL_Mua;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    @Override
    public void nhap() {
        System.out.print("Nhap Id: ");
        idkh = sc.nextLine().trim();
        super.nhap();
    }

    @Override
    public void xuat() {
        super.xuat();
        int length1 = -15, length2 = -50;
        System.out.printf("%" + length1 + "s: %" + length2 + "s\n", "Id khach hang", idkh);
    }

    @Override
    public int tinhThuong() {
        while (SL_Mua >= 10) {
            giamGia += 2;
            SL_Mua -= 10;
        }
        return giamGia;
    }
}