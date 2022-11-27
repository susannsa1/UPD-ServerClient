//          SUSANN SALMEY           //
//      DISTRIBUTED SYSTEMS         //
//          MR. KLINGEMANN          //

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class UDPClient{
    public static void main( String args[]){
        // args[0]: Message
        // args[1]: Server
        try {

            //Program begin
           System.out.println("Press 1 too Add a new piece of art-object: \nPress 2 t shown all the names of a museum: ");


            //Scanner
            Scanner scanner = new Scanner(System.in);
            String scan = scanner.nextLine();
            //scanner.close();

            String send = new String();

            String method1= "1";
            String method2= "2";



            if(scan.equals(method1)){
                System.out.println("The name of the paintings: ");
                String name = scanner.nextLine();

                System.out.println("The name of the Artist: ");
                String artist = scanner.nextLine();

                System.out.println("How much is the price: ");
                String price = scanner.nextLine();

                System.out.println("In which museum do you want safe 1 or 2 or 3? : ");
                String safe = scanner.nextLine();

                send = method1 + "." + safe + "." + name + "." + artist + "." + price + ".";
                System.out.println("Message:" + send);

            } else if (scan.equals(method2)) {
                System.out.println("The name of which museum do you want print 1 or 2 or 3?: ");
                String safe = scanner.nextLine();

                send = method2 + "." + safe + ".";

            }

            DatagramSocket aSocket = new DatagramSocket();

            byte [] m = send.getBytes();
            InetAddress aHost = InetAddress.getByName(args[1]);
            int serverPort = 6789;
            DatagramPacket request = new DatagramPacket (m, m.length,
                    aHost, serverPort);
            aSocket.send (request);

            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive (reply);
            System.out.println(" Reply: " + new String(reply.getData()));
            aSocket.close();
        }catch (SocketException e){ System.out.println(" Socket: " + e.getMessage());
        }catch (IOException e){ System.out.println(" IO: " + e.getMessage());}
    }
} 