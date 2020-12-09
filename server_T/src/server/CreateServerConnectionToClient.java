package server;

/**
 *
 * @author TrucHuynh
 */

import java.io.IOException;
import java.net.*;

public class CreateServerConnectionToClient {
	/**
	 * Create a new clientSocket
	 * Run the client Socket
	 * 
	 */
public CreateServerConnectionToClient(ServerSocket server){
	for(;;){
		
		try {
                    DefaultSocketClient clientSocket = new DefaultSocketClient(server.accept());
                    
                    //
                    clientSocket.start();
		} 
                catch (IOException e) 
                {
                    e.printStackTrace();
		}
	}
    }
}
