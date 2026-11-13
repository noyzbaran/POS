/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import CONTROLLER.Frm_Cashier;
import VIEWER.Frm_Dashboard;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class login_methods extends db_methods {

    db_methods d_m = new db_methods();
    gen_methods g_m = new gen_methods();
    gen_objects g_o = new gen_objects();
    public String user_type;

    public Boolean checkAccount(String username, String password,JFrame frm) {
        Boolean res = false;
        try {
            ArrayList<String> vals = d_m.returnValues("select * from tbl_users where username = '" + username + "' and password = '" + password + "' ", new String[]{"user_id", "privilege", "Name"});
            if (!vals.get(0).toString().isEmpty() && !vals.get(1).toString().isEmpty()) {
                if (vals.get(1).toString().equalsIgnoreCase("admin")) {
                    new Frm_Dashboard().setVisible(true);
                } else {
                    new Frm_Cashier(vals.get(2).toString()).setVisible(true);
                }
                frm.dispose();
                
            }else
                g_m.Error_Message("Accoount Error", "Unknown Account!");
            gen_objects.CurrentUser = vals.get(2).toString();
            System.out.println(vals.get(2).toString());
        } catch (Exception e) {
            g_m.Error_Message("Accoount Error", "Unknown Account!");
        }
        return res;
    }

}
