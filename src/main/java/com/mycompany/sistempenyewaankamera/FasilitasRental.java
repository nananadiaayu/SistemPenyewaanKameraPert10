
package com.mycompany.sistempenyewaankamera;

public class FasilitasRental {

    private String namaFasilitas;
    private String lokasi;
    private int kapasitas;

    public FasilitasRental(String namaFasilitas, String lokasi, int kapasitas) {
        this.namaFasilitas = namaFasilitas;
        this.lokasi = lokasi;
        this.kapasitas = kapasitas;
    }

    public void tampilkanInfo() {
        System.out.println("\n========== INFORMASI FASILITAS RENTAL ==========");
        System.out.println("Nama Fasilitas : " + namaFasilitas);
        System.out.println("Lokasi         : " + lokasi);
        System.out.println("Kapasitas      : " + kapasitas + " kamera");
    }
}
