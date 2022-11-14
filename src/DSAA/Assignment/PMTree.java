package DSAA.Assignment;
import java.util.ArrayList;
import java.util.Stack;

public class PMTree {
    private class Node {
        Node parent;
        Node left, right;
        String PrimeMinisterName;
        int days;
        int subTreeNodes;

        Node(Node parent, int days, String name) {
            this.parent = parent;
            this.days = days;
            this.left = this.right = null;
            this.PrimeMinisterName = name;
            this.subTreeNodes = 0;
        }

        /*
         * When deleting, we want to know how many children a node has.
         */
        int numChildren() {
            return (left == null ? 0 : 1) + (right == null ? 0 : 1);
        }

        // how many nodes are smaller than this node
        // essentially go down the left tree nodes till null.
        int howManySmaller() {
            if (this.left == null) {
                return 0;
            }
            if (this.right == null) {
                return this.subTreeNodes;
            }
            return 1 + this.left.howManySmaller();
        }

    }

    private Node root = null;


    //Had a talk to Dr. Richerby on the 9th of Novemember and talked about a MorrisInOrderTraversal
    //where you can traverse a tree by transforming it, upon further research (a.k.a. many stackoverflow pages)
    //I have managed to implement my own version of this in order to iterate through the tree and find the shortest
    //serving prime minister

    /*references : https://liacs.leidenuniv.nl/~deutzah/DS/september28.pdf
                 : https://stackoverflow.com/questions/5502916/explain-morris-inorder-tree-traversal-without-using-stacks-or-recursion
                 : https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
                 : https://en.wikipedia.org/wiki/Threaded_binary_tree
     */

    public String nthShortest(int n) {

        int count = 0;
        //need to be able to store the shortest serving prime minister
        String nthsmallest = null;
        Node curr = root; // to store the current node

        //while we are not at the end of the right tree or current does not equal null
        while (curr != null) {
            if (curr.left == null) {
                count++;

                // if count is equal to N then we found the
                // nth smallest, so store it in nthsmallest
                if (count == n) nthsmallest = curr.PrimeMinisterName;

                // go to current's right child
                curr = curr.right;
            } else {
                // we create links to Inorder Successor and count using these links
                Node pre = curr.left;
                while (pre.right != null && pre.right != curr)
                    pre = pre.right;

                // building links
                if (pre.right == null) {
                    //link made to Inorder Successor
                    pre.right = curr;
                    curr = curr.left;
                }else {
                    // Revert the changes made in if part (break link from the Inorder Successor)
                    pre.right = null;

                    count++;

                    // we have found the smallest or something smaller than the current
                    // therefore set it to the current smallest primeminister
                    // we are doing this as sometimes when we break the links as we are reverting the tree back to normal
                    // we may find that we have encountered anther smallest
                    if (count == n)
                        nthsmallest = curr.PrimeMinisterName;

                    curr = curr.right;
                }
            }
        }
        return nthsmallest; //return the found value
    }


    public String[] allNShortest(int n) {
        String[] temp = new String[n];
        for (int i = n; i > 0; i--) {
            temp[i-1] = (nthShortest(i));
        }
        return temp;
    }

    public String getName(int days) {
        Node temp = this.getNode(days, false);
        if (temp == null) {
            return "###NO SUCH PERSON###";
        }
        return temp.PrimeMinisterName;
    }

    private Node getNode(int days, boolean reducing) {
        Node cur = this.root;
        while (cur != null) {
            if (reducing) {
                cur.subTreeNodes--;
            }
            if (days == cur.days)
                return cur;
            else if (days < cur.days)
                cur = cur.left;
            else
                cur = cur.right;
        }
        return null;
    }

    public void insert(int days, String name) {
        Node cur = root;
        if (cur == null) {
            root = new Node(null, days, name);
            return;
        }

        while (true) {
            cur.subTreeNodes++;
            if (days == cur.days) {
                // if primeinster serves the exact same days -> replace the name'
                cur.PrimeMinisterName = name;
                cur.subTreeNodes--;
                return;
            } else if (days < cur.days) {
                if (cur.left == null) {
                    cur.left = new Node(cur, days, name);
                    return;
                } else
                    cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new Node(cur, days, name);
                    return;
                } else
                    cur = cur.right;
            }
        }
    }

    /*
     * Delete a node from the tree. If the node has one child or none,
     * delete it as if it, its parent (if it exists) and its child (if
     * it has one) are a doubly linked list. Otherwise, replace the value
     * in the node to be deleted with the minimum element of its right
     * subtree and delete the node that originally contained that element.
     * Note that, by construction, that node has at most one child (it has
     * no left child because a left child would contain a smaller value).
     *
     * Will only delete the first instance the function comes across. It will not
     * seek any * further as this was not specified in the requirments.
     */

    public void delete(int days) {
        if (this.getNode(days, false) == null) {
            throw new NullPointerException("Cannot delete Nonexistant Node");
        }
        Node node = this.getNode(days, true);
        if (node.numChildren() < 2) {
            simpleDelete(node);
        } else {
            Node min = getMinNode(node.right);
            simpleDelete(min);
            node.days = min.days;
        }
    }

    /*
     * Delete a node that has one child or none. We treat this node,
     * its parent (if it exists) and its child (if it has one) as a doubly
     * linked list and delete accordingly. The code is fiddly because of
     * the special cases. We might be deleting the root (parent == null)
     * and/or we might be deleting a node with no child, with just a left
     * child or just a right child.
     */
    private void simpleDelete(Node node) {
        Node child = node.left != null ? node.left : node.right;

        if (node == root) {
            root = child;
            if (root != null)
                root.parent = null;
        } else {
            if (node == node.parent.left)
                node.parent.left = child;
            else
                node.parent.right = child;
            if (child != null)
                child.parent = node.parent;
        }
    }

    /*
     * Return the node containing the smallest value in the subtree
     * rooted at the given node. This is found by following the left
     * child reference until we get to a node that has no left child.
     */
    private Node getMinNode(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }
}