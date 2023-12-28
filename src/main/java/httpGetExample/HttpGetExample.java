package httpGetExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGetExample {
    public static void main(String[] args) throws IOException {

        final URL url = new URL("http://jsonplaceholder.typicode.com/posts?_limit=10");
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(12000);
        con.setReadTimeout(12000);

        System.out.println("Start\n");
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println(content.toString());
            System.out.println("\nFinish");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(" ");
        }
    }
}
