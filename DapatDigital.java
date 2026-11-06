public interface DapatDigital {
    // Method abstrak (public abstract by default)
    void aksesEBook(String url);

    // Default method (Java 8+) – boleh di-override, boleh tidak
    default void infoDigital() {
        System.out.println("Anggota ini dapat mengakses e-book.");
    }

    // Konstanta (public static final by default)
    int MAX_DOWNLOAD_PER_HARI = 10;
}