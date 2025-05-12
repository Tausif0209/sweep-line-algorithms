public class MeetingRooms {
  static boolean canAttend(int[][] arr) {
        if(arr.length==1) return true;
        int[] minMax=minMax(arr);
        int min=minMax[0];
        int max=minMax[1];
        int[] sweepLine=new int[max-min+1];
        for(int[]a:arr){
            sweepLine[a[0]-min]++;
            sweepLine[a[1]-min]--;
        }
        for(int i=1;i<=max-min;i++)
        {
            sweepLine[i]+=sweepLine[i-1];
            if(sweepLine[i]>1) return false;
        } return sweepLine[0]<=1;
    }
    private static int[] minMax(int[][] arr){
        int min=arr[0][0];
        int max=arr[0][1];
        for(int[] a:arr){
            min=Math.min(min,a[0]);
            max=Math.max(max,a[1]);
        }
        return new int[] {min,max};
    }
}
