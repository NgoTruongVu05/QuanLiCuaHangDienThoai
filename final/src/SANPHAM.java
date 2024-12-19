import java.util.Scanner;

public class SANPHAM {
    public String idSanPham, hang, model, loai, chip;
    private float kichThuoc, gia, khoiLuong;
    private int dungLuong, ram;
    private static int soLuongTong;
    Scanner inp = new Scanner(System.in);

    public SANPHAM() {
        idSanPham = "";
        hang = "";
        model = "";
        kichThuoc = 0;
        gia = 0;
        khoiLuong = 0;
        dungLuong = 0;
        ram = 0;
        chip = "";
        soLuongTong++;
    }

    public SANPHAM(String idSanPham, String hang, String model, float kichThuoc, float gia, float khoiLuong,
            int dungLuong, int ram, String chip) {
        this.idSanPham = idSanPham;
        this.hang = hang;
        this.model = model;
        this.kichThuoc = kichThuoc;
        this.gia = gia;
        this.khoiLuong = khoiLuong;
        this.dungLuong = dungLuong;
        this.ram = ram;
        this.chip = chip;
        soLuongTong++;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    void setHang(String hang) {
        this.hang = hang;
    }

    String getHang() {
        return hang;
    }

    void setModel(String model) {
        this.model = model;
    }

    String getModel() {
        return model;
    }

    void setKichThuoc(float kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    float getKichThuoc() {
        return kichThuoc;
    }

    void setGia(float gia) {
        this.gia = gia;
    }

    float getGia() {
        return gia;
    }

    void setKhoiLuong(float khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    float getKhoiLuong() {
        return khoiLuong;
    }

    void setDungLuong(int dungLuong) {
        this.dungLuong = dungLuong;
    }

    int getDungLuong() {
        return dungLuong;
    }

    void setRam(int ram) {
        this.ram = ram;
    }

    int getRam() {
        return ram;
    }

    void setChip(String chip) {
        this.chip = chip;
    }

    String getChip() {
        return chip;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public static int getsoLuongTong() {
        return soLuongTong;
    }

    public static void setSoLuongTong(int soLuongTong) {
        SANPHAM.soLuongTong = soLuongTong;
    }

    public void nhap(String idSanPham) {
        this.idSanPham = idSanPham;
        while (true) {
            try {
                System.out.printf("Nhap hang: ");
                hang = inp.nextLine();
                System.out.printf("Model: ");
                model = inp.nextLine();
                System.out.printf("Kich thuoc: ");
                kichThuoc = Float.parseFloat(inp.nextLine());
                System.out.printf("Gia: ");
                gia = Float.parseFloat(inp.nextLine());
                System.out.printf("Khoi luong: ");
                khoiLuong = Float.parseFloat(inp.nextLine());
                System.out.printf("Dung luong: ");
                dungLuong = Integer.parseInt(inp.nextLine());
                System.out.printf("Ram: ");
                ram = Integer.parseInt(inp.nextLine());
                System.out.printf("Chip: ");
                chip = inp.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("\nNhap sai thong tin, vui long nhap lai.");
            }
        }
    }

    public void xuat() {
        int length1 = -15, length2 = -50;
        System.out.printf("\n%" + length1 + "s: %" + length2 + "s\n", "Id san pham", idSanPham);
        System.out.printf("%" + length1 + "s: %" + length2 + "s\n", "Hang", hang);
        System.out.printf("%" + length1 + "s: %" + length2 + "s\n", "Model", model);
        System.out.printf("%" + length1 + "s: %" + length2 + ".2f\n", "Kich thuoc", kichThuoc);
        System.out.printf("%" + length1 + "s: %" + length2 + ".2f\n", "Gia", gia);
        System.out.printf("%" + length1 + "s: %" + length2 + ".2f\n", "Khoi luong", khoiLuong);
        System.out.printf("%" + length1 + "s: %" + length2 + "d\n", "Dung luong", dungLuong);
        System.out.printf("%" + length1 + "s: %" + length2 + "d\n", "Ram", ram);
        System.out.printf("%" + length1 + "s: %" + length2 + "s\n", "Chip", chip);
    }
}