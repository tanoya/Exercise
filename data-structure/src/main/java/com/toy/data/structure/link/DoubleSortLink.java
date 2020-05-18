package com.toy.data.structure.link;

public class DoubleSortLink<T> {
    public T value;
    public DoubleSortLink<T> pre;
    public DoubleSortLink<T> next;

    public DoubleSortLink(T value){
        this.value = value;
    }
}
