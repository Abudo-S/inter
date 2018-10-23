/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bytecode;

import interpreter.RunTimeStack;
import interpreter.VirtualMachine;
import java.lang.reflect.Method;

/**
 *
 * @author mt
 */
public class CallCode extends ByteCode{

    @Override
    public void execute(VirtualMachine aThis) {
      String x=this.get_value();
        String[] st=x.split("<<");
        st[0]=st[0].replaceAll(" ","");
        if(st.length>1){
         st[1]=st[1].replaceAll(">>|\\s+","");
        }
        aThis.invokeAcall(x);
        /*try{
            RunTimeStack rts=aThis.get_rts();
             int y=0;
             Class cl=Class.forName("interpreter.Program");
              Object ob = cl.newInstance();
             if(!st[0].contains("Write")){
                  System.out.println(st[0]);
                Method m=cl.getDeclaredMethod(st[0],new Class[]{int.class});
                m.setAccessible(true);
                 y=(int)m.invoke(ob,rts.peek());
             }else
                {
                    Method m=cl.getDeclaredMethod(st[0],new Class[]{});
                     m.setAccessible(true);
                    y=(int)m.invoke(ob);
                }
             aThis.add_addr(y, st[0]);
             System.out.println(y);
         }catch(Exception e){
             System.out.println("Can't invoke a function call:"+e+",'PC':"+aThis.cur_pc());
         }*/
        
    }
    
    
    
    
}
