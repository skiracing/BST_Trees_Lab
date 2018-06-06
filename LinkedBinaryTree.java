public class LinkedBinaryTree implements BinaryTreeADT {

private BSTNode root;

LinkedBinaryTree() {
}

@Override
public boolean isEmpty() {
return this == null;
}

@Override
public int size() {
if (root == null) return 0;
else return count(root, 0);
}

private int count(BSTNode current, int count) {
int size = count;
if(current != null) {
size = count(current.getLeft(), size);
size++;
size = count(current.getRight(),size);
}
return size;
}

public void add(int value) {
root = addRecursive(root, value);
}

private BSTNode addRecursive(BSTNode current, int value) {    
if(current == null) {
    return new BSTNode(value);}
if(current.getElement() > value) {
    current.setLeft(addRecursive(current.getLeft(), value));}
else if (current.getElement() < value) {
    current.setRight(addRecursive(current.getRight(), value));}
return current;
}

private void inOrderTraversal(BSTNode current) {
if(current != null) {
inOrderTraversal(current.getLeft());
System.out.print(current.getElement() + " ");
inOrderTraversal(current.getRight());
}
}

public void printInOrder() {
System.out.println("The size of the tree is: " + size());
inOrderTraversal(root);
}


public void remove (int target) {
root = remove(root, target);
}

public BSTNode remove(BSTNode current, int target) {
if(current == null) return current;
else if(current.getElement() > target) {current.setLeft(remove(current.getLeft(),target));}
else if(current.getElement() < target) {current.setRight(remove(current.getRight(),target));}
else {
    if(current.getRight() == null) {return current.getLeft();}
    else if (current.getLeft() == null) {return current.getRight();}
    else {
        current.setElement(findMin(current.getRight()));
        current.setRight(remove(current.getRight(),current.getElement()));
}

}
return current;
}


public int findMin(BSTNode current) {
if(current.getLeft() == null) {return current.getElement();}
else {return findMin(current.getLeft());}
}

@Override
public BSTNode find(int target) {
BSTNode returned = find(root, target);
return returned;
}

private BSTNode find(BSTNode current, int target) {
if(current == null) {return null;}
else if(current.getElement() == target) {return current;}
else if(target< current.getElement()) {current = find(current.getLeft(), target);}
else if(target> current.getElement()) {current = find(current.getRight(), target);}
return current;
}

}

    
