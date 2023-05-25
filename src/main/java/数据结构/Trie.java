package 数据结构;

import java.util.Map;
import java.util.TreeMap;

public class Trie {

    private Map<Character, Trie> childrens;

    private boolean isEnd;

    public Trie() {
        this.childrens = new TreeMap<>();
        this.isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            Trie children = node.childrens.get(c);
            if (children == null) {
                node.childrens.put(c, new Trie());
            }
            node = node.childrens.get(c);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            Trie children = node.childrens.get(c);
            if (children == null) {
                return null;
            }
            node = children;
        }
        return node;
    }
}
