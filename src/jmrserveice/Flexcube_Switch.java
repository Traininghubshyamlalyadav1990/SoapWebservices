/***
	 * 
	 * This services is for validation perpose 
	 * @param req
	 * @return
	 */

package jmrserveice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Flexcube_Switch {
	
	
	protected static String server_IP = "141.117.57.42";
	private static final int server_Port = 5555 ;
	protected static String client_IP ;
	
	public static void main(String[] args) throws Exception, Exception {
		
	
		
		
		  final  String host = "localhost";
		    int init = 0  ;

		    try {
		        InetAddress iAddress = InetAddress.getLocalHost();
		        client_IP = iAddress.getHostAddress();
		        System.out.println("Current IP address : " +client_IP);
		    } catch (UnknownHostException e) {
		    }

		    try {System.out.println("hello1");
		        Socket socket = new Socket(server_IP,server_Port);
		        System.out.println("hello3");
		        init = initialize(socket);

		    }catch (SocketException e) {
		        System.out.println("Error: Unable to connect to server port ");
		    }


		    if (init ==  0 ){
		        System.out.println("error: Failed to initialize ");
		        System.exit(0);

		    }
		    //Thread init_Thread = new Thread();
		}
		private static int initialize(Socket socket ) throws IOException{
		    System.out.println("hello");
		    int rt_value = 0 ;

		    OutputStream os = socket.getOutputStream();
		    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    PrintWriter pw = new PrintWriter(os, true);

		    System.out.println("server: " + br.readLine());
		    pw.println("192.343.34.321");
		   // BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
		    //String userInput = userInputBR.readLine();

		    //out.println(userInput);

		    socket.close();
		    return rt_value = 1 ;



		
		
			
			
			
			
			
		
		
		
		
		
		
	}
}


