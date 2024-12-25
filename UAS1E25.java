//Rani Miftahus Sa'adah_244107020057_TI1E_25

import java.util.Scanner;

public class UAS1E25 {
    static Scanner sc = new Scanner(System.in);
    static String[] namaTim25; 
    static int[][] skor25;     
    static int[] totalSkor25; 
    static int jumlahTim25;

    public static void inputDataSkorTim() {
        System.out.print("Masukkan jumlah tim: ");
        jumlahTim25 = sc.nextInt();

        namaTim25 = new String[jumlahTim25];
        skor25 = new int[jumlahTim25][2];
        totalSkor25 = new int[jumlahTim25];

        for (int i = 0; i < jumlahTim25; i++) {
            sc.nextLine();
            System.out.print("Masukkan nama tim ke-" + (i + 1) + ": ");
            namaTim25[i] = sc.nextLine();
        
            for (int j = 0; j < 2; j++) {
                while (true) {
                    System.out.print("Masukkan skor " + namaTim25[i] + " untuk Level " + (j + 1) + ": ");
                    int inputSkor = sc.nextInt();

                    if (inputSkor < 0) {
                        System.out.println("Skor harus bilangan positif!");
                    } else if (j == 0 && inputSkor < 35) {
                        System.out.println("Skor Level 1 kurang dari 35, dianggap 0.");
                        skor25[i][j] = 0;
                        break;
                    } else {
                        skor25[i][j] = inputSkor;
                        break;
                    }
                }
            }
        }
        System.out.println("Data skor berhasil dimasukkan!");
}
public static void tampilkanTabelSkor() {
    System.out.println("\n==== Tabel Skor Turnamen ====");
    System.out.printf("%-15s %-10s %-10s %-10s\n", "Nama Tim", "Level 1", "Level 2", "Total Skor");

    for (int i = 0; i < jumlahTim25; i++) {
        totalSkor25[i] = skor25[i][0] + skor25[i][1];
        System.out.printf("%-15s %-10d %-10d %-10d\n", namaTim25[i], skor25[i][0], skor25[i][1], totalSkor25[i]);
    }
}
public static void tentukanJuara() {
    int skorTertinggi = -1;
    String timJuara = "";

    for (int i = 0; i < jumlahTim25; i++) {
        if (totalSkor25[i] > skorTertinggi) {
            skorTertinggi = totalSkor25[i];
            timJuara = namaTim25[i];
        }
    }

    System.out.println("\nSelamat kepada Tim " + timJuara + " yang telah memenangkan kompetisi!");
}

    
public static void main(String[] args) {
    int menu;
    boolean dataInput = false;
    do {
        System.out.println("===MENU UTAMA===");
        System.out.println("1. Input Data Skor Tim");
        System.out.println("2. Tampilkan Tabel skor");
        System.out.println("3. Tentukan Juara");
        System.out.println("4. Keluar");
        System.out.print("Pilih Menu(1-4): ");
        menu = sc.nextInt();
        switch (menu) {
            case 1:
                inputDataSkorTim();
                dataInput = true;
                break;
            case 2:
                if (!dataInput) {
                    System.out.println("Tidak ada data yang bisa ditampilkan.");
                } else {
                    tampilkanTabelSkor();
                }
                break;
            case 3:
                if (!dataInput) {
                    System.out.println("Silakan input data terlebih dahulu.");
                } else {
                    tentukanJuara();
                }
                break;
            case 4:
                System.out.println("Terima kasih telah menggunakan program ini!");
                break;
            default:
                System.out.println("Pilihan menu tidak valid. Silakan coba lagi.");
        }
    } while (menu != 4);
}
}