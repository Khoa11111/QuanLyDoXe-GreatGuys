/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DangNhap;

import JDBCConnect.JDBCConnect;
import MainFormCode.MainFormCode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class DangNhap extends JFrame{
    
    JFrame frame = new JFrame();
    
    Connection conn;
    ResultSet rs;
    
    JTextField txtLogin;
    JPasswordField txtPassword;
    JButton btnLogin;
    JButton btnExit;
    
    public DangNhap(){
        
        // Connect to SQl Server 
        conn = JDBCConnect.getJDBCConnect();
        
        // create and set frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 300);
        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        
        panel1.setBackground(new Color(0x11a0bd));
        panel2.setBackground(new Color(0xfafafa));
        panel3.setBackground(new Color(0x11a0bd));
        
        panel1.setPreferredSize(new Dimension(100,70));
        panel2.setPreferredSize(new Dimension(100,370));
        panel3.setPreferredSize(new Dimension(100,30));
        
        panel2.setLayout(null);
        
        ImageIcon icon = new ImageIcon("IconDOXE/iconbx.png");
        
        JLabel label = new JLabel();
        label.setIcon(icon);
        label.setBounds(20, 20, 110, 110);
        
        JLabel label2 = new JLabel("Tên Đăng Nhập:");
        label2.setBounds(150,30,105,30);
        label2.setFont(new Font("San Serif",Font.BOLD,13));
        label2.setForeground(new Color(0x6dcde3));
        
        JLabel label3 = new JLabel("Mật Khẩu:");
        label3.setBounds(167,80,70,50);
        label3.setFont(new Font("San Serif",Font.BOLD,13));
        label3.setForeground(new Color(0x6dcde3));
        
        txtLogin = new JTextField();
        txtLogin.setBounds(260, 35, 170, 25);
        
        txtPassword = new JPasswordField();
        txtPassword.setBounds(260, 95, 170, 25);
        
        btnLogin = new JButton("Đăng Nhập");
        btnLogin.setBounds(150, 150, 100, 30);
        btnLogin.addActionListener(loginEvent);
        btnLogin.setFocusable(false);
        btnLogin.setForeground(new Color(0xf57842));
        btnLogin.setBackground(new Color(0xf5e642));
        
        btnExit = new JButton("Thoát");
        btnExit.setBounds(355, 150, 100, 30);
        btnExit.addActionListener(exitEvent);
        btnExit.setFocusable(false);
        btnExit.setForeground(new Color(0xf57842));
        btnExit.setBackground(new Color(0xf5e642));
          
        panel2.add(label);
        panel2.add(label2);
        panel2.add(label3);
        panel2.add(txtLogin);
        panel2.add(txtPassword);
        panel2.add(btnLogin);
        panel2.add(btnExit);
        
        frame.setTitle("Đăng Nhập Hệ Thống");
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        
        frame.setVisible(true);
    }

    ActionListener loginEvent = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(txtLogin.getText().equals("") & String.valueOf(txtPassword.getPassword()).equals("")){
                JOptionPane.showMessageDialog(btnLogin, "Ban chua nhap tai khoan va mat khau");
                return;
            }
            if(txtLogin.getText().equals("")){
                JOptionPane.showMessageDialog(btnLogin, "Ban chua nhap tai khoan");
                return;
            }
            if(String.valueOf(txtPassword.getPassword()).equals("")){
                JOptionPane.showMessageDialog(btnLogin, "Ban chua nhap mat khau");
                return;
            }
            // Checking for userName and password
                String sql = "select * from Account where userName=? and pass=?";
                PreparedStatement pstm;
            try {
                pstm = conn.prepareStatement(sql);
                pstm.setString(1,txtLogin.getText());
                pstm.setString(2,String.valueOf(txtPassword.getPassword()));
                rs = pstm.executeQuery();
                
                if(rs.next()){
                    JOptionPane.showMessageDialog(btnLogin, "Ban da dang nhap  thanh cong");
                    frame.dispose();
                    MainFormCode mainFormCode = new MainFormCode();
                    mainFormCode.getMainFormCodeFrame();
                }
                else{
                    JOptionPane.showMessageDialog(btnLogin, "Ban da dang nhap that bai");
                    return ;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    
    ActionListener exitEvent =  new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           System.exit(0);
        }
    };
    
}