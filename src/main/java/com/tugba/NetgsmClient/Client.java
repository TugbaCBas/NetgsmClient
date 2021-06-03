/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugba.NetgsmClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONString;
import org.json.simple.JSONObject;

/**
 *
 * @author tugbacanoglu
 */
public class Client {
    
    
 
    AsynchronousSocketChannel connect() throws IOException, InterruptedException, ExecutionException {
    
        
    AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
    InetSocketAddress hostAddress = new InetSocketAddress("localhost", 8088);
    Future future = null;
    while (client.getLocalAddress() == null)
    {
     future = client.connect(hostAddress);
    
    }
    future.get();
    System.out.println(future);
    System.out.println("local is"+ client.getLocalAddress());
    System.out.println("remote is"+ client.getRemoteAddress());
    
    
    return client;
    }
    
    
     
    
    
    public String sendMessage(String message) throws IOException, InterruptedException, ExecutionException {
        while (true){
    AsynchronousSocketChannel client = connect();
        }
  
    
    
//    if (client.isOpen()){
//        String absoluter = "jjdjhbhd";
//        ByteBuffer integer = ByteBuffer.wrap(absoluter.getBytes());
//        Future future = client.write(integer);
//        System.out.println(future);
//    }
//    byte[] byteMsg = new String("log message").getBytes();
//    ByteBuffer buffer = ByteBuffer.wrap(byteMsg);
//    Charset charset = StandardCharsets.UTF_8;
//    Future<Integer> writeResult = client.write(charset.encode(CharBuffer.wrap("GET"+"5555"+" HTTP/1.0\r\n\r\n")));
//    System.out.println(writeResult);
//    
//
//    writeResult.get();
//    
//    System.out.println(writeResult);
//    
//    buffer.flip();
//    Future<Integer> readResult = client.read(buffer);
//    
//    // do some computation
//
//    readResult.get();
//    String echo = new String(buffer.array()).trim();
//    System.out.println(echo);
//    buffer.clear();
//    return echo;
}
    
    
}
