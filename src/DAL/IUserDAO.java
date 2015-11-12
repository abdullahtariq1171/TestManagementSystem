package DAL;

import Data.User;

public interface IUserDAO {
	public User validateUser(String name,String pass);
	public String getUserType(String id);
}
