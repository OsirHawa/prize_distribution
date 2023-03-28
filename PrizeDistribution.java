import java.util.*;


public class PrizeDistribution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the week prize values
        System.out.print("Enter the week prize values (comma separated): ");
        String[] prizeValuesStr = scanner.nextLine().split(",");
        int[] prizeValues = new int[prizeValuesStr.length];
        for (int i = 0; i <= prizeValuesStr.length-1; i++) {
            prizeValues[i] = Integer.parseInt(prizeValuesStr[i]);
        }

        // Get the week winners
        System.out.print("Enter the week winners (comma separated): ");
        String[] winners = scanner.nextLine().split(",");

        // Calculate the total prize money and the number of winners
        int totalPrizeMoney = 0;
        int numWinners = winners.length;
        for (int prizeValue : prizeValues) {
            totalPrizeMoney += prizeValue;
        }

        // Calculate the prize money for each winner
        int[] prizeMoney = new int[prizeValues.length];
        int moneyPerWinner = totalPrizeMoney / numWinners;
        int remainingPrizeMoney = totalPrizeMoney % numWinners;
        for (int i = 0; i < prizeValues.length; i++) {
            prizeMoney[i] = moneyPerWinner;
            if (remainingPrizeMoney > 0) {
                prizeMoney[i]++;
                remainingPrizeMoney--;
            }
        }

        // Display the prize money for each winner
        for (int i = 0; i < numWinners; i++) {
            System.out.print(winners[i] + ": ");
            int numPrizes = 0;
            for (int j = 0; j <= prizeMoney[i]-1; j++) {
                if (numPrizes > 0) {
                    System.out.print(",");
                }
                System.out.print(prizeValues[numPrizes]);
                numPrizes++;
            }
            System.out.println();
        }
    }
}
