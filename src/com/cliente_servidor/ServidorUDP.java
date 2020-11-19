package com.cliente_servidor;

import java.io.*; // classes para entrada e saída de dados
import java.net.*; // classes para socket, servidorsocket e clientesocket
import java.util.*;

public class ServidorUDP {
	
	public static void main(String argv[]) throws Exception {
 
		// cria socket do servidor com a porta 2000
        DatagramSocket servidorSocket = new DatagramSocket(10600);
 
        byte[] dadosRecebidos = new byte[1024];
        byte[] dadosEnviados = new byte[1024];
        
        
        while (true) {
						
			try {
 
				// declara o pacote a ser recebido
				DatagramPacket pacoteRecebido = new DatagramPacket(dadosRecebidos, dadosRecebidos.length);
				// recebe o pacote do cliente
				servidorSocket.receive(pacoteRecebido);
				System.out.println("Um novo cliente se conectou : "+pacoteRecebido.getAddress().toString());

 				//criando a Thread
			
				tratamentoRequiscao requisicao = new tratamentoRequiscao(servidorSocket, pacoteRecebido);
				requisicao.run();
				
				dadosRecebidos = new byte[1024];
				
				}catch (Exception e) {
				servidorSocket.close();
				e.printStackTrace();
			}
            
        
        }
     }
}
	
       