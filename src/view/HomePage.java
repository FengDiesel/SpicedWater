package view;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {
    private JPanel contentPane;
    private JLabel lblLogo, lblUsername;
    private JTextField txtUsername;
    private JButton submit;

    private JLabel img1,img2,img3;

    private ImageIcon logo = new ImageIcon("img\\logo-no-background.png");

    private final Color bgColor = new Color(40,38,52);
    private final Color priColor = new Color(255,64,87);

    private final int WIDTH = 1100;
    private final int HEIGHT = 1000;

    //private Image[] images = new Image[4];

    public HomePage(){
        contentPane = new JPanel();
        contentPane.setLayout(null);

        contentPane.setBackground(bgColor);
        this.setBounds(0,0,WIDTH, HEIGHT);

        lblLogo = new JLabel();
        lblLogo.setIcon(logo);
        lblLogo.setBounds(50,50,1000,174);
        contentPane.add(lblLogo);

        lblUsername = new JLabel("Username:");
        lblUsername.setForeground(priColor);
        lblUsername.setBounds(0,280,WIDTH,50);
        lblUsername.setFont(new Font("Proza Libre Regular", Font.BOLD, 30));
        lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setForeground(bgColor);
        txtUsername.setBackground(priColor);
        txtUsername.setBounds(350,350,400,50);
        txtUsername.setFont(new Font("Proza Libre Regular", Font.BOLD, 30));
        txtUsername.setBorder(null);
        txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(txtUsername);

        submit = new JButton("PLAY");
        submit.setBounds(200,500,300,100);
        contentPane.add(submit);

        //repaint();

        this.setContentPane(contentPane);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(JTextField txtUsername) {
        this.txtUsername = txtUsername;
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }

    /*public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponents(g2);

    }*/


}
