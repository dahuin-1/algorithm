package week12;
//https://kim6394.tistory.com/223
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

    public Node root;
    public BinaryTree() {
        this.root = null;
    }

    public boolean find(int id) {
        Node current = root;
        while (current != null) {
            if (current.getData() == id) {
                return true;
            } else if (current.getData() > id) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return false;
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
                parent.setRightChild(current.setRightChild();
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


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

    }
}

