class Solution {

    public String encode(String s[]) {
        // write your logic to encode the strings
        StringBuilder sb = new StringBuilder();
        for(String str: s) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public String[] decode(String s) {
        // write your logic to decode the string
        List<String> result = new ArrayList<>();
        int i=0;
        while(i<s.length()) {
            int j = i;
            while(s.charAt(j) != '#') j++;
            int len = Integer.parseInt(s.substring(i, j));
            String word = s.substring(j+1, j+1+len);
            result.add(word);
            i = j+1+len;
        }
        return result.toArray(new String[0]);
    }
}