package post_oder_duyet_cay_va_xoa_cay;

import java.util.HashMap;

public class BinaryTree<E extends Comparable<E>> extends AbstractTree<E> {
    protected class Node {
        private E element;
        private Node left;
        private Node right;

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    protected Node root;
    private int size;
    private HashMap<E, Integer> array = new HashMap<>();

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    //  ---------------------------------------------------------------
    @Override
    public boolean add(E e) {
        if (root == null) {
            root = new Node(e);
        } else {
            Node parent = null;
            Node current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else return false;
            }
//            --------------------------------
            if (e.compareTo(parent.element) < 0) {
                parent.left = new Node(e);
            } else if (e.compareTo(parent.element) > 0) {
                parent.right = new Node(e);
            }
        }
        this.size++;
        return true;
    }

    //-----------------------new add--------------------------------
    public void addNew(E e) {
        this.root = addNew(root, e, root);
    }

    private Node addNew(Node rootChild, E e, Node rootParent) {
        if (rootChild == null) {
            this.size++;
            if (rootParent == null) {
                rootChild = new Node(e);
            } else if (e.compareTo(rootParent.element) < 0) {
                rootParent.left = new Node(e);
            } else if (e.compareTo(rootParent.element) > 0) {
                rootParent.right = new Node(e);
            }
            return rootChild;
        }
        if (e.compareTo(rootChild.element) < 0) {
            addNew(rootChild.left, e, rootChild);
        } else if (e.compareTo(rootChild.element) > 0) {
            addNew(rootChild.right, e, rootChild);
        }
        return rootChild;
    }

    //    ------------------Ham Add---------------------
    public void add1(E e) {
        if (e != null) {
            this.root = add1(root, e);
            this.size++;
        }
    }

    private Node add1(Node root, E e) {
        if (root == null) {
            return new Node(e);
        }
        if (e.compareTo(root.element) < 0) {
            root.left = add1(root.left, e);
        } else if (e.compareTo(root.element) > 0) {
            root.right = add1(root.right, e);
        } else {
//            root.element = e;
            this.size--;
        }
        return root;
    }

    //  -------------------------------------------------------
    @Override
    public int size() {
        return this.size;
    }

    //  -----------------------------------------------------
    @Override
    public void showPostOrder() {
        array.clear();
        postOrder(root, 0, root);
        System.out.println();
        boolean check;
        for (int i = 1; i <= array.size(); i++) {
            check = false;
            for (E obj : array.keySet()) {
                if (array.get(obj) == i) {
                    System.out.print(array.get(obj) + "-" + obj + " ");
                    check = true;
                }
            }
            if (check) System.out.println();
        }
    }

    private void postOrder(Node root, int level, Node root1) {
        if (root == null) {
            return;
        }
        level++;
        if (root.left != null) {
            postOrder(root.left, level, root);
        }
        System.out.print(level + "-" + root.element + "(" + root1.element + ") ");
        array.put(root.element, level);
        if (root.right != null) {
            postOrder(root.right, level, root);
        }
    }

    //--------------------------------------------------------------------
    public void delete(E e) {
        this.root = delete(this.root, e);
        this.size--;
    }

    public Node minNode(Node root) {
        if (root.left != null)
            return minNode(root.left);
        else
            return root;
    }

    public Node delete(Node root, E e) {
        if (root == null) {
            return null;
        } else {
            //value is less than node's data then, search the value in left subtree
            if (e.compareTo(root.element) < 0)
                root.left = delete(root.left, e);
                //value is greater than node's data then, search the value in right subtree
            else if (e.compareTo(root.element) > 0)
                root.right = delete(root.right, e);

                //If value is equal to node's data that is, we have found the node to be deleted
            else if (e.compareTo(root.element) == 0) {
                //If node to be deleted has no child then, set the node to null
                if (root.left == null && root.right == null)
                    root = null;

                    //If node to be deleted has only one right child
                else if (root.left == null) {
                    root = root.right;
                }

                //If node to be deleted has only one left child
                else if (root.right == null) {
                    root = root.left;
                }

                //If node to be deleted has two children node
                else {
                    //then find the minimum node from right subtree
                    Node temp = minNode(root.right);
                    //Exchange the data between node and temp
                    root.element = temp.element;
                    //Delete the node duplicate node from right subtree
                    root.right = delete(root.right, temp.element);
                }
            }
            return root;
        }
    }

    //    ----------------------------Delete new-------------------------------------
    public void deleteNew(E e) {
        this.root = deleteNew(root, e);
        this.size--;
    }

    public Node deleteNew(Node root, E e) {
        if (root == null) {
            return null;
        }
        if (e.compareTo(root.element) < 0) {
            root.left = delete(root.left, e);
        } else if (e.compareTo(root.element) > 0) {
            root.right = delete(root.right, e);
        } else {
            if (root.left == null || root.right == null) {
                Node temp = root.left != null ? root.left : root.right;
                return temp;
            } else {
                Node successor = getSuccessor(root);
                root.element = successor.element;
                root.right = delete(root.right, successor.element);
            }
        }
        return root;
    }

    public Node getSuccessor(Node node) {
        if (node == null) {
            return null;
        }
        Node temp = node.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    //    -----------------------------------------------------------------------------------
    public void deleteNode(E key) {
        if (this.size == 1 && key.compareTo(root.element) == 0) {
            root = null;
            this.size--;
            return;
        }
        deleteNode(root, key);
        this.size--;
    }

    private Node deleteNode(Node root, E key) {
        if (root == null) return null;
        if (key.compareTo(root.element) < 0) {
            root.left = deleteNode(root.left, key);
        } else {
            if (key.compareTo(root.element) > 0) {
                root.right = deleteNode(root.right, key);
            } else {
                //if same
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                //otherwise, find min at right subtree
                Node temp = root.right;
                while (temp != null) {
                    if (temp.left == null) break;
                    temp = temp.left;
                }
                E min_at_right = temp.element;
                root.element = min_at_right;
                root.right = deleteNode(root.right, min_at_right);
            }
        }
        return root;
    }
}
