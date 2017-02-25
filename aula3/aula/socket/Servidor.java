package aula.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {

		try {
			System.out.println("Aplicação iniciada");
			ServerSocket srv = new ServerSocket(50000);
			System.out.println("Servidor ativo na porta 50000");

			while (true) {
				Socket s = srv.accept();
				String addr = s.getInetAddress().getHostAddress();
				System.out.println("O cliente " + addr + " se conectou na aplicação");
				AtendeCliente atende = new AtendeCliente(s);
				Thread t = new Thread(atende);
				t.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
