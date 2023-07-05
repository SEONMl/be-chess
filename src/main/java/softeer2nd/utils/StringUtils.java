package softeer2nd.utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {
    }

    public static String appendNewLine(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(NEWLINE);
        return sb.toString();
    }
}
