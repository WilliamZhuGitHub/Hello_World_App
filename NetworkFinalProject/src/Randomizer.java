import java.util.ArrayList;
import java.util.Random;

public class Randomizer {
	
	private Random randomGenerator;//"random" number generator
	private ArrayList<ClientHandler> arr;//array of clients waiting to be matched, they will be removed when matched
	
	//constructor for randomizer
	public Randomizer(ArrayList<ClientHandler> arr)
	{
		this.arr = arr;
	}
	//getter for arr
	public ArrayList<ClientHandler>getArr()
	{
		return this.arr;
	}
	//setter for arr
	public void setArr(ArrayList<ClientHandler> arr)
	{
		this.arr = arr;
	}
	
	
	public ClientHandler match()
	{
		//takes the first client in the array as client1 and removes them
		ClientHandler client1 = arr.get(0);
		arr.remove(0);
		
		ClientHandler client2 = null;
		
		//only when client size is greater than 3
		//this ensures that the first two wont always be matched with one another
		if(arr.size() >= 3)
		{
			client2 = arr.get(randomGenerator.nextInt(arr.size()));
			
			client1.setPartner(client2);
			client2.setPartner(client1);
			
			arr.remove(client2);//matches with random client and removes them from the list
		}
		
		return client2;//if client is not matched will return null
	}
	
	
}
