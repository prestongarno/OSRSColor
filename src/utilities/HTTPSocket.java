package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
/**
 * @author Preston Garno
 * 
 * Class used for downloading pages and files
 */
public class HTTPSocket {
    
    /**The URL for the specified world*/
    private URL url;
    
    /********************************
     * Public constructor
     * 
     * @param Address A string with the specified world URL
     *******************************/
    public HTTPSocket(String Address) throws IOException {
        url = new URL(Address);
    }
    
    /********************************
     * Sets the properties basically to act like a browser when
     * sending an HTTP request
     * 
     * @param URLConnection
     * @param userAgent
     *******************************/
    private void setProperties(URLConnection connection, String userAgent) {
        connection.addRequestProperty("Protocol", "HTTP/1.1");
        connection.addRequestProperty("Connection", "keep-alive");
        connection.addRequestProperty("Keep-Alive", "300");
        if (userAgent != null) {
            connection.addRequestProperty("User-Agent", userAgent);
        } else {
            connection.addRequestProperty("User-Agent", "Mozilla/5.0 (" + System.getProperty("os.name") + " " + System.getProperty("os.version") + ") Java/" + System.getProperty("java.version"));
        }    
    }
    
    /********************************
     * Method for downloading page
     * 
     * @param userAgent The page
     *******************************/
    public String getPage(String userAgent) {
        return request(null, userAgent, false);
    }
    
    /********************************
     * Requests the .jar
     * 
     * @param data
     * @param userAgent
     * @param post
     *******************************/
    public String request(String data, String userAgent, boolean post){
        try{
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            setProperties(connection, userAgent);
            connection.setRequestMethod(post ? "POST" : "GET");
            connection.setUseCaches(false);
            connection.setDoInput(true);
            
            if (post) {
                connection.addRequestProperty("Content-Length", String.valueOf(data.length()));
                connection.setDoOutput(true);
                
                try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream())) {
                    writer.write(data);
                    writer.flush();
                }
            }
            
            String Line;
            StringBuilder Builder = new StringBuilder();
            
            try (BufferedReader Reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                while ((Line = Reader.readLine()) != null) {
                    Builder.append(Line).append("\n");
                }
            }
            
            connection.disconnect();
            return Builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
