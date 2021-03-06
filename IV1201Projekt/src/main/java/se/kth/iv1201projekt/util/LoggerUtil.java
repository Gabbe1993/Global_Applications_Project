package se.kth.iv1201projekt.util;

import static com.mysql.jdbc.Util.stackTraceToString;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * A class that handles all logging done by the application.
 *
 * @author Samy
 */
public class LoggerUtil implements Serializable {

    private static final String homeDir = System.getProperty("user.home");
    private static final String logDir = "/GasakiLogs";
    private static final String exceptionFile = "/exceptionLog%g.log";
    private static final String testExceptionFile = "/testexceptionLog%g.log";
    private static final String methodFile = "/methodLog%g.log";
    private static final Handler excpFileHandler;
    private static final Handler testFileHandler;
    private static final Handler methodFileHandler;

    static {
        excpFileHandler = getHandler(exceptionFile);
        testFileHandler = getHandler(testExceptionFile);
        methodFileHandler = getHandler(methodFile);
    }

    /**
     * Returns the directory where the logs are stored on this machine
     * @return the directory of the logs 
     */
    public static String getLoggingDirectory(){
        return homeDir+logDir;
    }

    /**
     * Logs severe exceptions.
     *
     * @param e the exception itself
     * @param exceptionClass the class the exception was called from
     */
    public static void logSevere(Exception e, Object exceptionClass) {
        Logger logger = Logger.getLogger("");
        logger.addHandler(excpFileHandler);
        logger.log(Level.SEVERE, stackTraceToString(e), e);
    }

    /**
     * Logs exceptions created in an automated test
     *
     * @param e the exception itself
     * @param exceptionClass the class the exception was called from
     */
    public static void logTest(Exception e, Object exceptionClass) {
        Logger logger = Logger.getLogger("");
        logger.addHandler(testFileHandler);
        logger.log(Level.FINE, "StackTrace:\n"+stackTraceToString(e), e);
    }

    /**
     * Logsparameters when a method annotated @Aroundinvoke is called and exited
     *
     * @param method Class of where the method is called
     * @param formattedParams the parameters invoked
     * @param before if it's before it's called or after it has exited.
     */
    public static void logMethod(Method method, String[] formattedParams, boolean before) {
        Logger logger = Logger.getLogger("");
        logger.addHandler(methodFileHandler);
        String paramString = Arrays.toString(formattedParams);
        if (before) {
            logger.log(Level.OFF, "Logging method: " + method.getName() + " in class: "
                    + method.getDeclaringClass().getName());
            logger.log(Level.OFF, "Parameters before\n" + paramString);
        } else {
            logger.log(Level.OFF, "Return Value\n" + paramString);
        }
    }

    /**
     * creates the file handler and a directory for the filehandler to be in.
     * Can't log this exception because if it exists the logger can't log.
     *
     * @param filename name of the file the filehandler should write too.
     * @return the Filehandler
     */
    private static Handler getHandler(String filename) {
        Handler handler = null;
        try {
            new File(homeDir + logDir).mkdir();
            handler = new FileHandler(homeDir + logDir + filename, 1024, 10, true);
            handler.setFormatter(new SimpleFormatter());
        } catch (IOException | SecurityException ex) {
            ex.printStackTrace();
        }
        return handler;
    }

}
