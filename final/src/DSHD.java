import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DSHD {
    Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    ArrayList<HOADON> dshd;

    public DSHD() {
        dshd = new ArrayList<>();
    }

    public boolean Them(String MaKH, String MaNV, HOADON newHD, DSHD dshd) {
        return newHD.nhapMAKH(MaKH, MaNV, dshd);
    }

    public void ThemChiTiet(String ID, float Gia, HOADON newHD, DSSP dssp) {
        newHD.nhapchitiet(ID, Gia,dssp);
    }

    public void LuuHD(HOADON newHD,int giamGia) {
        newHD.giamGia(giamGia);
        dshd.add(newHD);
    }

    public void HienThi() {
        if (dshd.isEmpty()) {
            System.out.println("Khong ton tai danh sach hoa don.");
        }
        for (HOADON hd : dshd) {
            System.out.println(hd);
        }
    }

    public void timKiem(int MAHOADON) {
        boolean found = false;
        for (HOADON hd : dshd) {
            if (hd.getMAHOADON() == MAHOADON) {
                System.out.println("Da tim thay hoa don: ");
                System.out.println(hd);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay ma hoa don " + MAHOADON);
        }
    }

    public void docFile() {
        try (BufferedReader input = new BufferedReader(new FileReader("database/HOADON.txt"))) {
            String line;
            while ((line = input.readLine()) != null) {
                String[] arr = line.trim().split(",");
                if (arr.length >= 6) {
                    int MAHOADON = Integer.parseInt(arr[0].trim());
                    String MAKH = arr[1].trim();
                    String MANV = arr[2].trim();
                    int TONGSL = Integer.parseInt(arr[3].trim());
                    double TONGTIEN = Double.parseDouble(arr[4].trim());
                    LocalDate ThoiGian = LocalDate.parse(arr[5].trim(), formatter);
                    int LOAISP = Integer.parseInt(arr[6].trim());
                    int GIAMGIA = Integer.parseInt(arr[7].trim());

                    HOADON newHoadon = new HOADON(ThoiGian, MAHOADON, TONGTIEN, TONGSL, MAKH, MANV, LOAISP,GIAMGIA);
                    for (int i = 0; i < LOAISP; i++) {
                        String detailLine = input.readLine();
                        if (detailLine != null) {
                            String[] detailArr = detailLine.trim().split(",");
                            if (detailArr.length == 3) {
                                String ID = detailArr[0].trim();
                                float Gia = Float.parseFloat(detailArr[1].trim());
                                int SoLuong = Integer.parseInt(detailArr[2].trim());
                                ChiTietHoaDon newChiTietHoaDon = new ChiTietHoaDon(SoLuong, ID, Gia);
                                newHoadon.ThemChiTiet(newChiTietHoaDon);
                            }
                        }
                    }
                    dshd.add(newHoadon);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Lỗi khi đọc tệp: " + e.getMessage());
        }
    }

    public void luuFile() {
        try (BufferedWriter output = new BufferedWriter(new FileWriter("database/HOADON.txt"))) {
            for (HOADON hoadon : dshd) {
                output.write(hoadon.getMAHOADON() + "," + hoadon.getMAKH() + "," + hoadon.getMANV() + ","
                        + hoadon.getTONGSL() + "," + hoadon.getTONGTIEN() + ","
                        + hoadon.getThoiGian().format(formatter) + "," + hoadon.getLOAISP() + "," + hoadon.getGiamGia());
                output.newLine();

                for (ChiTietHoaDon chiTietHoaDon : hoadon.getDscthd()) {
                    output.write(
                            chiTietHoaDon.getID() + "," + chiTietHoaDon.getGia() + "," + chiTietHoaDon.getSOLUONG());
                    output.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu tệp: " + e.getMessage());
        }
    }

    public ArrayList<HOADON> getDshd() {
        return dshd;
    }

    public void hienThi() {
        for (HOADON hd : dshd) {
            hd.xuat();
        }
    }

    public void SX_Soluong() {
        if (dshd.isEmpty()) {
            System.out.println("Khong co hoa don nao trong danh sach");
        } else {
            Collections.sort(dshd, (hd1, hd2) -> Integer.compare(hd1.getTONGSL(), hd2.getTONGSL()));
            for (HOADON hd : dshd) {
                hd.xuat();
            }
        }
    }

    public void SX_Ten() {
        if (dshd.isEmpty()) {
            System.out.println("Khong co hoa nao trong danh sach");
        } else {
            Collections.sort(dshd, (hd1, hd2) -> Integer.compare(hd1.getMAHOADON(), hd2.getMAHOADON()));
            for (HOADON hd : dshd) {
                hd.xuat();
            }
        }
    }
}