import java.util.ArrayList;
import java.util.List;

public class A722_RemoveComments {
    public static void main(String[] args) {
        A722_RemoveComments solution = new A722_RemoveComments();
        String[] myInputs = {
                "/*Test program */",
                "int main()",
                "{ ",
                "  // variable declaration ",
                "int a, b, c;",
                "/* This is a test",
                "   multiline  ",
                "   comment for ",
                "   testing */",
                "a = b + c;",
                "}"
        };
        List<String> myResults = solution.removeComments(myInputs);
        for (String line : myResults) {
            System.out.println(line);
        }
    }

    public List<String> removeComments(String[] source) {
        List<String> results = new ArrayList<>();
        if (source == null || source.length == 0) {
            return results;
        }

        StringBuilder newStr = new StringBuilder();
        boolean blockOpen = false;
        for (String line : source) {
            int len = line.length();
            char[] curLine = line.toCharArray();
            for (int i = 0; i < len; i++) {
                //if the block comment symbol "/*" has not showed yet
                if (!blockOpen) {
                    //check "//" case
                    if (curLine[i] == '/' && i < len - 1 && curLine[i + 1] == '/') {
                        break;
                    }
                    //check "/*" case
                    else if (curLine[i] == '/' && i < len - 1 && curLine[i + 1] == '*') {
                        blockOpen = true;
                        i++;
                    }
                    //otherwise, put real codes into array
                    else {
                        newStr.append(curLine[i]);
                    }
                }
                //if the block symbol "/*" has already showed
                else {
                    //check if there is an end block symbol "*/"
                    if (curLine[i] == '*' && i < len - 1 && curLine[i + 1] == '/') {
                        blockOpen = false;
                        i++;
                    }
                }
            }
            //DO NOT FORGET to skip space
            if (!blockOpen && newStr.length() > 0) {
                results.add(newStr.toString());
                newStr = new StringBuilder();
            }
        }
        return results;
    }
}
