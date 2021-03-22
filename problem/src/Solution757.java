import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution757 {
    class CharNode {
        Character word;
        Integer count;

        public CharNode(Character word, Integer count) {
            this.count = count;
            this.word = word;
        }
    }

    public String reorganizeString(String S) {
        if (S == null || S.length() == 1 || S.length() == 0) {
            return S;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        PriorityQueue<CharNode> queue = new PriorityQueue<>(new Comparator<CharNode>() {
            @Override
            public int compare(CharNode o1, CharNode o2) {
                return o1.count - o2.count == 0 ? o2.word - o1.word : o2.count - o1.count;
            }
        });

        for (int i = 0; i < S.length(); i++) {
            if (map.get(S.charAt(i)) == null) {
                map.put(S.charAt(i), 1);
            } else {
                map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
            }

            if (map.get(S.charAt(i)) > (S.length() + 1) / 2) {
                return "";
            }
        }

        for (Character word : map.keySet()) {
            queue.offer(new CharNode(word, map.get(word)));
        }

        StringBuffer sb = new StringBuffer();

        while(queue.size() > 1) {
            CharNode node1 = queue.poll();
            CharNode node2 = queue.poll();

            sb.append(node1.word).append(node2.word);
            node1.count--;
            node2.count--;

            if (node1.count > 0) {
                queue.offer(node1);
            }

            if (node2.count > 0) {
                queue.offer(node2);
            }
        }

        sb.append(queue.poll().word);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution757().reorganizeString("aaabbbc"));
    }
}
