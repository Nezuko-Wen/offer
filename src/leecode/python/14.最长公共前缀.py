#
# @lc app=leetcode.cn id=14 lang=python3
#
# [14] 最长公共前缀
#

# @lc code=start

from typing import List


class leecode.Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        # 遍历
        # if not strs:
        #     return False
        # index = 0
        # res = ''
        # while True:
        #     if len(strs.__getitem__(0)) < index + 1:
        #         break
        #     char = strs.__getitem__(0)[index]
        #     end = False
        #     for str in strs:
        #         if len(str) < index + 1 or str[index] != char:
        #             end = True
        #             break
        #     if end:
        #         break
        #     res += char
        #     index += 1
        # return res
        # asicc字典排序
        if not strs:
            return ''
        min_str = min(strs)
        max_str = max(strs)
        res = ''
        for i, v in enumerate(min_str):
            if v != max_str[i]:
                break
            res += v
        return res

# @lc code=end
