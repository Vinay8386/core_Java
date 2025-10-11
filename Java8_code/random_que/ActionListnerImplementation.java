package Java8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListnerImplementation {
    public static void main(String[] args) {
        //Implementation without Lambda expression
        JButton show=new JButton("Click here");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expressions");
            }
        });

        /*//Implementation with Lambda expression
        JButton show=new JButton("Click here");
        show.addActionListener(e -> System.out.println("Event handling without lambda expressions"));*/
    }
}
