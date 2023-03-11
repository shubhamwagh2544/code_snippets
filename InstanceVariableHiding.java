package code_snippets;

public class InstanceVariableHiding {
    int varA;
    int varB;

    public InstanceVariableHiding(int varA, int varB) {
        varA = 10;
        varB = 20;
        System.out.println(varA+" "+varB);
    }

    public static void main(String[] args) {
        InstanceVariableHiding instance = new InstanceVariableHiding(1, 2);
        System.out.println(instance.varA);
        System.out.println(instance.varB);
    }
}
