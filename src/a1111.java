

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class a1111 extends JFrame{
    private Container cp;
    private JPanel jpn = new JPanel(new GridLayout(4,3,3,3));
    private JButton jbtns[] = new JButton[12];
    private String btnLabel[] =new String[10];
    private JLabel jlb = new JLabel("10");
    private Font fnt = new Font(null,Font.BOLD,18);


    public a1111 (){
        initComp();
    }

    private void initComp(){
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(50,50,300,400);
        cp.add(jpn,BorderLayout.CENTER);
        genJbtnLabrl(btnLabel);
        cp.add(jlb,BorderLayout.NORTH);
        for (int i=0;i<10;i++){
            jbtns[i] = new JButton(btnLabel[i]);
            jbtns[i].setFont(fnt);
            jpn.add(jbtns[i]);
            jbtns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton jbtn = (JButton) e.getSource();
                    jlb.setText(jlb.getText()+jbtn.getText());
                }

            });

        }


        jbtns[10] = new JButton("Reflash");
        jbtns[11] = new JButton("Exit");
        jpn.add(jbtns[10]);
        jpn.add(jbtns[11]);
//        cp.isVisible();
        jbtns[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String str = new String(jpwf.getPassword());
//                jpwf.setText(str.substring(0,str.length()-1));
            }
        });
        jbtns[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // login.setPWF(new string(jpwf.getPassword()));
                // RandomKeyboard.this.setVisible(false);


            }
        });
        jpn.add(jbtns[10]);
        jpn.add(jbtns[11]);
    }

    private void genJbtnLabrl(String btnLabel[]){
        int i=0;
        Random rnd = new Random(System.currentTimeMillis());
        while (i<10){
            btnLabel[i] = Integer.toString(rnd.nextInt(10));
            int j = 0;
            boolean flag = false;
            while (j<i){
                if (btnLabel[i].equals(btnLabel[j])){
                    flag = true;
                    j = i;
                }
                j++;
            }
            if (!flag){
                i++;
            }
        }
    }
}