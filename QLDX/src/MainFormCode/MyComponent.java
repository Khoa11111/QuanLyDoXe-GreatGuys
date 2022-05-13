/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFormCode;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class MyComponent {
    
    public void setMyTabbedPane(JTabbedPane tbp){
        tbp.setBounds(200, 55, 705, 502);
    }

    public void setPanelTabbed(JPanel p){
        p.setBounds(0, 0, 0,0);
        p.setLayout(null);
        p.setBackground(Color.white);
    }
    
    public void setPanel1(JPanel p){
        p.setBounds(0, 0, 905,90);
        p.setBackground(new Color(0x11a0bd));
    }
    
    public void setPanel2(JPanel p){
        p.setBounds(0, 90, 400,467);
        p.setBackground(new Color(0x11a0bd));
    }
    
    public void setLabel(JLabel lb,int x,int y){
        lb.setBounds(x, y, 100, 20);
        lb.setFont(new Font("San Serif",Font.BOLD,13));
        lb.setForeground(Color.red);
    }
    
    public void setTextField(JTextField txt,int  x, int y){
        txt.setBounds(x, y, 150, 20);
    }
    
    public void setComboBox(JComboBox cbx,int x, int y){
        cbx.setBounds(x,y,150,20);
    }

}
