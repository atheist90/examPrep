package stepic2_4;

public class Revizor {

    public Revizor(){

    }

    private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder etwas = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
            etwas.append(roles[i]);
            etwas.append(":");
            etwas.append("\n");
            for (int j = 0; j < textLines.length; j++) {
                if(textLines[j].startsWith(roles[i]) && textLines[j].startsWith(":", roles[i].length()) && textLines[j].contains(roles[i]+": ")) {

                    etwas.append(j+1);
                    etwas.append(")");
                    etwas.append(textLines[j].substring(roles[i].length() + 1));
                    etwas.append("\n");
                }
            }
            etwas.append("\n");
        }

        return  etwas.toString();
    }


    public static void main(String[] args) {
        String [] roles= {
                "A",
                "AA",
                "AAA"};
        String [] textLines={
                "AAA: 1A",
                "AA: 2AA",
                "A: 3AAA"};

        Revizor revizor = new Revizor();
        System.out.println(revizor.printTextPerRole(roles, textLines));
    }
}