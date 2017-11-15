package command;

import dao.UserDao;
import model.User;
import model.Agenda;
import service.AgendaService;
import org.apache.commons.cli.*;

import java.util.List;

public class AddAgendaCL extends AbstractCommand {
    AgendaService agendaService=new AgendaService();
    CommandLineParser parser;
    Options opts;
    String addAgenda;
    Agenda agenda;
    String t;
    String p;
    String s;
    String e;

    public boolean isMe(String[] args) {
        if (args[0].equals("addAgenda")) return true;
        return false;
    }

    public void buildOpts() {
        opts = new Options();
        opts.addOption("h", false, "帮助文档");
        opts.addOption("addAgenda", false, "创建会议");
        opts.addOption("t", true, "会议主题");
        opts.addOption("p", true, "会议参与者");
        opts.addOption("s", true, "会议起始时间");
        opts.addOption("e", true, "会议结束时间");
    }

    public void parser(String[] args) {
        parser = new BasicParser();
        CommandLine cl;
        try {
            cl = parser.parse(opts, args);
            if (cl.getOptions().length > 0) {
                if (cl.hasOption('h')) {
                    HelpFormatter hf = new HelpFormatter();
                    hf.printHelp("帮助", opts);
                } else {
                    t = cl.getOptionValue("t");
                    p = cl.getOptionValue("p");
                    s = cl.getOptionValue("s");
                    e = cl.getOptionValue("e");
                    setAddAgenda();
                }
            } else {
                System.err.println("ERROR_NOARGS");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void doCommand() {
        agendaService.addAgenda(this.agenda);
    }

    public void setUp() {

    }

    public void setAddAgenda(){
        Agenda agenda = new Agenda();
        agenda.setTitle(this.t);
        agenda.setStartTime(this.s);
        agenda.setEndTime(this.e);
        UserDao userDao = UserDao.getInstance();
        User user =userDao.findByName(this.p);
        agenda.setParticipator(userDao.getList());
        this.agenda = agenda;
    }



}
