package com.mycompany.sistempenyewaankamera;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PengelolaRental {

    private ArrayList<Kamera> daftarKamera;
    private HashMap<String, Pelanggan> daftarPelanggan;
    private FasilitasRental fasilitas;

    public PengelolaRental() {
        daftarKamera = new ArrayList<>();
        daftarPelanggan = new HashMap<>();
        fasilitas = new FasilitasRental(
                "Ruang Penyimpanan Kamera",
                "Lantai 1",
                20
        );
    }

    public ArrayList<Kamera> getDaftarKamera() {
        return daftarKamera;
    }

    public HashMap<String, Pelanggan> getDaftarPelanggan() {
        return daftarPelanggan;
    }

    public void tambahKamera(Kamera kamera) {
        daftarKamera.add(kamera);
        System.out.println("Data kamera berhasil dimasukkan ke pengelola rental.");
    }

    public Kamera cariKamera(String kode) {
        for (Kamera kamera : daftarKamera) {
            if (kamera.getKode().equalsIgnoreCase(kode)) {
                return kamera;
            }
        }
        return null;
    }

    public void tampilkanSemuaKamera() {
        System.out.println("\n========== DAFTAR KAMERA (AGGREGATION) ==========");

        if (daftarKamera.isEmpty()) {
            System.out.println("Belum ada data kamera.");
            return;
        }

        for (Kamera kamera : daftarKamera) {
            kamera.tampilkanInfo();
        }

        System.out.println("Total kamera: " + daftarKamera.size());
    }

    public void tambahPelanggan(Pelanggan pelanggan) {
        if (daftarPelanggan.containsKey(pelanggan.getIdPelanggan())) {
            System.out.println("ID pelanggan sudah digunakan.");
            return;
        }

        daftarPelanggan.put(pelanggan.getIdPelanggan(), pelanggan);
        System.out.println("Data pelanggan berhasil dimasukkan ke pengelola rental.");
    }

    public Pelanggan cariPelanggan(String id) {
        return daftarPelanggan.get(id);
    }

    public void tampilkanSemuaPelanggan() {
        System.out.println("\n========== DAFTAR PELANGGAN (AGGREGATION) ==========");

        if (daftarPelanggan.isEmpty()) {
            System.out.println("Belum ada data pelanggan.");
            return;
        }

        for (Map.Entry<String, Pelanggan> data : daftarPelanggan.entrySet()) {
            System.out.println(
                    "ID: " + data.getKey()
                    + " | Nama: " + data.getValue().getNama()
            );
        }
    }

    public void tampilkanFasilitas() {
        fasilitas.tampilkanInfo();
    }

    public boolean idKameraSudahAda(String kode) {
        return cariKamera(kode) != null;
    }
}