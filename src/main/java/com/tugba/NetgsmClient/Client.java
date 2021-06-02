/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugba.NetgsmClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 *
 * @author tugbacanoglu
 */
public class Client {
    
    
 
    AsynchronousSocketChannel connect() throws IOException, InterruptedException, ExecutionException {
    
    AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
    InetSocketAddress hostAddress = new InetSocketAddress("127.0.0.1", 8000);
    Future<Void> future = client.connect(hostAddress);
    future.get();
      
    
    return client;
    }
    
    
    
//    public CompletableFuture<Void> postJSON(URI uri, Map<String,String> map)
//    throws IOException
//{
//    ObjectMapper objectMapper = new ObjectMapper();
//    String requestBody = objectMapper
//          .writerWithDefaultPrettyPrinter()
//          .writeValueAsString(map);
//
//    HttpRequest request = HttpRequest.newBuilder(uri)
//          .header("Content-Type", "application/json")
//          .POST(BodyPublishers.ofString(requestBody))
//          .build();
//
//    return HttpClient.newHttpClient()
//          .sendAsync(request, BodyHandlers.ofString())
//          .thenApply(HttpResponse::statusCode)
//          .thenAccept(System.out::println);
//}
//    
    
    
    public String sendMessage(String message) throws IOException, InterruptedException, ExecutionException {
    AsynchronousSocketChannel client = connect();
    byte[] byteMsg = new String(message).getBytes();
    ByteBuffer buffer = ByteBuffer.wrap(byteMsg);
    Future<Integer> writeResult = client.write(buffer);
    System.out.println(writeResult);
    

    writeResult.get();
    
    System.out.println(writeResult);
    
    buffer.flip();
    Future<Integer> readResult = client.read(buffer);
    
    // do some computation

    readResult.get();
    String echo = new String(buffer.array()).trim();
    System.out.println(echo);
    buffer.clear();
    return echo;
}
    
    
}
