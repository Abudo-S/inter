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
public class LitCode extends ByteCode{

    @Override
    public void execute(VirtualMachine aThis) {
        RunTimeStack rts=aThis.get_rts();
        String st=this.get_value();
        
        String[] new_st=st.split(" ");
       try{
            //System.out.println(new_st[0]);
        int x=Integer.parseInt(new_st[0]);
            if(x>=0){
            rts.push(x);
            aThis.update_rts(rts);
            System.out.println();
                if(new_st.length>1){
                     //System.out.println(new_st[1]);
                    aThis.add_addr(x,new_st[1]);
                }
            }else{
                System.out.println("Can't add a negative number, "+"PC:"+aThis.cur_pc());
            }
        }catch(Exception e){
            System.out.println("Not a valid input for command 'LIT': "+e+",pc:"+aThis.cur_pc());
        }
        
    }
    
  
}
