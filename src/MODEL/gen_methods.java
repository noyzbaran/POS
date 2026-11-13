/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import CONTROLLER.Frm_confirm_delete;
import de.wannawork.jcalendar.JCalendarComboBox;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class gen_methods {

    public boolean confirm_delete = false;

    public void ChangePanel(JPanel cont, JPanel pnl) {
        cont.removeAll();
        cont.add(pnl);
        cont.repaint();
        cont.revalidate();
    }

    public void Message(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public Boolean areEmptyFields(JTextField[] fields) {
        Boolean res = true;
        for (JTextField f : fields) {
            res = f.getText().isEmpty() || f.getText().length() == 0;
            if (res) {
                break;
            }
        }
        for (JTextField f : fields) {
            res = f.getText().isEmpty() || f.getText().length() == 0;
            if (res) {
                f.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            } else {
                f.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            }
        }
        return res;
    }

    public Boolean areEmptyFields(JComboBox[] fields) {
        Boolean res = true;
        for (JComboBox c : fields) {
            res = c.getSelectedIndex() == 0;
            if (res) {
                break;
            }
        }
        return res;
    }

    public void Error_Message(String title, String msg) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    public void ClearFields(JTextField[] fields) {
        for (JTextField f : fields) {
            f.setText("");
        }
    }

    public void ClearCombo(JComboBox[] cmb) {
        for (JComboBox c : cmb) {
            c.setSelectedIndex(0);
        }
    }

    public String returnDate(JCalendarComboBox date, String format) {
        gen_objects g_o = new gen_objects();
        String res = new String();
        if (date.getDate() != null) {
            g_o.date_formater = new java.text.SimpleDateFormat(format);
            res = g_o.date_formater.format(date.getDate());
        }
        return res;
    }

    public Boolean Confirm(String title, String content) {
        return JOptionPane.showConfirmDialog(null, content, title, JOptionPane.YES_NO_OPTION) == 0;
    }

    public static Map map = new HashMap();

    public static void PrintReport(String print, String location, String sql) {
        try {
            JasperDesign jd = JRXmlLoader.load(location);  //String sql = "SELECT * FROM enrollee INNER JOIN sections,subjects,sis where enrollee.sectionID=sections.sectionID && sections.SubjectID=subjects.Subject_ID  && sis.Sis_ID=enrollee.StudentName &&  subjects.SubjectCode='"+jComboBox1.getSelectedItem()+"' && sections.SectionName=(select SectionsID from register where SectionsName='"+jComboBox4.getSelectedItem()+"') && enrollee.year='"+jComboBox3.getSelectedItem()+"' && enrollee.Semester='"+jComboBox2.getSelectedItem()+"' && FullName like '"+jTextField3.getText()+"%' ";
            FileInputStream fis = new FileInputStream(location);
            //BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);

            if (!(elements[0].equals(""))) {
                returnHashMaps(elements, values);
            }
//            
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);

            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp;

            if (!(elements[0].equals(""))) {
                jp = JasperFillManager.fillReport(jr, map, db_methods.con);
            } else {
                jp = JasperFillManager.fillReport(jr, null, db_methods.con);
            }

            if (print.equalsIgnoreCase("print")) {
                JasperPrintManager.printReport(jp, false);
            } else {
                JasperViewer.viewReport(jp, false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static int paramLength;
    public static String[] elements = new String[paramLength];
    public static String[] values = new String[paramLength];

    public static void returnHashMaps(String[] elements, String[] values) {
        try {
            for (int row = 0; row < elements.length; row++) {
                map.put(elements[row], values[row]);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public boolean confirm_delete() {
        boolean res = false;
        new Frm_confirm_delete(res, null, 0).setVisible(true);
        res = confirm_delete;
        return res;
    }
    
    
    public static String returnDouble(String text){
       // DecimalFormat format =  new DecimalFormat("0.##");
        text = text.replace(",", "");
        return (text);
    }
//    gen_methods gen = new gen_methods();
//    public static void main(String[] args){
//        System.out.println(returnDouble("1,295"));
//    }
}
