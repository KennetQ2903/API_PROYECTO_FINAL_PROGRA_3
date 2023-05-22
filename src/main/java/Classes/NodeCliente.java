package Classes;

public class NodeCliente {
    Cliente client;
    int height;
    NodeCliente left, right;

    public NodeCliente(Cliente client) {
        this.client = client;
        this.height = 1;
    }
}
