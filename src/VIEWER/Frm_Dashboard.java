/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEWER;

import CONTROLLER.Frm_Login;
import CONTROLLER.Frm_Login_new;
import CONTROLLER.Frm_Update_Item;
import MODEL.cashier_methods;
import MODEL.db_methods;
import MODEL.gen_methods;
import MODEL.gen_objects;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

public class Frm_Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Dashboard
     */
    public Frm_Dashboard() {
        Calendar cal = Calendar.getInstance();
        initComponents();
        java.awt.Toolkit tk = this.getToolkit();
        //System.out.println(tk.getScreenSize());
        this.setSize(tk.getScreenSize());
        setLocationRelativeTo(null);
        d_m.FillTable(tbl_items, "select barcode,description,sold_type from tbl_product");
        d_m.FillCombo(cmbCategory, "select category from tbl_prod_category", "category");
        d_m.FillCombo(cmbDistributor, "select distributor from tbl_distributor", "distributor");
        d_m.FillCombo(cmbSold, "Select * from tbl_sold_by", "sold_type");
        System.out.println((cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE)));
        DisplayAll(new JLabel[]{items, stock, critical, sales, salesTotal}, new String[]{"count(*)", "sum(batchcounter)", "count(*)", "sum(total_bill - total_capital)", "sum(total_bill - total_capital)"},
                new String[]{"", "", "where inventory <= critical_level", "where date like '%" + (cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE)) + "%'", ""}, new String[]{"tbl_product", "view_rough_stockin", "view_rough_inventory_summary", "tbl_transaction", "tbl_transaction"});
        javax.swing.Timer time = new javax.swing.Timer(1000, (ActionListener) new Frm_Dashboard.ClockListener());
        time.start();
        jLabel17.setVisible(Double.valueOf(critical.getText()) > 0);
        btns = new JButton[]{dashboard, product, inventory, Sales, settings, logout};

        FillSettings();
    }

    void FillSettings() {
        g_o.storeName = d_m.returnValue("select shopname from tbl_settings", "shopname");
        g_o.contact = "";
        g_o.owner = d_m.returnValue("select owner from tbl_settings", "owner");
        g_o.address = d_m.returnValue("select address from tbl_settings", "address");
        lbl_store_name.setText(g_o.storeName + " Point of Sales w/ Inventory");
        jLabel16.setText(lbl_store_name.getText());
        lbl_owner.setText("Owner: " + g_o.owner);
        lbl_address.setText("Address: " + g_o.address);
        dist_name1.setText(g_o.storeName);
        dist_number1.setText(g_o.owner);
        dist_email1.setText(g_o.address);
    }

    gen_methods g_m = new gen_methods();
    db_methods d_m = new db_methods();
    gen_objects g_o = new gen_objects();
    cashier_methods c_m = new cashier_methods();

    JButton[] btns;

    void DisplayLabel(JLabel lbl, String col, String cond, String table) {
        lbl.setText(d_m.returnValue("select " + col + " as `total` from " + table + " " + cond, "total"));
    }

    void DisplayAll(JLabel[] lbl, String[] cols, String[] cond, String[] tables) {
        for (int i = 0; i < lbl.length; i++) {
            DisplayLabel(lbl[i], cols[i], cond[i], tables[i]);
        }
    }

    class ClockListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Calendar now = Calendar.getInstance();
            current_date_time.setText(now.get(Calendar.YEAR) + "-" + ((now.get(Calendar.MONTH) + 1) < 10 ? "0"+(now.get(Calendar.MONTH) + 1):(now.get(Calendar.MONTH) + 1)) + "-" + (now.get(Calendar.DATE) < 10? "0"+now.get(Calendar.DATE):now.get(Calendar.DATE)));
            String hour = "" + (now.get(Calendar.HOUR_OF_DAY) > 12 ? now.get(Calendar.HOUR_OF_DAY) - 12 : now.get(Calendar.HOUR_OF_DAY));
            String min = now.get(Calendar.MINUTE) + "";
            String sec = (now.get(Calendar.SECOND)) + "";
            current_date_time.setText(current_date_time.getText() + " " + hour + ":" + min + ":" + sec + " " + (now.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
            lbl_time.setText(current_date_time.getText());
            // current_date_time.setText(String.format("%1$tH:%1$tM:%1$tS", now));
//            d_m.FillCombo(cmbCategory, "select category from tbl_prod_category", "category");
//            d_m.FillCombo(cmbDistributor, "select distributor from tbl_distributor", "distributor");

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        lbl_panel = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        lbl_store_name = new javax.swing.JLabel();
        lbl_time = new javax.swing.JLabel();
        cont = new javax.swing.JPanel();
        pn_dashboard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        items = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        stock = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        critical = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lbl_owner = new javax.swing.JLabel();
        lbl_address = new javax.swing.JLabel();
        current_date_time = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        sales = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        salesTotal = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        pnl_item = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtbarcode = new javax.swing.JTextField();
        txtproductName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtdescription = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbCategory = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbSold = new javax.swing.JComboBox();
        txtSKU = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPack = new javax.swing.JFormattedTextField();
        exp_date = new de.wannawork.jcalendar.JCalendarComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCriticalLevel = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbDistributor = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_items = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        item_searchProd = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtQty1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtQty2 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtOrigPrice = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        txtSKURef = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        txtPack1 = new javax.swing.JFormattedTextField();
        jLabel50 = new javax.swing.JLabel();
        pnl_inventory = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_inventory = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        inv_search = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        pnl_sales = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_sales = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        sales_total = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        sales_today = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        pnl_settings = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_accounts = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel35 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton13 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        dist_name = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        dist_number = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        dist_email = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_distributors = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        dist_name1 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        dist_number1 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        dist_email1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton15 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_logs = new javax.swing.JTable();
        menu = new javax.swing.JPanel();
        dashboard = new javax.swing.JButton();
        product = new javax.swing.JButton();
        Sales = new javax.swing.JButton();
        inventory = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(102, 0, 204));

        lbl_panel.setBackground(new java.awt.Color(153, 102, 255));
        lbl_panel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_panel.setForeground(new java.awt.Color(255, 255, 255));
        lbl_panel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_panel.setText("Current Panel: Dashboard");
        lbl_panel.setOpaque(true);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setBackground(new java.awt.Color(102, 0, 153));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Circled User Female Skin Type 4_60px.png"))); // NOI18N
        jLabel26.setText("Admin");
        jLabel26.setOpaque(true);

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cash Register_96px.png"))); // NOI18N

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(51, 51, 51));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("POS");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(51, 51, 51));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Inventory");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel49)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel26)
                .addGap(0, 0, 0))
        );

        lbl_store_name.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lbl_store_name.setForeground(new java.awt.Color(255, 255, 255));
        lbl_store_name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_store_name.setText("Point of Sales w/ Inventory");

        lbl_time.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lbl_time.setForeground(new java.awt.Color(255, 255, 255));
        lbl_time.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_time.setText("jLabel45");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(728, 728, 728)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_store_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_time, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 1141, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(lbl_store_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_time)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        cont.setBackground(new java.awt.Color(255, 255, 255));
        cont.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cont.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 204), 3));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total No. of Items");

        items.setBackground(new java.awt.Color(204, 0, 204));
        items.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        items.setForeground(new java.awt.Color(255, 255, 255));
        items.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        items.setText("1");

        jLabel24.setBackground(new java.awt.Color(204, 0, 204));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Warehouse_48px.png"))); // NOI18N
        jLabel24.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(items, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(items, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Total Stock-In");

        stock.setBackground(new java.awt.Color(0, 51, 255));
        stock.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        stock.setForeground(new java.awt.Color(255, 255, 255));
        stock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stock.setText("2");

        jLabel25.setBackground(new java.awt.Color(0, 51, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Product_48px.png"))); // NOI18N
        jLabel25.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
        );

        jPanel4.setBackground(new java.awt.Color(255, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 3));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Critical Level Items");

        critical.setBackground(new java.awt.Color(255, 102, 102));
        critical.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        critical.setForeground(new java.awt.Color(255, 255, 255));
        critical.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        critical.setText("3");

        jLabel44.setBackground(new java.awt.Color(255, 102, 102));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Shopping Cart_48px.png"))); // NOI18N
        jLabel44.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(critical, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(critical, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel5.setBackground(new java.awt.Color(0, 204, 51));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Point of Sales  w/ Inventory");

        lbl_owner.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_owner.setForeground(new java.awt.Color(255, 255, 255));
        lbl_owner.setText("Owner:");

        lbl_address.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_address.setForeground(new java.awt.Color(255, 255, 255));
        lbl_address.setText("Address: Kalabugao, Impasug-ong Bukidnon");

        current_date_time.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        current_date_time.setForeground(new java.awt.Color(255, 255, 255));
        current_date_time.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        current_date_time.setText("Date");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_owner, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_address, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(current_date_time, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_owner, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_address, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(current_date_time, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 204, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 3));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Sales Today");

        sales.setBackground(new java.awt.Color(255, 153, 0));
        sales.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        sales.setForeground(new java.awt.Color(255, 255, 255));
        sales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sales.setText("4");

        jLabel46.setBackground(new java.awt.Color(255, 153, 0));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Combo Chart_48px.png"))); // NOI18N
        jLabel46.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(sales, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sales, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel11.setBackground(new java.awt.Color(0, 153, 153));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Sales Total");

        salesTotal.setBackground(new java.awt.Color(0, 102, 102));
        salesTotal.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        salesTotal.setForeground(new java.awt.Color(255, 255, 255));
        salesTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salesTotal.setText("4");

        jLabel47.setBackground(new java.awt.Color(0, 102, 102));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Combo Chart_48px.png"))); // NOI18N
        jLabel47.setOpaque(true);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(salesTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salesTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pn_dashboardLayout = new javax.swing.GroupLayout(pn_dashboard);
        pn_dashboard.setLayout(pn_dashboardLayout);
        pn_dashboardLayout.setHorizontalGroup(
            pn_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dashboardLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pn_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pn_dashboardLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(pn_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pn_dashboardLayout.setVerticalGroup(
            pn_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dashboardLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pn_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pn_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_dashboardLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pn_dashboardLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        cont.add(pn_dashboard, "card5");

        pnl_item.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 51, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Save");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnl_item.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 522, 178, 61));

        txtbarcode.setEditable(false);
        txtbarcode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtbarcode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtbarcodeFocusGained(evt);
            }
        });
        txtbarcode.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtbarcodePropertyChange(evt);
            }
        });
        pnl_item.add(txtbarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 55, 183, 25));

        txtproductName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtproductName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtproductNameFocusGained(evt);
            }
        });
        pnl_item.add(txtproductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 92, 230, 25));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Product Name");
        pnl_item.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 95, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Description");
        pnl_item.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 131, -1, -1));

        txtdescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnl_item.add(txtdescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 128, 230, 25));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Category");
        pnl_item.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 166, -1, -1));

        cmbCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Select Value -", "By Piece", "By Pack" }));
        cmbCategory.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbCategoryPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        pnl_item.add(cmbCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 166, 192, 25));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton2FocusGained(evt);
            }
        });
        pnl_item.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 164, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Sold/Distribute by");
        pnl_item.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 202, 126, -1));

        cmbSold.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbSold.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Select Value -", "By Piece", "By Pack" }));
        cmbSold.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbSoldPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        pnl_item.add(cmbSold, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 202, 192, 24));

        txtSKU.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtSKU.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSKUCaretUpdate(evt);
            }
        });
        txtSKU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSKUKeyReleased(evt);
            }
        });
        pnl_item.add(txtSKU, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 340, 230, 25));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Retail Price");
        pnl_item.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 340, 126, -1));

        jLabel7.setBackground(new java.awt.Color(204, 204, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("WholeSale Price");
        jLabel7.setOpaque(true);
        pnl_item.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 376, 120, -1));

        txtPack.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtPack.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPackCaretUpdate(evt);
            }
        });
        txtPack.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPackKeyReleased(evt);
            }
        });
        pnl_item.add(txtPack, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 376, 119, 25));
        pnl_item.add(exp_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 412, 230, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Exp. Date");
        pnl_item.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 412, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Critical Level");
        pnl_item.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 448, -1, -1));

        txtCriticalLevel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        pnl_item.add(txtCriticalLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 448, 230, 25));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Distributor");
        pnl_item.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 486, -1, -1));

        cmbDistributor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbDistributor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Select Value -", "By Piece", "By Pack" }));
        pnl_item.add(cmbDistributor, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 486, 192, 25));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pnl_item.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 484, -1, -1));

        tbl_items.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_items.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_items.setRowHeight(20);
        jScrollPane1.setViewportView(tbl_items);

        pnl_item.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 55, 570, 490));

        jButton4.setBackground(new java.awt.Color(0, 51, 153));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Cancel");
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        pnl_item.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 522, 178, 61));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Barcode");
        pnl_item.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 58, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Product List/Added");
        pnl_item.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 27, -1, -1));

        item_searchProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        item_searchProd.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                item_searchProdCaretUpdate(evt);
            }
        });
        pnl_item.add(item_searchProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 24, 230, 25));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Stockin (per Pack)");
        pnl_item.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 240, 111, -1));

        txtQty1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQty1.setText("1");
        pnl_item.add(txtQty1, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 237, 230, 25));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("No. Of Packs");
        pnl_item.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 273, 111, -1));

        txtQty2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQty2.setText("1");
        pnl_item.add(txtQty2, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 273, 230, 25));

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton11.setText("+");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        pnl_item.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 56, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel15.setText("Original Price/Capital");
        pnl_item.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 309, 126, -1));

        txtOrigPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        pnl_item.add(txtOrigPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 309, 230, 25));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Ref. No.");
        pnl_item.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 22, -1, -1));

        txtSKURef.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnl_item.add(txtSKURef, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 19, 230, 25));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setText("+");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton7FocusGained(evt);
            }
        });
        pnl_item.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 202, -1, -1));

        txtPack1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtPack1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPack1CaretUpdate(evt);
            }
        });
        txtPack1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPack1KeyReleased(evt);
            }
        });
        pnl_item.add(txtPack1, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 376, 63, 25));

        jLabel50.setBackground(new java.awt.Color(204, 204, 255));
        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel50.setText("Qty.");
        jLabel50.setOpaque(true);
        pnl_item.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 376, -1, -1));

        cont.add(pnl_item, "card2");

        tbl_inventory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_inventory.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_inventory.setRowHeight(20);
        tbl_inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_inventoryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_inventory);

        jLabel17.setBackground(new java.awt.Color(255, 51, 0));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Click Me! Critical Level Alert! There are items that reaches its critical level. Re-stock must be considered.");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.setOpaque(true);
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Search Product/Item");

        inv_search.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inv_search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                inv_searchCaretUpdate(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 51, 153));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton12.setText("New Delivery/Re-Stock Item");
        jButton12.setEnabled(false);
        jButton12.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jButton12.setOpaque(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(0, 51, 153));
        jButton16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton16.setText("View Inventory History");
        jButton16.setEnabled(false);
        jButton16.setOpaque(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(0, 51, 153));
        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_update.setText("Update Product");
        btn_update.setEnabled(false);
        btn_update.setOpaque(false);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_inventoryLayout = new javax.swing.GroupLayout(pnl_inventory);
        pnl_inventory.setLayout(pnl_inventoryLayout);
        pnl_inventoryLayout.setHorizontalGroup(
            pnl_inventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_inventoryLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnl_inventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_inventoryLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(inv_search, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_inventoryLayout.setVerticalGroup(
            pnl_inventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_inventoryLayout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_inventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_inventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_inventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inv_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        cont.add(pnl_inventory, "card3");

        tbl_sales.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbl_sales);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setText("Transaction Lists History");

        sales_total.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sales_total.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel28.setBackground(new java.awt.Color(204, 204, 204));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Total Sales");
        jLabel28.setOpaque(true);

        jLabel43.setBackground(new java.awt.Color(204, 204, 204));
        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Current Sales (Today)");
        jLabel43.setOpaque(true);

        sales_today.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sales_today.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jComboBox4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "From the Beginning", "For Today Only" }));
        jComboBox4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jButton5.setText("View/Print Report");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("View/Print Report");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_salesLayout = new javax.swing.GroupLayout(pnl_sales);
        pnl_sales.setLayout(pnl_salesLayout);
        pnl_salesLayout.setHorizontalGroup(
            pnl_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_salesLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnl_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_salesLayout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(344, 344, 344)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(pnl_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sales_total)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addComponent(sales_today)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        pnl_salesLayout.setVerticalGroup(
            pnl_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_salesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jComboBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_salesLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnl_salesLayout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sales_today, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sales_total, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(203, 203, 203))))
        );

        cont.add(pnl_sales, "card4");

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Name");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Address");

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Contact");

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tbl_accounts.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tbl_accounts);

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Privilege");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Select Value -", "Admin", "Cashier" }));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Username");

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("Password");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("Status");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Select Value -", "Active", "In-active" }));

        jButton13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton13.setText("Save");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel29)
                        .addComponent(jTextField1)
                        .addComponent(jLabel30)
                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                        .addComponent(jLabel31)
                        .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                        .addComponent(jLabel32)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel33)
                        .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                        .addComponent(jLabel34)
                        .addComponent(jPasswordField1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel33)
                        .addGap(15, 15, 15)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("User Accounts", jPanel3);

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setText("Name");

        dist_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setText("Contact Number");

        dist_number.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setText("Email");

        dist_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tbl_distributors.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tbl_distributors);

        jButton14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton14.setText("Save");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(704, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel36)
                        .addComponent(dist_name)
                        .addComponent(jLabel37)
                        .addComponent(dist_number, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                        .addComponent(jLabel38)
                        .addComponent(dist_email, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addGap(211, 211, 211))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel36)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dist_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15)
                            .addComponent(jLabel37)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dist_number, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15)
                            .addComponent(jLabel38)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dist_email, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(269, 269, 269)))
                    .addContainerGap(19, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Distributor", jPanel7);

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Establishment Name");

        dist_name1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        dist_name1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Owner");

        dist_number1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        dist_number1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Establishment's Address");

        dist_email1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        dist_email1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Current Activated Year");

        jComboBox3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));

        jButton15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton15.setText("Save Settigs");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dist_name1)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dist_number1)
                            .addComponent(dist_email1)
                            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(326, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dist_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dist_number1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dist_email1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("System Settings", jPanel8);

        tbl_logs.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tbl_logs);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Activity Logs", jPanel9);

        javax.swing.GroupLayout pnl_settingsLayout = new javax.swing.GroupLayout(pnl_settings);
        pnl_settings.setLayout(pnl_settingsLayout);
        pnl_settingsLayout.setHorizontalGroup(
            pnl_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_settingsLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnl_settingsLayout.setVerticalGroup(
            pnl_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_settingsLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        cont.add(pnl_settings, "card6");

        getContentPane().add(cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 168, -1, 586));

        menu.setBackground(new java.awt.Color(153, 51, 255));

        dashboard.setBackground(new java.awt.Color(102, 0, 153));
        dashboard.setFont(new java.awt.Font("Century Gothic", 1, 22)); // NOI18N
        dashboard.setForeground(new java.awt.Color(255, 255, 255));
        dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dashboard2.png"))); // NOI18N
        dashboard.setText("Dashboard");
        dashboard.setContentAreaFilled(false);
        dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboard.setMargin(new java.awt.Insets(2, 2, 2, 2));
        dashboard.setOpaque(true);
        dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardActionPerformed(evt);
            }
        });

        product.setBackground(new java.awt.Color(153, 51, 255));
        product.setFont(new java.awt.Font("Segoe UI Light", 0, 22)); // NOI18N
        product.setForeground(new java.awt.Color(255, 255, 255));
        product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/product.png"))); // NOI18N
        product.setText("Product");
        product.setContentAreaFilled(false);
        product.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        product.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        product.setOpaque(true);
        product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productActionPerformed(evt);
            }
        });

        Sales.setBackground(new java.awt.Color(153, 51, 255));
        Sales.setFont(new java.awt.Font("Segoe UI Light", 0, 22)); // NOI18N
        Sales.setForeground(new java.awt.Color(255, 255, 255));
        Sales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sales2.png"))); // NOI18N
        Sales.setText("Sales");
        Sales.setContentAreaFilled(false);
        Sales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Sales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Sales.setOpaque(true);
        Sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesActionPerformed(evt);
            }
        });

        inventory.setBackground(new java.awt.Color(153, 51, 255));
        inventory.setFont(new java.awt.Font("Segoe UI Light", 0, 22)); // NOI18N
        inventory.setForeground(new java.awt.Color(255, 255, 255));
        inventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/inventory.png"))); // NOI18N
        inventory.setText("Inventory");
        inventory.setContentAreaFilled(false);
        inventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inventory.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        inventory.setOpaque(true);
        inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryActionPerformed(evt);
            }
        });

        settings.setBackground(new java.awt.Color(153, 51, 255));
        settings.setFont(new java.awt.Font("Segoe UI Light", 0, 22)); // NOI18N
        settings.setForeground(new java.awt.Color(255, 255, 255));
        settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings.png"))); // NOI18N
        settings.setText("Settings");
        settings.setContentAreaFilled(false);
        settings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settings.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        settings.setOpaque(true);
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });

        logout.setBackground(new java.awt.Color(153, 51, 255));
        logout.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        logout.setText("Log out");
        logout.setContentAreaFilled(false);
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logout.setOpaque(true);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Sales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(settings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(product, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(Sales, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 156, 231, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSoldPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbSoldPopupMenuWillBecomeInvisible
        //txtQty1.setEditable(cmbSold.getSelectedIndex() == 1);
        txtQty1.setText("1");
    }//GEN-LAST:event_cmbSoldPopupMenuWillBecomeInvisible

    private void productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productActionPerformed
        g_m.ChangePanel(cont, pnl_item);
        lbl_panel.setText("Current Panel:  Add/Update Product Information");
        ChangeColor(btns, product);
    }//GEN-LAST:event_productActionPerformed
    //String action = "Save";
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (g_m.areEmptyFields(new JTextField[]{txtbarcode, txtproductName, txtdescription, txtOrigPrice, txtSKU, (JTextField) txtQty1, (JTextField) txtQty2, (JTextField) txtSKU, (JTextField) txtPack, (JTextField) txtCriticalLevel})
                || g_m.areEmptyFields(new JTextField[]{txtbarcode, txtproductName, txtdescription, txtOrigPrice, txtQty1, txtQty2, txtSKU}) || g_m.areEmptyFields(new JComboBox[]{cmbCategory, cmbSold, cmbDistributor})) {

            g_m.Error_Message("Input Error", "Empty Fields detected!");
        } else {
            String ref_num = txtSKURef.getText();
            if (ref_num.isEmpty()) {
                JOptionPane.showMessageDialog(null, "You are about to save or update inventory info without a reference number!", "Empty Ref.No detected", JOptionPane.WARNING_MESSAGE);
                ref_num = txtbarcode.getText() + d_m.returnValue("select count(barcode) as counter from tbl_product where barcode = '" + txtbarcode.getText() + "'", "counter");
            }
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to save the inputed data?", "Action Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
                if (d_m.returnValue("select barcode from tbl_product where barcode = '" + txtbarcode.getText() + "'", "barcode").isEmpty()) {
                    d_m.ExeStatement("replace into tbl_product values ('" + txtbarcode.getText() + "','" + txtproductName.getText() + "','" + txtdescription.getText() + "','" + d_m.returnValue("select category_id from tbl_prod_category where category = '" + cmbCategory.getSelectedItem() + "'", "category_id") + "',"
                            + "'" + cmbSold.getSelectedItem() + "','" + g_m.returnDouble(txtOrigPrice.getText()) + "','" +  g_m.returnDouble(txtSKU.getText()) + "','" +  g_m.returnDouble(txtPack.getText()) + "','" + txtPack1.getText() + "','" + txtCriticalLevel.getText() + "')",
                            "");
                        d_m.ExeStatement("insert into tbl_stockin values ('" + ref_num + "','" + txtbarcode.getText() + "','" + txtQty1.getText() + "','" + txtQty2.getText() + "',now()," + (!g_m.returnDate(exp_date, g_o.date_format1).isEmpty() ? "'" + g_m.returnDate(exp_date, g_o.date_format1) + "'" : null) + ",'" + d_m.returnValue("select distributor_id from tbl_distributor where distributor = '" + cmbDistributor.getSelectedItem() + "'", "distributor_id") + "')", "Success! New Item has inserted to the database");
                } else {
                    d_m.ExeStatement("update tbl_product set WholeSaleQuantity = '"+txtPack1.getText()+"',product_name = '" + txtproductName.getText() + "',description = '" + txtdescription.getText() + "',sold_type = '" + cmbSold.getSelectedItem() + "'  ,unit_Price = '" +  g_m.returnDouble(txtOrigPrice.getText()) + "',MarkupRetailPrice = '" +  g_m.returnDouble(txtSKU.getText()) + "',markUpWholeSalePrice = '" +  g_m.returnDouble(txtPack.getText()) + "',cat_id = (select category_id from tbl_prod_category where category = '" + cmbCategory.getSelectedItem() + "') where barcode = '" + txtbarcode.getText() + "'  ", "Success! New item stockin was recorded!");
                    if (!txtQty1.getText().equals("1") || !txtQty2.getText().equals("1")) {
                        d_m.ExeStatement("insert into tbl_stockin values ('" + ref_num + "','" + txtbarcode.getText() + "','" + txtQty1.getText() + "','" + txtQty2.getText() + "',now()," + (!g_m.returnDate(exp_date, g_o.date_format1).isEmpty() ? "'" + g_m.returnDate(exp_date, g_o.date_format1) + "'" : null) + ",'" + d_m.returnValue("select distributor_id from tbl_distributor where distributor = '" + cmbDistributor.getSelectedItem() + "'", "distributor_id") + "')", "");
                    }
                }
                //g_m.Message("Success! New Item has inserted to the database");
                g_m.ClearFields(new JTextField[]{txtbarcode, txtproductName, txtdescription, txtOrigPrice, (JTextField) txtQty1, (JTextField) txtQty2, (JTextField) txtSKU, (JTextField) txtPack, (JTextField) txtCriticalLevel});
                g_m.ClearCombo(new JComboBox[]{cmbCategory, cmbSold, cmbDistributor});
            }
        }
        d_m.FillTable(tbl_items, "select barcode,description,sold_type from tbl_product");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //g_m.Message(g_m.returnDate(exp_date,g_o.date_format1));
//        g_m.Message(d_m.returnValue("select category_id from tbl_prod_category where category = '"+cmbCategory.getSelectedItem()+"'","category_id"));
//        g_m.Message(d_m.returnValue("select distributor_id from tbl_distributor where distributor = '"+cmbDistributor.getSelectedItem()+"'","distributor_id"));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        new Frm_new_barcode(txtbarcode, "Create/Read Barcode", 1).setVisible(true);
        d_m.FillCombo(cmbCategory, "select category from tbl_prod_category", "category");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void txtbarcodePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtbarcodePropertyChange

    }//GEN-LAST:event_txtbarcodePropertyChange
    private void txtbarcodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbarcodeFocusGained
        if (!txtbarcode.getText().isEmpty()) {
            // g_m.Message("sample test");
            d_m.FillCombo(cmbCategory, "select category from tbl_prod_category", "category");
            d_m.FillFields(new JTextField[]{txtproductName, txtdescription, txtOrigPrice, txtSKU, txtPack, txtCriticalLevel}, d_m.returnValues("Select * from tbl_product where barcode = '" + txtbarcode.getText() + "'", new String[]{"product_name", "description", "unit_price", "markUpRetailPrice", "MarkUpWholesalePrice", "critical_level"}));
            cmbCategory.setSelectedItem(d_m.returnValue("select category from tbl_prod_category where category_id = (select cat_id from tbl_product where barcode = '" + txtbarcode.getText() + "')", "category"));
            cmbSold.setSelectedItem(d_m.returnValue("select sold_type from tbl_product where  barcode = '" + txtbarcode.getText() + "'", "sold_type"));
            //exp_date.setDate(null);
            String chk = d_m.returnValue("select withExpiration from tbl_prod_category where category = '" + cmbCategory.getSelectedItem() + "'", "withExpiration");
            exp_date.setEnabled(chk.equalsIgnoreCase("true"));
            if (!chk.equalsIgnoreCase("true")) {
                exp_date.setDate(null);
            }
        }
    }//GEN-LAST:event_txtbarcodeFocusGained

    private void inventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryActionPerformed
        g_m.ChangePanel(cont, pnl_inventory);
        lbl_panel.setText("Current Panel:  Check Inventory/Re-stock of Items");
        d_m.FillTable(tbl_inventory, "select * from view_rough_inventory_summary");
        ChangeColor(btns, inventory);
    }//GEN-LAST:event_inventoryActionPerformed

    private void inv_searchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_inv_searchCaretUpdate
        d_m.FillTable(tbl_inventory, "select * from view_rough_inventory_summary where barcode like '%" + inv_search.getText() + "%' || description like '%" + inv_search.getText() + "%' ");
    }//GEN-LAST:event_inv_searchCaretUpdate

    private void tbl_inventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_inventoryMouseClicked
        jButton12.setEnabled(tbl_inventory.getSelectedRow() != - 1);
        jButton16.setEnabled(tbl_inventory.getSelectedRow() != - 1);
        btn_update.setEnabled(tbl_inventory.getSelectedRow() != - 1);
    }//GEN-LAST:event_tbl_inventoryMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Frm_entities1("Add New Product Category", 0).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmbCategoryPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbCategoryPopupMenuWillBecomeInvisible
        String chk = d_m.returnValue("select withExpiration from tbl_prod_category where category = '" + cmbCategory.getSelectedItem() + "'", "withExpiration");
        exp_date.setEnabled(chk.equalsIgnoreCase("true"));
        if (!chk.equalsIgnoreCase("true")) {
            exp_date.setDate(null);
        }
    }//GEN-LAST:event_cmbCategoryPopupMenuWillBecomeInvisible

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        g_m.ChangePanel(cont, pnl_settings);
        lbl_panel.setText("Current Panel:  Change System Settings and Account Settings");
        d_m.FillTable(tbl_accounts, "select * from tbl_users");
        d_m.FillTable(tbl_distributors, "select * from tbl_distributor");
        d_m.FillTable(tbl_logs, "select * from tbl_logs");
        ChangeColor(btns, settings);
    }//GEN-LAST:event_settingsActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (g_m.Confirm("Save user confirmation", "Are you sure you want to save this new User information?")) {
            d_m.ExeStatement("insert into tbl_users values (null,'" + jTextField1.getText() + "','" + jTextField3.getText() + "','" + jTextField4.getText() + "','" + jComboBox1.getSelectedItem() + "','" + jTextField5.getText() + "','" + jPasswordField1.getText() + "','" + jComboBox2.getSelectedItem() + "')", "");
            d_m.FillTable(tbl_accounts, "select * from tbl_users");
            g_m.ClearFields(new JTextField[]{jTextField1, jTextField3, jTextField4, jTextField5});
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (g_m.Confirm("Save Distributor Confirmation", "Are you sure you want to save this distributor information?")) {
            d_m.ExeStatement("insert into tbl_distributor values (null,'" + dist_name.getText() + "','" + dist_number.getText() + "','" + dist_email.getText() + "')", "");
            d_m.FillTable(tbl_accounts, "select * from tbl_distributor");
            g_m.ClearFields(new JTextField[]{jTextField1, jTextField3, jTextField4, jTextField5});
        }
        if (add_dist) {
            g_m.ChangePanel(cont, pnl_item);
            lbl_panel.setText("Current Panel:  Add/Update Product Information");
            d_m.FillCombo(cmbDistributor, "select distributor from tbl_distributor", "distributor");
            add_dist = false;
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        ChangeColor(btns, logout);
        if (g_m.Confirm("Exit Confirmation", "Are you sure you want to exit?")) {
            new Frm_Login().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void SalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesActionPerformed
        g_m.ChangePanel(cont, pnl_sales);
        lbl_panel.setText("Current Panel:  Sales Tracking");
        d_m.FillTable(tbl_sales, "Select *,(total_bill-total_capital) as `Sales` from tbl_transaction");
        sales_total.setText("" + d_m.returnValue("select sum((total_bill-total_capital)) as `Sales` from tbl_transaction", "sales"));
        ChangeColor(btns, Sales);
    }//GEN-LAST:event_SalesActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        d_m.FillTable(tbl_inventory, "select * from view_rough_inventory_summary where inventory <= critical_level ");
        jLabel17.setVisible(false);
        lbl_panel.setText("Current Panel:  Product Inventory - List of Items in Critical Level");
    }//GEN-LAST:event_jLabel17MouseClicked

    private void dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardActionPerformed
        Calendar cal = Calendar.getInstance();
        g_m.ChangePanel(cont, pn_dashboard);
        ChangeColor(btns, dashboard);
        lbl_panel.setText("Current Panel:  Check Inventory/Re-stock of Items");
        DisplayAll(new JLabel[]{items, stock, critical, sales}, new String[]{"count(*)", "sum(batchcounter)", "count(*)", "sum(total_bill - total_capital)"},
                new String[]{"", "", "where inventory <= critical_level", "where date like '%" + (cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE)) + "%'"}, new String[]{"tbl_product", "view_rough_stockin", "view_rough_inventory_summary", "tbl_transaction"});
    }//GEN-LAST:event_dashboardActionPerformed

    private void jComboBox4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox4PopupMenuWillBecomeInvisible
        Calendar now = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        if (jComboBox4.getSelectedIndex() == 0) {
            d_m.FillTable(tbl_sales, "select *,(total_bill-total_capital) as `Sales` from tbl_transaction");
        } else {
            d_m.FillTable(tbl_sales, "select *,(total_bill-total_capital) as `Sales` from tbl_transaction where date like '%" + now.get(Calendar.YEAR) + "-" + ((now.get(Calendar.MONTH) + 1) < 10 ? "0"+(now.get(Calendar.MONTH) + 1):(now.get(Calendar.MONTH) + 1)) + "-" + (now.get(Calendar.DATE) < 10? "0"+now.get(Calendar.DATE):now.get(Calendar.DATE)) + "%'");
            sales_today.setText("" + d_m.returnValue("select sum((total_bill-total_capital)) as `Sales` from tbl_transaction where date like '%" + now.get(Calendar.YEAR) + "-" + ((now.get(Calendar.MONTH) + 1) < 10 ? "0"+(now.get(Calendar.MONTH) + 1):(now.get(Calendar.MONTH) + 1)) + "-" + (now.get(Calendar.DATE) < 10? "0"+now.get(Calendar.DATE):now.get(Calendar.DATE)) + "%'", "sales"));
        }
        sales_total.setText("" + d_m.returnValue("select sum((total_bill-total_capital)) as `Sales` from tbl_transaction", "sales"));
    }//GEN-LAST:event_jComboBox4PopupMenuWillBecomeInvisible

    private void item_searchProdCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_item_searchProdCaretUpdate
        d_m.FillTable(tbl_items, "select barcode,description,sold_type from tbl_product where barcode like '%" + item_searchProd.getText() + "%' || description like '%" + item_searchProd.getText() + "%' ");
    }//GEN-LAST:event_item_searchProdCaretUpdate

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (tbl_inventory.getSelectedRow() > -1) {
            g_m.ChangePanel(cont, pnl_item);
            ChangeColor(btns, product);
            lbl_panel.setText("Current Panel:  Check Inventory/Re-stock of Items");
            txtbarcode.setText("" + tbl_inventory.getValueAt(tbl_inventory.getSelectedRow(), 0));
            txtbarcode.requestFocus();
        } else {
            g_m.Error_Message("Product infor selection error!", "Please select item info from the table.");
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void txtproductNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtproductNameFocusGained
        if (!txtbarcode.getText().isEmpty()) {
            //g_m.Message("sample test");
            d_m.FillFields(new JTextField[]{txtproductName, txtdescription}, d_m.returnValues("Select * from tbl_product where barcode = '" + txtbarcode.getText() + "'", new String[]{"product_name", "description"}));
        }
    }//GEN-LAST:event_txtproductNameFocusGained

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (!txtbarcode.getText().isEmpty()) {
            d_m.FillFields(new JTextField[]{txtproductName, txtdescription}, d_m.returnValues("Select * from tbl_product where barcode = '" + txtbarcode.getText() + "'", new String[]{"product_name", "description"}));
        }
    }//GEN-LAST:event_formWindowActivated

    private void jButton2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusGained
        d_m.FillCombo(cmbCategory, "select category from tbl_prod_category", "category");
    }//GEN-LAST:event_jButton2FocusGained
    Double total_bill,total_capital;
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Calendar now = Calendar.getInstance();
        g_m.elements = new String[]{"reportType", "Total","t_bill","t_capital"};
        g_m.values = new String[]{"Daily Sales Report", sales_today.getText(),
            ""+d_m.returnValue("select sum(total_bill) as `Sales` from tbl_transaction where tbl_transaction.`date`  like '%" + now.get(Calendar.YEAR) + "-" + ((now.get(Calendar.MONTH) + 1) < 10 ? "0"+(now.get(Calendar.MONTH) + 1):(now.get(Calendar.MONTH) + 1)) + "-" + (now.get(Calendar.DATE) < 10? "0"+now.get(Calendar.DATE):now.get(Calendar.DATE)) + "%' ", "sales"),
            ""+d_m.returnValue("select sum(total_capital) as `Sales` from tbl_transaction where tbl_transaction.`date`  like '%" + now.get(Calendar.YEAR) + "-" + ((now.get(Calendar.MONTH) + 1) < 10 ? "0"+(now.get(Calendar.MONTH) + 1):(now.get(Calendar.MONTH) + 1)) + "-" + (now.get(Calendar.DATE) < 10? "0"+now.get(Calendar.DATE):now.get(Calendar.DATE)) + "%' ", "sales")};
        g_m.PrintReport("display", "C:\\Users\\Public\\Documents\\Penton_POS_Reports\\sales_report.jrxml", "SELECT\n"
                + "     tbl_transaction.`transaction_id` AS tbl_transaction_transaction_id,\n"
                + "     tbl_transaction.`receipt_no` AS tbl_transaction_receipt_no,\n"
                + "     tbl_transaction.`total_bill` AS tbl_transaction_total_bill,\n"
                + "     tbl_transaction.`total_capital` AS tbl_transaction_total_capital,\n"
                + "     tbl_transaction.`cash` AS tbl_transaction_cash,\n"
                + "     tbl_transaction.`date` AS tbl_transaction_date,\n"
                + "     tbl_transaction.`employee_id` AS tbl_transaction_employee_id,\n"
                + "     tbl_users.`Address` AS tbl_users_Address,\n"
                + "     tbl_users.`Contact` AS tbl_users_Contact,\n"
                + "     tbl_users.`Name` AS tbl_users_Name\n"
                + "FROM\n"
                + "     `tbl_users` tbl_users INNER JOIN `tbl_transaction` tbl_transaction ON tbl_users.`user_id` = tbl_transaction.`employee_id`  where tbl_transaction.`date`  like '%" + now.get(Calendar.YEAR) + "-" + ((now.get(Calendar.MONTH) + 1) < 10 ? "0"+(now.get(Calendar.MONTH) + 1):(now.get(Calendar.MONTH) + 1)) + "-" + (now.get(Calendar.DATE) < 10? "0"+now.get(Calendar.DATE):now.get(Calendar.DATE)) + "%'");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        g_m.elements = new String[]{"reportType", "Total","t_bill","t_capital"};
        g_m.values = new String[]{"Sales Report Summary", sales_total.getText(),d_m.returnValue("select sum(total_bill) as `Sales` from tbl_transaction ", "sales"),
            d_m.returnValue("select sum(total_capital) as `Sales` from tbl_transaction ", "sales")};
        g_m.PrintReport("display", "C:\\Users\\Public\\Documents\\Penton_POS_Reports\\sales_report.jrxml", "SELECT\n"
                + "     tbl_transaction.`transaction_id` AS tbl_transaction_transaction_id,\n"
                + "     tbl_transaction.`receipt_no` AS tbl_transaction_receipt_no,\n"
                + "     tbl_transaction.`total_bill` AS tbl_transaction_total_bill,\n"
                + "     tbl_transaction.`total_capital` AS tbl_transaction_total_capital,\n"
                + "     tbl_transaction.`cash` AS tbl_transaction_cash,\n"
                + "     tbl_transaction.`date` AS tbl_transaction_date,\n"
                + "     tbl_transaction.`employee_id` AS tbl_transaction_employee_id,\n"
                + "     tbl_users.`Address` AS tbl_users_Address,\n"
                + "     tbl_users.`Contact` AS tbl_users_Contact,\n"
                + "     tbl_users.`Name` AS tbl_users_Name\n"
                + "FROM\n"
                + "     `tbl_users` tbl_users INNER JOIN `tbl_transaction` tbl_transaction ON tbl_users.`user_id` = tbl_transaction.`employee_id` ");
    }//GEN-LAST:event_jButton6ActionPerformed
    boolean add_dist = false;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        g_m.ChangePanel(cont, pnl_settings);
        lbl_panel.setText("Current Panel:  Change System Settings and Account Settings");
        add_dist = true;
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        if (tbl_inventory.getSelectedRow() > -1) {
            new Frm_batches("" + tbl_inventory.getValueAt(tbl_inventory.getSelectedRow(), 0)).setVisible(true);
        } else {
            g_m.Error_Message("Product infor selection error!", "Please select item info from the table.");
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new Frm_entities1("Add New Sold By Value", 1).setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton7FocusGained
        d_m.FillCombo(cmbSold, "Select * from tbl_sold_by", "sold_type");
    }//GEN-LAST:event_jButton7FocusGained

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if (!g_m.areEmptyFields(new JTextField[]{dist_name1, dist_number1, dist_email1}) && g_m.Confirm("Update store settings confirmation", "Are you sure you want to update the store settings?")) {
            d_m.ExeStatement("update tbl_settings set shopname = '" + dist_name1.getText() + "',owner = '" + dist_number1.getText() + "',address = '" + dist_email1.getText() + "' ", "Success! Store info is updated.");
            FillSettings();
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void txtSKUCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSKUCaretUpdate

    }//GEN-LAST:event_txtSKUCaretUpdate

    private void txtPackCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPackCaretUpdate

    }//GEN-LAST:event_txtPackCaretUpdate

    private void txtSKUKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSKUKeyReleased
        try {
            if (Double.valueOf(txtSKU.getText()) <= Double.valueOf(txtOrigPrice.getText()) && txtOrigPrice.getText().length() == txtSKU.getText().length()) {
                g_m.Error_Message("Input Error!", "Please enter price greater than the original price.");
                txtSKU.setText("");
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_txtSKUKeyReleased

    private void txtPackKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPackKeyReleased
        try {
            if (Double.valueOf(txtPack.getText()) <= Double.valueOf(txtOrigPrice.getText()) && txtOrigPrice.getText().length() == txtPack.getText().length()) {
                g_m.Error_Message("Input Error!", "Please enter price greater than the original price.");
                txtPack.setText("");
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_txtPackKeyReleased

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
         if (tbl_inventory.getSelectedRow() > -1) {
             new Frm_Update_Item(tbl_inventory.getValueAt(tbl_inventory.getSelectedRow(),0).toString()).setVisible(true);
         }else
             g_m.Error_Message("Product infor selection error!", "Please select item info from the table.");
    }//GEN-LAST:event_btn_updateActionPerformed

    private void txtPack1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPack1CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPack1CaretUpdate

    private void txtPack1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPack1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPack1KeyReleased

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Sales;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox cmbCategory;
    private javax.swing.JComboBox cmbDistributor;
    private javax.swing.JComboBox cmbSold;
    private javax.swing.JPanel cont;
    private javax.swing.JLabel critical;
    private javax.swing.JLabel current_date_time;
    private javax.swing.JButton dashboard;
    private javax.swing.JTextField dist_email;
    private javax.swing.JTextField dist_email1;
    private javax.swing.JTextField dist_name;
    private javax.swing.JTextField dist_name1;
    private javax.swing.JTextField dist_number;
    private javax.swing.JTextField dist_number1;
    private de.wannawork.jcalendar.JCalendarComboBox exp_date;
    private javax.swing.JPanel header;
    private javax.swing.JTextField inv_search;
    private javax.swing.JButton inventory;
    private javax.swing.JTextField item_searchProd;
    private javax.swing.JLabel items;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lbl_address;
    private javax.swing.JLabel lbl_owner;
    private javax.swing.JLabel lbl_panel;
    private javax.swing.JLabel lbl_store_name;
    private javax.swing.JLabel lbl_time;
    private javax.swing.JButton logout;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel pn_dashboard;
    private javax.swing.JPanel pnl_inventory;
    private javax.swing.JPanel pnl_item;
    private javax.swing.JPanel pnl_sales;
    private javax.swing.JPanel pnl_settings;
    private javax.swing.JButton product;
    private javax.swing.JLabel sales;
    private javax.swing.JLabel salesTotal;
    private javax.swing.JTextField sales_today;
    private javax.swing.JTextField sales_total;
    private javax.swing.JButton settings;
    private javax.swing.JLabel stock;
    private javax.swing.JTable tbl_accounts;
    private javax.swing.JTable tbl_distributors;
    public static javax.swing.JTable tbl_inventory;
    private javax.swing.JTable tbl_items;
    private javax.swing.JTable tbl_logs;
    private javax.swing.JTable tbl_sales;
    private javax.swing.JFormattedTextField txtCriticalLevel;
    private javax.swing.JFormattedTextField txtOrigPrice;
    private javax.swing.JFormattedTextField txtPack;
    private javax.swing.JFormattedTextField txtPack1;
    private javax.swing.JTextField txtQty1;
    private javax.swing.JTextField txtQty2;
    private javax.swing.JFormattedTextField txtSKU;
    private javax.swing.JTextField txtSKURef;
    private javax.swing.JTextField txtbarcode;
    private javax.swing.JTextField txtdescription;
    private javax.swing.JTextField txtproductName;
    // End of variables declaration//GEN-END:variables

    void ChangeColor(JButton[] btn, JButton bt) {
        int row = 0;
        for (JButton b : btn) {
            b.setBackground(new java.awt.Color(153,51,255));
            b.setForeground(Color.WHITE);
            b.setFont(new java.awt.Font("Segoe UI Light", 0, 22));
        }
        bt.setBackground(new java.awt.Color(102,0,153));
        bt.setFont(new java.awt.Font("Century Gothic", 1, 22));
    }
}
