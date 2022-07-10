//import java.awt.*;
//import javax.swing.*;
//import java.sql.*;
//import java.awt.event.*;
//
//
//
//public class UpdateCustomer extends JFrame implements ActionListener {
//    JLabel lblusername ,lblname ,lblgender ,lblcountry,lbladdress , lblphone ,lblemail;
//    JComboBox comboid;
//    JTextField tfnumber , tfname ,tfcountry,tfaddress,tfphone,tfemail,tfid;
//    JRadioButton rmale,rfemale;
//    JButton add, back;
//    UpdateCustomer(){
//        setBounds(450,200,850,550);
//        setLayout(null);
//        getContentPane().setBackground(Color.white);
//
//         lblusername = new JLabel("Username");
//        lblusername.setBounds(30,50,150,25);
//        add(lblusername);
//
//
//
//        JLabel lblid = new JLabel("Valid Id");
//        lblid.setBounds(30,90,150,25);
//        add(lblid);
//
//        comboid = new JComboBox(new String[]{"Passport","Aadhar Card","Pan Card","Voter ID"});
//        comboid.setBounds(220,90,150,25) ;
//        comboid.setBackground(Color.white);
//        add(comboid);
//
//        JLabel lblnumber = new JLabel("UserId");
//        lblnumber.setBounds(30,130,150,25);
//        add(lblnumber);
//
//        tfnumber = new JTextField() ;
//        tfnumber.setBounds(220,130,150,25);
//        add(tfnumber);
//
//        lblname = new JLabel("Name");
//        lblname.setBounds(30,170,150,25);
//        add(lblname);
//
//
//        lblgender = new JLabel("Gender");
//        lblgender.setBounds(30,210,150,25);
//        add(lblgender);
//
////         tfname = new JTextField();
////         tfname.setBounds(220,170,150,25);
////         add(tfname);
//
//        rmale = new JRadioButton("Male");
//        rmale.setBounds(220,210,70,25);
//        rmale.setBackground(Color.white);
//        add(rmale);
//
//        rfemale = new JRadioButton("Female");
//        rfemale.setBounds(300,210,70,25);
//        rfemale.setBackground(Color.white);
//        add(rfemale);
//
//        ButtonGroup bg = new ButtonGroup();
//        bg.add(rmale);
//        bg.add(rfemale);
//
//        lblcountry = new JLabel("Country");
//        lblcountry.setBounds(30,250,150,25);
//        add(lblcountry);
//
//        tfcountry = new JTextField();
//        tfcountry.setBounds(220,250,150,25);
//        add(tfcountry);
//
//        lbladdress = new JLabel("Address");
//        lbladdress.setBounds(30,290,150,25);
//        add(lbladdress);
//
//        tfaddress = new JTextField();
//        tfaddress.setBounds(220,290,150,25);
//        add(tfaddress);
//
//        lblphone = new JLabel("Phone Number");
//        lblphone.setBounds(30,330,150,25);
//        add(lblphone);
//
//        tfphone = new JTextField();

//        tfphone.setBounds(220,330,150,25);
//        add(tfphone);
//
//        lblemail = new JLabel("Email ");
//        lblemail.setBounds(30,370,150,25);
//        add(lblemail);
//
//        tfemail = new JTextField();
//        tfemail.setBounds(220,370,150,25);
//        add(tfemail);
//
//        add = new JButton("Add");
//        add.setForeground(Color.white);
//        add.setBackground(Color.gray);
//        add.setBounds(70,430,100,25);
//        add.addActionListener(this);
//        add(add);
//
//
//        back = new JButton("Back");
//        back.setForeground(Color.white);
//        back.setBackground(Color.gray);
//        back.setBounds(200,430,100,25);
//        back.addActionListener(this);
//        add(back);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(400,40,400,500);
//        add(image);
//
//
//        setVisible(true);
//
//        try {
//            Conn c = new Conn();
//            ResultSet rs = c.s.executeQuery("Select * from username ");
//
//            while (rs.next()){
//                lblusername.setText(rs.getString("username"));
//                lblname.setText(rs.getString("name"));
//
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//    }
//
//
//    public static void main(String[] args) {
//        new AddCustomer();
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent  ae) {
//        if(ae.getSource()==add){
//            String username=lblusername.getText();
//            String id = tfid.getText();
//            String number = tfnumber.getText();
//            String name = lblname.getText();
//            String gender = null;
//            if (rmale.isSelected()){
//                gender = "Male";
//            }else{
//                gender ="Female";
//            }
//            String country = tfcountry.getText();
//            String address = tfaddress.getText();
//            String phone = tfphone.getText();
//            String email = tfemail.getText();
//            try {
//                Conn c = new Conn();
//                ResultSet rs = c.s.executeQuery("");
//                while(rs.next()){
//                    lblusername.setText(rs.getString("username"));
//                    lblname.setText(rs.getString("name"));
//                    tfid.setText(rs.getString("id"));
//                    tfnumber.setText(rs.getString("number"));
//                    tfgender.setText(rs.getString("name"));
//                    lblname.setText(rs.getString("name"));
//                    lblname.setText(rs.getString("name"));
//                }
//                JOptionPane.showMessageDialog(null,"Customer details added Successfully");
//                setVisible(false);
//            }catch (Exception e ){
//                e.printStackTrace();
//            }
//
//        }else{
//            setVisible(false);
//
//        }
//
//    }
//}
