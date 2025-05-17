->bruteforce approach
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int arr[]=new int[nums.length-k+1];
        int i=0;
        for(int left=0;left<=nums.length-k;left++)
        {
            int greater=Integer.MIN_VALUE;
            for(int right=left;right<left+k;right++)
            {
                if(greater<nums[right])
                {
                    greater=nums[right];
                }
            }
            arr[i++]=greater;
        }
        return arr;
    }
}
->bruteforcetwo pointer approach
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int arr[]=new int[nums.length-k+1];
        int i=0;
        int left=0,right=0;
        while(right<nums.length)
        {
            if(right-left+1==k)
            {
                int max=Integer.MIN_VALUE;
                for(int j=left;j<=right;j++)
                {
                    max=Math.max(max,nums[j]);
                }
                arr[i++]=max;
                left++;
            }
            right++;
        }
        return arr;
    }
}
->using priority queue approach
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int arr[]=new int[nums.length-k+1];
        int j=0;
        PriorityQueue<Integer> dq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++)
        {
            dq.add(nums[i]);
        }
        arr[j++]=dq.peek();
        for(int i=k;i<nums.length;i++)
        {
            dq.remove(nums[i-k]);
            dq.add(nums[i]);
            arr[j++]=dq.peek();
        }
        return arr;
    }
}
all these approaches have O(n*k) time complexity and O(n) space complexity
and will not work for large inputs
->using deque approach
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int arr[]=new int[nums.length-k+1];
        Deque<Integer> dq=new ArrayDeque<>();
        int i;
        int j=0;
        for(i=0;i<k;++i)
        {
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i])
            {
                dq.removeLast();
            }
            dq.addLast(i);
        }
       
        for(i=k;i<nums.length;++i)
        {
             arr[j++]=nums[dq.peekFirst()];
            while(!dq.isEmpty() && dq.peek()<=i-k)
            {
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()])
            {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        arr[j++]=nums[dq.peekFirst()];
        return arr;
    }
}
