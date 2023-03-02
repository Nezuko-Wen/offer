#
# @lc app=leetcode.cn id=9 lang=python3
#
# [9] 回文数
#

# @lc code=start

# 偶数位 123321
# 12332 1233  123
# 1     12    123

# 奇数位 121
# 12 1
# 1  12
class Solution:
    def isPalindrome(self, x: int) -> bool:
       if x < 0 or (x % 10 == 0 and x != 0):
           return False
       res = 0
       while res < x:
           res = res * 10 + x % 10
           x //= 10
       return res == x or res // 10 == x
# @lc code=end

