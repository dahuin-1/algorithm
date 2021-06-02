package week12;

public class BinaryTree {

    public class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.setData(data);
            setLeftChild(null);
            setRightChild(null);
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeftChild() {
            return left;
        }

        public void setLeftChild(Node left) {
            this.left = left;
        }

        public Node getRightChild(){
            return right;
        }

        public void setRightChild(Node right) {
            this.right = right;
        }
    }

    private Node root;
    public Node getRoot() {
        return this.root;
    }

    public BinaryTree() {
        this.root = null;
    }

    public boolean delete(int id) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        while(current.getData() != id) {
            parent = current;
            if (current.getData() > id) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }
            if (current == null) {
                return false;
            }
        }
        //case1:자식노드가 없는 경우
        if(current.getLeftChild()==null && current.getRightChild()==null){
            if(current==root) {
                root = null;
            }
            if(isLeftChild) {
                parent.setLeftChild(null);
            }else{
                parent.setRightChild(null);
            }
        }
        //case2:하나의 자식을 갖는 경우
        else if(current.getRightChild()==null) {
            if(current == root) {
                root = current.getLeftChild();
            }else if(isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            }else{
                parent.setRightChild(current.getLeftChild());
            }
        } else if(current.getLeftChild() == null){
            if(current == root) {
                root = current.getRightChild();
            }else if(isLeftChild){
                parent.setLeftChild(current.getRightChild());
            }else{
                parent.setRightChild(current.getRightChild());
            }
        }

        //case3: 두개의 자식을 갖는 경우
        else if(current.getLeftChild()!=null && current.getRightChild() != null) {
            //오른쪽 서브트리의 최소값을 찾음
            Node successor = getSuccessor(current);
            if(current == root){
                root = successor;
            }else if(isLeftChild){
                parent.setLeftChild(successor);
            }else{
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }
        return true;
    }

    private Node getSuccessor(Node deleteNode) {
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.getRightChild();
        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if(successor != deleteNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(deleteNode.getRightChild());
        }
        return successor;
    }

    private boolean isSearch(int id) {
        if (root == null) return false;
        Node current = root;

        while(current!= null) {
            //현재노드와 찾는 값이 같으면
            if(current.getData()==id) {
                return true;
                //찾는 값이 현재 노드보다 작으면
            }else if(id < current.getData()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }

        }
        return false;
    }

    public void insert(int id) {
        if (isSearch(id)) return; //이미 존재하면 그냥 리턴

        Node newNode = new Node(id);
        if(root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent;

        while(true) {
            parent = current;
            if(id < parent.getData()) { //삽입하려는 키가 현재 노드보다 작으면
                current = parent.getLeftChild(); //왼쪽으로 이동
                if (current == null) { //왼쪽 노드가 비어있으면
                    parent.setLeftChild(newNode);  //왼쪽 노드에 삽입
                    return;
                }
            }else{ //삽입하려는 키가 현재 노드와 같거나 크면
                current = current.getRightChild();
                if(current == null) { //오른쪽 노드가 비어있으면
                    parent.setRightChild(newNode); //오른쪽 노드에 삽입입
                    return;
                }
            }
        }
    }

    public void display(Node root) {
        if(root != null) {
            display(root.getLeftChild());
            System.out.println(" " + root.getData());
            display(root.getRightChild());
        }
    }

    public void inOrder(Node node) { //left - root - right
        if(node != null) {
            inOrder(node.getLeftChild());
            System.out.println(node.data + " ");
            inOrder(node.getRightChild());
       }
    }

    public void preOrder(Node node) { //root - left - right
        if(node != null) {
            System.out.println(node.data + " ");
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    public void postOrder(Node node) { //left - right - root
        if(node != null) {
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            System.out.println(node.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(10);
        tree.insert(44);
        tree.insert(26);
        tree.insert(15);
        System.out.println("트리삽입결과 :");
        tree.display(tree.root);
        System.out.println("이진트리에서 4를 탐색 : "+tree.isSearch(4));
        System.out.println("이진트리에서 2를 삭제 : " + tree.delete(2));
        tree.display(tree.root);
        System.out.println("이진트리에서 4를 삭제 : " + tree.delete(4));
        tree.display(tree.root);
        System.out.println("이진트리에서 10을 삭제 : " + tree.delete(10));
        tree.display(tree.root);
        tree.inOrder(tree.getRoot());
        System.out.println();
        tree.preOrder(tree.getRoot());
        System.out.println();

    }
}

