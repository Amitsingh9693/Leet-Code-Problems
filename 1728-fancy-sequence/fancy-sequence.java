class Fancy {

    ArrayList<Long> arr;
    long mul = 1;
    long add = 0;
    long MOD = 1000000007;

    public Fancy() {
        arr = new ArrayList<>();
    }

    public void append(int val) {
        long v = (val - add + MOD) % MOD;
        v = v * modInverse(mul) % MOD;
        arr.add(v);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= arr.size()) return -1;
        long val = (arr.get(idx) * mul + add) % MOD;
        return (int) val;
    }

    long modInverse(long x) {
        return power(x, MOD - 2);
    }

    long power(long x, long y) {
        long res = 1;
        x %= MOD;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % MOD;
            x = (x * x) % MOD;
            y >>= 1;
        }
        return res;
    }
}