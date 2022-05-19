// { Driver Code Starts
import java.util.Scanner;

class GfG
{
	public static void main(String args[])
	{
		 Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
		 {
			MyQueue obj = new MyQueue();
			int Q = sc.nextInt();
			while(Q>0)
			{
				int QueryType = 0;
				QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					
					obj.push(a);
					
				}else if(QueryType == 2)
				{
				System.out.print(obj.pop()+" ");
				}
				Q--;
			}
			System.out.println("");
			t--;
		 }
	}
}



// } Driver Code Ends




class MyQueue {

    int front, rear, size, cap;
	int arr[] = new int[100005];

    MyQueue()
	{
		front=0;
		rear=0;
		size=0;
		cap=100005;
	}
	
	boolean isEmpty()
	{
	    return (size==0);
	}
	boolean isFull()
	{
	    return (cap==size);
	}
	int getFront()
	{
	    if(isEmpty())
	    {
	        return -1;
	    }
	    else
	    {
	        return front;
	    }
	}
	int getRear()
	{
	    if(isEmpty())
	    {
	        return -1;
	    }
	    else
	    {
	        return (front+size-1)%cap;
	    }
	}
	//Function to push an element x in a queue.
	void push(int x)
	{
	    // Your code here
	    if(isFull()) return;
	    arr[rear]=x;
	    //rear = getRear();
	    rear = (rear+1)%cap;
	    size++;
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		// Your code here
		if(isEmpty()) return -1;
		int curr = front;
		front = (front+1)%cap;
		size--;
		return arr[curr];
	} 
}

// hence this whole implementation is using circular array...using normal array
// we could achieve all queue operations but for dequeue operation using simple array it takes O(n) time as we have to shift
// each element one index back...hence in circular array we just move front ahead instead of shifting elements back
// in normal array we had front always =0 as we dont change front we move elements to front by shifting them one index back in case of dequeue operations
// and we had rear as size-1 always...cap is capacity of whole array and size is currently how much array is full i.e no of elements in array now
// in circular array we have initially front = 0 and rear we can get from front using (front+size-1)%cap as its circular so we will do modulo by capacity everywhere
// for enqueue or push we get rear as (rear+1)%cap again and then push at rear index the element x and incease size
// for dequeue inplace of shifting elements one step back we move front as (front+1)%cap and reduce size
// this way we can even accomodate elements at front if there is only one element at the end of array as then also rear will be bcz of modulo can encoporate new elements in the array



