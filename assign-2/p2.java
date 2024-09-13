// Write a Java method fact(int n) for returning factorial value for small n within 20.

long fact(long n) { // may return large numbers
    if (n < 0) // For negative numbers
        return -1; // No factorial for negative number
    else if (n == 0) // For 0 value
        return 1;
    else // Otherwise
        return n * fact(n - 1);
}