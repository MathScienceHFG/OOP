package com.hfg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.hfg.db.*;
import com.hfg.model.Account;

public class AccountDao {
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    public boolean addAccount(Account account){
        boolean bool =false;
        conn = DbConn.getconn();
        String sql = "INSERT INTO ACCOUNT(ACCOUNTNAME,PASSWORD,BALANCE,ACCOUNTTYPE) VALUES(?,?,?,?)";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,account.getAccountName());
            pstmt.setString(2,account.getPassword());
            pstmt.setDouble(3,account.getBalance());
            pstmt.setString(4,account.getAccountType());
            int rs = pstmt.executeUpdate();

            if (rs > 0)
            {
                bool = true;
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            DbClose.addClose(pstmt,conn);
        }
        return bool;
    }

}
