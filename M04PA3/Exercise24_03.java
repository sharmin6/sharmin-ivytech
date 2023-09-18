//NOTE: I have only add the comments where it ask me to between where is said BEGIN REVEL SUBMISSION and END REVEL SUBMISSION (between lines 320-489).
//Also when entering the five numbers, to enter the next number press enter first to do so.

import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collection;

public class Exercise24_03 {
  public static void main(String[] args) {
    new Exercise24_03();
  }
  
  public Exercise24_03() {
    TwoWayLinkedList<Double> list = new TwoWayLinkedList<>();
    System.out.print("Enter five numbers: ");
    Scanner input = new Scanner(System.in);
    double[] v = new double[5];
    for (int i = 0; i < 5; i++) 
      v[i] = input.nextDouble();

    list.add(v[1]);
    list.add(v[2]);
    list.add(v[3]);
    list.add(v[4]);
    list.add(0, v[0]);
    list.add(2, 10.55);
    list.remove(3);

    java.util.ListIterator<Double> iterator1 = list.listIterator();
    System.out.print("The list in forward order: ");
    while (iterator1.hasNext())
      System.out.print(iterator1.next() + " ");

    java.util.ListIterator<Double> iterator2 = list.listIterator(list.size() - 1);
    System.out.print("\nThe list in backward order: ");
    while (iterator2.hasPrevious())
      System.out.print(iterator2.previous() + " ");
  }
} 

interface MyList<E> extends java.util.Collection<E> {
  /** Add a new element at the specified index in this list */
  public void add(int index, E e);

  /** Return the element from this list at the specified index */
  public E get(int index);

  /** Return the index of the first matching element in this list.
   *  Return -1 if no match. */
  public int indexOf(Object e);

  /** Return the index of the last matching element in this list
   *  Return -1 if no match. */
  public int lastIndexOf(E e);

  /** Remove the element at the specified position in this list
   *  Shift any subsequent elements to the left.
   *  Return the element that was removed from the list. */
  public E remove(int index);

  /** Replace the element at the specified position in this list
   *  with the specified element and returns the new set. */
  public E set(int index, E e);
  
  @Override /** Add a new element at the end of this list */
  public default boolean add(E e) {
    add(size(), e);
    return true;
  }

  @Override /** Return true if this list contains no elements */
  public default boolean isEmpty() {
    return size() == 0;
  }

  @Override /** Remove the first occurrence of the element e 
   *  from this list. Shift any subsequent elements to the left.
   *  Return true if the element is removed. */
  public default boolean remove(Object e) {
    if (indexOf(e) >= 0) {
      remove(indexOf(e));
      return true;
    }
    else
      return false;
  }

  @Override
  public default boolean containsAll(Collection<?> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public default boolean addAll(Collection<? extends E> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public default boolean removeAll(Collection<?> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public default boolean retainAll(Collection<?> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public default Object[] toArray() {
    // Left as an exercise
    return null;
  }

  @Override
  public default <T> T[] toArray(T[] array) {
    // Left as an exercise
    return null;
  }
}

class TwoWayLinkedList<E> implements MyList<E> {
  private Node<E> head, tail;
  private int size;

  /** Create a default list */
  public TwoWayLinkedList() {
  }

  /** Create a list from an array of objects */
  public TwoWayLinkedList(E[] objects) {
    for (E e : objects)
      add(e);
  }

  /** Return the head element in the list */
  public E getFirst() {
    if (size == 0) {
      return null;
    } else {
      return head.element;
    }
  }

  /** Return the last element in the list */
  public E getLast() {
    if (size == 0) {
      return null;
    } else {
      return tail.element;
    }
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      result.append(current.element);
      current = current.next;
      if (current != null) {
        result.append(", "); // Separate two elements with a comma
      } else {
        result.append("]"); // Insert the closing ] in the string
      }
    }

    return result.toString();
  }

  /** Clear the list */
  public void clear() {
    head = tail = null;
  }

  /** Return true if this list contains the element o */
  public boolean contains(Object e) {
    System.out.println("Implementation left as an exercise");
    return true;
  }

  /** Return the element from this list at the specified index */
  public E get(int index) {
    System.out.println("Implementation left as an exercise");
    return null;
  }

  /**
   * Return the index of the head matching element in this list. Return -1 if
   * no match.
   */
  public int indexOf(Object e) {
    System.out.println("Implementation left as an exercise");
    return 0;
  }

  /**
   * Return the index of the last matching element in this list Return -1 if
   * no match.
   */
  public int lastIndexOf(Object e) {
    System.out.println("Implementation left as an exercise");
    return 0;
  }

  /**
   * Replace the element at the specified position in this list with the
   * specified element.
   */
  public E set(int index, E e) {
    System.out.println("Implementation left as an exercise");
    return null;
  }

  private class LinkedListIterator implements java.util.ListIterator<E> {
    private Node<E> current = head; // Current index

    public LinkedListIterator() {
    }
    
    public LinkedListIterator(int index) {
      if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
          + size);
      for (int nextIndex = 0; nextIndex < index; nextIndex++)
        current = current.next;
    }
    
    public void setLast() {
  	current = tail;
    }
    
    @Override
    public boolean hasNext() {
      return (current != null);
    }

    @Override
    public E next() {
      E e = current.element;
      current = current.next;
      return e;
    }

    @Override
    public void remove() {
      System.out.println("Implementation left as an exercise");
    }

    @Override
    public void add(E e) {
      System.out.println("Implementation left as an exercise");
    }

    @Override
    public boolean hasPrevious() {
      return current != null;
    }

    @Override
    public int nextIndex() {
      System.out.println("Implementation left as an exercise");
      return 0;
    }

    @Override
    public E previous() {
      E e = current.element;
      current = current.previous;
      return e;
    }

    @Override
    public int previousIndex() {
      System.out.println("Implementation left as an exercise");
      return 0;
    }

    @Override
    public void set(E e) {
      current.element = e; // TODO Auto-generated method stub
    }
  }

  private class Node<E> {
    E element;
    Node<E> next;
    Node<E> previous;

    public Node(E o) {
      element = o;
    }
  }

  @Override
  public int size() {
    return size;
  }

  public ListIterator<E> listIterator() {
    return new LinkedListIterator(); 
  }
  
  public ListIterator<E> listIterator(int index) {
    return new LinkedListIterator(index); 
  }

  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return null;
  }
  
// BEGIN REVEL SUBMISSION
// Adds an element to the beginning of the list.
public void addFirst(E e) {    
    // Create a new node with the given element
    Node<E> newNode = new Node<>(e);
    
    // Set the next reference of the new node to the current head
    newNode.next = head;
    
    // Update the head to point to the new node
    head = newNode;
    
    // Increase the size of the list
    size++;
    
    // If the list was empty before, update the tail to point to the new node as well
    if (tail == null) {
        tail = head;
    }
}

// Adds an element to the end of the list.
public void addLast(E e) {
    // Create a new node with the given element
    Node<E> newNode = new Node<>(e);
    
    // If the list is currently empty, make both head and tail point to the new node
    if (tail == null) {
        head = tail = newNode;
    } else {
        // If the list is not empty, update the next reference of the current tail to the new node
        tail.next = newNode;
        
        // Update the tail to point to the new node
        tail = tail.next;
    }
    
    // Increase the size of the list
    size++;
}

// Add a new element at the specified index in this list. The index of the head element is 0.
public void add(int index, E e) {
    // If the specified index is 0, call addFirst to add the element at the beginning
    if (index == 0) {
        addFirst(e);
    }
    // If the specified index is greater than or equal to the size, call addLast to add the element at the end
    else if (index >= size) {
        addLast(e);
    } else {
        // If the index is within the middle of the list, we need to traverse the list
        Node<E> current = head;
        
        // Traverse to the node just before the specified index
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        
        // Create a reference to the next node
        Node<E> temp = current.next;
        
        // Update the current node's next reference to point to the new node
        current.next = new Node<>(e);
        
        // Update the new node's next reference to point to the original next node
        (current.next).next = temp;
        
        // Increase the size of the list
        size++;
    }
}

// Remove the head node and return the object that is contained in the removed node.
public E removeFirst() {
    // If the list is empty, return null
    if (size == 0) {
        return null;
    }
    
    // Store the current head node in a temporary variable
    Node<E> temp = head;
    
    // Update the head to point to the next node (removing the current head)
    head = head.next;
    
    // Decrease the size of the list
    size--;
    
    // If the list is now empty, also update the tail to null
    if (head == null) {
        tail = null;
    }
    
    // Return the element of the removed node
    return temp.element;
}

// Remove the last node and return the object that is contained in the removed node.
public E removeLast() {
    // If the list is empty, return null
    if (size == 0) {
        return null;
    }
    // If there's only one node in the list, remove it and set both head and tail to null
    else if (size == 1) {
        Node<E> temp = head;
        head = tail = null;
        size = 0;
        return temp.element;
    } else {
        // If there are more than one nodes, traverse the list to find the node just before the last one
        Node<E> current = head;
        for (int i = 0; i < size - 2; i++) {
            current = current.next;
        }
        // Store the last node in a temporary variable
        Node<E> temp = tail;
        
        // Update the tail to point to the node just before the last one
        tail = current;
        
        // Set the next reference of the new tail to null (removing the last node)
        tail.next = null;
        
        // Decrease the size of the list
        size--;
        
        // Return the element of the removed node
        return temp.element;
    }
}

// Remove the element at the specified position in this list. Return the element that was removed from the list.
public E remove(int index) {
    // If the specified index is invalid, return null
    if (index < 0 || index >= size) {
        return null;
    }
    // If the specified index is 0, call removeFirst to remove the element from the beginning
    else if (index == 0) {
        return removeFirst();
    }
    // If the specified index is the last one, call removeLast to remove the element from the end
    else if (index == size - 1) {
        return removeLast();
    } else {
        // If the index is within the middle of the list, we need to traverse the list
        Node<E> previous = head;
        
        // Traverse to the node just before the specified index
        for (int i = 1; i < index; i++) {
            previous = previous.next;
        }
        
        // Store the node to be removed in a temporary variable
        Node<E> current = previous.next;
        
        // Update the previous node's next reference to skip the current node (removing it)
        previous.next = current.next;
        
        // Decrease the size of the list
        size--;
        
        // Return the element of the removed node
        return current.element;
    }
}
// END REVEL SUBMISSION
}