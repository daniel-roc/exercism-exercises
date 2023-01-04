public class LogLevels {

    public static String message(String logLine) {
        int i = logLine.indexOf(":");
        return logLine.substring(i + 2).trim();
    }

    public static String logLevel(String logLine) {
        int initialIndex = logLine.indexOf("[") + 1;
        int finalIndex = logLine.indexOf("]");
        return logLine.substring(initialIndex, finalIndex).toLowerCase();
    }

    public static String reformat(String logLine) {
        return message(logLine) + " " + "(" + logLevel(logLine) + ")";
    }
}
