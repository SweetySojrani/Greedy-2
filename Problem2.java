// Time Complexity - O(n) where n is the length of the tasks array
// Space Complexity - O(h) where h is the number of distinct tasks in the array

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length ==0)   return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int result =0;
        int maxfreq =0;
        int maxCount =0;
        for(int i=0;i < tasks.length;i++){
            char c = tasks[i];
            if(!map.containsKey(c)){
                map.put(c,0);
            }
            map.put(c,map.get(c)+1);
            maxfreq = Math.max(maxfreq,map.get(c));
        }
        for(char c : map.keySet()){
            if(map.get(c) == maxfreq)
                maxCount++;
        }
        int partitions = maxfreq -1;
        int empty = (n -(maxCount-1)) * partitions;
        int available = tasks.length - (maxfreq * maxCount);
        int idle = Math.max(0,empty-available);
        return tasks.length + idle;
    }
}
