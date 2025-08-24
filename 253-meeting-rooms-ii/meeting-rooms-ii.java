class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 1) return 1;
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        for (int[] interval: intervals) {
            starts.add(interval[0]);
            ends.add(interval[1]);
        }
        Collections.sort(starts);
        Collections.sort(ends);

        int start = 0, end = 0, rooms = 0, count = 0;
        while (start < starts.size()) {
            if (starts.get(start) < ends.get(end)) {
                count++;
                start++;
            }
            else {
                count--;
                end++;
            }
            rooms = Math.max(rooms, count);
        }
        return rooms;
    }
}