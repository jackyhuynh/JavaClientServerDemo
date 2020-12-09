package driver;

/*
 * "<CIS 35B>- Lab <4>"
 * Student :	Truc Huynh
 * Program :	HW3
 * 
 */


import java.io.IOException;
import java.net.ServerSocket;
import server.CreateServerConnectionToClient;


public class Driver {
	
	public static void main(String args[])throws IOException 
        {
            CreateServerConnectionToClient server = new CreateServerConnectionToClient(new ServerSocket(5555));
        }
}