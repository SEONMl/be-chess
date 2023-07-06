package softeer2nd.chess.utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");
    public static final String SPACE = " ";

    private StringUtils() {
    }

    public static String appendNewLine(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(NEWLINE);
        return sb.toString();
    }
}
