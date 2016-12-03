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
    
    boolean HaveinNode = false;//���ȿ� ��带 üũ�ϱ� ���ؼ�!
    
    public void Check ( String readline )
    {
     
    	
        	
        	String [] pattern = {"(^###### )","(^##### )","(^#### )","(^### )","(^## )","(^# )",
        			             "(    )","(\t){1,}","&copy;","&lt;","&gt;","&amp;",">"};
       
        	char [] arrayforspecial = (readline.trim()).toCharArray();
        	
        	//���ڿ��� ������ �ϴ� �������ص�, �� �� ������ ���ڰ� * Ȥ�� - �ϰ��, ����Ʈ�� �ƴ϶� horizontal �̴�.
            //�̸� ó���ϱ� ���� ������ ����
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
        			{ //�ڵ�����θ�  �˻��� ���ʰ� �Ǿ������� �������ä�� ( �׷��� �ڵ������ �ƴϱ� ) �˻��Ѵ�.
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

    			
        				//�ٸ� ȿ������ �˻��Ҷ���, �յ� ������ ���� ��ä �˻��Ѵ�. 
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
         idx = readline.indexOf("# "); //�о���� ������ ### ��ġã�Ƴ���. }  
         tokens = readline.substring( idx+1 , readline.length() ).trim();
         //"### "�� �������, �յ� ������ �����Ѵ�.
     	
        	 
         document.addNewNode(new Header(symbols, tokens));
         System.out.println("find successfully"); //�˻���
         
         document.accept(  new PlainVisitor()  );
    }
    public void H2( String readline )throws IOException 
    {
    	
         int idx=0;
         
    	 symbols = "h2"; 
         idx = readline.indexOf("## "); //�о���� ������ ### ��ġã�Ƴ���. }  
         tokens = readline.substring( idx+1 , readline.length() ).trim();
         //"### "�� �������, �յ� ������ �����Ѵ�.
     	
        	 
         document.addNewNode(new Header(symbols, tokens));
         System.out.println("find successfully"); //�˻���
         
         document.accept(  new PlainVisitor()  );
    }
    public void H3( String readline )throws IOException 
    {
    	
         int idx=0;
         
    	 symbols = "h3"; 
         idx = readline.indexOf("### "); //�о���� ������ ### ��ġã�Ƴ���. }  
         tokens = readline.substring( idx+1 , readline.length() ).trim();
         //"### "�� �������, �յ� ������ �����Ѵ�.
     	
        	 
         document.addNewNode(new Header(symbols, tokens));
         System.out.println("find successfully"); //�˻���
         
         document.accept(  new PlainVisitor()  );
    }
    public void H4( String readline )throws IOException 
    {
    	
         int idx=0;
         
    	 symbols = "h4"; 
         idx = readline.indexOf("#### "); //�о���� ������ ### ��ġã�Ƴ���. }  
         tokens = readline.substring( idx+1 , readline.length() ).trim();
         //"### "�� �������, �յ� ������ �����Ѵ�.
     	
        	 
         document.addNewNode(new Header(symbols, tokens));
         System.out.println("find successfully"); //�˻���
         
         document.accept(  new PlainVisitor()  );
    }
    public void H5( String readline )throws IOException 
    {
    	
         int idx=0;
         
    	 symbols = "h5"; 
         idx = readline.indexOf("##### "); //�о���� ������ ### ��ġã�Ƴ���. }  
         tokens = readline.substring( idx+1 , readline.length() ).trim();
         //"### "�� �������, �յ� ������ �����Ѵ�.
     	
        	 
         document.addNewNode(new Header(symbols, tokens));
         System.out.println("find successfully"); //�˻���
         
         document.accept(  new PlainVisitor()  );
    }
    public void H6( String readline )throws IOException 
    {
    	
         int idx=0;
         
    	 symbols = "h6"; 
         idx = readline.indexOf("###### "); //�о���� ������ ### ��ġã�Ƴ���. }  
         tokens = readline.substring( idx+1 , readline.length() ).trim();
         //"### "�� �������, �յ� ������ �����Ѵ�.
     	
        	 
         document.addNewNode(new Header(symbols, tokens));
         System.out.println("find successfully"); //�˻���
         
         document.accept(  new PlainVisitor()  );
    }
  

}