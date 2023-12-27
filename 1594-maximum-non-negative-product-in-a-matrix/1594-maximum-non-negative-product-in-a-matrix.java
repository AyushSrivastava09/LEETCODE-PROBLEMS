class Solution {
    private static final int MODULO = 1_000_000_007;
    public int maxProductPath(int[][] grid) {
        SignedProduct[][] products = initSignedProducts(grid);
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                products[i][j] = getBestSignedProduct(grid[i][j], products[i-1][j], products[i][j-1]);
            }
        }
        return Math.max(-1, (int)(products[grid.length -1][grid[0].length -1].positive % MODULO));
    }

    private SignedProduct getBestSignedProduct(int val, SignedProduct up, SignedProduct left) {
        long minNegative = Long.MAX_VALUE, maxPositive = Long.MIN_VALUE;
        long[] candidates = new long[4];
        candidates[0] = up.positive * val;
        candidates[1] = up.negative * val;
        candidates[2] = left.positive * val;
        candidates[3] = left.negative * val;
        for (int i = 0; i < 4; i++) {
            minNegative = Math.min(minNegative, candidates[i]);
            maxPositive = Math.max(maxPositive, candidates[i]);
        }
        if (maxPositive < 0) {
            return new SignedProduct(minNegative, minNegative);
        } else if (minNegative > 0) {
            return new SignedProduct(maxPositive, maxPositive);
        } else {
            return new SignedProduct(maxPositive, minNegative);
        }
    }

    private SignedProduct[][] initSignedProducts(int[][] grid) {
        SignedProduct[][] products = new SignedProduct[grid.length][grid[0].length];
        int rollingProduct = grid[0][0];
        products[0][0] = new SignedProduct(rollingProduct, rollingProduct);
        for (int j = 1; j < grid[0].length; j++) {
            rollingProduct *= grid[0][j];
            products[0][j] = new SignedProduct(rollingProduct, rollingProduct);
        }
        rollingProduct = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            rollingProduct *= grid[i][0];
            products[i][0] = new SignedProduct(rollingProduct, rollingProduct);
        }
        return products;
    }

    private static class SignedProduct {
        long positive;
        long negative;
    
        public SignedProduct(long positive, long negative) {
            this.positive = positive;
            this.negative = negative;
        }
    }

}