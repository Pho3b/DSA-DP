package studying.data_structures.disjoint_set;

import java.util.Arrays;

public class DisjointSet {
    int[] componentsSize, parent;


    /**
     * Default constructor with a given set size
     *
     * @param size int[]
     */
    public DisjointSet(int size) {
        this.parent = new int[size];
        this.componentsSize = new int[size];

        // At first every element is considered a different component
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            componentsSize[i] = 1;
        }
    }

    /**
     * Finds and returns the parent(Root) element of the given element's index
     *
     * @param i int
     * @return int
     */
    public int find(int i) {
        int root = i;

        while (root != parent[root]) {
            root = parent[root];
        }

        // Here we perform the "Path compression", this is what gives us "Amortized constant time"
        while (i != root) {
            int next = parent[i];
            parent[i] = root;
            i = next;
        }

        return root;
    }

    /**
     * Unifies the two given elements/sets into the same component/set
     * If the elements already belongs to a component, the smaller component will be inserted
     * into the bigger one
     * If they have the same size, the second component will be inserted into the first one
     *
     * @param i int
     * @param j int
     */
    public void union(int i, int j) {
        int iParent = find(i);
        int jParent = find(j);

        // If the two elements already belong to the same component we can return
        if (iParent == jParent) return;

        if (componentsSize[iParent] >= componentsSize[jParent]) {
            parent[jParent] = iParent;
            componentsSize[iParent] += componentsSize[jParent];
        } else {
            parent[iParent] = jParent;
            componentsSize[jParent] += componentsSize[iParent];
        }
    }

    /**
     * Prints the DisjointSet in a suitable format
     */
    public void print() {
        System.out.println();
        System.out.println("Disjoint Set:");

        for (int i = 0; i < this.parent.length; i++) {
            System.out.print("[" + i + " ==> " + parent[i] + "] ");
        }

        // Printing the components size array
        System.out.println();
        System.out.println("Components size array:");
        System.out.println(Arrays.toString(this.componentsSize));
    }

}
