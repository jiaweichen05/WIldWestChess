import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.EventListener;
import java.lang.Object;
public class Piece {
    private Icon image;
    private Boolean black;


    public Piece(ImageIcon temp, boolean black){
        image = temp;
        this.black = black;
    }

    public boolean isBlack(){
        return black;
    }

    public Icon getImage(){
        return image;
    }
}
