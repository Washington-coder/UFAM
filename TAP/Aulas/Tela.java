import java.awt.*;
import javax.swing.*;

public class Tela extends JFrame{
    public Tela() {
        super("Minha primeira tela em Java");
        this.setLayout(null);
        this.setSize(260, 180);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Tela tela = new Tela();
        tela.setVisible(true);
    }
}
