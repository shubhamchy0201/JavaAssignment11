import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CountCharacter {
    static HashMap<Character,Integer> hm=new HashMap<>();
    public static void main(String[] args) {
        readFile();
        writeToFile();
    }

    private static void readFile() {
        Scanner infile;

        try{
            //infile=new Scanner(new File("C:/Users/Shubham/IdeaProjects/Chapter8_Project/input.txt"));
            infile=new Scanner(new File("input.txt"));
            String input="";
            while (infile.hasNext())
            {
                input=infile.next();

                for(int i=0;i<input.length();i++)
                {
                    char ch=input.charAt(i);
                    if(hm.containsKey(ch))
                    {
                       hm.put(ch, hm.get(ch)+1);
                    }
                    else
                    {
                        hm.put(ch,1);
                    }
                }

            }

            infile.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Can't find file");
            System.out.println(ex.getMessage());
        }

    }

    private static void writeToFile() {
        try
        {
            PrintWriter pw=new PrintWriter("count.txt");
            pw.println(hm.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
