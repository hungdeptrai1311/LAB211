
package LinkedList;

import Product_Management.Order;

public class NodeOrder {
    public Order info;
    public NodeOrder next;

    public NodeOrder() {
    }

    public NodeOrder(Order x, NodeOrder q) {
        info = x;
        next = q;
    }

    public NodeOrder(Order x) {
        this(x, null);
    }
}
