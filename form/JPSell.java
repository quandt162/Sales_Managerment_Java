/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import entity.ChiTietHD;
import entity.HoaDon;
//import java.awt.Font;
//import java.awt.HeadlessException;
//import java.awt.LayoutManager;
//import java.awt.List;
//import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.FocusEvent;
//import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.math.BigDecimal;
//import java.nio.charset.StandardCharsets;
//import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
//import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
//import javafx.print.Printer;
//import javax.swing.ImageIcon;
//import javax.swing.InputVerifier;
//import javax.swing.JComponent;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
//import javax.swing.JTextField;
//import javax.swing.event.TableModelEvent;
//import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
//import javax.swing.table.JTableHeader;
//import javax.swing.table.TableColumnModel;

/**
 *
 * @author Love Jav
 */

public class JPSell extends javax.swing.JPanel{

    /**
     * Creates new form jpSell
     */
    Connection conn = null;
    PreparedStatement stmt =null;
    ResultSet rs =null;
       
    DefaultTableModel dtm = new DefaultTableModel(); 
   public JPSell() throws SQLException {
        initComponents();
//        Manager_CN mng = new Manager_CN(null, null);
//        String tennv = mng.getTenNV();
//        System.out.println("Ten nv = " + tennv);
        txtThanhToan.setText("0.0");
        lbSoDu.setText("0.0");
        txtTimKiem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        jPanel3.setOpaque(false);
        jPanel4.setOpaque(false);
        
        
        Vector v = new Vector();
        v.add("Mã Sản Phẩm");v.add("Tên Sản Phẩm");
        v.add("Giá");v.add("Đơn Vị");
        v.add("Số Lượng");v.add("Thành Tiền");
        
        tblSell2.setModel(dtm);
        dtm.setColumnIdentifiers(v);
        tblSell1.getTableHeader().setReorderingAllowed(false);
        tblSell2.getTableHeader().setReorderingAllowed(false);
        tblSell1.getTableHeader().setResizingAllowed(false);
        tblSell2.getTableHeader().setResizingAllowed(false);
                
        //tblSell2.setColumnSelectionAllowed(false);
        //tblSell2.enable(true);
        txtGiaDinh.setVisible(false);
        this.setOpaque(false); 
        
        try{
            conn = ConnectionDB.connectionDB.getConnection();
            ShowProduct();
            ShowComboBox1();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
   public boolean textChange(){
       String text = txtTimKiem.getText().trim();
       int textSize = text.length();
       
       return false;
   }
   public void ShowProduct(){
        Vector cols = new Vector();
        cols.addElement("Mã Sản Phẩm");
        cols.addElement("Tên Sản Phẩm");
        cols.addElement("Giá");
        cols.addElement("Đơn Vị Tiền");
        Vector rows = new Vector();
        String selectR = "SELECT * FROM HANGHOA";
        try{
            stmt = conn.prepareStatement(selectR);
            rs = stmt.executeQuery();
            while(rs.next()){
                Vector data = new Vector();
                
                data.addElement(rs.getString("MASP"));
                data.addElement(rs.getString("TenSP"));
                data.addElement(rs.getDouble("GiaBan"));
                data.addElement(rs.getString("DonViTinh"));
                
                rows.add(data);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        tblSell1.setModel(new DefaultTableModel(rows,cols));
    }
     public void ShowComboBox1(){
        String sql = "Select TenDM from DanhMuc";
        
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                String tenDM = rs.getString("TenDM");
                cbox1.addItem(tenDM);
            }         
           // System.out.println("List" + listDM.get(1));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            
        }
    }
    // check input
//    public boolean verify(JComponent input) {
//       String text = ((JTextField) input).getText();
//       try {
//          Double.parseDouble(text);
//       } catch (NumberFormatException e) {
//          return false;
//       }
//       return true;
//    }
//    public static int hex2decimal(String s) {
//            String digits = "0123456789ABCDEF";
//            s = s.toUpperCase();
//            int val = 0;
//            for (int i = 0; i < s.length(); i++) {
//                char c = s.charAt(i);
//                int d = digits.indexOf(c);
//                val = 16*val + d;
//             }
//        return val;
//    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton9 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSell2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSell1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbMaHD = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        txtTenKh = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jNhanVien = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbConNo = new javax.swing.JLabel();
        txtThanhToan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbSoDu = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        cbox1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtGiaDinh = new javax.swing.JTextField();
        cbGiaDinh = new javax.swing.JComboBox();
        jButton10 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1226, 796));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton9.setText("Tạo Hóa Đơn Mới");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, 30));

        jButton1.setText(">>>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 60, -1));

        jButton2.setText("<<<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 60, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 51), new java.awt.Color(255, 255, 0), null, new java.awt.Color(255, 204, 51)));

        tblSell2.setBackground(new java.awt.Color(255, 255, 153));
        tblSell2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSell2.setEditingRow(1);
        jScrollPane2.setViewportView(tblSell2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 660, 390));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 51), new java.awt.Color(255, 204, 0), null, new java.awt.Color(255, 204, 0)));

        tblSell1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblSell1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 460, 540));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), null, null, new java.awt.Color(0, 153, 153)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Tên Khách Hàng:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Địa Chỉ                 :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Số Lượng            :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Số Điện Thoại     :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Mã Hóa Đơn       :");

        lbMaHD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });
        txtDiaChi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDiaChiKeyPressed(evt);
            }
        });

        txtTenKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhActionPerformed(evt);
            }
        });
        txtTenKh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTenKhKeyPressed(evt);
            }
        });

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSDTKeyPressed(evt);
            }
        });

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });
        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyPressed(evt);
            }
        });

        jButton8.setText("OK");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addComponent(txtTenKh, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(lbMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, 660, 140));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), null, null, new java.awt.Color(0, 204, 204)));

        jButton5.setText("In Hóa Đơn");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("In CSV");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("Sản Phẩm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Lưu ");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jNhanVien.setText("Hóa Đơn");
        jNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNhanVien)
                .addGap(4, 4, 4)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jNhanVien))
                .addGap(34, 34, 34))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 470, 50));

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), null, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)), "Thanh Toán"));

        jLabel10.setText("Tổng Tiền           :");

        jLabel12.setText("Đã Thanh Toán  :");

        jLabel13.setText("Còn Nợ                :");

        txtThanhToan.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtThanhToanCaretUpdate(evt);
            }
        });
        txtThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtThanhToanMouseClicked(evt);
            }
        });
        txtThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhToanActionPerformed(evt);
            }
        });
        txtThanhToan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtThanhToanKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtThanhToanKeyTyped(evt);
            }
        });

        jLabel4.setText("VNĐ");

        jLabel11.setText("VNĐ");

        jLabel14.setText("VNĐ");

        jLabel15.setText("Số Dư                  : ");

        jLabel16.setText("VNĐ");

        lbSoDu.setText("  ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTongTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(lbConNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSoDu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtThanhToan))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16))
                .addGap(77, 77, 77))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbSoDu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbConNo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 610, 360, 170));

        jButton3.setText("Tìm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 90, 30));

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });
        add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 218, 30));

        cbox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbox1ItemStateChanged(evt);
            }
        });
        cbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox1ActionPerformed(evt);
            }
        });
        add(cbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Gia Đình              :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 102, 31));

        txtGiaDinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaDinhActionPerformed(evt);
            }
        });
        txtGiaDinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGiaDinhKeyPressed(evt);
            }
        });
        add(txtGiaDinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 110, 32));

        cbGiaDinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cbGiaDinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 110, 30));

        jButton10.setText("Thêm");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, -1, 30));
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1226, 796));
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setVisible(false);
        txtSoLuong.setText("");
        String CodeHD = genCodeHD();
        lbMaHD.setText(CodeHD);
        
        int r = tblSell1.getSelectedRow();
        Vector rows = new Vector();
        if(r != -1){
            Vector data = new Vector();
            data.addElement(tblSell1.getValueAt(r, 0));
            data.addElement(tblSell1.getValueAt(r, 1));
            data.addElement(tblSell1.getValueAt(r, 2));
            data.addElement(tblSell1.getValueAt(r, 3));
            dtm.addRow(data);
        }
        txtSoLuong.requestFocus();    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Tạo Hóa Đơn Mới?", "Hóa Đơn Mới", 1, 1, null);
        if(i  == JOptionPane.YES_OPTION){
            DefaultTableModel model = (DefaultTableModel) tblSell2.getModel();
            while(model.getRowCount() > 0){
                model.removeRow(0);
                lbMaHD.setText("");lbTongTien.setText("");lbConNo.setText("");
                txtTenKh.setText("");txtSDT.setText("");txtDiaChi.setText("");txtSoLuong.setText("");txtThanhToan.setText("");
            }
        }
        jButton1.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed


        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            MessageFormat[] header = new MessageFormat[13];
            int i = 0;
            header[i++] = new MessageFormat("");
            header[i++] = new MessageFormat("                                                                     Cửa Hàng Vật Liệu Xây Dựng MIẾN NHẮC");
            header[i++] = new MessageFormat("                                                                     Địa Chỉ : Số 1 - Quảng Bị - Chương Mỹ");
            header[i++] = new MessageFormat("                                                                     Số Điện Thoại: 096 85645 488");
            header[i++] = new MessageFormat("");
            header[i++] = new MessageFormat("                                                        HÓA ĐƠN BÁN HÀNG");
            header[i++] = new MessageFormat("");
            header[i++] = new MessageFormat("                                                     Ngày       Tháng       Năm");
            header[i++] = new MessageFormat("");
            header[i++] = new MessageFormat("Mã Hóa Đơn    :    " + lbMaHD.getText().trim());
            header[i++] = new MessageFormat("Khách Hàng    :    " + txtTenKh.getText().trim());
            header[i++] = new MessageFormat("Số Điện Thoại :    " + txtSDT.getText().trim());
            header[i++] = new MessageFormat("Địa Chỉ            :    " + txtDiaChi.getText().trim());
            
            MessageFormat[] footer = new MessageFormat[13];
            int j =0 ;

            footer[j++] = new MessageFormat("");
            footer[j++] = new MessageFormat(""
            + "                                                                                                   Số Lượng          :    ");
            footer[j++] = new MessageFormat("");
            footer[j++] = new MessageFormat(""
            + "                                                                                                   Tổng Tiền          :    " + lbTongTien.getText().trim() +"  vnđ");
            footer[j++] = new MessageFormat("");
            footer[j++] = new MessageFormat(""
            + "                                                                                                   Đã Thanh Toán :    " + txtThanhToan.getText().trim() +"  vnđ");
            footer[j++] = new MessageFormat("");
            footer[j++] = new MessageFormat(""
            + "                                                                                                   Còn Nợ              :    " + lbConNo.getText().trim() +"  vnđ");
            footer[j++] = new MessageFormat("");
            footer[j++] = new MessageFormat(""
            + "                                                                                                   Số Dư                :    " + lbSoDu.getText().trim() +"  vnđ");
            footer[j++] = new MessageFormat("");
            footer[j++] = new MessageFormat("");
            footer[j++] = new MessageFormat("           Khách Hàng"
            + "                                                                                                   Người Bán Hàng");
            
            job.setPrintable(new MyTablePrintable(tblSell2, PrintMode.FIT_WIDTH, header, footer));
            job.print();
            
         } catch (PrinterException ex) {
            ex.printStackTrace();
         }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        ShowProduct();
    }//GEN-LAST:event_jButton6ActionPerformed

    public String getTen(String id, String name,String table,String txtName){
        String ma = "select " + id + " from "+table+" where "+ name + " = ?";
        String key= "";
        try{
            stmt = conn.prepareStatement(ma);
            stmt.setString(1, txtName);
            rs = stmt.executeQuery();
            if(rs.next()){
                key = rs.getObject(1).toString();
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return key;
    }
    
    public boolean SaveKH(){
       String sql = "Insert into KhachHang(TenKH,SDT,DiaChi,DaTra,ConNo,sodu) values(?,?,?,?,?,?)";
       
       try{
           long conno = moneyFormat(lbConNo.getText().trim());
           long sodu  = moneyFormat(lbSoDu.getText().trim());
           stmt = conn.prepareStatement(sql);
           stmt.setString(1, txtTenKh.getText());
           stmt.setString(2, txtSDT.getText());
           stmt.setString(3, txtDiaChi.getText());
           stmt.setDouble(4, Double.parseDouble(txtThanhToan.getText()));
           stmt.setDouble(5, conno);
           stmt.setDouble(6, sodu);
           
           stmt.executeUpdate();
           return true;
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return false;
   }

    public boolean SaveHD() throws ParseException{
        String makh = getTen("MaKH","TenKH","KhachHang",txtTenKh.getText());
        System.out.println("MaKH: " + makh);
        String sql = "Insert into HoaDon(MaHD,MAKH,NgayLap,TongTien,Datra,ConNo,Sodu) values(?,?,?,?,?,?,?)";
        String date = genCodeDATE();
        long conno = moneyFormat(lbConNo.getText().trim());
        long sodu  = moneyFormat(lbSoDu.getText().trim());
        long tongtien = moneyFormat(lbTongTien.getText().trim());
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, lbMaHD.getText());
            stmt.setInt(2,Integer.parseInt(makh));
            stmt.setString(3, date);
            stmt.setDouble(4,tongtien);
            stmt.setDouble(5,(Double.parseDouble(txtThanhToan.getText())));
            stmt.setLong(6,conno);
            stmt.setLong(7,sodu);
            
            stmt.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean SaveCTHD() throws ParseException{
        String sql = "Insert into ChiTietHoaDon(MaHD,TenKH,MaSP,TenSP,SoLuong,GiaBan,ThanhTien,TongTien,DaTra,ConNo,SoDu)"
                + "                      values(?,?,?,?,?,?,?,?,?,?,?)";
        
        int rows = tblSell2.getRowCount();
        float soluong = Float.parseFloat(tblSell2.getValueAt(0, 4).toString());
        long tongtien = moneyFormat(lbTongTien.getText().trim());
        long conno = moneyFormat(lbConNo.getText().trim());
        long sodu  = moneyFormat(lbSoDu.getText().trim());
        
        try{
            stmt = conn.prepareStatement(sql);
            int i = 0;
            while(i <= rows -1){
                int k = 1;
                long unitprice = moneyFormat(tblSell2.getValueAt(i, 5).toString().trim());
                
                stmt.setString(k++,lbMaHD.getText());
                stmt.setString(k++, txtTenKh.getText());
                stmt.setString(k++,(String)tblSell2.getValueAt(i, 0));
                stmt.setString(k++, (String) tblSell2.getValueAt(i, 1));
                stmt.setFloat(k++,soluong);
                stmt.setDouble(k++,(Double)tblSell2.getValueAt(i, 2));
                stmt.setDouble(k++, unitprice);
                stmt.setDouble(k++, tongtien);
                stmt.setDouble(k++, Double.parseDouble(txtThanhToan.getText().toString()));
                stmt.setDouble(k++, conno);
                stmt.setDouble(k++, sodu);
                i++;
                stmt.executeUpdate();
            }
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return  false;
    }
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if("".equals(txtTenKh.getText().trim()) || txtTenKh.getText().trim() == null){
            JOptionPane.showMessageDialog(this, "Nhập Tên Khách Hàng","Nhập Tên",2);
            return;
        }
        if("".equals(lbTongTien.getText().trim()) || lbTongTien.getText().trim() == null){
            JOptionPane.showMessageDialog(this, "Chưa Có Sản Phẩm!!!","Thêm Sản Phẩm",2);
            return;
        }
        
        int rs = JOptionPane.showConfirmDialog(this, "Lưu Hóa Đơn Này?");
        if(rs == JOptionPane.YES_OPTION){
            try {
                if(SaveKH() == true && SaveHD() == true && SaveCTHD() == true){
                    JOptionPane.showMessageDialog(this, "Thành Công!!!");
                }else{
                    deleteCTHD(lbMaHD.getText().trim());
                    deleteKH(txtTenKh.getText().trim(), lbMaHD.getText().trim());
                    deleteHD(lbMaHD.getText().trim());
                    JOptionPane.showMessageDialog(this, "Không Thành Công!!!");
                }
                    
            } catch (ParseException ex) {
                Logger.getLogger(JPSell.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jButton7ActionPerformed
     public void deleteKH(String tenkh, String maHD){
        String sql = "DELETE khachhang"
                + "   from khachhang kh, hoadon hd "
                + "   where tenkh = ? and hd.mahd = ? ";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,tenkh);
            stmt.setString(2, maHD);
            
            stmt.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showConfirmDialog(this, ex.toString());
        }
    }
    public void deleteHD(String mahd){
        String sql = "DELETE from HoaDon where MaHD = ?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,mahd);
            
            stmt.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void deleteCTHD(String mahd){
        String sql = "DELETE chitiethoadon where MaHD = ?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,mahd);
            stmt.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showConfirmDialog(this, ex.toString());
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            DefaultTableModel model = (DefaultTableModel) tblSell2.getModel();
            int i = tblSell2.getSelectedRow();
            long tongtien = moneyFormat(lbTongTien.getText().toString());
            long unitPrice = moneyFormat(tblSell2.getValueAt(i, 5).toString());
            long tonggia = tongtien - unitPrice;
            String tgia = textFormat(tonggia);
            lbTongTien.setText(tgia);
            model.removeRow(i);
            //int i = removeSelectedRows(tblSell2);
            
        }catch(Exception ex){
            Logger.getLogger(JPSell.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
//    public static boolean isIntegerNumber(String str)
//    {
//        return str.matches("\\d+");
//    }
    public static boolean checkNumber(String s) throws Exception 
    {
        for(int i =0 ; i< s.length(); i++){
            if(Character.isDigit(s.charAt(i)) || s.charAt(i) == '.'){
     
            }else return false;
        }
        return true;
    }    
    public int getMaDM(String tenDM) throws SQLException{
        int maDM = -1;
        String sql = "Select MaDM from DanhMuc where tenDM = ?";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tenDM);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                maDM = rs.getInt("MaDM");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return maDM;
    }
    
    private void cbox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox1ItemStateChanged

    private void cbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int maDM = -1;
        try {
            maDM = getMaDM(cbox1.getSelectedItem().toString());
        } catch (SQLException ex) {
            Logger.getLogger(JPSell.class.getName()).log(Level.SEVERE, null, ex);
        }
        Vector cols = new Vector();
        
        cols.addElement("Mã Sản Phẩm");
        cols.addElement("Tên Sản Phẩm");
        cols.addElement("Giá");
        cols.addElement("Đơn Vị Tiền");
        
        Vector rows = new Vector();
        
        String sql = "Select * from HangHoa where MaDM = ?";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maDM);
        //    System.out.println("Ma" + maDM);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Vector vData = new Vector();
                
                vData.addElement(rs.getString("MASP"));
                vData.addElement(rs.getString("TenSP"));
                vData.addElement(rs.getDouble("GiaBan"));
                vData.addElement(rs.getString("DonViTinh"));
                
                rows.add(vData);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        tblSell1.setModel(new DefaultTableModel(rows,cols));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        // TODO add your handling code here:
//        
//        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
//
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                warn();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                warn();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                warn();
//            }
//            public void warn(){
//                String sql =  "Select * from HangHoa where TenSP like '" + txtTimKiem.getText() + "%'";
//        
//        Vector cols = new Vector();
//       
//        cols.addElement("Mã Sản Phẩm");
//        cols.addElement("Tên Sản Phẩm");
//        cols.addElement("Giá");
//        cols.addElement("Đơn Vị Tiền");
//       
//        Vector rows = new Vector(); 
//            try{
//                stmt = conn.prepareStatement(sql);
//                rs = stmt.executeQuery();
//                
//                while(rs.next()){
//                    Vector vData = new Vector();
//                
//                    vData.addElement(rs.getString("MASP"));
//                    vData.addElement(rs.getString("TenSP"));
//                    vData.addElement(rs.getDouble("GiaBan"));
//                    vData.addElement(rs.getString("DonViTinh"));
//                
//                    rows.add(vData);
//                }
//            }catch(Exception ex){
//                ex.printStackTrace();
//            }
//             tblSell1.setModel(new DefaultTableModel(rows,cols));
//            }
//        });
    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        try{
            txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();
            }
            public void warn(){
                String sql =  "Select * from HangHoa where TenSP like '" + txtTimKiem.getText() + "%'";
        
        Vector cols = new Vector();
       
        cols.addElement("Mã Sản Phẩm");
        cols.addElement("Tên Sản Phẩm");
        cols.addElement("Giá");
        cols.addElement("Đơn Vị Tiền");
       
        Vector rows = new Vector(); 
            try{
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    Vector vData = new Vector();
                
                    vData.addElement(rs.getString("MASP"));
                    vData.addElement(rs.getString("TenSP"));
                    vData.addElement(rs.getDouble("GiaBan"));
                    vData.addElement(rs.getString("DonViTinh"));
                
                    rows.add(vData);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
             tblSell1.setModel(new DefaultTableModel(rows,cols));
            }
            });
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtTimKiemKeyPressed
    
    private void jNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNhanVienActionPerformed
        // TODO add your handling code here:
        Vector cols = new Vector();
        cols.addElement("Mã HD");
        cols.addElement("TênKH");
        cols.addElement("Tổng Tiền");
//        cols.addElement("Đã Trả");
        cols.addElement("Còn Nợ");
        cols.addElement("Số Dư");
        
        Vector rows = new Vector();
        String sql = "Select hd.mahd,kh.tenkh, hd.tongtien,hd.datra,hd.conno,hd.sodu "
                + "  from HoaDon hd, KhachHang kh"
                + "  where hd.makh = kh.makh";
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
               String tongtien = textFormat(rs.getDouble("TongTien"));
             //  String datra = textFormat(rs.getDouble("DaTra"));
               String conno = textFormat(rs.getDouble("ConNo"));
               String sodu = textFormat(rs.getDouble("SoDu"));
               
               Vector data = new Vector();
               data.addElement(rs.getString("MaHD"));
               data.addElement(rs.getString("TenKH"));
               data.addElement(tongtien);
             //  data.addElement(data);
               data.addElement(conno);
               data.addElement(sodu);
               
               rows.add(data);
            }
            tblSell1.setModel(new DefaultTableModel(rows,cols));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jNhanVienActionPerformed

    private void txtThanhToanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThanhToanKeyPressed
        // TODO add your handling code here:
        try{
            if(checkNumber(txtThanhToan.getText()) == true){
                if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    long sodu = (long) (moneyFormat(lbTongTien.getText()) - Double.parseDouble(txtThanhToan.getText()));
                    long temp =  0;
                    if(sodu >= 0){
                        //   sodu =temp;
                        lbSoDu.setText("0.0");
                        String strigSodu = textFormat(sodu);
                        lbConNo.setText(strigSodu);
                    }else{
                        temp = sodu;
                        temp = temp + sodu *(-2);
                        lbConNo.setText("0.0");
                        String stringTemp = textFormat(temp);
                        lbSoDu.setText(stringTemp);
                    }
                    txtTenKh.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(this, "Bạn Phải Nhập Số", "Nhập Lại", -1);
                txtThanhToan.setText("");
            }
        }catch(Exception ex){
            Logger.getLogger(JPSell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtThanhToanKeyPressed

    private void txtThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhToanActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        String s = tblSell2.getValueAt(0, 0).toString();
        System.out.println("Ma SP: " + s);
        int rows = tblSell2.getRowCount();
        System.out.println("rows = " + rows);
    }//GEN-LAST:event_jButton8ActionPerformed

    public String textFormat(double d){
        NumberFormat formatter = NumberFormat.getInstance();
        String moneyString = formatter.format(d);
        
        return moneyString;
    }
    public String textFormat(String s){
        NumberFormat formatter = NumberFormat.getInstance();
        String moneyString = formatter.format(s);
        
        return moneyString;
    }
    public long moneyFormat(String s) throws ParseException{
        NumberFormat format = NumberFormat.getInstance(Locale.JAPANESE);
        Number number = format.parse(s);
        
        return (long)number;
    }
    private void txtSoLuongKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyPressed
        
        try {
            if(checkNumber(txtSoLuong.getText()) == true){
                if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    tblSell2.setValueAt(txtSoLuong.getText(), tblSell2.getRowCount() -1, 4);
                    long gia = (long) (Double.parseDouble(tblSell2.getValueAt(tblSell2.getRowCount()-1 , 2).toString().trim()) * Float.parseFloat(txtSoLuong.getText().toString().trim()));
                   //format text money
                    String stringGia = textFormat(gia);
                    tblSell2.setValueAt(stringGia, tblSell2.getRowCount()-1 , 5);
                    lbTongTien.setText(stringGia);
                    long tonggia = 0;
                    for(int i = 0; i <= tblSell2.getRowCount()-1;  i++){
                        tonggia = tonggia + moneyFormat(tblSell2.getValueAt(i, 5).toString().trim());
                    }
                    String stringTongGia = textFormat(tonggia);
                    lbTongTien.setText(stringTongGia);
                    lbConNo.setText(stringTongGia);
                    txtSoLuong.setText("...");
                    jButton1.setVisible(true);
                }
            }else{
                JOptionPane.showMessageDialog(this,"Bạn Chỉ Được Nhập Số́", "Nhập Lại", 1);
                txtSoLuong.setText("");
                
            }
        } catch (Exception ex) {
            jButton1.setVisible(false);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txtSoLuongKeyPressed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void txtSDTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTKeyPressed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void txtTenKhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenKhKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhKeyPressed

    private void txtTenKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhActionPerformed

    private void txtDiaChiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaChiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiKeyPressed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void txtThanhToanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThanhToanKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtThanhToanKeyTyped

    private void txtThanhToanCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtThanhToanCaretUpdate
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtThanhToanCaretUpdate

    private void txtThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtThanhToanMouseClicked
        // TODO add your handling code here:
        
        if(Double.parseDouble(txtThanhToan.getText().toString()) == 0){
            txtThanhToan.setText("");
        }
    }//GEN-LAST:event_txtThanhToanMouseClicked

    private void txtGiaDinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaDinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaDinhActionPerformed

    private void txtGiaDinhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaDinhKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaDinhKeyPressed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        // TODO add your handling code here:
        
        if(jButton10.getText().toString().equals("Thêm")){
            cbGiaDinh.setVisible(false);
            txtGiaDinh.setVisible(true);
            jButton10.setText("OK");
        }else if(jButton10.getText().toString().equals("OK")){
            cbGiaDinh.setVisible(true);
            txtGiaDinh.setVisible(false);
            jButton10.setText("Thêm");
        }
    }//GEN-LAST:event_jButton10MouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemKeyReleased

    //Xoa Dong table
    public int removeSelectedRows(JTable table){
        int i =0;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int[] rows = table.getSelectedRows();
        for(i=0;i<rows.length;i++){
          model.removeRow(rows[i]-i);
        }
        return i;
    }   
    public static String genCodeHD(){
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmmss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
    public static String genCodeDATE(){
       DateFormat dateFormat = new SimpleDateFormat("dd ':' MM ':' yy ' 'HH ':'mm");
//       Date date1 = new Date();
//       System.out.println(dateFormat.format(date1));
       Calendar cal = Calendar.getInstance();
//       System.out.println(dateFormat.format(cal.getTime()));
       return dateFormat.format(cal.getTime());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbGiaDinh;
    private javax.swing.JComboBox cbox1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jNhanVien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbConNo;
    private javax.swing.JLabel lbMaHD;
    private javax.swing.JLabel lbSoDu;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JTable tblSell1;
    private javax.swing.JTable tblSell2;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGiaDinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKh;
    private javax.swing.JTextField txtThanhToan;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
    
}
