package DAL;

public class UserDBdAOFactory extends UserDAOFatory {

	@Override
	public IUserDAO getUserDAO() {
		// TODO Auto-generated method stub
		
		return new UserDAO();
	}

}
