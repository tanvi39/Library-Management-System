import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReturnBookDetails extends JFrame implements ActionListener {
    JButton b1;
    JLabel l1;
    public ReturnBookDetails(){
        setTitle(" Return Book Details");
        setBackground(Color.pink);
        b1= new JButton("Back");
        b1.addActionListener(this);
        b1.setBounds(300, 500, 100, 30);
        b1.setForeground(Color.black);
        b1.setBackground(Color.white);

        l1 = new JLabel("");
        add(l1);
        l1.setBounds(20, 50, 680, 200);

        try{
            Conn con=new Conn();
            String sql = "SELECT * FROM `return book`";
            Statement st= con.c.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                l1.setText(l1.getText()+"<html>"+"Student Id: "+ rs.getInt("Student Id")+"&nbsp;&nbsp;&nbsp;&nbsp;"+"Student Name: "+ rs.getString("Student Name")+ "&nbsp;&nbsp;&nbsp;&nbsp;"+ "Book Id: "+rs.getInt("Book Id")+ "&nbsp;&nbsp;&nbsp;&nbsp;"+"Book Name: "+ rs.getString("Book Name") +  "&nbsp;&nbsp;&nbsp;&nbsp;"+ "Return Date: "+ rs.getString("Date") + "<br><br><html>");  }

        }
        catch (Exception ae){
            System.out.println(ae);
        }


        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(Color.blue, 2, true), "Return-Book-Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
        panel.setBackground(Color.pink);
        panel.setBounds(10, 30, 710, 500);

        add(panel);

        setLayout(null);
        setSize(750, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(b1);


    }
    public static void main(String[] args) {
        new ReturnBookDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==b1){
            this.setVisible(false);
            new Details().setVisible(true);

        }
    }
}
