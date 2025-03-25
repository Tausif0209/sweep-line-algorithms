import java.util.TreeMap;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        TreeMap<Integer,Integer> x_axis=new TreeMap<>();
        TreeMap<Integer,Integer> y_axis=new TreeMap<>();
        for(int[] r:rectangles){
            x_axis.put(r[0]+1,x_axis.getOrDefault(r[0]+1,0)+1);
            y_axis.put(r[1]+1,y_axis.getOrDefault(r[1]+1,0)+1);
            x_axis.put(r[2],x_axis.getOrDefault(r[2],0)-1);
            y_axis.put(r[3],y_axis.getOrDefault(r[3],0)-1);
        }
        int count=0;
        for(Integer key:x_axis.keySet()){
            Integer lowerKey=x_axis.lowerKey(key);
            if(lowerKey!=null) x_axis.put(key,x_axis.get(lowerKey)+x_axis.get(key));
        }
        for(Integer key:x_axis.keySet()){
            if(x_axis.get(key)==0) count++;
        }
        if(count>=3) return true;
        count=0;
         for(Integer key:y_axis.keySet()){
            Integer lowerKey=y_axis.lowerKey(key);
            if(lowerKey!=null) y_axis.put(key,y_axis.get(lowerKey)+y_axis.get(key));
    }
     for(Integer key:y_axis.keySet()){
            if(y_axis.get(key)==0) count++;
        }
        return count>=3;
}}