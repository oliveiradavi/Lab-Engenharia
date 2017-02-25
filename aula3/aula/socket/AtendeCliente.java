package aula.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class AtendeCliente implements Runnable {

	private Socket s;

	public AtendeCliente(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {

		try {
			OutputStream out = s.getOutputStream();
			OutputStreamWriter outw = new OutputStreamWriter(out);
			outw.write("Ola bem vindo ao servidor de aplicacao\n");
			outw.write("Digite algo\n");
			outw.flush();
			InputStream in = s.getInputStream();
			int i = 0;
			while ((i = in.read()) != 27) {
				System.out.print((char) i);
			}

			outw.close();
			System.out.println("Fim da aplicação");
		} catch (Exception e) {

		}

	}

}
