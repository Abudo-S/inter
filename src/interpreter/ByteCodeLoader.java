/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import bytecode.ByteCode;
import bytecode.HaltCode;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author mt
 */
public class ByteCodeLoader {
    Program p;
    private static ArrayList<String> initCodes;
    
    public ByteCodeLoader(String programFile) throws IOException{
        p=new Program();
        initCodes=new ArrayList<>();
        FileReader file=new FileReader(programFile);//programFile zBytesCodes
        BufferedReader rf=new BufferedReader(file);
        String rd=rf.readLine();
        while(rd!=null){
            initCodes.add(rd);
            rd=rf.readLine();
        }
    }

     Program loadCodes() {
       try{
           String st,st1;
       for(int i=0;i<initCodes.size();i++){ 
            st1=initCodes.get(i);
            if(st1.contains(" ")){
            st=st1.substring(0,st1.indexOf(" "));        
            st=CodeTable.get(st);          
                if(!st.equals("none")){
                    Class c=Class.forName("bytecode."+st);
                    ByteCode bc=(ByteCode) c.getDeclaredConstructor().newInstance();
                    st=st1.substring(st1.indexOf(" "));
                    st=st.replaceFirst(" ","");
                     //System.out.println(st);
                    bc.set_value(st);
                    bc.set_syntax(st1);
                    this.p.add(bc);
                }
            }else{
                st=CodeTable.get(st1);
                if(!st.equals("none")){
                    Class c=Class.forName("bytecode."+st);
                    ByteCode bc=(ByteCode) c.getDeclaredConstructor().newInstance();
                    st=st.replaceFirst(" ","");
                    // System.out.println(st);
                    bc.set_value(st1);
                    bc.set_syntax(st1);
                    this.p.add(bc);
                }
            }
        }
          //ByteCode bc=new HaltCode();
          //this.p.add(bc);
        }catch(Exception e){
            System.out.println("Error in ByteCodeLoader-loadCodes:"+e);
        }
       initCodes.clear();
        return this.p;
    }
}
