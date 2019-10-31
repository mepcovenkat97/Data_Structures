public class AVLTree
{
    Node root;
    int getBalance(Node root)
    {
        if(root == null)
            return 0;
        else
            return getHeight(root.left) - getHeight(root.right);
    }

    int getHeight(Node root)
    {
        if(root == null)
            return 0;
        else
            return root.height;
    }

    int max(int a,int b)
    {
        if(a > b)
            return a;
        else
            return b;
    }

    Node minValueNode(Node root)
    {
        Node current = root;
        while(current.left != null)
            current = current.left;
        return current;
    }

    Node rightRotate(Node root)
    {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.height = max(getHeight(root.left),getHeight(root.right))+1;
        newRoot.height = max(getHeight(newRoot.left),getHeight(newRoot.right))+1;
        return newRoot;
    }

    Node leftRotate(Node root)
    {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.height = max(getHeight(root.left), getHeight(root.right))+1;
        newRoot.height = max(getHeight(newRoot.left),getHeight(newRoot.right))+1;
        return newRoot;
    }

    Node insertNode(Node root, int data)
    {
        if(root == null)
            return (new Node(data));

        if(data < root.value)
            root.left = insertNode(root.left, data);
        else if(data > root.value)
            root.right = insertNode(root.right, data);
        else
            return root;

        root.height = 1+ max(getHeight(root.left), getHeight(root.right));
        int balance = getBalance(root);

        if(balance > 1 && data < root.left.value)
            return rightRotate(root);
        if(balance < -1 && data > root.right.value)
            return leftRotate(root);
        if(balance > 1 && data > root.left.value)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if(balance < -1 && data < root.right.value)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    Node deleteNode(Node root, int data)
    {
        if(root == null)
            return root;
        if(data < root.value)
            root.left = deleteNode(root.left, data);
        else if(data > root.value)
            root.right = deleteNode(root.right, data);
        else
        {
            if((root.left == null) || (root.right == null))
            {
                Node temp = null;
                if(temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                if( temp == null)
                {
                    temp = root;
                    root = null;
                }
                else
                {
                    root = temp;
                }
            }
            else
            {
                // Selecting the inorder Successor of deleted Node 
                // to replace the deleted node(if successor is present)
                Node temp = minValueNode(root.right);  
                root.value = temp.value;
                root.right = deleteNode(root.right, temp.value);
            }
        }
        if(root == null)
            return root;
        root.height = max(getHeight(root.left), getHeight(root.right));
        int balance = getBalance(root);
        if(balance > 1 && getBalance(root.left)>=0)
            return rightRotate(root);
        if(balance > 1 && getBalance(root.left)<0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if(balance < -1 && getBalance(root.right)<=0)
            return leftRotate(root);
        if(balance < -1 && getBalance(root.right)>0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    static void inOrder(Node node)  
    {  
        if (node != null)  
        {    
            inOrder(node.left);
            System.out.print(node.value + " ");  
            inOrder(node.right);  
        } 
    }
    public static void main(String[] args)
    {
        AVLTree tree = new AVLTree();
        tree.root = tree.insertNode(tree.root, 30);
        tree.root = tree.insertNode(tree.root, 20);
        tree.root = tree.insertNode(tree.root, 40);
        tree.root = tree.insertNode(tree.root, 10);
        tree.root = tree.insertNode(tree.root, 5);
        tree.root = tree.insertNode(tree.root, 3);
        tree.root = tree.insertNode(tree.root, 4);
        tree.root = tree.insertNode(tree.root, 50);
        tree.root = tree.insertNode(tree.root, 60);
        tree.root = tree.insertNode(tree.root, 70);
        tree.root = tree.insertNode(tree.root, 65);
        //tree.root = tree.insertNode(tree.root, 40);
        //tree.root = tree.insertNode(tree.root, 50);
        //tree.root = tree.insertNode(tree.root, 25);
        inOrder(tree.root);
        System.out.println();
        tree.root = tree.deleteNode(tree.root, 10);
        tree.root = tree.deleteNode(tree.root, 3);
        tree.root = tree.deleteNode(tree.root, 50);
        // tree.root = tree.deleteNode(tree.root, 60);
        // tree.root = tree.deleteNode(tree.root, 70);
        inOrder(tree.root);
        System.out.println();
    }
}