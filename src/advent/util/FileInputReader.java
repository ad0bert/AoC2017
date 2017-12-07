package advent.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputReader {
    public static void readIntegerLineHorizontal(List<Integer> input, File f) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] entries = line.split("\\s+");
                for (String s : entries) {
                    input.add(Integer.parseInt(s));
                }
            }
        }
    }

    public static void readIntegerLineVertical(List<Integer> input, File f) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.add(Integer.parseInt(line));
            }
        }
    }

    public static List<Node> readTree(File f) throws FileNotFoundException, IOException {
        List<Node> input = new ArrayList<Node>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] nodeSplit = line.split(" -> ");
                Node n = new Node(nodeSplit[0]);
                if (nodeSplit.length == 2) {
                    String[] nodes = nodeSplit[1].split(", ");
                    for (String node : nodes) {
                        Node shadow = new Node(node, -1);
                        n.addNode(shadow);
                    }
                }
                input.add(n);
            }
        }
        return input;
    }
}