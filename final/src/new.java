
public void them() {
    do{
        System.out.println("\nNhap id san pham: ");
        int tempId = inp.nextLine();
        int flag=0;
        for (SANPHAM sanpham : ds) {
            if (sanpham.getIdSanPham().equals(sanpham)) {
                System.out.println("\nDa trung id, vui long nhap lai.");
                flag=1;
            }
        }
    } while(flag==1);
    SANPHAM newSanpham = new SANPHAM();
    newSanpham.setIdSanPham(tempId);
    newSanpham.nhap();
    ds.add(newSanpham);
}