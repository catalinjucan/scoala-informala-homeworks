package tema11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JDBCInsertTest {

	private static final String DB_CONNECTION = "jdbc:postgresql://[::1]:5432/booking";
	private static final String DB_PASSWORD = "Banana1";
	private Connection dbConnection;
	private PreparedStatement preparedStatement;

	@Before
	public void setup() {
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", DB_PASSWORD);

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, props);

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

	}

	@After
	public void cleanUp() throws SQLException {

		if (preparedStatement != null) {
			preparedStatement.close();
		}

		if (dbConnection != null) {
			dbConnection.close();
		}
	}

	@Test
	public void insertValuesInTheTables() throws SQLException {

		// insertAccomodation(10, "Suite", "King Size", 2, "Junior Suite");

		// insertRoomFair(12, 200, "Autumn");

		insertAccomodationFairRelation(40, 10, 12);

		// changeValues();
	}

	private void insertAccomodationFairRelation(int id, int idAccomodation,
			int idRoomFair) throws SQLException {
		final String insertAccomodationFairRelationSQL = "INSERT INTO accomodation_fair_relation"
				+ "(id, id_accomodation, id_room_fair) VALUES" + "(?,?,?)";
		this.preparedStatement = dbConnection
				.prepareStatement(insertAccomodationFairRelationSQL);
		preparedStatement.setInt(1, id);
		preparedStatement.setInt(2, idAccomodation);
		preparedStatement.setInt(3, idRoomFair);

		preparedStatement.executeUpdate();
	}

	private void insertAccomodation(int id, String type, String bedType,
			int maxGuests, String description) throws SQLException {
		final String insertAccomodationSQL = "INSERT INTO accomodation"
				+ "(id, type, bed_type, max_guests, description) VALUES"
				+ "(?,?,?,?,?)";
		this.preparedStatement = dbConnection
				.prepareStatement(insertAccomodationSQL);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, type);
		preparedStatement.setString(3, bedType);
		preparedStatement.setInt(4, maxGuests);
		preparedStatement.setString(5, description);

		preparedStatement.executeUpdate();

	}

	private void insertRoomFair(int id, int value, String season)
			throws SQLException {
		final String insertRoomFairSQL = "INSERT INTO room_fair"
				+ "(id, value, season) VALUES" + "(?,?,?)";
		this.preparedStatement = dbConnection
				.prepareStatement(insertRoomFairSQL);
		preparedStatement.setInt(1, id);
		preparedStatement.setInt(2, value);
		preparedStatement.setString(3, season);

		preparedStatement.executeUpdate();
	}

	private void changeValues() throws SQLException {
		String updateTableSQL = "UPDATE room_fair SET season = ? WHERE id = ?";
		this.preparedStatement = dbConnection.prepareStatement(updateTableSQL);
		preparedStatement.setString(1, "Summer");
		preparedStatement.setInt(2, 5);

		preparedStatement.executeUpdate();
	}
}
