package personalrecom;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class PersonalRecommend {
	/**
     * 运行python脚本
     * @param shell 需要运行的python脚本
    */
	public List<String> execPython(String username) throws IOException{    
        
        String s;  
        //String[] args = new String[] {"python","E:\\te.py","test.txt",username};
        //String[] args = new String[] {"python","E:\\co-filting.py","test.txt",username};
        //String args = "python E:\\co-filting.py E:\\test.txt " + username;
        String args = "python /home/student/CF-3.0/co-filting.py /home/student/CF-3.0/test.txt " + username;		//调用服务器上的个性化推荐python程序
        //System.out.println(args);
        Process pc=Runtime.getRuntime().exec(args);    
        InputStreamReader ir = new InputStreamReader(pc.getInputStream());
        LineNumberReader input = new LineNumberReader(ir);
        String line;
        List<String> businessID = new ArrayList<String>();
        try{
	         while((line = input.readLine()) != null){
	        	 businessID.add(line);
	         }
        }catch(IOException e){
       	 e.printStackTrace();
        }
        input.close();
        ir.close();  
        return businessID;
   }
}
