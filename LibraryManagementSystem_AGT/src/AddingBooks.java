import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class AddingBooks extends JFrame implements ActionListener {
    JPanel contentPane;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2;
    JComboBox c1;

    public AddingBooks() {
        setTitle("Add Book");
        contentPane = new JPanel();
        contentPane.setBackground(Color.pink);
        setContentPane(contentPane);
        contentPane.setLayout(null);



        JLabel l1 = new JLabel("Book Id:");
        l1.setBounds(50, 100, 100, 30);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Book Name:");
        l2.setBounds(50, 150, 100, 30);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Publisher:");
        l3.setBounds(50, 200, 100, 30);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Price:");
        l4.setBounds(50, 250, 100, 30);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Edition:");
        l5.setBounds(50, 300, 100, 30);
        contentPane.add(l5);

        t1 = new JTextField();
        t1.setBounds(200, 100, 200, 30);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setBounds(200, 150, 200, 30);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setBounds(200, 200, 200, 30);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setBounds(200, 250, 200, 30);
        contentPane.add(t4);

        c1 = new JComboBox();
        c1.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4"}));
        c1.setBounds(200, 300, 200, 30);
        contentPane.add(c1);


        b1 = new JButton("Add");
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
        panel.setBorder(new TitledBorder(new LineBorder(Color.blue, 2, true), "Add-Book",
                TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
        panel.setBackground(Color.pink);
        panel.setBounds(10, 30, 460, 500);
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
                String sql = "INSERT INTO `book details`(`Id`, `Name`, `Publisher`, `Price`, `Edition`) VALUES (?,?,?,?,?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t1.getText());
                st.setString(2, t2.getText());
                st.setString(3, t3.getText());
                st.setString(4, t4.getText());
                st.setString(5,(String) c1.getSelectedItem());

                int i = st.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(b1, "Book Added Successfully!!");
                }


            }
            if (ae.getSource() == b2) {
                this.setVisible(false);
                new Details().setVisible(true);

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new  AddingBooks();
    }
}