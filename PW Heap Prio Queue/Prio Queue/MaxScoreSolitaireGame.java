import java.util.Arrays;

public class MaxScoreSolitaireGame {

    public int maximumScore(int a, int b, int c) {

        int[] piles = {a, b, c};
        Arrays.sort(piles);

        int score = 0;

        while (piles[1] > 0) {

            piles[1]--;
            piles[2]--;
            score++;


            Arrays.sort(piles);
        }

        return score;
    }

    public static void main(String[] args) {
        MaxScoreSolitaireGame game = new MaxScoreSolitaireGame();

        int a1 = 2, b1 = 4, c1 = 6;
        System.out.println("Maximum Score for (2, 4, 6): " + game.maximumScore(a1, b1, c1)); 

        int a2 = 4, b2 = 4, c2 = 6;
        System.out.println("Maximum Score for (4, 4, 6): " + game.maximumScore(a2, b2, c2));
    }
}
