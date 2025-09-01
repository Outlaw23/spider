package Spider.Working_On;

public class Main_Login {
	public static void MainLogin() {
		User_Data_Login  user = new User_Data_Login();

		Login_Screen  login = new Login_Screen(user.getUserData());
	}




}
