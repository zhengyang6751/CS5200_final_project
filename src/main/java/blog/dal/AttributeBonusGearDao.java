package blog.dal;
import blog.model.AttributeBonusGear;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AttributeBonusGearDao {
    protected ConnectionManager connectionManager;

	private static AttributeBonusGearDao instance = null;
	protected AttributeBonusGearDao() {
		connectionManager = new ConnectionManager();
	}
	public static AttributeBonusGearDao getInstance() {
		if(instance == null) {
			instance = new AttributeBonusGearDao();
		}
		return instance;
	}

    public AttributeBonusGear create(AttributeBonusGear attributeBonusGear) throws SQLException{
        String query = "INSERT INTO AttributeBonusGear (itemName, strengthBonus, dexterityBonus, vitalityBonus, intelligenceBonus, mindBonus) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, attributeBonusGear.getItemName());
            statement.setInt(2, attributeBonusGear.getStrengthBonus());
            statement.setInt(3, attributeBonusGear.getDexterityBonus());
            statement.setInt(4, attributeBonusGear.getVitalityBonus());
            statement.setInt(5, attributeBonusGear.getIntelligenceBonus());
            statement.setInt(6, attributeBonusGear.getMindBonus());
            statement.executeUpdate();
            return attributeBonusGear;
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

    public AttributeBonusGear getAttributeBonusGearByItemName(String itemName) throws SQLException{
        String query = "SELECT * FROM AttributeBonusGear WHERE itemName = ?;";
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
                AttributeBonusGear attributeBonusGear = new AttributeBonusGear(resultItemName, strengthBonus, dexterityBonus, vitalityBonus, intelligenceBonus, mindBonus);
                return attributeBonusGear;
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
        }
        return null;
    }
}
