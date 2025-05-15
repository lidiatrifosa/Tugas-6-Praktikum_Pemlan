package tugas.pkg6;

// Kelas Product bersifat generik dengan parameter tipe T yang bisa dibandingkan (Comparable<T>)
public class Product<T extends Comparable<T>> implements Comparable<Product<T>> {

    // Atribut privat dari produk
    private int id;          // ID unik untuk tiap produk
    private String name;     // Nama produk
    private T category;      // Kategori produk, bersifat generik dan bisa dibandingkan
    private double price;    // Harga produk

    // Konstruktor untuk menginisialisasi produk dengan ID, nama, kategori, dan harga
    public Product(int id, String name, T category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getter untuk mengambil ID produk
    public int getId() { return id; }

    // Getter untuk mengambil nama produk
    public String getName() { return name; }

    // Getter untuk mengambil kategori produk
    public T getCategory() { return category; }

    // Getter untuk mengambil harga produk
    public double getPrice() { return price; }

    // Implementasi dari metode compareTo agar produk bisa dibandingkan berdasarkan kategorinya
    // Hal ini memungkinkan produk diurutkan sesuai urutan kategori (misal abjad jika T = String)
    @Override
    public int compareTo(Product<T> other) {
        return this.category.compareTo(other.category);
    }

    // Override metode toString agar informasi produk ditampilkan secara ringkas dan informatif
    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Category: " + category + " | Price: Rp" + price;
    }
}
