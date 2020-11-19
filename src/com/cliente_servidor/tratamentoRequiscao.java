package com.cliente_servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.lang.*;

public class tratamentoRequiscao implements Runnable{
	
	private DatagramSocket socket;
	private DatagramPacket pacoterecebido;
	byte[] dadosEnviados = new byte[1024];

	@Override
	public void run () {
	try {
		this.trataRequisicao();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}					
	}
	
	
	public tratamentoRequiscao (DatagramSocket servidorSocket, DatagramPacket pacoterecebido) {
		this.socket = servidorSocket;
		this.pacoterecebido = pacoterecebido;	
		
	}
	
	private void trataRequisicao() throws IOException{
		
		String sentenca = new String(pacoterecebido.getData());
				
		String sentencaCapturada = sentenca.toUpperCase();
		dadosEnviados = sentencaCapturada.getBytes();

     // monta o pacote com enderço IP e porta
		DatagramPacket pacoteEnviado = new DatagramPacket(dadosEnviados, dadosEnviados.length, pacoterecebido.getAddress(), pacoterecebido.getPort());

     // envia ao cliente
		this.socket.send(pacoteEnviado);
	
	}
	
	
}
