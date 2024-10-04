import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {
		Constant constants = new Constant();
		boolean isValidArg = true;
		while (isValidArg) {
			// Check arguments
			if (args[0].equals("a")) {
				isValidArg = false;
				System.out.println(constants.LOADING_MESSAGE);
				try {
					BufferedReader s = new BufferedReader(
							new InputStreamReader(new FileInputStream("students.txt")));
					String r = s.readLine();
					String i[] = r.split(",");
					for (String j : i) {
						System.out.println(j);
					}
				} catch (Exception e) {

				}
				System.out.println(constants.LOADED_MESSAGE);
			}
			else if (args[0].equals("r")) {
				isValidArg = false;
				System.out.println(constants.LOADING_MESSAGE);
				try {
					BufferedReader s = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String r = s.readLine();
					System.out.println(r);
					String i[] = r.split(",");
					Random x = new Random();
					int y = x.nextInt();
					System.out.println(i[y]);
				} catch (Exception e) {

				}
				System.out.println(constants.LOADED_MESSAGE);
			} 
			else if (args[0].contains("+")) {
				isValidArg = false;
				System.out.println(constants.LOADING_MESSAGE);
				try {
					BufferedWriter s = new BufferedWriter(
							new FileWriter("students.txt", true));
					String t = args[0].substring(1);
					Date d = new Date();
					String df = constants.DATA_FORMATE;
					DateFormat dateFormat = new SimpleDateFormat(df);
					String fd = dateFormat.format(d);
					s.write(", " + t + "\nList last updated on " + fd);
					s.close();
				} catch (Exception e) {

				}

				System.out.println(constants.LOADED_MESSAGE);
			} 
			else if (args[0].contains("?")) {
				isValidArg = false;
				System.out.println(constants.LOADING_MESSAGE);
				try {
					BufferedReader s = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String r = s.readLine();
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
				System.out.println(constants.LOADED_MESSAGE);
			} 
			else if (args[0].contains("c")) {
				isValidArg = false;
				System.out.println(constants.LOADING_MESSAGE);
				try {
					BufferedReader s = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String D = s.readLine();
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
				System.out.println(constants.LOADED_MESSAGE);
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