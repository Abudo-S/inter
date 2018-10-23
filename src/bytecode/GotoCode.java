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
public class GotoCode extends ByteCode{

    @Override
    public void execute(VirtualMachine aThis) {
        String x=this.get_value();
        String[] st=x.split("<<");
        st[0]=st[0].replaceAll(" ","");
        st[1]=st[1].replaceAll("\\s+|>>","");
       // System.out.println(st[1]);
        /*if(aThis.check_k(st[0])){
            aThis.add_return_addr(st[0]);
        }*/
        int y=Integer.parseInt(st[1]);
        if(aThis.cur_pc()<y){
            aThis.mod_pc(y);
        }else{
             System.out.println("Can't apply 'PC': "+aThis.cur_pc()+",the program have already read this statment'PC'");
        }
    }
    
   
    
}
