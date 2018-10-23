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
public abstract class ByteCode {
    private String syntax;
   private String value;
  // private RunTimeStack rts;
   
   public ByteCode(){
   
   }
  /* public void my_func(){
       
   }*/
   public void set_value(String x){
       this.value=x;
   }
   public String get_value(){
       return this.value;
   }
   /*public void set_rts(RunTimeStack rts){
       this.rts=rts;
   }
   public RunTimeStack get_rts(){
       return this.rts;
   }*/
   public void set_syntax(String x){
       this.syntax=x;
   }
   public String get_syntax(){
       return this.syntax;
   }

    public abstract void execute(VirtualMachine aThis);
}
