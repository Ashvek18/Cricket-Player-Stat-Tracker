import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Middlepage {

    JLabel l1;
    JButton b1,b2,b3;
    Middlepage(String Ax,String role){
        JFrame f=new JFrame();
        f.setTitle("modify");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.black);

        l1=new JLabel("TO MAKE CHANGES TO YOUR RECORD SELECT ANY ONE OPTION");
        b1=new JButton("ADD RECORD");
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(role.equals("Bowler"))
                    new Bowling();
                else if(role.equals("Batsman"))
                    new Batting(Ax);
                else
                {
                    new Bowling();
                    new Batting(Ax);
                }
            }
        });
        b2=new JButton("VIEW OLD RECORD");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Displaybat();

            }
        });
        //b3=new JButton("MODIFY RECORD");
        b3=new JButton("EXIT");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        l1.setBounds(400,20,1000,40);
        b1.setBounds(650,120,200,60);
        b2.setBounds(650,220,200,60);
        b3.setBounds(650,320,200,60);
        // b4.setBounds(650,420,200,60);

        l1.setFont(new Font("Arial",Font.BOLD,24));

        l1.setForeground(Color.WHITE);
        f.add(l1);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        // f.add(b4);

        f.setSize(1920,1080);
        f.setLayout(null);
        f.setVisible(true);

    }
    public static void main(String[] args) {
        new Middlepage("ashvek", "roles");
    }

}
