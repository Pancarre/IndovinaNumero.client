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
        String send;
        DataOutputStream out;
        BufferedReader in;
        String status;

        try{

            s = new Socket("localhost",3000);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new DataOutputStream(s.getOutputStream());

            System.out.println("server pronto");
            tastiera = new BufferedReader(new InputStreamReader(System.in));

            do{
          
                System.out.println("inserisci numero");
                send = tastiera.readLine();
                out.writeBytes(send+"\n");
                status = in.readLine();

                System.out.println("risposta " + status);

                switch(status){
                    
                        
                    case "1":
                        System.out.println("numero è più grande");
                        break;
                    case "2":
                        System.out.println("numero è più piccolo");
                        break;
                    case "3":
                        int tentativi = Integer.parseInt(in.readLine());
                        System.out.println("numero è giusto " + tentativi);
                        break;
                    default:
                        System.out.println("numero non valido");
                        break;
                }

            }while(!status.equals("3"));
            s.close();

        }
        catch(Exception e){

                    System.out.println( "errore" + e.getMessage());

        }
        










    }
}
