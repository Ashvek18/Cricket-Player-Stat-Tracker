import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Signup extends JFrame {
    JLabel l,l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5;
    JRadioButton r1,r2,r3;
    JButton b1,b2;
    ButtonGroup g1;

    Signup() {
        super("Signup Page");
        setSize(1920,1080);


        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l = new JLabel("Sign Up Details ");
        l1 = new JLabel("First Name :");
        l2 = new JLabel("Last Name :");
        l3 = new JLabel("Email :");
        l4 = new JLabel("Role :");
        l5 = new JLabel("Create Username :");
        l6 = new JLabel("Create Password :");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        r1=new JRadioButton("Batsman",true);
        r2=new JRadioButton("Bowler",false);
        r3=new JRadioButton("Allrounder",false);
        g1=new ButtonGroup();

        l.setBounds(700,5,300,30);
        t1.setBounds(800,60,250,30);
        t2.setBounds(800,120,250,30);
        t3.setBounds(800,180,250,30);
        t4.setBounds(800,300,250,30);
        t5.setBounds(800,360,250,30);
        b1=new JButton("ADD");
        b2=new JButton("EXIT");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        l1.setBounds(550,60,150,30);
        l2.setBounds(550,120,200,30);
        l3.setBounds(550,180,200,30);
        l4.setBounds(550,240,300,30);
        l5.setBounds(550,300,200,30);
        l6.setBounds(550,360,200,30);
        r1.setBounds(800,240,100,50);
        r2.setBounds(900,240,100,50);
        r3.setBounds(1000,240,120,50);

        l.setFont(new Font("Arial",Font.BOLD,22));
        l1.setFont(new Font("Arial",Font.PLAIN,24));
        l2.setFont(new Font("Arial",Font.PLAIN,24));
        l3.setFont(new Font("Arial",Font.PLAIN,24));
        l4.setFont(new Font("Arial",Font.PLAIN,24));
        l5.setFont(new Font("Arial",Font.PLAIN,24));
        l6.setFont(new Font("Arial",Font.PLAIN,24));
        b1.setBounds(570,600,100,60);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String role="";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String urll="jdbc:mysql://localhost:3306/test";
                    Connection conn=DriverManager.getConnection(urll,"root","");
                    Statement stm=conn.createStatement();
                    if(r1.isSelected()) {
                        role = r1.getText();
                        stm.executeUpdate("INSERT INTO `testbat` (`username`, `Matches`, `Run`, `Avg`, `SR`, `BF`) VALUES ('"+t4.getText()+"', '0', '0', '0', '0', '0')");
                    }
                    else if(r2.isSelected())
                        role=r2.getText();
                    else if(r3.isSelected())
                        role=r3.getText();

                    stm.executeUpdate("INSERT INTO `login` (`First Name`, `Last Name`, `Email`, `Role`, `Username`, `Password`) VALUES('"+t1.getText()+"', '"+t2.getText()+"', '"+t3.getText()+"', '"+role+"', '"+t4.getText()+"', '"+t5.getText()+"');");
                }catch(Exception ex){
                    System.out.print(ex);
                }
                new Login();

                dispose();
            }
        });
        b2.setBounds(870,600,100,60);

        r1.setFont(new Font("Arial",Font.PLAIN,20));
        r2.setFont(new Font("Arial",Font.PLAIN,20));
        r3.setFont(new Font("Arial",Font.PLAIN,20));

        add(l);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(r1);
        add(r2);
        add(r3);
        add(b1);
        add(b2);
        g1.add(r1);
        g1.add(r2);
        g1.add(r3);

        setLayout(null);
        setVisible(true);
    }
}
