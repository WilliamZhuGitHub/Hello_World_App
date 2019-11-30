import java.io.*;
import java.net.*;
import java.util.Scanner;

class ChatRoomClient {
	String IP;
	int port;
	Socket connectionSocket;
	DataOutputStream os;
	BufferedReader in;
	String name;
	Scanner scnr;


	public ChatRoomClient(String IP, int port) throws UnknownHostException, IOException
	{
		this.IP = IP;
		this.port = port;

		connectionSocket = new Socket(IP, port);
		os = new DataOutputStream(connectionSocket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		scnr = new Scanner(System.in);


	}
	public BufferedReader getIn()
	{
		return in;
	}
	public DataOutputStream getOs()
	{
		return os;
	}
	public Socket getSock()
	{
		return connectionSocket;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}	
	public Scanner getScanner()
	{
		return scnr;
	}
	public static void main(String argv[]) throws IOException{


		ChatRoomClient client = new ChatRoomClient("10.244.156.3", 8080);
		BufferedReader in = client.getIn();
		DataOutputStream os = client.getOs();
		Scanner scnr = client.getScanner();

		readThread read = new readThread(client.getSock(), client);
		writeThread write = new writeThread(client.getSock(), client);

		read.start();
		write.start();



	}	
}
