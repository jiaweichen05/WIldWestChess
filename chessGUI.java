import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.EventListener;
import java.lang.Object;

public class chessGUI extends JFrame implements ActionListener {
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private JButton New, Resign;
    private JPanel chessBoard;
    private final JLabel message = new JLabel("Welcome to the Wild West Chess!");
    private String[] moveSet;
    private static int count;
    private Icon old, movedTo;
    private JButton firstButton, secondButton;
    private static JDialog gameRules;
    private static boolean isFirstGame = true;
    private final Icon bbish = new ImageIcon("images/blackBishop.PNG");
    private final Icon brook = new ImageIcon("images/blackRook.PNG");
    private final Icon bking = new ImageIcon("images/blackKing.PNG");
    private final Icon bqueen = new ImageIcon("images/blackQueen.PNG");
    private final Icon bpawn = new ImageIcon("images/blackPawn.PNG");
    private final Icon bknight = new ImageIcon("images/blackKnight.PNG");
    private final Icon wbish = new ImageIcon("images/whiteBishop.PNG");
    private final Icon wrook = new ImageIcon("images/whiteRook.PNG");
    private final Icon wking = new ImageIcon("images/whiteKing.PNG");
    private final Icon wqueen = new ImageIcon("images/whiteQueen.PNG");
    private final Icon wpawn = new ImageIcon("images/whitePawn.PNG");
    private final Icon wknight = new ImageIcon("images/whiteKnight.PNG");

    public chessGUI() {
        count = 0;
        setTitle("Wild West Chess");
        initializeGUI();
        add(gui);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        addActionListener();
        setActionCommands();
        setLocationRelativeTo(null);
        setVisible(true);
        if (isFirstGame)
        {
            isFirstGame = false;
            gameRules.setVisible(true);
        }else{
            gameRules.setVisible(false);
        }
    }

    public void initializeGUI() {
        moveSet = new String[2];
        old = new ImageIcon();
        movedTo = new ImageIcon();
        firstButton = new JButton();
        secondButton = new JButton();
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
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

        chessBoard = new JPanel(new GridLayout(8, 8));
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        gui.add(chessBoard);



        Insets buttonMargins = new Insets(0, 0, 0, 0);
        for (int row = 0; row < chessBoardSquares.length; row++) {
            boolean black;
            if (row % 2 == 0) {
                black = false;
            } else {
                black = true;
            }
            for (int col = 0; col < chessBoardSquares[0].length; col++) {
                chessBoardSquares[row][col] = new JButton();
                chessBoardSquares[row][col].setMargin(buttonMargins);

                if (black) {
                    chessBoardSquares[row][col].setBackground(Color.BLACK);
                    black = false;
                } else {
                    chessBoardSquares[row][col].setBackground(Color.WHITE);
                    black = true;
                }
                chessBoard.add(chessBoardSquares[row][col]);
            }
        }
        for (int i = 0; i < 8; i++) {
            chessBoardSquares[1][i].setIcon(bpawn);
        }
        for (int i = 0; i < 8; i++) {
            chessBoardSquares[6][i].setIcon((wpawn));
        }
        chessBoardSquares[0][0].setIcon(brook);
        chessBoardSquares[7][0].setIcon(wrook);
        chessBoardSquares[0][1].setIcon(bknight);
        chessBoardSquares[7][1].setIcon(wknight);
        chessBoardSquares[0][2].setIcon(bbish);
        chessBoardSquares[7][2].setIcon(wbish);
        chessBoardSquares[0][3].setIcon(bqueen);
        chessBoardSquares[7][3].setIcon(wqueen);
        chessBoardSquares[0][4].setIcon(bking);
        chessBoardSquares[7][4].setIcon(wking);
        chessBoardSquares[0][5].setIcon(bbish);
        chessBoardSquares[7][5].setIcon(wbish);
        chessBoardSquares[0][6].setIcon(bknight);
        chessBoardSquares[7][6].setIcon(wknight);
        chessBoardSquares[0][7].setIcon(brook);
        chessBoardSquares[7][7].setIcon(wrook);

        gameRules = new JDialog(); gameRules.setTitle("Wild West Chess Rules"); gameRules.setSize(500,175);
        JTextPane info = new JTextPane(); info.setEditable(false);
        info.setText("In order to move the pieces, please click the piece you want to move and " +
                "then click on the tile that you want to move to\n\nYou can choose to play traditional " +
                "chess by following conventional chess rules or you can play \"Wild West Mode\"" +
                "\n\nThank you for playing Wild West Chess!");
//        info.setFont(newFont);
        gameRules.add(info); gameRules.setLocationRelativeTo(null);
    }

    public void addActionListener() {
        for (int row = 0; row < chessBoardSquares.length; row++) {
            for (int col = 0; col < chessBoardSquares[0].length; col++) {
                chessBoardSquares[row][col].addActionListener(this);
            }
        }
        New.addActionListener(this);
        Resign.addActionListener(this);
    }

    public void setActionCommands() {
        int count1 = 1;
        for (int row = 0; row < chessBoardSquares.length; row++) {
            for (int col = 0; col < chessBoardSquares[row].length; col++) {
                chessBoardSquares[row][col].setActionCommand(Integer.toString(count1));
                count1++;
            }
        }
        New.setActionCommand("New");
        Resign.setActionCommand("Resign");
    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("New")) {
            dispose();
            new chessGUI();
        }
        if (actionCommand.equals("Resign")) {
            JDialog temp = new JDialog();
            temp.setTitle("Chess Dialog");
            temp.setSize(200, 100);
            JTextPane text = new JTextPane();
            text.setText("GAME OVER!\nCLICK NEW TO PLAY AGAIN");
            text.setEditable(false);
            temp.add(text); temp.setLocationRelativeTo(null);
            temp.setResizable(false); temp.setVisible(true);
        }
        if (!actionCommand.equals("New") && !actionCommand.equals("Resign")) {
            if (count < 2) {
                moveSet[count] = actionCommand;
                count++;
            }

            if (moveSet[0] != null && moveSet[1] != null) {
                for (int j = 1; j <= 64; j++) {
                    int rowVal, colVal;
                    if (j % 8 == 0) {
                        rowVal = j / 8 - 1;
                        colVal = 7;
                    } else {
                        rowVal = j / 8;
                        colVal = j % 8 - 1;
                    }
                    if (moveSet[0].equals(Integer.toString(j))) {
                        firstButton = chessBoardSquares[rowVal][colVal];
                        old = chessBoardSquares[rowVal][colVal].getIcon();
                    }
                    if (moveSet[1].equals(Integer.toString(j))) {
                        secondButton = chessBoardSquares[rowVal][colVal];
                        movedTo = chessBoardSquares[rowVal][colVal].getIcon();
                    }
                }
                firstButton.setIcon(null);
                secondButton.setIcon(old);

                count = 0;
                moveSet = new String[2];
                old = new ImageIcon();
                movedTo = new ImageIcon();
                firstButton = new JButton();
                secondButton = new JButton();

            }
        }
    }
}
