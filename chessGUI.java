import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.util.EventListener;

public class chessGUI extends JFrame implements EventListener{
    private final JPanel gui = new JPanel(new BorderLayout(3,3));
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private JPanel chessBoard;
    private final JLabel message = new JLabel("Welcome to the Wild West Chess!");

    public chessGUI(){
        setTitle("Wild West Chess");
        initializeGUI();
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize(350,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initializeGUI(){
        gui.setBorder(new EmptyBorder(5,5,5,5));
        JToolBar tools = new JToolBar();
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("New"));
        tools.addSeparator();
        tools.add(new JButton("Resign"));
        tools.addSeparator();
        tools.add(message);

        chessBoard = new JPanel(new GridLayout(0,9));
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        gui.add(chessBoard);

        Insets buttonMargins = new Insets(0,0,0,0);
        for (int row = 0; row < chessBoardSquares.length; row++)
        {
            for (int col = 0; col < chessBoardSquares[0].length; col++)
            {
                JButton b = new JButton();
                b.setMargin(buttonMargins);
            }
        }
    }
}
