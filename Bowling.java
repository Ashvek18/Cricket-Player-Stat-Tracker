import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Bowling {
    JLabel l1,l2,l3,l4,l5;
 //   JCheckBox cb1,cb2,cb3;
    JTextField t1,t2,t3;
    JButton b1,b2;
    Bowling(){
        JFrame f=new JFrame();
        f.setTitle("Bowling page");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1=new JLabel("BOWLING DETAILS");
       // l2=new JLabel("Format:");
        l3=new JLabel("Overs Bowled:");
        l4=new JLabel("Runs Conceeded:");
        l5=new JLabel("Wickets Taken:");
//        cb1=new JCheckBox("T20");
//        cb2=new JCheckBox("ODI");
//        cb3=new JCheckBox("TEST");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        b1=new JButton("ADD");
        b2=new JButton("EXIT");

        l1.setBounds(700,5,300,30);
     //   l2.setBounds(590,60,100,30);
        l3.setBounds(515,130,200,30);
        l4.setBounds(475,220,200,30);
        l5.setBounds(500,310,200,30);
//        cb1.setBounds(700,50,100,50);
//        cb2.setBounds(800,50,100,50);
//        cb3.setBounds(910,50,120,50);
        t1.setBounds(715,125,350,40);
        t2.setBounds(715,220,350,40);
        t3.setBounds(715,310,350,40);
        b1.setBounds(570,450,100,60);
        b2.setBounds(870,450,100,60);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        l1.setFont(new Font("Arial",Font.BOLD,22));
       // l2.setFont(new Font("Arial",Font.PLAIN,24));
        l3.setFont(new Font("Arial",Font.PLAIN,24));
        l4.setFont(new Font("Arial",Font.PLAIN,24));
        l5.setFont(new Font("Arial",Font.PLAIN,24));
//        cb1.setFont(new Font("Arial",Font.PLAIN,20));
//        cb2.setFont(new Font("Arial",Font.PLAIN,20));
//        cb3.setFont(new Font("Arial",Font.PLAIN,20));

        f.add(l1);
       // f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
//        f.add(cb1);
//        f.add(cb2);
//        f.add(cb3);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(b1);
        f.add(b2);

        f.setSize(1920,1080);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new Bowling();
    }
}
