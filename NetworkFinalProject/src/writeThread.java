import java.io.*;
import java.net.*;
import java.util.Scanner;
//Used https://www.codejava.net/java-se/networking/how-to-create-a-chat-console-application-in-java-using-socket
//as a reference on how to use threading in this case
public class writeThread extends Thread {
    private Socket socket;
    private ChatRoomClient client;
    DataOutputStream output;

    public writeThread(Socket socket, ChatRoomClient client) {
        this.socket = socket;
        this.client = client;

        this.output = client.getOs();

    }

    public void run() {


    	Scanner scnr = client.getScanner();
        String userName = scnr.nextLine();
        client.setName(userName);
        try {
			output.writeBytes(userName + "\r\n");
		} catch (IOException e) {}

        String text;

        do {
            text = scnr.nextLine();
            if(text.equals("{quit}"))
            {
            	try {
					output.writeBytes(client.getName() + " has left the chat!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	System.exit(0);
            }
            try {
				output.writeBytes(text + "\r\n");
			} catch (IOException e) {}

        } while (true);
    }
} 