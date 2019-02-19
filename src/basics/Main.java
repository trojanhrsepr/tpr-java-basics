package basics;

import java.io.*;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

import basics.model.Kalamata;
import basics.model.Olive;
import basics.model.OliveColor;
import basics.model.OliveName;
import basics.test.Basics;
import basics.test.DataStructures;
import basics.test.ReflectionApi;

public class Main {

    /**
     * Main method where different functionalities of Java are tried
     * @param args
     */

    private static final String FLOWERS_FEED;
    private static final ArrayList<Olive> olives = new ArrayList<>();

    // Use of a static initializer to instantiate static variables
    // To access variable, Main.FLOWERS_FEED will provide value of static variable
    // This block of code is called whenever a static variable is referenced
    // Will be called only once though to initialize data irrespective of the number of references
    static {
        FLOWERS_FEED = "http://services.hanselandpetal.com/feeds/flowers.xml";
        olives.add(new Kalamata());
        olives.add(new Kalamata());
    }

    public static void main(String[] args) {

        // Basics.basics();

        // DataStructures.basics();

        threadBasics();

        // Class implementation practice (Class within class using abstract/ interface)
        List<Olive> olives = new ArrayList<>();
        olives.add(new Kalamata());
        olives.add(new Kalamata());

        // On uncommenting, I get exception abstract class cannot be instantiated
        olives.add(new Olive(OliveName.LIGURIAN, OliveColor.BLACK, 2));
        olives.add(new Olive(OliveName.LIGURIAN, OliveColor.GREEN, 2));
        olives.add(new Olive(OliveName.LIGURIAN, OliveColor.GOLDEN, 2));
        olives.add(new Olive(OliveName.LIGURIAN, OliveColor.GREEN, 2));

        OlivePress press = new OlivePress();
        // int totalOil = press.getOil(olives);
        // System.out.println("Total olive oil: " + totalOil);

        // ReflectionApi.basics();

        // fileIO();

        // Anonymous inner class that doesn't have a name, and is used just this once from within this block
        new Object() {
            void open() {
                System.out.println("Running anonymous class");
            }
        } .open();

    }

    public static void fileIO() {
        String sourceFile = "files/newtext.txt";
        String targetFile = "files/target.txt";

        // Adding inside bracket makes sure event is closed in case of exception.
        try (
                FileReader fRead = new FileReader(sourceFile);
                BufferedReader bRead = new BufferedReader(fRead);
                FileWriter fWrite = new FileWriter(targetFile)
        ){
            while (true) {
                String line = bRead.readLine();
                if( line == null )
                    break;
                else {
                    fWrite.write(line+"\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Path pathSource = Paths.get("files", "target.txt");
        Path pathTarget = Paths.get("files/new", "target.txt" );

        try {
            Files.copy(pathSource, pathTarget, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream inputStream = null;
        BufferedInputStream bistream = null;


        // Needs internet
        // Declaring within brackets is an addition of Java 7
        try(FileWriter fw = new FileWriter(targetFile)) {
            URL url = new URL(FLOWERS_FEED);
            inputStream = url.openStream();
            bistream = new BufferedInputStream(inputStream);

            StringBuilder sb = new StringBuilder();

            while(true) {
                int data = bistream.read();
                if(data == -1)
                    break;
                else {
                    sb.append((char)data);
                }
            }
            System.out.println(sb);
            fw.write(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Finally is executed after the main thread always
            // When close statements are after exception code, they may not be
            // closed. Finally is handy in that situation
            if(inputStream!= null && bistream!=null) {
                try {
                    inputStream.close();
                    bistream.close();
                } catch (Exception e) {}
            }
        }
    }

    public static void threadBasics() {
        Olive o = new Olive();
        ThreadTest thread = new ThreadTest(1, o);
        ThreadTest thread2 = new ThreadTest(2, o);
        ThreadTest thread3 = new ThreadTest(3, o);
        Runnable runnable = new RunnableTest();
        thread.start();
        thread2.start();
        thread3.start();
        new Thread(runnable).start();
        try{
            Thread.sleep(2500);
            // On interrupting one thread, the others still remain unaffected
            thread.interrupt();
        } catch (Exception e) {}

        try {
            System.out.println("Main thread");
            for(int i=0; i<5; i++) {
                System.out.println("Main is functional");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
