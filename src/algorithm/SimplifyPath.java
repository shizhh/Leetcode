package algorithm;

import java.util.Stack;

public class SimplifyPath {
	public static void main(String[] args){
		SimplifyPath main = new SimplifyPath();
		
		System.out.println(main.simplifyPath("/home//foo/"));
	}
	
	public String simplifyPath(String path){
		String[] tmp = path.split("/");
		Stack<String> stack = new Stack<>();
		for (String s : tmp){
			if (s.equals("") || s.equals(".")) {
				
			}else if (s.equals("..")) {
				if (stack.isEmpty());
				else stack.pop();
			}else {
				stack.push(s);
			}
		}
		//String result = "";
		if (stack.isEmpty())	return "/";
		else { 
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty()) {
				sb.insert(0, "/" + stack.pop());
			}
			return sb.toString();
		}
	}
}
