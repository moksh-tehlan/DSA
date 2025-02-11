package binary_search.faqs;

public class BookAllocation {
    public static void main(String[] args) {
        int[] arr = new int[]{25, 46, 28, 49, 24};
        System.out.println(findPages(arr,4));
    }

    private static int findPages(int[] nums,int m){
        int start = Integer.MIN_VALUE;
        int end = 0;
        for(int i : nums){
            start = Math.max(i,start);
            end += i;
        }

        while(start <= end){
            int mid = start + (end-start)/2;

            int studentPossible = studentCanBeGiven(nums,mid);
            if(studentPossible <= m){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

    private static int studentCanBeGiven(int[] nums,int pages){
        int currPages = nums[0];
        int student = 1;
        for(int i = 1; i< nums.length; i++){
            if(currPages + nums[i] <= pages){
                currPages += nums[i];
            }else{
                student++;
                currPages = nums[i];
            }
        }
        return student;
    }
}
