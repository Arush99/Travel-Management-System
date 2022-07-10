import javax.swing.*;
import java.awt.*;

public class Loading  extends JFrame implements  Runnable{
    Thread t;
    JProgressBar bar;
    String Customer;

    public  void  run(){
        try{
            for(int i=1;i<=101;i++){
                int max= bar.getMaximum(); //100
                int value=bar.getValue();

                if(value<max){
                    bar.setValue(bar.getValue() + 1);
                }else{
                    setVisible(false);
                    // new class object
                }
                Thread.sleep(10);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    Loading(String Customer){
        this.Customer=Customer;
        t=new Thread(this);

        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel text=new JLabel("Travel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);

        bar=new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);


        JLabel loading=new JLabel("Loading, please wait....");
        loading.setBounds(230,130,180,30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway",Font.BOLD,16));
        add(loading);

        JLabel username=new JLabel("Welcome "+ Customer );
        username.setBounds(20,310,400,40);
        username.setForeground(Color.RED);
        username.setFont(new Font("Raleway",Font.BOLD,16));
        add(username);

        t.start();
        setVisible(true);
    }

    public static void main(String[] args)  {
        new Loading(" ");
        new Dashboard("").setVisible(true);

    }
}
