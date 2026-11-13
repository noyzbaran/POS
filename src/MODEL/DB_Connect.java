/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODEL;
import java.sql.*;
public class DB_Connect {
    public static Connection connect(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
          //  con = DriverManager.getConnection("jdbc:mysql://192.168.254.253:3306/penton_pos","root","");
//            con = DriverManager.getConnection("jdbc:mysql://192.168.254.102:3306/penton_pos","root","");
//            con = DriverManager.getConnection("jdbc:mysql://192.168.1.102:3306/penton_pos","root","");
//            con = DriverManager.getConnection("jdbc:mysql://192.168.100.102:3306/penton_pos","root","");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/penton_pos","root","");
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
    
    public static void main(String[] args){
        Connection test = connect();
        if(test!=null)
            System.out.println("Success!");
    }
}
