package second;

import command.AbstractCommand;
import command.AddAgendaCL;
import command.AddUserCL;
import dao.AgendaDao;
import dao.UserDao;
import model.Agenda;
import model.User;
import util.Util;
import net.sf.json.JSONArray;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App2
{
    public static void main(String[] args) throws ParseException {
        init();

        AbstractCommand abstractCommand=null;
        List<AbstractCommand> list=new ArrayList<AbstractCommand>();
        list.add(new AddUserCL());
        list.add(new AddAgendaCL());

        for (AbstractCommand command:list){
            if (command.isMe(args)) abstractCommand=command;
        }
        abstractCommand.excute(args);

        try {
            close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init(){
        //初始化users
        try {
            JSONArray jsonArray = Util.readFile("users");
            UserDao.getInstance().init(Util.jsonArrayToList(jsonArray, User.class));
        } catch (IOException e) {
            UserDao.getInstance().init(new ArrayList<User>());
            e.printStackTrace();
        }

        //初始化agendas
        try {
            JSONArray jsonArray = Util.readFile("agendas");
            AgendaDao.getInstance().init(Util.jsonArrayToList(jsonArray, Agenda.class));
        } catch (IOException e) {
            AgendaDao.getInstance().init(new ArrayList<Agenda>());
            e.printStackTrace();
        }

    }

    public static void close() throws IOException {
        //持久化users
        List<User> users=UserDao.getInstance().getList();
        Util.writeFile("users",(Util.listToJSONArray(users)).toString());
        //持久化agendas
        List<Agenda> agendas = AgendaDao.getInstance().getList();
        Util.writeFile("agendas",(Util.listToJSONArray(agendas)).toString());
    }
}
