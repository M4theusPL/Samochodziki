import javax.swing.*;
import java.awt.*;

public class Ludzik {

    private int z=0, gora=240, dol=260;

    public Ludzik(int z){
        this.z = z;

        if(gora<40){
            z=0;
        }
    }

    public void rysuj (Graphics graph){
        graph.fillOval(245,gora+=z,10,10);
        graph.drawLine(250,250+z, 240, 260+z);
        graph.drawLine(250,250+z, 260, 260+z);
        graph.drawLine(250,250+z, 250, 260+z);
        graph.drawLine(250,260+z, 240, 270+z);
        graph.drawLine(250,dol+z, 260, 270+z);
    }

}
