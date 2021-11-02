#### [剑指 Offer II 001. 整数除法](https://leetcode-cn.com/problems/xoh6Oh/)

难度简单

给定两个整数 `a` 和 `b` ，求它们的除法的商 `a/b` ，要求不得使用乘号 `'*'`、除号 `'/'` 以及求余符号 `'%'` 。

**注意：**

- 整数除法的结果应当截去（`truncate`）其小数部分，例如：`truncate(8.345) = 8` 以及 `truncate(-2.7335) = -2`
- 假设我们的环境只能存储 32 位有符号整数，其数值范围是 `[−231, 231−1]`。本题中，如果除法结果溢出，则返回 `231 − 1`

**示例 1：**

```
输入：a = 15, b = 2
输出：7
解释：15/2 = truncate(7.5) = 7
```

**示例 2：**

```
输入：a = 7, b = -3
输出：-2
解释：7/-3 = truncate(-2.33333..) = -2
```

**示例 3：**

```
输入：a = 0, b = 1
输出：0
```

**示例 4：**

```
输入：a = 1, b = 1
输出：1
```

**提示:**

- `-231 <= a, b <= 231 - 1`
- `b != 0`

注意：本题与主站 29 题相同：https://leetcode-cn.com/problems/divide-two-integers/

```java
class Solution {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int minus = 2;
        if (a >= 0) {
            a = -a;
            minus--;
        }
        if (b >= 0) {
            b = -b;
            minus--;
        }
        int res = helper(a, b);
        return minus == 1 ? -res : res;
    }

    private int helper(int dividend, int divisor) {
        int res = 0;
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;
            while (value >= Integer.MIN_VALUE >> 1 && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }
            res = res + quotient;
            dividend -= value;
        }
        return res;
    }
}
```





#### [剑指 Offer II 002. 二进制加法](https://leetcode-cn.com/problems/JFETK5/)

难度简单

给定两个 01 字符串 `a` 和 `b` ，请计算它们的和，并以二进制字符串的形式输出。

输入为 **非空** 字符串且只包含数字 `1` 和 `0`。

**示例 1:**

```
输入: a = "11", b = "10"
输出: "101"
```

**示例 2:**

```
输入: a = "1010", b = "1011"
输出: "10101"
```

**提示：**

- 每个字符串仅由字符 `'0'` 或 `'1'` 组成。
- `1 <= a.length, b.length <= 10^4`
- 字符串如果不是 `"0"` ，就都不含前导零。

注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/

```java
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0 || carry > 0) {
            int first = i >= 0 ? a.charAt(i) - '0' : 0;
            int second = j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append((char) (first + second + carry) % 2);
            carry = (first + second + carry) / 2;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
```





#### [剑指 Offer II 003. 前 n 个数字二进制中 1 的个数](https://leetcode-cn.com/problems/w3tCBm/)

难度简单

给定一个非负整数 `n` ，请计算 `0` 到 `n` 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。

**示例 1:**

```
输入: n = 2
输出: [0,1,1]
解释: 
0 --> 0
1 --> 1
2 --> 10
```

**示例 2:**

```
输入: n = 5
输出: [0,1,1,2,1,2]
解释:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
```

**说明 :**

- `0 <= n <= 105`

**进阶:**

- 给出时间复杂度为 `O(n*sizeof(integer))` 的解答非常容易。但你可以在线性时间 `O(n)` 内用一趟扫描做到吗？
- 要求算法的空间复杂度为 `O(n)` 。
- 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 `__builtin_popcount` ）来执行此操作。

注意：本题与主站 338 题相同：https://leetcode-cn.com/problems/counting-bits/

```java
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }
}
```

```java
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
```

