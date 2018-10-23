/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import java.util.HashMap;

/**
 *
 * @author mt
 */
class CodeTable {
     private static HashMap<String,String> codes;
     
    public static String get(String key){
        if(codes.containsKey(key)){
            return codes.get(key);
        }else{
            return "none";
        }
    }
    public static void init(){
        codes=new HashMap<>();
        codes.put("HALT","HaltCode");
        codes.put("POP","PopCode");
        codes.put("FALSEBRANCH","FalseBranchCode");
        codes.put("GOTO","GotoCode");
        codes.put("STORE","StoreCode");
        codes.put("LOAD","LoadCode");
        codes.put("LIT","LitCode");
        codes.put("ARGS","ArgsCode");
        codes.put("CALL","CallCode");
        codes.put("RETURN","ReturnCode");
        codes.put("BOP","BopCode");
        codes.put("READ","ReadCode");
        codes.put("WRITE","WriteCode");
        codes.put("LABEL","LabelCode");
        codes.put("DUMP","DumpCode");
    }
}
