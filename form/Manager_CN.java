/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import form.JPProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
//import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import form.PMain;
import entity.Employees;
import java.awt.AWTException;
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.net.URL;
//import java.awt.Toolkit;
//import java.io.BufferedInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.time.Year;
//import java.util.Calendar;
import java.util.Date;
//import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
//import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.tools.Tool;
//com.sun.java.swing.plaf.motif.MotifLookAndFeel
//com.sun.java.swing.plaf.windows.WindowsLookAndFeel
/**
 *
 * @author Love Jav
 */
public class Manager_CN extends javax.swing.JFrame {

    /**
     * Creates new form Manager
     */
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs =null;
    public CardLayout  card = new CardLayout();
    String tennv = "";
    String matkhau = "";
    String quyen = "";
    
    public  Manager_CN(Login login, Employees employees) throws SQLException{
        super();
        initComponents();
        
        setIconFrame();
        ShowTrayIcon();
        tennv = employees.getTennv();
        matkhau = employees.getMatkhau();
        quyen = employees.getQuyen();
        
        this.setLocation(200, 10);
        jpMain.setLayout(card); 
        Dimension d=getMaximumSize(); 
        this.setSize(d.width, d.height);
        jpMain.removeAll();
        jpMain.repaint();
        jpMain.validate();
        
        jpMain.add(new PMain(),"Panel Main");
        jpMain.add(new JPSell(),"SELL");
        jpMain.add(new JPProduct(),"Products");
        jpMain.add(new JPBill(),"Customer");
        jpMain.add(new JPEmployees(),"EmPloyees");
        jpMain.add(new AboutME(),"AboutMe");
        jpMain.add(new CalculateEpls(),"CaculateEpls");
        
        lbUser.setText(employees.getTennv());
        
        jPanel1.setOpaque(false);
        jpDanhMuc.setOpaque(false);
        jPanel7.setOpaque(false);
        jPanel3.setOpaque(false);

        this.setMaximumSize(new Dimension(1615,965));
        this.setResizable(false);

        this.pack();
        Clock();
        t1.start();
        
//        try {
//        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//      } catch (Exception e) {
//        e.printStackTrace();
//      }
    }
    
    public Manager_CN() throws SQLException {
       initComponents();
        ImageIcon icon = new ImageIcon("mages\\payment-icon.png");
        this.setIconImage(icon.getImage());
//        this.setLocation(200, 50);
//        jMenuBar1.setEnabled(false);
//        jpMain.setLayout(card); 
//        //this.setResizable(false);
//        
//        Dimension d=getMaximumSize(); 
//        this.setSize(d.width, d.height);
//        
//        jpMain.removeAll();
//        jpMain.repaint();
//        jpMain.validate();
//        
//        jpMain.add(new PMain(),"Panel Main");
//        jpMain.add(new JPSell(),"SELL");
//        jpMain.add(new JPProduct(),"Products");
//        jpMain.add(new JPBill(),"Customer");
//        jpMain.add(new CalculateEpls(),"CaculateEpls");
//        jpMain.add(new JPEmployees(),"EmPloyees");
//        jpMain.add(new AboutME(),"AboutMe");
//        
//        //set Opaque
//        jPanel1.setOpaque(false);
//        jpDanhMuc.setOpaque(false);
//        jPanel7.setOpaque(false);
//        jPanel3.setOpaque(false);
//
//        this.setMinimumSize(new Dimension(1615,965));
//        this.setResizable(true);
//        this.pack();
//        Clock();
//        t1.start();
//        try {
//        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//      } catch (Exception e) {
//        e.printStackTrace();
//      }
    }
    Timer t1 = new Timer(150, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            String st = txtMain.getText();
            txtMain.setText(st.substring(1) + st.charAt(0));
        }
    });
    public String getTenNV(){
        return tennv;
    }
    public void Clock()
    {
        final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        final DateFormat timeFormat2 = new SimpleDateFormat("dd'/'MM");
        final DateFormat timeFormat3 = new SimpleDateFormat("yyyy");
        ActionListener timerListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Date date = new Date();
                Date day = new Date();
                Date year = new Date();
                String time = timeFormat.format(date);
                lbtime.setText(time);
                String d = timeFormat2.format(day);
                lbday.setText(d);
                String y = timeFormat3.format(year);
                lbyear.setText(y);
            }
        };
        Timer timer = new Timer(1000, timerListener);
        // to make sure it doesn't wait one second at the start
        timer.setInitialDelay(0);
        timer.start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jFrame1 = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtMain = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jpDanhMuc = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btHome = new javax.swing.JButton();
        btBanLe = new javax.swing.JButton();
        btKhoHang = new javax.swing.JButton();
        btTinhCong = new javax.swing.JButton();
        btKhachHang = new javax.swing.JButton();
        btLanguage = new javax.swing.JButton();
        btNhanVien = new javax.swing.JButton();
        btTinhCong1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        lbday = new javax.swing.JLabel();
        lbyear = new javax.swing.JLabel();
        lbtime = new javax.swing.JLabel();
        btChangeAccout = new javax.swing.JButton();
        btAboutMe = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jpMain = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btSychonize = new javax.swing.JButton();
        btMusic = new javax.swing.JButton();
        btSnake = new javax.swing.JButton();
        btexit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jButton13.setBackground(new java.awt.Color(204, 255, 204));
        jButton13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/User-Group-icon.png"))); // NOI18N
        jButton13.setText("Khách Hàng");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 255, 51));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/shop-cart-apply-icon.png"))); // NOI18N
        jButton10.setText("Nhập Hàng");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(204, 255, 204));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/raw_material.png"))); // NOI18N
        jButton8.setText("Kho Hàng");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(204, 204, 255));
        jButton11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/Preppy-icon.png"))); // NOI18N
        jButton11.setText("Nhân Viên");

        jButton9.setBackground(new java.awt.Color(153, 255, 255));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/auction-hammer-icon.png"))); // NOI18N
        jButton9.setText("Bán Lẻ");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/Man-icon.png"))); // NOI18N
        jButton12.setText("About me");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Qs2T 1.0.1");
        setBackground(new java.awt.Color(204, 255, 204));
        setExtendedState(6);

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 153));

        txtMain.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 48)); // NOI18N
        txtMain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMain.setText("       Vật Liệu Xây Dựng Miến Nhắc   ");

        lbUser.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbUser.setForeground(new java.awt.Color(255, 255, 204));
        lbUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Xin Chào");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMain, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMain))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel11.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 21, 1570, 60));

        jpDanhMuc.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 51, 51), new java.awt.Color(255, 51, 51)));
        jpDanhMuc.setToolTipText("Danh Mục");
        jpDanhMuc.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btHome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/Home-icon.png"))); // NOI18N
        btHome.setText("Trang Chủ");
        btHome.setHideActionText(true);
        btHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btHome.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHomeActionPerformed(evt);
            }
        });

        btBanLe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btBanLe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/auction-hammer-icon (1).png"))); // NOI18N
        btBanLe.setText("Bán Lẻ & HD");
        btBanLe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btBanLe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBanLeActionPerformed(evt);
            }
        });

        btKhoHang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btKhoHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/Folder-Home-Folder-icon.png"))); // NOI18N
        btKhoHang.setText("Kho Hàng");
        btKhoHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btKhoHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKhoHangActionPerformed(evt);
            }
        });

        btTinhCong.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btTinhCong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/Microsoft-Excel-icon.png"))); // NOI18N
        btTinhCong.setText("Báo Cáo");
        btTinhCong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btTinhCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTinhCongActionPerformed(evt);
            }
        });

        btKhachHang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/bill.png"))); // NOI18N
        btKhachHang.setText("Hóa Đơn");
        btKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKhachHangActionPerformed(evt);
            }
        });

        btLanguage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btLanguage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/devil-icon.png"))); // NOI18N
        btLanguage.setText("Ngôn Ngữ");
        btLanguage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLanguageActionPerformed(evt);
            }
        });

        btNhanVien.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/csv-icon.png"))); // NOI18N
        btNhanVien.setText("Nhân Viên");
        btNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhanVienActionPerformed(evt);
            }
        });

        btTinhCong1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btTinhCong1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/Administrator-3-icon.png"))); // NOI18N
        btTinhCong1.setText("Khách Hàng");
        btTinhCong1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btTinhCong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTinhCong1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btBanLe, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btTinhCong1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btTinhCong, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btLanguage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(btKhoHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btHome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBanLe, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btKhoHang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btTinhCong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btTinhCong1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpDanhMuc.add(jPanel3);
        jPanel3.setBounds(10, 8, 170, 300);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbday.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        lbday.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel7.add(lbday, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 170, 50));

        lbyear.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        lbyear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel7.add(lbyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 170, 100));

        lbtime.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        lbtime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel7.add(lbtime, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 170, 90));

        btChangeAccout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/Button-exit-icon.png"))); // NOI18N
        btChangeAccout.setText("Đổi tài khoản");
        btChangeAccout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btChangeAccout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChangeAccoutActionPerformed(evt);
            }
        });
        jPanel7.add(btChangeAccout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 140, 30));

        btAboutMe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btAboutMe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/devil-icon.png"))); // NOI18N
        btAboutMe.setText("About Me");
        btAboutMe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btAboutMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAboutMeActionPerformed(evt);
            }
        });
        jPanel7.add(btAboutMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 140, 30));

        jpDanhMuc.add(jPanel7);
        jPanel7.setBounds(10, 331, 170, 460);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/tuychon.png"))); // NOI18N
        jpDanhMuc.add(jLabel3);
        jLabel3.setBounds(2, 2, 185, 796);

        jPanel11.add(jpDanhMuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 190, 800));

        jpMain.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 0), new java.awt.Color(255, 51, 51)));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/main1.jpg"))); // NOI18N

        javax.swing.GroupLayout jpMainLayout = new javax.swing.GroupLayout(jpMain);
        jpMain.setLayout(jpMainLayout);
        jpMainLayout.setHorizontalGroup(
            jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpMainLayout.setVerticalGroup(
            jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel11.add(jpMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 1230, -1));

        btSychonize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/thin-115_upload_cloud_files_drive-48.png"))); // NOI18N
        btSychonize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSychonizeActionPerformed(evt);
            }
        });
        jPanel11.add(btSychonize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 230, 100, 80));

        btMusic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/audio-folder-icon.png"))); // NOI18N
        btMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMusicActionPerformed(evt);
            }
        });
        jPanel11.add(btMusic, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 370, 100, 80));

        btSnake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/Snake-icon.png"))); // NOI18N
        btSnake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSnakeActionPerformed(evt);
            }
        });
        jPanel11.add(btSnake, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 500, 100, 80));

        btexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/Action-exit-icon.png"))); // NOI18N
        btexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btexitActionPerformed(evt);
            }
        });
        jPanel11.add(btexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 630, 100, -1));

        jLabel5.setText("Phần mềm bán hàng EasySell version 1.0.1");
        jPanel11.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 900, 460, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/12119811_942970322426154_92051987_o.jpg"))); // NOI18N
        jPanel11.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/bill.png"))); // NOI18N
        jMenuItem1.setText("New Bill");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/productItem.png"))); // NOI18N
        jMenuItem3.setText("New Product");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/employee item.png"))); // NOI18N
        jMenuItem4.setText("New Employee");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator2);

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/open item.png"))); // NOI18N
        jMenuItem16.setText("Open All Bill");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem16);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Open All Product");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator3);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/item export.png"))); // NOI18N
        jMenuItem6.setText("Import Excel");
        jMenu1.add(jMenuItem6);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Export CSV");
        jMenu1.add(jMenuItem8);

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/item import.png"))); // NOI18N
        jMenuItem17.setText("Export PDF");
        jMenu1.add(jMenuItem17);
        jMenu1.add(jSeparator4);

        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/item save.png"))); // NOI18N
        jMenuItem18.setText("Save");
        jMenu1.add(jMenuItem18);
        jMenu1.add(jSeparator5);

        jMenuItem19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem19.setText("Exit");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem19);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/fix bill.png"))); // NOI18N
        jMenuItem2.setText("Fix Bill");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/fix product.png"))); // NOI18N
        jMenuItem9.setText("Fix Product Info");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/fix customer.png"))); // NOI18N
        jMenuItem7.setText("Fix Employee Info");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText("Fix Report");
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("View");

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setText("Product");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/bill.png"))); // NOI18N
        jMenuItem12.setText("Bill");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuItem13.setText("Customer");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/employee item.png"))); // NOI18N
        jMenuItem14.setText("Employee");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem14);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Tool");

        jMenuItem15.setText("Update Pro Version");
        jMenu4.add(jMenuItem15);
        jMenu4.add(jSeparator6);

        jMenuItem22.setText("Play Snake");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem22);

        jMenuItem23.setText("Play Music");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem23);

        jMenuItem24.setText("Sychonize website");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem24);

        jMenuBar1.add(jMenu4);

        jMenu6.setText("About me");

        jMenuItem21.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem21.setText("About me");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem21);

        jMenuBar1.add(jMenu6);

        jMenu5.setText("Help");

        jMenuItem20.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem20.setText("Contact me");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem20);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here
   
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btexitActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, "Thoát Hết Các Hoạt Động?", "Thoát", 1);
        if(result == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btexitActionPerformed

    private void btHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHomeActionPerformed
        // TODO add your handling code here:
        card.show(jpMain,"Panel Main");
        jpMain.repaint();
        jpMain.validate();
    }//GEN-LAST:event_btHomeActionPerformed

    private void btBanLeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBanLeActionPerformed
        // TODO add your handling code here:
        
        card.show(jpMain, "SELL");
        jpMain.repaint();
        jpMain.revalidate();
    }//GEN-LAST:event_btBanLeActionPerformed

      public boolean CheckLogin(){
        JLabel jPassword = new JLabel("Password");
        JTextField password = new JPasswordField();
        Object[] ob = {jPassword, password};
        int result = JOptionPane.showConfirmDialog(null, ob, "Điền mật khẩu", JOptionPane.OK_CANCEL_OPTION);
        String mk = password.getText().trim();
        if(mk.equals(matkhau)){
            return true;
        }
        return false;  
    }
    private void btKhoHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhoHangActionPerformed
        // TODO add your handling code here:
        if(CheckLogin() == true){
            card.show(jpMain, "Products");
            jpMain.repaint();
            jpMain.revalidate();
        }
//        else
//            JOptionPane.showMessageDialog(this, "Bạn Không Có Quyền", "Regret", 2);
        
    }//GEN-LAST:event_btKhoHangActionPerformed

    private void btKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhachHangActionPerformed
        // TODO add your handling code here:
        if(CheckLogin() == true){
            card.show(jpMain,"Customer");
            jpMain.repaint();
            jpMain.validate();
        }
//        else
//            JOptionPane.showMessageDialog(this, "Bạn Không Có Quyền", "Regret", 2);
        
    }//GEN-LAST:event_btKhachHangActionPerformed

    private void btNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhanVienActionPerformed
        // TODO add your handling code here:
        if(CheckLogin() == true){
             card.show(jpMain, "EmPloyees");
            jpMain.repaint();
            jpMain.revalidate();
        }
//        else
//            JOptionPane.showMessageDialog(this, "Bạn Không Có Quyền", "Regret", 2);
       
    }//GEN-LAST:event_btNhanVienActionPerformed

    private void btChangeAccoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChangeAccoutActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Login lg = new Login();
        lg.setVisible(true);
    }//GEN-LAST:event_btChangeAccoutActionPerformed

    private void btLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLanguageActionPerformed
        // TODO add your handling code here:
            String language [] = {"English","Japanese","Tiếng Việt"};
            JComboBox jComboBox = new JComboBox(language);
            Object obj [] = {jComboBox};
            JOptionPane.showMessageDialog(null,obj, "Chức năng chưa hoàn thiện",1);
    }//GEN-LAST:event_btLanguageActionPerformed

    private void btTinhCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTinhCongActionPerformed
        // TODO add your handling code here:
            card.show(jpMain, "CaculateEpls");
            jpMain.repaint();
            jpMain.revalidate();
    }//GEN-LAST:event_btTinhCongActionPerformed

    private void btSychonizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSychonizeActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Bạn phải nâng cấp bản PRO để sử dụng chức năng này");
    }//GEN-LAST:event_btSychonizeActionPerformed

    private void btMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMusicActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Bạn phải nâng cấp bản PRO để sử dụng chức năng này");
    }//GEN-LAST:event_btMusicActionPerformed

    private void btSnakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSnakeActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Bạn phải nâng cấp bản PRO để sử dụng chức năng này");
    }//GEN-LAST:event_btSnakeActionPerformed

    private void btAboutMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAboutMeActionPerformed
        // TODO add your handling code here:
        card.show(jpMain, "AboutMe");
        jpMain.repaint();
        jpMain.revalidate();
    }//GEN-LAST:event_btAboutMeActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
       btBanLe.doClick();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        btKhoHang.doClick();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        btKhachHang.doClick();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        btNhanVien.doClick();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        btKhachHang.doClick();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        // TODO add your handling code here:
        btSnake.doClick();
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        btKhachHang.doClick();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        btKhoHang.doClick();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        btKhoHang.doClick();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        btexit.doClick();
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        btKhachHang.doClick();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        btNhanVien.doClick();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        // TODO add your handling code here:
        btMusic.doClick();
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        // TODO add your handling code here:
        btSychonize.doClick();
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        btKhoHang.doClick();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        btNhanVien.doClick();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        // TODO add your handling code here:
        btAboutMe.doClick();
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Đỗ Trung Quân: 0966 057 359");
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void btTinhCong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTinhCong1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btTinhCong1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Manager_CN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manager_CN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manager_CN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manager_CN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        try{
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Manager_CN().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Manager_CN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAboutMe;
    private javax.swing.JButton btBanLe;
    private javax.swing.JButton btChangeAccout;
    private javax.swing.JButton btHome;
    private javax.swing.JButton btKhachHang;
    private javax.swing.JButton btKhoHang;
    private javax.swing.JButton btLanguage;
    private javax.swing.JButton btMusic;
    private javax.swing.JButton btNhanVien;
    private javax.swing.JButton btSnake;
    private javax.swing.JButton btSychonize;
    private javax.swing.JButton btTinhCong;
    private javax.swing.JButton btTinhCong1;
    private javax.swing.JButton btexit;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPanel jpDanhMuc;
    private javax.swing.JPanel jpMain;
    private javax.swing.JLabel lbUser;
    private javax.swing.JLabel lbday;
    private javax.swing.JLabel lbtime;
    private javax.swing.JLabel lbyear;
    private javax.swing.JLabel txtMain;
    // End of variables declaration//GEN-END:variables

    private void setIconFrame() {
        setIconImage(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/mages/iconsystem - Copy.png")));
    }
    public void ShowTrayIcon(){
        if(!SystemTray.isSupported()){
            System.out.println("Lỗi, máy tính của bạn lởm quá");
            System.exit(0);
            return;
        }
        
        final PopupMenu popup = new PopupMenu();
        trayIcon = new TrayIcon(CreateIcon("/mages/iconsystem.png", "Tray Icon"));
        final SystemTray tray = SystemTray.getSystemTray();
        
        trayIcon.setToolTip("EasySell Version 1.0.1\nProject Qs2T");
        
        Menu DisplayMenu = new Menu();

        //add component menu items
        MenuItem AboutItem = new MenuItem("About");
        MenuItem ExitItem = new MenuItem("Exit");
        MenuItem MainMenu = new MenuItem("Trang Chủ Ctrl+H");
        
        MenuItem SaleItem = new MenuItem("Bán Hàng Ctrl+S");
        MenuItem StoreItem = new MenuItem("Kho Hàng Ctrl+P");
        MenuItem CustomerItem = new MenuItem("Khách Hàng Ctrl+C");
        MenuItem EmployeeItem = new MenuItem("Nhân Viên Ctrl+E");
        MenuItem CalculateItem = new MenuItem("Doanh Số Thu Chi Ctrl+R");
        MenuItem LanguageItem = new MenuItem("Ngôn Ngữ Ctrl+L");
        MenuItem AboutMeItem = new MenuItem("About Maker Ctrl+A");
//        
        //populate the popup menu
        popup.add(MainMenu);
        popup.add(SaleItem);
        popup.add(CustomerItem);
        popup.add(EmployeeItem);
        popup.add(CalculateItem);
        popup.add(LanguageItem);
        
        popup.addSeparator();
        popup.add(AboutItem);
        popup.addSeparator();
        popup.add(ExitItem);
        
        //populate the mesage display menu
        //DisplayMenu.add(MainMenu);
        
        trayIcon.setPopupMenu(popup);
        MainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jpMain,"Panel Main");
                jpMain.repaint();
                jpMain.validate();
            }
        });
        
        SaleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jpMain, "SELL");
                jpMain.repaint();
                jpMain.revalidate();
            }
        });
        
        CustomerItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheckLogin() == true){
                    card.show(jpMain,"Customer");
                    jpMain.repaint();
                    jpMain.validate();
                }
            }
        });
        
        EmployeeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheckLogin() == true){
                   card.show(jpMain, "EmPloyees");
                   jpMain.repaint();
                   jpMain.revalidate();
                }
            }
        });
        
        CalculateItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jpMain, "CaculateEpls");
                jpMain.repaint();
                jpMain.revalidate();
            }
        });
        
        LanguageItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btLanguage.doClick();
            }
        });
        
        AboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sản Phẩm được tạo bởi Đỗ Quân");
            }
        });
        
        ExitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
        
        try{
            tray.add(trayIcon);
        }catch(AWTException ex){
            ex.printStackTrace();
        }
    }
    
    protected static Image CreateIcon(String path, String desc){
        URL imageURL = Manager_CN.class.getResource(path);
        return (new ImageIcon(imageURL, desc)).getImage();
    }
    public TrayIcon trayIcon;
}


