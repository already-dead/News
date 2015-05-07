package logger;

/**
 * Created by ragexe on 03.05.2015.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TrueLogger {

    private static TrueLogger logger;
    //File Logs = new File("E://Development//jdpro//engine_example_leonovich//logfile.txt");
    //File Logs = new File("C:\\Users\\ragexe\\ОЦ ПВТ\\Макейчик_WebApplication\\WebApplication\\logfile.txt");
    File Logs = new File("C://Users//ragexe//ОЦ ПВТ//Макейчик_WebApplication//WebApplication//logfile.txt");
    BufferedWriter buferSaveLog = null;
    BufferedReader buferReadLog = null;
    ArrayList list = new ArrayList();

    private TrueLogger() {
        try {
            buferReadLog = new BufferedReader(new FileReader(Logs));
        } catch (FileNotFoundException e) {
            System.out.println("�������� � ������������ �������!!!");
            e.printStackTrace();
        }
    }

    public static synchronized TrueLogger getLogger() {
        if (logger == null) logger = new TrueLogger();
        return logger;
    }

    public void write(String log) {
        try {
            GregorianCalendar myData = new GregorianCalendar();
            list.add(log + " >>> " + myData.getTime() + " <<< ");
            buferSaveLog = new BufferedWriter(new FileWriter(Logs));
            for (int i = 0; i < list.size(); i++) buferSaveLog.write(list.get(i) + "\r\n");
            buferSaveLog.flush();
        } catch (IOException e) {
            System.out.println("�������� � ������ write �������!!!");
            e.printStackTrace();
        }
    }
}
