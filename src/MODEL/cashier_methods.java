/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.ArrayList;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.PrinterName;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class cashier_methods extends db_methods {

    db_methods d_m = new db_methods();
    gen_methods g_m = new gen_methods();
    public double quantity = 1;

    public void TransactItem(JTable tbl, String value, String[] cols) {
        try {
            DefaultTableModel tab = (DefaultTableModel) tbl.getModel();
            ArrayList<String> values = d_m.returnValues("Select * from tbl_product where barcode = '" + value + "' ", cols);
            //if(!CheckExisting(tbl,values.get(0).toString(),quantity,(Double.valueOf(values.get(1).toString()) * quantity)))
            java.text.DecimalFormat formater = new java.text.DecimalFormat("#.00");
            if (!CheckExisting(tbl, value, quantity, (Double.valueOf(values.get(2).toString()) * quantity))) {
                tab.addRow(new Object[]{"", (Object) values.get(0), (Object) values.get(1), (Object) values.get(2), quantity, formater.format((Double.valueOf(values.get(2).toString()) * quantity))});
            }
            quantity = 1;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean CheckExisting(JTable tbl, String val1, Double val2, Double val3) {
        boolean res = false;
        for (int row = 0; row < tbl.getRowCount(); row++) {
            res = (tbl.getValueAt(row, 1).toString().equals(val1));
            if (res) {
                tbl.setValueAt(Double.valueOf(tbl.getValueAt(row, 4).toString()) + val2, row, 4);
                tbl.setValueAt(Double.valueOf(tbl.getValueAt(row, 5).toString()) + val3, row, 5);
                break;
            }
        }
        return res;
    }

    public Double returnTotal(JTable tbl, int col) {
        Double res = 0.0;
        for (int row = 0; row < tbl.getRowCount(); row++) {
            res += Double.valueOf(tbl.getValueAt(row, col).toString());
        }
        return res;
    }

    public void SaveTransaction(String rec, String total, String capital, String cash, int id) {
        try {
            d_m.ExeStatement("insert into tbl_transaction values (null,'" + rec + "','" + total + "','" + capital + "','" + cash + "',now(),'" + id + "') ", "");
            cashdrawerOpen();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void SaveStockout(JTable tbl, String id) {
        for (int r = 0; r < tbl.getRowCount(); r++) {
            d_m.ExeStatement("insert into tbl_stockout values ('" + id + "','" + tbl.getValueAt(r, 1) + "','" + tbl.getValueAt(r, 4) + "','"+tbl.getValueAt(r, 3)+"')", "");
        }
        DefaultTableModel tab = (DefaultTableModel) tbl.getModel();
        for (int r = tbl.getRowCount() - 1; r != -1; r--) {
            tab.removeRow(r);
        }
    }

    public void ClearFields(JTextField[] fields) {
        for (JTextField f : fields) {
            f.setText(new String(""));
        }
    }

    public void cashdrawerOpen() {

        byte[] open = {27, 112, 48, 55, 121};
// byte[] cutter = {29, 86,49};
        String printer = "EPSON TM-U220 Receipt";
        PrintServiceAttributeSet printserviceattributeset = new HashPrintServiceAttributeSet();
        printserviceattributeset.add(new PrinterName(printer, null));
        PrintService[] printservice = PrintServiceLookup.lookupPrintServices(null, printserviceattributeset);
        if (printservice.length != 1) {
            System.out.println("Printer not found");
        }
        PrintService pservice = printservice[0];
        DocPrintJob job = pservice.createPrintJob();
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(open, flavor, null);
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        try {
            job.print(doc, aset);
        } catch (PrintException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void cashdrawerOpen2() {
        
        byte[] open = {27, 112, 48, 55, 121};
//        byte[] cutter = {29, 86,49};
        String printer = "";
        PrintServiceAttributeSet printserviceattributeset = new HashPrintServiceAttributeSet();
        printserviceattributeset.add(new PrinterName(printer,null));
        PrintService[] printservice = PrintServiceLookup.lookupPrintServices(null, printserviceattributeset);
        if(printservice.length!=1){
            System.out.println("Printer not found");
        }
        PrintService pservice = printservice[0];
        DocPrintJob job = pservice.createPrintJob();
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(open,flavor,null);
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        try {
            job.print(doc, aset);
        } catch (PrintException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void ChangePrice(JTable tbl,int col,Double max,int colFinal){
        for(int r = 0; r < tbl.getRowCount();r++){
            if(Double.valueOf(tbl.getValueAt(r,col).toString()) >= max){
                tbl.setValueAt(d_m.returnValue("select markupwholesalePrice from tbl_product where barcode = '"+tbl.getValueAt(r,1)+"'", "markupWholeSalePrice"), r, colFinal);
                tbl.setValueAt( Double.valueOf(tbl.getValueAt(r,col).toString()) * Double.valueOf(tbl.getValueAt(r,colFinal).toString()) , r,tbl.getColumnCount()-1);
            }else{
                tbl.setValueAt(d_m.returnValue("select markupRetailPrice from tbl_product where barcode = '"+tbl.getValueAt(r,1)+"'", "markupRetailPrice"), r, colFinal);
                tbl.setValueAt( Double.valueOf(tbl.getValueAt(r,col).toString()) * Double.valueOf(tbl.getValueAt(r,colFinal).toString()) , r,tbl.getColumnCount()-1);
            }
        }
        FillCounter(tbl);
    }
    
    public void FillCounter(JTable tbl){
        for(int i = 0; i < tbl.getRowCount();i++)
            tbl.setValueAt((i+1), i, 0);
    }
    
    public void RemoveItem(JTable tbl,int row){
        DefaultTableModel tab = (DefaultTableModel) tbl.getModel();
        tab.removeRow(row);
    }
}
