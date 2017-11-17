package com.hfg.model;

public class Account {
    private String accountType;//活期or定期
    private double balance;//余额
    private String accountName;//账户名
    private String password;//密码
    private String idCard;//身份证号码


    public void setBalance(double balance){this.balance=balance;}

    public void setAccountType(String accountType){
        this.accountType = accountType;
    }

    public void setAccountName(String accountName){
        this.accountName = accountName;
    }

    public void setPassWord(String password){
        this.password = password;
    }

    public double getBalance(){return this.balance;}

    public String getAccountType(){
        return this.accountType;
    }

    public String getAccountName(){
        return this.accountName;
    }


    public String getPassword(){ return this.password;}


}
