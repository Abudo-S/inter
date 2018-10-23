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
public class WriteCode extends ByteCode{

    @Override
    public void execute(VirtualMachine aThis) {
        RunTimeStack rts=aThis.get_rts();
        int x=rts.peek();
        if(x==-1){
            System.out.println("Can't apply 'PC': "+aThis.cur_pc());
        }else
        System.out.println(x);
    }
    
    
    
}
