import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 400;

    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[][] board = new JButton[3][3];
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;

    boolean gameOver = false;
    int turns = 0;

    TicTacToe() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);

                tile.setBackground(Color.ORANGE);
                tile.setForeground(Color.BLUE);
                tile.setFont(new Font("Arial", Font.BOLD, 60));
               // tile.setFocusable(true);
                tile.setFocusable(false);
                // tile.setText(currentPlayer);
                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (gameOver)
                            return;
                        JButton tile = (JButton) e.getSource();
                        if (tile.getText().equals("")) {
                            tile.setText(currentPlayer);
                            turns++;
                            checkWinner();
                            if (!gameOver) {
                                currentPlayer = currentPlayer == playerX ? playerO : playerX;
                                textLabel.setText("<html><span style='color: #FFFF00; font-weight: bold;'>"
                                        + currentPlayer + "</span>'s turn.</html>");
                            }

                        }

                    }
                });

            }
        }

        JButton restartButton = new JButton("Restart");
        restartButton.setPreferredSize(new Dimension(100, 35)); // Set preferred size here
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
        frame.add(restartButton, BorderLayout.SOUTH);
    }

    void checkWinner() {
        // horizontal
        for (int r = 0; r < 3; r++) {
            if (board[r][0].getText().equals(""))
                continue;

            if (board[r][0].getText().equals(board[r][1].getText())
                    && board[r][1].getText().equals(board[r][2].getText())) {
                highlightWinnerCells(board[r][0], board[r][1], board[r][2]);
                gameOver = true;
                return;
            }
        }

        // vertical
        for (int c = 0; c < 3; c++) {
            if (board[0][c].getText().equals(""))
                continue;

            if (board[0][c].getText().equals(board[1][c].getText())
                    && board[1][c].getText().equals(board[2][c].getText())) {
                highlightWinnerCells(board[0][c], board[1][c], board[2][c]);
                gameOver = true;
                return;
            }
        }

        // diagonal
        if (!board[0][0].getText().equals("") && board[0][0].getText().equals(board[1][1].getText())
                && board[0][0].getText().equals(board[2][2].getText())) {
            highlightWinnerCells(board[0][0], board[1][1], board[2][2]);
            gameOver = true;
            return;
        }

        // anti-diagonal
        if (!board[0][2].getText().equals("") && board[0][2].getText().equals(board[1][1].getText())
                && board[0][2].getText().equals(board[2][0].getText())) {
            highlightWinnerCells(board[0][2], board[1][1], board[2][0]);
            gameOver = true;
            return;
        }

        // Tie
        if (turns == 9) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    board[r][c].setEnabled(false);
                }
            }
            textLabel.setText("It's a tie!");
            gameOver = true;
        }
    }

    void highlightWinnerCells(JButton... buttons) {
        for (JButton button : buttons) {
            button.setBackground(Color.GREEN);
        }
        textLabel.setText("<html><span style='color: #FFFF00; font-weight: bold;'>"
                + currentPlayer + "</span> is the Winner!</html>");
        // Disable all other buttons
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (!board[r][c].getText().equals("")) {
                    board[r][c].setEnabled(false);
                }
            }
        }
    }

    void restartGame() {
        // Reset button states
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c].setText("");
                board[r][c].setEnabled(true);
                board[r][c].setBackground(Color.ORANGE);
            }
        }
        currentPlayer = playerX;
        gameOver = false;
        turns = 0;
        textLabel.setText("<html><span style='color: #FFFF00; font-weight: bold;'>"
                + currentPlayer + "</span>'s turn.</html>");
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}




/**
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TicTacToe {
    int boardWidth=600;
    int boardHeight=400;

    JFrame frame=new JFrame("Tic-Tac-Toe");
    JLabel textLabel=new JLabel();
    JPanel textPanel=new JPanel();
    JPanel boardPanel=new JPanel();

    JButton[][] board=  new JButton[3][3];
    String playerX ="X";
    String playerO ="O";
    String currentPlayer = playerX;

    boolean gameOver = false;
    int turns = 0;

    TicTacToe(){
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground (Color.white);
        textLabel.setFont(new Font("Arial",Font.BOLD,50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel);
        frame.add(textPanel,BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        for(int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                JButton tile=new JButton();
                board[r][c]=tile;
                boardPanel.add(tile);

                tile.setBackground(Color.ORANGE);
                tile.setForeground(Color.BLUE);
                tile.setFont(new Font("Arial",Font.BOLD,60));
                tile.setFocusable(true);
                tile.setFocusable(false);
               // tile.setText(currentPlayer);
               tile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    if(gameOver) return;
                    JButton tile=(JButton)e.getSource();
                    if(tile.getText()==""){
                        tile.setText(currentPlayer);
                        turns++;
                        checkWinner();
                        if(!gameOver){
                            currentPlayer = currentPlayer == playerX ? playerO : playerX;
                            textLabel.setText("<html><span style='color: #FFFF00; font-weight: bold;'>"
                            + currentPlayer + "</span>'s turn.</html>" );
                        }
       
                    }
                  

                }
               });
        
            }
        }
}
         void checkWinner(){
        //horizontal
        for(int r=0;r<3;r++){
            if(board[r][0].getText()=="") continue;

            if(board[r][0].getText() == board[r][1].getText() &&
               board[r][1].getText() == board[r][2].getText()){
                for(int i=0;i<3;i++){
                  setWinner(board[r][i]);
                }
                gameOver = true;
                return;
            }
        }

      //vertical
      for(int c=0;c<3;c++){
        if(board[0][c].getText() == "")continue;

        if (board[0][c].getText() == board[1][c].getText() &&
        board[1][c].getText() == board[2][c].getText()) {
            for(int i=0;i<3;i++){
                setWinner(board[i][c]);
            }
            gameOver=true;
            return;
        }
      }
      //diagonally
      if (board[0][0].getText().equals(board[1][1].getText()) &&
      board[1][1].getText().equals(board[2][2].getText()) &&
      !board[0][0].getText().isEmpty()) {
      for (int i = 0; i < 3; i++) {
          setWinner(board[i][i]);
      }
      gameOver = true;
      return;
  }
         
    //anidiagonally
    if(board[0][2].getText() == board[1][1].getText() &&
       board[1][1].getText() == board[2][0].getText() &&
       board[0][2].getText() !=""){
        setWinner(board[0][2]);
        setWinner(board[1][1]);
        setWinner(board[2][0]);
        gameOver = true;
        return;
       }     
       

       if(turns == 9){
        for(int r=0;r<3;r++){
           for(int c=0;c<3;c++){
            setTie(board[r][c]);
           } 
        }
        gameOver = true;
       }
            }
     void setWinner(JButton tile){
        tile.setForeground(Color.green);
        tile.setBackground(Color.gray);
        textLabel.setText("<html><span style='color: #FFFF00; font-weight: bold;'>"
        + currentPlayer + "</span>is the Winner!</html>");
     }
     void setTie(JButton tile){
      tile.setForeground(Color.RED);
      tile.setBackground(Color.gray);
      textLabel.setText("tie!");
     }
}
 */