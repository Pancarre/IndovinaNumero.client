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
        int send;
        String receive;
        DataOutputStream out;
        BufferedReader in;
        int status = 4;



        try{

            s = new Socket("localhost",3000);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new DataOutputStream(s.getOutputStream());

            System.out.println("server pronto");

            tastiera = new BufferedReader(new InputStreamReader(System.in));



            while(status != 0){
                System.out.println("inserisci numero");

                send = tastiera.read();

                out.writeInt(send);

                status = in.read();

                System.out.println("risposta" + status);


                switch(status){

                    case 0:
                        System.out.println("numero giusto");
                        break;
                    case 1:
                        System.out.println("numero è più piccolo");
                        break;
                    case 2:
                        System.out.println("numero è più grande");
                        break;
                }

            }
           

            s.close();


        }
        catch(Exception e){

                    System.out.println( "errore" + e.getMessage());

        }
        










    }
}
