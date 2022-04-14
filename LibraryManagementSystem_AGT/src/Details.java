import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Details extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;

    public Details(){
        setTitle("Welcome To Cognitive Library");
        setBackground(Color.pink);

        JLabel i1;
        ImageIcon i10  = new ImageIcon(ClassLoader.getSystemResource("student.png"));
        Image i11 = i10.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        i1= new JLabel(i12);
        i1.setBounds(50, 50, 200, 100);
        add(i1);


        b1= new JButton("Add Student");
        b1.setBounds(50,170,200,30);
        b1.setForeground(Color.yellow);
        b1.setBackground(Color.black);

        b2= new JButton("View Student Details");
        b2.setBounds(50,220,200,30);
        b2.setForeground(Color.cyan);
        b2.setBackground(Color.black);

        JLabel i2;
        ImageIcon i13  = new ImageIcon(ClassLoader.getSystemResource("book.png"));
        Image i14 = i13.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        i2= new JLabel(i15);
        i2.setBounds(300, 50, 200, 100);
        add(i2);

        b3= new JButton("Add Book");
        b3.setBounds(300,170,200,30);
        b3.setForeground(Color.yellow);
        b3.setBackground(Color.black);

        b4= new JButton("View Book Details");
        b4.setBounds(300,220,200,30);
        b4.setForeground(Color.cyan);
        b4.setBackground(Color.black);

        JLabel i3;
        ImageIcon i16  = new ImageIcon(ClassLoader.getSystemResource("issue.png"));
        Image i17 = i16.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i18 = new ImageIcon(i17);
        i3= new JLabel(i18);
        i3.setBounds(50, 300, 200, 100);
        add(i3);


        b5= new JButton("Issue Book");
        b5.setBounds(50,420,200,30);
        b5.setForeground(Color.yellow);
        b5.setBackground(Color.black);

        b6= new JButton("View Issued Book Details");
        b6.setBounds(50,470,200,30);
        b6.setForeground(Color.cyan);
        b6.setBackground(Color.black);


        JLabel i4;
        ImageIcon i19  = new ImageIcon(ClassLoader.getSystemResource("return.png"));
        Image i20 = i19.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i21 = new ImageIcon(i20);
        i4= new JLabel(i21);
        i4.setBounds(300, 300, 200, 100);
        add(i4);

        b7= new JButton("Return Book");
        b7.setBounds(300,420,200,30);
        b7.setForeground(Color.yellow);
        b7.setBackground(Color.black);

        b8= new JButton("View Return Book Details");
        b8.setBounds(300,470,200,30);
        b8.setForeground(Color.cyan);
        b8.setBackground(Color.black);

        b9= new JButton("Logout");
        b9.setBounds(170,580,200,30);
        b9.setForeground(Color.yellow);
        b9.setBackground(Color.black);


        add(b1);
        b1.addActionListener(this);
        add(b2);
        b2.addActionListener(this);
        add(b3);
        b3.addActionListener(this);
        add(b4);
        b4.addActionListener(this);
        add(b5);
        b5.addActionListener(this);
        add(b6);
        b6.addActionListener(this);
        add(b7);
        b7.addActionListener(this);
        add(b8);
        b8.addActionListener(this);
        add(b9);
        b9.addActionListener(this);


        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(Color.yellow, 2, true), "",
                TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
        panel.setBackground(Color.pink);
        panel.setBounds(10, 20, 560, 620);
        add(panel);


        setLayout(null);
        setSize(600, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==b1){
            this.setVisible(false);
            new AddingStudent().setVisible(true);
        }
        if (ae.getSource()==b2){
            this.setVisible(false);
            new StudentDetails().setVisible(true);
        }
        if (ae.getSource()==b3){
            this.setVisible(false);
            new AddingBooks().setVisible(true);
        }
        if (ae.getSource()==b4){
            this.setVisible(false);
            new BookDetails().setVisible(true);
        }
        if (ae.getSource()==b5){
            this.setVisible(false);
            new IssueBook().setVisible(true);
        }
        if (ae.getSource()==b6){
            this.setVisible(false);
            new IssueBookDetails().setVisible(true);
        }
        if (ae.getSource()==b7){
            this.setVisible(false);
            new ReturnBook().setVisible(true);
        }
        if (ae.getSource()==b8){
            this.setVisible(false);
            new ReturnBookDetails().setVisible(true);
        }
        if (ae.getSource()==b9){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Details();
    }
}
