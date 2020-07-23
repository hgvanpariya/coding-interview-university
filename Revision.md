
## Linked List

### Question : Reverse Link List

Reverse a singly linked list.

Example:
```
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
```

#### Solution

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode pre = null;
        ListNode current = head;
        ListNode post = head.next;
        
        
        while(current != null){
            
            current.next = pre;
            pre = current;
            current = post;
            if(post != null){
                post = post.next;
            }
        }
        
        return pre;
    }
}

/**

1 2 3 4
p null
c 1
n 2

c-Next = p
p=c
c=n
n=n.next

pre = 3
c = 4
post = null

3 4 

c.next = pre (3)
pre = c (4)
c = null
n = null.next

*/
```

### Question

Complete the following function-

Node * alternateReverse( Node* head1, Node*head2){
// code goes here
}
Where ‘Node’ is the structure of a linked list node defined as:

struct Node{
int data;
struct Node *next;
};
alternateReverse() must remove the even number nodes from the linked list and append them to the end in reverse order. No extra space was allowed. It was for 5 marks.
Example:

Input-1->2->3->4->5->6
Output-1->3->5->6->4->2

Input-1->2->3->4->5->6->7->8->9
Output-1->3->5->7->9->8->6->4->2


#### Solution:

Iterate through all list nodes and put the alternate nodes on to stack. Time complexity of O(N) and space complexity of S(N/2).

```java
public Node ReverseAlternateNodes(Node head){

        /*
            Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6
            Output: 1 -> 3 - > 5 -> 6 -> 4 -> 2
         */

         Node temp =  head;
         Stack<Node> stck = new Stack<Node>();

         while (temp.Next != null){
                          
            var next = temp.Next.Next;            
            var reverseItem = temp.Next;

            //Null out the reversedNode next item.
            reverseItem.Next = null;
            //Push the next node on to the stack;
            stck.Push(reverseItem);

            //Assign Next.Next to current next;
            temp.Next = next;

            if(temp.Next != null){
                temp = temp.Next;
                continue;
            }
            break;            
         }

         while(stck.Count > 0){
             temp.Next = stck.Pop();
             //Console.WriteLine(temp.Next.Val);
             temp = temp.Next;
         }

         return head;
    }
```

## Other
### Question : Container With Most Water

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

<img width="442" alt="Screenshot 2020-07-23 at 3 44 14 PM" src="https://user-images.githubusercontent.com/1458819/88275944-d4f67280-ccfb-11ea-918e-f59ab5a40fb6.png">

#### Solution
```java
class Solution {
    public int maxArea(int[] height) {
        
        cornerCase(height);
        
        int inputLength = height.length -1;
        int min = 0;
        int max = inputLength;
        
        int maxWaterLevel = 0;
        int currentLength = inputLength;
        
        while(min<max && min >=0 && max <= inputLength){
            int currentLevel = height[min] < height[max]?height[min]:height[max];
            int currentWaterCapacity =  currentLevel * currentLength;
            
            if(currentWaterCapacity > maxWaterLevel){
                maxWaterLevel = currentWaterCapacity;
            }
            if(height[min] < height[max]){
                min++;
            }else{
                max--;
            }
            currentLength--;
        }
        
        return maxWaterLevel;
        
    }
    
    public void cornerCase(int[] height){
        if(height == null){
            throw new IllegalArgumentException("ERR01:");
        }
        if(height.length < 2){
            throw new IllegalArgumentException("ERR02:");
        }
    }
}
/*


testplan
****************
[1,1]
[1,5]
[5,1]

[1,8,6]
[8,1,6]
[6,1,8]

[1]
[]
*********************

[1,1] -> 1

[1,5] -> 1

[5,1]  -> 1

[1,8,6] 
6
6,8 -> 6
6,8,1 -> 6

[8,1,6]
1,6 -> 1
8,6 -> 6*2
=12

8,1 => 1
=1

[6,1,8]

1,8 => 1
6,1,8 => 6*2
=12

[1,8,6,2,5,4,8,3,7]
1,7 -> 8*1
8,7 -> 7*7 => 49

[6,1,8]

6,8 -> 2*6 => 12




7 -indexOf(8) 


**/
```
