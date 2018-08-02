import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String line;
        while (true){
            if ("END".equals(line = reader.readLine())){
                break;
            }

            sb.append(line).append(System.lineSeparator());
        }

        String result = sb.toString();
        Pattern pattern = Pattern.compile("(<a)\\s+href[^>]+(>)\\s*.*?(</a>)");
        Matcher matcher = pattern.matcher(result);

        while (matcher.find()){
            String entireGroup = matcher.group(0);
            String openTag = matcher.group(1);
            String closeOpenTag = matcher.group(2);
            String closeATag = matcher.group(3);
            String replacement = entireGroup.replaceFirst(openTag, "[URL");
            replacement = replacement.replaceFirst(closeOpenTag, "]");
            replacement = replacement.replaceFirst(closeATag, "[/URL]");
            result = result.replace(entireGroup, replacement);
        }

        System.out.println(result);
    }
}
