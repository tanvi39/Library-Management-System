import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class SignUp extends JFrame implements ActionListener {
    JPanel contentPane;
    JTextField t1, t2, t3;
    JButton b1, b2;
    JPasswordField p1,p2;
    JLabel title;

    public SignUp() {
        setTitle("Sign Up");
        contentPane = new JPanel();
        contentPane.setBackground(Color.pink);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        title= new JLabel("SIGN UP");
        title.setFont(new Font("Osward", Font.BOLD, 30));
        title.setBounds(40,40,450,40);
        contentPane.add(title);

        JLabel l1 = new JLabel("Enter Username:");
        l1.setBounds(50, 100, 100, 30);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Enter Name:");
        l2.setBounds(50, 150, 100, 30);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Email:");
        l3.setBounds(50, 200, 100, 30);
        contentPane.add(l3);

        JLabel l4= new JLabel("Password:");
        l4.setBounds(50, 250, 100, 30);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Confirm Password:");
        l5.setBounds(50, 300, 150, 30);
        contentPane.add(l5);

        t1 = new JTextField();
        t1.setBounds(200, 100, 200, 30);
        contentPane.add(t1);

        t2 = new JTextField();
        t2.setBounds(200, 150, 200, 30);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setBounds(200, 200, 200, 30);
        contentPane.add(t3);

        p1 = new JPasswordField();
        p1.setBounds(200, 250, 200, 30);
        contentPane.add(p1);

        p2 = new JPasswordField();
        p2.setBounds(200, 300, 200, 30);
        contentPane.add(p2);



        b1 = new JButton("SignUp");
        b1.addActionListener(this);
        b1.setBounds(100, 400, 100, 30);
        b1.setForeground(Color.black);
        b1.setBackground(Color.white);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(300, 400, 100, 30);
        b2.setForeground(Color.black);
        b2.setBackground(Color.white);
        contentPane.add(b2);


        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(Color.blue, 2, true), "SignUp",
                TitledBorder.LEADING, TitledBorder.TOP, null, Color.blue));
        panel.setBackground(Color.pink);
        panel.setBounds(10, 20, 460, 520);
        contentPane.add(panel);



        setLayout(null);
        setSize(500, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public void actionPerformed(ActionEvent ae) {
        try {
            Conn con = new Conn();

            if (ae.getSource() == b1) {
                String sql = "INSERT INTO `signup`(`Username`, `Name`, `Email`, `Password`, `Confirm Password`) VALUES (?,?,?,?,?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t1.getText());
                st.setString(2, t2.getText());
                st.setString(3, t3.getText());
                st.setString(4, p1.getText());
                st.setString(5, p2.getText());

                int i = st.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(b1, "SignUp Successful!!");
                }

                t1.setText("");
                t2.setText("");
                t3.setText("");
                p1.setText("");
                p2.setText("");

            }
            if (ae.getSource() == b2) {
                this.setVisible(false);
                new Login().setVisible(true);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignUp();
    }
}
