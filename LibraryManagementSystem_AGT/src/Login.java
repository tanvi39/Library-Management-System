import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.sql.*;

public class Login  extends JFrame implements ActionListener{


    JTextField textField;
    JPasswordField passwordField;
    JButton b1,b2;
    JPanel panel;
    JLabel l1,l2,title;


    public Login() {
        setTitle("Login");
        panel = new JPanel();
        panel.setBackground(Color.pink);
        setContentPane(panel);
        panel.setLayout(null);

        title= new JLabel("LOGIN TO COGNITIVE LIBRARY");
        title.setFont(new Font("Osward", Font.BOLD, 22));
        title.setBounds(40,40,450,40);
        panel.add(title);


        l1 = new JLabel("Enter Username:");
        l1.setBounds(50, 140, 100, 30);
        panel.add(l1);

        l2 = new JLabel(" Enter Password:");
        l2.setBounds(50, 200, 100, 30);
        panel.add(l2);

        textField = new JTextField();
        textField.setBounds(200, 140, 200, 30);
        panel.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 200,200 , 30);
        panel.add(passwordField);


        b1 = new JButton("Login");
        b1.addActionListener(this);
        b1.setBounds(100, 300, 80, 30);
        b1.setForeground(Color.black);
        b1.setBackground(Color.white);
        panel.add(b1);


        b2 = new JButton("SignUp");
        b2.addActionListener(this);
        b2.setBounds(300, 300, 80, 30);
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        panel.add(b2);


        JPanel panel1 = new JPanel();
        panel1.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2, true), "Login",
                TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
        panel1.setBackground(Color.PINK);
        panel1.setBounds(10, 10, 460, 340);
        panel.add(panel1);

        setLayout(null);
        setSize(500,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try {
                Conn con = new Conn();
                String sql = "select * from Signup where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, passwordField.getText());
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new Load().setVisible(true);
                } else
                    JOptionPane.showMessageDialog(b1, "Invalid Login!!");

            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if(ae.getSource() == b2){
            setVisible(false);
            SignUp su = new SignUp();
            su.setVisible(true);
        }
    }

    public static void main(String[] args) {

        new Login().setVisible(true);
    }

}
