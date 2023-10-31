class Solution {
    public double myPow(double x, int n) {
        return util1(x,n);
    }
    public double util1(double x, int n) {
		long N = (long) n;
		if (n < 0) {
			return 1.0 / helper2(x, N * -1);
		} else {
			return helper2(x, N);
		}
	}

	// will use binary exponention
	public double helper2(double x, long n) {
		if (n == 0) {
			return 1.0;
		}
		if (n % 2 == 0) {
			return helper2(x * x, n / 2);
		} else {
			return x * helper2(x * x, (n - 1) / 2);
		}
	}
}