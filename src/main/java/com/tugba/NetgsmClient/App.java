package com.tugba.NetgsmClient;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException, ExecutionException
    {
        Client client = new Client();
        client.sendMessage("hello its me");
       RequestGenerator generator = new RequestGenerator();
       System.out.println(" hello") ;
    }
}
