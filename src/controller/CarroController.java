/**
 * Classe CarroController respons�vel por receber atributos da classe principal
 * e passa-los � classe que cont�m as Threads, al�m de execut�-las
 * @author Augusto Luiz Silva
 * @date 20/03/18
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class CarroController implements ActionListener{
	private JLabel delorean;
	private JLabel ecto;
	private JButton btnIniciar;
	private JLabel delorean_nome;
	private JLabel ecto_nome;
	
	/**
	 * Construtor
	 * @param delorean � a label contendo o ve�culo delorean que disputar� a corrida
	 * @param ecto � a label contendo o ve�culo ecto-1 que disputar� a corrida
	 * @param btnIniciar � o bot�o respons�vel por iniciar a corrida
	 * @param delorean_nome � a label com o nome do delorean
	 * @param ecto_nome � a label com o nome do delorean
	 */
	public CarroController(JLabel delorean, JLabel ecto, JButton btnIniciar, JLabel delorean_nome, JLabel ecto_nome) {
		this.delorean = delorean;
		this.ecto = ecto;
		this.btnIniciar = btnIniciar;
		this.delorean_nome = delorean_nome;
		this.ecto_nome = ecto_nome;
	}
	
	/**
	 * M�todo que chama o m�todo executa
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		delorean.setBounds(-180, 335, 328, 129);
		ecto.setBounds(-225, 415, 328, 129);
		
		delorean_nome.setBounds(815, 34, 148, 28);
		delorean_nome.setVisible(false);
		
		ecto_nome.setBounds(815, 79, 148, 28);
		ecto_nome.setVisible(false);
		
		executa();
	}
	
	/**
	 * M�todo que cria objetos da classe ThreadCarro, passando par�mtros a ela e executa as threads
	 */
	public void executa() {
		int podio = 0;
		ThreadCarro tdelorean = new ThreadCarro(delorean, btnIniciar, delorean_nome, podio);
		ThreadCarro tecto = new ThreadCarro(ecto, btnIniciar, ecto_nome, podio);
		
		tdelorean.start();
		tecto.start();
	}
}
