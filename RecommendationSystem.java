
//RecommendationSystem
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RecommendationSystem {

    private Connection connection;

    public RecommendationSystem(Connection connection) {
        this.connection = connection;
    }

    public Map<Integer, Set<String>> getAllRecommendations() {
        Map<Integer, Set<String>> allRecommendations = new HashMap<>();
        try {
            String query = "SELECT user_id, recommendation_text FROM recommendations";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String recommendation = resultSet.getString("recommendation_text");
                allRecommendations.computeIfAbsent(userId, k -> new HashSet<>()).add(recommendation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allRecommendations;
    }

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            RecommendationSystem recommendationSystem = new RecommendationSystem(connection);
            Map<Integer, Set<String>> allRecommendations = recommendationSystem.getAllRecommendations();
            for (Map.Entry<Integer, Set<String>> entry : allRecommendations.entrySet()) {
                int userId = entry.getKey();
                Set<String> userRecommendations = entry.getValue();
                System.out.println("Recommendations for User ID " + userId + ":");
                for (String recommendation : userRecommendations) {
                    System.out.println(recommendation);
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

