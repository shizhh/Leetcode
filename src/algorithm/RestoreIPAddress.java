package algorithm;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

	public List<String> restoreIpAddresses(String s){
		List<String> res = new ArrayList<>();
		restoreIp(s, res, 0, "", 0);
		return res;
	}
	
	private void restoreIp(String ip, List<String> res, int index, String restoredip, int count){
		if (count > 4)
			return;
		if (count == 4 && index == ip.length()){
			res.add(restoredip);
		}
		
		for (int i=1; i<4; i++){
			if (index+i>ip.length()){
				break;
			}
			String s = ip.substring(index, index+i);
			if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue;
			restoreIp(ip, res, index+i, restoredip+s+(count==3?"":"."), count+1);
		}
	}
	
	public static void main(String[] args){
//		String s = "25525511135";
		String s = "255101101";
		RestoreIPAddress main = new RestoreIPAddress();
		List<String> res = main.restoreIpAddresses(s);
		System.out.println(res);
	}
	
}
