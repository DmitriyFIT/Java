import java.security.SecureRandom;
import java.util.concurrent.CopyOnWriteArrayList;

public class Node {
    private volatile Node parent;
    private String url;
    private volatile int depth;
    private volatile CopyOnWriteArrayList<Node> children;

    public Node(String url) {
        parent = null;
        this.url = url;
        depth = 0;
        children = new CopyOnWriteArrayList<>();
    }

    private int calculateDepth() {
        int depthCount = 0;
        if (parent == null) {
            return depthCount;
        }
        else {
            depthCount = 1 + parent.calculateDepth();
        }
        return depthCount;
    }

    public synchronized void addChild(Node element) {
        Node root = getRootElement();
        if (!root.containsUrl(element.getUrl())) {
            element.setParent(this);
            children.add(element);
        }
    }

    public Node getRootElement() {
        return parent == null ? this : parent.getRootElement();
    }

    private boolean containsUrl(String url) {
        if (this.url.equals(url)) {
            return true;
        }
        for (Node child : children) {
            if (child.containsUrl(url)) {
                return true;
            }
        }
        return false;
    }

    public String getUrl() {
        return url;
    }

    private synchronized void setParent(Node node) {
        this.parent = node;
        this.depth = calculateDepth();
    }

    public CopyOnWriteArrayList<Node> getChildren() {
        return children;
    }
}