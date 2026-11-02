package com.mycompany.sistempenyewaankamera;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class SistemPenyewaanKamera {

    static Scanner input = new Scanner(System.in);

    static ArrayList<Kamera> daftarKamera = new ArrayList<>();
    static HashMap<String, String> daftarPelanggan = new HashMap<>();

    public static void main(String[] args) {

        tambahDataAwal();
        tambahDataPelanggan();

        int pilihan;

        do {
            System.out.println();
            System.out.println("==============================================");
            System.out.println("        SISTEM PENYEWAAN KAMERA");
            System.out.println("==============================================");
            System.out.println("1. Tambah Data Kamera");
            System.out.println("2. Tampilkan Seluruh Kamera");
            System.out.println("3. Cari Kamera");
            System.out.println("4. Hitung Biaya Penyewaan");
            System.out.println("5. Ubah Status Kamera");
            System.out.println("6. Keluar");
            System.out.println("7. Pengecekan Kamera");
            System.out.println("8. Kelola Data Pelanggan");
            System.out.println("9. Cari Kamera (Exception)");
            System.out.println("==============================================");
            System.out.print("Pilih menu: ");

            try {
                pilihan = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Masukkan pilihan berupa angka!");
                input.nextLine();
                pilihan = 0;
            }

            switch (pilihan) {

                case 1:
                    tambahKamera();
                    break;

                case 2:
                    tampilkanSemuaKamera();
                    break;

                case 3:
                    cariKamera();
                    break;

                case 4:
                    hitungBiaya();
                    break;

                case 5:
                    ubahStatus();
                    break;

                case 6:
                    System.out.println();
                    System.out.println("Terima kasih telah menggunakan");
                    System.out.println("Sistem Penyewaan Kamera.");
                    break;
                    
                case 7:
                    simulasiKamera();
                    break;

                case 8:
                    menuPelanggan();
                    break;

                case 9:
                    cekKamera();
                    break;

                default:
                    System.out.println("Pilihan menu tidak tersedia.");
            }

        } while (pilihan != 6);

        input.close();
    }

    static void tambahDataPelanggan() {
        daftarPelanggan.put("P001", "Andi");
        daftarPelanggan.put("P002", "Budi");
        daftarPelanggan.put("P003", "Citra");
    }

    static void menuPelanggan() {
        int pilihanPelanggan;

        do {
            System.out.println("\n========== MENU PELANGGAN ==========");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Cari Pelanggan");
            System.out.println("3. Tampilkan Semua Pelanggan");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");

            try {
                pilihanPelanggan = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Masukkan angka!");
                input.nextLine();
                pilihanPelanggan = 0;
            }

            switch (pilihanPelanggan) {
                case 1:
                    System.out.print("Masukkan ID pelanggan: ");
                    String id = input.nextLine();
                    if (daftarPelanggan.containsKey(id)) {
                        System.out.println("ID pelanggan sudah digunakan!");
                    } else {
                        System.out.print("Masukkan nama pelanggan: ");
                        String nama = input.nextLine();
                        tambahPelanggan(id, nama);
                    }
                    break;
                case 2:
                    System.out.print("Masukkan ID pelanggan: ");
                    cariPelanggan(input.nextLine());
                    break;
                case 3:
                    tampilkanPelanggan();
                    break;
                case 4:
                    System.out.println("Kembali ke menu utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihanPelanggan != 4);
    }

    static void tambahPelanggan(String id, String nama) {
        daftarPelanggan.put(id, nama);
        System.out.println("Pelanggan berhasil ditambahkan!");
    }

    static void cariPelanggan(String id) {
        if (daftarPelanggan.containsKey(id)) {
            System.out.println("Nama pelanggan: " + daftarPelanggan.get(id));
        } else {
            System.out.println("Pelanggan tidak ditemukan!");
        }
    }

    static void tampilkanPelanggan() {
        System.out.println("\n========== DAFTAR PELANGGAN ==========");
        if (daftarPelanggan.isEmpty()) {
            System.out.println("Belum ada data pelanggan.");
            return;
        }
        for (Map.Entry<String, String> data : daftarPelanggan.entrySet()) {
            System.out.println("ID: " + data.getKey() + " | Nama: " + data.getValue());
        }
    }

    static void tambahDataAwal() {

        daftarKamera.add(
                new KameraDSLR(
                        "K001",
                        "Canon",
                        150000,
                        "Full Frame"
                )
        );

        daftarKamera.add(
                new KameraDSLR(
                        "K002",
                        "Nikon",
                        175000,
                        "APS-C"
                )
        );

        daftarKamera.add(
                new KameraMirrorLess(
                        "K003",
                        "Sony",
                        200000,
                        "24 MP"
                )
        );

        daftarKamera.add(
                new KameraMirrorLess(
                        "K004",
                        "Fujifilm",
                        180000,
                        "26 MP"
                )
        );

        daftarKamera.add(
                new KameraAction(
                        "K005",
                        "GoPro",
                        125000,
                        true
                )
        );
        
        daftarKamera.add(
                new KameraCinema(
                        "K009",
                        "Sony FX3",
                        350000,
                        "4K"
                )
        );       
    }

    static void tambahKamera() {

        System.out.println();
        System.out.println("========== TAMBAH KAMERA ==========");

        

        System.out.print("Kode kamera      : ");
        String kode = input.nextLine();

        System.out.print("Merk kamera      : ");
        String merk = input.nextLine();

        System.out.print("Harga sewa/hari  : ");
        double harga = input.nextDouble();
        input.nextLine();

        System.out.println();
        System.out.println("Pilih tipe kamera:");
        System.out.println("1. DSLR");
        System.out.println("2. Mirrorless");
        System.out.println("3. Action Camera");
        System.out.println("4. Cinema Camera");
        System.out.print("Pilihan: ");

        int tipe = input.nextInt();
        input.nextLine();

        Kamera kameraBaru = null;

        switch (tipe) {

            case 1:

                System.out.print("Jenis sensor     : ");
                String sensor = input.nextLine();

                kameraBaru = new KameraDSLR(
                        kode,
                        merk,
                        harga,
                        sensor
                );

                break;

            case 2:

                System.out.print("Resolusi         : ");
                String resolusi = input.nextLine();

                kameraBaru = new KameraMirrorLess(
                        kode,
                        merk,
                        harga,
                        resolusi
                );

                break;

            case 3:

                System.out.print("Tahan air? (y/n) : ");
                String jawaban = input.nextLine();

                boolean tahanAir =
                        jawaban.equalsIgnoreCase("y");

                kameraBaru = new KameraAction(
                        kode,
                        merk,
                        harga,
                        tahanAir
                );

                break;
                
            case 4:
                System.out.print("Resolusi video : ");
                String resolusiVideo = input.nextLine();

                kameraBaru = new KameraCinema(
                        kode,
                        merk,
                        harga,
                        resolusiVideo
                        
                );
                
                break;
            
    
            default:

                System.out.println(
                        "Tipe kamera tidak valid."
                );

                return;
        }

        daftarKamera.add(kameraBaru);

        System.out.println();
        System.out.println(
                "Kamera berhasil ditambahkan!"
        );
    }

    static void tampilkanSemuaKamera() {

        System.out.println();
        System.out.println(
                "=============== DAFTAR KAMERA ==============="
        );

        if (daftarKamera.isEmpty()) {

            System.out.println(
                    "Belum ada data kamera."
            );

            return;
        }

        System.out.printf(
                "%-8s %-15s %-18s %-12s %-15s %-10s%n",
                "Kode",
                "Merk",
                "Jenis",
                "Spesifikasi",
                "Harga/Hari",
                "Status"
        );

        System.out.println(
                "-------------------------------------------------------------------------------"
        );

        for (int i = 0; i < daftarKamera.size(); i++) {

            // Memanggil method overriding
            daftarKamera.get(i).tampilkanInfo();
        }

        System.out.println();
        System.out.println(
                "Total objek kamera: "
                + Kamera.getTotalKamera()
        );
    }

    static void cariKamera() {

        System.out.println();
        System.out.println(
                "=============== CARI KAMERA ==============="
        );

        System.out.println("1. Cari berdasarkan kode");
        System.out.println("2. Cari berdasarkan merk");
        System.out.print("Pilih: ");

        int pilihan = input.nextInt();
        input.nextLine();

        if (pilihan == 1) {

            System.out.print("Masukkan kode: ");
            String kode = input.nextLine();

            cariKamera(kode);

        } else if (pilihan == 2) {

            System.out.print("Masukkan merk: ");
            String merk = input.nextLine();

            cariKamera(merk, true);

        } else {

            System.out.println(
                    "Pilihan tidak valid."
            );
        }
    }

    static void cariKamera(String kode) {

        boolean ditemukan = false;

        for (int i = 0; i < daftarKamera.size(); i++) {

            if (daftarKamera.get(i)
                    .getKode()
                    .equalsIgnoreCase(kode)) {

                daftarKamera.get(i).tampilkanInfo();

                ditemukan = true;
            }
        }

        if (!ditemukan) {

            System.out.println(
                    "Kamera dengan kode tersebut tidak ditemukan."
            );
        }
    }

    static void cariKamera(
            String merk,
            boolean berdasarkanMerk) {

        boolean ditemukan = false;

        for (int i = 0; i < daftarKamera.size(); i++) {

            if (daftarKamera.get(i)
                    .getMerk()
                    .equalsIgnoreCase(merk)) {

                daftarKamera.get(i).tampilkanInfo();

                ditemukan = true;
            }
        }

        if (!ditemukan) {

            System.out.println(
                    "Kamera dengan merk tersebut tidak ditemukan."
            );
        }
    }

    static void hitungBiaya() {

        System.out.println();
        System.out.println(
                "========== HITUNG BIAYA SEWA =========="
        );

        System.out.print("Masukkan kode kamera: ");
        String kode = input.nextLine();

        Kamera kamera = null;

        for (int i = 0; i < daftarKamera.size(); i++) {

            if (daftarKamera.get(i)
                    .getKode()
                    .equalsIgnoreCase(kode)) {

                kamera = daftarKamera.get(i);

                break;
            }
        }

        if (kamera == null) {

            System.out.println(
                    "Kamera tidak ditemukan."
            );

            return;
        }

        if (!kamera.isTersedia()) {

            System.out.println(
                    "Kamera sedang disewa."
            );

            return;
        }

        System.out.print("Lama sewa (hari): ");
        int hari = input.nextInt();

        if (hari <= 0) {

            System.out.println(
                    "Jumlah hari harus lebih dari 0."
            );

            return;
        }

        System.out.print("Gunakan diskon? (y/n): ");

        input.nextLine();

        String jawaban = input.nextLine();

        double total;

        if (jawaban.equalsIgnoreCase("y")) {

            System.out.print("Masukkan diskon (%): ");
            double diskon = input.nextDouble();

            if (diskon < 0 || diskon > 100) {

                System.out.println(
                        "Diskon harus antara 0-100%."
                );

                return;
            }

            total = kamera.hitungBiaya(
                    hari,
                    diskon
            );

        } else {

            total = kamera.hitungBiaya(hari);
        }

        System.out.println();
        System.out.println(
                "========== DETAIL PENYEWAAN =========="
        );

        System.out.println(
                "Kode kamera : "
                + kamera.getKode()
        );

        System.out.println(
                "Merk        : "
                + kamera.getMerk()
        );

        System.out.println(
                "Jenis       : "
                + kamera.getJenis()
        );

        System.out.println(
                "Lama sewa   : "
                + hari
                + " hari"
        );

        System.out.printf(
                "Total biaya : Rp%,.0f%n",
                total
        );
    }

    static void ubahStatus() {

        System.out.println();
        System.out.println(
                "========== UBAH STATUS KAMERA =========="
        );

        System.out.print(
                "Masukkan kode kamera: "
        );

        String kode = input.nextLine();

        for (int i = 0; i < daftarKamera.size(); i++) {

            if (daftarKamera.get(i)
                    .getKode()
                    .equalsIgnoreCase(kode)) {

                if (daftarKamera.get(i).isTersedia()) {

                    daftarKamera.get(i)
                            .setTersedia(false);

                    System.out.println(
                            "Status kamera diubah menjadi DISEWA."
                    );

                } else {

                    daftarKamera.get(i)
                            .setTersedia(true);

                    System.out.println(
                            "Status kamera diubah menjadi TERSEDIA."
                    );
                }

                return;
            }
        }

        System.out.println(
                "Kamera tidak ditemukan."
        );
    }
    static void prosesKamera(Kamera kamera) {

        System.out.println("\n=== PROSES KAMERA ===");

        kamera.lakukanPengecekan();

        if (kamera instanceof BisaMerekamVideo) {
            BisaMerekamVideo video = (BisaMerekamVideo) kamera;
            video.rekamVideo();
        }

        if (kamera instanceof PerluPerawatan) {
            PerluPerawatan perawatan = (PerluPerawatan) kamera;
            perawatan.lakukanPerawatan();
        }
    }
   
    static void simulasiKamera() {

        System.out.println();
        System.out.println("========== SIMULASI KAMERA ==========");

        System.out.print("Masukkan kode kamera: ");
        String kode = input.nextLine();

        for (int i = 0; i < daftarKamera.size(); i++) {

            if (daftarKamera.get(i).getKode().equalsIgnoreCase(kode)) {

                prosesKamera(daftarKamera.get(i));

                return;
            }
        }

        System.out.println("Kamera tidak ditemukan.");
    }
    
        
    static void cekKamera() {
        try {
            System.out.print("Masukkan kode kamera: ");
            String kode = input.nextLine();
            Kamera kamera = cariKameraDenganException(kode);
            System.out.println("Kamera ditemukan:");
            kamera.tampilkanInfo();
        } catch (KameraException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Proses pencarian kamera selesai.");
        }
    }

    static Kamera cariKameraDenganException(String kode) throws KameraException {

        if (kode == null || kode.trim().isEmpty()) {
            throw new KameraException(
                "Kode kamera tidak boleh kosong!"
            );
        }

        for (int i = 0; i < daftarKamera.size(); i++) {

            if (daftarKamera.get(i).getKode()
                    .equalsIgnoreCase(kode)) {

                return daftarKamera.get(i);
            }
        }

        throw new KameraException(
            "Kamera dengan kode " + kode + " tidak ditemukan!"
        );
    }

}