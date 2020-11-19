package com.cliente_servidor;

import java.io.*; // classes para entrada e sa�da de dados
import java.net.*; // classes para socket, servidorocket e clientesocket

class ServidorTCP {
	public static void main(String argv[]) throws Exception {
		String clienteSentenca;
		String sentencaCapturada;

        // cria socket de comunica��o com os clientes na porta 6789
		ServerSocket bemVindoSocket = new ServerSocket(8523);

		// espera msg de algum cliente e trata
		while (true) {

			// espera conex�o de algum cliente
			Socket conexaoSocket = bemVindoSocket.accept();
			// cria streams de entrada e saida com o cliente que chegou
			BufferedReader cadeiaCliente = new BufferedReader(new InputStreamReader(conexaoSocket.getInputStream()));
			DataOutputStream servidorParaCliente = new DataOutputStream(conexaoSocket.getOutputStream());

			// l� uma linha do cliente
			clienteSentenca = cadeiaCliente.readLine();

			// transforma a linha em mai�sculas
			sentencaCapturada = clienteSentenca.toUpperCase() + '\n';
			// envia a linha mai�scula para o cliente
			servidorParaCliente.writeBytes(sentencaCapturada);
		}
	}
}