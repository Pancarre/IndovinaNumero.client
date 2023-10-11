package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "client" );
        Socket s;
        BufferedReader tastiera;
        String stringaUtente;
        String stringaRicevutaDalServer;
        DataOutputStream out;
        BufferedReader in;




        try{
            tastiera = new BufferedReader(new InputStreamReader(System.in));

            s = new Socket("localhost",3000);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new DataOutputStream(s.getOutputStream());

            stringaUtente = tastiera.readLine();
            out.writeBytes(stringaUtente + "\n");

            stringaRicevutaDalServer = in.readLine();

            System.out.println( stringaRicevutaDalServer );

            s.close();




        }
        catch(Exception e){

                    System.out.println( "errore" + e.getMessage());

        }
        










    }
}
