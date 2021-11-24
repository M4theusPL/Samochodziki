import javax.swing.*;
import java.awt.*;

public class Samochodzik {

    private String nazwa;
    private int x=0, y=0;

    public Samochodzik(String nazwa, int x, int y){
        this.nazwa = nazwa;
        this.x = x;
        this.y = y;
    }

    public void rysuj (Graphics graph){
        Image ikonka = new ImageIcon(getClass().getClassLoader().getResource(nazwa)).getImage();
        graph.drawImage(ikonka, x, y, null);
    }

}
