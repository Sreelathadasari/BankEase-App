import java.sql.*;

public class BankOperations {

    public void createAccount(String name, double balance, String type) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO accounts(holder_name, balance, account_type, created_date) VALUES(?,?,?,CURDATE())";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setDouble(2, balance);
        ps.setString(3, type);
        ps.executeUpdate();
        System.out.println("Account Created Successfully!");
        con.close();
    }

    public void deposit(int accountId, double amount) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setDouble(1, amount);
        ps.setInt(2, accountId);
        ps.executeUpdate();
        System.out.println("Amount Deposited!");
        con.close();
    }

    public void withdraw(int accountId, double amount) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setDouble(1, amount);
        ps.setInt(2, accountId);
        ps.executeUpdate();
        System.out.println("Amount Withdrawn!");
        con.close();
    }

    public void checkBalance(int accountId) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "SELECT holder_name, balance FROM accounts WHERE account_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, accountId);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            System.out.println("Name: " + rs.getString("holder_name"));
            System.out.println("Balance: " + rs.getDouble("balance"));
        }
        con.close();
    }
}