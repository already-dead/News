package logger;
import java.io.IOException;
import java.util.logging.*;

public abstract class LogApp {
    final static Logger logger = Logger.getLogger(LogApp.class.getName());
    public static void log(Exception log) {
        try {
            FileHandler fh = new FileHandler("D://logfile.txt");
            logger.addHandler(fh);
            HtmlFormatter htmlformatter = new HtmlFormatter();
            FileHandler htmlfile = new FileHandler("D://logfile.html");
            htmlfile.setFormatter(htmlformatter);
            logger.addHandler(htmlfile);
            logger.log(Level.WARNING,"Ошибка", log);
        } catch (SecurityException e) {
            logger.log(Level.SEVERE, "Не удалось создать файл лога из-за политики безопасности.", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Не удалось создать файл лога из-за ошибки ввода-вывода.", e);
            //        logger.log(Level.INFO, "Запись лога с уровнем INFO (информационная)");
            //        logger.log(Level.SEVERE, "Запись лога с уровнем SEVERE (серъёзная ошибка)", new Exception("Проверочное сообщение об ошибке"));
        }
    }
}

