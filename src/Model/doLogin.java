/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import GUI.home;
import GUI.login;
import db.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;

/**
 *
 * @author DELL
 */
public class doLogin {

    static Logger log = Logger.getLogger(doLogin.class.getName());
    Connection conn;

    public doLogin() {
        conn = db.dbConnection.getConnection();
    }

    public String doLogin(String username, String password) {
        String msg = "";
        String query = "SELECT * FROM shop_admins join staff_job_role on shop_admins.id_role=staff_job_role.id_role  WHERE username =? AND password=?";
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, username);
            psm.setString(2, password);
            ResultSet rs = psm.executeQuery();
            String typedpw = password;
            String psw = "";
            String role = "";
            while (rs.next()) {
                psw = rs.getString("password");
                role = rs.getString("role_name");
            }

            if (typedpw.equals(psw)) {

                if (role.equals("owner")) {
                    home h = new home();
                    h.setVisible(true);
                    msg = "Logged In Successfully";
                }

                if (role.equals("manager")) {

                    home h = new home();
                    h.jButton1.setEnabled(false);
                    h.jButton1.setOpaque(false);
                    h.jButton1.setContentAreaFilled(true);
                    h.jButton1.setBorderPainted(false);
                    h.setVisible(true);
                    msg = "Logged In Successfully";

                }

                if (role.equals("cashier")) {

                    home h = new home();
                    h.jButton1.setEnabled(false);
                    h.jButton1.setOpaque(false);
                    h.jButton1.setContentAreaFilled(true);
                    h.jButton1.setBorderPainted(false);

                    h.jButton2.setEnabled(false);
                    h.jButton2.setOpaque(false);
                    h.jButton2.setContentAreaFilled(true);
                    h.jButton2.setBorderPainted(false);

                    h.jButton6.setEnabled(false);
                    h.jButton6.setOpaque(false);
                    h.jButton6.setContentAreaFilled(true);
                    h.jButton6.setBorderPainted(false);

                    h.jButton7.setEnabled(false);
                    h.jButton7.setOpaque(false);
                    h.jButton7.setContentAreaFilled(true);
                    h.jButton7.setBorderPainted(false);

                    h.jButton8.setEnabled(false);
                    h.jButton8.setOpaque(false);
                    h.jButton8.setContentAreaFilled(true);
                    h.jButton8.setBorderPainted(false);

                    h.jButton9.setEnabled(false);
                    h.jButton9.setOpaque(false);
                    h.jButton9.setContentAreaFilled(true);
                    h.jButton9.setBorderPainted(false);

                    h.jButton10.setEnabled(false);
                    h.jButton10.setOpaque(false);
                    h.jButton10.setContentAreaFilled(true);
                    h.jButton10.setBorderPainted(false);

                    h.setVisible(true);
                    msg = "Logged In Successfully";

                }

            } else {
                msg = "Login Failure";
                log.debug(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "Login Failure";
        }
        return msg;
    }

}
