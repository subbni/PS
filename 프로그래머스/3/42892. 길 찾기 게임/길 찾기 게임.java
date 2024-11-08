import java.util.Arrays;

class Solution {
  static int[] preorder;
  static int[] postorder;
  static int idx;
  static class Node implements Comparable<Node> {
    int number;
    int x;
    int y;
    Node parent;
    Node leftChild;
    Node rightChild;
    public Node(int number, int x, int y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }
    public void setParent(Node parent) {
    this.parent = parent;
    }
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }
    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
    @Override
    public int compareTo(Node node) {
      if(this.y == node.y) {
        return this.x - node.x;
      } else {
        return node.y - this.y;
      }
    }
  }

  static public int[][] solution(int[][] nodeinfo) {
    Node[] nodeList = new Node[nodeinfo.length];
    for(int i=0; i<nodeinfo.length; i++) {
      nodeList[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
    }
    Arrays.sort(nodeList);
    Node root = nodeList[0];
    for(int i=1; i<nodeList.length; i++) {
      insertNode(root, nodeList[i]);
    }

    preorder = new int[nodeinfo.length];
    postorder = new int[nodeinfo.length];
    idx = 0;
    markPreorder(root);
    idx = 0;
    markPostorder(root);
    int[][] answer = new int[2][];
    answer[0] = preorder;
    answer[1] = postorder;
    return answer;
  }

  static public void insertNode(Node parent, Node newNode) {
    if(parent.x > newNode.x) {
      if(parent.leftChild == null) {
        parent.setLeftChild(newNode);
        newNode.setParent(parent);
      } else {
        insertNode(parent.leftChild, newNode);
      }
    } else {
      if(parent.rightChild == null) {
        parent.setRightChild(newNode);
        newNode.setParent(parent);
      } else {
        insertNode(parent.rightChild, newNode);
      }
    }
  }

  static public void markPreorder(Node node) {
    if(node == null) return;
    preorder[idx++] = node.number;
    markPreorder(node.leftChild);
    markPreorder(node.rightChild);
  }

  static public void markPostorder(Node node) {
    if(node == null) return;
    markPostorder(node.leftChild);
    markPostorder(node.rightChild);
    postorder[idx++] = node.number;
  }
} 