//package bearmaps.lab9;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
public class MyTrieSet implements TrieSet61B {

    private Node root;

    public MyTrieSet() {
        root = new Node('\0',false);
    }

    private class Node {
        private char nodeChar;
        private boolean isKey;
        private Map<Character,Node> map;

        public Node(char nodechar, boolean isleaf) {
            this.nodeChar = nodechar;
            this.isKey = isleaf;
            map = new HashMap<>();
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean contains(String key) {
        if (key == null || key.length() < 1 || root ==null) {
            return false;
        }
        Node curr = root;
        Node next = null;
        for (int i = 0, n = key.length(); i < n; i++) {
            char c = key.charAt(i);
            next = curr.map.get(c);
            if (next == null) {
                return false;
            }
            curr = next;
        }
        return curr.isKey;
    }

    @Override
    public void add(String key) {
        if (key == null || key.length() < 1) {
            return;
        }
        Node curr = root;
        for (int i = 0, n = key.length(); i < n; i++) {
            char c = key.charAt(i);
            if (!curr.map.containsKey(c)) {
                curr.map.put(c, new Node(c, false));
            }
            curr = curr.map.get(c);
        }
        curr.isKey = true;
    }

    @Override
    public List<String> keysWithPrefix(String prefix) {
        if (prefix == null || prefix.length() < 1 || root ==null) {
            return null;
        }
        List<String> reList = new ArrayList<>();
        Node curr = root;
        for (int i = 0, n = prefix.length(); i < n; i++) {
            char c = prefix.charAt(i);
            curr = curr.map.get(c);
        }
        if (curr.isKey) {
            reList.add(prefix);
        }
        for (Node currNode : curr.map.values()){
            if (currNode != null){
                getStringWithPrefix(reList, prefix, currNode);
            }
        }
        return reList;
    }

    private void getStringWithPrefix(List<String> reList, String word, Node currNode) {
        if (currNode.isKey) {
            reList.add(word + currNode.nodeChar);
        }
        for (Node NextNode : currNode.map.values()){
            if (NextNode != null){
                getStringWithPrefix(reList, word + currNode.nodeChar, NextNode);
            }
        }
    }

    @Override
    public String longestPrefixOf(String key) {
        if (key == null || key.length() < 1) {
            return null;
        }
        Node curr = root;
        String result = "";
        for (int i = 0, n = key.length(); i < n; i++) {
            char c = key.charAt(i);
            if (!curr.map.containsKey(c)) {
                break;
            }
            result = result + c;
            curr = curr.map.get(c);
        }
        return result;
    }
}
