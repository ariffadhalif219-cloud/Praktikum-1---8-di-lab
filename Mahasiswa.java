public class Mahasiswa extends Anggota {
    private String nim;

    public Mahasiswa(String id, String nama, String nim) {
        super(id, nama); // Wajib panggil constructor parent
        this.nim = nim;
    }

    @Override
    public int getLimitPinjamBuku() {
        return 5; // Mahasiswa boleh pinjam 5 buku
    }

    @Override
    public double hitungDenda(int terlambatHari) {
        return terlambatHari * 1000; // Rp 1000 per hari keterlambatan
        
    }
}