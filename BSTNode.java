

public class BSTNode {
private int data;
private BSTNode left;
private BSTNode right;

BSTNode() {}

BSTNode (int data) {
this.data = data;
this.left = null;
this.right = null;
}


public int numChildren () {
if (left != null && right != null) {return 2;}
else if (left != null || right != null) {return 1;}
return 0;
}

public void setElement(int data) {
this.data = data;
}

public int getElement() {
return data;
}

public BSTNode getRight() {
return this.right;
}

public void setRight (BSTNode node) {
this.right = node;
}

public BSTNode getLeft() {
return this.left;
}

public void setLeft (BSTNode node) {
this.left = node;
}

}