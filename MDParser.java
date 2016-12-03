
/**
 * Created by eunli on 2016-11-20.
 */
import element.Document;
import element.Header;
import visitor.PlainVisitor;

import element.typeChecker; //��� Ÿ���Ǻ���.

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;



public class MDParser {
	
	public static FileInputStream inputfileStream;
    public static FileInputStream outputfileStream;
    public static String mode;

    public static void main(String[] args) {
    	
    	mode = "p"; //Plain Mode.
    	
    	commandChecker(args);





        
      
        String currentLine;
        String temp = " ";

        typeChecker check = new typeChecker(); //Ÿ��üĿ �ν��Ͻ� ���� ( �ż��� ����� ���� ) 

       try {
       	
           BufferedReader in = new BufferedReader(new FileReader(args[0]));
           
           while ((currentLine = in.readLine()) != null ) 
           {
           	
        	
             System.out.println(currentLine);
             //��� ȿ�������ؼ� ���ִ� ���.
             	char [] head_check = (currentLine.trim()).toCharArray();
             
             	for(int i = 0 ; i< head_check.length ; i++)
             	{
             		if(head_check[i]=='-'||head_check[i]=='=')
             		{
             			//���� �ٿ� ���ȿ������!
             		}
             	}
             
             	if( currentLine == "-" || currentLine == "--" ||
             			currentLine == "=" ||currentLine == "==" )
             	{
             		//���� �ٿ� ���ȿ������!
             	}
             
             
             check.Check(currentLine);
               
            
           }
           in.close(); 
           }catch (FileNotFoundException e){e.printStackTrace();
       }catch (IOException e){e.printStackTrace();}

   }




    

    public static void commandChecker(String[] args){
    	
    	if(args[0].equals("--help")){
    		help();
    	}
    	else if(args.length<2){
    		wrong();
    	}
    	
    	if(!(args[0].endsWith(".md")) && (args[1].endsWith(".html"))){
    		wrong();
    	}
    }


    public static void wrong(){
    	
    	System.out.println("Wrong input!");
    	System.out.println("Use help function for detail!");
    	System.exit(0);
    }

    public static void help(){

    	
    	try{
    		
    		FileInputStream in = null;
    		in = new FileInputStream("README.md");
    		int ch;
			while((ch = in.read())!=-1){
                System.out.print((char)ch);
        	}
			
            in.close();
            System.exit(0);
            
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    }
}
