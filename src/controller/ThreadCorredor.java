package controller;

import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread {
	private int idPessoa;
	private int corrida;
	private Semaphore semaforo;
	private int tamanhoCorredor = 200;
	private int passoPessoa;
	
	public ThreadCorredor (int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
		
	}
	
	@Override
	public void run() {
		Corredor();
	}

	private void Corredor() {
		while (corrida <= tamanhoCorredor) {
			passoPessoa = (int)((Math.random() * 2 ) + 4);
			corrida += passoPessoa;
		}
		try {
			semaforo.acquire();
			int abrePorta = (int)((Math.random() * 1001 ) + 1000);
			sleep (abrePorta);
			System.out.println("A pessoa #" +idPessoa+ " cruzou a porta em " +abrePorta+ " segundos.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
}
