import java.util.Random;

public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;

    public BinaryTreeNode(int value, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public BinaryTreeNode(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void addElementRandomly(int value) {

        if (new Random().nextBoolean()) {

            if (this.leftChild == null) {
                this.leftChild = new BinaryTreeNode(value);
            } else {
                this.leftChild.addElementRandomly(value);
            }

        } else {

            if (this.rightChild == null) {
                this.rightChild = new BinaryTreeNode(value);
            } else {
                this.rightChild.addElementRandomly(value);
            }

        }

    }

    public void addElementBinarySearch(int value) {

        if (value < this.value) {
            // left
            if (this.leftChild == null) {
                this.leftChild = new BinaryTreeNode(value);
            } else {
                this.leftChild.addElementBinarySearch(value);
            }
        } else {
            // right
            if (this.rightChild == null) {
                this.rightChild = new BinaryTreeNode(value);
            } else {
                this.rightChild.addElementBinarySearch(value);
            }
        }

    }
}
