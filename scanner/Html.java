package scanner;
 
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.*;

/**
 * Beschreiben Sie hier die Klasse Html.
 * 
 * @author JKrier, JVogt
 * @version Ueb07 Prototyp
 */

public class Html
{
    private Scanner in;
    private PrintStream out = System.out;
    private File file;

    /**
     * Konstruktor für Objekte der Klasse Html
     */
    
    public Html(String test_html) throws IOException 
    {
        this.file = new File("test.html");   // meine html datei, die aber nicht gestartet bekomme
        in = new Scanner(file);
        out.println(file + ":");
    }
    
    public void start() {
        Pattern pattern =
                Pattern.compile("<a.* href=.*>.*</a>");
        String next;
        do {
            next = in.findWithinHorizon(pattern, 0);
            if (next != null)
                out.println(next);
                
            } 
            while (next != null);
    }

    public static void main(String[] args) 
    {
        if (args.length == 1) 
        {
            try {
                Html ls = new Html(args[0]);
                ls.start();
                } catch (Exception e) 
            {
                System.out.println(e);
            }
        } 
        
        else {
            System.out.println("Ende der Datei"); 
             }
    }
}
