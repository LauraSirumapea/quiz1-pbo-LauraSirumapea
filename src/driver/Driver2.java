import java.util.Scanner;

public class Driver2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Input jumlah total data
        System.out.print("Masukkan jumlah data: ");
        int n = sc.nextInt();

        int[] nilai = new int[n];

        // 2. Input deret nilai
        System.out.println("Masukkan deret nilai:");
        for (int i = 0; i < n; i++) {
            nilai[i] = sc.nextInt();
        }

        // 3. Input kode kelompok
        System.out.print("Masukkan kode kelompok (A/B/C): ");
        char kelompok = sc.next().toUpperCase().charAt(0);

        int total = 0;

        // Proses menghitung total sesuai kelompok
        for (int i = 0; i < n; i++) {
            if (kelompok == 'A' && i % 3 == 0) {
                total += nilai[i];
            } else if (kelompok == 'B' && i % 3 == 1) {
                total += nilai[i];
            } else if (kelompok == 'C' && i % 3 == 2) {
                total += nilai[i];
            }
        }

        // Output hasil
        System.out.println("Total nilai kelompok " + kelompok + " = " + total);

        sc.close();
    }
}