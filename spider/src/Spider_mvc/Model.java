package Spider_mvc;

public class Model {
	private String currentScreen;

	public void StateManager() {
		this.currentScreen = "main";
	}

	public String getCurrentScreen() {
		return currentScreen;
	}

	public void setCurrentScreen(String screen) {
		this.currentScreen = screen;
	}
}
