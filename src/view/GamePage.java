package view;

import model.Drink;
import model.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class GamePage extends JFrame {
    private JPanel contentPane;
    private JButton btn1,btn2,btn3,btn4;

    private final Color bgColor = new Color(40,38,52);
    private final Color priColor = new Color(255,64,87);
    private final Font font = new Font("Proza Libre Regular", Font.BOLD, 40);
    private final Font smallerFont = new Font("Proza Libre Regular", Font.PLAIN, 30);

    private final int WIDTH = 1500;
    private final int HEIGHT = 900;

    private Drink[] drinks = new Drink[4];
    private Game game;

    private Image currentImage;

    public GamePage(Game game){
        this.game = game;

        contentPane = new JPanel();
        contentPane.setLayout(null);

        contentPane.setBackground(bgColor);
        this.setBounds(0,0,WIDTH, HEIGHT);

        btn1 = new JButton();
        btn1.setBounds(830, 400, 300, 100);
        btn1.setFont(smallerFont);
        btn1.setBackground(priColor);
        btn1.setBorder(null);
        contentPane.add(btn1);

        btn2 = new JButton();
        btn2.setBounds(1150, 400, 300, 100);
        btn2.setFont(smallerFont);
        btn2.setBackground(priColor);
        btn2.setBorder(null);
        contentPane.add(btn2);

        btn3 = new JButton();
        btn3.setBounds(830, 550, 300, 100);
        btn3.setFont(smallerFont);
        btn3.setBackground(priColor);
        btn3.setBorder(null);
        contentPane.add(btn3);

        btn4 = new JButton();
        btn4.setBounds(1150, 550, 300, 100);
        btn4.setFont(smallerFont);
        btn4.setBackground(priColor);
        btn4.setBorder(null);
        contentPane.add(btn4);

        this.setContentPane(contentPane);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponents(g2);

        drinks = game.getDrinks();

        System.out.println("< ----- > \nQuestion number: " + game.getQuestionNumber());
        System.out.println("Drink number: " + game.getDrinkNumber());
        System.out.println("Image URL: " + drinks[game.getDrinkNumber()].getStrDrinkThumb());

        if(game.getQuestionNumber() == 0) System.out.println("Correct answer: " + drinks[game.getDrinkNumber()].getStrDrink());
        else if(game.getQuestionNumber() == 1) System.out.println("Correct answer: " + drinks[game.getDrinkNumber()].getStrGlass());
        else System.out.println("Correct answer: " + drinks[game.getDrinkNumber()].getStrIngredient1());


        try {
            currentImage = ImageIO.read(new URL(drinks[game.getDrinkNumber()].getStrDrinkThumb()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        g2.drawImage(currentImage, 100,100,700,700,null);

        g2.setColor(priColor);
        g2.setFont(font);

        g2.drawString("Lives: " + game.getLives(), 800, 100);
        g2.drawString("Score: " + game.getScore(), 1000, 100);

        FontMetrics fm = g2.getFontMetrics();
        int stringWidth = fm.stringWidth(game.getQuestions()[game.getQuestionNumber()]);

        g2.drawString(game.getQuestions()[game.getQuestionNumber()], ((WIDTH - stringWidth) / 2)+380, 350);

        updateButtons();
    }

    public void finishGame() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);

        JOptionPane.showMessageDialog(null, "You scored: " + game.getScore(), "Game finished", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }

    private void updateButtons(){
        btn1.setVisible(true);
        btn2.setVisible(true);
        btn3.setVisible(true);
        btn4.setVisible(true);

        btn1.setBounds(830, 400, 300, 100);
        btn2.setBounds(1150, 400, 300, 100);
        btn3.setBounds(830, 550, 300, 100);
        btn4.setBounds(1150, 550, 300, 100);

        switch (game.getQuestionNumber()) {
            case 0 -> {
                btn1.setText(drinks[0].getStrDrink());
                btn2.setText(drinks[1].getStrDrink());
                btn3.setText(drinks[2].getStrDrink());
                btn4.setText(drinks[3].getStrDrink());
            }
            case 1 -> {
                btn1.setText(drinks[0].getStrGlass());
                btn2.setText(drinks[1].getStrGlass());
                btn3.setText(drinks[2].getStrGlass());
                btn4.setText(drinks[3].getStrGlass());
            }
            case 2 -> {
                btn1.setText(drinks[0].getStrIngredient1());
                btn2.setText(drinks[1].getStrIngredient1());
                btn3.setText(drinks[2].getStrIngredient1());
                btn4.setText(drinks[3].getStrIngredient1());
            }
        }

        if(btn1.getText().equalsIgnoreCase(btn2.getText())) {
            btn2.setVisible(false);
            btn1.setBounds(980, 400, 300, 100);
        }

        if(btn1.getText().equalsIgnoreCase(btn3.getText())) {
            btn3.setVisible(false);
            btn4.setBounds(980, 550, 300, 100);
        }

        if(btn1.getText().equalsIgnoreCase(btn4.getText())) {
            btn4.setVisible(false);
            btn3.setBounds(980, 550, 300, 100);
        }

        if(btn2.getText().equalsIgnoreCase(btn3.getText())) {
            btn3.setVisible(false);
            btn4.setBounds(980, 550, 300, 100);
        }

        if(btn2.getText().equalsIgnoreCase(btn4.getText())) {
            btn4.setVisible(false);
            btn3.setBounds(980, 550, 300, 100);
        }

        if(btn3.getText().equalsIgnoreCase(btn4.getText())) {
            btn4.setVisible(false);
            btn3.setBounds(980, 550, 300, 100);
        }
    }

    public JButton getBtn1() {
        return btn1;
    }

    public void setBtn1(JButton btn1) {
        this.btn1 = btn1;
    }

    public JButton getBtn2() {
        return btn2;
    }

    public void setBtn2(JButton btn2) {
        this.btn2 = btn2;
    }

    public JButton getBtn3() {
        return btn3;
    }

    public void setBtn3(JButton btn3) {
        this.btn3 = btn3;
    }

    public JButton getBtn4() {
        return btn4;
    }

    public void setBtn4(JButton btn4) {
        this.btn4 = btn4;
    }
}
