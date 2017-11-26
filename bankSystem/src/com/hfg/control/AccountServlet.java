package com.hfg.control;

import java.io.IOException;

import com.hfg.dao.AccountDao;
import com.hfg.model.Account;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;


public class AccountServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String accountName = request.getParameter("account");
        String password =request.getParameter("password");
        String balance = request.getParameter("balance");
        String accountType = request.getParameter("accountType");
        System.out.println(balance);
        Account account = new Account();
        account.setAccountName(accountName);
        account.setAccountType(accountType);
        account.setPassWord(password);
        account.setBalance(Double.parseDouble(balance));
        AccountDao accountDao=new AccountDao();
        accountDao.addAccount(account);


    }
}
