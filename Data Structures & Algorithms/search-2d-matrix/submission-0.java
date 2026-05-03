class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        int n = matrix.length, m = matrix[0].length;
        for(int i=0;i<n;i++) {
            if(target >= matrix[i][0] && target <= matrix[i][m-1]) {
                return searchElement(matrix[i], target);
            }
        }
        return false;
    }

    private boolean searchElement(int[] matrix, int target) {
        int low = 0, high = matrix.length;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(target == matrix[mid]) {
                return true;
            } else if(target < matrix[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
