/*
    Method: Binary Search;
    TimeComplexity: O(log(m + n)));
    SpaceComplexity: O(1);
    Time: 2019/10/27;
    Attention:
    1. Tricks and details in binary search.
       Reference: https://www.zhihu.com/question/36132386.
       1.1 when to use <= and when to use < ?. Why < is not working here? Because in the first loop, i is set to 1, and then iMin = iMax,
           directly jump into return 0.0;
       1.2 iMax = i -1 and Imax = i are both valid hear;
       1.3 why iMax = m instead of m - 1 ?
*/

class SolutionOne {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i != m && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i != 0 && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}



