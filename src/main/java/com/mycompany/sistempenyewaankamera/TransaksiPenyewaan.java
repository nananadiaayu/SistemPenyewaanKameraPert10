
package com.mycompany.sistempenyewaankamera;

public class TransaksiPenyewaan {

    public void prosesPenyewaan(
            Pelanggan pelanggan,
            Kamera kamera,
            int lamaSewa) {

        System.out.println("\n========== PROSES TRANSAKSI PENYEWAAN ==========");

        if (pelanggan == null) {
            System.out.println("Transaksi gagal: pelanggan tidak ditemukan.");
            return;
        }

        if (kamera == null) {
            System.out.println("Transaksi gagal: kamera tidak ditemukan.");
            return;
        }

        if (lamaSewa <= 0) {
            System.out.println("Transaksi gagal: lama sewa harus lebih dari 0 hari.");
            return;
        }

        if (!kamera.isTersedia()) {
            System.out.println("Transaksi gagal: kamera sedang disewa.");
            return;
        }

        double total = kamera.hitungBiaya(lamaSewa);

        kamera.setTersedia(false);

        System.out.println("Status Transaksi : BERHASIL");
        System.out.println("ID Pelanggan     : " + pelanggan.getIdPelanggan());
        System.out.println("Nama Pelanggan   : " + pelanggan.getNama());
        System.out.println("Kode Kamera      : " + kamera.getKode());
        System.out.println("Merk Kamera      : " + kamera.getMerk());
        System.out.println("Lama Sewa        : " + lamaSewa + " hari");

        System.out.printf("Total Biaya      : Rp%,.0f%n", total);

        System.out.println("Status Kamera    : DISEWA");
    }
}
