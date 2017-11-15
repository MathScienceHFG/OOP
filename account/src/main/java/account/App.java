package account;

import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Scanner;


import org.apache.commons.cli.Options;
import org.apache.log4j.Logger;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import javax.xml.bind.annotation.XmlID;




public class App
{

    Options options = new Options();
   private static final Logger logger = Logger.getLogger(App.class);


    public static void main( String[] args )
    {

        logger.error("This is error message");
        Account account=null;
        System.out.println("1.创建用户\n2.查询余额\n3.存款\n4.取款\n");
        Scanner sc = new Scanner(System.in);
        while (true){
            int choose=sc.nextInt();
            switch (choose){
                case 1:{
                    account=new Account();
                    break;
                }
                case 2:{
                    System.out.println((account != null ? "当前余额为："+ account.getBanlance() : "你还未创建用户"));
                    break;
                }
                case 3:{
                    System.out.print("请输入存款金额：");
                    if (account == null) throw new AssertionError();
                    account.deposit(sc.nextDouble());
                    System.out.println("存款成功，现在您的余额为："+account.getBanlance());
                    break;
                }
                case 4:{
                    if (account == null) {
                        System.out.println("您还未创建用户");
                        break;
                    }
                    System.out.print("请输入取款金额：");
                    if (account.withdraw(sc.nextDouble())){
                        System.out.println("取款成功，现在您的余额为："+account.getBanlance());
                    }else{
                        System.out.println("取款失败，你的余额不足");
                    }
                    break;
                }default:{
                    System.out.println("1.创建用户\n2.查询余额\n3.存款\n4.取款\n");
                    break;
                }
            }
        }
    }
}