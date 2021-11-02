import java.net.*;
import java.io.*;
import java.util.Scanner;

public class server
{


    public static void main (String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        //server has an always active listening port to the computers requests
        ServerSocket s_server = new ServerSocket(7171);

        //server has another port to get readings from sensors
        Socket as_client = new Socket("localHost",5151);//client to sensor
        //output(request for readings) and input(readings) for the server as client
        DataInputStream dis_asclient_reading = new DataInputStream(as_client.getInputStream());
        DataOutputStream dos_asclient_request = new DataOutputStream(as_client.getOutputStream());

        while(true)
        {
            /*
            server here is listening to computer requests and sending recommendations
             */
            //wait and accept an area computer connection
            System.out.println("from server waiting...");
            Socket s1 = s_server.accept();
            //request(data input stream from the driver) + //recommendation output stream to the computer
            DataInputStream server_data_is = new DataInputStream(s1.getInputStream());
            DataOutputStream server_data_os = new DataOutputStream(s1.getOutputStream());
            System.out.println("SERVER ACCEPTED REQ");
            while(true)
            {
            //get request stream from computer client
            String str =  server_data_is.readUTF();
            System.out.println("from server :here is the received req..." + str);



            /*
            server here acts as a client to get readings from the sensors
             */

            System.out.print(" server as client >> Enter req to send to sensor:");
            String read_request = sc.next();
            dos_asclient_request.writeUTF(read_request);
            //flush the content of the buffer to the output stream
            dos_asclient_request.flush();
            String sensor_respond = dis_asclient_reading.readUTF();
            System.out.println("sensor_responds:" + sensor_respond);


            if(read_request.equals("bye"))
                break;



        }

            s_server.close();
            as_client.close();

        }




    }








}
