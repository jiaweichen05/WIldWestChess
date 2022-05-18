import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.EventListener;
import java.lang.Object;

public class chessGUI extends JFrame implements EventListener{
    private final JPanel gui = new JPanel(new BorderLayout(3,3));
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private JPanel chessBoard;
    private final JLabel message = new JLabel("Welcome to the Wild West Chess!");

    public chessGUI(){
        setTitle("Wild West Chess");
        initializeGUI();
        add(gui);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize(1000,1000);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void initializeGUI(){
        gui.setBorder(new EmptyBorder(5,5,5,5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("New"));
        tools.addSeparator();
        tools.add(new JButton("Resign"));
        tools.addSeparator();
        tools.add(message);

        chessBoard = new JPanel(new GridLayout(8,8));
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        gui.add(chessBoard);
        ImageIcon icon = new ImageIcon("images/blackBishop.PNG");

        Insets buttonMargins = new Insets(0,0,0,0);
        for (int row = 0; row < chessBoardSquares.length; row++)
        {
            boolean black;
            if (row%2 == 0){
                black = false;
            }
            else{
                black = true;
            }
            for (int col = 0; col < chessBoardSquares[0].length; col++)
            {
                chessBoardSquares[row][col] = new JButton(icon);
                chessBoardSquares[row][col].setMargin(buttonMargins);
//                ImageIcon icon = new ImageIcon(
//                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                chessBoardSquares[row][col].setIcon(icon);

//                if (black){
//                    chessBoardSquares[row][col].setBackground(Color.BLACK);
//                    black = false;
//                }
//                else{
//                    chessBoardSquares[row][col].setBackground(Color.WHITE);
//                    black = true;
//                }
                chessBoard.add(chessBoardSquares[row][col]);
            }
        }
    }
//    public void addMouseListener(){
//        for (int row = 0; row< chessBoardSquares.length;row++){
//            for (int col = 0;col<chessBoardSquares[0].length;col++){
//                chessBoardSquares[row][col].addMouseListener(this);
//            }
//        }
//    }
//
//    public void mouseAction(MouseEvent e){
//
//    }
}
