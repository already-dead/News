import org.apache.log4j.Logger;

public class hello {
    final static Logger logger = Logger.getLogger(hello.class);
    public static void main(String[] args) {
        System.out.println("Hello world");
        logger.error("Hello!!");
    }
}
