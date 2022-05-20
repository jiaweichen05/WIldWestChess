import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.EventListener;
import java.lang.Object;

public class chessGUI extends JFrame implements ActionListener{
    private final JPanel gui = new JPanel(new BorderLayout(3,3));
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private JButton New, Resign;
    private JPanel chessBoard;
    private final JLabel message = new JLabel("Welcome to the Wild West Chess!");
    private String[] moveSet;

    public chessGUI(){
        setTitle("Wild West Chess");
        initializeGUI();
        add(gui);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize(1000,1000);
        addActionListener();
        setActionCommands();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initializeGUI(){
        gui.setBorder(new EmptyBorder(5,5,5,5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
         New = new JButton("New");
         Resign = new JButton("Resign");
        tools.add(New);
        tools.addSeparator();
        tools.add(Resign);
        tools.addSeparator();
        tools.add(message);

        chessBoard = new JPanel(new GridLayout(8,8));
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        gui.add(chessBoard);
        ImageIcon bbish = new ImageIcon("images/blackBishop.PNG");
        ImageIcon brook = new ImageIcon("images/blackRook.PNG");
        ImageIcon bking = new ImageIcon("images/blackKing.PNG");
        ImageIcon bqueen = new ImageIcon("images/blackQueen.PNG");
        ImageIcon bpawn = new ImageIcon("images/blackPawn.PNG");
        ImageIcon bknight = new ImageIcon("images/blackKnight.PNG");
        ImageIcon wbish = new ImageIcon("images/whiteBishop.PNG");
        ImageIcon wrook = new ImageIcon("images/whiteRook.PNG");
        ImageIcon wking = new ImageIcon("images/whiteKing.PNG");
        ImageIcon wqueen = new ImageIcon("images/whiteQueen.PNG");
        ImageIcon wpawn = new ImageIcon("images/whitePawn.PNG");
        ImageIcon wknight = new ImageIcon("images/whiteKnight.PNG");


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
                chessBoardSquares[row][col] = new JButton();
                chessBoardSquares[row][col].setMargin(buttonMargins);

                if (black){
                    chessBoardSquares[row][col].setBackground(Color.BLACK);
                    black = false;
                }
                else{
                    chessBoardSquares[row][col].setBackground(Color.WHITE);
                    black = true;
                }
                chessBoard.add(chessBoardSquares[row][col]);
            }
        }
        for(int i = 0;i<8;i++){
            chessBoardSquares[1][i].setIcon(bpawn);
        }
        for(int i = 0;i<8;i++){
            chessBoardSquares[6][i].setIcon((wpawn));
        }
        chessBoardSquares[0][0].setIcon(brook); chessBoardSquares[7][0].setIcon(wrook);
        chessBoardSquares[0][1].setIcon(bknight); chessBoardSquares[7][1].setIcon(wknight);
        chessBoardSquares[0][2].setIcon(bbish); chessBoardSquares[7][2].setIcon(wbish);
        chessBoardSquares[0][3].setIcon(bqueen); chessBoardSquares[7][3].setIcon(wqueen);
        chessBoardSquares[0][4].setIcon(bking); chessBoardSquares[7][4].setIcon(wking);
        chessBoardSquares[0][5].setIcon(bbish); chessBoardSquares[7][5].setIcon(wbish);
        chessBoardSquares[0][6].setIcon(bknight); chessBoardSquares[7][6].setIcon(wknight);
        chessBoardSquares[0][7].setIcon(brook); chessBoardSquares[7][7].setIcon(wrook);

    }
    public void addActionListener(){
        for (int row = 0; row< chessBoardSquares.length;row++){
            for (int col = 0;col<chessBoardSquares[0].length;col++){
                chessBoardSquares[row][col].addActionListener(this);
            }
        }
        New.addActionListener(this);
        Resign.addActionListener(this);
    }

    public void setActionCommands()
    {
        int count = 1;
        for (int row = 0; row < chessBoardSquares.length; row++)
        {
            for (int col = 0; col < chessBoardSquares[row].length; col++)
            {
                chessBoardSquares[row][col].setActionCommand(Integer.toString(count));
                count++;
            }
        }
        New.setActionCommand("New");
        Resign.setActionCommand("Resign");
    }

    public void actionPerformed(ActionEvent e){
        String actionCommand = e.getActionCommand();
        ImageIcon old = new ImageIcon(), movedTo = new ImageIcon();
        int count = 0;
        while (count < 2 ){
            moveSet[count] = actionCommand;
            count++;
        }
        for (int j = 1; j < 64; j++)
        {
            if (moveSet[0].equals(Integer.toString(j)))
            {
                old = moveSet[0].getIcon();
                continue;
            }
        }
        //Divide by 8 for row value
        // Modulo 8 for col value - 1



    }
}
