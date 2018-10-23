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
public class PopCode extends ByteCode{

    @Override
    public void execute(VirtualMachine aThis) {
        RunTimeStack rts=aThis.get_rts();
        int n=Integer.parseInt(this.get_value());
        int c=0;
        //if(rts.get_size()>=n){
            for(int i=0;i<n;i++){
               // System.out.println("+++"+rts.get_size());
                if(rts.get_size()!=0){
                    rts.pop(); 
                    c++;
                }
            }
            aThis.update_rts(rts);
       // }
            if(c!=n){
            System.out.println("Can't apply 'PC': "+aThis.cur_pc()+",Note:it could be partially applied!");
        }
    }
}
