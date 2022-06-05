import java.util.Random;
import java.util.Scanner;

public class Game {

    int size;
    int who;
    int x;
    int y;
    int score = 0;
    int rakipScore = 0;
    boolean game = true;
    String[][] board;

    Random random = new Random();
    Scanner scan = new Scanner(System.in);

    public Game(int size, int who) {
        this.size = size;
        this.who = who;
    }

    public void start() {
        prepareGame();

    }

    public void prepareGame() {
        createGameBoard(size);
        printBoard();
        playWith(who);

    }

    public void playWith(int who) {

        switch (who) {
            case 1:
                System.out.println("Arkadaşla oynama sistemimiz şuanda çalışmamaktadır.");
                break;
            case 2:
                singlePlayer();
                System.out.println("Bota Karşı Oynuyorsunuz.");

                break;
            case 3:
                System.out.println("Oyun Bitti!");
                break;
        }
        System.out.println("--------------------------");
    }

    public void singlePlayer() {
        while (game) {
            playerInput();
            getScore();
            printBoard();
            randomPlay();
            getScore();
            printBoard();
        }


    }

    public void playerInput() {
        System.out.println("Lütfen Oynamak İstediğiniz Koordinatları Giriniz.\nY = ");
        x = scan.nextInt();
        System.out.println("X = ");
        y = scan.nextInt();
        boolean secim = true;
        if (board[x][y] == "*") {
            System.out.println("X koymak İçin 1'e basınız.Y koymak için 2'ye basınız.");
            int xory = scan.nextInt();
            if (xory == 1) {
                board[x][y] = "X";
                xory = 0;
            } else {
                board[x][y] = "Y";
                xory = 0;
            }

            secim = false;
        } else {
            System.out.println("Bu alana Oynayamazsınız!Lütfen Farklı Değerler Giriniz.");
        }
        secim = true;


    }

    public void randomPlay() {
        boolean oynadiMi = false;
        while (!oynadiMi) {
            x = random.nextInt(size);
            y = random.nextInt(size);
            if (board[x][y] == "*") {
                int secim = random.nextInt(2);
                if (secim == 1) {
                    board[x][y] = "X";
                } else {
                    board[x][y] = "Y";
                }
                oynadiMi = true;
            }
        }

    }

    public void getScore(){ // Hatalı çalışmakta... !!
        if(y+2< board.length && x+2< board.length){
            if(board[x][y]==board[x+1][y] && board[x+1][y]==board[x+2][y]){
                score++;
            }
            if(board[x][y]==board[x][y+1] && board[x][y]==board[x][y+2]){
                score++;
            }
        }else{
            if(x+2>= board.length){
                x=board.length;
            }
            if(y+2>=board.length){
             y=board.length;
            }
            if(board[x][y]==board[x+1][y] && board[x+1][y]==board[x+2][y]){
                score++;
            }
            if(board[x][y]==board[x][y+1] && board[x][y]==board[x][y+2]){
                score++;
            }
        }

    }

    public void createGameBoard(int size) {
        board = new String[size][size];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = "*";
            }
        }

    }

    public void printBoard() {
        System.out.println("Güncel Oyun Tahtası : ");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Güncel Puan Durumu : \nSiz : " + score + " Bilgisayar : " + rakipScore);
    }
}
