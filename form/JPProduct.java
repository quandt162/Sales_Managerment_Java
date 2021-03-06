/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.sql.Connection;
//import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.ComboBoxModel;
//import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Love Jav
 */
public class JPProduct extends javax.swing.JPanel {

    /**
     * Creates new form jpProduct
     */
    Connection conn = null;
    PreparedStatement stmt =null;
    ResultSet rs =null;
    public JPProduct() {
        
        initComponents();
        jPanel6.setOpaque(false);
        jLabel7.setOpaque(false);
        jLabel8.setOpaque(false);
        jLabel9.setOpaque(false);
        jLabel10.setOpaque(false);
        jPanel1.setOpaque(false);
        this.setOpaque(false);
        tblProduct.getTableHeader().setReorderingAllowed(false);
        tblProduct.getTableHeader().setResizingAllowed(false);
        try{
            conn = ConnectionDB.connectionDB.getConnection();
            ShowProduct();
            ShowComboBox2();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
     public String getTen(String id, String name,String table,String txtName){
        
        String ma = "select " + id + " from "+table+" where "+ name + " = ?";
        String key= "";
    //    String makh = getTen("MaKH","TenKH",txtTenKh.getText());
        
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
    public void themDanhMuc(String tenDM){
       String sql = "SELECT tendm FROM DanhMuc Where TenDM =?";
        
            try{
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, tenDM);
                rs = stmt.executeQuery();

                if(rs.next()){
                    JOptionPane.showMessageDialog(this, tenDM + " Đã tồn tại!" ,"Lỗi", 1);
                }else{

                    String sqlAdd  = "INSERT INTO DanhMuc(TenDM) values(?)";
                    stmt = conn.prepareStatement(sqlAdd);
                    stmt.setString(1, tenDM);
                    stmt.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Thêm Thành Công");
                }
            }catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Không Thành Công");
            }
    }
    public void ShowComboBox2(){
        String sql = "Select TenDM from DanhMuc";
        
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                String tenDM = rs.getString("TenDM");
                cb2.addItem(tenDM);
            }         
           // System.out.println("List" + listDM.get(1));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            
        }
    }
    public void ShowProduct(){
        
        Vector cols = new Vector();
        cols.addElement("Mã Sản Phẩm");
        cols.addElement("Tên Sản Phẩm");
        cols.addElement("Giá");
        cols.addElement("Đơn Vị Tính");
        cols.addElement("Loại");
        Vector rows = new Vector();
        String selectR = "SELECT hh.masp, hh.tensp, hh.giaban, hh.donvitinh, dm.tendm "
                + "       FROM HANGHOA hh, DANHMUC dm"
                + "       Where hh.madm = dm.madm";
        
        try{
            stmt = conn.prepareStatement(selectR);
            rs = stmt.executeQuery();
            while(rs.next()){
                Vector data = new Vector();
                data.addElement(rs.getString("MASP"));
                data.addElement(rs.getString("TenSP"));
                data.addElement(rs.getDouble("GiaBan"));
                data.addElement(rs.getString("DonViTinh"));
                data.addElement(rs.getString("TenDM"));
                        
                rows.add(data);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        tblProduct.setModel(new DefaultTableModel(rows,cols));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        cb1 = new javax.swing.JComboBox();
        txtTimKiem = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cb2 = new javax.swing.JComboBox();
        txtMSP = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        txtTenSp = new javax.swing.JTextField();
        txtDVT = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        txtDM = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(153, 153, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 51), new java.awt.Color(255, 255, 51), null, new java.awt.Color(255, 255, 51)));

        cb1.setBackground(new java.awt.Color(255, 153, 153));
        cb1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo Loại", "Theo Tên", "" }));

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });

        btSearch.setText("Tìm");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cb1)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtTimKiem)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addGap(12, 12, 12))))
        );

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 370, 60));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 51), new java.awt.Color(255, 255, 0), null, new java.awt.Color(255, 255, 51)));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 51), new java.awt.Color(255, 255, 0), null, new java.awt.Color(255, 255, 51)));

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 690, 660));

        jPanel1.setBackground(new java.awt.Color(153, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 51), new java.awt.Color(204, 255, 51), null, null));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Loại Sản Phẩm:");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Giá Bán:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Mã Sản Phẩm:");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Đơn Vị Tính:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Tên Sản Phẩm:");

        txtTenSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSpActionPerformed(evt);
            }
        });

        btAdd.setText("Thêm");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btEdit.setText("Sửa");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btDelete.setText("Xóa");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btExit.setText("In hết sản phẩm");

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14)
                            .addComponent(cb2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                            .addGap(123, 123, 123)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDVT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(txtGia, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenSp, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMSP, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btExit, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDM, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDM, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 430, 320));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/main1.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1226, 796));
        jLabel1.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSearchActionPerformed

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        // TODO add your handling code here:
        int row = tblProduct.getSelectedRow();
        
        if(row != -1){
            cb2.setSelectedItem(tblProduct.getValueAt(row, 4));
            txtMSP.setText(tblProduct.getValueAt(row, 0).toString());
            txtTenSp.setText(tblProduct.getValueAt(row, 1).toString());
            txtGia.setText(tblProduct.getValueAt(row, 2).toString());
            txtDVT.setText(tblProduct.getValueAt(row, 3).toString());
        }
    }//GEN-LAST:event_tblProductMouseClicked
    public void EditMaCTHD(String code){
        
    }
    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
//        if("".equals(txtMSP.getText()) || txtMSP.getText() == null){
//            JOptionPane.showMessageDialog(this, "Chọn Sản phẩm!!!");
//        }else{
            String sqlEdit = "UPDATE HANGHOA set TenSp = ? , GiaBan = ?, DonViTinh = ?, MaDM = ? Where MaSP =?";
            try{
                stmt = conn.prepareStatement(sqlEdit);
                stmt.setString(1, txtTenSp.getText());
                stmt.setDouble(2, Double.parseDouble(txtGia.getText()));
                stmt.setString(3, txtDVT.getText());
                
                stmt.setInt(4, cb2.getSelectedIndex());
                stmt.setString(5, txtMSP.getText());

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this,"Sửa Thành Công");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Không Thành công");
                e.printStackTrace();
            }
     //   }
       
        txtMSP.setText("");
        ShowProduct();
    }//GEN-LAST:event_btEditActionPerformed
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
    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
        if(("".equals(txtMSP.getText()) || txtMSP.getText() == null) || ("".equals(txtTenSp.getText()) || txtTenSp.getText() == null ) ||
                ("".equals(txtGia.getText()) || txtGia.getText() == null ) || ("".equals(txtDVT.getText()) || txtDVT.getText() == null )){
            JOptionPane.showMessageDialog(this, "Bạn Phải Điền Hết Thông Tin Sản Phẩm!!!");
            return;
        }
        
        int maDM = -1;
        try {
            maDM = getMaDM(cb2.getSelectedItem().toString());
        } catch (SQLException ex) {
            Logger.getLogger(JPProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sqlQuery = "SELECT * From HangHoa Where MaSP = ?";
    //    System.out.println("MA" + maDM);
        try{

            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1,txtMSP.getText());
            rs = stmt.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(this, "Sản Phẩm Đã Tồn Tại");
            }
            else{
                
                String sqladd = "INSERT INTO HangHoa(MaSP, TenSP, GiaBan, DonViTinh, MaDM) values(?,?,?,?,?)";
                
                stmt = conn.prepareStatement(sqladd);
                stmt.setString(1, txtMSP.getText());
                stmt.setString(2, txtTenSp.getText());
                stmt.setDouble(3, Double.parseDouble(txtGia.getText()));
                stmt.setString(4, txtDVT.getText());
                stmt.setInt(5,maDM);
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(this,"Đã Thêm" + txtTenSp.getText());
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        txtMSP.setText("");
        ShowProduct();
    }//GEN-LAST:event_btAddActionPerformed
    
    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        String sqldelete = " DELETE HANGHOA Where MASP = ?";
        
        if("".equals(txtMSP.getText()) || txtMSP.getText() == null){
            JOptionPane.showMessageDialog(this, "Chọn Sản phẩm!!!");
        }else{
            int choice = JOptionPane.showConfirmDialog(this, "Bạn Có Chắc Muốn Xóa Không?");
        
            if(choice == JOptionPane.YES_OPTION){
                try{
                    stmt = conn.prepareStatement(sqldelete);
                    stmt.setString(1, txtMSP.getText());
                    stmt.executeUpdate();

                    ShowProduct();
                }catch(SQLException ex){
                    System.out.println(ex);
                }
            }
        }
        
        txtMSP.setText("");
    }//GEN-LAST:event_btDeleteActionPerformed

    private void txtTenSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this, "Thêm Danh Mục Này?");
        
        if("".equals(txtDM.getText()) && txtDM.getText() == null){
            return;
        }else{
            if(choice == JOptionPane.YES_OPTION){
                themDanhMuc(txtDM.getText());
            }
        }
        
        ShowComboBox2();
 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        // TODO add your handling code here:
           String sql =  "Select * from HangHoa where TenSP like '" + txtTimKiem.getText() + "%'";
        
        Vector cols = new Vector();
        
        cols.addElement("Mã Sản Phẩm");
        cols.addElement("Tên Sản Phẩm");
        cols.addElement("Giá");
        cols.addElement("Đơn Vị Tiền");
        
        
        Vector rows = new Vector();
     //   do
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
            tblProduct.setModel(new DefaultTableModel(rows,cols));
    }//GEN-LAST:event_txtTimKiemKeyTyped
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btSearch;
    private javax.swing.JComboBox cb1;
    private javax.swing.JComboBox cb2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtDM;
    private javax.swing.JTextField txtDVT;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMSP;
    private javax.swing.JTextField txtTenSp;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
