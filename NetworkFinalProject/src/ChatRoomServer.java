import java.io.*;
import java.net.*;
import java.util.ArrayList;
//Zachary Baker
//Used https://www.geeksforgeeks.org/multi-threaded-chat-application-set-1/ as a reference
//on handling mutliple clients
 
public class ChatRoomServer  
{ 
    static ArrayList<ClientHandler> connected = new ArrayList<ClientHandler>();//connected clients
    static ArrayList<ClientHandler> waiting = new ArrayList<ClientHandler>();//connected clients
    static ArrayList<ClientHandler> matched =  new ArrayList<ClientHandler>();//matched clients
    static Randomizer r = new Randomizer(waiting);
    ServerSocket ss;
    
    public ChatRoomServer(int port) throws IOException
    {
    	ss = new ServerSocket(port);
    }
    public ServerSocket getSS()//returns client server socket
    {
    	return ss;
    }
    public ArrayList<ClientHandler> getArray()//returns all clients connected to server
    {
    	return connected;
    }
    public static void broadcast(String message)//sends from server to all connected clients
    {
    	//iterates through all clients in the connected array
    	for(int i = 0; i < connected.size(); i ++)
    	{
    		try {
    			//sends message to all clients in the array
    			connected.get(i).getOs().writeBytes(message + "\r\n");
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
            r.setArr(waiting);//updates randomizer's array with new waiting clients
            
            DataInputStream is = new DataInputStream(sock.getInputStream()); 
            DataOutputStream os = new DataOutputStream(sock.getOutputStream()); 
               
            // Create a new handler
            ClientHandler ch = new ClientHandler(sock, is, os, server,null); 
  
            Thread t = new Thread(ch);
            connected.add(ch);//adds client to connected array
            waiting.add(ch);//adds client to waiting array
            
            ClientHandler m = r.match();
            //if the client is matched
            if(m != null)
            {
            	//removes matched partners from waiting array
            	waiting.remove(m);
            	waiting.remove(m.getPartner());
            	
            	//adds matched partners to connected array
            	matched.add(m);
            	matched.add(m.getPartner());
            	
            	//sets the status of both clients to matched
            	m.setMatched();
            	m.getPartner().setMatched();
            }
            t.start();
        } 
    } 
} 