package tesco;

import java.util.*;

public class StringWrapper {
	// Input: "Today is thursday. I am writing code"
	// Output: "Today", "is thu", "rsday.", "I am w", "riting", "code"

	// Input: " "
	// Output: "Today", "is thu", "rsday.", "I am w", "riting", "code"

//	public List<String> getStringWrapped(String input, int n) {
//		List<String> output = new ArrayList<>();
//		if (input == null || input.isEmpty()) {
//			return null;
//		}
//		
//		char prevChar = ' ';
//		for(int i=0; i<input.length();)
//		{
//			StringBuilder line = new StringBuilder();
//			int j=0;
//			
//			for(; (i+j)<input.length() && j<n;)
//			{
//				if(input.charAt(i+j)==' ' && prevChar==' ')
//				{
//					//do nothing.
//				}
//				else
//				{
//					line.append(input.charAt(i+j));
//				}
//				prevChar = input.charAt(i+j);
//				
//			}
//			i=i+j;
//			output.add(line.toString());
//		}
//		return output;
//	}

	public List<String> getStringWrapped(String actualInput, int n) {
		if (actualInput == null || actualInput.isEmpty()) {
			return null;
		}
		List<String> output = new ArrayList<>();
		String input = actualInput;
		System.out.println("Actual Input ::" + actualInput);
		//Remove all special characters with space, using the below code
		input = input.replaceAll("[^A-Za-z0-9]", " ");
		System.out.println("Sanitized Input1 =>" + input);
		//This is to sanitize the input. First trimming. Next, removing consecutive whitespaces with a single space.
		//This is important.
		input = input.trim().replaceAll("\\s+", " ");
		System.out.println("Sanitized Input2 =>" + input);
		
		for (int i = 0, j = n; i < input.length();i=i+n) {
			int endIndex = i + j > input.length() ? input.length() - 1 : i + j;
			String line = input.substring(i, endIndex);
			line = line.trim();
			if (line.length() == n) {
				output.add(line);
			} else if (line.length() < n) {
				//System.out.println("Hi");
				//String outputLine = line.substring(n);
				output.add(line);
				//String nextLine = outputLine.substring(n);
			}
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input1 = "Today is thursday. I am writing code";
		String input2 = "Today			is    thursday. I am writing code";
		List<String> output = new StringWrapper().getStringWrapped(input2, 6);
		//System.out.println(output);
		for (String outputString : output)
			System.out.println(outputString);
	}

}
