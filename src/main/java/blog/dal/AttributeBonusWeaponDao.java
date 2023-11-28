package blog.dal;
import blog.model.AttributeBonusWeapon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AttributeBonusWeaponDao {
    protected ConnectionManager connectionManager;

	private static AttributeBonusWeaponDao instance = null;
	protected AttributeBonusWeaponDao() {
		connectionManager = new ConnectionManager();
	}
	public static AttributeBonusWeaponDao getInstance() {
		if(instance == null) {
			instance = new AttributeBonusWeaponDao();
		}
		return instance;
	}

    public AttributeBonusWeapon create(AttributeBonusWeapon attributeBonusWeapon) throws SQLException{
        String query = "INSERT INTO AttributeBonusWeapon (itemName, strengthBonus, dexterityBonus, vitalityBonus, intelligenceBonus, mindBonus) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, attributeBonusWeapon.getItemName());
            statement.setInt(2, attributeBonusWeapon.getStrengthBonus());
            statement.setInt(3, attributeBonusWeapon.getDexterityBonus());
            statement.setInt(4, attributeBonusWeapon.getVitalityBonus());
            statement.setInt(5, attributeBonusWeapon.getIntelligenceBonus());
            statement.setInt(6, attributeBonusWeapon.getMindBonus());
            statement.executeUpdate();
            return attributeBonusWeapon;
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
        public AttributeBonusWeapon getAttributeBonusWeaponByItemName(String itemName) throws SQLException{
            String query = "SELECT * FROM AttributeBonusWeapon WHERE itemName = ?;";
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
                    AttributeBonusWeapon attributeBonusWeapon = new AttributeBonusWeapon(resultItemName, strengthBonus, dexterityBonus, vitalityBonus, intelligenceBonus, mindBonus);
                    return attributeBonusWeapon;
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
