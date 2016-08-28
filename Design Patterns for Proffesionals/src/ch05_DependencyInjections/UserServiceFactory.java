package ch05_DependencyInjections;

public class UserServiceFactory {
	public UserService6 getInstance() {
		return new UserService6(new UserDataRepositoryImpl());
	}
}
