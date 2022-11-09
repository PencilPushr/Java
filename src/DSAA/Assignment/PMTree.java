package DSAA.Assignment;
import java.util.ArrayList;

public class PMTree {
    private class Node {
        Node parent;
        Node left, right;
        String PrimeMinisterName;
        int days;
        int subTreeNodes;

        Node (Node parent, int days, String name) {
            this.parent = parent;
            this.days = days;
            this.left = this.right = null;
            this.PrimeMinisterName = name;
            this.subTreeNodes = 0;
        }

        /*
         *  When deleting, we want to know how many children a node has.
         */
        int numChildren () {
            return (left == null ? 0 : 1) + (right == null ? 0 : 1);
        }

        //how many nodes are smaller than this node
        // essentially go down the left tree nodes till null.
        int howManySmaller() {
            if (this.left == null){return 0;}
            if (this.right == null){return this.subTreeNodes;}
            return 1 + this.left.howManySmaller();
        }

    }

    private Node root = null;

    //recursive algorithm for finding subtree size at a given node
    int getSubtreeSize(int cur, ArrayList<Integer> children, ArrayList<Integer> subSize) {
        subSize.set(cur, 1);
        int size = children.size();
        for (int i = 0; i < size; i++) {
            subSize.set(cur, getSubtreeSize(i, children, subSize));
            if (i == (size - 1)) {
                return subSize.get(cur);
            }
        }
        return size;
    }



    public String nthShortest (int n) {
        if (n < 1) {
            System.out.println("Cannot have shorter than the shortest.");
            return "";
        }
        if (this.root == null){
            System.out.println("Cannot search an empty list.");
            return "";
        }
        if (n > this.root.subTreeNodes+1){
            System.out.println("There aren't that many items.");
            return "";
        }
        boolean found = false;
        Node current = this.root;
        while (!found){

            int temp = current.howManySmaller() + 1;
            System.out.println(current.PrimeMinisterName);
            System.out.println("Temp: "+temp);
            if (temp < n){
                //no longer looking for nth smallest
                //looking for n-(howmuchstuff I've skipped) -> alter create a copy of n and perform the operation
                //n - temp would give the value of stuff we have skipped
                //the thing we are looking for
                n -= temp;
                current = current.right;
            } else if (temp > n){
                current = current.left;
            }else{
                found = true;
            }
        }
        return current.PrimeMinisterName;
    }

    public String[] allNShortest (int n){
        String[] temp = new String[n];
        for(int i = n; i > 0; i--){
            temp[i] = (nthShortest(i));
        }
        return temp;
    }

    public String getName (int days) {
        Node temp = this.getNode (days,false);
        if (temp == null){
            return "###NO SUCH PERSON###";
        }
        return temp.PrimeMinisterName;
    }

    private Node getNode (int days, boolean reducing) {
        Node cur = this.root;
        while (cur != null) {
            if (reducing){cur.subTreeNodes--;}
            if (days == cur.days)
                return cur;
            else if (days < cur.days)
                cur = cur.left;
            else
                cur = cur.right;
        }
        return null;
    }

    public void insert (int days, String name) {
        Node cur = root;
        if (cur == null) {
            root = new Node (null, days, name);
            return;
        }

        while (true) {
            cur.subTreeNodes++;
            if (days == cur.days){
                //add modification so if a primeminister serves the exact same days -> replace the name
                //other case, cur.subTreeNode--;
                return;
            }
            else if (days < cur.days) {
                System.out.println("Adding left.");
                if (cur.left == null) {
                    cur.left = new Node (cur, days, name);
                    return;
                } else
                    cur = cur.left;
            } else {
                System.out.println("Adding right.");
                if (cur.right == null) {
                    cur.right = new Node (cur, days, name);
                    return;
                } else
                    cur = cur.right;
            }
        }
    }

    /*
     *  Delete a node from the tree. If the node has one child or none,
     *  delete it as if it, its parent (if it exists) and its child (if
     *  it has one) are a doubly linked list. Otherwise, replace the value
     *  in the node to be deleted with the minimum element of its right
     *  subtree and delete the node that originally contained that element.
     *  Note that, by construction, that node has at most one child (it has
     *  no left child because a left child would contain a smaller value).
     *
     *  Will only delete the first instance the function comes across. It will not seek any          *  further as this was not specified in the requirments.
     */


    public void delete (int days) {
        if (this.getNode (days,false) == null){
            throw new NullPointerException("Cannot delete Nonexistant Node");
        }
        Node node = this.getNode (days,true);
        if (node.numChildren() < 2) {
            simpleDelete (node);
        } else {
            Node min = getMinNode(node.right);
            simpleDelete (min);
            node.days = min.days;
        }
    }

    /*
     *  Delete a node that has one child or none. We treat this node,
     *  its parent (if it exists) and its child (if it has one) as a doubly
     *  linked list and delete accordingly. The code is fiddly because of
     *  the special cases. We might be deleting the root (parent == null)
     *  and/or we might be deleting a node with no child, with just a left
     *  child or just a right child.
     */
    private void simpleDelete (Node node) {
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
     *  Return the node containing the smallest value in the subtree
     *  rooted at the given node. This is found by following the left
     *  child reference until we get to a node that has no left child.
     */
    private Node getMinNode (Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }
}