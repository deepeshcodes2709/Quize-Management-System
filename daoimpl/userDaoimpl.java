package quizmanagementsystem.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import quizmanagementsystem.model.Role;
import quizmanagementsystem.model.User;
import quizmanagementsystem.Exception.AuthenticationFaildException;
import quizmanagementsystem.Exception.InvalidInputException;
import quizmanagementsystem.dao.userDao;
import quizmanagementsystem.util.DbUtil;

public class userDaoimpl implements userDao{

	public java.sql.Connection con;
	public userDaoimpl() throws Exception{
		con = DbUtil.getConnection();
	}
	@Override
	public void close() throws Exception {
		if(con != null)
			con.close();
	
	}
	@Override
	public void Registration(String name,String email,String password) throws InvalidInputException, SQLException {
		
		// Email Validation
	    if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
	        throw new InvalidInputException("Invalid Email Format");
	    }
		
	    // Password Validation
	    if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
	        throw new InvalidInputException(
	                "Password must contain 1 Uppercase, 1 Lowercase, 1 Number and minimum 8 characters");
	    }
		
		String sql = "insert into users(name,email,password,role) values(?,?,?,'Student')";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,name);
		stmt.setString(2,email);
		stmt.setString(3,password);
		
		
		 int count = stmt.executeUpdate();
		
		 if (stmt.executeUpdate() == 0) {
	            throw new InvalidInputException("Registration Failed");
	        }
		
	}
	@Override
	public User login(String email, String password) throws AuthenticationFaildException, SQLException {
	
			String sql = "select email,password,role from users where email = ? and password = ?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			User u = new User();
			stmt.setString(1,  email);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				
				
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setRole(Role.valueOf(rs.getString("role")));
				return u;
			}
		
	
		throw new AuthenticationFaildException("invalied email or password");
	}
	
	
}
