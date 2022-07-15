import java.util.*;

public class ArrayPractice1 {
    static int Row, Col, Sr, Sc;
    static int[][] Board = new int[100][100];
    static void cross() {
        if(Board[Sr][Sc] != 0) return;
        Board[Sr][Sc] = 1;
        for (int i = Sr - 1; i >= 0; --i) {
            if(Board[i][Sc] !=0) break;
            Board[i][Sc] = 1;
        }
        for (int i= Sr + 1; i < Row; ++i) {
            if (Board[i][Sc] != 0) break;
            Board[i][Sc] = 1;
        }
        for (int j = Sc - 1; j >= 0; --j) {
            if (Board[Sr][j] != 0) break;
            Board[Sr][j] = 1;
        }
        for (int j = Sc + 1; j < Col; ++j) {
            if (Board[Sr][j] != 0) break;
            Board[Sr][j] = 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Row = sc.nextInt(); Col = sc.nextInt();
        for(int i = 0; i < Row; ++i)
            for (int j = 0; j < Col; ++j)
                Board[i][j] = sc.nextInt();

        Sr = sc.nextInt(); Sc = sc.nextInt();
        cross();
        for (int i = 0; i < Row; ++i) {
            for (int j = 0; j < Col; ++j) {
                System.out.print(Board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
