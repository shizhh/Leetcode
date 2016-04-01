package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences
{
	public List<String> findRepeatedDnaSequences(String s)
	{
		return findRepeatedDnaSequences2(s, 10);
	}
	
	private List<String> findRepeatedDnaSequences(String s, int letterLen)
	{
		List<String> result = new LinkedList<>();
		if (s == null || s.length() < letterLen )
		    return result;
		Map<String, Integer> visited = new HashMap<>();
		int len = s.length();
		int start = 0;
		while (start <= len-letterLen)
		{
			String dna = s.substring(start, start+letterLen);
			if (visited.get(dna) == null)
			{
				visited.put(dna, 1);
			}
			else if (visited.get(dna) == 1)
			{
				result.add(dna);
				visited.put(dna, 2);
			}
			else 
			{
				
			}
			start++;
		}
		
		return result;
		
	}
	
	public List<String> findRepeatedDnaSequences2(String s, int letterLen)
	{
		List<String> result = new LinkedList<>();
		Set<Integer> word = new HashSet<>();
		Set<Integer> doubleWord = new HashSet<>();
		
		int[] map = new int[26];
		map['A'-'A'] = 0;
		map['C'-'A'] = 1;
		map['G'-'A'] = 2;
		map['T'-'A'] = 3;
		
		for (int start = 0, len = s.length(); start <= len-letterLen; start++)
		{
			int v = 0;
			for (int i = start; i < start+10; i++)
			{
				v = v << 2;
				v |= map[s.charAt(i)-'A'];
			}
			
			if (!word.add(v) && doubleWord.add(v))
			{
				result.add(s.substring(start, start+letterLen));
			}
		}
		return result;
	}
	
	public List<String> findRepeatedDnaSequences2(String s) {
        List<String> result = new LinkedList<>();
        Set<Integer> word = new HashSet<>();
        Set<Integer> secondWord = new HashSet<>();
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            value <<= 2;
            value |= map[s.charAt(i) - 'A'];
            value &= 0xfffff;
            if (i < 9) {
                continue;
            }
            System.out.print(value + "\t");
            System.out.println(Integer.toBinaryString(value));
            if (!word.add(value) && secondWord.add(value)) {
                result.add(s.substring(i - 9, i + 1));
            }
        }
        return result;
    }
	
	public static void main(String[] args)
	{
		String s = "ACACACACACAC";
		RepeatedDNASequences main = new RepeatedDNASequences();
		System.out.println(main.findRepeatedDnaSequences2(s));
		//System.out.println(Integer.toBinaryString(1048575));
	}
	
}
