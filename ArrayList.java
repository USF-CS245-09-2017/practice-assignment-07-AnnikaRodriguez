import java.util.*;

public class ArrayList<T> implements List<T> {

    private T[] array;
    private int size;
    private int max_size;

    public ArrayList(){

        this.size = 0;
        this.max_size = 10;
        array = (T[]) new Object[10];

    }

    public void add(T item) {

        //increases the size of the array if needed
        if (size == max_size) {
            growArray();
            max_size*= 2;
        }
            array[size] = item;
            size++;

    }

        public void add (int pos, T item){

            if (size == max_size) {
               growArray();
                max_size*= 2;

            }

            for(int i = size; i > pos; i--){
                array[i] = array[i-1];
            }
            array[pos] = item;
            size++;

    }

    public T get(int pos){

            if(pos < 0 || pos > size){
                throw new ArrayIndexOutOfBoundsException("Position not valid.");
            }

            T data = array[pos];
            return data;


    }

    public T remove(int pos){

        if(pos < 0){
            throw new ArrayIndexOutOfBoundsException("Not a valid Index.");

        }

        T removed = array[pos]; //return of type T

        for(int i = pos+1; i < size; i++){
            array[i-1] = array[i];
        }

        size--;
        return removed; //return of type T

    }

    public int size(){

        return this.size;  //returns instance variable

    }

    private void growArray(){

        T[] temp = (T[]) new Object[array.length * 2];

        for(int i = 0; i < size; i++){
            temp[i] = array[i];
        }

        //max_size *= 2;
        array = temp;

    }



}
