public abstract class Anggota {
    // Atribut (state) - boleh ada di abstract class
    protected String id;
    protected String nama;

    // Constructor - boleh ada, tapi tidak bisa dipanggil langsung dengan new
    public Anggota(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    // METHOD KONKRIT - boleh di-share ke semua subclass
    public void tampilkanInfo() {
        System.out.println("ID : " + id);
        System.out.println("Nama : " + nama);
    }

    // METHOD ABSTRAK - wajib di-override di subclass (tidak punya badan)
    public abstract int getLimitPinjamBuku();
    
    public abstract double hitungDenda(int terlambatHari);
}