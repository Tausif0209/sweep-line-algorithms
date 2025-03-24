import java.util.TreeMap;

class Solution {
    public int countDays(int days, int[][] meetings) {
        TreeMap<Integer,Integer> sweepLine=new TreeMap<>();
        for(int[] m:meetings) {
            sweepLine.put(m[0],sweepLine.getOrDefault(m[0],0)+1);
            sweepLine.put(m[1]+1,sweepLine.getOrDefault(m[1]+1,0)-1);
        }
        for(Integer key:sweepLine.keySet()){
            Integer lowerKey=sweepLine.lowerKey(key);
            if(lowerKey==null) continue;
            sweepLine.put(key,sweepLine.get(lowerKey)+sweepLine.get(key));
        }
        int countDays=0;
        int i=1;
        boolean flag=true;
        for(Integer key:sweepLine.keySet()){
            int n=sweepLine.get(key);
            if(n==0){
                i=key;
                flag=true;
            }
            else if(flag){
                flag=false;
                countDays+=key-i;
            }
        }
        return countDays + (days+1-i);
    }
}
