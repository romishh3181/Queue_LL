import java.util.Scanner;
class Nudu{
    int data;
    Nudu next;
    public Nudu(int data){
        this.data=data;
        this.next=null;
    }
}
public class QueueLL {
    private Nudu front,rear;
    public void enqueue(int data){
        Nudu newn=new Nudu(data);
        if(isEmpty()){
            front=rear=newn;
        }
        else{
            rear.next=newn;
            rear=newn;
        }
        printqueue();
    }
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        if(front==rear){
            front=rear=null;
        }
        else{
            front=front.next;
        }
        printqueue();
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }
    public boolean isEmpty(){
        return front==null&& rear==null;
    }
    public int size(){
        int cnt=0;
        Nudu current=front;
        while(current!=null){
            cnt++;
            current=current.next;
        }
        return cnt;
    }
    private void printqueue(){
        System.out.println("Queue");
        if(isEmpty()){
            System.out.println("Empty");
            return;
        }
        Nudu current =front;
        while(current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        QueueLL queue1=new QueueLL();
        while(true){
            System.out.println("Choose an operation.");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Check if queue is empty.");
            System.out.println("5. Get queue size");
            System.out.println("6. Exit");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Enter element to enqueue.");
                    int ele=sc.nextInt();
                    queue1.enqueue(ele);
                    break;
                case 2:
                    queue1.dequeue();
                    break;
                case 3:
                    queue1.peek();
                    break;
                case 4:
                    System.out.println(queue1.isEmpty());
                    break;
                case 5:
                    System.out.println("Queue size:"+queue1.size());
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
