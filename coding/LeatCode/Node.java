package LeatCode;

import java.util.*;

class Node {
    String id;
    String title;
    String type;
    String path;
    String parentId;
    String parentType;

    Node(String id, String title, String type, String path, String parentId, String parentType) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.path = path;
        this.parentId = parentId;
        this.parentType = parentType;
    }


    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();

        nodes.add(new Node("12345", "company-xyz", "Company", "Company", null, null));
        nodes.add(new Node("123456", "department-abc", "Department", "Department", "12345", "Company"));
        nodes.add(new Node("1234567", "section-1", "Section", "Section", "123456", "Department"));
        nodes.add(new Node("12345678", "stage123", "Stage", "Stage", "1234567", "Section"));

        String inputTitle = "stage123";

        Map<String, Node> map = new HashMap<>();
        for (Node n : nodes) {
            map.put(n.id, n);
        }

        // Find node by title
        Node current = null;
        for (Node n : nodes) {
            if (n.title.equalsIgnoreCase(inputTitle)) {
                current = n;
                break;
            }
        }

        if (current == null) {
            System.out.println("Node not found!");
            return;
        }

        // Build full path by traversing parents
        LinkedList<String> pathList = new LinkedList<>();
        while (current != null) {
            pathList.addFirst(current.title);
            if (current.parentId == null) break;
            current = map.get(current.parentId);
        }

        String fullPath = String.join(" > ", pathList);

        System.out.println("{");
        System.out.println("  \"title\": \"" + inputTitle + "\",");
        System.out.println("  \"path\": \"" + fullPath + "\"");
        System.out.println("}");
    }
}

