/**
 * Classe principal do programa
 * @author Augusto Luiz Silva
 * @date 20/03/18
 */

package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CarroController;

public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 *É o método responsável por construir o JFrame, posicionando suas respectivas Labels e button 
	 */
	public Principal(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1005, 578);
		setResizable(false);
		
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		setContentPane(painel);
		painel.setLayout(null);
		JLabel fundo = new JLabel();
		fundo.setBounds(0, 0, 1000, 550);
		fundo.setIcon(new ImageIcon("imagens/fundo.png"));
		
		JLabel ecto = new JLabel("");
		ecto.setBounds(-225, 415, 328, 129);
		ecto.setIcon(new ImageIcon("imagens/ecto.png"));
		
		painel.add(ecto);
		
		JLabel delorean = new JLabel("");
		delorean.setBounds(-180, 335, 328, 129);
		delorean.setIcon(new ImageIcon("imagens/delorean.png"));
		
		painel.add(delorean);
		
		
		JLabel nomeBotao = new JLabel();
		nomeBotao.setIcon(new ImageIcon("imagens/start.png"));
		
		
		JButton btnIniciar = new JButton();
		btnIniciar.setBounds(20, 30, 125, 45);
		btnIniciar.setBackground(Color.white);
		btnIniciar.add(nomeBotao);
		
		painel.add(btnIniciar);
		
		JLabel delorean_nome = new JLabel();
		delorean_nome.setBounds(815, 34, 148, 28);
		delorean_nome.setIcon(new ImageIcon("imagens/delorean_nome.png"));
		delorean_nome.setVisible(false);
		
		painel.add(delorean_nome);
		
		JLabel ecto_nome = new JLabel();
		ecto_nome.setBounds(815, 79, 148, 28);
		ecto_nome.setIcon(new ImageIcon("imagens/ecto_nome.png"));
		ecto_nome.setVisible(false);
		
		painel.add(ecto_nome);
		
		painel.add(fundo);
		
		CarroController cc = new CarroController(delorean, ecto, btnIniciar, delorean_nome, ecto_nome);
		
		btnIniciar.addActionListener(cc);
	}
}
