
package LinkedList;

import product_management.Customer;

public class NodeCustomer {
    public Customer info;
    public NodeCustomer next;

    public NodeCustomer() {
    }

    public NodeCustomer(Customer x, NodeCustomer q) {
        info = x;
        next = q;
    }

    public NodeCustomer(Customer x) {
        this(x, null);
    }
}
