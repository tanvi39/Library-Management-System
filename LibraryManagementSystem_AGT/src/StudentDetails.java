import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class StudentDetails extends JFrame implements ActionListener {
    JButton b1;
    JLabel l1;

    public StudentDetails(){
        setTitle("Student Details");
        setBackground(Color.pink);
        b1= new JButton("Back");
        b1.addActionListener(this);
        b1.setBounds(250, 500, 100, 30);
        b1.setForeground(Color.black);
        b1.setBackground(Color.white);


        l1 = new JLabel("");
        add(l1);
        l1.setBounds(20, 50, 580, 100);
        try{
            Conn con=new Conn();
            String sql = "SELECT * FROM `student details`";
            Statement st= con.c.createStatement();
            ResultSet rs= st.executeQuery(sql);

            while(rs.next()){
                l1.setText(l1.getText()+ "<html>"+"Id: "+ rs.getInt("Id")+"&nbsp;&nbsp;&nbsp;&nbsp;"+"Name: "+ rs.getString("Name")+ "&nbsp;&nbsp;&nbsp;&nbsp;"+"Father Name: "+ rs.getString("Father Name")+"&nbsp;&nbsp;&nbsp;&nbsp;"+"Course: "+ rs.getString("Course")+ "&nbsp;&nbsp;&nbsp;&nbsp;"+"Year: "+ rs.getString("Year") +  "<br><br><html>");
            }

        }
        catch (Exception ae){
            System.out.println(ae);
        }


        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(Color.blue, 2, true), "Issue-Book-Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
        panel.setBackground(Color.pink);
        panel.setBounds(10, 30, 560, 500);
        add(panel);

        setLayout(null);
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(b1);


    }

    public static void main(String[] args) {
        new StudentDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==b1){
            this.setVisible(false);
            new Details().setVisible(true);

        }
    }

}

