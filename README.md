# 🏴‍☠️ Pick the Coins - A Dynamic Programming Game

### 📌 Description
**Pick the Coins** is a two-player strategic game that demonstrates the **Optimal Game Strategy Problem** using **Dynamic Programming**. Players take turns picking either the first or last coin from a row, aiming to maximize their total sum while anticipating their opponent’s best possible moves. The game ensures an engaging experience with an interactive UI and multiple game modes.

### 🎮 Features
- **Single-player mode** (Play against a computer)
- **Multiplayer mode** (Compete with another player)
- **Multiple input methods**:
  - **Manual input** (Insert your own coin values)
  - **Random generation** (System generates coins)
  - **File-based input** (Load from a file)
- **Dynamic Programming implementation** to determine the optimal strategy.
- **Visual representation** of the DP table and selected coins.
- **Beautiful UI** with an adventurous pirate theme!

---

## 📷 Screenshots

### 🏠 Main Menu
![Main Menu](https://github.com/abdar7eem/-Pick-the-Coins---A-Dynamic-Programming-Game/blob/main/MainMenu.png)

### 🎭 Select Game Mode
![Select Game Mode](https://github.com/abdar7eem/-Pick-the-Coins---A-Dynamic-Programming-Game/blob/main/GameMode.png)

### 💾 Select Data Insertion Method
![Data Insertion](https://github.com/abdar7eem/-Pick-the-Coins---A-Dynamic-Programming-Game/blob/main/GameMethod.png)

### 🏆 Random Mode - Game Result
![Random Mode Result](https://github.com/abdar7eem/-Pick-the-Coins---A-Dynamic-Programming-Game/blob/main/Random.png)

### 🎲 Manual Mode - Game Play
![Manual Mode](https://github.com/abdar7eem/-Pick-the-Coins---A-Dynamic-Programming-Game/blob/main/Computer.png)

---

# 🏴‍☠️ Pick the Coins - A Dynamic Programming Game

## 🏗️ Algorithm Explanation

The **Optimal Game Strategy Problem** is solved using **Dynamic Programming**. The DP table is constructed as follows:

1. Define `dp[i][j]` as the maximum sum a player can collect from index `i` to `j`.
2. Consider both choices: picking the first or last coin.
3. Store the results in a table to ensure optimal moves at every stage.

### Example
For the given set of coins:
```plaintext
coins = [4, 15, 7, 3, 8, 9]

Expected Result: 27
Coins Chosen: [9, 8, 7, 3]
DP Table Displayed in the UI

