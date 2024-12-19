import java.util.*;
import java.time.LocalDate;

public class HOADON {
    Scanner sc = new Scanner(System.in);
    LocalDate ThoiGian;
    private int MAHOADON;
    private double TONGTIEN;
    private int LOAISP;
    private int TONGSL;
    private String MAKH;
    private String MANV;
    private int giamGia;
    private ArrayList<ChiTietHoaDon> dscthd = new ArrayList<>();

    public HOADON() {
        LOAISP = 0;
        TONGSL = 0;
        giamGia = 0;
    }

    // constructor
    public HOADON(LocalDate ThoiGian, int MAHOADON, double TONGTIEN, int TONGSL, String MAKH, String MAVN, int LOAISP, int GIAMGIA) {
        this.LOAISP = LOAISP;
        this.ThoiGian = ThoiGian;
        this.MAHOADON = MAHOADON;
        this.TONGTIEN = TONGTIEN;
        this.TONGSL = TONGSL;
        this.MAKH = MAKH;
        this.MANV = MAVN;
        this.giamGia = GIAMGIA;
    }

    // Getter
    public int getGiamGia() {
        return giamGia;
    }
    
    public String getMANV() {
        return MANV;
    }
    public double getTONGTIEN() {
        return TONGTIEN;
    }

    public LocalDate getThoiGian() {
        return ThoiGian;
    }

    public int getLOAISP() {
        return LOAISP;
    }

    public int getMAHOADON() {
        return MAHOADON;
    }

    // Prototype
    public void nhapchitiet(String ID, float Gia,DSSP dssp) {
        ChiTietHoaDon cthd = new ChiTietHoaDon();
        cthd.nhap(ID, Gia);
        
        for(SANPHAM sp: dssp.getDs()){
            if(sp.getIdSanPham().equals(ID)){
                if(sp instanceof DIENTHOAI dt){
                    if(cthd.getSOLUONG() > dt.getSoLuong()){
                        System.out.println("Khong du so luong san pham con ton!!!");
                        return;
                    }
                    dt.setSoLuong(dt.getSoLuong() - cthd.getSOLUONG());
                }
                else if(sp instanceof TABLET tablet){
                    if(cthd.getSOLUONG() > tablet.getsoLuong()){
                        System.out.println("Khong du so luong san pham con ton!!!");
                        return;
                    }
                    tablet.setsoLuong(tablet.getsoLuong() - cthd.getSOLUONG());
                }
            }
        }
        this.LOAISP++;
        this.TONGSL += cthd.getSOLUONG();
        this.TONGTIEN += cthd.getSOLUONG() * cthd.getGia();
        dscthd.add(cthd);
    }

    public void giamGia(int giamGia){
        if (giamGia!=0){
            TONGTIEN = TONGTIEN - (TONGTIEN*giamGia/100);
            this.giamGia=giamGia;
        }
    }

    public String getMAKH() {
        return MAKH;
    }

    public int getTONGSL() {
        return TONGSL;
    }

    public ArrayList<ChiTietHoaDon> getDscthd() {
        return dscthd;
    }

    public void ThemChiTiet(ChiTietHoaDon chiTietHoaDon) {
        dscthd.add(chiTietHoaDon);
    }

    public boolean nhapMAKH(String MaKH,String MaNV, DSHD dshd) {
        boolean daco = false;
        ThoiGian = LocalDate.now();
        this.MAKH = MaKH;
        this.MANV = MaNV;
        System.out.print("Nhap Ma Hoa Don(int): ");
        int MAHOADON = sc.nextInt();
        for (HOADON hd : dshd.getDshd()) {
            if (hd.getMAHOADON() == MAHOADON) {
                daco = true;
            }
        }
        if (!daco)
            this.MAHOADON = MAHOADON;
        else{
            System.out.println("Ma hoa don da ton tai.");
        }
        return daco;
    }

    public void xuat() {
        System.out.println("======================================================");
        System.out.println("Ma hoa don: " + MAHOADON);
        System.out.println("Ma khach hang: " +  MAKH);
        System.out.println("Ma nhan vien: " + MANV);
        System.out.printf("|%10s|%10s|%10s|%10s|\n", "San Pham", "So Luong", "Don gia", "Thanh Tien");
        for (ChiTietHoaDon cthd : dscthd) {
            System.out.printf("|%10s|%10d|%10.2f|%10.2f|\n", cthd.getID(), cthd.getSOLUONG(), cthd.getGia(),
            cthd.getGia() * cthd.getSOLUONG());
        }
        System.out.println("Tong so luong: "+ TONGSL);
        System.out.println("Giam gia : " + giamGia + "%");
        System.out.println("Thoi Gian: " + ThoiGian);
        System.out.println("Tong Tien: " + TONGTIEN);
    }
}