//FAITH KATABWA(KTBFAI002)



import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.Scanner;
import java.io.FileReader;

public class MedianFilter{
	
	static long startTime = 0;
	static Double[] output = new Double[0];
	static final ForkJoinPool fjPool = new ForkJoinPool();
	
	//Current Time IN MILLISECONDS
	private static void tick(){
		startTime = System.currentTimeMillis();
	}
	
	//Time taken to execute block of code in MILLISECONDS
	private static float tock(){
		return (System.currentTimeMillis() - startTime) / 1000.0f; 
	}
	
	//MedianFilter Method creating ForkJoinPool
	static void medianFilter(List<Double> list, int min, int max, int filter){
   
	  fjPool.invoke(new ParallelMedianFilter(list,  min,  max, filter));
	}

	public static void main(String[] args) throws FileNotFoundException{
		List<Double> list = new ArrayList<Double>();

		String inputFile = args[0];   //input data file
		int filter = Integer.parseInt(args[1]);      //Filter Size
		String outputFile = args[2]; //output data file
		
		//Reading input from file
		Scanner scan = new Scanner(new FileReader(inputFile));
		int arraySize = scan.nextInt();
		scan.nextLine();
		while(scan.hasNext()){
			String line = scan.nextLine();
			String[] data = line.split("\\s+");
			list.add(Double.parseDouble(data[1]));
		}
		scan.close(); // free memory
		
		Double[] sequentialOutput = new Double[list.size()];
		output = new Double[list.size()];
		int border = (filter-1)/2;
		
		System.gc(); //to minimize the likelihood that the garbage collector will run during your execution 
      
      
		tick();//To record the current time before stepping in the parallel median filterings
      
		medianFilter(list, 0, arraySize, filter); //Calls the ,medianFilter that Create ForkJoinPool
      
		float time = tock(); //TimeTaken to execute parallel median filtering block 
      
		System.out.println("Parallel median filtering took: " + time + "s");
    
		
		try{
		    PrintWriter output_to_File = new PrintWriter(outputFile, "UTF-8"); // Create a new textfile of the output
		    output_to_File.println(arraySize);
		    for(int i=0; i<arraySize; i++){
		    	output_to_File.println(i+ " " + output[i]); // the format of the text file output
		    }
		    output_to_File.close(); // to free memory
		} catch (IOException e) { // catches the error that might occur when the user tries to create a textfile that has the same name as the one that already exits
                               			
		}
		
	   System.gc();                                    //to minimize the likelihood that the garbage collector will run during your execution
		tick();                                         //starting time for sequential median filtering
		for(int i =0; i<list.size(); i++){
			List<Double> temp = new ArrayList<Double>();
			if(i<border || i>(list.size()-border-1)){
				sequentialOutput[i] = list.get(i);
			}
			else{
				for(int j=i-border; j<border+i+1;j++){
					temp.add(list.get(j));
				}
				Collections.sort(temp);
				sequentialOutput[i] = temp.get((temp.size()-1)/2);
			}
			temp.clear(); //to free the memory
		}
		
		float sTime = tock(); // TimeTaken to execute Sequential median filtering block
		System.out.println("Sequential median filtering took: " + sTime+"s");
		
	}
}

