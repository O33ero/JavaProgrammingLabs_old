package com.ozzero;

import java.util.Stack;

/**
 * {@link #binaryTree()} - собственная реализация бинарного дерева.
 * </p> 1. Вспомагательная структура ✔️ {@link #treeNode}
 * </p> 2. Ссылка на корневой элемент ✔️ {@link #root}
 * </p> 3. Число элементов в дереве ✔️ {@link #size}
 * </p> 4. Конструктор ✔️ {@link #binaryTree()}
 * </p> 5. Конструктор копирования ✔️ {@link #binaryTree(binaryTree)}
 * </p> 6. Добавление элемента ✔️ {@link #insert(Comparable)}
 * </p> 7. Поиск элемента ✔️ {@link #contain(Comparable)}
 * </p> 8. Удаление всех элементов ✔️ {@link #clear()}
 * </p> 9. Зависимые интерфейсы (опционально) {@code Comparable}
 */
public class binaryTree<T extends Comparable<T>> {
    /**
     * {@link #treeNode} - структура для хранения значений в {@link #binaryTree()}
     */
    static class treeNode<T extends Comparable<T>>  {
        private treeNode<T> left;
        private treeNode<T> rigth;
        private T value;

        public treeNode() {
            left = null;
            rigth = null;
            value = null;
        }

        public treeNode(T t) {
            left = null;
            rigth = null;
            value = t;
        }
    }

    private treeNode<T> root;
    private int size;
    private int maxLevel = 0;
    
    // Constructors
    binaryTree() {
        root = new treeNode<T>();
        size = 0;
    }

    binaryTree(binaryTree<T> other) { // https://coderoad.ru/1753486/Конструктор-копирования-для-двоичного-дерева-C
        root = new treeNode<T>();
        size = 0;
        Stack<treeNode<T>> stack = new Stack<>();
        treeNode<T> cur = other.root;
        while(cur != null) {
            this.insert(cur.value);
            if(cur.rigth != null) {
                stack.add(cur.rigth);
            }
            if(cur.left != null) {
                cur = cur.left;
            }
            else if (stack.isEmpty()) {
                break;
            }
            else {
                cur = stack.pop();
            }
        }        
    }

    // Private methods

    // Public non-static methods
    public void insert(T value) {

        treeNode<T> cur = this.root;

        while(true) {
            
            if(cur.value == null) { // Занимаем корень
                cur.value = value; 
                this.size++;
                break;
            }
            if(cur.value.compareTo(value) == 0) // Такой уже есть
                break;
            
            if(cur.value.compareTo(value) < 0) {
                if(cur.rigth != null) {
                    cur = cur.rigth;
                    continue;
                }
                else {
                    this.size++;
                    cur.rigth = new treeNode<>(value);
                    break;
                }
            }

            if(cur.value.compareTo(value) > 0) {
                if(cur.left != null) {
                    cur = cur.left;
                    continue;
                }
                else {
                    this.size++;
                    cur.left = new treeNode<>(value);
                    break;
                }
            }
        }
    }

    public boolean contain(T value) {
        Stack<treeNode<T>> stack = new Stack<>();
        treeNode<T> cur = this.root;
        while(cur != null) {
            
            if(cur.value.equals(value)) 
                return true;

            if(cur.rigth != null) {
                stack.add(cur.rigth);
            }
            if(cur.left != null) {
                cur = cur.left;
            }
            else if (stack.isEmpty()) {
                break;
            }
            else {
                cur = stack.pop();
            }
        }   

        return false;
    }

    public void clear() {
        Stack<treeNode<T>> stack = new Stack<>();
        treeNode<T> cur = this.root;
        while(cur != null) {
            cur.value = null;
            if(cur.rigth != null) {
                stack.add(cur.rigth);
            }
            if(cur.left != null) {
                cur = cur.left;
            }
            else if (stack.isEmpty()) {
                break;
            }
            else {
                cur = stack.pop();
            }
        }

        root.left = null;
        root.rigth = null;
        size = 0;

        System.gc(); // Убери мусор (пожалуйста)
    }

    // Getters and Setters
    public int size() {
        return size;
    }

    public int getMaxLevel() {
        treeNode<T> cur = this.root;

        if(cur.left != null) level(cur.left, 1);
        if(cur.rigth != null) level(cur.rigth, 1);

        return maxLevel;
    }

    private void level(treeNode<T> node, int lvl) {
        if(lvl > maxLevel) maxLevel = lvl;
        if(node.left != null) level(node.left, lvl + 1);
        if(node.rigth != null) level(node.rigth, lvl + 1);
    }

}

