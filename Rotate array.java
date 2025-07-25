// Solution 1 - Intermediate Array
public void rotate(int[] nums, int k) {
if(k > nums.length)
k=k%nums.length;
int[] result = new int[nums.length];
for(int i=0; i < k; i++){
result[i] = nums[nums.length-k+i];
}
int j=0;
for(int i=k; i<nums.length; i++){
result[i] = nums[j];
j++;
}
System.arraycopy( result, 0, nums, 0, nums.length );
}



//Solution 2 - Bubble Rotate
public static void rotate(int[] arr, int order) {
if (arr == null || order < 0) {
throw new IllegalArgumentException("Illegal argument!");
}
for (int i = 0; i < order; i++) {
for (int j = arr.length - 1; j > 0; j--) {
int temp = arr[j];
arr[j] = arr[j - 1];
arr[j - 1] = temp;
}
}
}


// Solution 3 - Reversal
public static void rotate(int[] arr, int order) {
order = order % arr.length;
if (arr == null || order < 0) {
throw new IllegalArgumentException("Illegal argument!");
}
//length of first part
int a = arr.length - order;
reverse(arr, 0, a-1);
reverse(arr, a, arr.length-1);
reverse(arr, 0, arr.length-1);
}
public static void reverse(int[] arr, int left, int right){
if(arr == null || arr.length == 1)
return;
while(left < right){
int temp = arr[left];
arr[left] = arr[right];
arr[right] = temp;
left++;
right--;
}}
