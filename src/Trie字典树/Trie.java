package Trie字典树;

import java.util.TreeMap;

/**
 * 描述     Trie字典树
 *
 * @author lixinzhen
 * @create 2021/11/9 18:50
 */
public class Trie {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    //获得了Trie中存储的单词数量
    public int getSize() {
        return size;
    }

    //Trie中添加一个新的单词word
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        //以前存在单词
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    //查询单词word是否在Trie中
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }
    //查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c= prefix.charAt(i);
            if (cur.next.get(c)==null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }
    //Trie字典树和简单的模式匹配
    public boolean search(String word){
        return match(root,word,0);
    }
    private boolean match(Node node,String word,int index){
        if (index == word.length())
            return node.isWord;
        char c = word.charAt(index);
        if (c !='.'){
            if (node.next.get(c)==null)
                return false;
            return match(node.next.get(c),word,index+1);
        }
        else {
            for(char nextChar :node.next.keySet())
                if (match(node.next.get(nextChar),word,index+1))
                    return true;
                return false;
        }
    }

}
