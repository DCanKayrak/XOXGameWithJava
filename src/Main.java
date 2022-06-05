import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("X O X Oyunumuza Hoşgeldiniz.\n--------------------------");
        System.out.println("Lütfen Tahta Boyutunu Giriniz.");
        int size = scan.nextInt();
        System.out.println("Kiminle oynamak istiyorsunuz ?\n1-Arkadaşa Karşı\n2-Bota Karşı\n3-Çıkış");
        int who = scan.nextInt();
        Game oyun = new Game(size,who);
        oyun.start();
    }
}
