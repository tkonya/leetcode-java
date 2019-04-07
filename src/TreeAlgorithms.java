import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TreeAlgorithms {

    private static BinaryTreeNode parentNode;

    public static void main(String[] args) {

        Random rand = new Random();

        parentNode = new BinaryTreeNode(Math.abs(rand.nextInt() % 100));
        for (int i = 0; i < 7; ++i) {
            parentNode.addElementBinarySearch(Math.abs(rand.nextInt() % 100));
        }

        Queue<BinaryTreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(parentNode);

        while(!nodesQueue.isEmpty()) {
            BinaryTreeNode n = nodesQueue.remove();
            System.out.println(n.value);
            if (n.leftChild != null) {
                nodesQueue.add(n.leftChild);
            }
            if (n.rightChild != null) {
                nodesQueue.add(n.rightChild);
            }
        }

        System.out.println();

    }








}
