package main;

import java.io.IOException;
import java.net.URLDecoder;

/**
 * Created by Preston on 2015-12-20.
 */
public class BootLoader {
    
    /**String that uses arguments for starting the JVM*/
    private static final String BOOT_FLAGS = "-Xbootclasspath/p:";
    
    /********************************
     * Main method that will start the application by finding and
 calling Main.Main(String[] args)
     * 
     * @param args default Java Main class args
     * @throws IOException if cant find the main class
     *******************************/
    public static void main(String[] args) throws IOException {
        String path = BootLoader.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        path = URLDecoder.decode(path, "UTF-8").replaceAll("\\\\", "/");

        StringBuilder commands = new StringBuilder(0xFF);
        String mainName = Main.class.getCanonicalName();
        boolean windows = System.getProperty("os.name").contains("Win");
        if (windows) {
            commands.append("javaw");
        } else {
            commands.append("java");
        }

        commands.append(' ').append(BOOT_FLAGS);
        commands.append('"').append(path).append("\"");
        commands.append(" -cp ").append('"').append(".").append('"').append(' ').append(mainName);

        for (String arg : args) {
            commands.append(' ').append('"').append(arg).append('"');
        }

        Process application = null;
        Runtime runtime = Runtime.getRuntime();

        if (windows) {
            application = runtime.exec(commands.toString());
        }
        else {
            application = runtime.exec(new String[]{ "/bin/sh", "-c", commands.toString() });
        }
        
        System.out.println(commands.toString());
    }
}

