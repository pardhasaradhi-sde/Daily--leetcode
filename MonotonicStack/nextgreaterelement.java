->bruteforce approach
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> h1=new HashMap<>();
        int i=0;
        for(int num:nums2)
        {
            h1.put(num,i++);
        }
        int arr[]=new int[nums1.length];
        for(int j=0;j<nums1.length;j++)
        {
            int index=h1.get(nums1[j]);
            int nextgreater=-1;
            for(int k=index+1;k<nums2.length;k++)
            {
                if(nums2[k]>nums1[j])
                {
                    nextgreater=nums2[k];
                    break;
                }
            }
            arr[j]=nextgreater;
        }
        return arr;
    }
}
->optimal approach using monotonic stack
  class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> h1=new HashMap<>();
       Stack<Integer> s=new Stack<>();
        for(int i=nums2.length-1;i>=0;i--)
        {
            int curr=nums2[i];
            while(!s.isEmpty() && s.peek()<=curr)
            {
                s.pop();
            }
            h1.put(curr,s.isEmpty()?-1:s.peek());
            s.push(curr);
        }
        int arr[]=new int[nums1.length];
        for(int j=0;j<nums1.length;j++)
        {
            arr[j]=h1.get(nums1[j]);
        }
        return arr;
    }
}
