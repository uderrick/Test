
/**
 * Created by eunli on 2016-11-20.
 */
import element.Document;
import element.Header;
import visitor.PlainVisitor;

import element.typeChecker; //노드 타입판별기.

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

        typeChecker check = new typeChecker(); //타입체커 인스턴스 생성 ( 매서드 사용을 위해 ) 

       try {
       	
           BufferedReader in = new BufferedReader(new FileReader(args[0]));
           
           while ((currentLine = in.readLine()) != null ) 
           {
           	
        	
             System.out.println(currentLine);
             //헤더 효과를위해서 해주는 얘들.
             	char [] head_check = (currentLine.trim()).toCharArray();
             
             	for(int i = 0 ; i< head_check.length ; i++)
             	{
             		if(head_check[i]=='-'||head_check[i]=='=')
             		{
             			//이전 줄에 헤더효과적용!
             		}
             	}
             
             	if( currentLine == "-" || currentLine == "--" ||
             			currentLine == "=" ||currentLine == "==" )
             	{
             		//이전 줄에 헤더효과적용!
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
