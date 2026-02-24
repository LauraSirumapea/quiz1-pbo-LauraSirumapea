import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Pakaian {
    String jenis;
    int jumlah;
    boolean isLuntur;
    String notes;

    public Pakaian(String jenis, int jumlah, boolean isLuntur, String notes) {
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.isLuntur = isLuntur;
        this.notes = notes;
    }
}

public class Driver3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pakaian> daftarCucian = new ArrayList<>();
        int totalPakaian = 0;

        // Pengaturan Waktu
        LocalDateTime waktuSekarang = LocalDateTime.now();
        // Tanggal Pengembalian (1 Hari Kerja)
        LocalDateTime waktuKembali = waktuSekarang.plusDays(1);
        
        DateTimeFormatter formatLengkap = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm");
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        System.out.println("==============================================");
        System.out.println("      SISTEM LAUNDRY ASRAMA IT DEL");
        System.out.println("==============================================");
        
        System.out.print("Nama Mahasiswa : "); String nama = sc.nextLine();
        System.out.print("NIM            : "); String nim = sc.nextLine();
        System.out.print("Asrama         : "); String asrama = sc.nextLine();

        boolean tambahLagi = true;
        while (tambahLagi) {
            System.out.println("\n--- Detail Item ---");
            System.out.print("Jenis Pakaian  : "); String jenis = sc.next();
            System.out.print("Jumlah Pcs     : "); int jumlah = sc.nextInt();
            System.out.print("Luntur? (y/n)  : "); String lunturInput = sc.next();
            boolean isLuntur = lunturInput.equalsIgnoreCase("y");
            
            sc.nextLine(); // clear buffer
            System.out.print("Notes Khusus   : "); String notes = sc.nextLine();

            daftarCucian.add(new Pakaian(jenis, jumlah, isLuntur, notes));
            totalPakaian += jumlah;

            System.out.print("Tambah jenis lain? (y/n): ");
            if (sc.next().equalsIgnoreCase("n")) tambahLagi = false;
        }

        // --- OUTPUT DETAIL SEMUA LAUNDRY ---
        System.out.println("\n\n");
        System.out.println("================================================================");
        System.out.println("                STRUK DETAIL LAUNDRY ASRAMA IT DEL              ");
        System.out.println("================================================================");
        System.out.printf(" PEMILIK  : %-20s  ASRAMA : %s\n", nama.toUpperCase(), asrama);
        System.out.printf(" NIM      : %-20s  MASUK  : %s\n", nim, waktuSekarang.format(formatLengkap));
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-3s | %-12s | %-6s | %-8s | %s\n", "NO", "JENIS", "QTY", "LUNTUR", "CATATAN");
        System.out.println("----------------------------------------------------------------");

        int no = 1;
        for (Pakaian p : daftarCucian) {
            String statusLuntur = p.isLuntur ? "[!] YA" : "TIDAK";
            System.out.printf("%-3d | %-12s | %-6d | %-8s | %s\n", 
                              no++, p.jenis, p.jumlah, statusLuntur, p.notes);
        }

        System.out.println("----------------------------------------------------------------");
        System.out.println(" TOTAL PAKAIAN : " + totalPakaian + " Pcs");
        System.out.println("================================================================");
        System.out.println(" STATUS : AKAN DIANTAR KE ASRAMA");
        System.out.println(" ESTIMASI PENGEMBALIAN : " + waktuKembali.format(formatTanggal));
        System.out.println("================================================================");
        System.out.println(" * Pakaian luntur akan dipisahkan saat pencucian.");
        System.out.println(" * Segera lapor jika ada kekurangan saat barang diantar.");
        System.out.println("================================================================");
        System.out.println("            Terima kasih - Semangat Kuliahnya!                  ");
        
        sc.close();
    }
}