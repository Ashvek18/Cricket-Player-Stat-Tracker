import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Batting extends JFrame {
    JLabel l,l1,l2,l3,l4;
    JTextField t1,t2;
    JRadioButton c1,c2;
    JButton b1,b2;
    ButtonGroup g1,g2;

    Batting(String ax)
    {
        super("Batting Details");

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l=new JLabel("Batting Details ");
    //    l1=new JLabel("Format : ");
        l2=new JLabel("Runs Scored : ");
        l3=new JLabel("Balls Faced : ");
        l4=new JLabel("Did you remained not out? :");

//        r1=new JRadioButton("T20",false);
//        r2=new JRadioButton("ODI",false);
//        r3=new JRadioButton("TEST",false);
        c1=new JRadioButton("YES",false);
        c2=new JRadioButton("NO",false);

        t1=new JTextField();
        t2=new JTextField();

        b1=new JButton("ADD");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String urll="jdbc:mysql://localhost:3306/test";
                    Connection conn= DriverManager.getConnection(urll,"root","");
                    Statement stm=conn.createStatement();
                    ResultSet rs=stm.executeQuery("SELECT * FROM `testbat` WHERE `username` LIKE '"+ax+"'");
                    while(rs.next()){
                        int mat=rs.getInt(2);
                        int run=rs.getInt(3);
                        float avg=rs.getFloat(4);
                        float sr=rs.getFloat(5);
                        int bf=rs.getInt(6);
                        mat++;
                        run+=Integer.parseInt(t1.getText());
                        bf+=Integer.parseInt(t2.getText());
                        sr=run*100/bf;
                        avg=run/mat;
                        stm.executeUpdate("INSERT INTO `testbat` (`username`, `Matches`, `Run`, `Avg`, `SR`, `BF`) VALUES ('"+ax+"', '"+mat+"', '"+run+"', '"+avg+"', '"+sr+"', '"+bf+"')");

                        //stm.executeUpdate("UPDATE `testbat` SET `username`='"+ax+"',`Matches`='"+mat+"',`Run`='"+run+"',`Avg`='"+avg+"',`SR`='"+sr+"',`BF`='"+bf+"' WHERE `username` likes'"+ax+"'");
                    }
                }catch(Exception ex){}
                dispose();
            }
        });
        b2=new JButton("EXIT");
//        g1=new ButtonGroup();
        g2=new ButtonGroup();


        l.setBounds(700,5,300,30);
      //  l1.setBounds(590,60,100,30);
        l2.setBounds(525,130,200,30);
        l3.setBounds(540,220,200,30);
        l4.setBounds(385,310,300,30);
//        r1.setBounds(700,50,100,50);
//        r2.setBounds(800,50,100,50);
//        r3.setBounds(900,50,120,50);
        t1.setBounds(715,130,300,40);
        t2.setBounds(715,220,300,40);
        c1.setBounds(700,310,100,50);
        c2.setBounds(800,310,100,50);


        l.setFont(new Font("Arial",Font.BOLD,22));
    //    l1.setFont(new Font("Arial",Font.PLAIN,24));
        l2.setFont(new Font("Arial",Font.PLAIN,24));
        l3.setFont(new Font("Arial",Font.PLAIN,24));
        l4.setFont(new Font("Arial",Font.PLAIN,24));
//        r1.setFont(new Font("Arial",Font.PLAIN,20));
//        r2.setFont(new Font("Arial",Font.PLAIN,20));
//        r3.setFont(new Font("Arial",Font.PLAIN,20));


        b1.setBounds(570,450,100,60);
        b2.setBounds(870,450,100,60);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(c1);
        add(c2);
        add(b1);
        add(b2);
        add(t2);
        add(t1);
        add(l);
       // add(l1);
        add(l2);
        add(l3);
        add(l4);
//        add(r1);
//        add(r2);
//        add(r3);
//        g1.add(r1);
//        g1.add(r2);
//        g1.add(r3);
        g2.add(c1);
        g2.add(c2);


        setSize(1920,1080);
        setLayout(null);
        setVisible(true);



    }
    public static void main(String[] args) {
        new Batting("ash");
    }
}
