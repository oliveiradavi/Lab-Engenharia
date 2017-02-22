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
			Socket s = srv.accept();
			String addr = s.getInetAddress().getHostAddress();
			System.out.println("O cliente " + addr + " se conectou na aplicação");
			
			OutputStream out = s.getOutputStream();
			OutputStreamWriter outw = new OutputStreamWriter(out);
			outw.write("Ola bem vindo ao servidor de aplicação\n");
			outw.write("Digite algo\n");
			InputStream in = s.getInputStream();
			int i = 0;
			while ( (i = in.read()) != 27){
				System.out.println((char)i);
			}
			outw.flush();
			outw.close();
			
			System.out.println("Fim da aplicação");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
