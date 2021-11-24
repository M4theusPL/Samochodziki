import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ProjektPanel extends JPanel implements KeyListener{

    int x1=0, x2=0, y1=60, y2=115, i=0, j=0, z=0, x=0, k=0, l=0;
    String nazwa = "samochodzik.png", nazwaDwa = "samochodzikLewo.png";

    ProjektPanel(){
        JPanel tlo = new JPanel();
        tlo.setBounds(0,0, 400,500);
        addKeyListener(this);

        //nowy wątek jazda samochodziku po górnym torze jazdy
        new Thread(new Runnable(){
            @Override
            public void run() {
                while (true) {
                    try {
                        jedzDol(-64,500);
                    } catch (Exception e) {
                    }
                }
            }
        }).start();

        //nowy wątek jazda samochodziku po dolnym torze jazdy
        new Thread(new Runnable(){
            @Override
            public void run() {
                while (true) {
                    try {
                        jedzGora(-64,500);
                    } catch (Exception e) {
                    }
                }
            }
        }).start();

    }

    public void paintComponent(Graphics graph) {
        super.paintComponent(graph);
        setBackground(Color.lightGray);
        Graphics2D g2d = (Graphics2D) graph;
        g2d.setColor(Color.black);


        //linia górna
        g2d.drawLine(0,50,500,50);
        //linia dolna
        g2d.drawLine(0,155,500,155);

        //przerywane linie
        g2d.drawLine(20,100,50,100);
        g2d.drawLine(80,100,110,100);
        g2d.drawLine(140,100,170,100);
        g2d.drawLine(200,100,230,100);
        g2d.drawLine(260,100,290,100);
        g2d.drawLine(320,100,350,100);
        g2d.drawLine(380,100,410,100);
        g2d.drawLine(440,100,470,100);


        //tworzenie samochodzików jako obiekty
        Samochodzik s1 = new Samochodzik(nazwa, x1, y1);
        s1.rysuj(g2d);
        Samochodzik s2 = new Samochodzik(nazwaDwa, x2, y2);
        s2.rysuj(g2d);

        //tworzenie ludzika jako obiekt
        Ludzik l1 = new Ludzik(z);
        l1.rysuj(g2d);

        //drzewka
        Color brazowy = new Color(139, 69, 19);
        g2d.setColor(brazowy); //Ustawienie koloru pobranego ze statycznych klasy Color (pakiet awt)
        g2d.fillRect(70,230,25,100); //Rysowanie prostokąta wypełnionego kolorem ustawionym metodą setColor
        g2d.fillRect(420,230,25,100);

        Color zielonyCiemny = new Color(0,128,0);
        g2d.setColor(zielonyCiemny);
        g2d.fillOval(48,200,70,70); //Rysowanie elipsy wypełnionej kolorem
        g2d.fillOval(398,200,70,70);
    }

    //zmiana koloru samochodzików wraz ze zmianą biegu
    public void zmienKolor(int i, int j){
        if (j==0){
            if (i==1){
                nazwa = "samochodzik.png";
                nazwaDwa = "samochodzikLewo.png";
            } else if (i==2){
                nazwa = "samochodzik2.png";
                nazwaDwa = "samochodzik2Lewy.png";
            } else if (i==3){
                nazwa = "samochodzik3.png";
                nazwaDwa = "samochodzik3Lewy.png";
            } else if (i==4){
                nazwa = "samochodzik4.png";
                nazwaDwa = "samochodzik4Lewy.png";
            } else if (i==5){
                nazwa = "samochodzik4.png";
                nazwaDwa = "samochodzik4Lewy.png";
            }
        } else {
            if (i==1){
                nazwaDwa = "samochodzik.png";
                nazwa = "samochodzikLewo.png";
            } else if (i==2){
                nazwaDwa = "samochodzik2.png";
                nazwa = "samochodzik2Lewy.png";
            } else if (i==3){
                nazwaDwa = "samochodzik3.png";
                nazwa = "samochodzik3Lewy.png";
            } else if (i==4){
                nazwaDwa = "samochodzik4.png";
                nazwa = "samochodzik4Lewy.png";
            }
        }
    }

    //zmiana pozycji ludzika w górę
    public void wgore(int i) {
        if(z<=-230){
        } else {
            z = z - i;
            x=z;
            repaint();
        }
    }

    //zmiana pozycji ludzika w dół
    public void wdol(int i) {
        if(z>=100){

        }  else {
            z = z + i;
            x=z;
            repaint();
        }
    }

    //odświeżanie programu do domyślnych wartości
    public void odswiezProgram(){
        nazwa = "samochodzik.png";
        nazwaDwa = "samochodzikLewo.png";
        i=-65;
        l=515;
        z=z-x;
    }

    //poruszanie się samochodziku na górnym torze jazdy
    public void jedzGora(int start, int koniec) {
        i = start;
        j = koniec;
        while (i < koniec) {
            //gdy wystąpi kolizja samochodzik - ludzik zatrzymaj samochodzik
            //w przeciwnym wypadku samochodzik jedzie dalej
            if (i == 180 && (z >= -220) && (z <= -165) ) {
                x1 = 180;
            } else {
                x1 = i;
                i += 1;
            }
            repaint();
            pause(10);
        }
    }

    //poruszanie się samochodziku na dolnym torze jazdy
    public void jedzDol(int poczatek, int end) {
        k = poczatek;
        l = end;
        while (l > k) {
            if (l == 275 && (z >= -180) && (z <= -105) ) {
                x2 = 275;
            } else {
                x2 = l;
                l -= 1;
            }
            repaint();
            pause(7);
        }
    }

    //pauza
    public void pause(int i) {
        try{
            Thread.sleep(i);
        } catch (InterruptedException e) {}
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e){
        int c = e.getKeyCode();

        //działanie strzałki w dół
        if (c == KeyEvent.VK_DOWN){
            wdol(5);
        }
        //działanie strzałki w górę
        if (c == KeyEvent.VK_UP){
            wgore(5);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
