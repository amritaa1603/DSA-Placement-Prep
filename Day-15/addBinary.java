class Solution {
    public String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Traverse both strings from right to left
        while (i >= 0 || j >= 0 || carry != 0) {

            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            // Add result bit
            result.append(sum % 2);

            // Update carry
            carry = sum / 2;
        }

        // Reverse final result
        return result.reverse().toString();
    }
}