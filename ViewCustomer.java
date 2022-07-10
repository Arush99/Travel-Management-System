import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class ViewCustomer extends JFrame {
    ViewCustomer(){
       setBounds(450,180,870,625);
       getContentPane().setBackground(Color.white);
       setLayout(null);

       JLabel lblusername = new JLabel("Username");
       lblusername.setBounds(30,50,150,25);
       add(lblusername);

       JLabel labelusername = new JLabel();
       labelusername.setBounds(220,50,150,25);
       add(labelusername);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(70,50,150,25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220,90,150,25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(110,50,150,25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelusername.setBounds(220,130,150,25);
        add(labelusername);

        JLabel lblname = new JLabel("Name");
        lblusername.setBounds(150,50,150,25);
        add(lblusername);

        JLabel labelname = new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);

        JLabel lblcountry = new JLabel("Country");
        lblusername.setBounds(190,50,150,25);
        add(lblusername);

        JLabel labelcountry = new JLabel();
        labelusername.setBounds(220,210,150,25);
        add(labelusername);

     setVisible(true);
    }

    public static void main(String[] args) {
        new ViewCustomer();
    }

}
