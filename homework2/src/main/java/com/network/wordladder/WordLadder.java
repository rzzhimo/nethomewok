package com.network.wordladder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class WordLadder {

    private Set<String> usedWord = new TreeSet<String>();

    private char alphabet[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public char getChar(int i) {
        return alphabet[i];
    }

    public WordLadder() {
        dicInit();
    }

    ;
    private Set<String> dic = new TreeSet<String>();

    private void dicInit() {

        String file = "src/main/java/com/network/wordladder/dict.txt";

        try {
            if (file == "") {
                System.out.println("File is not exist");
            } else {

                FileReader in = new FileReader(file);

                BufferedReader reader = new BufferedReader(in);
                String line;
                while ((line = reader.readLine()) != null) {
                    // 一次读入一行数据

                    dic.add(line);
                }

                System.out.println("字典构建完成");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void setUsed(String word) {
        usedWord.add(word);
    }

    public boolean isUsed(String word) {
        return usedWord.contains(word);
    }

    private void neiborHood(String word, Vector<String> neibor) {
        //dicInit();
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < 26; j++) {
                String newWord = new String("");
                newWord = word.substring(0, i) + getChar(j) + word.substring(i + 1);
                if (dic.contains(newWord)) {
                    //System.out.println(neiborHood.toString());
                    neibor.add(newWord);
                }
            }

        }
    }

    public String dfs(String sourceWord, String targetWord) {

        Stack<String> wordStack = new Stack();
        wordStack.push(sourceWord);
        String ladder = "";
        sourceWord = sourceWord.toLowerCase();
        targetWord = targetWord.toLowerCase();

        Queue<Stack<String>> sq = new LinkedList<Stack<String>>();//新建队列

        sq.add(wordStack);//队列中存的是栈，栈中存的是原来的词

        while (!(sq.isEmpty())) {

            Stack<String> newStack = sq.poll();//新的栈接受队列sq返回的栈


            Vector<String> neibors = new Vector<String>();
            neiborHood(newStack.peek(), neibors);//判断是否是邻居


            for (int i = 0; i < neibors.size(); i++) {

                if (!isUsed(neibors.elementAt(i))) {
                    setUsed(neibors.elementAt(i));//表明用过这个单词了

                    if (neibors.elementAt(i).equals(targetWord)) {
                        System.out.println("find");

                        ladder += targetWord;
                        ladder += " ";
                        while (!newStack.empty()) {
                            ladder += newStack.pop();
                            ladder += " ";


                        }
                        usedWord.clear();//将用过的单词清零
                        return ladder;
                    } else {
                        Stack<String> copystack = new Stack<String>();

                        copystack.addAll(newStack);
                        copystack.push(neibors.elementAt(i));
                        sq.add(copystack);//将邻居所在的栈加入队列

                    }
                }
            }
        }
        ladder = "there is no ladder";
        return ladder;
    }

    ;

}

