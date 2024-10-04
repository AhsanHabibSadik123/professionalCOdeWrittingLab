import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {
		boolean isValidArg = true;
		while (isValidArg) {
			// Check arguments
			if (args[0].equals("a")) {
				isValidArg = false;
				System.out.println("Loading data ...");
				try {
					BufferedReader fileReader = new BufferedReader(
							new InputStreamReader(new FileInputStream("students.txt")));
					String read = fileReader.readLine();
					String i[] = read.split(",");
					for (String j : i) {
						System.out.println(j);
					}
				} catch (Exception e) {

				}
				System.out.println("Data Loaded.");
			}
			else if (args[0].equals("r")) {
				isValidArg = false;
				System.out.println("Loading data ...");
				try {
					BufferedReader fileReader = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String read = fileReader.readLine();
					System.out.println(read);
					String string[] = read.split(",");
					Random random = new Random();
					int y = random.nextInt();
					System.out.println(string[y]);
				} catch (Exception e) {

				}
				System.out.println("Data Loaded.");
			} 
			else if (args[0].contains("+")) {
				isValidArg = false;
				System.out.println("Loading data ...");
				try {
					BufferedWriter fileWriter = new BufferedWriter(
							new FileWriter("students.txt", true));
					String t = args[0].substring(1);
					Date date = new Date();
					String formate = "dd/mm/yyyy-hh:mm:ss a";
					DateFormat dateFormat = new SimpleDateFormat(formate);
					String fd = dateFormat.format(date);
					fileWriter.write(", " + t + "\nList last updated on " + fd);
					fileWriter.close();
				} catch (Exception e) {

				}

				System.out.println("Data Loaded.");
			} 
			else if (args[0].contains("?")) {
				isValidArg = false;
				System.out.println("Loading data ...");
				try {
					BufferedReader fileReader = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String r = fileReader.readLine();
					String i[] = r.split(",");
					boolean done = false;
					String t = args[0].substring(1);
					for (int idx = 0; idx < i.length && !done; idx++) {
						if (i[idx].equals(t)) {
							System.out.println("We found it!");
							done = true;
						}
					}
				} catch (Exception e) {

				}
				System.out.println("Data Loaded.");
			} 
			else if (args[0].contains("c")) {
				isValidArg = false;
				System.out.println("Loading data ...");
				try {
					BufferedReader fileReader = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String D = fileReader.readLine();
					char a[] = D.toCharArray();
					boolean in_word = false;
					int count = 0;
					for (char c : a) {
						if (c == ' ') {
							if (!in_word) {
								count++;
								in_word = true;
							} else {
								in_word = false;
							}
						}
					}
					System.out.println(count + " word(s) found " + a.length);
				} catch (Exception e) {

				}
				System.out.println("Data Loaded.");
			}
			else{
				System.out.println("Invalid Argument. Please Enter a Valid Argument (a , r , c , ?studentName , +studentName)");
				Scanner inputScanner = new Scanner(System.in);
				String inputArg = inputScanner.nextLine();
				args = inputArg.split("//s+");
				isValidArg = true;
			}
		}
	}
}