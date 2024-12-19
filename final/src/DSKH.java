import java.util.*;
import java.io.*;

public class DSKH implements iQUANLY, iTIEMNANG {
    private ArrayList<KHACHHANG> ds;
    Scanner sc = new Scanner(System.in);

    public ArrayList<KHACHHANG> getDs() {
        return ds;
    }

    public DSKH() {
        this.ds = new ArrayList<>();
    }

    public DSKH(ArrayList<KHACHHANG> ds) {
        this.ds = ds;
    }

    @Override
    public void them() {
        KHACHHANG kh = new KHACHHANG();
        kh.nhap();
        boolean flag = false;
        for (KHACHHANG x : ds) {
            if (x.getIdkh().equals(kh.getIdkh())) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Khach hang da ton tai trong danh sach");
        } else {
            ds.add(kh);
            System.out.println("Da them khach hang");
        }
    }

    @Override
    public void capNhat(String id) {
        if (ds.isEmpty()) {
            System.out.println("Khong co khach hang nao trong danh sach");
        } else {
            boolean found = false;
            for (KHACHHANG x : ds) {
                if (x.getIdkh().equals(id)) {
                    found = true;
                    System.out.println("Chon thuoc tinh de sua:");
                    System.out.println("1. Ten");
                    System.out.println("2. Sdt");
                    System.out.println("3. Dia chi");
                    System.out.println("4. Nam sinh");
                    System.out.print("Nhap lua chon: ");
                    int chon = sc.nextInt();
                    sc.nextLine();
                    switch (chon) {
                        case 1:
                            System.out.print("Nhap ten moi: ");
                            String ten = sc.nextLine().trim();
                            x.setTen(ten);
                            break;
                        case 2:
                            System.out.println("Nhap so dien thoai moi: ");
                            String sdt = sc.nextLine().trim();
                            x.setSdt(sdt);
                            break;
                        case 3:
                            System.out.print("Nhap dia chi moi: ");
                            String diachi = sc.nextLine().trim();
                            x.setDiaChi(diachi);
                            break;
                        case 4:
                            System.out.print("Nhap nam sinh moi: ");
                            int sn = sc.nextInt();
                            sc.nextLine();
                            x.setNamSinh(sn);
                            break;
                        default:
                            System.out.println("Lua chon khong hop le");
                            break;
                    }
                    break;
                }
            }
            if (!found) {
                System.out.println("Khong tim thay khach hang");
            }
        }
    }

    @Override
    public void xoa(String id) {
        if (ds.isEmpty()) {
            System.out.println("Khong co khach hang nao trong danh sach");
        } else {
            boolean found = false;
            for (KHACHHANG x : ds) {
                if (x.getIdkh().equals(id)) {
                    found = true;
                    ds.remove(x);
                    System.out.println("Da xoa thanh cong");
                    break;
                }
            }
            if (!found) {
                System.out.println("Khong tim thay khach hang");
            }
        }
    }

    @Override
    public void timKiem(String id) {
        if (ds.isEmpty()) {
            System.out.println("Khong co khach hang nao trong danh sach");
        } else {
            for (KHACHHANG x : ds) {
                if (x.getIdkh().equals(id)) {
                    x.xuat();
                    return;
                }
            }
            System.out.println("Khong tim thay khach hang");
        }
    }

    @Override
    public void hienThi() {
        if (ds.isEmpty()) {
            System.out.println("Khong co khach hang nao trong danh sach");
        } else {
            for (KHACHHANG kh : ds) {
                System.out.printf("\nKhach hang:\n");
                kh.xuat();
            }
        }
    }

    public void docFile() {
        try {
            BufferedReader input = new BufferedReader(new FileReader("database/KHACHHANG.txt"));
            String line;
            while ((line = input.readLine()) != null) {
                String arr[] = line.split(",");
                if (arr.length == 9) {
                    String cccd = arr[0];
                    String ten = arr[1];
                    String sdt = arr[2];
                    String diaChi = arr[3];
                    int namSinh = Integer.parseInt(arr[4]);
                    int thuong = Integer.parseInt(arr[5]);
                    String idKH = arr[6];
                    int slMua = Integer.parseInt(arr[7]);
                    int giamGia = Integer.parseInt(arr[8]);
                    KHACHHANG kh = new KHACHHANG(cccd, ten, sdt, diaChi, namSinh, thuong, idKH, slMua, giamGia);
                    ds.add(kh);
                }
            }
            input.close();
        } catch (IOException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    public void luuFile() {
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter("database/KHACHHANG.txt"));
            for (KHACHHANG kh : ds) {
                output.write(kh.getCccd() + "," + kh.getTen() + "," + kh.getSdt() + "," + kh.getDiaChi() + ","
                        + kh.getNamSinh() + "," + kh.getThuong() + "," + kh.getIdkh() + "," + kh.getSL_Mua() + ","
                        + kh.getGiamGia());
                output.newLine();
            }
            output.close();
        } catch (IOException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    @Override
    public void SX_Soluong() {
        if (ds.isEmpty()) {
            System.out.println("Khong co khach hang nao trong danh sach");
        } else {
            Collections.sort(ds, (kh1, kh2) -> Integer.compare(kh1.getSL_Mua(), kh2.getSL_Mua()));
            System.out.println("\nDa sap xep thanh cong.");
        }
    }

    @Override
    public void SX_Ten() {
        if (ds.isEmpty()) {
            System.out.println("Khong co khach hang nao trong danh sach");
        } else {
            Collections.sort(ds, (kh1, kh2) -> kh1.getTen().compareTo(kh2.getTen()));
            System.out.println("\nDa sap xep thanh cong.");
        }
    }

    @Override
    public void XUAT() {
        if (ds.isEmpty()) {
            System.out.println("Khong co khach hang nao trong danh sach");
        } else {
            Collections.sort(ds, (kh1, kh2) -> Integer.compare(kh1.getSL_Mua(), kh2.getSL_Mua()));
            KHACHHANG kh = ds.get(ds.size() - 1);
            kh.xuat();
        }
    }
}