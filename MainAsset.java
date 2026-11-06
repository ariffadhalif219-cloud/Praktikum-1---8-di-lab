import java.util.ArrayList;

// ==========================================
// 1. ABSTRACT CLASS: AsetDigital
// ==========================================
abstract class AsetDigital {
    protected String id;
    protected String namaFile;
    protected double ukuranMB;

    // Konstruktor
    public AsetDigital(String id, String namaFile, double ukuranMB) {
        this.id = id;
        this.namaFile = namaFile;
        this.ukuranMB = ukuranMB;
    }

    // Method abstrak yang wajib di-override oleh subclass
    public abstract void tampilkanPreview();

    // Method konkrit untuk mencetak info dasar
    public void getInfo() {
        System.out.println("ID        : " + id);
        System.out.println("Nama File : " + namaFile);
        System.out.println("Ukuran    : " + ukuranMB + " MB");
    }
}

// ==========================================
// 3. INTERFACE: DapatDipromosikan
// ==========================================
interface DapatDipromosikan {
    void promosikan();

    default void infoPromosi() {
        System.out.println("Status    : Aset ini sedang dalam program promosi khusus.");
    }
}

// ==========================================
// 2. SUBCLASS KONKRIT: Gambar, Video, Dokumen
// ==========================================
class Gambar extends AsetDigital {
    private String resolusi;

    public Gambar(String id, String namaFile, double ukuranMB, String resolusi) {
        super(id, namaFile, ukuranMB);
        this.resolusi = resolusi;
    }

    @Override
    public void tampilkanPreview() {
        System.out.println("--- Preview Aset Gambar ---");
        getInfo();
        System.out.println("Resolusi  : " + resolusi);
    }
}

class Video extends AsetDigital {
    private int durasiMenit;

    public Video(String id, String namaFile, double ukuranMB, int durasiMenit) {
        super(id, namaFile, ukuranMB);
        this.durasiMenit = durasiMenit;
    }

    @Override
    public void tampilkanPreview() {
        System.out.println("--- Preview Aset Video ---");
        getInfo();
        System.out.println("Durasi    : " + durasiMenit + " menit");
    }
}

class Dokumen extends AsetDigital {
    private int jumlahHalaman;

    public Dokumen(String id, String namaFile, double ukuranMB, int jumlahHalaman) {
        super(id, namaFile, ukuranMB);
        this.jumlahHalaman = jumlahHalaman;
    }

    @Override
    public void tampilkanPreview() {
        System.out.println("--- Preview Aset Dokumen ---");
        getInfo();
        System.out.println("Halaman   : " + jumlahHalaman + " halaman");
    }
}

// ==========================================
// 4. SUBCLASS: VideoPromosi (Inherit Video & Implement Interface)
// ==========================================
class VideoPromosi extends Video implements DapatDipromosikan {

    public VideoPromosi(String id, String namaFile, double ukuranMB, int durasiMenit) {
        super(id, namaFile, ukuranMB, durasiMenit);
    }

    @Override
    public void promosikan() {
        System.out.println("[PROMOSI] Video " + namaFile + " sedang dipromosikan di beranda utama!");
    }
}

// ==========================================
// 5. CLASS MAIN: MainAsset
// ==========================================
public class MainAsset {
    public static void main(String[] args) {
        // A. Membuat ArrayList<AsetDigital> berisi minimal 1 objek dari masing-masing subclass[cite: 9]
        ArrayList<AsetDigital> daftarAset = new ArrayList<>();
        daftarAset.add(new Gambar("G001", "pemandangan.jpg", 4.5, "1920x1080"));
        daftarAset.add(new Video("V001", "tutorial_java.mp4", 150.0, 45));
        daftarAset.add(new Dokumen("D001", "laporan_lkm.pdf", 2.1, 15));
        daftarAset.add(new VideoPromosi("VP001", "iklan_produk.mp4", 85.0, 2));

        System.out.println("=== ITERASI & POLIMORFISME (ABSTRACT CLASS) ===");
        // B. Iterasi dan panggil tampilkanPreview() — polimorfisme via abstract class[cite: 9]
        for (AsetDigital aset : daftarAset) {
            aset.tampilkanPreview();
            
            // C. Gunakan instanceof untuk mengecek objek yang mengimplementasi DapatDipromosikan dan panggil promosikan()[cite: 9]
            if (aset instanceof DapatDipromosikan) {
                ((DapatDipromosikan) aset).promosikan();
                ((DapatDipromosikan) aset).infoPromosi();
            }
            System.out.println("------------------------------------------");
        }

        // D. Buat ArrayList<DapatDipromosikan> terpisah dan tambahkan VideoPromosi ke dalamnya (polimorfisme via interface)[cite: 9]
        ArrayList<DapatDipromosikan> daftarPromo = new ArrayList<>();
        daftarPromo.add((VideoPromosi) daftarAset.get(3)); // Menambahkan VideoPromosi yang ada di list sebelumnya

        System.out.println("\n=== POLIMORFISME VIA INTERFACE (ArrayList<DapatDipromosikan>) ===");
        for (DapatDipromosikan promo : daftarPromo) {
            promo.promosikan();
            promo.infoPromosi();
        }
    }
}