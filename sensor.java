import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class sensor
{

        public static void main (String args[]) throws IOException
        {
            Scanner sc = new Scanner(System.in);
            //sensor acts as a server
            ServerSocket s_server = new ServerSocket(5151);


            while(true) {
            /*
            sensor here is listening to server requests and then send readings
             */
                //wait and accept an area computer connection
                System.out.println("from sensor waiting...");
                Socket s1 = s_server.accept();
                DataInputStream sensor_data_is = new DataInputStream(s1.getInputStream());
                DataOutputStream sensor_data_os = new DataOutputStream(s1.getOutputStream());

                System.out.println("SENSOR ACCEPTED REQ");
                while (true) {
                    String usr_msg = sensor_data_is.readUTF();
                    System.out.println("server as Client says:" + usr_msg);

                    sensor_data_os.writeUTF("Here is the readings from sensors: 123 ");
                    sensor_data_os.flush();
                    System.out.println("BEFORE LOOOOOPING AGAIN");


                    if (usr_msg.equals("bye")) {
                        break;
                    }


                }

                s_server.close();


            }
        }










}
