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
public class DumpCode extends ByteCode{
   // private static boolean Dump=false;
    @Override
    public void execute(VirtualMachine aThis) {
        String x=this.get_value();
        x=x.replaceAll(" ","");
        x=x.toUpperCase();
        if(x.equals("ON")){
            aThis.switch_dump(true);
            
        }else{
            aThis.switch_dump(false);
        }
        
    }
    /*(public void set_dump(boolean x){
        Dump=x;
    }
    public boolean get_dump(){
        return Dump;
    }*/
   
   
    
}
