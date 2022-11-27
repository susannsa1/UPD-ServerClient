import java.util.Scanner;

import java.net.*;
import java.io.*;

public class UDPServer{
    public static void main( String args[]){
        System.out.println("The Server is running");


        // 3 Objects of Arts
        Art marjan = new Art("Top Dogs","Marjan",1820);
        Art madina = new Art("The Sandman","Madina",32);
        Art omar = new Art ("Blue Eyes","Omar",987234);


        // 3 Objects of Museum
        Museum museum1= new Museum("Museum_of_Madina",new Art[]{marjan});
        Museum museum2= new Museum("Museum_of_Omar", new Art[]{omar});
        Museum museum3= new Museum("Museum_of_Marjan",new Art[]{madina});





        try{
            DatagramSocket aSocket = new DatagramSocket (6789);
            byte[] buffer = new byte[1000];
            while(true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);

                aSocket.receive(request);
                System.out.println(" Request:" + new String(request.getData(), 0, request.getLength()));


                String send = new String(request.getData());
                String[] seperatdata = send.split("\\.",140);
                String m = " yeaah you did it!! ";

                //schauen ob ich adden oder printen soll => methode 1 /2
                if (seperatdata[0].equals("1")) {
                    if (seperatdata[1].equals("1")) {
                        museum1.addArt(seperatdata[2], seperatdata[3], Integer.valueOf(seperatdata[4]));
                    } else if (seperatdata[1].equals("2")) {
                        museum2.addArt(seperatdata[2], seperatdata[3], Integer.valueOf(seperatdata[4]));

                    } else if (seperatdata[1].equals("3")) {
                        museum3.addArt(seperatdata[2], seperatdata[3], Integer.valueOf(seperatdata[4]));
                    }
                } else if (seperatdata[0].equals("2")) {
                        m = "";
                    if (seperatdata[1].equals("1")) {
                        for (int i = 0; i < museum1.getArtObject().length; i++) {
                            m = m + museum1.getArtObject()[i].getName() + " ";
                        }

                    } else if (seperatdata[1].equals("2")) {
                        for (int i = 0; i < museum2.getArtObject().length; i++) {
                            m = m + museum2.getArtObject()[i].getName() + " ";
                        }
                    } else if (seperatdata[1].equals("3")) {
                        for (int i = 0; i < museum3.getArtObject().length; i++) {
                            m = m + museum3.getArtObject()[i].getName() + " ";
                        }
                    }
                }

                System.out.println("Museum1:" + museum1.getArtObject().length);
                System.out.println("Museum2:" + museum2.getArtObject().length);
                System.out.println("Museum3:" + museum3.getArtObject().length);



                DatagramPacket reply = new DatagramPacket(m.getBytes(),
                            m.length(), request.getAddress(), request.getPort());
                    aSocket.send(reply);

            }
        }catch (SocketException e){ System.out.println(" Socket: " + e.getMessage());
        }catch (IOException e) {System.out.println(" IO: " + e.getMessage());}
    } // main
} //class UDPServer
