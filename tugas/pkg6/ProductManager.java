package tugas.pkg6;
import java.util.*;

// Kelas ProductManager bertugas untuk mengelola produk dlm marketplace
public class ProductManager {
    
    // Menyimpan daftar semua produk 
    private List<Product<?>> products = new ArrayList<>();
    
    // Menyimpan kategori unik 
    private Set<String> categories = new HashSet<>();
    
    // Menyimpan produk-produk yang telah diproses (dlm bentuk antrian)
    private Queue<Product<?>> processedQueue = new LinkedList<>();
    
    //// Menyimpan produk-produk yang telah dihapus(fitur tambahan)
    private List<Product<?>> deletedHistory = new ArrayList<>();

    // Method untuk menambahkan produk baru
    public void addProduct(Product<?> product) {
        products.add(product); // Tambah ke daftar produk
        categories.add(product.getCategory().toString()); // Tambah ke set kategori unik
    }

    // Method untuk menghapus produk berdasarkan ID
  public void removeProductById(int id) {
    Iterator<Product<?>> iterator = products.iterator();
    while (iterator.hasNext()) {
        Product<?> p = iterator.next();
        if (p.getId() == id) {
            deletedHistory.add(p);  
            iterator.remove();      
            break;
        }
    }
}

    // Method untuk mencari produk berdasarkan nama dan kategori
    public List<Product<?>> searchProduct(String name, String category) {
        List<Product<?>> result = new ArrayList<>();
        for (Product<?> p : products) {
            // Cek nama dan kategori (case-insensitive)
            if (p.getName().equalsIgnoreCase(name) &&
                p.getCategory().toString().equalsIgnoreCase(category)) {
                result.add(p);
            }
        }
        return result;
    }

    // Method untuk menampilkan seluruh produk, diurutkan berdasarkan kategori
    public void displayAllProductsSorted() {
        // Salin daftar produk ke list baru agar tidak mengubah data asli
        List<Product<?>> sortedList = new ArrayList<>(products);
        
        // Gunakan Comparator manual karena wildcard tidak bisa langsung di-sort
        Collections.sort(sortedList, new Comparator<Product<?>>() {
            @Override
            public int compare(Product<?> p1, Product<?> p2) {
                return p1.getCategory().toString().compareTo(p2.getCategory().toString());
            }
        });

        // Tampilkan hasil produk yang sudah diurutkan
        for (Product<?> p : sortedList) {
            System.out.println(p);
        }
    }

    // Method untuk menampilkan semua kategori yang unik
    public void displayCategories() {
        System.out.println("\nKategori unik:");
        for (String category : categories) {
            System.out.println("- " + category);
        }
    }

    // Method untuk menambahkan produk ke antrian produk yang telah diproses
    public void processProduct(Product<?> product) {
        processedQueue.add(product);
    }

    // Method untuk menampilkan semua produk yang sudah diproses
    public void displayProcessedQueue() {
        System.out.println("\nAntrian produk yang telah diproses:");
        for (Product<?> p : processedQueue) {
            System.out.println(p);
        }
    }

    // === BONUS FITUR ===
    // Method untuk menampilkan riwayat produk yang dihapus
   public void displayDeletedHistory() {
    System.out.println("\nRiwayat Produk yang Telah Dihapus:");
    if (deletedHistory.isEmpty()) {
        System.out.println("- Tidak ada produk yang dihapus.");
    } else {
        for (Product<?> p : deletedHistory) {
            System.out.println(p);
        }
    }
}
}
