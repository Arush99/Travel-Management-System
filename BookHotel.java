

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class BookHotel extends JFrame implements ActionListener {

    Choice chotel,cac,cfood;
    JLabel  l1,l2,l3,l4,l5,l6,l7, l11,l12,l13,l14,labelid;
    JTextField tfday ,tfpersons;
    String username;
    JButton b1,b2,b3;
    BookHotel(String username){
        this.username = username;
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon  i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(500,50,600,300);
        add(l10);

         l1 =new JLabel("BOOK HOTEL");
        l1.setBounds(100,10,200,30);
        l1.setFont(new Font("Tahoma", Font.BOLD,20));
        add(l1);

         l2 =new JLabel("Username ");
        l2.setBounds(40,70,100,30);
        l2.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN,16));
        add(l2);

        l11 =new JLabel();
        l11.setBounds(250,70,100,30);
        l11.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN,16));
        add(l11);

         l3 =new JLabel("Select Hotel ");
        l3.setBounds(40,110,150,30);
        l3.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN,16));
        add(l3);


        chotel = new Choice();
        chotel.setBounds(250,110,200,30);
        add(chotel);

        JLabel lblpersons =new JLabel("Number of Persons ");
        lblpersons.setBounds(40,150,150,25);
        lblpersons.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN,16));
        add(lblpersons);



        JLabel lbdays =new JLabel("Number  of Days ");
        lbdays.setBounds(40,190,150,25);
        lbdays.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN,16));
        add(lbdays);

        tfday = new JTextField("1");
        tfday.setBounds(250,190,200,25);
        add(tfday);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);


        JLabel  lblac=new JLabel("AC/Non-AC ");
        lblac.setBounds(40,230,150,25);
        lblac.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN,16));
        add( lblac);

        cac= new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230,200,20);
        add(cac);


        JLabel lblfood =new JLabel("Food included ");
        lblfood.setBounds(40,270,150,25);
        lblfood.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN,16));
        add(lblfood);

        cfood= new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270,200,20);
        add(cfood);

        JLabel lblid =new JLabel("ID");
        lblid.setBounds(40,310,150,20);
        lblid.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN,16));
        add(lblid);


        labelid =new JLabel();
        labelid.setBounds(250,310,150,25);
        add(labelid);




         l5 =new JLabel("Phone");
        l5.setBounds(40,350,150,25);
        l5.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN,16));
        add(l5);

        l12 =new JLabel();
        l12.setBounds(250,350,150,25);
        add(l12);

         l6 =new JLabel("Number");
        l6.setBounds(40,390,150,25);
        l6.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN,16));
        add(l6);

        l13 =new JLabel();
        l13.setBounds(250,390,200,25);
        add(l13);


         l7 =new JLabel("Total Price ");
        l7.setBounds(40,430,150,25);
        l7.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN,16));
        add(l7);

        l14 =new JLabel();
        l14.setBounds(250,430,150,25);
        l14.setForeground(Color.red);
        l14.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN,16));
        add(l14);

        try{
            Conn c =new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }


        b1 = new JButton( "Check price");
        b1.setBackground(Color.BLACK );
        b1.setForeground(Color.white);
        b1.setFont(new Font("times new roman",Font.PLAIN,15));
        b1.setBounds(60,490,120,25);
        //  b1.addActionListener(this);
        add(b1);


        b2 = new JButton( "Book Hotel");
        b2.setBackground(Color.BLACK );
        b2.setForeground(Color.white);
        b2.setFont(new Font("times new roman",Font.PLAIN,15));
        b2.setBounds(200,490,120,25);
        //   b2.addActionListener(this);

        add(b2);


        b3 = new JButton( "Back");
        b3.setBackground(Color.BLACK );
        b3.setForeground(Color.white);
        b3.setFont(new Font("times new roman",Font.PLAIN,15));
        b3.setBounds(340,490,120,25);
            b3.addActionListener(this);

        add(b3);





    }


    public static void main(String[] args){

        new BookHotel("vijay123").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==b3){
            setVisible(false);
        }else if(ae.getSource()==b1){
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("Select * from hotel where name = '"+chotel.getSelectedItem()+"'");
                while (rs.next()){
                    int cost = Integer.parseInt("costperson");
                    int ac = Integer.parseInt("acroom");
                    int food = Integer.parseInt("foodinclud");
                    int person = Integer.parseInt(tfpersons.getText());
                    int day = Integer.parseInt(tfday.getText());
                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();
                    if(person * day >0){
                        int total = 0;
                        total += acselected.equals("AC") ? ac: 0;
                        total += foodselected.equals("Yes") ? food: 0;
                        total +=cost;
                        total = total * person * day;
                        l7.setText("rs" + total);

                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Please enter Valid Details");
                    }

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String pack = chotel.getSelectedItem();
            int cost = 0;
            if (pack.equals("Golden Package ")){
                cost +=12000;
            }else  if(pack.equals("Silver Package")){
                cost +=25000;
            }else {
                cost += 32000;
            }
        }
        else{
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("insert into bookhotel values ('"+ l2.getText()+"','"+ chotel.getSelectedItem()+"','"+tfpersons.getText() +"','"+labelid.getText() +"','"+tfday.getText()+"','"+cac.getSelectedItem() +"','"+cfood.getSelectedItem() +"','"+l5.getText() +"','"+l6.getText()+"','"+l7.getText()+"')");
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}


