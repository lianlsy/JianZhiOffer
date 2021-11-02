class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0 || carry > 0) {
            int first = i >= 0 ? a.charAt(i) - '0' : 0;
            int second = j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append((char) (first + second + carry) % 2);
            carry = (first + second + carry) / 2;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
