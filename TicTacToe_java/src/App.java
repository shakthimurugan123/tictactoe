
public class App {
    public static void main(String[] args) throws Exception {
        TicTacToe TicTacToe=new TicTacToe();


    }
}

/**
 Tic-Tac-Toe Java Project Presentation
Introduction
Welcome to the presentation of our Tic-Tac-Toe game project implemented in Java! In this brief overview, we'll explore the key concepts utilized in building this game.

1. JFrame
What is it?
JFrame is a class in the Java Swing library used to create and manage a windowed GUI application.
Usage in the Project
Our Tic-Tac-Toe game utilizes JFrame to create the main window interface where the game is played.
JFrame provides the structure for organizing game elements such as buttons and labels.
2. JButton
What is it?
JButton is a class in the Java Swing library used to create a clickable button component.
Usage in the Project
Each cell in the Tic-Tac-Toe grid is represented by a JButton.
JButtons allow players to interact with the game by clicking to mark their moves.
3. ActionListener
What is it?
ActionListener is an interface in Java Swing used to handle events triggered by user actions, such as button clicks.
Usage in the Project
ActionListeners are attached to each JButton to handle the player's moves.
When a player clicks a button, the ActionListener triggers an action to update the game state and check for a winner.
4. GridLayout
What is it?
GridLayout is a layout manager in Java Swing used to arrange components in a grid of rows and columns.
Usage in the Project
The Tic-Tac-Toe game board is organized using a GridLayout to ensure proper alignment of buttons in a 3x3 grid.
5. Game Logic
Key Concepts
Switching Players: The game tracks the current player (X or O) and switches between them after each move.
Win Detection: Winning combinations are checked horizontally, vertically, and diagonally to determine the winner.
Tie Condition: If all cells are filled without a winner, the game ends in a tie.
Conclusion
Our Tic-Tac-Toe game project demonstrates the effective use of Java Swing components and event handling to create an interactive and enjoyable gaming experience. By leveraging concepts such as JFrame, JButton, ActionListener, and GridLayout, we've built a functional and visually appealing game that showcases the versatility of Java for GUI development.

Thank you for your attention, and let's continue exploring the exciting world of Java programming!
 */