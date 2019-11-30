import java.io.*;
import java.net.*;
//Used https://www.codejava.net/java-se/networking/how-to-create-a-chat-console-application-in-java-using-socket
//as a reference on how to use threading in this case
public class readThread extends Thread {
    private BufferedReader reader;
    private Socket socket;
    private ChatRoomClient client;

    public readThread(Socket socket, ChatRoomClient client) {
        this.socket = socket;
        this.client = client;

        try {
            InputStream input = socket.getInputStream();
            reader = client.getIn();
        } catch (IOException ex) {}
    }

    public void run() {
        while (true) {
            try {
                String response = reader.readLine();
                System.out.println(response);
            } catch (IOException ex) {
                break;
            }
        }
    }
} 