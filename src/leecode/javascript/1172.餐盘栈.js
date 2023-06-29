/*
 * @lc app=leetcode.cn id=1172 lang=javascript
 *
 * [1172] 餐盘栈
 */

// @lc code=start
/**
 * @param {number} capacity
 */
var DinnerPlates = function (capacity) {
  this.capacity = capacity;
  this.table = [];
  this.pushStack = [];
  this.popStack = [];
};

/**
 * @param {number} val
 * @return {void}
 */
DinnerPlates.prototype.push = function (val) {
  // const stack = this.table.find(cur => cur.length < this.capacity);
  // 写入栈为空，说明要新建一个栈
  if (this.pushStack.length === 0) {
    this.table.push([val]);
    this.pushStack.push(this.table.length - 1);
    this.popStack.push(this.table.length - 1);
  } else {
    //直接推入当前写入栈，这里不会改变弹出栈的索引
    const pushIndex = this.pushStack[this.pushStack.length - 1];
    this.table[pushIndex].push(val);
    if (this.table[pushIndex].length === this.capacity) 
      this.pushStack.pop();
    }
};

/**
 * @return {number}
 */
DinnerPlates.prototype.pop = function () {
  if (this.popStack.length === 0) return -1;
  const popIndex = this.popStack[this.popStack.length - 1];
  const cur = this.table[popIndex];
  const ret = cur.pop();
  if (cur.length === 0) {
    //栈空,pop导致的栈空要移除该栈
    this.table.splice(index, 1);
    this.popStack.pop();
  } else {
    //有栈可写入，将该栈索引写入push栈
    if (this.pushStack.find(cur => cur === popIndex) === undefined) {
      //插入该索引的位置
      const insertIndex = this.pushStack.findIndex(cur => cur < popIndex);
      if (insertIndex === -1) {
        this.pushStack.push(popIndex);
      } else {
        this.pushStack = [this.pushStack.slice(0, insertIndex), popIndex, this.pushStack.slice(insertIndex + 2)];
      }
    }
  }
  return ret;
};

/**
 * @param {number} index
 * @return {number}
 */
DinnerPlates.prototype.popAtStack = function (index) {
  const arr = this.table[index];
  if (arr?.length) {
    return arr.pop();
  } else {
    return -1;
  }
};

const D = new DinnerPlates(2); // 初始化，栈最大容量 capacity = 2

for (let i = 0; i < 2523268; i++) {
  console.log(D.push(i));
}



const a = [1, 2, 3];
console.log(a.findIndex(cur => cur > 3));
  