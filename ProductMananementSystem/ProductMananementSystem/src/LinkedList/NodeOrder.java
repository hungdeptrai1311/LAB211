
package LinkedList;

import product_management.Ordering;

public class NodeOrder {
    public Ordering info;
    public NodeOrder next;

    public NodeOrder() {
    }

    public NodeOrder(Ordering x, NodeOrder q) {
        info = x;
        next = q;
    }

    public NodeOrder(Ordering x) {
        this(x, null);
    }
}
