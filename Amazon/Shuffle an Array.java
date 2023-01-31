class Solution {
  private int[] nums;
  private Random random;

  public Solution(int[] nums) {
    this.nums = nums;
    this.random = new Random();
  }
  public int[] reset() {
    return nums;
  }
  public int[] shuffle() {
    int[] randomArray = nums.clone();
    for (int i = nums.length - 1; i > 0; i--) {
      int j = random.nextInt(i + 1);
      int t = randomArray[i];
      randomArray[i] = randomArray[j];
      randomArray[j] = t;
    }
    return randomArray;
  }
}