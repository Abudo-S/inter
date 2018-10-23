/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import bytecode.ByteCode;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author mt
 */
class Program {
    private int[] i=new int[1];
    private int[] j=new int[1];
    private int[] m=new int[1];
    private int[] k=new int[1];
    //private String Lrv;
     private ArrayList<ByteCode> allByteCodes=new ArrayList<>();
     private HashMap<String,String> labels=new HashMap();
     
     public int factorial(int n){    
        if (n == 0)    
          return 1;    
        else    
          return(n * factorial(n-1));    
     }    
     public int fibonacci(int n) { 
        if (n <= 1) 
           return n; 
        return fibonacci(n-1) + fibonacci(n-2); 
     } 
     public int Read(int x){
         return x;
     }
    public int f (int i) {
        //System.out.println(i);
        return i + j[0] + k[0] + 2;
      }
//m = f(3);
    public int Write(){
        //System.out.println(j[0]+"-------");
        return j[0]+m[0];
    }
//i = write(j+m);
    public void resolveAddress(){
       i=j=m=k=null;
    }
    public void set_value(String x,int val){
        try{
        if(x.contains("i")||x.contains("j")||x.contains("m")||x.contains("k")){
            if(x.matches("\\s*[i].*")){
                    this.i[0]=val;
                    //  System.out.println(this.i[0]+"*");
            }else if(x.matches("\\s*[j].*")){
                     this.j[0]=val;
                   //   System.out.println(this.j[0]+"*");
           }else if(x.matches("\\s*[m].*")){
                     this.m[0]=val;
                   //   System.out.println(this.m[0]+"*");
            }else if(x.matches("\\s*[k].*")){
                     this.k[0]=val;
                  //    System.out.println(this.k[0]+"*");
            }
    
        }  
        }catch(Exception e){
            System.out.println(e+"in Program");
        }
       }
    public void add(ByteCode bc){
        allByteCodes.add(bc);
    }
   /* public void delete(ByteCode bc){
        
    }*/

    ByteCode getCode(int pc) {
        return allByteCodes.get(pc);
    }
    public void add_lb(String name){
         if(!this.labels.containsKey(name)){
            this.labels.put(name," ");
         }
     }
    public boolean add_v(String name,String x,String whole){
        if(!this.labels.containsValue(x)){            
          
          if(this.labels.containsKey(name)){
             this.labels.put(whole,x);
            }else{
              this.labels.put(name,x);
           }
           return true;
        }
        return false;
       //System.out.println(this.labels.values());
    }
      public boolean check_key(String x){
          //System.out.println(this.labels.get(x));
         //System.out.println(this.labels.size());
        return this.labels.containsKey(x);
     }
      public int get_val(String name){
          //System.out.println(this.labels.values());
         // System.out.println("hello:"+this.labels.size());
          return Integer.parseInt(this.labels.get(name));
      }
      /*public void set_Lrv(String x){
          this.Lrv=x;
      }
      public String get_Lrv(){
          return this.Lrv;
      }*/
      public int get_all_size(){
          return this.allByteCodes.size();
      }
    
}
