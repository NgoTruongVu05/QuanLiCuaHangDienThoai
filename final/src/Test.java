public class Test {
    public static void main(String[] args) {
        DSHD dshd = new DSHD();dshd.docFile();
        DSSP dssp = new DSSP();dssp.docFile();
        DSKH dskh = new DSKH();dskh.docFile();
        DSNV dsnv = new DSNV();dsnv.docFile();
        menu mn = new menu();
        mn.menuchinh(dshd, dskh, dsnv, dssp);
    }
}