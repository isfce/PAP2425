package util;

public class TestStack {

	public static void main(String[] args) {
		StackInt s1= new StackInt(3);
		s1.push(10);
		s1.push(20);
		s1.push(30);
		s1.push(40);
		while (!s1.empty()) {
			System.out.println(s1.pop());
		}
		//s1.pop();
		IStack<String> s2 = new Stack<>();
		s2.push("Vo");
		s2.push("Waf");
		s2.push("Hug");
		while (!s2.empty()) {
			System.out.println(s2.pop());
		}
			
	}

}
