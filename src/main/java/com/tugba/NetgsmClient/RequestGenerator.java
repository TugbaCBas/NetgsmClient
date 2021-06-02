/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugba.NetgsmClient;


import com.github.fge.jsonschema.main.JsonSchema;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.simple.JSONObject;

/**
 *
 * @author tugbacanoglu
 */
public class RequestGenerator {
    
    RequestGenerator ()throws IOException{
        
     JSONObject obj = new JSONObject();
     RequestBody body = generateRandom();
     obj.put("id",body.id);
     obj.put("operation",body.operation);
     obj.put("num1",body.num1);
     obj.put("num2", body.num2);

     StringWriter out = new StringWriter();
      obj.writeJSONString(out);
      
      System.out.println(out.toString());
      
     
    
    
    }
    
    
     static final String[] operations = {"Multiply", "Subtract", " Divide","Add"};  
    
    RequestBody generateRandom(){
    
        Random random = new Random();
        int rand_num1 = random.nextInt(10);
        int rand_num2 = random.nextInt(10);
        String rand_operation = operations[random.nextInt(operations.length)];
        int rand_id = random.nextInt(1000);
        RequestBody body = new RequestBody(rand_id, rand_operation, rand_num1, rand_num2);
        
        return body;
        
        
    }
    
   
    
    
//    void generateJSON() throws IOException{
//        
//     JSONObject obj = new JSONObject();
//     RequestBody body = generateRandom();
//     obj.put("id",body.id);
//     obj.put("operation",body.operation);
//     obj.put("num1",body.num1);
//     obj.put("num2", body.num2);
//
//     StringWriter out = new StringWriter();
//      obj.writeJSONString(out);
//      
//      System.out.println(out.toString());
//      
//    }
//    
    
    
    
    
    
}
