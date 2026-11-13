/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.cashier_methods;
import MODEL.db_methods;
import MODEL.gen_methods;
import MODEL.gen_objects;
import VIEWER.Frm_new_barcode;
import VIEWER.Frm_transaction_summary;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class Frm_Cashier extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Cashier
     */
    public Frm_Cashier(String user) {
        initComponents();
        setLocationRelativeTo(null);
        java.awt.Toolkit tk = this.getToolkit();
        setSize(tk.getScreenSize());
        lbl_prompt.setVisible(false);
        time = new javax.swing.Timer(1000, (ActionListener) new Frm_Cashier.ClockListener());
        time.start();
        txtbarcode.requestFocus();
        lbl_user.setText("Current User:  " + user);
        cashier_name = user;
        lbl_address.setText(d_m.returnValue("Select address from tbl_settings", "address"));
        lbl_store.setText(d_m.returnValue("Select shopname from tbl_settings", "shopname") + " Point of Sales (P.O.S)");

        g_o.storeName = d_m.returnValue("select shopname from tbl_settings", "shopname");
        g_o.contact = "";
        g_o.owner = d_m.returnValue("select owner from tbl_settings", "owner");
        g_o.address = d_m.returnValue("select address from tbl_settings", "address");
        g_o.CurrentUser = user;
        //g_m.Message(user);
    }
    javax.swing.Timer time;
    String cashier_name;
    cashier_methods c_m = new cashier_methods();
    db_methods d_m = new db_methods();
    gen_methods g_m = new gen_methods();

    String price_type = "markupretailprice";
    String rawID;
    String hour;
    Calendar now = Calendar.getInstance();

    private void ChangeQuantityPrice(KeyEvent evt) {
        try {
            if (tbl_items.getSelectedRow() != -1 || evt.getKeyCode() == KeyEvent.VK_ENTER) {
                tbl_items.setValueAt("" + (Double.valueOf(tbl_items.getValueAt(tbl_items.getSelectedRow(), 3).toString()) * Double.valueOf(tbl_items.getValueAt(tbl_items.getSelectedRow(), 4).toString())), tbl_items.getSelectedRow(), 5);
            }
            c_m.ChangePrice(tbl_items, 4, max_whole_quantity, 3);
            txtTotalBill.setText("" + c_m.returnTotal(tbl_items, tbl_items.getColumnCount() - 1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    class ClockListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Calendar now = Calendar.getInstance();
            current_date_time.setText("Date and Time: " + now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.DATE));
            hour = "" + (now.get(Calendar.HOUR_OF_DAY) > 12 ? now.get(Calendar.HOUR_OF_DAY) - 12 : now.get(Calendar.HOUR_OF_DAY));
            String min = now.get(Calendar.MINUTE) + "";
            String sec = (now.get(Calendar.SECOND)) + "";
            current_date_time.setText(current_date_time.getText() + " " + hour + ":" + min + ":" + sec + " " + (now.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
            // current_date_time.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_store = new javax.swing.JLabel();
        lbl_address = new javax.swing.JLabel();
        current_date_time = new javax.swing.JLabel();
        lbl_user = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_items = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtbarcode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotalBill = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCash = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtChange = new javax.swing.JTextField();
        lbl_prompt = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 0, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_store.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbl_store.setForeground(new java.awt.Color(255, 255, 255));
        lbl_store.setText("Penton Store");

        lbl_address.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_address.setForeground(new java.awt.Color(255, 255, 255));
        lbl_address.setText("Kalabugao, asdasd");

        current_date_time.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        current_date_time.setForeground(new java.awt.Color(255, 255, 255));
        current_date_time.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        current_date_time.setText("Current Date and Time");

        lbl_user.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_user.setForeground(new java.awt.Color(255, 255, 255));
        lbl_user.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_user.setText("Current Account:  Employee1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_address, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_store, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(current_date_time, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lbl_store, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_user)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(current_date_time))
                .addContainerGap())
        );

        tbl_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item_count", "Barcode", "Product Name", "Price", "Quantity", "Sub-total"
            }
        ));
        tbl_items.setRowHeight(25);
        tbl_items.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbl_itemsFocusGained(evt);
            }
        });
        tbl_items.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_itemsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_itemsKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbl_itemsKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_items);
        if (tbl_items.getColumnModel().getColumnCount() > 0) {
            tbl_items.getColumnModel().getColumn(0).setMinWidth(75);
            tbl_items.getColumnModel().getColumn(0).setMaxWidth(75);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Purchased Items List");

        txtbarcode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtbarcode.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtbarcodeCaretUpdate(evt);
            }
        });
        txtbarcode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtbarcodeFocusGained(evt);
            }
        });
        txtbarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbarcodeKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Barcode/SKU (Scan Product)");

        jLabel3.setBackground(new java.awt.Color(0, 204, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Total Items Purchased");
        jLabel3.setOpaque(true);

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 2));
        txtTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTotalFocusGained(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 102, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total Bill");
        jLabel4.setOpaque(true);

        txtTotalBill.setEditable(false);
        txtTotalBill.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalBill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotalBill.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 2));

        jLabel5.setBackground(new java.awt.Color(255, 204, 51));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cash");
        jLabel5.setOpaque(true);

        txtCash.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCash.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51), 2));
        txtCash.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCashCaretUpdate(evt);
            }
        });
        txtCash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCashKeyPressed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 51, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Change");
        jLabel6.setOpaque(true);

        txtChange.setEditable(false);
        txtChange.setBackground(new java.awt.Color(255, 255, 255));
        txtChange.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtChange.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtChange.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 2));

        lbl_prompt.setBackground(new java.awt.Color(255, 51, 51));
        lbl_prompt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_prompt.setForeground(new java.awt.Color(255, 255, 255));
        lbl_prompt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_prompt.setText("Item not found in the database!");
        lbl_prompt.setOpaque(true);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Save Transaction [vk_ENTER]");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Shortcut Keys:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("Search Item [vk_Insert]");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("Remove Item [vk_Delete]");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("Save Transaction [vk_Enter]");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("Change Quantity [vk_F11]");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 0, 0));
        jLabel14.setText("Enter Cash [vk_F12]");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setText("Log out [vk_Esc]");

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_INSERT, 0));
        jMenuItem1.setText("Search Item");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Remove Item");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        jMenuItem5.setText("Scan Item");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        jMenuItem4.setText("Change Quantity");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setText("Print Daily Sales Report");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText("Re-Print Previous Receipt");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem3.setText("Enter Cash");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Change Price to Whole Sale");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Change Price to Retail");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Settings");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem6.setText("Logout");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtbarcode, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTotalBill)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)))
                            .addComponent(txtCash)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                            .addComponent(txtChange)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                            .addComponent(lbl_prompt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_prompt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtTotalBill, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtCash, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtChange, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbarcodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbarcodeFocusGained
        if (txtbarcode.getText().length() > 0) {
            String chk = d_m.returnValue("select barcode from tbl_product where barcode = '" + txtbarcode.getText() + "'", "barcode");
            if (chk.isEmpty()) {
                g_m.Error_Message("Error!", "Item not Found!");
            }
        }
    }//GEN-LAST:event_txtbarcodeFocusGained
    double max_whole_quantity = 6;
    private void txtbarcodeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtbarcodeCaretUpdate
        String chk = d_m.returnValue("select barcode from tbl_product where barcode = '" + txtbarcode.getText() + "'", "barcode");
        String val = txtbarcode.getText();
        if (!txtbarcode.getText().isEmpty()) {
            if (!chk.isEmpty()) {
                max_whole_quantity = Double.valueOf(d_m.returnValue("select WholeSaleQuantity from tbl_product where barcode = '" + txtbarcode.getText() + "'", "WholeSaleQuantity"));
                if (c_m.quantity >= max_whole_quantity) {
                    price_type = "MarkUpWholeSalePrice";
                }
                c_m.TransactItem(tbl_items, val, new String[]{"barcode", "product_name", price_type});
                txtTotal.requestFocus();
                txtTotal.setText("" + tbl_items.getRowCount());
                java.text.DecimalFormat formater = new java.text.DecimalFormat("#.00");
                txtTotalBill.setText("" + formater.format(c_m.returnTotal(tbl_items, tbl_items.getColumnCount() - 1)));
                c_m.ChangePrice(tbl_items, 4, max_whole_quantity, 3);
            }
        }
        lbl_prompt.setVisible(txtbarcode.getText().length() > 0);

//        txtTotalBill.setText("" + c_m.returnTotal(tbl_items, tbl_items.getColumnCount() - 1));
//        txtTotal.setText(tbl_items.getRowCount() + "");
//        c_m.FillCounter(tbl_items);
    }//GEN-LAST:event_txtbarcodeCaretUpdate

    private void txtTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusGained
        String chk = d_m.returnValue("select barcode from tbl_product where barcode = '" + txtbarcode.getText() + "'", "barcode");
        if (chk.isEmpty()) {
            g_m.Error_Message("Error!", "Item not Found!");
            txtbarcode.setText("");
        }
        txtbarcode.setText(new String(""));
        txtbarcode.requestFocus();
        c_m.quantity = 1;
    }//GEN-LAST:event_txtTotalFocusGained

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new Frm_new_barcode(txtbarcode, "Select Item", 2).setVisible(true);
        txtbarcode.setText(new String(""));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtbarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbarcodeKeyPressed
        //if (evt.getKeyCode() == KeyEvent.VK_INSERT) {
//            new Frm_new_barcode(txtbarcode, "Select Item", 2).setVisible(true);
//            txtbarcode.setText(new String(""));
        //}
    }//GEN-LAST:event_txtbarcodeKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        DefaultTableModel tab = (DefaultTableModel) tbl_items.getModel();
        if (g_m.Confirm("Delete Item Confirmation", "Are you sure you want to remove the selected item in the list?")) {
            new Frm_confirm_delete(false, tbl_items, tbl_items.getSelectedRow()).setVisible(true);
//            if(g_m.confirm_delete){
//                tab.removeRow(tbl_items.getSelectedRow());
            txtTotalBill.setText("" + c_m.returnTotal(tbl_items, tbl_items.getColumnCount() - 1));
            txtTotal.setText(tbl_items.getRowCount() + "");
            c_m.FillCounter(tbl_items);
//            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void tbl_itemsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_itemsKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            DefaultTableModel tab = (DefaultTableModel) tbl_items.getModel();
            if (g_m.Confirm("Delete Item Confirmation", "Are you sure you want to remove the selected item in the list?")) {
                new Frm_confirm_delete(false, tbl_items, tbl_items.getSelectedRow()).setVisible(true);
                txtTotalBill.setText("" + c_m.returnTotal(tbl_items, tbl_items.getColumnCount() - 1));
                txtTotal.setText(tbl_items.getRowCount() + "");
                c_m.FillCounter(tbl_items);
            }
        }
        ChangeQuantityPrice(evt);
    }//GEN-LAST:event_tbl_itemsKeyPressed

    private void txtCashCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCashCaretUpdate
        if (!txtTotalBill.getText().isEmpty() && !txtCash.getText().isEmpty()) {
            txtChange.setText("" + (Double.valueOf(txtCash.getText()) - Double.valueOf(txtTotalBill.getText())));
            jButton1.setEnabled((Double.valueOf(txtCash.getText()) >= Double.valueOf(txtTotalBill.getText())));
        }
    }//GEN-LAST:event_txtCashCaretUpdate

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        txtCash.requestFocus();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setEnabled(false);
        if (Double.valueOf(txtCash.getText()) >= Double.valueOf(txtTotalBill.getText())) {
            new Frm_transaction_summary(lbl_store.getText(), txtTotalBill.getText(), txtCash.getText(), txtChange.getText(), txtbarcode).setVisible(true);
            save_transaction();
            price_type = "MarkUpRetailPrice";
            jButton1.setEnabled(false);
        } else {
            g_m.Error_Message("Invalid input!", "Please enter proper amount of money/cash.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            c_m.quantity = Double.valueOf(javax.swing.JOptionPane.showInputDialog(null, "Enter new quantity for this item:"));
        } catch (Exception e) {
            System.out.println(e);
            c_m.quantity = 1;
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        time.start();
    }//GEN-LAST:event_formWindowActivated

    private void txtCashKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCashKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (Double.valueOf(txtCash.getText()) >= Double.valueOf(txtTotalBill.getText()) && g_m.Confirm("Purchase Confirmation", "Are you sure you want to save the current transaction?")) {
                new Frm_transaction_summary(lbl_store.getText(), txtTotalBill.getText(), txtCash.getText(), txtChange.getText(), txtbarcode).setVisible(true);
                save_transaction();
                //g_m.Message("");
                price_type = "MarkUpRetailPrice";
                jButton1.setEnabled(false);
            } else {
                g_m.Error_Message("Invalid input!", "Please enter proper amount of money/cash.");
            }
        }
    }//GEN-LAST:event_txtCashKeyPressed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        txtbarcode.requestFocus();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if (g_m.Confirm("Exit Confirmation", "Are you sure you want to exit?")) {
            new Frm_Login().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if (g_m.Confirm("Price Alteration Confirmation", "Are you sure you want to alter the price from retail to wholesale for this item?")) {
            price_type = "MarkUpWholeSalePrice";
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void tbl_itemsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_itemsKeyTyped
        ChangeQuantityPrice(evt);
    }//GEN-LAST:event_tbl_itemsKeyTyped

    private void tbl_itemsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_itemsKeyReleased
        ChangeQuantityPrice(evt);
    }//GEN-LAST:event_tbl_itemsKeyReleased

    private void tbl_itemsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbl_itemsFocusGained
//        System.out.println("test!");
        txtTotalBill.setText("" + c_m.returnTotal(tbl_items, tbl_items.getColumnCount() - 1));
        txtTotal.setText(tbl_items.getRowCount() + "");
    }//GEN-LAST:event_tbl_itemsFocusGained

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if (g_m.Confirm("Price Alteration Confirmation", "Are you sure you want to alter the price from wholesale to retail for this item or for the entire transaction?")) {
            price_type = "MarkUpRetailPrice";
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Calendar now = Calendar.getInstance();
        g_m.elements = new String[]{"reportType", "Total", "t_bill", "t_capital"};
        g_m.values = new String[]{"Daily Sales Report", d_m.returnValue("select sum((total_bill-total_capital)) as `Sales` from tbl_transaction where date like '%" + now.get(Calendar.YEAR) + "-" + ((now.get(Calendar.MONTH) + 1) < 10 ? "0" + (now.get(Calendar.MONTH) + 1) : (now.get(Calendar.MONTH) + 1)) + "-" + (now.get(Calendar.DATE) < 10 ? "0" + now.get(Calendar.DATE) : now.get(Calendar.DATE)) + "%' and employee_id = (select user_id from tbl_users where name = '" + g_o.CurrentUser + "')", "sales"),
            "" + d_m.returnValue("select sum(total_bill) as `Sales` from tbl_transaction where tbl_transaction.`date`  like '%" + now.get(Calendar.YEAR) + "-" + ((now.get(Calendar.MONTH) + 1) < 10 ? "0" + (now.get(Calendar.MONTH) + 1) : (now.get(Calendar.MONTH) + 1)) + "-" + (now.get(Calendar.DATE) < 10 ? "0" + now.get(Calendar.DATE) : now.get(Calendar.DATE)) + "%' and employee_id = (select user_id from tbl_users where name = '" + g_o.CurrentUser + "')", "sales"),
            "" + d_m.returnValue("select sum(total_capital) as `Sales` from tbl_transaction where tbl_transaction.`date`  like '%" + now.get(Calendar.YEAR) + "-" + ((now.get(Calendar.MONTH) + 1) < 10 ? "0" + (now.get(Calendar.MONTH) + 1) : (now.get(Calendar.MONTH) + 1)) + "-" + (now.get(Calendar.DATE) < 10 ? "0" + now.get(Calendar.DATE) : now.get(Calendar.DATE)) + "%' and employee_id = (select user_id from tbl_users where name = '" + g_o.CurrentUser + "')", "sales")};
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
                + "     `tbl_users` tbl_users INNER JOIN `tbl_transaction` tbl_transaction ON tbl_users.`user_id` = tbl_transaction.`employee_id`  where tbl_transaction.`date`  like '%" + now.get(Calendar.YEAR) + "-" + ((now.get(Calendar.MONTH) + 1) < 10 ? "0" + (now.get(Calendar.MONTH) + 1) : (now.get(Calendar.MONTH) + 1)) + "-" + (now.get(Calendar.DATE) < 10 ? "0" + now.get(Calendar.DATE) : now.get(Calendar.DATE)) + "%' and employee_id = (select user_id from tbl_users where name = '" + g_o.CurrentUser + "')");
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if (g_m.Confirm("Print Receipt", "Are you sure you want to re-print previous receipt?")) {
            g_m.elements = new String[]{"Employee", "Change", "storeName", "owner", "address"};
            g_m.values = new String[]{cashier_name, Change, g_o.storeName, g_o.owner, g_o.address};
            g_m.PrintReport("print", "C:\\Users\\Public\\Documents\\Penton_POS_Reports\\report1.jrxml", "SELECT\n"
                    + "     *,\n"
                    + "     tbl_product.`Barcode` AS tbl_product_Barcode,\n"
                    + "     tbl_product.`MarkUpRetailPrice` AS tbl_product_MarkUpRetailPrice,\n"
                    + "     tbl_product.`MarkUpWholeSalePrice` AS tbl_product_MarkUpWholeSalePrice,\n"
                    + "     tbl_transaction.`total_bill` AS tbl_transaction_total_bill,\n"
                    + "     tbl_transaction.`receipt_no` AS tbl_transaction_receipt_no,\n"
                    + "     tbl_transaction.`total_capital` AS tbl_transaction_total_capital,\n"
                    + "     tbl_transaction.`cash` AS tbl_transaction_cash,\n"
                    + "     tbl_transaction.`date` AS tbl_transaction_date,\n"
                    + "     tbl_stockout.price_per_item as `Item_price` "
                    + "FROM\n"
                    + "     `tbl_product` tbl_product INNER JOIN `tbl_stockout` tbl_stockout ON tbl_product.`Barcode` = tbl_stockout.`barcode`\n"
                    + "     INNER JOIN `tbl_transaction` tbl_transaction ON tbl_stockout.`receipt_no` = tbl_transaction.`receipt_no` where tbl_stockout.`receipt_no` = '" + prev_id + "' ");
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Cashier("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel current_date_time;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_address;
    private javax.swing.JLabel lbl_prompt;
    private javax.swing.JLabel lbl_store;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JTable tbl_items;
    private javax.swing.JTextField txtCash;
    private javax.swing.JTextField txtChange;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalBill;
    private javax.swing.JTextField txtbarcode;
    // End of variables declaration//GEN-END:variables
    String TotalBill, TotalCash, Change;
    String prev_id;

    void save_transaction() {
        Double[] res = new Double[tbl_items.getRowCount()];
        Double total = new Double(0.0);
        for (int row = 0; row < res.length; row++) {
            res[row] = Double.valueOf(d_m.returnValue("Select unit_price from tbl_product where barcode = '" + tbl_items.getValueAt(row, 1) + "'", "unit_price")) * Double.valueOf(tbl_items.getValueAt(row, 4).toString());
        }
        for (Double rs : res) {
            total += rs;
        }
        java.text.DecimalFormat formater = new java.text.DecimalFormat("#.00");
        System.out.println("" + formater.format(total));
        Calendar now = Calendar.getInstance();
        rawID = "" + now.get(Calendar.YEAR) + (now.get(Calendar.MONTH) + 1) + now.get(Calendar.DATE) + now.get(Calendar.HOUR_OF_DAY) + now.get(Calendar.HOUR_OF_DAY) + now.get(Calendar.MINUTE) + now.get(Calendar.SECOND) + d_m.returnValue("select transaction_id from tbl_transaction order by transaction_id", "transaction_id")+d_m.returnValue("select user_id from tbl_users where name = '" + cashier_name + "'", "user_id");
        
        //g_m.Message(cashier_name);
        //g_m.Message(d_m.returnValue("select user_id from tbl_users where name = '" + cashier_name + "'", "user_id"));
        c_m.SaveTransaction(rawID, txtTotalBill.getText(), "" + formater.format(total), txtCash.getText(), Integer.valueOf(d_m.returnValue("select user_id from tbl_users where name = '" + cashier_name + "'", "user_id")));
        
        c_m.SaveStockout(tbl_items, rawID);
        prev_id = rawID;
        TotalBill = txtTotalBill.getText();
        TotalCash = txtCash.getText();
        Change = txtChange.getText();
        g_m.elements = new String[]{"Employee", "Change", "storeName", "owner", "address"};
        g_m.values = new String[]{cashier_name, txtChange.getText(), g_o.storeName, g_o.owner, g_o.address};
        g_m.PrintReport("print", "C:\\Users\\Public\\Documents\\Penton_POS_Reports\\report1.jrxml", "SELECT\n"
                + "     *,\n"
                + "     tbl_product.`Barcode` AS tbl_product_Barcode,\n"
                + "     tbl_product.`MarkUpRetailPrice` AS tbl_product_MarkUpRetailPrice,\n"
                + "     tbl_product.`MarkUpWholeSalePrice` AS tbl_product_MarkUpWholeSalePrice,\n"
                + "     tbl_transaction.`total_bill` AS tbl_transaction_total_bill,\n"
                + "     tbl_transaction.`receipt_no` AS tbl_transaction_receipt_no,\n"
                + "     tbl_transaction.`total_capital` AS tbl_transaction_total_capital,\n"
                + "     tbl_transaction.`cash` AS tbl_transaction_cash,\n"
                + "     tbl_transaction.`date` AS tbl_transaction_date,\n"
                + "     tbl_stockout.price_per_item as `Item_price` "
                + "FROM\n"
                + "     `tbl_product` tbl_product INNER JOIN `tbl_stockout` tbl_stockout ON tbl_product.`Barcode` = tbl_stockout.`barcode`\n"
                + "     INNER JOIN `tbl_transaction` tbl_transaction ON tbl_stockout.`receipt_no` = tbl_transaction.`receipt_no` where tbl_stockout.`receipt_no` = '" + rawID + "' ");
//        g_m.PrintReport("print", "C:\\Users\\Public\\Documents\\Penton_POS_Reports\\report1.jrxml", "SELECT\n"
//                + "     *,\n"
//                + "     tbl_product.`Barcode` AS tbl_product_Barcode,\n"
//                + "     tbl_product.`MarkUpRetailPrice` AS tbl_product_MarkUpRetailPrice,\n"
//                + "     tbl_product.`MarkUpWholeSalePrice` AS tbl_product_MarkUpWholeSalePrice,\n"
//                + "     tbl_transaction.`total_bill` AS tbl_transaction_total_bill,\n"
//                + "     tbl_transaction.`receipt_no` AS tbl_transaction_receipt_no,\n"
//                + "     tbl_transaction.`total_capital` AS tbl_transaction_total_capital,\n"
//                + "     tbl_transaction.`cash` AS tbl_transaction_cash,\n"
//                + "     tbl_transaction.`date` AS tbl_transaction_date,\n"
//                + "     tbl_stockout.price_per_item as `Item_price` "
//                + "FROM\n"
//                + "     `tbl_product` tbl_product INNER JOIN `tbl_stockout` tbl_stockout ON tbl_product.`Barcode` = tbl_stockout.`barcode`\n"
//                + "     INNER JOIN `tbl_transaction` tbl_transaction ON tbl_stockout.`receipt_no` = tbl_transaction.`receipt_no` where tbl_stockout.`receipt_no` = '" + rawID + "' ");
        c_m.ClearFields(new JTextField[]{txtTotal, txtTotalBill, txtCash, txtChange});
        g_m.Message("Success! Transaction was successfully saved!");
    }
    gen_objects g_o = new gen_objects();
}
