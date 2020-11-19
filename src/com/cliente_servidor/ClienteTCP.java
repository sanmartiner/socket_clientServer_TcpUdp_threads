package com.cliente_servidor;

import java.io.*; // classes para entrada e saída de dados//
import java.net.*; // classes para socket, servidorsocket e clientesocket//

class ClienteTCP {
	public static void main(String argv[]) throws Exception {
		String sentenca;
		String sentencaModificada;

// cria o stream do teclado
		BufferedReader cadeiaUsuario = new BufferedReader(new InputStreamReader(System.in));

		// cria o socket de acesso ao server hostname na porta 6789
		Socket clienteSocket = new Socket("127.0.0.1", 6789);

		// cria os streams (encadeamentos) de entrada e saida com o servidor
		DataOutputStream clienteParaServidor = new DataOutputStream(clienteSocket.getOutputStream());
		BufferedReader cadeiaServidor = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));

		// le uma linha do teclado e coloca em sentenca
		sentenca = cadeiaUsuario.readLine();

		// envia a linha para o server
		clienteParaServidor.writeBytes(sentenca + '\n');

		// lê uma linha do server
		sentencaModificada = cadeiaServidor.readLine();

		// apresenta a linha do server no vídeo
		System.out.println("Para o servidor " + sentencaModificada);

		// fecha o cliente
		clienteSocket.close();
	}
}
