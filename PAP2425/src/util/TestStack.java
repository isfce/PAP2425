package util;

public class TestStack {

	public static void main(String[] args) {
		StackInt s1= new StackInt(3);
		s1.push(10);
		s1.push(20);
		s1.push(30);
		while (!s1.empty()) {
			System.out.println(s1.pop());
		}
		//s1.pop();
			
	}

}
