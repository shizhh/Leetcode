package algorithm;



public class Trie {
	
	class TrieNode {
		
		char val;
		boolean isWord;
		TrieNode[] children = new TrieNode[26];
		
		// Initialize your data structure here.
		public TrieNode() {    }
		
		public TrieNode(char c)
		{
			//TrieNode node = new TrieNode();
			//node.val = c;
			val = c;
		}
	}
	
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        int len = word.length();
        for (int i = 0; i < len; i++)
        {
        	char c = word.charAt(i);
        	if (node.children[c-'a'] == null)
        	{
        		TrieNode child = new TrieNode(c);
        		node.children[c-'a'] = child;
        	}
        	node = node.children[c-'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        int len = word.length();
        TrieNode node = root;
        for (int i = 0; i < len; i++)
        {
            char c = word.charAt(i);
            if (node.children[c-'a'] == null)	return false;
            else
            {
                node = node.children[c-'a'];
            }
        }
        return node.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	int len = prefix.length();
        TrieNode node = root;
        for (int i = 0; i < len; i++)
        {
            char c = prefix.charAt(i);
            if (node.children[c-'a'] == null)	return false;
            else
            {
                node = node.children[c-'a'];
            }
        }
        return true;

    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");