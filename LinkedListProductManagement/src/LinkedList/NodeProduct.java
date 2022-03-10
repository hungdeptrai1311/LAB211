
package LinkedList;

import Product_Management.Product;

public class NodeProduct {
    public Product info;
    public NodeProduct next;

    public NodeProduct() {
    }

    public NodeProduct(Product x, NodeProduct q) {
        info = x;
        next = q;
    }

    public NodeProduct(Product x) {
        this(x, null);
    }
}
