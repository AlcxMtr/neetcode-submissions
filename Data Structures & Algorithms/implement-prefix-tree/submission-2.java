class PrefixTree {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean word = false;
    }

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = true;
    }

    public boolean search(String word) {
        return rSearch(root, word, 0);
    }

    private boolean rSearch(TrieNode node, String word, int idx) {
        if (idx == word.length()) return node.word;
        char c = word.charAt(idx);
        node = node.children[c - 'a'];
        if (node == null) return false;
        return rSearch(node, word, idx + 1);
    }

    public boolean startsWith(String prefix) {
        return rStartsWith(root, prefix, 0);
    }

    private boolean rStartsWith(TrieNode node, String word, int idx) {
        if (idx == word.length()) return true;
        char c = word.charAt(idx);
        node = node.children[c - 'a'];
        if (node == null) return false;
        return rStartsWith(node, word, idx + 1);
    }

}
