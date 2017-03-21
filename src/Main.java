public class Main {

    public static void main(String[] args) {
       GenbankParser genbankParser = new GenbankParser();
       genbankParser.readGenelist(args[0]);
       genbankParser.readGenbankFile(args[1]);
    }
}
