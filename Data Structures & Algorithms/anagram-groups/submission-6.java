class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int counts[] = new int[26];
            str.chars().forEach(c -> counts[c - 'a']++);
            String id = Arrays.toString(counts);
            List<String> list = map.computeIfAbsent(id, c -> new ArrayList<String>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
