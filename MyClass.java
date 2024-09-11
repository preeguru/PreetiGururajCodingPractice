import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyClass implements MyInterface {
	
	static Map<String,Integer> map;

	public int myAdd(int m,int n) {
		return m+n;
	}
	
	public int strStr(String haystack, String needle) {
        for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    }
	
	 public String mergeAlternately(String word1, String word2) {
	        StringBuilder result = new StringBuilder();
	        int i = 0;
	        while (i < word1.length() || i < word2.length()) {
	            if (i < word1.length()) {
	                result.append(word1.charAt(i));
	            }
	            if (i < word2.length()) {
	                result.append(word2.charAt(i));
	            }
	            i++;
	        }
	        return result.toString();
	    }
	
	//Input: nums = [4,1,2,1,2]
	//Output: 4
	 public int singleNumber(int[] nums) {
	        int first=0;
	        for(int n:nums) {
	          first = first^n;
	        }
	        return first;
	    }
	
    public boolean isPalindrome(String s) {if (s.isEmpty()) {
    	return true;
    }
    int start = 0;
    int last = s.length() - 1;
    while(start <= last) {
    	char currFirst = s.charAt(start);
    	char currLast = s.charAt(last);
    	if (!Character.isLetterOrDigit(currFirst )) {
    		start++;
    	} else if(!Character.isLetterOrDigit(currLast)) {
    		last--;
    	} else {
    		if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
    			return false;
    		}
    		start++;
    		last--;
    	}
    }
    return true;
}
	
	public int getPersonAge(String name) {
		return map.get(name);		
	}
	
	public void populateData(String name, int age) {
		map.put(name, age);
	}
	
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean res = false;
        for(int i=1,j=1;i<flowerbed.length-1 && j<=n;i++,j++){
            if(flowerbed[i]==0 && flowerbed[i-1]!=1 && flowerbed[i+1]!=1) { 
              flowerbed[i]=1;
              res = true;
              System.out.println(flowerbed[i]);
              
            }
        }
        return res;
    }
	
	public int maxOperations(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        int sum=0;
        List<Integer> list = new ArrayList<>();
        for(int n : nums) {
            list.add(n);
        }
        while(!list.isEmpty()) {
            sum+=nums[right];
            while(sum>k && left<=right){
                sum-=nums[left];
                left++;
            }
            if(sum == k) {
            	System.out.println("----" + left + "---" + right);
            	System.out.println("----" + nums[left] + "---" + nums[right]);
            	
                count+=1;
                list.remove(left);
                list.remove(right);
            }
           // right++;
        }
        return count;
    }
	
	public static void main(String[] args) {
	    map = new HashMap<>();
		map.put("Preeti", 28);
//		MyInterface my = (m,n) -> m+n;
		MyClass my = new MyClass();
//		my.defaultMethod();
//		my.populateData("Preeti",29);
//		System.out.println(my.getPersonAge("Preeti"));
//		System.out.println("Abstract method result : " +my.myAdd(2, 3));
//		System.out.println("Static method result : " + MyInterface.add(5, 6));
//		
//		System.out.println(my.isPalindrome("A man, a plan, a canal: Panama"));
//		System.out.println(my.strStr("sadbutsad", "but"));
//		String s = " hello";
//		System.out.println(s.stripLeading());
//		System.out.println(my.canPlaceFlowers(new int[] {1,0,0,0,1}, 1));
		int x = my.maxOperations(new int[] {1,2,3,4}, 5);
		System.out.println(x);
	}
}
