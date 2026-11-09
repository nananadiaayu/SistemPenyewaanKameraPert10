package com.mycompany.sistempenyewaankamera;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemPenyewaanKamera {

    static Scanner input = new Scanner(System.in);

    static PengelolaRental pengelola = new PengelolaRental();

    static ArrayList<Kamera> daftarKamera =
            pengelola.getDaftarKamera();

    static HashMap<String, Pelanggan> daftarPelanggan =
            pengelola.getDaftarPelanggan();

    static TransaksiPenyewaan transaksi =
            new TransaksiPenyewaan();

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
            System.out.println("10. Transaksi Penyewaan");
            System.out.println("11. Tampilkan Composition");
            System.out.println("12. Tampilkan Aggregation");
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

                case 10:
                    jalankanTransaksi();
                    break;

                case 11:
                    tampilkanComposition();
                    break;

                case 12:
                    tampilkanAggregation();
                    break;

                default:
                    System.out.println("Pilihan menu tidak tersedia.");
            }

        } while (pilihan != 6);

        input.close();
    }

    static void tambahDataPelanggan() {

        pengelola.tambahPelanggan(
                new Pelanggan("P001", "Andi")
        );

        pengelola.tambahPelanggan(
                new Pelanggan("P002", "Budi")
        );

        pengelola.tambahPelanggan(
                new Pelanggan("P003", "Citra")
        );
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

        Pelanggan pelangganBaru = new Pelanggan(id, nama);

        pengelola.tambahPelanggan(pelangganBaru);

        if (daftarPelanggan.containsKey(id)) {
            System.out.println("Pelanggan berhasil ditambahkan!");
        }
    }

    static void cariPelanggan(String id) {

        Pelanggan pelanggan = pengelola.cariPelanggan(id);

        if (pelanggan != null) {
            System.out.println("Pelanggan ditemukan:");
            pelanggan.tampilkanInfo();

        } else {
            System.out.println("Pelanggan tidak ditemukan!");
        }
    }

    static void tampilkanPelanggan() {
        pengelola.tampilkanSemuaPelanggan();
    }

    static void tambahDataAwal() {

        pengelola.tambahKamera(
                new KameraDSLR(
                        "K001",
                        "Canon",
                        150000,
                        "Full Frame"
                )
        );

        pengelola.tambahKamera(
                new KameraDSLR(
                        "K002",
                        "Nikon",
                        175000,
                        "APS-C"
                )
        );

        pengelola.tambahKamera(
                new KameraMirrorLess(
                        "K003",
                        "Sony",
                        200000,
                        "24 MP"
                )
        );

        pengelola.tambahKamera(
                new KameraMirrorLess(
                        "K004",
                        "Fujifilm",
                        180000,
                        "26 MP"
                )
        );

        pengelola.tambahKamera(
                new KameraAction(
                        "K005",
                        "GoPro",
                        125000,
                        true
                )
        );

        pengelola.tambahKamera(
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

        if (pengelola.cariKamera(kode) != null) {
            System.out.println("Kode kamera sudah digunakan!");
            return;
        }

        System.out.print("Merk kamera      : ");
        String merk = input.nextLine();

        System.out.print("Harga sewa/hari  : ");

        double harga;

        try {
            harga = input.nextDouble();
            input.nextLine();

        } catch (InputMismatchException e) {
            System.out.println("Harga harus berupa angka!");
            input.nextLine();
            return;
        }

        System.out.println();
        System.out.println("Pilih tipe kamera:");
        System.out.println("1. DSLR");
        System.out.println("2. Mirrorless");
        System.out.println("3. Action Camera");
        System.out.println("4. Cinema Camera");
        System.out.print("Pilihan: ");

        int tipe;

        try {
            tipe = input.nextInt();
            input.nextLine();

        } catch (InputMismatchException e) {
            System.out.println("Tipe kamera harus berupa angka!");
            input.nextLine();
            return;
        }

        Kamera kameraBaru;

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
                System.out.print("Resolusi video   : ");
                String resolusiVideo = input.nextLine();

                kameraBaru = new KameraCinema(
                        kode,
                        merk,
                        harga,
                        resolusiVideo
                );
                break;

            default:
                System.out.println("Tipe kamera tidak valid.");
                return;
        }

        pengelola.tambahKamera(kameraBaru);

        System.out.println();
        System.out.println("Kamera berhasil ditambahkan!");
    }

    static void tampilkanSemuaKamera() {

        System.out.println();
        System.out.println("=============== DAFTAR KAMERA ===============");

        if (daftarKamera.isEmpty()) {
            System.out.println("Belum ada data kamera.");
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

            // Memanggil method overriding.
            daftarKamera.get(i).tampilkanInfo();
        }

        System.out.println();
        System.out.println(
                "Total objek kamera: " + Kamera.getTotalKamera()
        );
    }

    static void cariKamera() {

        System.out.println();
        System.out.println("=============== CARI KAMERA ===============");

        System.out.println("1. Cari berdasarkan kode");
        System.out.println("2. Cari berdasarkan merk");
        System.out.print("Pilih: ");

        int pilihan;

        try {
            pilihan = input.nextInt();
            input.nextLine();

        } catch (InputMismatchException e) {
            System.out.println("Pilihan harus berupa angka!");
            input.nextLine();
            return;
        }

        if (pilihan == 1) {

            System.out.print("Masukkan kode: ");
            String kode = input.nextLine();

            cariKamera(kode);

        } else if (pilihan == 2) {

            System.out.print("Masukkan merk: ");
            String merk = input.nextLine();

            cariKamera(merk, true);

        } else {
            System.out.println("Pilihan tidak valid.");
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
        System.out.println("========== HITUNG BIAYA SEWA ==========");

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
            System.out.println("Kamera tidak ditemukan.");
            return;
        }

        if (!kamera.isTersedia()) {
            System.out.println("Kamera sedang disewa.");
            return;
        }

        System.out.print("Lama sewa (hari): ");

        int hari;

        try {
            hari = input.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Lama sewa harus berupa angka!");
            input.nextLine();
            return;
        }

        if (hari <= 0) {
            System.out.println("Jumlah hari harus lebih dari 0.");
            input.nextLine();
            return;
        }

        System.out.print("Gunakan diskon? (y/n): ");

        input.nextLine();

        String jawaban = input.nextLine();

        double total;

        if (jawaban.equalsIgnoreCase("y")) {

            System.out.print("Masukkan diskon (%): ");

            double diskon;

            try {
                diskon = input.nextDouble();
                input.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Diskon harus berupa angka!");
                input.nextLine();
                return;
            }

            if (diskon < 0 || diskon > 100) {
                System.out.println("Diskon harus antara 0-100%.");
                return;
            }

            total = kamera.hitungBiaya(hari, diskon);

        } else {
            total = kamera.hitungBiaya(hari);
        }

        System.out.println();
        System.out.println("========== DETAIL PENYEWAAN ==========");

        System.out.println("Kode kamera : " + kamera.getKode());
        System.out.println("Merk        : " + kamera.getMerk());
        System.out.println("Jenis       : " + kamera.getJenis());
        System.out.println("Lama sewa   : " + hari + " hari");

        System.out.printf("Total biaya : Rp%,.0f%n", total);
    }

    static void ubahStatus() {

        System.out.println();
        System.out.println("========== UBAH STATUS KAMERA ==========");

        System.out.print("Masukkan kode kamera: ");

        String kode = input.nextLine();

        for (int i = 0; i < daftarKamera.size(); i++) {

            if (daftarKamera.get(i)
                    .getKode()
                    .equalsIgnoreCase(kode)) {

                if (daftarKamera.get(i).isTersedia()) {

                    daftarKamera.get(i).setTersedia(false);

                    System.out.println(
                            "Status kamera diubah menjadi DISEWA."
                    );

                } else {

                    daftarKamera.get(i).setTersedia(true);

                    System.out.println(
                            "Status kamera diubah menjadi TERSEDIA."
                    );
                }

                return;
            }
        }

        System.out.println("Kamera tidak ditemukan.");
    }

    static void prosesKamera(Kamera kamera) {

        System.out.println("\n=== PROSES KAMERA ===");

        kamera.lakukanPengecekan();

        if (kamera instanceof BisaMerekamVideo) {

            BisaMerekamVideo video =
                    (BisaMerekamVideo) kamera;

            video.rekamVideo();
        }

        if (kamera instanceof PerluPerawatan) {

            PerluPerawatan perawatan =
                    (PerluPerawatan) kamera;

            perawatan.lakukanPerawatan();
        }
    }

    static void simulasiKamera() {

        System.out.println();
        System.out.println("========== SIMULASI KAMERA ==========");

        System.out.print("Masukkan kode kamera: ");
        String kode = input.nextLine();

        for (int i = 0; i < daftarKamera.size(); i++) {

            if (daftarKamera.get(i)
                    .getKode()
                    .equalsIgnoreCase(kode)) {

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

            Kamera kamera =
                    cariKameraDenganException(kode);

            System.out.println("Kamera ditemukan:");
            kamera.tampilkanInfo();

        } catch (KameraException e) {

            System.out.println("Error: " + e.getMessage());

        } finally {

            System.out.println(
                    "Proses pencarian kamera selesai."
            );
        }
    }

    static Kamera cariKameraDenganException(String kode)
            throws KameraException {

        if (kode == null || kode.trim().isEmpty()) {

            throw new KameraException(
                    "Kode kamera tidak boleh kosong!"
            );
        }

        for (int i = 0; i < daftarKamera.size(); i++) {

            if (daftarKamera.get(i)
                    .getKode()
                    .equalsIgnoreCase(kode)) {

                return daftarKamera.get(i);
            }
        }

        throw new KameraException(
                "Kamera dengan kode " + kode + " tidak ditemukan!"
        );
    }

    static void tampilkanComposition() {

        System.out.println("\n========== COMPOSITION ==========");

        System.out.println(
                "PengelolaRental memiliki objek FasilitasRental."
        );

        System.out.println(
                "Objek FasilitasRental dibuat langsung di constructor PengelolaRental."
        );

        pengelola.tampilkanFasilitas();
    }

    static void tampilkanAggregation() {

        System.out.println("\n========== AGGREGATION ==========");

        System.out.println(
                "PengelolaRental mengelola kumpulan objek Kamera dan Pelanggan."
        );

        System.out.println(
                "Objek Kamera dan Pelanggan dibuat dari luar PengelolaRental."
        );

        pengelola.tampilkanSemuaKamera();
        pengelola.tampilkanSemuaPelanggan();
    }

    static void jalankanTransaksi() {

        System.out.println("\n========== TRANSAKSI PENYEWAAN ==========");

        System.out.print("Masukkan ID pelanggan: ");
        String idPelanggan = input.nextLine();

        Pelanggan pelanggan =
                pengelola.cariPelanggan(idPelanggan);

        if (pelanggan == null) {
            System.out.println("Pelanggan tidak ditemukan.");
            return;
        }

        System.out.println("\nDaftar kamera yang tersedia:");

        for (Kamera kamera : daftarKamera) {

            if (kamera.isTersedia()) {
                kamera.tampilkanInfo();
            }
        }

        System.out.print("\nMasukkan kode kamera yang ingin disewa: ");
        String kodeKamera = input.nextLine();

        Kamera kamera = pengelola.cariKamera(kodeKamera);

        if (kamera == null) {
            System.out.println("Kamera tidak ditemukan.");
            return;
        }

        System.out.print("Lama sewa (hari): ");

        int lamaSewa;

        try {
            lamaSewa = input.nextInt();
            input.nextLine();

        } catch (InputMismatchException e) {
            System.out.println("Lama sewa harus berupa angka!");
            input.nextLine();
            return;
        }

        transaksi.prosesPenyewaan(
                pelanggan,
                kamera,
                lamaSewa
        );
    }
}