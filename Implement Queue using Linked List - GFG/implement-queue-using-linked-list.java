// { Driver Code Starts
import java.util.*;
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}

class GfG {
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


/*The structure of the node of the queue is
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}*/

class MyQueue
{
    QueueNode front, rear;
    
    //Function to push an element into the queue.
	void push(int a)
	{
        // Your code here
        QueueNode temp = new QueueNode(a);
        if(front==null)
        {
            front=rear=temp;
            return;
        }
        rear.next=temp;
        rear = temp;
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        // Your code here
        QueueNode pop;
        if(front==null)
        {
            return -1;
        }
        pop=front;
        front = front.next;
        if(front==null)
        {
            rear=null;
        }
        return pop.data;
	}
}

// so just we are first creating a temp node with given value a that we need to push in queue
// then if its the 1st element (i.e front=null) we are gonna push then make front=rear=temp i.e all the same as only one node there..its the 1st node just created
// if not 1st node then just add it to next of rear...and move rear to that newly added element...its like front acts as head and rear acts as tail like in linkedlist
// then for dequeue i.e pop if empty list i.e front=null return -1
// else move front one node ahead so then already 1st node will be deleted...after that i.e moving one node ahead
// if front = null that means there was only one node and we popped it so in that condition make rear also as null as our list got empty we deleted the only node
// nd for returning which data we popped we store front in a node pop and return pop.data


