package stand.bst;

public class BSTTest {
    private static final int arr[] = {1,5,4,3,2,6};
    public static void main(String[] args) {
        int i, ilen;
        BSTree<Integer> tree=new BSTree<Integer>();

        System.out.print("== 依次添加: ");
        ilen = arr.length;
        for(i=0; i<ilen; i++) {
            System.out.print(arr[i]+" ");
            tree.insert(arr[i]);
        }

        System.out.print("\n== 前序遍历: ");
        tree.preOrder();

        System.out.print("\n== 中序遍历: ");
        tree.inOrder();

        System.out.print("\n== 后序遍历: ");
        tree.postOrder();
        System.out.println();

        System.out.print("\n== 前驱节点: ");
        System.out.println(tree.predecessor(tree.search(tree.mRoot, 5)).getValue());
        System.out.println();

        System.out.print("\n== 后继节点: ");
        System.out.println(tree.successor(tree.search(tree.mRoot, 5)).getValue());
        System.out.println();

        System.out.print("\n== 递归查找节点6：");
        System.out.println(tree.search(tree.mRoot, 6).getValue());
        System.out.print("\n== 非递归查找节点6：");
        System.out.println(tree.iterativeSearch(6).getValue());

        System.out.println("== 最小值: "+ tree.minimum());
        System.out.println("== 最大值: "+ tree.maximum());
        System.out.println("== 树的详细信息: ");
        tree.print();
//
//        System.out.print("\n== 删除根节点: "+ arr[3]);
//        tree.remove(arr[3]);
//
//        System.out.print("\n== 中序遍历: ");
//        tree.inOrder();
//        System.out.println();

        // 销毁二叉树
        tree.clear();

    }
}
