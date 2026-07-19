import tkinter as tk
from tkinter import ttk

def tampilkan_data():
    # Mengambil nilai dari input field
    nim = entry_nim.get()
    nama = entry_nama.get()
    prodi = entry_prodi.get()
    
    # Format teks output
    hasil = (
        "========== BIODATA MAHASISWA ==========\n\n"
        f"NIM\t\t: {nim}\n"
        f"Nama\t\t: {nama}\n"
        f"Program Studi\t: {prodi}"
    )
    
    # Mengaktifkan area text, mengosongkannya, lalu mengisi data baru
    text_output.config(state="normal")
    text_output.delete("1.0", tk.END)
    text_output.insert(tk.END, hasil)
    text_output.config(state="disabled") # di-disable lagi agar tidak bisa diketik manual

def reset_data():
    # Membersihkan input field
    entry_nim.delete(0, tk.END)
    entry_nama.delete(0, tk.END)
    entry_prodi.delete(0, tk.END)
    
    # Membersihkan area output
    text_output.config(state="normal")
    text_output.delete("1.0", tk.END)
    text_output.config(state="disabled")

# Membuat Window Utama
root = tk.Tk()
root.title("Aplikasi Biodata Mahasiswa")
root.geometry("550x450")
root.resizable(False, False)

# --- SECTION INPUT DATA ---
frame_input = ttk.LabelFrame(root, text="Input Data", padding=10)
frame_input.pack(fill="x", padx=15, pady=5)

# NIM
ttk.Label(frame_input, text="NIM").grid(row=0, column=0, sticky="w", pady=5)
entry_nim = ttk.Entry(frame_input, width=50)
entry_nim.grid(row=0, column=1, padx=10, pady=5)

# Nama
ttk.Label(frame_input, text="Nama").grid(row=1, column=0, sticky="w", pady=5)
entry_nama = ttk.Entry(frame_input, width=50)
entry_nama.grid(row=1, column=1, padx=10, pady=5)

# Program Studi
ttk.Label(frame_input, text="Program Studi").grid(row=2, column=0, sticky="w", pady=5)
entry_prodi = ttk.Entry(frame_input, width=50)
entry_prodi.grid(row=2, column=1, padx=10, pady=5)

# --- TOMBOL / BUTTONS ---
frame_btn = ttk.Frame(root, padding=10)
frame_btn.pack()

btn_tampilkan = ttk.Button(frame_btn, text="Tampilkan", command=tampilkan_data)
btn_tampilkan.grid(row=0, column=0, padx=5)

btn_reset = ttk.Button(frame_btn, text="Reset", command=reset_data)
btn_reset.grid(row=0, column=1, padx=5)

# --- SECTION OUTPUT ---
frame_output = ttk.LabelFrame(root, text="Output", padding=10)
frame_output.pack(fill="both", expand=True, padx=15, pady=5)

# Menggunakan Text widget dengan font Courier agar spacing tab/kolom rapi dan lurus
text_output = tk.Text(frame_output, height=10, bg="#f0f0f0", font=("Courier", 10), state="disabled", bd=0)
text_output.pack(fill="both", expand=True)

# Menjalankan Aplikasi
root.mainloop()