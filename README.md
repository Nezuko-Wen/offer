# 位运算

异或运算==》无符号加  
a^a=0    a^0=a  
取二进制最右边的1  int count = a & ((~a) + 1) <br/>


### 数组中有一个数出现奇数次，其他出现偶数次，求这个数。
```java
//将所有数进行异或的结果即为所求
```
### 数组中有两个数出现奇数次，其他出现偶数次，求这个数。
```java
//所有数异或后的结果为 a ^ b
可知a!=b,所以e = a ^ b != 0,所以a和b在某一位上只有一个数为1
int i = e & ((~e) + 1)找到最右边的1，假设a在该位上为1
下面用i找出a
新增一个中间变量e‘,将数组中的数与i进行异或，如果异或结果为0,则把该数和e’与该数异或，因为除了a之外，其他这个位上为1的数的个数是偶数个，异或完后都会抵消，最后e‘=a,则b=a ^ a ^ b = e ^ a = e ^ e’
```
### 一个数的二进制中1的个数。
```java
int count = a & ((~a) + 1) 还是利用这个式子
public class OneCount {

    public static void main(String[] args) {
        System.out.println(findOneCount(7));
    }

    private static int findOneCount(int N) {
        int i;
        int result = 0;
        while ((i = (N & ((~N) + 1))) != 0) {
            result ++;
            N ^= i;
        }
        return result;
    }
}
```
# 栈
### 用栈实现队列
### O(1)复杂度获取栈中最小值
# 队列
### 用队列实现栈
### 环形队列
```java
public class CircularQueue {
    private int[] table;
    private int size = 0; //元素个数
    private int front = 0; //队头
    private int rear = 0; //队尾
    private final int limit;

    private static final int DEFAULT_LIMIT = 10;

    public CircularQueue() {
        this.limit = DEFAULT_LIMIT;
        table = new int[limit];
    }

    public CircularQueue(int limit) {
        this.limit = limit;
        table = new int[limit];
    }

    public void put(int val) {
        if (size == limit) {
            throw new RuntimeException("当前队列已满");
        }
        size ++;
        table[rear] = val;
        rear = rear == limit - 1 ? 0 : rear + 1;
    }

    public int pop() {
        if (size == 0) {
            throw new RuntimeException("当前队列为空");
        }
        size --;
        int ret = table[front];
        front = front == limit - 1 ? 0 : front + 1;
        return ret;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
```

# hash
# 递归
### master公式
形如T(N) = a * T(N/b) + O(N^d)(其中的a、b、d都是常数)的递归函数，可以直接通过Master公式来确定时间复杂度<br />
如果 log(b,a) < d，复杂度为O(N^d)<br />
如果 log(b,a) > d，复杂度为O(N^log(b,a))<br />
如果 log(b,a) == d，复杂度为O(N^d * logN)<br />

### 归并排序
```java
    private void mergeSplit(T[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSplit(nums, l, mid);
        mergeSplit(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(T[] nums, int l, int mid, int r) {
        int left = l;
        int right = mid + 1;
        List<T> temp = new ArrayList<>(r - l + 1);
        while (left <= mid && right <= r) {
            if (less(nums[left], nums[right])) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }
        while (left <= mid) {
            temp.add(nums[left++]);
        }
        while (right <= r) {
            temp.add(nums[right++]);
        }
        for (int i = 0; i < temp.size(); i++) {
            nums[l + i] = temp.get(i);
        }
    }
```
归并思想可解决 找某个数左边或右边某种数的问题
1. 小数和
把一个数的左边小于该数的数叫小数，求所有小数的和。<br />
eg: [1,3,4,2,5]<br />
1没有小数<br />
3的小数:1<br />
4的小数:1,3<br />
2的小数:1<br />
5的小数:1,3,4,2<br />
小数和为:1+1+3+1+1+3+4+2

### 前缀树
1）单个字符串中，字符从前到后的加到一棵多叉树上 <br />
2）字符放在边上，节点上有专属的数据项（常见的是pass和end值）<br />
3）样本添加方式，每个字符串都从根节点开始加，如果没有路就新建，如果有路就复用<br />
4）添加时，沿途节点的pass值加1，每个字符串结束时来到的节点end值加1<br />

end值可查某个字符串出现几次,pass值可查以某个字符串为前缀的字符串出现过几次
