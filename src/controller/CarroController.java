/**
 * Classe CarroController responsável por receber atributos da classe principal
 * e passa-los à classe que contém as Threads, além de executá-las
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
	 * @param delorean é a label contendo o veículo delorean que disputará a corrida
	 * @param ecto é a label contendo o veículo ecto-1 que disputará a corrida
	 * @param btnIniciar é o botão responsável por iniciar a corrida
	 * @param delorean_nome é a label com o nome do delorean
	 * @param ecto_nome é a label com o nome do delorean
	 */
	public CarroController(JLabel delorean, JLabel ecto, JButton btnIniciar, JLabel delorean_nome, JLabel ecto_nome) {
		this.delorean = delorean;
		this.ecto = ecto;
		this.btnIniciar = btnIniciar;
		this.delorean_nome = delorean_nome;
		this.ecto_nome = ecto_nome;
	}
	
	/**
	 * Método que chama o método executa
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
	 * Método que cria objetos da classe ThreadCarro, passando parâmtros a ela e executa as threads
	 */
	public void executa() {
		int podio = 0;
		ThreadCarro tdelorean = new ThreadCarro(delorean, btnIniciar, delorean_nome, podio);
		ThreadCarro tecto = new ThreadCarro(ecto, btnIniciar, ecto_nome, podio);
		
		tdelorean.start();
		tecto.start();
	}
}
