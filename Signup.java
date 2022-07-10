import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {
    JButton create,back;
    JTextField tfusername,tfname,tfpassword ,tfsecurity, tfanswer;
    Choice security;
    JLabel j1;


    Signup () {
        j1 = new JLabel();
        j1.setText("Signup");
        add(j1);
        setVisible(true);
        setBounds(300, 200, 900, 360);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel pl = new JPanel();
        pl.setBackground(new Color(133, 193, 233));
        pl.setBounds(0, 0, 500, 400);
        pl.setLayout(null);
        add(pl);

        JLabel lblusername = new JLabel("username");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblusername.setBounds(50, 20, 125, 25);
        pl.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(190, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfusername);

        JLabel lblname = new JLabel("name");
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblname.setBounds(50, 60, 125, 25);
        pl.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfname);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblpassword.setBounds(50, 100, 125, 25);
        pl.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(190, 100, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfpassword);

        JLabel lblsecurity= new JLabel("Security Question");
        lblsecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblsecurity.setBounds(50, 140, 125, 25);
        pl.add(lblsecurity);

        tfsecurity = new JTextField();
        tfsecurity.setBounds(190, 140, 180, 25);
        tfsecurity.setBorder(BorderFactory.createEmptyBorder());
       pl.add(tfsecurity);


        security = new Choice();
        security.add("Fav Cartoon Character");
        security.add("Fav Avenger");
        security.add("Your fav colour");
        security.setBounds(190, 140, 180, 25);
       pl.add(security);



        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblanswer.setBounds(50, 180, 125, 25);
        pl.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(190, 180, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfanswer);

         create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setBackground(new Color(133, 193, 233));
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBounds(80, 250, 100, 30);
        create.addActionListener(this);
        pl.add(create);

         back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setBackground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back .setBounds(250, 250, 100, 30);
        back.addActionListener(this);
        pl.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 200);
        add(image);

        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==create){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
              String question = security.getSelectedItem();
              String answer = tfanswer.getText();
              String query = " insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
              try{
                 Conn c = new Conn();
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Account created Successfully");
                 setVisible(false);
                 new Login();

              }catch (Exception ae){
                  ae.printStackTrace();

              }

        }else if(e.getSource()==back){
            setVisible(false);

        }

    }

    public static void main(String[] args) {
        new Signup();
    }


}

