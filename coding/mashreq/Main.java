package mashreq;
import java.util.*;
import java.util.stream.*;
class Main {

    static class UserScore {
        private final String name;
        private final int score;

        public UserScore(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return this.name;
        }

        public int getScore() {
            return this.score;
        }
    }

    static class Competition {
        private final List<UserScore> scores;

        private Competition(UserScore... scores) {
            this.scores = List.of(scores);
        }

        public List<UserScore> getScores() {
            return this.scores;
        }
    }

    public static void main(String[] args) {

        Competition round1 = new Competition(
                new UserScore("Alex", 2),
                new UserScore("Rudy", 4),
                new UserScore("Alexa", 9),
                new UserScore("Mary", 10),
                new UserScore("Bella", 2),
                new UserScore("John", 1)
        );

        Competition round2 = new Competition(
                new UserScore("Terry", 10),
                new UserScore("Mark", 8),
                new UserScore("Angela", 3)
        );

        Competition round3 = new Competition(
                new UserScore("Catty", 5),
                new UserScore("Raymond", 2),
                new UserScore("Lidiya", 8)
        );

        // Find count of users scored between 2 (inclusive) and 6 (inclusive) for each round
        int minimum = 2;
        int maximum = 6;
        List<Competition> rounds = Arrays.asList(round1, round2, round3);
        List<Long> usersCount = rounds.stream()
                .map(round -> round.getScores().stream()
                        .filter(u -> u.getScore() >= minimum && u.getScore() <= maximum)
                        .count()
                )
                .collect(Collectors.toList());

        System.out.println(usersCount);  // Output: [3, 1, 2]
    }
}
