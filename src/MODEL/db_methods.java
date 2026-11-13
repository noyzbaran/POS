/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import static MODEL.gen_methods.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class db_methods extends DB_Connect {

    public static Connection con = connect();
    public static Statement smt = null;
    public static ResultSet rs = null;

    // sinlge line query execution method
    public static void ExeStatement(String sql, String message) {
        gen_methods g_m = new gen_methods();
        try {
            smt = con.createStatement();
            smt.execute(sql);
            if (!message.isEmpty()) {
                g_m.Message(message);
            }
            smt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // method to fetch data from db_table to java_table
    public static void FillTable(JTable tbl, String sql) {
        try {
            smt = con.createStatement();
            rs = smt.executeQuery(sql);
            tbl.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            smt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String returnValue(String sql, String col) {
        String val = new String();
        try {
            smt = con.createStatement();
            rs = smt.executeQuery(sql);
            if (rs.next()) {
                val = rs.getString(col);
            }
            rs.close();
            smt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return val;
    }

    public static void FillCombo(JComboBox cmb, String sql, String col) {
        cmb.removeAllItems();
        cmb.addItem("- Select Value -");
        try {
            smt = con.createStatement();
            rs = smt.executeQuery(sql);
            while (rs.next()) {
                cmb.addItem(rs.getString(col));
            }
            rs.close();
            smt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<String> returnValues(String sql, String[] cols) {
        ArrayList<String> res = new ArrayList<String>();
        try {
            for (String f : cols) {
                smt = con.createStatement();
                rs = smt.executeQuery(sql);
                if (rs.next()) {
                    res.add(rs.getString(f));
                }
            }
            rs.close();
            smt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    public void FillFields(JTextField[] fields, ArrayList<String> val) {
        try {
            for (int i = 0; i < fields.length; i++) {
                if (val.get(i) != null) {
                    fields[i].setText(val.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void FillFields(JComboBox[] fields, ArrayList<String> val) {
        try {
            for (int i = 0; i < fields.length; i++) {
                if (val.get(i) != null) {
                    fields[i].setSelectedItem(val.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
