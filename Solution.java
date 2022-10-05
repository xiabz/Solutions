// Given an array of meeting time intervals where intervals[i] = [start_i, end_i], determine if a person could attend all meetings.
// Input: meetings = [[0, 30], [15, 20], [5, 10]]
// Output: false

import java.util.Arrays;

public class Solution {
    public boolean checkMeeting(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] meetings1 = {{0, 30}, {15, 20}, {5, 10}};
        int[][] meetings2 = {};
        int[][] meetings3 = {{0, 5}, {15, 20}, {5, 10}};
        int[][] meetings4 = {{0, 5}};

        Solution s = new Solution();

        boolean s1 = s.checkMeeting(meetings1);
        boolean s2 = s.checkMeeting(meetings2);
        boolean s3 = s.checkMeeting(meetings3);
        boolean s4 = s.checkMeeting(meetings4);

        System.out.println(String.format("Test case 1: expected false, real %s", s1));
        System.out.println(String.format("Test case 1: expected true, real %s", s2));
        System.out.println(String.format("Test case 1: expected true, real %s", s3));
        System.out.println(String.format("Test case 1: expected true, real %s", s4));
    }
}


// Test case 1: expected false, real false
// Test case 1: expected true, real true
// Test case 1: expected true, real true
// Test case 1: expected true, real true