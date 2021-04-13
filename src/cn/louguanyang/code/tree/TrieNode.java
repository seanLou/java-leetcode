package cn.louguanyang.code.tree;

/**
 * Trie Node
 *
 * @author louguanyang
 * @createAt 2021/4/13 10:10 下午
 */
public class TrieNode {
    public char data;
    public TrieNode[] children = new TrieNode[26];
    public boolean isEndChar = false;

    public TrieNode(char data) {
        this.data = data;
    }

}
