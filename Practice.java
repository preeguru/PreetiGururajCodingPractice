import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Practice {

//	public Practice(int x) {
//		super(x);
//		// TODO Auto-generated constructor stub
//	}

	public int maxSumAlgo(int[] a) {

		int globalMax = a[0];
		int localMax = globalMax;
		for (int i = 1; i < a.length; i++) {
			localMax = Math.max(a[i] + localMax, a[i]);
			globalMax = Math.max(localMax, globalMax);
		}
		return globalMax;
	}

	public int[] RotateByK(int[] a, int K) { // rotate to right

		int n = a.length;
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			int pos = (i + K) % n;
			b[pos] = a[i];
		}
		return b;
	}

	public int[] RotatebyKLeft(int[] a, int K) {

		int n = a.length;
		int[] temp = new int[K];

		for (int i = 0; i < K; i++) {
			temp[i] = a[i];
		}

		for (int i = K; i < n; i++) {
			a[i - K] = a[i];
		}

		for (int i = 0; i < K; i++) {
			a[i + n - K] = temp[i];
		}

		return a;
	}
	
	public String uniqueCharOrNot (String s) {
		
		Set<String> hashChar = new HashSet<>();
		String[] s1 = s.split("");
		for(int i=0; i<s.length(); i++) {
			
			hashChar.add(s1[i]);
		}
		if (hashChar.size()==s.length()) return "String has unique characters";
		else return "String doesn't have unique characters";
	}
	
	public int longestSubstring(String s) {
		
		int left = 0;
		int maxL = 0;
		Set<Character> charSet = new HashSet<>();
		for(int right=0; right<s.length();right++) {
			if(!charSet.contains(s.charAt(right))) {
				charSet.add(s.charAt(right));
				maxL = Math.max(maxL, right-left+1);
			} else {
				while(charSet.contains(s.charAt(right))) {
					charSet.remove(s.charAt(left));
					left++;
				}
				charSet.add(s.charAt(right));
			}
		}
		return maxL;
		
	}
	
	class ListNode {
		int val;
		ListNode next;
		ListNode (int x) {
			val=x;
			next=null;
		}
	}
	
	public ListNode reverseLinkedList (ListNode head ) {
		
		ListNode prev = null;
		ListNode current = head;
		
		while(current!=null) {
			ListNode next = current.next;
			current.next=prev;
			prev = current;
			current = next ;
		}
		return prev;
		
	}
	
	 class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		 TreeNode(int x) {
			this.val=x;
			this.left=null;
			this.right=null;
		}
	}
	 
	 public int Height (TreeNode root) {
		 
		 if(root==null) return 0;
		 int leftHeight = Height(root.left);
		 int rightHeight = Height (root.right);
		 if(leftHeight == -1 || rightHeight == -1 ) return -1;
		 if(Math.abs(leftHeight - rightHeight) > 1) return -1;
		 
		 return Math.max(leftHeight,rightHeight)+1;
	 }
	 
	 public boolean isBalanced (TreeNode root) {
		 if(root==null) return true;
		 if(Height(root)==-1) return false;
		 return true;
	 }

	 public class BinaryTree {
		 public TreeNode inOrderInsert (Integer[] a, int i) {
			 TreeNode root = null;
			 if(i<a.length && a[i]!=null) {
				 root = new TreeNode(a[i]);
				 root.left = inOrderInsert(a,2*i+1);
				 root.right = inOrderInsert (a,2*i+2);
			 }
			 return root;
		 }
	 }
	 
	 public ListNode insertNode (int[] a) {
		 
		 if(a.length == 0) return null;
		 ListNode head = new ListNode(a[0]);
		 ListNode current = head;
		 for(int i=1; i<a.length;i++) {
			 current.next = new ListNode(a[i]);
			 current = current.next;
		 }
		 return head;
		 
	 }
	 
	 public int factorial(int n) {
		 
		 if (n==0) return 1;
		 int fact = 1;
		 for(int i=n;i>0;i--) {
			 fact = fact * i;
		 }
		 return fact;
	 }
	 
	 public boolean isPalindrome(String s) {
		 StringBuilder s1 = new StringBuilder(s);
		 StringBuilder rev = s1.reverse();
		 
		 if(rev.toString().equalsIgnoreCase(s)) return true;
		 else return false;
		 
	 }
	 
	 public boolean isPrime(int n) {
		 if(n<=1) return false;
		 
		 for(int i=2;i<=Math.sqrt(n);i++) {
			 if(n%i==0) return false;
			
		 } return true;
	 }
	 
	 public void fibonacci(int n) {
		 int[] fib=new int[n+2];
		 fib[0]=0;
		 fib[1]=1;
		 for(int i=2;i<=n;i++) {
			 fib[i] = fib[i-1]+fib[i-2];
		 }
		 
		 for(int i=0;i<n;i++) {
			 System.out.println(fib[i]);
		 }
		 
	 }
	 
	 public int maxEle(int[] a) {
		 int max = 0;
		 for(int i=0;i<a.length;i++) {
			 if(a[i]>max)
				 max = a[i];
		 }
		 return max;
	 }
	 
	 public int countVowel(String s) {
		 int count=0;
		 Set<Character> setVowel = new HashSet<>();
		 setVowel.add('a');
		 setVowel.add('e');
		 setVowel.add('i');
		 setVowel.add('o');
		 setVowel.add('u');
		 for(int i=0;i<s.length();i++) {
			 if(setVowel.contains(s.charAt(i))) count++;
		 }
		 return count;
	 }
	 
	 class Solution {
		    public int maxProfit(int[] prices) {
		        int profit = 0;
		        for(int i=1;i<prices.length;i++) {
		            if(prices[i] > prices[i-1]) {
		                profit += prices[i] - prices[i-1];
		            }
		        }
		        return profit;
		    
		    }
		}
	 
	 //Best Time to Buy and Sell Stock
//	 class Solution {
//		    public int maxProfit(int[] prices) {
//		        int buy = prices[0];
//		        int profit = 0;
//		        for (int i = 1; i < prices.length; i++) {
//		            if (prices[i] < buy) {
//		                buy = prices[i];
//		            } else if (prices[i] - buy > profit) {
//		                profit = prices[i] - buy;
//		            }
//		        }
//		        return profit;
//		    }
//		}
	 
	 public String longestCommonPrefix(String[] strs) {
	        if (strs == null || strs.length == 0) return "";
	        String prefix = strs[0];
	        for (String s : strs)
	            while (s.indexOf(prefix) != 0)
	                prefix = prefix.substring(0, prefix.length() - 1);
	        return prefix;
	    }
	 
	 public boolean isAnagram(String s, String s1) {
		 char[] charArr1 = s.toCharArray();
		 char[] charArr2 = s1.toCharArray();		 
		 Arrays.sort(charArr1);
		 Arrays.sort(charArr2);
		 
		 if(s.length()!=s1.length()) return false;
		 
		 for(int i=0;i<s.length();i++) {
			 if(charArr1[i]!=charArr2[i]) {
				 return false;
			 }
		 }
		 return true;
	 }
	
//		    public int romanToInt(String s) {
//		        int ans=0;
//		        Map<Character,Integer> m = new HashMap<>();
//		        m.put('I',1);
//		        m.put('V', 5);
//		        m.put('X', 10);
//		        m.put('L', 50);
//		        m.put('C', 100);
//		        m.put('D', 500);
//		        m.put('M', 1000);
//		        for(int i=0;i<s.length();i++){
//		        if(i<s.length() - 1 && m.get(s.charAt(i))<m.get(s.charAt(i+1))){
//		            ans = ans-m.get(s.charAt(i));
//		        } else 
//		        {
//		            ans = ans+m.get(s.charAt(i));}
//		        }
//		        return ans;
//		    }
		    
		        public boolean isPalindromeLeet(String s) {
		            s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
		            StringBuilder s1 = new StringBuilder(s);
		            s1.reverse();
		            if(s.equalsIgnoreCase(s1.toString()))
		            return true;
		            else return false;
		        }
		        
		        static String[] solution(String[] inputArray) {
		            int longest = 0;
		            for (int i = 0; i < inputArray.length; i++) {
		                if (inputArray[i].length() > longest) {
		                    longest = inputArray[i].length();
		                }
		            }
		            
		            final int longestLength = longest;
		            return Arrays.stream(inputArray)
		                .filter(s -> s.length() == longestLength)
		                .toArray(String[]::new);
		        }    
	 
	public static void main(String args[]) {
		
//		for(int i=1;i<10;i++) {
//		MultithreadingSample smp = new MultithreadingSample(i);
//		Thread myThread = new Thread(smp);
//		myThread.start();
//		System.out.println("is thread alive "+myThread.isAlive());
//		try {
////			myThread.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
//		for(int i=1;i<10;i++) {
//			MultithreadingSample2 smp2 = new MultithreadingSample2(i);
//			smp2.start();
//			}
//	}
		String[] arr = {"preeti","vk","nidhi","pradeep"};
		String[] res = Practice.solution(arr);
		for(String s : res) {
			System.out.println(s);
		}
}}
