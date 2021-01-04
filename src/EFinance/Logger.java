package EFinance;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;

/**
 * Provides logging and related operations for eFinance.
 */
public class Logger {

    private final File logFile = new File("eFinance_log.txt");

    private static final Logger INSTANCE = new Logger();

    /**
     * Constructor for logger.
     */
    private Logger() {
        createLogFile();
    }

    /**
     * Gets the current instance of logger.
     *
     * @return The logger instance
     */
    public static Logger getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new log file if one does not exist.
     */
    private void createLogFile() {

        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Adds a message to the log file.
     *
     * @param message The message to be written.
     *
     * @usage Logger logger = Logger.getInstance(); logger.log("sample
     * message");
     */
    public void log(String message) {
        FileWriter fw = null;
        try {
            String time = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT);
            fw = new FileWriter(logFile, true);
            fw.write(time + ": " + message + System.getProperty("line.separator"));
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Clears all log file entries.
     */
    public void clearLog() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(logFile);
            fw.write("");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
