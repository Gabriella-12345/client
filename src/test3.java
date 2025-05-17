import java.io.*;
import java.net.*;

public class test3 {
    public static void main(String args[]){
        Socket client = null;

        //defualt port number we are going to use
        int portnumber = 3000;
        if(args.length >= 1){
            portnumber = Integer.parseInt(args[0]);
        }

        for (int i=0; i<10 ; i++) {
            try {
                String msg = "";

                //create a cliet socket
                client = new Socket(InetAddress.getLocalHost(), portnumber);
                System.out.println("Client socket is created " + client);

                //create an output stream of the client socket
                OutputStream clientOut = client.getOutputStream();
                PrintWriter pw = new PrintWriter(clientOut, true);

                 //create an input stream of the client socket
                InputStream clientIn = client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));

                //create bufferredreader for a strand input 
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("Enter your name. Type Bye to exit.");

                //read data from standard input device and write it to the output
                // stream of the client socket
                msg = stdIn.readLine().trim();
                pw.println(msg);

                //read data from the input stream of the client socket.
                System.out.println("Massage returned from the server = " + br.readLine());
                
                //stop the operation
                if (msg.equalsIgnoreCase("Bye")) {
                    break;
                }
                
            } catch (IOException ie) {
                System.out.println("I/O error " + ie);
                // TODO: handle exception
            }
        }
        
    
    
    
    
    }
}
