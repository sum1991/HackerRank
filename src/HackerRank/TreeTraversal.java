package HackerRank;

class TreeNode{
    public TreeNode Left;
    public TreeNode Right;
    public int value;
    public TreeNode(int item)
    {
        value = item;
        Left = Right = null;
    }
}
class BinaryTree{
    TreeNode root;
    BinaryTree(){
        root = null;
    }

    public void Inorder(TreeNode node){

        if(node==null){
            return;
        }
        Inorder(node.Left);
        System.out.println("Node value"+node.value);
        Inorder(node.Right);
    }
    public void Postorder(TreeNode node){

        if(node==null){
            return;
        }
        Postorder(node.Left);
        Postorder(node.Right);
        System.out.println("Node value"+node.value);
    }
    public void Preorder(TreeNode node){

        if(node==null){
            return;
        }
        System.out.println("Node value"+node.value);
        Preorder(node.Left);
        Preorder(node.Right);
    }
}
public class TreeTraversal {


    public static void main(String[] args) throws Exception{

        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.Left = new TreeNode(2);
        bt.root.Right = new TreeNode(3);
        bt.root.Left.Left = new TreeNode(4);
        bt.root.Left.Right = new TreeNode(5);
        bt.Inorder(bt.root);
    }
}


