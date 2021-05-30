package week12;

import org.w3c.dom.Node;

public class BST {
    Node root = null;

    public static void main(String[] args) {

    }

    public Node search(int key) {
        if (root == null) return null;
        Node focusNode = root;

        while (focusNode.key != key) {
            if (key < focusNode.key) { //현재 노드보다 작으면
                focusNode = focusNode.leftChild; //왼쪽으로
            } else { //크면
                focusNode = focusNode.rightChild; //오른쪽으로
            }

            if (focusNode == null)
                return null;
        }
        return focusNode;
    }

    public void insert(int key) {
        if (search(key) != null) return; //이미 존재하면 그냥 리턴

        Node newNode = new Node(key);

        if (root == null) {
            root = newNode; //트리가 비어있으면 root에 삽입
        } else {
            Node focusNode = root; //탐색용 현재노드
            Node parent;           //탐색용 노드의 부모 노드

            while (true) {
                parent = focusNode; //이동

                if (key < parent.key) { //삽입하려는 키가 현재 노드보다 작으면
                    focusNode = parent.leftChild; //왼쪽으로 이동

                    if (focusNode == null) { //왼쪽 노드가 비어있으면
                        parent.leftChild = newNode; //왼쪽 노드에 삽입
                        return;
                    }
                } else { //삽입하려는 키가 현재 노드와 같거나 크면
                    focusNode = parent.rightChild; //오른쪽으로 이동

                    if (focusNode == null) { //오른쪽 노드가 비어있으면
                        parent.rightChild = newNode; //오른쪽 노드에 삽입입
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        Node focusNode = root;
        Node parent = root;

        boolean isLeftChild = true;
        // while 문이 끝나고 나면 focusNode 는 삭제될 노드를 가리키고,
        // parent 는 삭제될 노드의 부모노드를 가리키게 되고,
        // 삭제될 노드가 부모노드의 left 인지 right 인지에 대한 정보를 가지게 된다
        while (focusNode.key != key) {
            parent = focusNode;
            if (key < focusNode.key) {
                focusNode = parent.leftChild;
            } else {
                isLeftChild = false;
                focusNode = parent.rightChild;
            }
            //찾으려는 노드가 없는 경우
            if (focusNode == null) {
                return false;
            }
        }
        Node replacementNode;
        //지우려는 노드의 자식 노드가 없는 경우
        if (focusNode.leftChild == null && focusNode.rightChild == null) {
            if (focusNode == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }
        // 지우려는 노드의 오른쪽 자식노드가 없는 경우 (왼쪽 자식 노드만 있는 경우)
        else if (focusNode.rightChild == null) {
            replacementNode = focusNode.leftChild;
            if (focusNode == root)
                root = replacementNode;
            else if (isLeftChild)
                parent.leftChild = replacementNode;
            else
                parent.rightChild = replacementNode;
        }
        // 지우려는 노드의 왼쪽 자식노드가 없는 경우 (오른쪽 자식 노드만 있는 경우)
        else if (focusNode.leftChild == null) {
            replacementNode = focusNode.rightChild;
            if (focusNode == root)
                root = replacementNode;
            else if (isLeftChild)
                parent.leftChild = replacementNode;
            else
                parent.rightChild = replacementNode;
        }
        // 지우려는 노드의 양쪽 자식노드가 모두 있는 경우
        // 오른쪽 자식 노드의 sub tree 에서 가장 작은 노드를 찾아서 지우려는 노드가 있던 자리에 위치시킨다
        else {
            // 삭제될 노드의 오른쪽 sub tree 를 저장해둔다
            Node rightSubTree = focusNode.rightChild;
            // 삭제될 노드 자리에 오게 될 새로운 노드 (오른쪽 sub tree 에서 가장 작은 값을 가진 노드)
            // 이 노드는 왼쪽 child 가 없어야 한다 (가장 작은 값이기 때문에)
            replacementNode = getRightMinNode(focusNode.rightChild);
            if (focusNode == root)
                root = replacementNode;
            else if (isLeftChild)
                parent.leftChild = replacementNode;
            else
                parent.rightChild = replacementNode;

            replacementNode.rightChild = rightSubTree;
            //지우려는 노드의 오른쪽 sub tree에 노드가 하나밖에 없는 경우
            if (replacementNode == rightSubTree)
                replacementNode.rightChild = null;
            replacementNode.leftChild = focusNode.leftChild;
        }

        return true;
    }

    private Node getRightMinNode(Node rightChildRoot) {
        Node parent = rightChildRoot;
        Node focusNode = rightChildRoot;

        while(focusNode.leftChild != null) {
            parent = focusNode;
            focusNode = focusNode.leftChild;
        }
        parent.leftChild = null;
        return focusNode;
    }


    private class Node {
        int key;
        Node leftChild;
        Node rightChild;

        public Node(int key) {
            this.key = key;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
}
