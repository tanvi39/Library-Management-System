import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class AddingStudent extends JFrame implements ActionListener{
    JPanel contentPane;
    JTextField t1, t2, t3;
    JComboBox comboBox_1, comboBox_2;
    JButton b1, b2;

    public AddingStudent() {
        setTitle("Add Student");
        contentPane = new JPanel();
        contentPane.setBackground(Color.pink);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Student Id:");
        l1.setBounds(50, 100, 100, 30);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Student Name:");
        l2.setBounds(50, 150, 100, 30);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Father Name:");
        l3.setBounds(50, 200, 100, 30);
        contentPane.add(l3);

        JLabel l4= new JLabel("Course:");
        l4.setBounds(50, 250, 100, 30);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Year:");
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


        comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(
                new String[]{"B.Tech", "M.Tech", "MBA", "BBA", "BCA", "B.Sc", "M.Sc", "B.Com", "M.Com","Others"}));
        comboBox_2.setBounds(200, 250, 100, 30);
        contentPane.add(comboBox_2);

        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[]{"First", "Second", "Third", "Four"}));
        comboBox_1.setBounds(200, 300, 100, 30);
        contentPane.add(comboBox_1);


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
        panel.setBorder(new TitledBorder(new LineBorder(Color.blue, 2, true), "Add-Student",
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
                String sql = "INSERT INTO `student details`(`Id`, `Name`, `Father Name`, `Course`, `Year`) VALUES (?,?,?,?,?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t1.getText());
                st.setString(2, t2.getText());
                st.setString(3, t3.getText());
                st.setString(4,(String) comboBox_2.getSelectedItem());
                st.setString(5,(String) comboBox_1.getSelectedItem());

                int i = st.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(b1, "Student Added Successfully!!");
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
        new AddingStudent();
    }
}