package DSAAssgmnt;

public class StackArry {
    int size;
    int top;
    int [] stack;

    StackArry(int size) {
        this.size = size;
        top = -1;
        stack = new int[size];
    }

    public void push(int no) {
        if (top == size - 1) {
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = no;
        System.out.println(no + " :is pushed to stack");
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    public int pop(){
        if(top==-1){
            System.out.println("Stack is Empty");
            return-1;
        }
        return stack[top--];
    }
    public boolean isEmpty(){
        return top == -1;
    }

    public static void main(String[] args) {
        StackArry s= new StackArry(5);

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Top Element: "+s.peek());
        System.out.println("Popped :"+s.pop());
        System.out.println("Top Element: "+s.peek());
        System.out.println("Popped :"+s.pop());
        System.out.println("Top Element: "+s.peek());
        System.out.println("Popped :"+s.pop());
        System.out.println("Is Empty? "+s.isEmpty());
    }
}
