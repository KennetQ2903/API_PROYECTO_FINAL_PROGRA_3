package Classes;

import java.util.ArrayList;
import java.util.List;

public class AVLTreeClient {
    private NodeCliente root;
    private int height(NodeCliente node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int balanceFactor(NodeCliente node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private NodeCliente rotateLeft(NodeCliente node) {
        NodeCliente x = node.right;
        NodeCliente t = x.left;
        x.left = node;
        node.right = t;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private NodeCliente rotateRight(NodeCliente node) {
        NodeCliente x = node.left;
        NodeCliente t = x.right;
        x.right = node;
        node.left = t;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private NodeCliente rotateDoubleLeft(NodeCliente node) {
        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }

    private NodeCliente rotateDoubleRight(NodeCliente node) {
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    public void insert(Cliente client) {
        root = insert(root, client);
    }

    private NodeCliente insert(NodeCliente node, Cliente client) {
        if (node == null) {
            return new NodeCliente(client);
        }
        if (client.getCUI() < node.client.getCUI()) {
            node.left = insert(node.left, client);
        } else if (client.getCUI() > node.client.getCUI()) {
            node.right = insert(node.right, client);
        } else {
            return node;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = balanceFactor(node);
        if (balance > 1 && client.getCUI() < node.left.client.getCUI()) {
            return rotateRight(node);
        }
        if (balance < -1 && client.getCUI() > node.right.client.getCUI()) {
            return rotateLeft(node);
        }
        if (balance > 1 && client.getCUI() > node.left.client.getCUI()) {
            return rotateDoubleRight(node);
        }
        if (balance < -1 && client.getCUI() < node.right.client.getCUI()) {
            return rotateDoubleLeft(node);
        }
        return node;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    // Método auxiliar para recorrer el árbol AVL en orden
    private void inOrderTraversal(NodeCliente node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.client.toString() + " ");
            inOrderTraversal(node.right);
        }
    }

    // Método para obtener la profundidad del árbol AVL
    public int getDepth() {
        return getDepth(root);
    }

    // Método auxiliar para obtener la profundidad de un nodo del árbol AVL
    private int getDepth(NodeCliente node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // Método para obtener el nivel del árbol AVL
    public int getLevel() {
        return getLevel(root);
    }

    // Método auxiliar para obtener el nivel de un nodo del árbol AVL
    private int getLevel(NodeCliente node) {
        if (node == null) {
            return 0;
        }
        int leftLevel = getLevel(node.left);
        int rightLevel = getLevel(node.right);
        return Math.max(leftLevel, rightLevel) + 1;
    }

    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        getClientes(root, clientes);
        return clientes;
    }

    private void getClientes(NodeCliente node, List<Cliente> clientes) {
        if (node != null) {
            getClientes(node.left, clientes);
            clientes.add(node.client);
            getClientes(node.right, clientes);
        }
    }

    public Cliente buscarCliente(long cui) {
        NodeCliente node = buscarCliente(root, cui);
        if (node != null) {
            return node.client;
        }
        return null;
    }

    private NodeCliente buscarCliente(NodeCliente node, long cui) {
        if (node == null || node.client.getCUI() == cui) {
            return node;
        }
        if (cui < node.client.getCUI()) {
            return buscarCliente(node.left, cui);
        } else {
            return buscarCliente(node.right, cui);
        }
    }


}
