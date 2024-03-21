package hellofx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    Random random = new Random();
    
    ArrayList<Button> buttons;


    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button button10;
    @FXML
    private Button button11;
    @FXML
    private Button button12;
    @FXML
    private Button button13;
    @FXML
    private Button button14;
    @FXML
    private Button button15;
    @FXML
    private Button button16;
    @FXML
    private Button button17;
    @FXML
    private Button button18;
    @FXML
    private Button button19;
    @FXML
    private Button button20;
    @FXML
    private Button button21;
    @FXML
    private Button button22;
    @FXML
    private Button button23;
    @FXML
    private Button button24;
    @FXML
    private Button button25;
    @FXML
    private Button resetButton;
    @FXML
    private TextField winnerText;

    private char[] board = new char[25]; // Represents the board with 25 squares
    private boolean playerTurn = true; // Player starts first

    @FXML
    public void initialize() {
        buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24, button25));
        resetBoard();
    }

    @FXML
    void buttonClicked(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        int index = buttons.indexOf(clickedButton);
        if (board[index] == 0) {
            if (playerTurn) {
                clickedButton.setText("X");
                board[index] = 'X';
            }
            if (!checkWinner()) {
                playerTurn = !playerTurn;
                playAI();
                checkWinner();
            }
        }
    }

    void playAI() {
        int index;
        do {
            index = random.nextInt(25);
        } while (board[index] != 0);
        buttons.get(index).setText("O");
        board[index] = 'O';
        playerTurn = !playerTurn;
    }

    boolean checkWinner() {
        // Check rows
        for (int i = 0; i < 25; i += 5) {
            if (board[i] != 0 && board[i] == board[i + 1] && board[i] == board[i + 2] && board[i] == board[i + 3] && board[i] == board[i + 4]) {
                declareWinner(board[i]);
                return true;
            }
        }
    
        // Check columns
        for (int i = 0; i < 5; i++) {
            if (board[i] != 0 && board[i] == board[i + 5] && board[i] == board[i + 10] && board[i] == board[i + 15] && board[i] == board[i + 20]) {
                declareWinner(board[i]);
                return true;
            }
        }
    
        // Check diagonals
        if (board[0] != 0 && board[0] == board[6] && board[0] == board[12] && board[0] == board[18] && board[0] == board[24]) {
            declareWinner(board[0]);
            return true;
        }
        if (board[4] != 0 && board[4] == board[8] && board[4] == board[12] && board[4] == board[16] && board[4] == board[20]) {
            declareWinner(board[4]);
            return true;
        }
    
        // Check if the board is full (tie)
        boolean boardFull = true;
        for (int i = 0; i < 25; i++) {
            if (board[i] == 0) {
                boardFull = false;
                break;
            }
        }
        if (boardFull) {
            declareWinner('T'); // 'T' represents a tie
            return true;
        }
    
        return false; // No winner yet
    }
    
    void declareWinner(char winner) {
        if (winner == 'X') {
            winnerText.setText("Player X wins!");
        } else if (winner == 'O') {
            winnerText.setText("Player O wins!");
        } else {
            winnerText.setText("It's a tie!");
        }
        // You may add additional logic here, such as resetting the board or ending the game
    }
    

    void resetBoard() {
        Arrays.fill(board, (char) 0);
        buttons.forEach(button -> button.setText(""));
        playerTurn = true;
    }

    @FXML
    void resetButtonOnAction(ActionEvent e) {
        resetBoard();
        winnerText.setText("");
    }

}
