以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

 

示例 1：

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    intervals.sort((a, b) => a[0] - b[0]);
    for (let i = 0 ; i < intervals.length - 1 ; i++) {
        const temp = [];
        if (intervals[i][1] >= intervals[i+1][0]) {
            if (intervals[i][1] >= intervals[i+1][1]) {
                temp.push(intervals[i][0]);
                temp.push(intervals[i][1]);
            } else {
                temp.push(intervals[i][0]);
                temp.push(intervals[i+1][1]);
            }
            intervals.splice(i, 2, temp);
            i--;
        }
    }
    return intervals;
};
