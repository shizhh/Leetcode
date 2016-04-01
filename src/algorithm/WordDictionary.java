package algorithm;


class Node
{
	char val;
	boolean isWord;
	Node[] children = new Node[27];
	
	Node() {}
	
	Node(char c){ val = c;}
}

public class WordDictionary
{
	private Node root;
	
	public WordDictionary()
	{
		root = new Node();
		root.val = ' ';
	}
	
	
    // Adds a word into the data structure.
    public void addWord(String word) {
        Node cur = root;
        int len = word.length();
        for (int i = 0; i < len; i++)
        {
        	char c = word.charAt(i);
        	if (c == '.')
        	{
        		if (cur.children[26] == null)
        		{
        			Node child = new Node(c);
        			cur.children[26] = child;
        		}
        		cur = cur.children[26];
        	}
        	else
        	{
        		if (cur.children[c-'a'] == null)
        		{
        			Node child = new Node(c);
        			cur.children[c-'a'] = child;
        		}
        		cur = cur.children[c-'a'];
        	}
        }
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    private boolean search(String word, int index, Node cur)
    {
    	if (index == word.length())
    	{
    		if(cur.isWord)
    			return true;
    		return false;
    	}
    	Node[] children = cur.children;
    	char c = word.charAt(index);
    	if (c == '.')
    	{
    		for (int i = 0; i < 27; i++)
    		{
    			Node n = children[i];
    			if (n != null)
    			{
    				boolean b = search(word, index+1, n);
    				if (b)
    					return true;
    			}
    		}
    		return false;
    	}
    	else
    	{
    		Node node = children[c-'a'];
    		if (node == null)
    			return false;
    		return search(word, index+1, node);
    	}
    	  
    }
    
    //Your WordDictionary object will be instantiated and called as such:
    //WordDictionary wordDictionary = new WordDictionary();
    //wordDictionary.addWord("word");
    //wordDictionary.search("pattern");
    public static void main(String[] args)
    {
    	WordDictionary wordDictionary = new WordDictionary();
    	wordDictionary.addWord("bad");
    	wordDictionary.addWord("dad");
    	wordDictionary.addWord("mad");
    	
    	boolean a1 = wordDictionary.search("pad");
    	boolean a2 = wordDictionary.search("bad");
    	boolean a3 = wordDictionary.search(".ad");
    	boolean a4 = wordDictionary.search("b..");
    	
    	System.out.println(a1);
    	System.out.println(a2);
    	System.out.println(a3);
    	System.out.println(a4);
    }
}

