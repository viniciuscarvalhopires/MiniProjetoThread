package cursojava.thread;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

public class TimeScreen extends JDialog { //JDialog serve pra criar a tela para inserir  ou exibir dados
	
	private JPanel jPanel = new JPanel(new GridBagLayout()); //Criação do painel
	
	private JLabel description = new JLabel("Nome");
	private JTextField insertName = new JTextField();
	
	private JLabel description2 = new JLabel("E-mail");
	private JTextField insertEmail = new JTextField();
	
	private JButton startButton = new JButton("Add lista");
	private JButton stopButton = new JButton("Stop");
	
	private ThreadQueueImplement queue = new ThreadQueueImplement(); //instância da classe ThreadQueueImplement
	
	public TimeScreen() { //executa o que estiver dentro na execução
	
	setTitle("JDialong Class"); //Título do painel
	setSize(new Dimension(240, 240)); //Dimensões do painel
	setLocationRelativeTo(null); //Centralizar o painel na tela do usuário
	setResizable(false); //Desabilita o redimensionamento do painel
	
	GridBagConstraints gridBagConstraints = new GridBagConstraints(); //Definir as dimensões do painel
	gridBagConstraints.gridx = 0;
	gridBagConstraints.gridy = 0;
	gridBagConstraints.gridwidth = 2;
	gridBagConstraints.anchor = GridBagConstraints.WEST;
	gridBagConstraints.insets = new Insets(5, 10, 5, 10);
	
	description.setPreferredSize(new Dimension(200, 25)); //Dimensões da Label
	jPanel.add(description, gridBagConstraints);
	
	insertName.setPreferredSize(new Dimension(200, 25));
	gridBagConstraints.gridy ++;
	jPanel.add(insertName, gridBagConstraints);
	
	description2.setPreferredSize(new Dimension(200, 25));
	gridBagConstraints.gridy ++;
	jPanel.add(description2, gridBagConstraints);
	
	insertEmail.setPreferredSize(new Dimension(200, 25));
	gridBagConstraints.gridy ++;
	jPanel.add(insertEmail, gridBagConstraints);
	 
	gridBagConstraints.gridwidth = 1;
	startButton.setPreferredSize(new Dimension(92, 25));
	gridBagConstraints.gridy ++;
	jPanel.add(startButton, gridBagConstraints);
	
	stopButton.setPreferredSize(new Dimension(92, 25));
	gridBagConstraints.gridx ++;
	jPanel.add(stopButton, gridBagConstraints);
	
	startButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(queue == null) {
				queue = new	ThreadQueueImplement();
				queue.start();
			}
			
			
			ThreadQueue threadQueue = new ThreadQueue();
			threadQueue.setNome(insertName.getText());
			threadQueue.setEmail(insertEmail.getText());
			
			queue.add(threadQueue);
			
		}
		
	});
	
	stopButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			queue.stop();
		}
	});
	
	queue.start();
	add(jPanel, BorderLayout.WEST);
	

	setVisible(true);
	}
}
