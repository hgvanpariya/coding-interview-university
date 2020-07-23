
## Linked List

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
