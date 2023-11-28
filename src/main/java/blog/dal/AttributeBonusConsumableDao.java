package blog.dal;
import blog.model.AttributeBonusConsumable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AttributeBonusConsumableDao {
    protected ConnectionManager connectionManager;

	private static AttributeBonusConsumableDao instance = null;
	protected AttributeBonusConsumableDao() {
		connectionManager = new ConnectionManager();
	}
	public static AttributeBonusConsumableDao getInstance() {
		if(instance == null) {
			instance = new AttributeBonusConsumableDao();
		}
		return instance;
	}

    public AttributeBonusConsumable create(AttributeBonusConsumable attributeBonusConsumable) throws SQLException {
        String query = "INSERT INTO AttributeBonusConsumable (itemName, strengthBonus, dexterityBonus, vitalityBonus, intelligenceBonus, mindBonus) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, attributeBonusConsumable.getItemName());
            statement.setInt(2, attributeBonusConsumable.getStrengthBonus());
            statement.setInt(3, attributeBonusConsumable.getDexterityBonus());
            statement.setInt(4, attributeBonusConsumable.getVitalityBonus());
            statement.setInt(5, attributeBonusConsumable.getIntelligenceBonus());
            statement.setInt(6, attributeBonusConsumable.getMindBonus());
            statement.executeUpdate();
            return attributeBonusConsumable;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
        }
    }

    public AttributeBonusConsumable getAttributeBonusConsumableByItemName(String itemName) throws SQLException{
        String query = "SELECT * FROM AttributeBonusConsumable WHERE itemName = ?;";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, itemName);
            results = statement.executeQuery();
            if(results.next()) {
                String resultItemName = results.getString("itemName");
                int strengthBonus = results.getInt("strengthBonus");
                int dexterityBonus = results.getInt("dexterityBonus");
                int vitalityBonus = results.getInt("vitalityBonus");
                int intelligenceBonus = results.getInt("intelligenceBonus");
                int mindBonus = results.getInt("mindBonus");
                AttributeBonusConsumable attributeBonusConsumable = new AttributeBonusConsumable(resultItemName, strengthBonus, dexterityBonus, vitalityBonus, intelligenceBonus, mindBonus);
                return attributeBonusConsumable;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(results != null) {
                results.close();
            }
        }
        return null;
    }
}
