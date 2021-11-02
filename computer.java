import java.io.*;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class computer
{
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        //making a client socket to send request for recommendation
        //and input stream is getting best route back from the server
        Socket computer = new Socket("localHost",7171);
        //output(request for readings) and input(readings) for the server as client
        DataInputStream dis_rec = new DataInputStream(computer.getInputStream());
        DataOutputStream dos_req = new DataOutputStream(computer.getOutputStream());


        while(true)
        {
            // Reading data from driver using readLine
            System.out.println("from computer enter req...");
            System.out.println("req sent from the driver");
            String read_request = sc.next();
            //flush the content of the buffer to the output stream
            dos_req.flush();
            //send request to the server
            dos_req.writeUTF(read_request);


            //get the recommendation from the server
            System.out.println("driver waiting for recommendation..");
            String server_respond = dis_rec.readUTF();
            
            System.out.println("the server respond for recommendation:" + server_respond);
            System.out.println("finally the driver receives the rec:)");

            if(read_request.equals("bye"))
                break;




        }


    computer.close();



    }
}

