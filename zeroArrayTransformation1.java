class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] sweepLine=new int[nums.length+1];
        for(int[] querie:queries){
            sweepLine[querie[0]]++;
            sweepLine[querie[1]+1]--;
        }
        for(int i=1;i<nums.length;i++){
            sweepLine[i]+=sweepLine[i-1];
            if(sweepLine[i]<nums[i]) return false;
        }
        return (sweepLine[0]>=nums[0]);
    }
}