import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.EventListener;
import java.lang.Object;

public class Button {
    private static int row = 0;
    private static int col = 0;
    private int myrow;
    private int mycol;
    private JButton button;
    public Button(){
        button = new JButton();
        myrow = row;
        mycol = col;
        row++;
        col++;
    }

    public int getRow(){
        return myrow;
    }

    public int getCol(){
        return mycol;
    }

}
