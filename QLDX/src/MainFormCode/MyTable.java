/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFormCode;

import JDBCConnect.JDBCConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class MyTable {
    Connection conn = null;
    ResultSet rs;
    int q,i;
    
    public void getTableDangNhap(JTable tb){
        conn = JDBCConnect.getJDBCConnect();
        String sql = "select maNV,tenNV,ngaysinh,gioitinh,loaiNV,diachi,SDT,matkhauNV from NhanVien";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            q = stData.getColumnCount();
            DefaultTableModel model = (DefaultTableModel) tb.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                Vector columnData = new Vector();
                for (i=1; i<=q; i++){
                    columnData.add(rs.getString("maNV"));
                    columnData.add(rs.getString("tenNV"));
                    columnData.add(rs.getDate("ngaysinh"));
                    columnData.add(rs.getString("gioitinh"));
                    columnData.add(rs.getString("loaiNV"));
                    columnData.add(rs.getString("diachi"));
                    columnData.add(rs.getString("SDT"));
                    columnData.add(rs.getString("matkhauNV"));
                }
                model.addRow(columnData);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MyTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getTableDangNhap_MaNV(JTable tb,JTextField txt){
        conn = JDBCConnect.getJDBCConnect();
        String sql = "select * from NhanVien where maNV=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, txt.getText());
            rs = pstm.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            q = stData.getColumnCount();
            DefaultTableModel model = (DefaultTableModel) tb.getModel();
            model.setRowCount(0);

            while(rs.next()){
                Vector columnData = new Vector();
                for (i=1; i<=q; i++){
                    columnData.add(rs.getString("maNV"));
                    columnData.add(rs.getString("tenNV"));
                    columnData.add(rs.getDate("ngaysinh"));
                    columnData.add(rs.getString("gioitinh"));
                    columnData.add(rs.getString("loaiNV"));
                    columnData.add(rs.getString("diachi"));
                    columnData.add(rs.getString("SDT"));
                    columnData.add(rs.getString("matkhauNV"));
                }
                model.addRow(columnData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
