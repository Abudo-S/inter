/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import bytecode.ByteCode;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author mt
 */
public class VirtualMachine {
    private Stack<Integer> returnAddrs;
    private RunTimeStack runStack;
    private Stack<String> returnFnames;
   // private Stack<String> varnames;
    private int pc;
    private Boolean isRunning;
    private Program program;   
    private boolean inter_switch=false;

    VirtualMachine(Program program) {
        this.program=program;
    }

    public void executeProgram(){
        try{
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<>();
        returnFnames=new Stack();
      //  varnames =new Stack();
        isRunning = true;
        while(isRunning){
            ByteCode code = program.getCode(pc); 
            if(code.getClass().getName().equals("bytecode.ReturnCode")&&this.inter_switch){
                System.out.println(code.get_syntax());
            }
            code.execute(this);
            if(!code.getClass().getName().equals("bytecode.DumpCode")){
               if(this.inter_switch==true){            
                    if(!code.getClass().getName().equals("bytecode.ReturnCode")){
                        System.out.println(code.get_syntax());
                         runStack.dump();
                        this.clean();
                    }
               }
            }
            pc++;
            if(pc>this.program.get_all_size()-1){
                isRunning=false;
            }
        }
       int x=this.runStack.get_size();
       
       /* for(int i=0;i<x;i++){
          System.out.println(this.runStack.pop());
        }*/
        }catch(Exception e){
            System.out.println("Can't fetch a ByteCode : "+this.cur_pc()+"\n"+e);
        }
    }
     public void add_addr(int x,String Vname){
        // returnAddrs.add(x);
         //varnames.add(Vname);
         this.program.set_value(Vname, x);
     }
     public void stop_running(){
         this.isRunning=false;
     }
     public RunTimeStack get_rts(){
         return this.runStack;
     }
     public void update_rts(RunTimeStack rts){
         this.runStack=rts;
     }
    /* public void solve_addr(){
         
     }*/
    /* public void add_lb(String name){
         this.program.add_lb(name);
     }*/
     public boolean add_v(String name,String x,String whole){
         return this.program.add_v(name,x,whole);
     }
    /* public void add_return_addr(String x){   
         this.returnAddrs.add(this.program.get_val(x));
         //System.out.println(x);
     }*/
     public boolean check_k(String x){
         return this.program.check_key(x);
     }
     public int cur_pc(){
         return this.pc;
     }
     public void mod_pc(int x){
         this.pc=x;
     }
     public int resolve_ret_addr(){
         int x=this.returnAddrs.peek();
         this.returnAddrs.clear();
         return x;
     }
     public void add_return_addN(String name,int x){
         this.returnFnames.add(name);
         this.returnAddrs.add(x);
     }
     public int get_return_add(){
         if(this.returnAddrs.size()>0){
             return this.returnAddrs.pop();
         }
         return -1;
     }
     public String get_return_N(){
         if(this.returnFnames.size()>0){
             return this.returnFnames.pop();
         }
         return "-1";
     }
     public void invokeAcall(String name){
         try{
             if(this.inter_switch==true&&(!name.contains("Write")||!name.contains("f"))){
             int y=0;
             if(!name.contains("Write")){
                  //System.out.println(name);
                Class x=Class.forName(this.program.getClass().getName());
                Method m=x.getDeclaredMethod(name,new Class[]{int.class});
                //System.out.println(this.runStack.peek());
                 y=(int)m.invoke(this.program,this.runStack.peek());
             }else
                {
                    y=this.program.Write();                    
                }
             this.returnFnames.push(name);
             //System.out.println(name);
             this.returnAddrs.push(y);
             //System.out.println(y);
             }
         }catch(Exception e){
             System.out.println("Can't invoke a function call:"+e+",'PC':"+this.cur_pc());
         }
     }
     public void switch_dump(boolean x){
         if(x==true){
             this.inter_switch=true;
         }else{
             this.inter_switch=false;
         }
     }
     public void clean(){
         this.returnAddrs.clear();
         this.returnFnames.clear();
         //this.program.resolveAddress();
     }
     
}
