import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String kode;
        int porsi;
        int totalBayar = 0;

        System.out.println("Menu\t\tPorsi\tHarga\tTotal");
        System.out.println("=============================================");

        while (true) {
            kode = input.next();

            if (kode.equals("END")) {
                break;
            }

            porsi = input.nextInt();

            if (kode.equals("NGS")) {
                int harga = 25000;
                int total = harga * porsi;
                totalBayar += total;
                System.out.println("Nasi Padang\t" + porsi + "\t" + harga + "\t" + total);
            }
            else if (kode.equals("AP")) {
                int harga = 22000;
                int total = harga * porsi;
                totalBayar += total;
                System.out.println("Ayam Goreng\t" + porsi + "\t" + harga + "\t" + total);
            }
            else if (kode.equals("GG")) {
                int harga = 30000;
                int total = harga * porsi;
                totalBayar += total;
                System.out.println("Rendang\t\t" + porsi + "\t" + harga + "\t" + total);
            }
            else {
                System.out.println("Kode tidak valid!");
            }
        }

        System.out.println("=============================================");
        System.out.println("Total Pembayaran\t\t\t" + totalBayar);

        input.close();
    }
}