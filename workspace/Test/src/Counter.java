import java.util.Scanner;


public class Counter {
	public static void main(String[] args) {
		int counter = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("��+�h+1�A��s�h�k�s");
		while(true){
			String s = input.nextLine();
			if(s.equals("+")){
				counter++;
				System.out.println(counter);
			}else if(s.equals("s")){
				counter = 0;
				System.out.println(counter);
			}
		}
	}

}
