import java.io.*;
import java.util.*;
import java.net.*;

public class Download {
	public static void main(String[] args) throws IOException {
		Scanner keyin = new Scanner(System.in);
		System.out.print("Please input the internet address-->");
		String address = keyin.next();
		System.out.print("Please input the file name-->");
		String fileName = keyin.next();

		URL url = new URL(address);
		InputStream is = url.openStream();

		FileOutputStream fos = new FileOutputStream(fileName);
		int temp;
		while ((temp = is.read()) != -1) {
			fos.write(temp);
		}
		fos.close();
		is.close();
	}
}