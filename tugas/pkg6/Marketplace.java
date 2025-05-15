package tugas.pkg6;

public class Marketplace {
    public static void main(String[] args) {
        // Membuat objek ProductManager untuk mengelola produk
        ProductManager manager = new ProductManager();

        // Membuat beberapa produk dengan kategori bertipe String
        Product<String> p1 = new Product<>(1, "Laptop", "Elektronik", 7500000);
        Product<String> p2 = new Product<>(2, "Kaos", "Pakaian", 120000);
        Product<String> p3 = new Product<>(3, "Pulpen", "Alat Tulis", 5000);
        Product<String> p4 = new Product<>(4, "Smartphone", "Elektronik", 3500000);
        Product<String> p5 = new Product<>(5, "Topi", "Pakaian", 89000);

        // Menambahkan produk-produk ke dalam manager
        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.addProduct(p3);
        manager.addProduct(p4);
        manager.addProduct(p5);

        // Menampilkan semua produk, diurutkan berdasarkan kategori
        System.out.println("=== Daftar Produk (Diurutkan berdasarkan Kategori) ===");
        manager.displayAllProductsSorted();

        // Menampilkan semua kategori produk yang unik
        manager.displayCategories();

        // Mencari produk berdasarkan nama dan kategori
        System.out.println("\nHasil pencarian 'Kaos' di kategori 'Pakaian':");
        for (Product<?> p : manager.searchProduct("Kaos", "Pakaian")) {
            System.out.println(p); // Menampilkan produk yang ditemukan
        }

        // Menandai produk sebagai "telah diproses" (dimasukkan ke dalam antrian)
        manager.processProduct(p2);
        manager.processProduct(p3); 
        manager.displayProcessedQueue(); // Menampilkan antrian produk yang telah diproses

        // Menghapus produk berdasarkan ID
        manager.removeProductById(2);
        manager.removeProductById(3);

        // Menampilkan ulang daftar produk setelah penghapusan
        System.out.println("\nDaftar Produk setelah penghapusan ");
        manager.displayAllProductsSorted();

        // Bonus: Tampilkan riwayat produk yang dihapus
        manager.displayDeletedHistory();
    }
}
