package io.github.twblamer.practice.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

class SinglyLinkedListNode<T> {
    T value;
    SinglyLinkedListNode<T> next;

    public SinglyLinkedListNode(T data) {
        this.value = data;
        this.next = null;
    }
}

public class SinglyLinkedList<T> implements Iterable<T> {
    protected SinglyLinkedListNode<T> head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void add(T value) {
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(value);

        if (head == null) {
            head = newNode;
        } else {
            var current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private SinglyLinkedListNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                throwIfEmpty();

                var value = current.value;
                current = current.next;

                return value;
            }

            private void throwIfEmpty() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    public boolean remove(T value) {
        if (head == null) {
            return false;
        }

        if (head.value.equals(value)) {
            head = head.next;
            return true;
        }

        var current = head;

        while (current.next != null) {
            if (current.next.value.equals(value)) {
                current.next = current.next.next;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void reverse() {
        SinglyLinkedListNode<T> prev = null;
        SinglyLinkedListNode<T> current = head;
        SinglyLinkedListNode<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }
}
