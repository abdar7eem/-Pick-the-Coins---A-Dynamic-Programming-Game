import java.io.File;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller implements Initializable {

    @FXML
    private AnchorPane MainMenuVbox;

    @FXML
    private Button backMode;

    @FXML
    private Button backSelectPlayer;

    @FXML
    private Button computerBtn;

    @FXML
    private AnchorPane computerFile;

    @FXML
    private Button computerFileBack;

    @FXML
    private Text computerFileP1Coins;

    @FXML
    private Text computerFileP2Coins;

    @FXML
    private HBox computerFileSelectedCoinsHbox;

    @FXML
    private TextArea computerFileTextArea;

    @FXML
    private Text computerFileWinner;

    @FXML
    private AnchorPane computerManual;

    @FXML
    private Button computerManualBack;

    @FXML
    private Spinner<Integer> computerManualSpinner = new Spinner<>(2, 30, 2);

    @FXML
    private AnchorPane computerRandom;

    @FXML
    private Button computerRandomBack;

    @FXML
    private Text computerRandomP1Coins;

    @FXML
    private Text computerRandomP2Coins;

    @FXML
    private HBox computerRandomSelectedCoinsHbox;

    @FXML
    private TextArea computerRandomTextArea;

    @FXML
    private Text computerRandomWinner;

    @FXML
    private Text comuterManualP1Coins;

    @FXML
    private Text comuterManualP2Coins;

    @FXML
    private HBox comuterManualSelectedCoinsHbox;

    @FXML
    private Button comuterManualSubmit;

    @FXML
    private TextArea comuterManualTextArea;

    @FXML
    private TilePane comuterManualTilePane;

    @FXML
    private Text comuterManualWinner;

    @FXML
    private Button fileModeBtn;

    @FXML
    private Button manualModeBtn;

    @FXML
    private Button playBtn;

    @FXML
    private AnchorPane playingModeVbox;

    @FXML
    private Button randomModeBtn;

    @FXML
    private AnchorPane selectPlayerVbox;

    @FXML
    private Spinner<Integer> twoPlayeManualSpinner = new Spinner<>(2, 30, 2);

    @FXML
    private Button twoPlayerBtn;

    @FXML
    private AnchorPane twoPlayerFile;

    @FXML
    private Button twoPlayerFileBack;

    @FXML
    private Button twoPlayerFileChoseA;

    @FXML
    private Button twoPlayerFileChoseB;

    @FXML
    private Text twoPlayerFileP1Coins;

    @FXML
    private Text twoPlayerFileP2Coins;

    @FXML
    private HBox twoPlayerFileSelectedCoinsHbox;

    @FXML
    private Text twoPlayerFileTurn;

    @FXML
    private Text twoPlayerFileWinner;

    @FXML
    private AnchorPane twoPlayerManual;

    @FXML
    private Button twoPlayerManualBack;

    @FXML
    private Button twoPlayerManualChoseA;

    @FXML
    private Button twoPlayerManualChoseB;

    @FXML
    private Text twoPlayerManualCoins;

    @FXML
    private Text twoPlayerManualP1Coins;

    @FXML
    private Text twoPlayerManualP2Coins;

    @FXML
    private HBox twoPlayerManualSelectedCoinsHbox;

    @FXML
    private Button twoPlayerManualSubmit;

    @FXML
    private TilePane twoPlayerManualTilePane;

    @FXML
    private Text twoPlayerManualTurn;

    @FXML
    private AnchorPane twoPlayerRandom;

    @FXML
    private Button twoPlayerRandomBack;

    @FXML
    private Button twoPlayerRandomChoseA;

    @FXML
    private Button twoPlayerRandomChoseB;

    @FXML
    private Text twoPlayerRandomP1Coins;

    @FXML
    private Text twoPlayerRandomP2Coins;

    @FXML
    private HBox twoPlayerRandomSelectedCoinsHbox;

    @FXML
    private Text twoPlayerRandomTurn;

    @FXML
    private Text twoPlayerRandomWinner;

    @FXML
    private Button exitBtn;

    int arrSelectedCoins[];
    int iteratorI;
    int iteratorJ;
    boolean isPlayer1Turn = false;
    int player1Score, player2Score;
    boolean isComputer = false;

    // MEthod to Mode back Action
    @FXML
    void backModeAction(ActionEvent event) {
        playingModeVbox.setVisible(false);
        selectPlayerVbox.setVisible(true);
        isComputer = false;
    }

    // Method to selectPlayer back Action
    @FXML
    void backSelectPlayerAction(ActionEvent event) {
        selectPlayerVbox.setVisible(false);
        MainMenuVbox.setVisible(true);
    }

    // Method to choose computer mode
    @FXML
    void choseComputerMode(ActionEvent event) {
        selectPlayerVbox.setVisible(false);
        playingModeVbox.setVisible(true);
        isComputer = true;
    }

    // Method to choose two player mode 
    @FXML
    void chosetwoPlayerMode(ActionEvent event) {
        selectPlayerVbox.setVisible(false);
        playingModeVbox.setVisible(true);
        isComputer = false;
    }

    // Method to computer File back action
    @FXML
    void computerFileBackAction(ActionEvent event) {
        player1Score = 0;
        player2Score = 0;
        computerFile.setVisible(false);
        playingModeVbox.setVisible(true);
        computerFileP1Coins.setText("-");
        computerFileP2Coins.setText("-");
        computerFileWinner.setText("-");
        computerFileTextArea.clear();
    }

    // Method to computer Manual Back action
    @FXML
    void computerManualBackAction(ActionEvent event) {
        computerManual.setVisible(false);
        playingModeVbox.setVisible(true);
        comuterManualTilePane.getChildren().clear();
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        tf1.setMaxWidth(80);
        tf2.setMaxWidth(80);
        comuterManualTilePane.getChildren().addAll(tf1, tf2);
        player1Score = 0;
        player2Score = 0;
        comuterManualP1Coins.setText("-");
        comuterManualP2Coins.setText("-");
        comuterManualWinner.setText("-");
        SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(2,
                Integer.MAX_VALUE, 2, 2);
        computerManualSpinner.setValueFactory(valueFactory1);
        comuterManualTextArea.clear();
    }

    // Method to computer Random back Action
    @FXML
    void computerRandomBackAction(ActionEvent event) {
        computerRandom.setVisible(false);
        playingModeVbox.setVisible(true);
        player1Score = 0;
        player2Score = 0;
        computerRandomP1Coins.setText("-");
        computerRandomP2Coins.setText("-");
        computerRandomWinner.setText("-");
        computerRandomTextArea.clear();
    }

    // Method to computer Manual submit Action
    @FXML
    void comuterManualSubmitAction(ActionEvent event) {

        arrSelectedCoins = new int[computerManualSpinner.getValue()];
        iteratorI = 0;
        iteratorJ = arrSelectedCoins.length - 1;
        boolean allFieldsValid = true;
        for (int j = 0; j < comuterManualTilePane.getChildren().size(); j++) {
            if (((TextField) comuterManualTilePane.getChildren().get(j)).getText().isEmpty()) {
                showError("Text Field error", "You must fill all Text Fields!");
                allFieldsValid = false;
                break;
            } else {
                try {
                    int k = Integer.parseInt(((TextField) comuterManualTilePane.getChildren().get(j)).getText());
                    arrSelectedCoins[j] = k;
                } catch (NumberFormatException ex) {
                    showError("Incorrect Input", "Enter valid numbers");
                    allFieldsValid = false;
                    break;
                }
            }
        }

        if (allFieldsValid) {
            isPlayer1Turn = true;
            player1Score = 0;
            player2Score = 0;
            comuterManualP1Coins.setText("-");
            comuterManualP2Coins.setText("-");
            comuterManualWinner.setText("-");
            Text txt = (Text) comuterManualSelectedCoinsHbox.getChildren().get(0);
            comuterManualSelectedCoinsHbox.getChildren().clear();
            comuterManualSelectedCoinsHbox.getChildren().addAll(txt);
            for (int i = 0; i < arrSelectedCoins.length; i++) {
                TextField tf = new TextField(String.valueOf(arrSelectedCoins[i]));
                tf.setMaxWidth(40);
                tf.setEditable(false);
                comuterManualSelectedCoinsHbox.getChildren().addAll(tf);
            }
        }

        CoinsDp dp = new CoinsDp();
        dp.maximumCoins(arrSelectedCoins);
        comuterManualWinner.setText(dp.printSelectedCoins(arrSelectedCoins));
        comuterManualP1Coins.setText(String.valueOf(dp.player1Score));
        comuterManualP2Coins.setText(String.valueOf(dp.player2Score));
        comuterManualTextArea.setText(dp.getDpTable(arrSelectedCoins));
    }

    // Method to file mode Button Action
    @FXML
    void fileModeBtnAction(ActionEvent event) {
        if (isComputer) {

            Text txt1 = (Text) computerFileSelectedCoinsHbox.getChildren().get(0);
            computerFileSelectedCoinsHbox.getChildren().clear();
            computerFileSelectedCoinsHbox.getChildren().addAll(txt1);

            FileChooser fileChooser1 = new FileChooser();
            fileChooser1.setTitle("Open Text File");
            fileChooser1.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            File selectedFile1 = fileChooser1.showOpenDialog(new Stage());
            if (selectedFile1 != null) {
                try {
                    readFile(selectedFile1);
                    playingModeVbox.setVisible(false);
                    computerFile.setVisible(true);

                    Text txt = (Text) computerFileSelectedCoinsHbox.getChildren().get(0);
                    computerFileSelectedCoinsHbox.getChildren().clear();
                    computerFileSelectedCoinsHbox.getChildren().addAll(txt);
                    for (int i = 0; i < arrSelectedCoins.length; i++) {
                        TextField tf = new TextField(String.valueOf(arrSelectedCoins[i]));
                        tf.setMaxWidth(40);
                        tf.setEditable(false);
                        computerFileSelectedCoinsHbox.getChildren().addAll(tf);
                    }

                    CoinsDp dp = new CoinsDp();
                    dp.maximumCoins(arrSelectedCoins);
                    computerFileWinner.setText(dp.printSelectedCoins(arrSelectedCoins));
                    computerFileP1Coins.setText(String.valueOf(dp.player1Score));
                    computerFileP2Coins.setText(String.valueOf(dp.player2Score));
                    computerFileTextArea.setText(dp.getDpTable(arrSelectedCoins));
                } catch (Exception ex) {
                    showError("File Data",
                            "Check the file data, the data must be even numbers of positive integers seperated by comma");
                }
            }
        }

        if (!isComputer) {

            Text txt1 = (Text) twoPlayerFileSelectedCoinsHbox.getChildren().get(0);
            twoPlayerFileSelectedCoinsHbox.getChildren().clear();
            twoPlayerFileSelectedCoinsHbox.getChildren().addAll(txt1);

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Text File");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            File selectedFile = fileChooser.showOpenDialog(new Stage());
            if (selectedFile != null) {
                try {
                    readFile(selectedFile);
                    playingModeVbox.setVisible(false);

                    twoPlayerFile.setVisible(true);

                    Text txt = (Text) twoPlayerFileSelectedCoinsHbox.getChildren().get(0);
                    twoPlayerFileSelectedCoinsHbox.getChildren().clear();
                    twoPlayerFileSelectedCoinsHbox.getChildren().addAll(txt);
                    for (int i = 0; i < arrSelectedCoins.length; i++) {
                        TextField tf = new TextField(String.valueOf(arrSelectedCoins[i]));
                        tf.setMaxWidth(40);
                        tf.setEditable(false);
                        twoPlayerFileSelectedCoinsHbox.getChildren().addAll(tf);
                    }

                    player1Score = 0;
                    player2Score = 0;
                    isPlayer1Turn = true;
                    twoPlayerFileTurn.setText("Player 1 Turn");
                    iteratorI = 0;
                    iteratorJ = arrSelectedCoins.length - 1;
                    twoPlayerFileChoseA.setDisable(false);
                    twoPlayerFileChoseB.setDisable(false);

                    twoPlayerFileChoseA.setText(String.valueOf(arrSelectedCoins[0]));
                    twoPlayerFileChoseB.setText(String.valueOf(arrSelectedCoins[arrSelectedCoins.length - 1]));

                } catch (Exception e) {
                    showError("File Data",
                            "Check the file data, the data must be even numbers of positive integers seperated by comma");
                }
            }
        }
    }

    // Method to manual mode Button Action
    @FXML
    void manualModeBtnAction(ActionEvent event) {
        playingModeVbox.setVisible(false);
        if (!isComputer) {

            Text txt = (Text) twoPlayerManualSelectedCoinsHbox.getChildren().get(0);
            twoPlayerManualSelectedCoinsHbox.getChildren().clear();
            twoPlayerManualSelectedCoinsHbox.getChildren().addAll(txt);

            twoPlayerManual.setVisible(true);
            twoPlayerManualTilePane.getChildren().clear();
            TextField tf1 = new TextField();
            TextField tf2 = new TextField();
            tf1.setMaxWidth(80);
            tf2.setMaxWidth(80);
            twoPlayerManualTilePane.getChildren().addAll(tf1, tf2);

        }
        if (isComputer) {

            Text txt = (Text) comuterManualSelectedCoinsHbox.getChildren().get(0);
            comuterManualSelectedCoinsHbox.getChildren().clear();
            comuterManualSelectedCoinsHbox.getChildren().addAll(txt);

            computerManual.setVisible(true);
            comuterManualTilePane.getChildren().clear();
            TextField tf1 = new TextField();
            TextField tf2 = new TextField();
            tf1.setMaxWidth(80);
            tf2.setMaxWidth(80);
            comuterManualTilePane.getChildren().addAll(tf1, tf2);
        }
    }

    // Method to play Button Action
    @FXML
    void playAction(ActionEvent event) {
        MainMenuVbox.setVisible(false);
        selectPlayerVbox.setVisible(true);
    }

    // Method to random Back Action
    @FXML
    void randomModeBtnAction(ActionEvent event) {
        if (isComputer) {

            Text txt = (Text) computerRandomSelectedCoinsHbox.getChildren().get(0);
            computerRandomSelectedCoinsHbox.getChildren().clear();
            computerRandomSelectedCoinsHbox.getChildren().addAll(txt);

            VBox vbox = new VBox();
            HBox hbox = new HBox();
            Label label = new Label("Enter the number of Coins:");
            Spinner<Integer> s = new Spinner<>();
            SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(2,
                    30, 2, 2);
            s.setValueFactory(valueFactory1);
            hbox.getChildren().addAll(label, s);
            hbox.setSpacing(15);
            hbox.setAlignment(Pos.CENTER);

            Label label2 = new Label("Enter the range of Coins value:");

            HBox hbox2 = new HBox();
            Spinner<Integer> s2 = new Spinner<>();
            SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(2,
                    1000, 2, 1);
            s2.setValueFactory(valueFactory2);
            hbox2.getChildren().addAll(label2, s2);
            hbox2.setSpacing(15);
            hbox2.setAlignment(Pos.CENTER);

            Button btn = new Button("Submit");

            vbox.getChildren().addAll(hbox, hbox2, btn);
            vbox.setAlignment(Pos.CENTER);
            vbox.setSpacing(15);
            Stage stage = new Stage();
            stage.setScene(new Scene(vbox, 400, 400));
            vbox.setStyle("-fx-background-image: url('img/coins.jpg'); "
                    + "-fx-background-size: cover; "
                    + "-fx-background-position: center center; "
                    + "-fx-background-repeat: no-repeat;");
            stage.show();
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent arg0) {
                    stage.close();
                    playingModeVbox.setVisible(false);

                    computerRandom.setVisible(true);

                    arrSelectedCoins = new int[s.getValue()];
                    Text txt = (Text) computerRandomSelectedCoinsHbox.getChildren().get(0);
                    computerRandomSelectedCoinsHbox.getChildren().clear();
                    computerRandomSelectedCoinsHbox.getChildren().addAll(txt);
                    for (int i = 0; i < arrSelectedCoins.length; i++) {
                        Random random = new Random();
                        arrSelectedCoins[i] = (random.nextInt(s2.getValue()) + 1);
                        TextField tf = new TextField(String.valueOf(arrSelectedCoins[i]));
                        tf.setMaxWidth(40);
                        tf.setEditable(false);
                        computerRandomSelectedCoinsHbox.getChildren().addAll(tf);
                    }

                    CoinsDp dp = new CoinsDp();
                    dp.maximumCoins(arrSelectedCoins);
                    computerRandomWinner.setText(dp.printSelectedCoins(arrSelectedCoins));
                    computerRandomP1Coins.setText(String.valueOf(dp.player1Score));
                    computerRandomP2Coins.setText(String.valueOf(dp.player2Score));
                    computerRandomTextArea.setText(dp.getDpTable(arrSelectedCoins));
                }
            });
        }

        if (!isComputer) {

            Text txt = (Text) twoPlayerRandomSelectedCoinsHbox.getChildren().get(0);
            twoPlayerRandomSelectedCoinsHbox.getChildren().clear();
            twoPlayerRandomSelectedCoinsHbox.getChildren().addAll(txt);

            VBox vbox = new VBox();
            HBox hbox = new HBox();
            Label label = new Label("Enter the number of Coins:");
            Spinner<Integer> s = new Spinner<>();
            SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(2,
                    10, 2, 2);
            s.setValueFactory(valueFactory1);
            hbox.getChildren().addAll(label, s);
            hbox.setSpacing(15);
            hbox.setAlignment(Pos.CENTER);

            Label label2 = new Label("Enter the range of Coins value:");

            HBox hbox2 = new HBox();
            Spinner<Integer> s2 = new Spinner<>();
            SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(2,
                    1000, 2, 1);
            s2.setValueFactory(valueFactory2);
            hbox2.getChildren().addAll(label2, s2);
            hbox2.setSpacing(15);
            hbox2.setAlignment(Pos.CENTER);

            Button btn = new Button("Submit");

            vbox.getChildren().addAll(hbox, hbox2, btn);
            vbox.setAlignment(Pos.CENTER);
            vbox.setSpacing(15);
            vbox.setStyle("-fx-background-image: url('img/coins.jpg'); "
                    + "-fx-background-size: cover; "
                    + "-fx-background-position: center center; "
                    + "-fx-background-repeat: no-repeat;");
            Stage stage = new Stage();
            stage.setScene(new Scene(vbox, 400, 400));
            stage.show();
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent arg0) {
                    stage.close();
                    playingModeVbox.setVisible(false);

                    twoPlayerRandom.setVisible(true);

                    player1Score = 0;
                    player2Score = 0;
                    isPlayer1Turn = true;
                    twoPlayerRandomTurn.setText("Player 1 Turn");

                    arrSelectedCoins = new int[s.getValue()];
                    Text txt = (Text) twoPlayerRandomSelectedCoinsHbox.getChildren().get(0);
                    twoPlayerRandomSelectedCoinsHbox.getChildren().clear();
                    twoPlayerRandomSelectedCoinsHbox.getChildren().addAll(txt);
                    for (int i = 0; i < arrSelectedCoins.length; i++) {
                        Random random = new Random();
                        arrSelectedCoins[i] = (random.nextInt(s2.getValue()) + 1);
                        TextField tf = new TextField(String.valueOf(arrSelectedCoins[i]));
                        tf.setMaxWidth(40);
                        tf.setEditable(false);
                        twoPlayerRandomSelectedCoinsHbox.getChildren().addAll(tf);
                    }

                    iteratorI = 0;
                    iteratorJ = arrSelectedCoins.length - 1;
                    twoPlayerRandomChoseA.setDisable(false);
                    twoPlayerRandomChoseB.setDisable(false);

                    twoPlayerRandomChoseA.setText(String.valueOf(arrSelectedCoins[0]));
                    twoPlayerRandomChoseB.setText(String.valueOf(arrSelectedCoins[arrSelectedCoins.length - 1]));
                }
            });
        }
    }

    // Method to two player File Back Action
    @FXML
    void twoPlayerFileBackAction(ActionEvent event) {
        twoPlayerFile.setVisible(false);
        playingModeVbox.setVisible(true);
        twoPlayerFileP1Coins.setText("-");
        twoPlayerFileP2Coins.setText("-");
        twoPlayerFileWinner.setText("-");
        isPlayer1Turn = true;
        player1Score = 0;
        player2Score = 0;
    }

    // Method to two player File Choose Action for choise A
    @FXML
    void twoPlayerFileChoseAAction(ActionEvent event) {
        if (iteratorI + 1 != iteratorJ) {
            if (isPlayer1Turn) {
                player1Score += arrSelectedCoins[iteratorI];
                twoPlayerFileTurn.setText("Player 2 Turn");
                twoPlayerFileSelectedCoinsHbox.getChildren().get(iteratorI + 1)
                        .setStyle("-fx-background-color:green");
            } else {
                player2Score += arrSelectedCoins[iteratorI];
                twoPlayerFileTurn.setText("Player 1 Turn");
                twoPlayerFileSelectedCoinsHbox.getChildren().get(iteratorI + 1)
                        .setStyle("-fx-background-color:red");
            }
            iteratorI++;
            twoPlayerFileChoseA.setText(String.valueOf(arrSelectedCoins[iteratorI]));
            isPlayer1Turn = !isPlayer1Turn;

        } else {
            twoPlayerFileChoseA.setDisable(true);
            twoPlayerFileChoseB.setDisable(true);
            twoPlayerFileChoseA.setText("-");
            twoPlayerFileChoseB.setText("-");
            twoPlayerFileTurn.setText("End of the Game");
            if (isPlayer1Turn) {
                player1Score += arrSelectedCoins[iteratorI];
                player2Score += arrSelectedCoins[iteratorJ];
                twoPlayerFileSelectedCoinsHbox.getChildren().get(iteratorI + 1)
                        .setStyle("-fx-background-color:green");
                twoPlayerFileSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:red");
            } else {
                player1Score += arrSelectedCoins[iteratorJ];
                player2Score += arrSelectedCoins[iteratorI];
                twoPlayerFileSelectedCoinsHbox.getChildren().get(iteratorI + 1)
                        .setStyle("-fx-background-color:red");
                twoPlayerFileSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:green");
            }
            twoPlayerFileP1Coins.setText(String.valueOf(player1Score));
            twoPlayerFileP2Coins.setText(String.valueOf(player2Score));
            if (player1Score > player2Score) {
                twoPlayerFileWinner.setText("Player 1");
            } else if (player1Score < player2Score) {
                twoPlayerFileWinner.setText("Player 2");
            } else {
                twoPlayerFileWinner.setText("It's tie");
            }
        }
    }

    // Method to two player File Choose Action for choise B
    @FXML
    void twoPlayerFileChoseBAction(ActionEvent event) {
        if (iteratorI != iteratorJ - 1) {
            if (isPlayer1Turn) {
                player1Score += arrSelectedCoins[iteratorJ];
                twoPlayerFileTurn.setText("Player 2 Turn");
                twoPlayerFileSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:green");
            } else {
                player2Score += arrSelectedCoins[iteratorJ];
                twoPlayerFileTurn.setText("Player 1 Turn");
                twoPlayerFileSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:red");
            }
            iteratorJ--;
            twoPlayerFileChoseB.setText(String.valueOf(arrSelectedCoins[iteratorJ]));
            isPlayer1Turn = !isPlayer1Turn;

        } else {
            twoPlayerFileChoseA.setDisable(true);
            twoPlayerFileChoseB.setDisable(true);
            twoPlayerFileChoseA.setText("-");
            twoPlayerFileChoseB.setText("-");
            twoPlayerFileTurn.setText("End of the Game");
            if (isPlayer1Turn) {
                player1Score += arrSelectedCoins[iteratorJ];
                player2Score += arrSelectedCoins[iteratorI];
                twoPlayerFileSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:green");
                twoPlayerFileSelectedCoinsHbox.getChildren().get(iteratorI - 1)
                        .setStyle("-fx-background-color:red");
            } else {
                player1Score += arrSelectedCoins[iteratorI];
                player2Score += arrSelectedCoins[iteratorJ];
                twoPlayerFileSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:red");
                twoPlayerFileSelectedCoinsHbox.getChildren().get(iteratorI - 1)
                        .setStyle("-fx-background-color:green");
            }
            twoPlayerFileP1Coins.setText(String.valueOf(player1Score));
            twoPlayerFileP2Coins.setText(String.valueOf(player2Score));
            if (player1Score > player2Score) {
                twoPlayerFileWinner.setText("Player 1");
            } else if (player1Score < player2Score) {
                twoPlayerFileWinner.setText("Player 2");
            } else {
                twoPlayerFileWinner.setText("It's tie");
            }
        }
    }

    // Method for two player manual Back Action
    @FXML
    void twoPlayerManualBackAction(ActionEvent event) {
        twoPlayerManual.setVisible(false);
        playingModeVbox.setVisible(true);
        twoPlayerManualTilePane.getChildren().clear();
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        tf1.setMaxWidth(80);
        tf2.setMaxWidth(80);
        twoPlayerManualTilePane.getChildren().addAll(tf1, tf2);
        SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(2,
                Integer.MAX_VALUE, 2, 2);
        twoPlayeManualSpinner.setValueFactory(valueFactory1);
        twoPlayerManualTurn.setText("Insert Coins to start");
        twoPlayerManualP1Coins.setText("-");
        twoPlayerManualP2Coins.setText("-");
        twoPlayerManualCoins.setText("-");
        isPlayer1Turn = true;
        player1Score = 0;
        player2Score = 0;
    }

    // Mehod to two player Manual Choose Action for Choise A
    @FXML
    void twoPlayerManualChoseAAction(ActionEvent event) {
        if (iteratorI + 1 != iteratorJ) {
            if (isPlayer1Turn) {
                player1Score += arrSelectedCoins[iteratorI];
                twoPlayerManualTurn.setText("Player 2 Turn");
                twoPlayerManualSelectedCoinsHbox.getChildren().get(iteratorI + 1)
                        .setStyle("-fx-background-color:green");
            } else {
                player2Score += arrSelectedCoins[iteratorI];
                twoPlayerManualTurn.setText("Player 1 Turn");
                twoPlayerManualSelectedCoinsHbox.getChildren().get(iteratorI + 1)
                        .setStyle("-fx-background-color:red");
            }
            iteratorI++;
            twoPlayerManualChoseA.setText(String.valueOf(arrSelectedCoins[iteratorI]));
            isPlayer1Turn = !isPlayer1Turn;

        } else {
            twoPlayerManualChoseA.setDisable(true);
            twoPlayerManualChoseB.setDisable(true);
            twoPlayerManualChoseA.setText("-");
            twoPlayerManualChoseB.setText("-");
            twoPlayerManualTurn.setText("End of the Game");
            if (isPlayer1Turn) {
                player1Score += arrSelectedCoins[iteratorI];
                player2Score += arrSelectedCoins[iteratorJ];

                twoPlayerManualSelectedCoinsHbox.getChildren().get(iteratorI + 1)
                        .setStyle("-fx-background-color:green");
                twoPlayerManualSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:red");
            } else {
                player1Score += arrSelectedCoins[iteratorJ];
                player2Score += arrSelectedCoins[iteratorI];

                twoPlayerManualSelectedCoinsHbox.getChildren().get(iteratorI + 1)
                        .setStyle("-fx-background-color:red");
                twoPlayerManualSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:green");
            }
            twoPlayerManualP1Coins.setText(String.valueOf(player1Score));
            twoPlayerManualP2Coins.setText(String.valueOf(player2Score));
            if (player1Score > player2Score) {
                twoPlayerManualCoins.setText("Player 1");
            } else if (player1Score < player2Score) {
                twoPlayerManualCoins.setText("Player 2");
            } else {
                twoPlayerManualCoins.setText("It's tie");
            }
        }
    }

    // Mehod to two player Manual Choose Action for Choise B
    @FXML
    void twoPlayerManualChoseBAction(ActionEvent event) {
        if (iteratorI != iteratorJ - 1) {
            if (isPlayer1Turn) {
                player1Score += arrSelectedCoins[iteratorJ];
                twoPlayerManualTurn.setText("Player 2 Turn");
                twoPlayerManualSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:green");
            } else {
                player2Score += arrSelectedCoins[iteratorJ];
                twoPlayerManualTurn.setText("Player 1 Turn");
                twoPlayerManualSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:red");
            }
            iteratorJ--;
            twoPlayerManualChoseB.setText(String.valueOf(arrSelectedCoins[iteratorJ]));
            isPlayer1Turn = !isPlayer1Turn;

        } else {
            twoPlayerManualChoseA.setDisable(true);
            twoPlayerManualChoseB.setDisable(true);
            twoPlayerManualChoseA.setText("-");
            twoPlayerManualChoseB.setText("-");
            twoPlayerManualTurn.setText("End of the Game");
            if (isPlayer1Turn) {
                player1Score += arrSelectedCoins[iteratorJ];
                player2Score += arrSelectedCoins[iteratorI];

                twoPlayerManualSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:green");
                twoPlayerManualSelectedCoinsHbox.getChildren().get(iteratorI + 1)
                        .setStyle("-fx-background-color:red");
            } else {
                player1Score += arrSelectedCoins[iteratorI];
                player2Score += arrSelectedCoins[iteratorJ];

                twoPlayerManualSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:red");
                twoPlayerManualSelectedCoinsHbox.getChildren().get(iteratorI + 1)
                        .setStyle("-fx-background-color:green");
            }
            twoPlayerManualP1Coins.setText(String.valueOf(player1Score));
            twoPlayerManualP2Coins.setText(String.valueOf(player2Score));
            if (player1Score > player2Score) {
                twoPlayerManualCoins.setText("Player 1");
            } else if (player1Score < player2Score) {
                twoPlayerManualCoins.setText("Player 2");
            } else {
                twoPlayerManualCoins.setText("It's tie");
            }
        }
    }

    // Method for two player Manual Submit Action
    @FXML
    void twoPlayerManualSubmitAction(ActionEvent event) {
        arrSelectedCoins = new int[twoPlayeManualSpinner.getValue()];
        iteratorI = 0;
        iteratorJ = arrSelectedCoins.length - 1;
        boolean allFieldsValid = true;
        for (int j = 0; j < twoPlayerManualTilePane.getChildren().size(); j++) {
            if (((TextField) twoPlayerManualTilePane.getChildren().get(j)).getText().isEmpty()) {
                showError("Text Field error", "You must fill all Text Fields!");
                allFieldsValid = false;
                break;
            } else {
                try {
                    int k = Integer.parseInt(((TextField) twoPlayerManualTilePane.getChildren().get(j)).getText());
                    arrSelectedCoins[j] = k;
                } catch (NumberFormatException ex) {
                    showError("Incorrect Input", "Enter valid numbers");
                    allFieldsValid = false;
                    break;
                }
            }
        }

        if (allFieldsValid) {
            isPlayer1Turn = true;
            player1Score = 0;
            player2Score = 0;
            twoPlayerManualTurn.setText("Player 1 Turn");
            twoPlayerManualP1Coins.setText("-");
            twoPlayerManualP2Coins.setText("-");
            twoPlayerManualCoins.setText("-");
            Text txt = (Text) twoPlayerManualSelectedCoinsHbox.getChildren().get(0);
            twoPlayerManualSelectedCoinsHbox.getChildren().clear();
            twoPlayerManualSelectedCoinsHbox.getChildren().addAll(txt);
            for (int i = 0; i < arrSelectedCoins.length; i++) {
                TextField tf = new TextField(String.valueOf(arrSelectedCoins[i]));
                tf.setMaxWidth(40);
                tf.setEditable(false);
                twoPlayerManualSelectedCoinsHbox.getChildren().addAll(tf);
            }

            twoPlayerManualChoseA.setDisable(false);
            twoPlayerManualChoseB.setDisable(false);

            twoPlayerManualChoseA.setText(String.valueOf(arrSelectedCoins[0]));
            twoPlayerManualChoseB.setText(String.valueOf(arrSelectedCoins[arrSelectedCoins.length - 1]));
        }
    }

    // Method for two player Random back Action
    @FXML
    void twoPlayerRandomBackAction(ActionEvent event) {
        twoPlayerRandom.setVisible(false);
        playingModeVbox.setVisible(true);
        twoPlayerRandomTurn.setText("Insert Coins to start");
        twoPlayerRandomP1Coins.setText("-");
        twoPlayerRandomP2Coins.setText("-");
        twoPlayerRandomWinner.setText("-");
        isPlayer1Turn = true;
        player1Score = 0;
        player2Score = 0;
    }

    // Method for two player random Choose Action for chise A
    @FXML
    void twoPlayerRandomChoseAAction(ActionEvent event) {
        if (iteratorI + 1 != iteratorJ) {
            if (isPlayer1Turn) {
                player1Score += arrSelectedCoins[iteratorI];
                twoPlayerRandomTurn.setText("Player 2 Turn");
                twoPlayerRandomSelectedCoinsHbox.getChildren().get(iteratorI + 1)
                        .setStyle("-fx-background-color:green");
            } else {
                player2Score += arrSelectedCoins[iteratorI];
                twoPlayerRandomTurn.setText("Player 1 Turn");
                twoPlayerRandomSelectedCoinsHbox.getChildren().get(iteratorI + 1)
                        .setStyle("-fx-background-color:red");
            }
            iteratorI++;
            twoPlayerRandomChoseA.setText(String.valueOf(arrSelectedCoins[iteratorI]));
            isPlayer1Turn = !isPlayer1Turn;

        } else {
            twoPlayerRandomChoseA.setDisable(true);
            twoPlayerRandomChoseB.setDisable(true);
            twoPlayerRandomChoseA.setText("-");
            twoPlayerRandomChoseB.setText("-");
            twoPlayerRandomTurn.setText("End of the Game");
            if (isPlayer1Turn) {
                player1Score += arrSelectedCoins[iteratorI];
                player2Score += arrSelectedCoins[iteratorJ];
                twoPlayerRandomSelectedCoinsHbox.getChildren().get(iteratorI + 1)
                        .setStyle("-fx-background-color:green");
                twoPlayerRandomSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:red");
            } else {
                player1Score += arrSelectedCoins[iteratorJ];
                player2Score += arrSelectedCoins[iteratorI];
                twoPlayerRandomSelectedCoinsHbox.getChildren().get(iteratorI + 1)
                        .setStyle("-fx-background-color:red");
                twoPlayerRandomSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:green");
            }
            twoPlayerRandomP1Coins.setText(String.valueOf(player1Score));
            twoPlayerRandomP2Coins.setText(String.valueOf(player2Score));
            if (player1Score > player2Score) {
                twoPlayerRandomWinner.setText("Player 1");
            } else if (player1Score < player2Score) {
                twoPlayerRandomWinner.setText("Player 2");
            } else {
                twoPlayerRandomWinner.setText("It's tie");
            }
        }
    }

    // Method for two Player Random Choose Action for Choise B
    @FXML
    void twoPlayerRandomChoseBAction(ActionEvent event) {
        if (iteratorI != iteratorJ - 1) {
            if (isPlayer1Turn) {
                player1Score += arrSelectedCoins[iteratorJ];
                twoPlayerRandomTurn.setText("Player 2 Turn");
                twoPlayerRandomSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:green");
            } else {
                player2Score += arrSelectedCoins[iteratorJ];
                twoPlayerRandomTurn.setText("Player 1 Turn");
                twoPlayerRandomSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:red");
            }
            iteratorJ--;
            twoPlayerRandomChoseB.setText(String.valueOf(arrSelectedCoins[iteratorJ]));
            isPlayer1Turn = !isPlayer1Turn;

        } else {
            twoPlayerRandomChoseA.setDisable(true);
            twoPlayerRandomChoseB.setDisable(true);
            twoPlayerRandomChoseA.setText("-");
            twoPlayerRandomChoseB.setText("-");
            twoPlayerRandomTurn.setText("End of the Game");
            if (isPlayer1Turn) {
                player1Score += arrSelectedCoins[iteratorJ];
                player2Score += arrSelectedCoins[iteratorI];
                twoPlayerRandomSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:green");
                twoPlayerRandomSelectedCoinsHbox.getChildren().get(iteratorI + 1)
                        .setStyle("-fx-background-color:red");
            } else {
                player1Score += arrSelectedCoins[iteratorI];
                player2Score += arrSelectedCoins[iteratorJ];
                twoPlayerRandomSelectedCoinsHbox.getChildren().get(iteratorJ + 1)
                        .setStyle("-fx-background-color:red");
                twoPlayerRandomSelectedCoinsHbox.getChildren().get(iteratorI + 1)
                        .setStyle("-fx-background-color:green");
            }
            twoPlayerRandomP1Coins.setText(String.valueOf(player1Score));
            twoPlayerRandomP2Coins.setText(String.valueOf(player2Score));
            if (player1Score > player2Score) {
                twoPlayerRandomWinner.setText("Player 1");
            } else if (player1Score < player2Score) {
                twoPlayerRandomWinner.setText("Player 2");
            } else {
                twoPlayerRandomWinner.setText("It's tie");
            }
        }
    }

    // Method to exit the game
    @FXML
    void exitAction(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Media sound = new Media(getClass().getResource("music/pirate.mp3").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        MainMenuVbox.setVisible(true);
        selectPlayerVbox.setVisible(false);
        playingModeVbox.setVisible(false);
        twoPlayerManual.setVisible(false);
        twoPlayerRandom.setVisible(false);
        twoPlayerFile.setVisible(false);
        computerManual.setVisible(false);
        computerRandom.setVisible(false);
        computerFile.setVisible(false);

        twoPlayerManualChoseA.setDisable(true);
        twoPlayerManualChoseB.setDisable(true);

        twoPlayerRandomChoseA.setDisable(true);
        twoPlayerRandomChoseB.setDisable(true);

        twoPlayerFileChoseA.setDisable(true);
        twoPlayerFileChoseB.setDisable(true);

        SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(2,
                Integer.MAX_VALUE, 2, 2);
        SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(2,
                Integer.MAX_VALUE, 2, 2);
        twoPlayeManualSpinner.setValueFactory(valueFactory1);
        computerManualSpinner.setValueFactory(valueFactory2);

        if (true) {
            TextField tf1 = new TextField();
            TextField tf2 = new TextField();
            TextField tf3 = new TextField();
            TextField tf4 = new TextField();

            tf1.setMaxWidth(80);
            tf2.setMaxWidth(80);
            tf3.setMaxWidth(80);
            tf4.setMaxWidth(80);
            twoPlayerManualTilePane.getChildren().addAll(tf1, tf2);
            comuterManualTilePane.getChildren().addAll(tf3, tf4);
        }

        twoPlayeManualSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue > oldValue) {
                TextField tf1 = new TextField();
                TextField tf2 = new TextField();
                tf1.setMaxWidth(80);
                tf2.setMaxWidth(80);
                twoPlayerManualTilePane.getChildren().addAll(tf1, tf2);
            } else {
                twoPlayerManualTilePane.getChildren().removeLast();
                twoPlayerManualTilePane.getChildren().removeLast();
            }
        });

        computerManualSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue > oldValue) {
                TextField tf1 = new TextField();
                TextField tf2 = new TextField();
                tf1.setMaxWidth(80);
                tf2.setMaxWidth(80);
                comuterManualTilePane.getChildren().addAll(tf1, tf2);
            } else {
                comuterManualTilePane.getChildren().removeLast();
                comuterManualTilePane.getChildren().removeLast();
            }
        });

    }

    public void readFile(File file) throws Exception {
        Scanner input = new Scanner(file);
        String line = input.nextLine().trim();
        line = line.replace(" ", "");
        String[] tokens = line.split(",");
        if (tokens.length % 2 == 0) {
            arrSelectedCoins = new int[tokens.length];
            for (int i = 0; i < arrSelectedCoins.length; i++) {
                arrSelectedCoins[i] = Integer.parseInt(tokens[i]);
            }
        } else {
            throw new Exception();
        }
    }

    public static void showError(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
