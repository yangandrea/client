package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class App 
{
    public static void main( String[] args )
    {
        try {
            Socket s = new Socket("localhost", 6789);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader inServ = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String stringaServer;
            int n = 0;
            do {
                n++;
                System.out.println("Inserisci un numero da indovinare");
                String st = in.readLine();
                out.writeBytes(st + '\n');
                stringaServer = inServ.readLine();
                if (stringaServer.equals("1"))
                {
                    System.out.println("Hai inserito un numero basso.");
                }
                if (stringaServer.equals("2"))
                {
                    System.out.println("hai inserito un numero piu alto.");
                }
                if(stringaServer.equals("4"))
                {
                    System.out.println("Devi inserire un numero compreso tra 1 e 100");
                }
            } while (Integer.parseInt(stringaServer)!= 3);
            System.out.println("Numero indovinato!");
            if(n == 1)
            {
                System.out.println("HAI INDOVINATO in un tentativo.");
            }
            else{
                System.out.println("HAI INDOVINATO in " + n + " tentativi!");
            }
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione!");
            System.exit(1);
        }
    }
}
