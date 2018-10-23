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
public class FalseBranchCode extends ByteCode{

    @Override
    public void execute(VirtualMachine aThis) {
        String x=this.get_value();
        String[] st=x.split("<<");
        st[0]=st[0].replaceAll(" ","");
        st[1]=st[1].replaceAll(">>|\\s+","");
        RunTimeStack rts=aThis.get_rts();
        boolean isDone=false;
        if(rts.get_size()>0){
            int y=rts.pop();
            if(y==-1){
            System.out.println("Can't apply 'PC': "+aThis.cur_pc());
            }
            else if(y==0){
               isDone= aThis.add_v(st[0],st[1],x);
            }
            if(isDone==false){
                System.out.println("the id is in use 'PC':"+aThis.cur_pc());
            }
        }
    }
    
    
    
}
