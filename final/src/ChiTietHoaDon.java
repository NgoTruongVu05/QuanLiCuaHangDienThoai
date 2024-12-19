import java.util.Scanner;

public class ChiTietHoaDon {
    Scanner sc = new Scanner(System.in);
    private int SOLUONG;
    private String ID;
    private float Gia;

    // Constructor
    public ChiTietHoaDon() {
        SOLUONG = 0;
        Gia = 0;
        ID = "";
    }

    public ChiTietHoaDon(int SOLUONG, String ID, float Gia) {
        this.SOLUONG = SOLUONG;
        this.ID = ID;
        this.Gia = Gia;
    }

    // Getter
    public int getSOLUONG() {
        return SOLUONG;
    }

    public String getID() {
        return ID;
    }

    public float getGia() {
        return Gia;
    }

    // setter
    public void setSOLUONG(int sOLUONG) {
        SOLUONG = sOLUONG;
    }

    public void setMODEL(String mODEL) {
        ID = mODEL;
    }

    public void setGia(float gia) {
        Gia = gia;
    }

    // Phương thức
    public void nhap(String ID, float Gia) {
        this.ID = ID;
        this.Gia = Gia;
        System.out.print("Nhap So Luong: ");
        SOLUONG = sc.nextInt();
    }
}