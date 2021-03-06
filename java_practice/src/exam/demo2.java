package exam;



import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Ellen on 2017/4/1.
 */
public class demo2 {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String beginWord = in.nextLine();
        String endWord = in.nextLine();
        Set<String> wordList = new HashSet<>();
        while (in.hasNext()) {
            wordList.add(in.next());
        }

        System.out.print(ladderLength(beginWord,endWord,wordList));
    }

    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
       // int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }
}
