package algorithm;

public class DecodeWays {

	public static int numDecodings(String s){
		if (s==null || s.length()==0 || s.charAt(0)=='0'){
			return 0;
		}
		int n = s.length();
		int[] res = new int[n+1];
		res[0]=1;
		res[1]=1;
		for(int i=1; i<n; i++){
			char ch = s.charAt(i); 
			if(ch == '0'){
				if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2'){	//10, 20
					res[i+1]=res[i-1];
				}else{	// 00, 30,40,50,60,70,80,90
					return 0;
				}
			}
			else{
				if(s.charAt(i-1)=='0' || s.charAt(i-1)>'2'){	// 01-09, 31-99
					res[i+1]=res[i];
				}else if((s.charAt(i-1)=='2' && ch<='6') || s.charAt(i-1)=='1'){	//21-26, 11-19
					res[i+1]=res[i]+res[i-1];
				}else{				// 27-29
					res[i+1]=res[i];
				}
			}
		}
		return res[n];
	}
	
	public static void main(String[] args){
		String s = "26";
		System.out.println(numDecodings(s));
	}
}
