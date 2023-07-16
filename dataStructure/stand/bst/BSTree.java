package stand.bst;

/**
 * BST的定义在二叉查找树中:
 * 若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 任意节点的左、右子树也分别为二叉查找树。
 * 没有键值相等的节点。
 */
public class BSTree<T extends Comparable> {
    public BSTNode mRoot;

    /**
     * 若二叉树非空，则执行以下操作:
     * <p>
     * 访问根结点；
     * 先序遍历左子树；
     * 先序遍历右子树。
     */
    public void preOrder() {
        preOrder(mRoot);
    }

    private void preOrder(BSTNode bstNode) {
        if (bstNode != null) {
            System.out.print(bstNode.value + " ");
            preOrder(bstNode.left);
            preOrder(bstNode.right);
        }
    }

    /**
     * 中序遍历
     * 若二叉树非空，则执行以下操作:
     * <p>
     * 中序遍历左子树；
     * 访问根结点；
     * 中序遍历右子树。
     */
    public void inOrder() {
        inOrder(mRoot);
    }

    private void inOrder(BSTNode bstNode) {
        if (bstNode != null) {
            inOrder(bstNode.left);
            System.out.print(bstNode.value + " ");
            inOrder(bstNode.right);
        }
    }

    /**
     * 后序遍历
     * 若二叉树非空，则执行以下操作:
     * <p>
     * 后序遍历左子树；
     * 后序遍历右子树；
     * 访问根结点。
     */
    public void postOrder() {
        postOrder(mRoot);
    }

    private void postOrder(BSTNode bstNode) {
        if (bstNode != null) {
            postOrder(bstNode.left);
            postOrder(bstNode.right);
            System.out.print(bstNode.value + " ");
        }
    }

    public void insert(T val) {
        BSTNode<T> node = new BSTNode<>(val, null, null, null);
        if (node != null) {
            insert(this, node);
        }
    }

    /**
     * 基于二叉排序树特点，左右中升序，找到要插入的节点位置的父节点。
     * 判断要插入父节点的左节点或右节点
     *
     * @param bsTree
     * @param node
     */
    private void insert(BSTree<T> bsTree, BSTNode<T> node) {
        int cmp;
        BSTNode<T> y = null;
        BSTNode<T> x = bsTree.mRoot;

        // 查找z的插入位置
        while (x != null) {
            y = x;
            cmp = node.value.compareTo(x.value);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;
        if (y == null) {
            mRoot = node;
        } else {
            cmp = node.value.compareTo(y.value);
            if (cmp < 0) {
                y.left = node;
            } else {
                y.right = node;
            }
        }


    }

    public BSTNode<T> search(BSTNode<T> bstNode, T val) {
        if (bstNode == null) {
            return null;
        }
        int i = val.compareTo(bstNode.value);
        if (i > 0) {
            return search(bstNode.right, val);
        } else if (i < 0) {
            return search(bstNode.left, val);
        } else {
            return bstNode;
        }
    }

    public BSTNode<T> iterativeSearch(T val) {
        return iterativeSearch(mRoot, val);
    }

    private BSTNode<T> iterativeSearch(BSTNode<T> bstNode, T val) {
        while (bstNode != null) {
            int cmp = val.compareTo(bstNode.value);
            if (cmp < 0)
                bstNode = bstNode.left;
            else if (cmp > 0)
                bstNode = bstNode.right;
            else
                return bstNode;
        }
        return null;
    }


    public T minimum() {
        BSTNode<T> p = minimum(mRoot);
        if (p != null)
            return p.value;

        return null;
    }


    public BSTNode<T> minimum(BSTNode<T> bstNode) {
        if (bstNode == null) {
            return null;
        }
        while (bstNode.left != null) {
            bstNode = bstNode.left;
        }
        return bstNode;
    }

    public T maximum() {
        BSTNode<T> p = maximum(mRoot);
        if (p != null)
            return p.value;

        return null;
    }


    public BSTNode<T> maximum(BSTNode<T> bstNode) {
        if (bstNode == null) {
            return null;
        }
        while (bstNode.right != null) {
            bstNode = bstNode.right;
        }
        return bstNode;
    }

    /**
     * 前驱节点：对一棵二叉树进行中序遍历，遍历后的顺序，当前节点的前一个节点为该节点的前驱节点；
     * <p>
     * 后继节点：对一棵二叉树进行中序遍历，遍历后的顺序，当前节点的后一个节点为该节点的后继节点；
     * <p>
     * 例如一颗完全二叉树（1,2,3,4,5,6,7），按照中序遍历后的顺序为：（4,2,5,1,6,3,7），1节点的前驱节点为：5，后继节点为6.
     *
     * @param bstNode
     * @return
     */
    public BSTNode<T> predecessor(BSTNode<T> bstNode) {
        // 如果x存在左孩子，则"x的前驱结点"为 "以其左孩子为根的子树的最大结点"。
        if (bstNode.left != null) {
            return maximum(bstNode.left);
        }

        // 如果x没有左孩子。则x有以下两种可能:
        // (01) x是"一个右孩子"，则"x的前驱结点"为 "它的父结点"。
        // (01) x是"一个左孩子"，则查找"x的最低的父结点，并且该父结点要具有右孩子"，找到的这个"最低的父结点"就是"x的前驱结点"。
        BSTNode<T> y = bstNode.parent;
        while ((y != null) && (bstNode == y.left)) {
            bstNode = y;
            y = y.parent;
        }
        return y;

    }

    /*
     * 找结点(x)的后继结点。即，查找"二叉树中数据值大于该结点"的"最小结点"。
     */
    public BSTNode<T> successor(BSTNode<T> bstNode) {
        // 如果x存在右孩子，则"x的后继结点"为 "以其右孩子为根的子树的最小结点"。
        if (bstNode.right != null)
            return minimum(bstNode.right);

        // 如果x没有右孩子。则x有以下两种可能: 
        // (01) x是"一个左孩子"，则"x的后继结点"为 "它的父结点"。
        // (02) x是"一个右孩子"，则查找"x的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"x的后继结点"。
        BSTNode<T> y = bstNode.parent;
        while ((y != null) && (bstNode == y.right)) {
            bstNode = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * 1.删除的节点为叶子节点：直接删除。
     * <p>
     * 2.删除的节点只存在左子树或右子树：删除节点的父节点直接指向子树节点。
     * <p>
     * 3.删除的节点同时存在左子树和右子树：将删除节点的左子树的最右节点或右子树的最左节点替换删除节点，同时删除替换节点，再将删除节点指向子树节点。
     */

    private BSTNode<T> remove(BSTree<T> bst, BSTNode<T> z) {
        return null;
    }

    /*
     * 删除结点(z)，并返回被删除的结点
     *
     * 参数说明:
     *     tree 二叉树的根结点
     *     z 删除的结点
     */
    public void remove(T key) {
        BSTNode<T> z, node;
        if ((z = search(mRoot, key)) != null)
            if ((node = remove(this, z)) != null)
                node = null;
    }


    public void print() {
        if (mRoot != null)
            print(mRoot, (T) mRoot.value, 0);
    }

    /*
     * 打印"二叉查找树"
     *
     * key        -- 节点的键值
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(BSTNode<T> tree, T key, int direction) {
        if (tree != null) {

            if (direction == 0)    // tree是根节点
                System.out.printf("%2d is root\n", tree.value);
            else                // tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.value, key, direction == 1 ? "right" : "left");

            print(tree.left, tree.value, -1);
            print(tree.right, tree.value, 1);
        }
    }

    /*
     * 销毁二叉树
     */
    private void destroy(BSTNode<T> tree) {
        if (tree == null)
            return;
        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);
        tree = null;
    }

    public void clear() {
        destroy(mRoot);
        mRoot = null;
    }


    public class BSTNode<T extends Comparable> {
        private T value;
        private BSTNode<T> left;
        private BSTNode<T> right;
        private BSTNode<T> parent;

        public BSTNode(T value, BSTNode<T> left, BSTNode<T> right, BSTNode<T> parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public T getValue() {
            return value;
        }
    }


}
