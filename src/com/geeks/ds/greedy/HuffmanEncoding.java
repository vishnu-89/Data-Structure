package com.geeks.ds.greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Huffman coding (also known as Huffman Encoding) is an algorithm for doing data compression,
 * and it forms the basic idea behind file compression. This post talks about the fixed-length
 * and variable-length encoding, uniquely decodable codes, prefix rules, and Huffman Tree construction
 */
public class HuffmanEncoding {

    public static void main(String[] args)
    {
        String text = "Huffman coding is a data compression algorithm.";
        buildHuffmanTree(text);
    }

    public static void buildHuffmanTree(String text) {
        if (text == null || text.length() == 0) {
            return;
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (char c: text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.freq));

        for (Map.Entry<Character, Integer> entry: freq.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (pq.size() != 1) {

            Node left = pq.poll();
            Node right = pq.poll();

            int sum = left.freq + right.freq;
            pq.add(new Node(null, sum, left, right));
        }

        Node root = pq.peek();
        Map<Character, String> huffmanCode = new HashMap<>();
        encode(root, "", huffmanCode);

        System.out.println("Huffman Codes are: " + huffmanCode);
        System.out.println("The original string is: " + text);

        StringBuilder sb = new StringBuilder();
        for (char c: text.toCharArray()) {
            sb.append(huffmanCode.get(c));
        }

        System.out.println("The encoded string is: " + sb);
        System.out.print("The decoded string is: ");

        if (isLeaf(root)) {
            while (root.freq-- > 0) {
                System.out.print(root.ch);
            }
        }
        else {
            int index = -1;
            while (index < sb.length() - 1) {
                index = decode(root, index, sb);
            }
        }
    }

    public static void encode(Node root, String str, Map<Character, String> huffmanCode) {
        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            huffmanCode.put(root.ch, str.length() > 0 ? str : "1");
        }

        encode(root.left, str + '0', huffmanCode);
        encode(root.right, str + '1', huffmanCode);
    }

    public static int decode(Node root, int index, StringBuilder sb) {
        if (root == null) {
            return index;
        }
        if (isLeaf(root)) {
            System.out.print(root.ch);
            return index;
        }

        index++;

        root = (sb.charAt(index) == '0') ? root.left : root.right;
        index = decode(root, index, sb);
        return index;
    }

    public static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }
}

class Node
{
    Character ch;
    Integer freq;
    Node left = null;
    Node right = null;

    Node(Character ch, Integer freq){
        this.ch = ch;
        this.freq = freq;
    }

    public Node(Character ch, Integer freq, Node left, Node right) {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}