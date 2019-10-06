
public class Main {

	public static void main(String[] args) {
		ChatClient clientThread = new ChatClient();
		ChatServer serverThread = new ChatServer();

		serverThread.start();
		clientThread.start();
	}
}
