package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String a = list.get(i);
            String b = list.get(i + 1);

            if (a.length() <= b.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i, list.get(i));
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String tmp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, tmp);
        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = 0; i < list.size() - 1; ) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
            } else {
                i++;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        Stack<Integer> s = new Stack<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int v = queue.remove();
            queue.add(v);
            s.push(v);
        }

        boolean ok = true;

        for (int i = 0; i < size; i++) {
            int v = queue.remove();
            if (v != s.pop()) ok = false;
            queue.add(v);
        }

        return ok;
    }

    public void reorder(Queue<Integer> queue) {
        Stack<Integer> s = new Stack<>();
        while (!queue.isEmpty()) s.push(queue.remove());
        ArrayList<Integer> list = new ArrayList<>(s);
        list.sort(Integer::compare);
        for (int x : list) queue.add(x);
    }

    public void rearrange(Queue<Integer> queue) {
        Queue<Integer> evens = new LinkedList<>();
        Queue<Integer> odds = new LinkedList<>();

        while (!queue.isEmpty()) {
            int x = queue.remove();
            if (x % 2 == 0) evens.add(x);
            else odds.add(x);
        }

        queue.addAll(evens);
        queue.addAll(odds);
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s.length() > max) max = s.length();
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> s1 = new HashSet<>(list1);
        Set<Integer> s2 = new HashSet<>(list2);
        s1.retainAll(s2);
        return s1.size();
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> vals = new HashSet<>(map.values());
        return vals.size() == map.size();
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> res = new HashMap<>();
        for (String key : map1.keySet()) {
            if (map2.containsKey(key) && map1.get(key).equals(map2.get(key))) {
                res.put(key, map1.get(key));
            }
        }
        return res;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> res = new HashMap<>();
        for (var e : map.entrySet()) {
            res.put(e.getValue(), e.getKey());
        }
        return res;
    }

    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : map.values()) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }

        int bestVal = 0;
        int bestCount = Integer.MAX_VALUE;

        for (var e : freq.entrySet()) {
            int value = e.getKey();
            int count = e.getValue();

            if (count < bestCount || (count == bestCount && value < bestVal)) {
                bestCount = count;
                bestVal = value;
            }
        }

        return bestVal;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        int best = 0;

        for (int x : list) {
            int c = freq.getOrDefault(x, 0) + 1;
            freq.put(x, c);
            if (c > best) best = c;
        }

        return best;
    }
}