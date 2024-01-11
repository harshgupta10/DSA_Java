class Solution {
    public int longestCommonSubpath(int n, int[][] paths) {
        int minPathLen = Integer.MAX_VALUE;
        for (int[] p : paths) {
            minPathLen = Math.min(minPathLen, p.length);
        }

        return longestCommonSubpath(n, paths, minPathLen);
    }

    private int longestCommonSubpath(int n, int[][] paths, int minPathLen) {
        int left = 0, right = minPathLen;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (hasCommon(paths, mid, n)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    // rolling hash
    private boolean hasCommon(int[][] paths, int len, int n) {
        n++;
        int mod = (int) 1e9 + 7;
        long pow = 1;
        for (int i = 0; i < len - 1; i++) {
            pow = (pow * n) % mod;
        }

        Map<Long, List<int[]>> hashToEndIdx = new HashMap<>();
        for (int p = 0; p < paths.length; p++) {
            long hash = 0;
            for (int i = 0; i < paths[p].length; i++) {
                // drop left
                if (i >= len) {
                    hash = (hash - pow * paths[p][i-len]) % mod;
                }
                // add right
                hash = ((hash * n + paths[p][i]) % mod + mod) % mod;

                if (i >= len - 1) {
                    hashToEndIdx.computeIfAbsent(hash, l -> new ArrayList<>())
                                .add(new int[]{p, i});
                }
            }
        }

        for (List<int[]> endIdxs : hashToEndIdx.values()) {
            if (endIdxs.size() < paths.length) {
                continue;
            }

            int[] common = null;
            Set<Integer> friends = new HashSet<>();
            for (int[] endIdx : endIdxs) {
                int i = endIdx[0];
                int j = endIdx[1];

                if (!friends.add(i)) {
                    continue;
                }

                if (common == null) {
                    common = Arrays.copyOfRange(paths[i], j-len+1, j+1);
                } else {
                    if (!Arrays.equals(common, Arrays.copyOfRange(paths[i], j-len+1, j+1))) {
                        common = null;
                        break;
                    } 
                }
            }

            if (friends.size() == paths.length && common != null) {
                return true;
            }
        }

        return false;
    }
}