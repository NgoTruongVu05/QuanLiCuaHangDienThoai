import java.util.Scanner;

public class NHANVIEN extends NGUOI {
    private String idnv;
    private int SL_Ban, luong;
    Scanner inp = new Scanner(System.in);

    public NHANVIEN() {
        super();
        idnv = "";
        SL_Ban = 0;
        luong = 0;
    }

    public NHANVIEN(String CCCD, String TEN, String SDT, String DIACHI, int NAMSINH, int tienThuong, String idnv,
            int SL_Ban, int luong) {
        super(CCCD, TEN, SDT, DIACHI, NAMSINH, tienThuong);
        this.idnv = idnv;
        this.SL_Ban = SL_Ban;
        this.luong = luong;
    }

    void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    String getIdnv() {
        return idnv;
    }

    public void setSL_Ban(int SL_Ban) {
        this.SL_Ban = SL_Ban;
    }

    public int getSL_Ban() {
        return SL_Ban;
    }

    public void nhap(boolean coIdnv) {
        if (!coIdnv) {
            System.out.printf("Id nhan vien: ");
            idnv = inp.nextLine();
        }
        super.nhap();
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    @Override
    public void xuat() {
        super.xuat();
        int length1 = -15, length2 = -50;
        System.out.printf("%" + length1 + "s: %" + length2 + "s\n", "Id nhan vien", idnv);
        System.out.printf("%" + length1 + "s: %" + length2 + "s\n", "So luong ban", SL_Ban);
        System.out.printf("%" + length1 + "s: %" + length2 + "d\n", "Luong", tinhLuong());
    }

    @Override
    public int tinhThuong() {
        int temp = 0, soluong = 10, tempSlban = SL_Ban;
        while (tempSlban >= soluong) {
            temp += luong / 50;
            tempSlban -= soluong;
        }
        return temp;
    }

    public int tinhLuong() {
        return luong + tinhThuong();
    }
}