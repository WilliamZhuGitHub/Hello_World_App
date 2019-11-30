import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

//used https://www.geeksforgeeks.org/multi-threaded-chat-application-set-1/ as a reference 
//on how to handle added clients
class ClientHandler implements Runnable  
{ 
    Scanner scn = new Scanner(System.in); 
    private String name = ""; 
    final DataInputStream is; 
    final DataOutputStream os; 
    BufferedReader in;
    Socket s; 
    boolean isloggedin;
    ChatRoomServer server;

    public ClientHandler(Socket s, DataInputStream is, DataOutputStream os, ChatRoomServer server) { 
        this.is = is; 
        this.os = os; 
        this.s = s; 
        this.isloggedin=true;
        this.server = server;
        try {
			this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {}	
    } 
    public DataInputStream getIs()
    {
    	return is;
    }
    public DataOutputStream getOs()
    {
    	return os;
    }
    public void send(String message) throws IOException
    {
    	os.writeBytes(message + "\r\n");
    }
    public void sendAll(ArrayList<ClientHandler> arr, String message, String name)
    {
    	for(int i = 0; i < arr.size();i++)
    	{
    		try {
    			if(this != arr.get(i))
    			{
    				arr.get(i).send(name +": " + message);
				}
			} catch (IOException e) {}
    	}
    }
    public void allMessage(String message, ArrayList<ClientHandler> arr, String name)
    {
    	for(int i = 0; i < arr.size();i++)
    	{
    		try {
    			if(this != arr.get(i))
    			{
    				arr.get(i).send(name + message);
				}
			} catch (IOException e) {}
    	}
    }
    public void run() { 

    	try {

			send("Welcome to the chat! Please enter your name: ");
			name = in.readLine();
			send("Hello " + name + ", if you ever want to quit just enter {quit}");
			System.out.println(name + " has joined the chat!");
			allMessage(" has joined the chat!", server.getArray(), name);



			String message = in.readLine();


	        while (true)  
	        { 
	            sendAll(server.getArray(), message, name);
	            message = in.readLine();

	            if(message.equals("{quit}"))
	            {
	            	send(name + " has left the chat");
	            	System.out.println(name + " has left the chat");
	            	is.close();
	            	os.close();
	            	s.close();
	            	server.getArray().remove(this);
	            	System.exit(0);
	            	break;
	            }
	        }

		} catch (IOException e1) {
			System.out.println(name + " has left the chat");
			allMessage(" has left the chat", server.getArray(), name);
		}	


    } 
}  