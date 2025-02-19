class CoinsDp {
    int[][] dp; 
    static int player1Score = 0; 
    static int player2Score = 0; 

    // Method to calculate the maximum amount of coins a player can collect
    public int maximumCoins(int[] arr) {
        int n = arr.length;
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i];
        }

        for (int k = 2; k <= n; k++) {
            for (int left = 0; left <= n - k; left++) {
                int right = left + k - 1;

                int leftOp1 = 0;
                if (left + 2 <= right) {
                    leftOp1 = dp[left + 2][right];
                }

                int leftOp2 = 0;
                if (left + 1 <= right - 1) {
                    leftOp2 = dp[left + 1][right - 1];
                }

                int takeLeft = arr[left] + Math.min(leftOp1, leftOp2);

                int rightOp1 = 0;
                if (left <= right - 2) {
                    rightOp1 = dp[left][right - 2];
                }

                int rightOp2 = 0;
                if (left + 1 <= right - 1) {
                    rightOp2 = dp[left + 1][right - 1];
                }

                int takeRight = arr[right] + Math.min(rightOp1, rightOp2);

                // Store the maximum value in the dp table
                dp[left][right] = Math.max(takeLeft, takeRight);
            }
        }
        return dp[0][n - 1];
    }

    // Method to display the DP table
    public String getDpTable(int[] coins) {
        String table = "";

        table += "       ";
        for (int coin : coins) {
            table += String.format("%-6d", coin);
        }
        table += "\n       ";

        for (int i = 0; i < coins.length; i++) {
            table += "__    ";
        }
        table += "\n";

        for (int i = 0; i < dp.length; i++) {
            table += String.format("%-6d| ", coins[i]); 
            for (int j = 0; j < dp[i].length; j++) {
                table += String.format("%-6d", dp[i][j]);
            }
            table += "\n";
        }
        return table;
    }

    // Method determine which coins each player select
    public String printSelectedCoins(int[] arr) {
        StringBuilder player1Coins = new StringBuilder();
        StringBuilder player2Coins = new StringBuilder();

        int player1ScoreTemp = 0;
        int player2ScoreTemp = 0;

        int left = 0;
        int right = arr.length - 1;
        boolean player1Turn = true; 

        while (left <= right) {
            
            int leftOp1 = 0;
            if (left + 2 <= right) {
                leftOp1 = dp[left + 2][right];
            }

            int leftOp2 = 0;
            if (left + 1 <= right - 1) {
                leftOp2 = dp[left + 1][right - 1];
            }

            int takeLeft = arr[left] + Math.min(leftOp1, leftOp2);

            
            int rightOp1 = 0;
            if (left <= right - 2) {
                rightOp1 = dp[left][right - 2];
            }

            int rightOp2 = 0;
            if (left + 1 <= right - 1) {
                rightOp2 = dp[left + 1][right - 1];
            }

            int takeRight = arr[right] + Math.min(rightOp1, rightOp2);

           
            if (takeLeft >= takeRight) {
                if (player1Turn) {
                    player1Coins.append(arr[left]).append(" ");
                    player1ScoreTemp += arr[left];
                } else {
                    player2Coins.append(arr[left]).append(" ");
                    player2ScoreTemp += arr[left];
                }
                left++; // Move the left pointer to right
            } else {
                if (player1Turn) {
                    player1Coins.append(arr[right]).append(" ");
                    player1ScoreTemp += arr[right];
                } else {
                    player2Coins.append(arr[right]).append(" ");
                    player2ScoreTemp += arr[right];
                }
                right--; // Move the right pointer to left
            }
            player1Turn = !player1Turn; 
        }

        // Update the final scores
        player1Score = player1ScoreTemp;
        player2Score = player2ScoreTemp;

        // Determine the winner and return the result
        if (player1ScoreTemp > player2ScoreTemp) {
            return "Player 1 wins! Selected coins: " + player1Coins.toString();
        } else if (player2ScoreTemp > player1ScoreTemp) {
            return "Player 2 wins! Selected coins: " + player2Coins.toString();
        } else {
            return "It's a tie! Player 1 selected: " + player1Coins.toString() +
                    "Player 2 selected: " + player2Coins.toString();
        }
    }

    public static void main(String[] args) {
        CoinsDp coinGame = new CoinsDp();
        int[] arr = { 4, 15, 7, 3, 8, 9 };
        int max = coinGame.maximumCoins(arr);
        System.out.println(max);
        System.out.println(coinGame.printSelectedCoins(arr));
        System.out.println(coinGame.getDpTable(arr));
    }
}
