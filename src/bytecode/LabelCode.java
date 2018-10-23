/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bytecode;

import interpreter.VirtualMachine;

/**
 *
 * @author mt
 */
public class LabelCode extends ByteCode{

    @Override
    public void execute(VirtualMachine aThis) {
        String x=this.get_value();
        String[] st=x.split("<<");
        boolean isDone;
        st[0]=st[0].replaceAll(" ","");
        st[1]=st[1].replaceAll(">>|\\s+","");;
          isDone= aThis.add_v(st[0],st[1],x);
            if(isDone==false){
                System.out.println("the id is in use 'PC':"+aThis.cur_pc());
            }
    }
    
   
    
}
