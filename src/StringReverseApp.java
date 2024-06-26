import java.io.*;
import java.util.logging.*;

public class StringReverseApp {
  
    private static final Logger logger = Logger.getLogger(StringReverseApp.class.getName());
    public static void main(String[] args) throws Exception {

        FileReader inputFile = null;
        BufferedReader bufferedReader = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferWriter = null;

        try {
           
            inputFile = new FileReader("c:/Users/vaishnavi.sonawane/Documents/AssigmentFile-I/input.txt");
            bufferedReader = new BufferedReader(inputFile);

            
            fileWriter = new FileWriter("c:/Users/vaishnavi.sonawane/Documents/AssigmentFile-I/output.txt");
            bufferWriter = new BufferedWriter(fileWriter);

            String data;
            while ((data = bufferedReader.readLine()) != null) {
             
                bufferWriter.write(reverseLine(data));
                bufferWriter.newLine(); 
                
            }   

        } catch (IOException ex) {
            ex.printStackTrace();
            logger.log(Level.SEVERE, "Error reading or writing file", ex);
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
                if (inputFile != null)
                    inputFile.close();
                if (bufferWriter != null) {
                    bufferWriter.flush();
                    bufferWriter.close();
                }
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
                logger.log(Level.SEVERE, "Error closing file streams", ex);
            }
        }

    }
    

    public static String reverseLine(String line)
    {
        String[] lineArr = line.split(" ");
        StringBuilder reverseLine = new StringBuilder();

        for(int i=0;i<lineArr.length;i++)
        {
            reverseLine.append(reverseWord(lineArr[i])).append(" ");
        }
        return reverseLine.toString().trim();
    }

    public static String reverseWord(String word)
    {
        String newWord="";
        String tempChar="";
        System.out.println(newWord);
        if(word.charAt(word.length()-1) == ',' ||word.charAt(word.length()-1) == ';' ||word.charAt(word.length()-1) == '!' ||word.charAt(word.length()-1) == '.')
        {
            tempChar=String.valueOf(word.charAt(word.length()-1));
            newWord = word.substring(0, word.length()-1);
        }else{
            newWord = word.substring(0, word.length());
        }
        
        return new StringBuilder(newWord).reverse().toString()+tempChar;
    }
}