import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;


public class StringReverseApp {
    public static void main(String[] args) throws Exception {
        FileReader inputFile=null;
        BufferedReader bufferedReader=null;
        FileWriter fileWriter=null;
        BufferedWriter bufferWriter=null;
        String data="";

        try{
        inputFile = new FileReader("c:/Users/vaishnavi.sonawane/Documents/AssigmentFile-I/input.txt");
        bufferedReader = new BufferedReader(inputFile);
        data =  bufferedReader.readLine();
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
         }
        finally{
        bufferedReader.close();
        }
        
        StringBuffer newData = new StringBuffer();
        char temp='.';
        boolean flag=false;
        int dataLength = data.length();

        for(int i=dataLength-1;i>=0;i--)
        {
            if(data.charAt(i) == ',' || data.charAt(i) =='!'|| data.charAt(i)== '.'|| data.charAt(i)== ';')
            {   
                if(flag)
                    newData.append(temp);
                temp = data.charAt(i);
                flag=true;
            }else{
                    newData.append(data.charAt(i));
            }
            
        }
        newData.append(temp);
        
        try{
           fileWriter = new FileWriter("c:/Users/vaishnavi.sonawane/Documents/AssigmentFile-I/output.txt");
            bufferWriter = new BufferedWriter(fileWriter);
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
        }

        try{
            File outputFile = new File("c:/Users/vaishnavi.sonawane/Documents/AssigmentFile-I/output.txt");
            if(!outputFile.exists())
            {
                outputFile.createNewFile();
                bufferWriter.append(newData);
            }
            else
                bufferWriter.append(newData);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally{
            bufferWriter.close();
        }
    }
}