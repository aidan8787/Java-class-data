package DataStructures;

import java.util.Iterator;

public class DoublyLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private class node implements Comparable<node> {
        private T data;
        private node prev;
        private node next;

        node(T data) {
            this.data = data;
            next = null;
            prev = null;
        }

        public int compareTo(node o) {
            return data.compareTo(o.data);
        }
    }

    private node head;
    private node tail;
    private int size;

    public DoublyLinkedList() {
        size = 0;
        tail = null;
        head = null;
    }

    /* Add to tail */
    public void add(T element) {
        node temp = new node(element);
        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
        }
        tail = temp;
        size++;
    }

    public void addfront(T element) {
        var temp = new node(element);
        if (head != null) {
            temp.next = head;
            head.prev = temp;
        }
        head = temp;
        size++;
    }

    public void addback(T element) {
        var temp = new node(element);
        if (tail != null) {
            tail.next = temp;
            temp.prev = tail;
        }
        tail = temp;
        size++;
    }

    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        node current = head;
        node add = new node(element);
        if (tail == null) {
            add(element);
        }
        for (int i = 0; i < index - 1; i++) {
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        if (current == null) {
            current = add;
        } else {
            add.next = current.next;
            if (current.next != null) {
                current.next.prev = add;
            }
            current.next = add;
            add.prev = current;
        }
        head = current;
        size++;
    }

    public boolean addspot(T data, int spot) {
        node add = new node(data);
        node temp = head;
        if (head == null && spot == 0) {
            head = add;
            size++;
            return true;
        }
        if (spot > size() || spot < 0) {
            addback(data);
            return false;
        }
        for (int lcv = 0; lcv < spot - 1; lcv++) {
            temp = temp.next;
        }
        if (temp.next == null) {
            temp.next = add;
            add.prev = temp;
            tail=add;
            size++;
            return true;
        }
        temp.next.prev = add;
        add.next = temp.next;
        add.prev = temp;
        temp.next = add;
        size++;
        return true;
    }

    /* Inserts new node in sorted order */
    public void addsorted(T element) {
        int cnt = 0;
        node current = head;
        node temp = new node(element);
            while (cnt <size) {
                if (current == null) {
                    break;
                }
                if(temp.data.compareTo(element)>=0)
                {
                    break;
                }
                cnt++;
                current = current.next;
            }
            addspot( element,cnt);
    }

    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (head == null) {
            size = 0;
        } else {
            node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            if (current == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                node before = current.prev;
                node after = current.next;
                after.prev = before;
                before.next = after;
                current = before;
                current.next = after;
                head = current;
                size--;
            }
        }
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        if (current == null) {
            return tail.data;
        }
        return current.data;
    }

    public void set(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = element;
    }

    public void print() {
        for (node current = head; current != null; current = current.next)
            System.out.print(current.data + " ");
        System.out.println();
    }

    public void settail(T element) {
        if (tail != null) {
            tail.data = element;
        } else {
            node temp = new node(element);
            tail = temp;
        }
    }

    public void sethead(T element) {
        if (head != null) {
            head.data = element;
        } else {
            node temp = new node(element);
            head = temp;
        }
    }

    public void printbackward() {
        for (node current = tail; current != null; current = current.prev)
            System.out.print(current.data + " ");
        System.out.println();
    }

    public int size() {
        return size;
    }

    public boolean IsEmpty() {
        return size == 0;
    }

    public void remove(T element) {
        int cnt = 0;
        while (get(cnt).compareTo(element) != 0) {
            cnt++;
        }
        remove(cnt);
    }

    public T pop() {
        T dat = tail.data;
        node temp = tail.prev;
        temp.next = null;
        tail = temp;
        size--;
        return dat;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            private node current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}