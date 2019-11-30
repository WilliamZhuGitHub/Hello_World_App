import java.io.*;
import java.net.*;
import java.util.ArrayList;
//Zachary Baker
//Used https://www.geeksforgeeks.org/multi-threaded-chat-application-set-1/ as a reference
//on handling mutliple clients
 
public class ChatRoomServer  
{ 
    static ArrayList<ClientHandler> arr = new ArrayList<ClientHandler>();
    ServerSocket ss;
    
    public ChatRoomServer(int port) throws IOException
    {
    	ss = new ServerSocket(port);
    }
    public ServerSocket getSS()
    {
    	return ss;
    }
    public ArrayList<ClientHandler> getArray()
    {
    	return arr;
    }
    public static void sendAll(String message)
    {
    	for(int i = 0; i < arr.size(); i ++)
    	{
    		try {
    			arr.get(i).getOs().writeBytes(message + "\r\n");
    		}catch (IOException e) {
				e.printStackTrace();
			}
    	}
    } 

    public static void main(String[] args) throws IOException  
    { 
    	ChatRoomServer server = new ChatRoomServer(8080);
    	
         
        ServerSocket ss = server.getSS();
        System.out.println("Waiting for connection...");
          
        Socket sock; 
          
        // running infinite loop for getting 
        // client request 
        while (true)  
        { 
            // Accept the incoming request 
            sock = ss.accept(); 
            DataInputStream is = new DataInputStream(sock.getInputStream()); 
            DataOutputStream os = new DataOutputStream(sock.getOutputStream()); 
               
            // Create a new handler
            ClientHandler ch = new ClientHandler(sock, is, os, server,null); 
  
            Thread t = new Thread(ch);
            arr.add(ch); 
            t.start();
        } 
    } 
} 