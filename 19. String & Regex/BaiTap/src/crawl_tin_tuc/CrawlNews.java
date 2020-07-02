package crawl_tin_tuc;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("https://dantri.com.vn/the-gioi.htm ");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            // open the stream and put it into BufferedReader
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            // close scanner
            scanner.close();
            // remove all new line
            content = content.replaceAll("\\n+", "");
            // regex
            Pattern p = Pattern.compile("<a title=\"(.*?)\"");
            Matcher m = p.matcher(content);
            Set<String> set = new LinkedHashSet<>();
            while (m.find()) {
                if (m.group(1).length()>30) {
                    set.add(m.group(1));
                }
            }
            for (String obj:set) {
                obj = obj.replaceAll("&quot;","");
                System.out.println(obj.toString()+"\n");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
