package element;

import element.Document;
import element.Header;
import visitor.PlainVisitor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;


public class typeChecker {
	
	String symbols;
    String tokens;
    Document document = new Document();
    
    boolean HaveinNode = false;//노드안에 노드를 체크하기 위해서!
    
    public void Check ( String readline )
    {
     
    	
        	
        	String [] pattern = {"(^###### )","(^##### )","(^#### )","(^### )","(^## )","(^# )",
        			             "(    )","(\t){1,}","&copy;","&lt;","&gt;","&amp;",">"};
       
        	char [] arrayforspecial = (readline.trim()).toCharArray();
        	
        	//문자열에 공백을 싹다 제거해준뒤, 맨 앞 세개의 문자가 * 혹은 - 일경우, 리스트가 아니라 horizontal 이다.
            //이를 처리하기 위한 복잡한 절차
            String deleteblank = readline.replaceAll("\\s", "");
            char [] listorhori = deleteblank.toCharArray();
            
            if(   ( arrayforspecial[0]=='*'&&arrayforspecial[1]==' ')&&(listorhori[2]!='*')
                    ||( arrayforspecial[0]=='+'&&arrayforspecial[1]==' ')
                    ||( arrayforspecial[0]=='-'&&arrayforspecial[1]==' ')&&(listorhori[2]!='-'))
                	  {
                			System.out.println("LIST");
                      }
                
                if(  ( arrayforspecial[0]=='-'&&arrayforspecial[1]==' '&&arrayforspecial[2]=='-'&&arrayforspecial[3]==' '&&arrayforspecial[4]=='-')||
                     ( arrayforspecial[0]=='*' && arrayforspecial[1]==' ' && arrayforspecial[2]=='*'&&arrayforspecial[3]==' '&&arrayforspecial[4]=='*')||
      				 ( arrayforspecial[0]=='*'&&arrayforspecial[1]=='*'&&arrayforspecial[2]=='*'))
     				 {
     						System.out.println("Horizontal");
     				 }
                else
        
        		for(   int i=0  ;  i<pattern.length  ;  i++ )
        		{
    		
    		
        			if( pattern[i]=="(    )"  ||  pattern[i]=="(\t){1,}"  ) 
        			{ //코드블럭여부를  검사할 차례가 되었을때는 공백놔둔채로 ( 그래야 코드블럭인줄 아니까 ) 검사한다.
        				Pattern p = Pattern.compile(  pattern[i]  );
        				Matcher m = p.matcher( readline );
    			
        				if( m.find())
        				{
        					HaveinNode = true;
        					System.out.println("CODEBLOCKKKK");
        				}
    			
        			}
    		
    		
        			else
        			{ 

    			
        				//다른 효과들을 검사할때는, 앞뒤 공백을 제거 한채 검사한다. 
        				Pattern p = Pattern.compile(  pattern[i]  );
        				Matcher m = p.matcher( readline.trim() );
    			
        		if(  m.find() )
                {
             	   
        			if(  p.toString()=="(^### )"  ||  p.toString()=="(^## )"  ||  p.toString()=="(^# )")
        			{   
        				HaveinNode = true;
        				System.out.println("HEADER SUCCESS");
                 	 
        			}	
                   
        			if( p.toString()=="&amp;"  ||  p.toString()=="&copy;"||  p.toString()=="&lt;"||  p.toString()=="&gt;")
        			{
        				HaveinNode = true;
        				System.out.println("Special char success");
        			}
        			if( p.toString()==">" )
        			{
        				HaveinNode = true;
        				System.out.println("Blokc quoted SUCCESS");
        			}
        			else
        			{
	                	   HaveinNode = false;
	                	   System.out.println("This is plain Text");
        			}
           
        
                }
        
        	}

        		}
    }
    
    public void H1( String readline )throws IOException 
    {
    	
         int idx=0;
         
    	 symbols = "h1"; 
         idx = readline.indexOf("# "); //읽어들인 곳에서 ### 위치찾아낸다. }  
         tokens = readline.substring( idx+1 , readline.length() ).trim();
         //"### "을 떼어낸다음, 앞뒤 공백을 제거한다.
     	
        	 
         document.addNewNode(new Header(symbols, tokens));
         System.out.println("find successfully"); //검사기능
         
         document.accept(  new PlainVisitor()  );
    }
    public void H2( String readline )throws IOException 
    {
    	
         int idx=0;
         
    	 symbols = "h2"; 
         idx = readline.indexOf("## "); //읽어들인 곳에서 ### 위치찾아낸다. }  
         tokens = readline.substring( idx+1 , readline.length() ).trim();
         //"### "을 떼어낸다음, 앞뒤 공백을 제거한다.
     	
        	 
         document.addNewNode(new Header(symbols, tokens));
         System.out.println("find successfully"); //검사기능
         
         document.accept(  new PlainVisitor()  );
    }
    public void H3( String readline )throws IOException 
    {
    	
         int idx=0;
         
    	 symbols = "h3"; 
         idx = readline.indexOf("### "); //읽어들인 곳에서 ### 위치찾아낸다. }  
         tokens = readline.substring( idx+1 , readline.length() ).trim();
         //"### "을 떼어낸다음, 앞뒤 공백을 제거한다.
     	
        	 
         document.addNewNode(new Header(symbols, tokens));
         System.out.println("find successfully"); //검사기능
         
         document.accept(  new PlainVisitor()  );
    }
    public void H4( String readline )throws IOException 
    {
    	
         int idx=0;
         
    	 symbols = "h4"; 
         idx = readline.indexOf("#### "); //읽어들인 곳에서 ### 위치찾아낸다. }  
         tokens = readline.substring( idx+1 , readline.length() ).trim();
         //"### "을 떼어낸다음, 앞뒤 공백을 제거한다.
     	
        	 
         document.addNewNode(new Header(symbols, tokens));
         System.out.println("find successfully"); //검사기능
         
         document.accept(  new PlainVisitor()  );
    }
    public void H5( String readline )throws IOException 
    {
    	
         int idx=0;
         
    	 symbols = "h5"; 
         idx = readline.indexOf("##### "); //읽어들인 곳에서 ### 위치찾아낸다. }  
         tokens = readline.substring( idx+1 , readline.length() ).trim();
         //"### "을 떼어낸다음, 앞뒤 공백을 제거한다.
     	
        	 
         document.addNewNode(new Header(symbols, tokens));
         System.out.println("find successfully"); //검사기능
         
         document.accept(  new PlainVisitor()  );
    }
    public void H6( String readline )throws IOException 
    {
    	
         int idx=0;
         
    	 symbols = "h6"; 
         idx = readline.indexOf("###### "); //읽어들인 곳에서 ### 위치찾아낸다. }  
         tokens = readline.substring( idx+1 , readline.length() ).trim();
         //"### "을 떼어낸다음, 앞뒤 공백을 제거한다.
     	
        	 
         document.addNewNode(new Header(symbols, tokens));
         System.out.println("find successfully"); //검사기능
         
         document.accept(  new PlainVisitor()  );
    }
  

}