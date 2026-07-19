import sqlite3
import os

def get_db_connection():
    # Database otomatis dibuat di dalam folder tanpa XAMPP
    return sqlite3.connect("toko_retail.db")

def inisialisasi_database():
    conn = get_db_connection()
    cursor = conn.cursor()
    cursor.execute("""
    CREATE TABLE IF NOT EXISTS barang (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        kode TEXT NOT NULL UNIQUE,
        nama_barang TEXT NOT NULL,
        harga INTEGER NOT NULL,
        stok INTEGER NOT NULL
    )
    """)
    
    # Isi data awal sesuai contoh soal
    cursor.execute("SELECT COUNT(*) FROM barang")
    if cursor.fetchone()[0] == 0:
        data_awal = [
            ('B001', 'Mie instan', 10000, 100),
            ('B002', 'chocolatos', 2000, 100),
            ('B003', 'Nabati', 3000, 100)
        ]
        cursor.executemany("INSERT INTO barang (kode, nama_barang, harga, stok) VALUES (?, ?, ?, ?)", data_awal)
        conn.commit()
    
    cursor.close()
    conn.close()

def bersihkan_layar():
    os.system('cls' if os.name == 'nt' else 'clear')

def cetak_menu():
    print("┌──────────────────────────────────┐")
    print("│         MENU TOKO RETAIL         │") # Judul sesuai gambar
    print("├──────────────────────────────────┤")
    print("│  1. Tampil Semua Data            │") # Menu 1[cite: 2]
    print("│  2. Tambah Data                  │") # Menu 2[cite: 2]
    print("│  3. Cari Data                    │") # Menu 3[cite: 2]
    print("│  4. Ubah Data                    │") # Menu 4[cite: 2]
    print("│  5. Hapus Data                   │") # Menu 5[cite: 2]
    print("│  0. Keluar                       │") # Pilihan keluar[cite: 2]
    print("└──────────────────────────────────┘")

def tampil_semua_data():
    bersihkan_layar()
    conn = get_db_connection()
    cursor = conn.cursor()
    cursor.execute("SELECT kode, nama_barang, harga, stok FROM barang")
    rows = cursor.fetchall()
    
    print("\n┌────────────────────────────────────────────────────────┐")
    print("│               DAFTAR BARANG TOKO RETAIL                │") # Header tabel sesuai gambar[cite: 2]
    print("├────┬──────────┬─────────────────────────┬───────┬──────┤")
    print("│ #  │ Kode     │ Nama Barang             │ Harga │ Stok │")
    print("├────┼──────────┼─────────────────────────┼───────┼──────┤")
    
    for index, row in enumerate(rows, 1):
        print(f"│ {index:<2} │ {row[0]:<8} │ {row[1]:<23} │ {row[2]:<5} │ {row[3]:<4} │")
        
    print("└────┴──────────┴─────────────────────────┴───────┴──────┘")
    print(f"Total: {len(rows)} barang\n") # Total barang sesuai gambar[cite: 2]
    
    cursor.close()
    conn.close()
    input("Tekan Enter untuk kembali ke menu...")

def tambah_data():
    bersihkan_layar()
    print("=== MENU 2: TAMBAH DATA BARANG ===")
    kode = input("Masukkan Kode Barang: ")
    nama = input("Masukkan Nama Barang: ")
    harga = int(input("Masukkan Harga: "))
    stok = int(input("Masukkan Stok: "))
    
    conn = get_db_connection()
    cursor = conn.cursor()
    try:
        cursor.execute(
            "INSERT INTO barang (kode, nama_barang, harga, stok) VALUES (?, ?, ?, ?)",
            (kode, nama, harga, stok)
        )
        conn.commit()
        print("\n[Sukses] Data barang baru berhasil ditambahkan!")
    except sqlite3.Error as err:
        print(f"\n[Gagal] Kode sudah ada atau error: {err}")
    
    cursor.close()
    conn.close()
    input("\nTekan Enter untuk kembali ke menu...")

def cari_data():
    bersihkan_layar()
    print("=== MENU 3: CARI DATA BARANG ===")
    keyword = input("Masukkan Nama atau Kode Barang yang dicari: ")
    
    conn = get_db_connection()
    cursor = conn.cursor()
    cursor.execute(
        "SELECT kode, nama_barang, harga, stok FROM barang WHERE nama_barang LIKE ? OR kode LIKE ?",
        (f"%{keyword}%", f"%{keyword}%")
    )
    rows = cursor.fetchall()
    
    if rows:
        print("\nHasil Pencarian:")
        for index, row in enumerate(rows, 1):
            print(f"{index}. Kode: {row[0]} | Nama: {row[1]} | Harga: {row[2]} | Stok: {row[3]}")
    else:
        print("\n[Informasi] Barang tidak ditemukan.")
        
    cursor.close()
    conn.close()
    input("\nTekan Enter untuk kembali ke menu...")

def ubah_data():
    bersihkan_layar()
    print("=== MENU 4: UBAH DATA BARANG ===")
    kode = input("Masukkan Kode Barang yang ingin diubah: ")
    
    conn = get_db_connection()
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM barang WHERE kode = ?", (kode,))
    result = cursor.fetchone()
    
    if result:
        print(f"\nData Lama -> Nama: {result[2]} | Harga: {result[3]} | Stok: {result[4]}")
        nama_baru = input("Nama Baru (kosongkan jika tetap): ") or result[2]
        harga_baru = input("Harga Baru (kosongkan jika tetap): ")
        harga_baru = int(harga_baru) if harga_baru else result[3]
        stok_baru = input("Stok Baru (kosongkan jika tetap): ")
        stok_baru = int(stok_baru) if stok_baru else result[4]
        
        cursor.execute(
            "UPDATE barang SET nama_barang = ?, harga = ?, stok = ? WHERE kode = ?",
            (nama_baru, harga_baru, stok_baru, kode)
        )
        conn.commit()
        print("\n[Sukses] Data barang berhasil diperbarui!")
    else:
        print("\n[Error] Kode barang tidak ditemukan.")
        
    cursor.close()
    conn.close()
    input("\nTekan Enter untuk kembali ke menu...")

def hapus_data():
    bersihkan_layar()
    print("=== MENU 5: HAPUS DATA BARANG ===")
    kode = input("Masukkan Kode Barang yang ingin dihapus: ")
    
    conn = get_db_connection()
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM barang WHERE kode = ?", (kode,))
    if cursor.fetchone():
        cursor.execute("DELETE FROM barang WHERE kode = ?", (kode,))
        conn.commit()
        print("\n[Sukses] Data barang telah dihapus dari database!")
    else:
        print("\n[Error] Kode barang tidak ditemukan.")
        
    cursor.close()
    conn.close()
    input("\nTekan Enter untuk kembali ke menu...")

def main():
    inisialisasi_database()
    while True:
        bersihkan_layar()
        cetak_menu()
        pilihan = input("Pilihan : ") # Sesuai format input pilihan di gambar[cite: 2]
        
        if pilihan == '1':
            tampil_semua_data()
        elif pilihan == '2':
            tambah_data()
        elif pilihan == '3':
            cari_data()
        elif pilihan == '4':
            ubah_data()
        elif pilihan == '5':
            hapus_data()
        elif pilihan == '0':
            print("\nKeluar dari program. Terima kasih!")
            break
        else:
            print("\nPilihan tidak tersedia!")
            input("Tekan Enter untuk mengulangi...")

if __name__ == "__main__":
    main()