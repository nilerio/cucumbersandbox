/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // System.in and System.out are input and output streams, respectively.
        InputStream inputStream = System.in;

        InputReader in = new InputReader(inputStream);

        // Read the number of test casese.
        int numberOfTest = in.nextInt();
        for (int currentTest = 0; currentTest < numberOfTest; ++currentTest) {

            log("Playing game " + (currentTest + 1) + "Out of " + numberOfTest);
            Config config = in.getConfig();
            playgame(config);
        }
    }

    private static void log(String s) {
      //  System.out.println(s);
    }

    private static void playgame(Config config) {

        boolean isBobTurn = true;
        for (int turn = 0; turn < config.N; turn++) {
            log(isBobTurn ? "Bob turn" : "Alice turn");
            int magicNumber = config.BobMagicNumber;
            int ennemieMagicNumber = config.AliceMagicNumber;
            if (!isBobTurn) {
                magicNumber = config.AliceMagicNumber;
                ennemieMagicNumber = config.BobMagicNumber;
            }
            if (!findNumber(config.gameValues, magicNumber, ennemieMagicNumber, isBobTurn)) {
                return;
            }
            isBobTurn = !isBobTurn;
        }
    }

    private static void printWinner(boolean isBobTurn) {
        if (isBobTurn) {
            System.out.println("ALICE");
        } else {
            System.out.println("BOB");
        }
    }

    private static boolean findNumber(List<Integer> gameValues, int magicNumber, int ennemieMagicNumber, boolean isBobTurn) {
        List<Integer> currentPlayerValues = gameValues.stream().filter(integer -> integer % magicNumber == 0)
                .collect(Collectors.toList());
        if (currentPlayerValues.isEmpty()) {
            printWinner(isBobTurn);
            return false;
        } else {
            List<Integer> ennemieValues = gameValues.stream().filter(integer -> integer % ennemieMagicNumber == 0)
                    .collect(Collectors.toList());
            if (!ennemieValues.isEmpty()) {
                gameValues.removeAll(ennemieValues);
            } else {
                gameValues.remove(currentPlayerValues.get(0));
            }
        }
        return true;
    }

    static class Config {
        public int N;
        public int BobMagicNumber;
        public int AliceMagicNumber;
        public List<Integer> gameValues;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public Config getConfig() {
            String line = next();
            Config config = new Config();
            config.N = Integer.parseInt(next());
            config.BobMagicNumber = Integer.parseInt(next());
            config.AliceMagicNumber = Integer.parseInt(next());

            ArrayList<Integer> gamevalues = new ArrayList<>();
            for (int i = 0; i < config.N; i++) {
                gamevalues.add(Integer.parseInt(next()));
            }

            config.gameValues = gamevalues;
            return config;
        }
    }
}
