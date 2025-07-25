// Naive Approach
public static String longestPalindrome1(String s) {
int maxPalinLength = 0;
String longestPalindrome = null;
int length = s.length();
// check all possible sub strings
for (int i = 0; i < length; i++) {
for (int j = i + 1; j < length; j++) {
int len = j - i;
String curr = s.substring(i, j + 1);
if (isPalindrome(curr)) {
if (len > maxPalinLength) {
longestPalindrome = curr;
maxPalinLength = len;
}
}
}
}
return longestPalindrome;
}
public static boolean isPalindrome(String s) {
for (int i = 0; i < s.length() - 1; i++) {
if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
return false;
}
}
return true;
}



//Dynamic Programming
public static String longestPalindrome2(String s) {
if (s == null)
return null;
if(s.length() <=1)
return s;
int maxLen = 0;
String longestStr = null;
int length = s.length();
int[][] table = new int[length][length];
for (int i = 0; i < length; i++) {
table[i][i] = 1;
}
printTable(table);
for (int i = 0; i <= length - 2; i++) {
if (s.charAt(i) == s.charAt(i + 1)){
table[i][i + 1] = 1;
longestStr = s.substring(i, i + 2);
}
}
printTable(table);
for (int l = 3; l <= length; l++) {
for (int i = 0; i <= length-l; i++) {
int j = i + l - 1;
if (s.charAt(i) == s.charAt(j)) {
table[i][j] = table[i + 1][j - 1];
if (table[i][j] == 1 && l > maxLen)
longestStr = s.substring(i, j + 1);
} else {
table[i][j] = 0;
}
printTable(table);
}
}
return longestStr;
}
public static void printTable(int[][] x){
for(int [] y : x){
for(int z: y){
System.out.print(z + " ");
}
System.out.println();
}
System.out.println("------");
}


// Simple Algorithm
public String longestPalindrome(String s) {
if (s.isEmpty()) {
return null;
}
if (s.length() == 1) {
return s;
}
String longest = s.substring(0, 1);
for (int i = 0; i < s.length(); i++) {
String tmp = helper(s, i, i);
if (tmp.length() > longest.length()) {
longest = tmp;
}
tmp = helper(s, i, i + 1);
if (tmp.length() > longest.length()) {
longest = tmp;
}
}
return longest;
}
public String helper(String s, int begin, int end) {
while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) ==
s.charAt(end)) {
begin--;
end++;
}
return s.substring(begin + 1, end);
}
