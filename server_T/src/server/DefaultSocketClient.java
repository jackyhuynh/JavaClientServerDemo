/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

/**
 *
 * @author TrucHuynh
 */
import java.net.*;
import java.util.*;
import java.io.*;

public class 
    DefaultSocketClient extends Thread implements   SocketClientInterface,
                                                    SocketClientConstants {
   
    private ObjectInputStream reader;
    private ObjectOutputStream writer;
    private Socket sock;
    private String strHost;
    private int iPort;
    private BuildCarModelOptions build;
    
   
    //constructor
    public DefaultSocketClient(Socket server) throws IOException {
        this.sock  = server;
        this.build = new BuildCarModelOptions();
    }
  

    /**
     *      Over load the run method to run 
     */
        @Override
    public void run(){
    	if (openConnection())	 {
            try {
                handleSession();
            } 	catch (Exception e) {
                System.out.print("\n\tProplem handle session...!!!\n");	
                closeSession();
            }
            closeSession();
        }
    }//run
    
    
    /**
     *
     * @return boolean
     */
    @Override
    public boolean openConnection(){
    	try {
            writer = new ObjectOutputStream ( sock.getOutputStream());
            reader = new ObjectInputStream(sock.getInputStream());
    	    System.out.println ("\tClient is connected to server...");
    	    return true;
            } 
        catch (IOException e){
    	    if (DEBUG) System.err.println
                (strHost + "Unable to obtain stream to/from ");
    	    return false;
    	  }
    }
    
    
    /**
     *get user's choice ( upload, config or quit)
     * 
     * @throws java.lang.Exception
     */
    @Override
    public void handleSession() throws Exception{
    	  Properties pro = null;
    	  String strInput;
    	 
    	  try {
    		  strInput=(String)reader.readObject();
			
    		while (!(strInput.equals("q"))){
    				// upload method
                    if (strInput.equalsIgnoreCase("upload"))	{
                    	if(UploadCar(pro))
                			System.out.println("\nSucessfully upload properties file\n");
                    }
                    //	config method
                    else if (strInput.equalsIgnoreCase("config")) {   
                    	if(ConfigCar())
                    		System.out.println("\nSucessfully configuration the Car\n");
                    }
                    // get user's choice ( upload, config or quit)
    	       	    strInput=(String)reader.readObject();
    	       	}
            } catch (IOException e){
            if (DEBUG) 
            	System.out.println ("\nError in main control file\n");
            }
    	}       
    	 /**
    	  * this method calls a method of  BuildcarModelOptions to create 
    	  * an instance of automobile then send the result to the client 
    	  */
    private boolean UploadCar(Properties pro)
    {
    	boolean Flag= false;

        //get property file from  user
    	try {
			pro = (Properties)reader.readObject();
			handleInput (pro);
			Flag=true;
		} catch (ClassNotFoundException | IOException e) {
			 if (DEBUG)
				 System.out.println("\nError upload properties file\n");
			Flag= false;
		}
    	return Flag;
    	
    }
    /**
     * + ConfigCar():boolean
     * Logic:
     * 			get list of available model from server
     * 			send the list to the client so client can choose which car
     * 			and send an instance of the model from server to the client 
     * @ return Flag : boolean
     */
    private boolean ConfigCar()
    {
    	boolean Flag= false;
    	try {
        	ArrayList<String> list= build.listOfAvailableModel();
        	sendOutput(list);
        	build.sendSelectedmodelTOUser((String)reader.readObject(), writer);
			Flag=true;
		} catch (ClassNotFoundException | IOException e) {
			 if (DEBUG)
				 System.out.println("\nError configurate the Automobile\n");
			 Flag= false;
			}
    		return Flag;
    	}
    
    
   		/**
   	 	*	Logic:  Simple write St to console
     	* 	@param someObj	:someObject
     	*/
    	protected void sendOutput(Object anyObject)
        {
            try {
                writer.writeObject(anyObject);
            }
            catch (IOException e){
                if (DEBUG) System.out.println 
    	               ("Error writing to " + strHost);
            }
    	}
        
    	/**
         *	Logic:  create automobile and add to linkedhashmap
         * 	send message result to the user
         *  @param pro_Car:Properties 
         */
    	protected void handleInput(Properties pro_Car) {
            build.BuildAutoFromProObjAndAddtoLink(pro_Car);
            // send message result to the user
            sendOutput("\n\tCar model : \""+pro_Car.getProperty("CarModel")+ "\" is created...\n");
            }       

    	/**
    	 *
    	 */
    	@Override
    	public void closeSession()
    	{
    		try {
    			writer.close();
    			reader.close();
    			sock.close();
    		} catch (IOException e)	{
    			if (DEBUG) System.err.println
                	( "\nError closing socket to " + strHost+"\n");
    		}       
    	}

    	public void setHost(String strHost){
    		this.strHost = strHost;
    	}

    	public void setPort(int iPort){
    		this.iPort = iPort;
    	}
}