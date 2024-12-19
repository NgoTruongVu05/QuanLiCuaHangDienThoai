import java.util.Scanner;

public abstract class NGUOI {
    private String cccd, ten, sdt, diaChi;
    private int namSinh, thuong;
    Scanner inp = new Scanner(System.in);

    public NGUOI() {
        cccd = "";
        ten = "";
        sdt = "";
        diaChi = "";
        namSinh = 0;
        thuong = 0;
    }

    public NGUOI(String cccd, String ten, String sdt, String diaChi, int namSinh, int thuong) {
        this.cccd = cccd;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.namSinh = namSinh;
        this.thuong = thuong;
    }

    void setCccd(String cccd) {
        this.cccd = cccd;
    }

    String getCccd() {
        return cccd;
    }

    void setTen(String ten) {
        this.ten = ten;
    }

    String getTen() {
        return ten;
    }

    void setSdt(String sdt) {
        this.sdt = sdt;
    }

    String getSdt() {
        return sdt;
    }

    void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    String getDiaChi() {
        return diaChi;
    }

    void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    int getNamSinh() {
        return namSinh;
    }

    public int getThuong() {
        return thuong;
    }

    public void setThuong(int thuong) {
        this.thuong = thuong;
    }

    public void nhap() {
        System.out.printf("\nNhap cccd: ");
        cccd = inp.nextLine();
        System.out.printf("ten: ");
        ten = inp.nextLine();
        System.out.printf("So dien thoai: ");
        sdt = inp.nextLine();
        System.out.printf("Dia chi: ");
        diaChi = inp.nextLine();
        while (true) {
            try {
                System.out.printf("Nam sinh: ");
                namSinh = Integer.parseInt(inp.nextLine());
                if (namSinh > 1950 && namSinh<=2024)
                    break;
                else
                    System.out.println("\nNam sinh yeu cau tren 1950 va duoi 2025.\n");
            } catch (Exception e) {
                System.out.println("\nNam sinh bat buoc la so.");
            }
        }
    }

    public void xuat() {
        int length1 = -15, length2 = -50;
        System.out.printf("%" + length1 + "s: %" + length2 + "s\n", "Cccd", cccd);
        System.out.printf("%" + length1 + "s: %" + length2 + "s\n", "Ten", ten);
        System.out.printf("%" + length1 + "s: %" + length2 + "s\n", "So dien thoai", sdt);
        System.out.printf("%" + length1 + "s: %" + length2 + "s\n", "Dia chi", diaChi);
        System.out.printf("%" + length1 + "s: %" + length2 + "d\n", "Nam sinh", namSinh);
    }

    abstract public int tinhThuong();
}