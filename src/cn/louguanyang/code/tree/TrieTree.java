package cn.louguanyang.code.tree;

/**
 * Trie Tree
 * org.apache.commons.collections4.Trie
 * org.apache.commons.collections4.trie.PatriciaTrie
 * @author louguanyang
 * @createAt 2021/4/13 10:12 下午
 */
public class TrieTree {
    private TrieNode root = new TrieNode('/');

    // 往Trie树中插入一个字符串
    public void insert(char[] text) {
        TrieNode p = root;
        for (char c : text) {
            int index = c - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(c);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndChar = true;
    }


    // 在Trie树中查找一个字符串
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (char c : pattern) {
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        // false: 不能完全匹配，只是前缀；true: 找到pattern
        return p.isEndChar;
    }
}
