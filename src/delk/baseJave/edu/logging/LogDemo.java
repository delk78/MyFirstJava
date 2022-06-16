package delk.baseJave.edu.logging;
import java.util.logging.*;
import java.util.Arrays;

/**
 * REad this https://habr.com/ru/post/247647/
 * good picture https://ucarecdn.com/63586ed2-84cd-46cc-bade-a335c0c4c585/
 * Note that log level maybe configured in file C:\Users\local-admin\IdeaProjects\HelloWorld\src\delk\baseJave\edu\logging.properties
 * # To use this config start JVM with parameter:
 * # -Djava.util.logging.config.file=[full path]logging.properties
 *
 * .level=ALL
 * .handlers=java.util.logging.ConsoleHandler
 * java.util.logging.ConsoleHandler.level=ALL
 */
public class LogDemo {

    private static final Logger LOGGER = Logger.getLogger(LogDemo.class.getName());

    private static void configureLogging() {
        String nameA = "org.stepic.java.logging.ClassA";
        String nameB = "org.stepic.java.logging.ClassB";
        String nameC = "org.stepic.java";
        Logger loggerA  = Logger.getLogger(nameA);
        Logger loggerB  = Logger.getLogger(nameB);
        Logger loggerC = Logger.getLogger(nameC);
        loggerA.setLevel(Level.ALL);
        loggerB.setLevel(Level.WARNING);
        ConsoleHandler ch = new ConsoleHandler(); //we going to send those messages to console
        ch.setFormatter(new XMLFormatter()); // in xml format (it's what stepik asks ;)
        ch.setLevel(Level.ALL); //handler also have it's own level....
        loggerC.addHandler(ch);
        loggerC.setUseParentHandlers(false); //don't send logging messages to next level
    }

    public static void main(String[] args) {
        // default logging level INFO, all finer events will be ignored
        // default level could be redefined in .properties config file
        LOGGER.log(Level.FINE, "Started with arguments: {0}", Arrays.toString(args));
        LOGGER.log(Level.FINE, "Class name: {0}", LOGGER.getClass().toString());
        try {
            randomFailingAlgorithm();
        }
        catch (IllegalStateException e) {
            LOGGER.log(Level.SEVERE, "Exception caught", e);
            System.exit(2);
        }
        LOGGER.fine("Finished successfully");

    }

    private static void randomFailingAlgorithm() {
        double randomNumber = Math.random();
        LOGGER.log(Level.FINE, "Generated random number: {0}", randomNumber);
        if (randomNumber < 0.5) {
            throw new IllegalStateException("Invalid phase of the Moon");
        }
    }


}