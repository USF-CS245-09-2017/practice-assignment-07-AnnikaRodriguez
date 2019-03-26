public class LinkedList<T> implements List<T> {

    private Node<T> head;
    int size;

    public LinkedList(){
        head = null;
        size = 0;

    }

    public void add(T item){

        if(this.head == null){
            head = new Node<T>(item); //assign new item to head
            head.setNext(null); //
            this.size++; //increases the size since you add an item in list
        }

        else {
            Node<T> current = head;

            while(current.getNext() != null){
                current = current.getNext();
            }

            Node<T> node = new Node(item);
            current.setNext(node);
            this.size++; //increase the size as you add an item
        }


    }

    public void add(int pos, T item) {

        if (pos > size || pos < 0){
            throw new IndexOutOfBoundsException("Invalid Size");    //or could grow the size of the list
        }

        if (pos == 0) {    //adding at the head
            Node<T> node = new Node<T>(item);
            node.setNext(head);
            head = node;
            size++;

        } else {
            Node<T> n = new Node(item); //create new node
            Node prev = head;
            for (int i = 0; i < pos - 1; i++) {
                prev = prev.getNext();
            }
                n.setNext(prev.getNext());
                prev.setNext(n); //makes prev node the new node
                size++;
            }

    }

    public T get(int pos){

        if (pos > size || pos < 0){
            throw new IndexOutOfBoundsException("Invalid Size");
        }
            Node<T> n = head;

            for(int i = 0; i < pos; i ++){

                n = n.getNext();
            }

        return n.getData();

    }

    public T remove(int pos){
        if (pos > size || pos < 0){
            throw new IndexOutOfBoundsException("Invalid Size");
        }

        Node<T> current;

        if(pos == 0){
            current = head;
            head = head.getNext();

        }
        else {
            Node<T>previous = head;
            for (int i = 0; i < pos - 1; i++) {
                previous = previous.getNext();

            }

            current = previous.getNext();    //your next is my next
            previous.setNext(current.getNext());
        }

        size--;
        return current.getData();

    }

    public int size(){

        return size;  //returns instance variable

    }





}
