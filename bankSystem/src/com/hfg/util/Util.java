package com.hfg.util;

import java.util.Scanner;

public class Util {
    public static String generateAccount() {//生成账户名
        return "12";
    }

    public static String getPassword() {
        Scanner in = new Scanner(System.in);
        String password;
        while (true) {
            System.out.println("请输入初始密码");
            String password1 = in.nextLine();
            System.out.println("请再次输入密码");
            String password2 = in.nextLine();
            if (password1 == password2) {
                password = password1;
                break;
            }
        }
        return password;
    }
}
