package ru.job4j.tree;

import java.util.*;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    public boolean isBinary() {
        Queue<Node<E>> list  = new LinkedList<>();
        Node<E> tempNode;
        boolean check = true;
        list.add(this.root);
        while (!list.isEmpty()) {
            tempNode = list.poll();
            if (tempNode.children.size() > 2) {
                check = false;
                break;
            }
            list.addAll(tempNode.children);
        }
        return check;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> pNode = findBy(parent);
        if (pNode.isPresent()) {
            Optional<Node<E>> cNode = findBy(child);
            if (cNode.isEmpty()) {
                Node<E> tempChild = new Node<>(child);
                pNode.get().children.add(tempChild);
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
         }
        return rsl;
    }
}