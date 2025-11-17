package DsaPractice;

public class LinkedListDSA {
        public static void main(String[] args) {
            System.out.println("=== Singly Linked List ===");
            SinglyLinkedList a = new SinglyLinkedList();
            a.addLast(1); a.addLast(3); a.addLast(5);
            System.out.println("A: " + a);
            System.out.println("Reverse A (iterative):");
            a.reverse();
            System.out.println(a);

            System.out.println("\nPalindrome check:");
            SinglyLinkedList p = new SinglyLinkedList();
            p.addLast(1); p.addLast(2); p.addLast(2); p.addLast(1);
            System.out.println(p + " isPalindrome? " + p.isPalindrome());

            System.out.println("\nMerge sorted lists:");
            SinglyLinkedList l1 = new SinglyLinkedList();
            SinglyLinkedList l2 = new SinglyLinkedList();
            l1.addLast(1); l1.addLast(2); l1.addLast(4);
            l2.addLast(1); l2.addLast(3); l2.addLast(5); l2.addLast(6);
            System.out.println("L1: " + l1);
            System.out.println("L2: " + l2);
            SinglyLinkedList merged = SinglyLinkedList.mergeSorted(l1, l2);
            System.out.println("Merged: " + merged);

            System.out.println("\n=== Doubly Linked List ===");
            DoublyLinkedList d = new DoublyLinkedList();
            d.addLast(10); d.addFirst(5); d.addLast(15);
            System.out.println("Forward: " + d.forward());
            System.out.println("Backward: " + d.backward());
            d.remove(10);
            System.out.println("After remove(10) forward: " + d.forward());

            System.out.println("\n=== Circular Linked List ===");
            CircularLinkedList c = new CircularLinkedList();
            c.add(7); c.add(8); c.add(9);
            System.out.println("Circular: " + c); // prints from head once
            c.remove(8);
            System.out.println("After remove(8): " + c);
        }

        // ------------------ Singly Linked List ------------------
        static class SinglyLinkedList {
            static class Node {
                int val;
                Node next;
                Node(int v){ val = v; }
            }
            private Node head;
            private Node tail;
            private int size = 0;

            public void addFirst(int v){
                Node n = new Node(v);
                n.next = head;
                head = n;
                if (tail == null) tail = head;
                size++;
            }
            public void addLast(int v){
                Node n = new Node(v);
                if (tail == null) {
                    head = tail = n;
                } else {
                    tail.next = n;
                    tail = n;
                }
                size++;
            }
            public boolean remove(int v){
                if (head == null) return false;
                if (head.val == v){
                    head = head.next;
                    if (head == null) tail = null;
                    size--;
                    return true;
                }
                Node cur = head;
                while (cur.next != null && cur.next.val != v) cur = cur.next;
                if (cur.next == null) return false;
                cur.next = cur.next.next;
                if (cur.next == null) tail = cur;
                size--;
                return true;
            }
            public boolean contains(int v){
                Node cur = head;
                while (cur != null){
                    if (cur.val == v) return true;
                    cur = cur.next;
                }
                return false;
            }

            // Iterative reverse (in-place)
            public void reverse(){
                Node prev = null;
                Node cur = head;
                tail = head; // after reverse, old head becomes tail
                while (cur != null){
                    Node nxt = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = nxt;
                }
                head = prev;
            }

            // Check palindrome using O(1) extra memory (reverse second half)
            public boolean isPalindrome(){
                if (head == null || head.next == null) return true;
                // find middle
                Node slow = head, fast = head;
                while (fast.next != null && fast.next.next != null){
                    slow = slow.next;
                    fast = fast.next.next;
                }
                // slow is end of first half
                Node secondStart = reverseList(slow.next); // reversed second half
                Node p1 = head, p2 = secondStart;
                boolean ok = true;
                while (p2 != null){
                    if (p1.val != p2.val) { ok = false; break; }
                    p1 = p1.next; p2 = p2.next;
                }
                // restore list
                slow.next = reverseList(secondStart);
                return ok;
            }

            // helper: reverse and return new head
            private Node reverseList(Node node){
                Node prev = null, cur = node;
                while (cur != null){
                    Node nxt = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = nxt;
                }
                return prev;
            }

            // merge two sorted lists (non-destructive copies not required; we can re-use nodes)
            public static SinglyLinkedList mergeSorted(SinglyLinkedList a, SinglyLinkedList b){
                Node p = a.head;
                Node q = b.head;
                SinglyLinkedList res = new SinglyLinkedList();
                Node dummy = new Node(0);
                Node tail = dummy;
                while (p != null && q != null){
                    if (p.val <= q.val){
                        tail.next = p;
                        p = p.next;
                    } else {
                        tail.next = q;
                        q = q.next;
                    }
                    tail = tail.next;
                }
                tail.next = (p != null) ? p : q;
                // set res.head and res.tail properly
                res.head = dummy.next;
                // find tail and size quickly
                Node cur = res.head; int cnt = 0;
                Node last = null;
                while (cur != null){
                    last = cur; cur = cur.next; cnt++;
                }
                res.tail = last;
                res.size = cnt;
                return res;
            }

            public String toString(){
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                Node cur = head;
                while (cur != null){
                    sb.append(cur.val);
                    if (cur.next != null) sb.append(", ");
                    cur = cur.next;
                }
                sb.append("]");
                return sb.toString();
            }
        }

        // ------------------ Doubly Linked List ------------------
        static class DoublyLinkedList {
            static class DNode {
                int val;
                DNode prev, next;
                DNode(int v){ val = v; }
            }
            private DNode head, tail;
            private int size = 0;

            public void addFirst(int v){
                DNode n = new DNode(v);
                if (head == null){
                    head = tail = n;
                } else {
                    n.next = head;
                    head.prev = n;
                    head = n;
                }
                size++;
            }
            public void addLast(int v){
                DNode n = new DNode(v);
                if (tail == null){
                    head = tail = n;
                } else {
                    tail.next = n;
                    n.prev = tail;
                    tail = n;
                }
                size++;
            }
            public boolean remove(int v){
                DNode cur = head;
                while (cur != null && cur.val != v) cur = cur.next;
                if (cur == null) return false;
                if (cur.prev != null) cur.prev.next = cur.next; else head = cur.next;
                if (cur.next != null) cur.next.prev = cur.prev; else tail = cur.prev;
                size--;
                return true;
            }
            public String forward(){
                StringBuilder sb = new StringBuilder("[");
                DNode cur = head;
                while (cur != null){
                    sb.append(cur.val);
                    if (cur.next != null) sb.append(", ");
                    cur = cur.next;
                }
                sb.append("]");
                return sb.toString();
            }
            public String backward(){
                StringBuilder sb = new StringBuilder("[");
                DNode cur = tail;
                while (cur != null){
                    sb.append(cur.val);
                    if (cur.prev != null) sb.append(", ");
                    cur = cur.prev;
                }
                sb.append("]");
                return sb.toString();
            }
        }

        // ------------------ Circular Linked List (singly circular) ------------------
        static class CircularLinkedList {
            static class CNode {
                int val; CNode next;
                CNode(int v){ val = v; }
            }
            private CNode tail; // tail.next is head
            private int size = 0;

            public void add(int v){
                CNode n = new CNode(v);
                if (tail == null){
                    tail = n; tail.next = n;
                } else {
                    n.next = tail.next;
                    tail.next = n;
                    tail = n;
                }
                size++;
            }
            // remove first occurrence
            public boolean remove(int v){
                if (tail == null) return false;
                CNode cur = tail.next; // head
                CNode prev = tail;
                for (int i=0;i<size;i++){
                    if (cur.val == v){
                        if (cur == tail && cur.next == tail){ // only node
                            tail = null;
                        } else {
                            prev.next = cur.next;
                            if (cur == tail) tail = prev;
                        }
                        size--;
                        return true;
                    }
                    prev = cur;
                    cur = cur.next;
                }
                return false;
            }
            public String toString(){
                if (tail == null) return "[]";
                StringBuilder sb = new StringBuilder("[");
                CNode cur = tail.next; // head
                for (int i=0;i<size;i++){
                    sb.append(cur.val);
                    if (i < size-1) sb.append(", ");
                    cur = cur.next;
                }
                sb.append("]");
                return sb.toString();
            }
        }
    }
