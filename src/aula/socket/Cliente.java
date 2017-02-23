package aula.socket;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {

	private static final String SERVIDOR = "10.68.76.177";
	private static final int PORTA = 50000;

	public static void main(String[] args) {

		try {
			Socket soc = new Socket(SERVIDOR, PORTA);
			InputStream serverInput = soc.getInputStream();
			OutputStream serverOutput = soc.getOutputStream();
			InputStreamReader serverReader = new InputStreamReader(serverInput);
			InputStreamReader tecladoReader = new InputStreamReader(System.in);

			while (true) {
				if (serverReader.ready()) {
					System.out.println((char) serverReader.read());
				}

				if (tecladoReader.ready()) {
					int letra = tecladoReader.read();
					serverOutput.write((char) letra);
					serverOutput.flush();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
