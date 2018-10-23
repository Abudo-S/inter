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
public class ArgsCode extends ByteCode{

    @Override
    public void execute(VirtualMachine aThis) {
       RunTimeStack rts=aThis.get_rts();
        String st=this.get_value();
        int x=Integer.parseInt(st);
        //System.out.println(rts.peekFP());
        rts.newFrameAt(x);
       // System.out.println("+"+(rts.get_size()-x));
        aThis.update_rts(rts);
    }
    
  
    
}
