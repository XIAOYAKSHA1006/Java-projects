/* It is a two player tic tac toe game. */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {
    private JFrame window;
    private JButton[][] buttons;
    private JLabel label;
    private String current_player;
    private String[][] board;

    public TicTacToe() {
        window = new JFrame("Tic Tac Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(300, 300);
        window.setLayout(new GridLayout(4, 3));

        current_player = "X";
        board = new String[3][3];
        buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 24));
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                window.add(buttons[i][j]);
                board[i][j] = "";
            }
        }

        label = new JLabel("Player X's turn", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        window.add(label);
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (board[row][col].equals("")) {
                board[row][col] = current_player;
                buttons[row][col].setText(current_player);

                String winner = checkWinner();
                if (winner != null) {
                    label.setText("Player " + winner + " wins!");
                    disableButtons();
                } else if (checkTie()) {
                    label.setText("It's a tie!");
                } else {
                    current_player = (current_player.equals("X")) ? "O" : "X";
                    label.setText("Player " + current_player + "'s turn");
                }
            }
        }
    }

    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    private String checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].equals("")) {
                return board[i][0];
            }
            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].equals("")) {
                return board[0][i];
            }
        }
        if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].equals("")) {
            return board[0][0];
        }
        if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].equals("")) {
            return board[0][2];
        }
        return null;
    }

    private boolean checkTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void run() {
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToe game = new TicTacToe();
            game.run();
        });
    }
}
