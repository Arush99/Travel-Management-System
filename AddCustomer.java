import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener  {

    JLabel lblusername ,lblname,labelusername,labelname,lblcountry;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfphone,tfemail;
    JRadioButton rmale, rfemale;
    JButton ba,bb;



    AddCustomer() {
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

         lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);

        comboid = new JComboBox(new String[] {"Passport", "Aadhar Card", "Pan Card", "Ration Card"});
        comboid.setBounds(220, 90, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);


         lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 210, 70, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210, 70, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 290, 150, 25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 330, 150, 25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30, 370, 150, 25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 150, 25);
        add(tfemail);

         ba = new JButton("Add");
        ba.setBounds(70, 420, 100, 25);
        ba.setBackground(Color.black);
        ba.setForeground(Color.white);
        ba.addActionListener(this);
        add(ba);


        bb = new JButton("Back");
        bb.setBounds(240, 420, 100, 25);
        bb.setBackground(Color.black);
        bb.setForeground(Color.white);
//        bb.addActionListener(this);
        add(bb);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from account where username ='vijay123' ");
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);

    }


    public static void main(String[] args) {
        new AddCustomer();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==ba){
           String username = labelusername.getText();
           String id = (String) comboid.getSelectedItem();
           String number = tfnumber.getText();
           String name = labelname.getText();
           String gender = null;
           if (rmale.isSelected()){
               gender ="Male";
           }
           else {
               gender ="Female";
           }
           String country = tfcountry.getText();
           String address = tfaddress.getText();
           String phone = tfphone.getText();
           String email = tfemail.getText();

           try {
               Conn c = new Conn();
                String query = "insert into customer values ( '"+username +"' ,'"+id +"' ,'"+number +"','"+name +"','"+gender+"','"+country+"','"+address +"','"+phone +"','"+email +"' ) ";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully ");
                 setVisible(false);
           }catch(Exception e){
               e.printStackTrace();

           }
        }
        else {
            setVisible(false);
        }

    }
}
