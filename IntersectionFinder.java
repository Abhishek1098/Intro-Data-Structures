import java.util.ArrayList;
import java.io.*;
public class IntersectionFinder{
	
	public IntersectionFinder(){
		File name = new File("input-file.txt");

		ArrayList<ArrayList<String>> listHolder = new ArrayList<>();

		try{
			BufferedReader input = new BufferedReader(new FileReader(name));
			
			String text;	
			while( (text=input.readLine())!= null) {
				ArrayList<String> list = new ArrayList<>();
				String [] pieces = text.split(" ");
				for(int x = 0; x < pieces.length; x++){
					list.add(pieces[x]);
				}
				listHolder.add(list);
			}
		}
		catch (IOException io) {
			System.err.println("File does not exist");
		}
		
		int setCount=0;
		while(listHolder.size()>2){
			setCount++;

			ArrayList<String> list1 = listHolder.get(0);
			ArrayList<String> list2 = listHolder.get(1);
			ArrayList<String> list3 = listHolder.get(2);
			for(int i = 0; i < 3; i++){
				listHolder.remove(0);
			}
	
			ArrayList<Integer> intersections = new ArrayList<>();

			for(int x = 0; x < list1.size(); x++){
				String pointNumber = list1.get(x);
				for(int y = 0; y < list2.size(); y++){
					String checkNumber = list2.get(y);
					if(pointNumber.equals(checkNumber)){
						for(int z = 0; z < list3.size(); z++){
							checkNumber = list3.get(z);
							if(pointNumber.equals(checkNumber)){													intersections.add(Integer.valueOf(pointNumber));
							}
						}
					}
				}
			} 

			for (int i = 0; i < intersections.size()-1; i++){
      				int minIndex = i;
      				for (int j = i+1; j < intersections.size(); j++){
					if (intersections.get(j) < intersections.get(minIndex)){
						minIndex = j;
					}
				}
            			
      				Integer temp = intersections.get(i);
      				intersections.set(i, intersections.get(minIndex));
      				intersections.set(minIndex, temp);
			}

			System.out.println("Set "+setCount+" intersection="+intersections);	
		
		}
		

	}

	public static void main (String [] args){
		IntersectionFinder app = new IntersectionFinder();
	}
}