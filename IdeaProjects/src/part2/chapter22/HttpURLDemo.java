package part2.chapter22;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

class HttpURLDemo {
    public static void main(String[] args) throws IOException {
        URL hp = new URL("http://www.google.com");
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();
        System.out.printf("Request method: %s%n", hpCon.getRequestMethod());
        System.out.printf("Response code: %d%n", hpCon.getResponseCode());
        System.out.printf("Response message: %s%n", hpCon.getResponseMessage());

        Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
        System.out.println("Next follow header");
        for (Map.Entry<String, List<String>> entry : hdrMap.entrySet()) {
            System.out.printf("Key: %s Value: %s%n", entry.getKey(), entry.getValue());
        }
    }
}
