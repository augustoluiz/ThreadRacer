/**
 * Classe ThreadCarro que herda todos os atributos e opera��es da classe Thread
 * Aqui encontra-se as Thread a serem executadas
 * @author Augusto Luiz Silva
 * @date 20/03/18
 */

package controller;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ThreadCarro extends Thread{
	private JLabel carro;
	private JButton btnIniciar;
	private JLabel nome;
	private static int podio;
	
	/**
	 * Construtor
	 * @param carro � a label contendo o ve�culo que disputar� a corrida
	 * @param btnIniciar � o bot�o respons�vel por iniciar a corrida
	 * @param nome � a label com o nome dos carros, sendo utilizada na classifica��o final
	 * @param pod vari�vel auxiliar que � sempre passada como pod = 0 
	 * a fim de ajudar na l�gica da classifica��o 
	 */
	
	public ThreadCarro(JLabel carro, JButton btnIniciar, JLabel nome, int pod) {
		this.carro = carro;
		this.btnIniciar = btnIniciar;
		this.nome = nome;
		podio = pod;
	}

	/**
	 * m�todo run que efetua achamada do m�todo executa sem a passagem de par�metros
	 */
	
	@Override
	public void run() {
		executa();
	}
	
	/**
	 * m�todo que gera randomicamente o posicionamento da label at� esta chegar a um ponto
	 * pr�-determinado (linha de chegada) e consequentemente exibir a classifica��o
	 */
	
	private void executa() {
		btnIniciar.setVisible(false);;
		Random random = new Random();
		Rectangle posicao;
		Rectangle posicao_placar;
		
		posicao = carro.getBounds();
		carro.setBounds(posicao);
		
		posicao_placar = nome.getBounds();
		
		
		while(posicao.x < 660) {
			try {
				Thread.sleep(5);
			}
			
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			posicao.x = posicao.x + random.nextInt(5);
			carro.setBounds(posicao);
		}
		if(posicao_placar.y == 34) {
			if (podio == 0) {
				podio++;
			}
			else {
				posicao_placar.y = 79;
				nome.setBounds(posicao_placar);
			}
		}
		else {
			if (podio == 0) {
				posicao_placar.y = 34;
				nome.setBounds(posicao_placar);
				podio++;
			}
		}
		
		nome.setVisible(true);
		
		btnIniciar.setVisible(true);
	}
}