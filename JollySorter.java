import java.io.*;
import java.util.ArrayList;

public class JollySorter{

	public JollySorter(){
		
		ArrayList<ArrayList<Integer>> listHolder = new ArrayList<>();

		File name = new File("input-file-jolly.txt");
		try{
			BufferedReader input = new BufferedReader(new FileReader(name));
			
			String text;	
			while( (text=input.readLine())!= null) {
				String [] pieces = text.split(" ");
				listHolder.add(sort(pieces));
			}
		}
		catch (IOException io) {
			System.err.println("File does not exist");
		}


		System.out.println(listHolder);
	}

	public ArrayList<Integer> sort(String [] pieces){

		boolean ifAscending = true;
		
		ArrayList<Integer> output = new ArrayList<>();
		for(int x = 1; x < pieces.length; x++) output.add(Integer.valueOf(pieces[x])); 

		for(int x = 0; x < output.size()-1; x++){
			if(ifAscending){
				if(output.get(x) > output.get(x+1)){
					Integer temp = output.get(x);
					output.set(x, output.get(x+1));
					output.set(x+1, temp);
				}
				ifAscending = false;
			}else{
				if(output.get(x) < output.get(x+1)){
					Integer temp = output.get(x);
					output.set(x, output.get(x+1));
					output.set(x+1, temp);
				}
				ifAscending = true;
			}
		}

		return output;

	}

	public static void main (String [] args){
		JollySorter app = new JollySorter();
	}
}