class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();) {
            int j=i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + len;
            result.add(str.substring(i, j));
            i = j;
        }
        return result;
    }
}
