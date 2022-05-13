/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFormCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class MainFormCode {
    
    JFrame frame = new JFrame();
    MyComponent component  = new MyComponent();
    DefaultTableModel tdm;
    MyTable tb;
    JTextField txtMaNV,txtTenNV,txtNgaySinh,txtDiaChi,txtSDT,txtMK;
    
    public void  getMainFormCodeFrame(){
        // create panel
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panelTaiKhoan = new JPanel();
        JPanel panelQuanLy = new JPanel();
 
        // create label
        JLabel labelMaNV,labelTenNV,labelNgaySinh,labelGT,labelLoaiNV,labelDiaChi
                ,labelSDT,labelMK;
        labelMaNV = new JLabel("Mã Nhân Viên");
        labelTenNV = new JLabel("Tên Nhân Viên");
        labelNgaySinh = new JLabel("Ngày Sinh");
        labelGT = new JLabel("Giới Tính");
        labelLoaiNV = new JLabel("Loai Nhân Viên");
        labelDiaChi = new JLabel("Địa Chỉ");
        labelSDT = new JLabel("Số Điện Thoại");
        labelMK = new JLabel("Mật Khẩu");
        
        // create textfield
        txtMaNV = new JTextField();
        txtTenNV = new JTextField();
        txtNgaySinh = new JTextField();
        txtDiaChi = new JTextField();
        txtSDT = new JTextField();
        txtMK = new JTextField();
        
        JTextField txtTK_MaNV = new JTextField();
        
        // create button
        JButton btnTK_MaNV = new JButton("Tìm Theo Mã");
        JButton btnThem = new JButton("Thêm");
        JButton btnXoa = new JButton("Xóa");
        JButton btnHienDS = new JButton("Hiện Danh Sách");
        JButton btnTDTT = new JButton("Sửa Thông Tin");
        
        // create combobox
        JComboBox cbxGT,cbxLoaiNV;
        cbxGT = new JComboBox();
        cbxLoaiNV = new JComboBox();
        
        // create table
        JTable tableTK = new JTable();
        
        // create TabbedPane
        JTabbedPane tabpane = new JTabbedPane();

        // set up label
        component.setLabel(labelMaNV, 40, 20);
        component.setLabel(labelTenNV, 40, 60);
        component.setLabel(labelNgaySinh, 40, 100);
        component.setLabel(labelGT, 40, 140);
        component.setLabel(labelLoaiNV, 400, 20);
        component.setLabel(labelDiaChi, 400, 60);
        component.setLabel(labelSDT, 400, 100);
        component.setLabel(labelMK, 400, 140);
        
        // set up textField
        component.setTextField(txtMaNV, 160, 20);
        component.setTextField(txtTenNV, 160, 60);
        component.setTextField(txtNgaySinh, 160, 100);
        component.setTextField(txtDiaChi, 520, 60);
        component.setTextField(txtSDT, 520, 100);
        component.setTextField(txtMK, 520, 140);
        
        component.setTextField(txtTK_MaNV, 10, 200);
        
        // set up button
        component.setButton(btnTK_MaNV, 170, 200,117,20);
        component.setButton(btnThem, 310, 200, 70, 20);
        component.setButton(btnXoa, 385, 200, 70, 20);
        component.setButton(btnTDTT,460, 200, 128, 20);
        component.setButton(btnHienDS,604, 200, 140, 20);
        
        
        // set up comboBox
        component.setComboBox(cbxGT, 160, 140);
        component.setComboBox(cbxLoaiNV, 520, 20);
        
        //set up panel
        component.setPanel1(panel);
        component.setPanel2(panel2);
        component.setPanelTabbed(panelTaiKhoan);         
        component.setPanelTabbed(panelQuanLy);
        
        // set up TabbedPane
        component.setMyTabbedPane(tabpane);
        Font font = new Font("Open Sans",Font.CENTER_BASELINE,25);
        tabpane.setFont(font);
        tabpane.setForeground(new Color(0xfc037b));
        
        // add items to cbxGT
        cbxGT.addItem("Nam");
        cbxGT.addItem("Nữ");
        
        //set up table
        JScrollPane sp = new JScrollPane(tableTK);
        sp.setBounds(10, 230, 735, 220);
        
        // add column to tableTK
        tdm = (DefaultTableModel) tableTK.getModel();
        tdm.addColumn("Mã NV");
        tdm.addColumn("Tên NV");
        tdm.addColumn("Ngày Sinh");
        tdm.addColumn("Giới Tính");
        tdm.addColumn("Loại NV");
        tdm.addColumn("Địa Chỉ");
        tdm.addColumn("SDT");
        tdm.addColumn("Mật Khẩu");
        
        //add data from sql to tableTK
        tb = new MyTable();
        tb.getTableDangNhap(tableTK);
        
                
        // add component to panelTaiKhoan
        panelTaiKhoan.add(labelMaNV);
        panelTaiKhoan.add(labelTenNV);
        panelTaiKhoan.add(labelNgaySinh);
        panelTaiKhoan.add(labelGT);
        panelTaiKhoan.add(labelLoaiNV);
        panelTaiKhoan.add(labelDiaChi);
        panelTaiKhoan.add(labelSDT);
        panelTaiKhoan.add(labelMK);
        panelTaiKhoan.add(txtMaNV);
        panelTaiKhoan.add(txtTenNV);
        panelTaiKhoan.add(txtNgaySinh);
        panelTaiKhoan.add(txtDiaChi);
        panelTaiKhoan.add(txtSDT);
        panelTaiKhoan.add(txtMK);
        panelTaiKhoan.add(cbxGT);
        panelTaiKhoan.add(cbxLoaiNV);
        panelTaiKhoan.add(sp);
        panelTaiKhoan.add(txtTK_MaNV);
        panelTaiKhoan.add(btnTK_MaNV);
        panelTaiKhoan.add(btnThem);
        panelTaiKhoan.add(btnXoa);
        panelTaiKhoan.add(btnHienDS);
        panelTaiKhoan.add(btnTDTT);
        
        // add panel to tabbedpane
        tabpane.addTab("Tai Khoan",panelTaiKhoan);
        tabpane.addTab("Quan Ly", panelQuanLy);
        
        // add component to frame
        frame.add(tabpane);
        frame.add(panel);
        frame.add(panel2);
        
        // Display the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(923, 610);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        
        // set event for TabbedPane
        ChangeListener changeListener = new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
                int index = sourceTabbedPane.getSelectedIndex();
                tabpane.setBackground(Color.LIGHT_GRAY);
            }
        };
        
        // set event for button btnTK_MaNV
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnTK_MaNV){
                    tb.getTableDangNhap_MaNV(tableTK,txtTK_MaNV);
                }
            }
        };
        btnTK_MaNV.addActionListener(actionListener);
    }
    public static void main(String[] args) {
        MainFormCode mainFormCode = new MainFormCode();
        mainFormCode.getMainFormCodeFrame();
    }
}
