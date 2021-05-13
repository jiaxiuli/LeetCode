// 给你一个数组 points ，其中 points[i] = [xi, yi] ，表示第 i 个点在二维平面上的坐标。多个点可能会有 相同 的坐标。

// 同时给你一个数组 queries ，其中 queries[j] = [xj, yj, rj] ，表示一个圆心在 (xj, yj) 且半径为 rj 的圆。

// 对于每一个查询 queries[j] ，计算在第 j 个圆 内 点的数目。如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。

// 请你返回一个数组 answer ，其中 answer[j]是第 j 个查询的答案。

 

// 示例 1：


// 输入：points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
// 输出：[3,2,2]
// 解释：所有的点和圆如上图所示。
// queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆。
// 示例 2：


// 输入：points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
// 输出：[2,3,2,4]
// 解释：所有的点和圆如上图所示。
// queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆，queries[3] 是紫色的圆。

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/queries-on-number-of-points-inside-a-circle
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

/**
 * @param {number[][]} points
 * @param {number[][]} queries
 * @return {number[]}
 */
var countPoints = function(points, queries) {
    var res = [];
    for(let i in queries){
        res.push(0);
    }
    for(let i in queries){
        for( let j in points){
            if(getDistance(points[j][0], queries[i][0],points[j][1], queries[i][1]) 
            <= Math.pow(queries[i][2], 2)){
                res[i]++;
            }
        }
    }
    return res;
};

function getDistance(x1, x2, y1, y2) {
    return Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2);
}
