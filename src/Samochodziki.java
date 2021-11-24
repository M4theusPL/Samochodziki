import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Samochodziki extends JFrame implements ActionListener{

    JButton buttonKolorNiebieski, buttonKolorZielony, buttonKolorCzerwony, buttonKolorRozowy, buttonKierunekJazdy;
    JMenuItem menuItemOdswiez, menuItemZamknij, menuItemOMnie, menuItemOProgramie;

    int i=1, j=0, z=270;

    Samochodziki(){
        super("Animacja samochodzik");
        setBounds(200,250,500,470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ProjektPanel projektPanel = new ProjektPanel();

        JPanel panel = new JPanel(new BorderLayout());
        JToolBar pasek = new JToolBar();
        //ustawienie skupienia na panel z wartością true
        panel.setFocusable(true);
        //dodanie zdarzeń klawiszy kalwiatury
        panel.addKeyListener(projektPanel);
        //utawienie skubienia projektPanel jako okno, do prawidłowego działania klawiszy
        projektPanel.requestFocusInWindow();

        buttonKolorNiebieski = new JButton("Niebieski");
        buttonKolorNiebieski.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i=1;
                projektPanel.zmienKolor(i,j);
                projektPanel.requestFocusInWindow();
            }
        });
        pasek.add(buttonKolorNiebieski);

        buttonKolorZielony = new JButton("Zielony");
        buttonKolorZielony.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i=2;
                projektPanel.zmienKolor(i,j);
                projektPanel.requestFocusInWindow();
            }
        });
        pasek.add(buttonKolorZielony);

        buttonKolorCzerwony = new JButton("Czerwony");
        buttonKolorCzerwony.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i=3;
                projektPanel.zmienKolor(i,j);
                projektPanel.requestFocusInWindow();
            }
        });
        pasek.add(buttonKolorCzerwony);

        buttonKolorRozowy = new JButton("Różowy");
        buttonKolorRozowy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i=4;
                projektPanel.zmienKolor(i,j);
                projektPanel.requestFocusInWindow();
            }
        });
        pasek.add(buttonKolorRozowy);

        buttonKierunekJazdy = new JButton("Zmiana biegu");
        buttonKierunekJazdy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (j==0){
                    j=1;
                    projektPanel.zmienKolor(i,j);
                    projektPanel.requestFocusInWindow();
                } else {
                    j=0;
                    projektPanel.zmienKolor(i,j);
                    projektPanel.requestFocusInWindow();
                }
            }
        });
        pasek.add(buttonKierunekJazdy);

        panel.add(pasek,BorderLayout.NORTH);
        panel.add(BorderLayout.CENTER,projektPanel);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu menuPlik = new JMenu("Plik");
        JMenu menuInformacje = new JMenu("Informacje");

        jMenuBar.add(menuPlik);
        jMenuBar.add(menuInformacje);

        menuItemOdswiez = new JMenuItem("Odswież program");
        menuItemOdswiez.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                projektPanel.odswiezProgram();
            }
        });


        menuItemZamknij = new JMenuItem("Zamknij");
        menuItemZamknij.addActionListener(this);

        menuItemOMnie = new JMenuItem("O mnie");
        menuItemOMnie.addActionListener(this);
        menuItemOProgramie = new JMenuItem("Informacje o programie");
        menuItemOProgramie.addActionListener(this);

        menuPlik.add(menuItemOdswiez);
        menuPlik.add(menuItemZamknij);
        menuInformacje.add(menuItemOMnie);
        menuInformacje.add(menuItemOProgramie);

        setJMenuBar(jMenuBar);

        setContentPane(panel);
        setVisible(true);
    }

    public static void main (String[] arg){
        new Samochodziki();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object o = e.getSource();
        if (o == menuItemZamknij) {
            int nr = JOptionPane.showConfirmDialog(Samochodziki.this, "Czy chcesz wyłączyć aplikację?", "Zamknięcie aplikacji", JOptionPane.YES_NO_OPTION);
            if (nr == 0)
                System.exit(0);
        } else if (o == menuItemOMnie){
            JOptionPane.showMessageDialog(Samochodziki.this, "Jestem studentem drugiego roku informatyki.\n" +
                    "Autor: M4theusPL\n");
        } else if (o == menuItemOProgramie){
            JOptionPane.showMessageDialog(Samochodziki.this, "To jest aplikacja napisana w jęzku Java.\n\n" +
                    "Program animuje przejazd samochodzików po drodze.\n" +
                    "Wyświetla drogę, dwa drzewka i ludzika, którym możemy sterować strzałkami (góra/dół).\n" +
                    "Gdy ludzik znajdzie się na torze jazdy danego samochodziku, samochodzik się zatrzymuje.\n" +
                    "Możliwe jest zmiana koloru samochodzików i biegu (do przodu, do tyłu).\n");
        }
    }

}
