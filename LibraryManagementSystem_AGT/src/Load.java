import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Load extends JFrame implements Runnable {

    JPanel contentPane;
    JProgressBar progressBar;
    int s;
    Thread th;

    public static void main(String[] args) {
        new Load().setVisible(true);
    }

    public void setUploading() {
        setVisible(false);
        th.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new Details().setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Load() {

        super("Loading");
        th = new Thread((Runnable) this);


        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbllibraryManagement = new JLabel("COGNITIVE LIBRARY");
        lbllibraryManagement.setForeground(Color.blue);
        lbllibraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
        lbllibraryManagement.setBounds(180, 60, 500, 35);
        contentPane.add(lbllibraryManagement);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 135, 300, 25);
        contentPane.add(progressBar);

        JLabel lblNewLabel_2 = new JLabel("Please Wait ...");
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lblNewLabel_2.setForeground(Color.white);
        lblNewLabel_2.setBounds(200, 165, 150, 20);
        contentPane.add(lblNewLabel_2);

        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setBounds(0, 0, 590, 390);
        contentPane.add(panel);

        setSize(600,400);

        setUploading();
    }
}

