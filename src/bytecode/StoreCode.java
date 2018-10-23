/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bytecode;

import interpreter.RunTimeStack;
import interpreter.VirtualMachine;

/**
 *
 * @author mt
 */
public class StoreCode extends ByteCode{

    @Override
    public void execute(VirtualMachine aThis) {
        try{
        RunTimeStack rts=aThis.get_rts();
        String st=this.get_value();
       // st=st.replaceFirst(" ","");
        String[] new_st=st.split(" ");
        int x=Integer.parseInt(new_st[0]);
        //System.out.println("--"+x);
        x=rts.store(x);
        if(x==-1){
         System.out.println("Can't apply 'PC': "+aThis.cur_pc());
        }
        aThis.update_rts(rts);
              if(new_st.length>1){
                  // System.out.println(new_st[1]);
                 aThis.add_addr(x,new_st[1]);
                }
        }catch(Exception e){
            System.out.println("Not a valid input for command 'Store': "+e+",pc:"+aThis.cur_pc());
        }
    }
    
    
    
}
