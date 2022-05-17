// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
class GFG{
	static void printList(Node node, PrintWriter out) 
	{ 
		while (node != null) 
		{ 
			out.print(node.data + " "); 
			node = node.next; 
		} 
		out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node ans = ob.divide(n, head);
            printList(ans, out); 
            t--;
        }
        out.flush();
    } 
} // } Driver Code Ends


//User function Template for Java

/* 
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution{
    Node divide(int N, Node head){
        // code here
        Node es=null ; Node ee=null ; Node os=null ; Node oe=null;
        Node curr = head;
        while(curr!=null)
        {
            if(curr.data%2==0)
            {
                if(es==null)
                {
                    es=curr;
                    ee=es;
                    curr=curr.next;
                }
                else
                {
                    ee.next=curr;
                    ee=ee.next;
                    curr=curr.next; 
                }
            }
            else
            {
                if(os==null)
                {
                    os=curr;
                    oe=os;
                    curr=curr.next;
                }
                else
                {
                    oe.next=curr;
                    oe=oe.next;
                    curr=curr.next;
                }
            }
        }
        if(es==null || os==null)
        {
            return head;
        }
        ee.next = os;
        oe.next = null;
        return es;
    }
}

//here we are making two separate kind of list..not actual but just separating data in such a way... you can say one for even and one for odd
// and we decalred four nodes corresponding to its start and end point...like es from even start ee for even end
// os for odd start and oe for odd end so that we can keep track of end and start of both list and connect it accordingly
// so we traverse the list and if its even and 1st element then we append it to es i.e even start and also make ee=es as end will also be that element as only one element
// if not first element then we append it to ee and move ee one node ahead as one extra elemnt got addded so new ee will be that element
// same is the case in odd for os and oe...finally we gor both even and odd separated by correspoding es , ee, os , amd oe
// so now we can link even end with odd start by ee.next = os and make odd end as null i.e oe.next = null as thats the end of list
// nd if it contains only even or only odd elements then simply return head as no modifications will be required