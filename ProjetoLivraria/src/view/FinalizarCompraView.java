package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.CompraController;
import model.Compra;

public class FinalizarCompraView extends JPanel implements ActionListener {
	
	private JFrame frame;
	private JTextField quantidadeField;
	private JTextField precoField;
	private Compra compra;
	
	public FinalizarCompraView(Compra c) {
		this.compra = c;
		criarFormulario();

	}

	public void criarFormulario() {
		this.setLayout(new BorderLayout());

		JLabel espacoLabel = new JLabel("");
		JLabel espacoLabel2 = new JLabel("");
		JLabel tituloLabel = new JLabel("Compra", SwingConstants.CENTER);
		tituloLabel.setFont(new Font("Arial", Font.BOLD, 40));

		JLabel livroLabel = new JLabel("Livro Selecionado");
		livroLabel.setFont(new Font("Arial", Font.BOLD, 16));

		JTextField livroField = new JTextField(20);
		livroField.setEditable(false);
		String codLivro = GerarCompraView.codLivro;
		livroField.setText(codLivro);

		JLabel quantidadeLabel = new JLabel("Quantidade");
		quantidadeLabel.setFont(new Font("Arial", Font.BOLD, 16));

		quantidadeField = new JTextField(20);

		JLabel precoLabel = new JLabel("Pre�o");
		precoLabel.setFont(new Font("Arial", Font.BOLD, 16));

		precoField = new JTextField(20);

		JButton concluir = new JButton("Concluir");
		concluir.addActionListener(this);
		concluir.setActionCommand("concluir");

		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);
		cancelar.setActionCommand("cancelar");
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.insets = new Insets(10, 0, 0, 5);

		this.add(tituloLabel, BorderLayout.NORTH);

		gbc.gridx = 0;
		gbc.gridy = 0;
		panelCentral.add(espacoLabel, gbc);

		gbc.gridx = 1;
		panelCentral.add(livroLabel, gbc);

		gbc.gridx = 2;
		panelCentral.add(livroField, gbc);

		gbc.gridy = 1;
		gbc.gridx = 1;
		panelCentral.add(quantidadeLabel, gbc);

		gbc.gridx = 2;
		panelCentral.add(quantidadeField, gbc);

		gbc.gridy = 2;
		gbc.gridx = 1;
		panelCentral.add(precoLabel, gbc);

		gbc.gridx = 2;
		panelCentral.add(precoField, gbc);

		gbc.gridx = 3;
		panelCentral.add(espacoLabel2, gbc);

		gbc.gridy = 3;
		gbc.gridx = 1;
		panelCentral.add(concluir, gbc);

		gbc.gridx = 2;
		panelCentral.add(cancelar, gbc);

		this.add(panelCentral, BorderLayout.CENTER);

	}

	public void acaoConcluir(){
		// TODO Auto-generated method stub
		compra.setQuantidade(Integer.parseInt(quantidadeField.getText()));
		compra.setPreco(Double.parseDouble(precoField.getText()));
		
		
		CompraController compraController = new CompraController();
		try {
			if(compraController.cadastro(compra)) {
				
			}
		} catch (HeadlessException /* | SQLException */ e) {
			// e.printStackTrace();
		}
	}

	public void acaoCancelar() {
		JOptionPane.showMessageDialog(null, "Impremetar a�ao para voltar ao GerarCompraView");
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("concluir")) {
			acaoConcluir();
		} else if (e.getActionCommand().equals("cancelar")) {
			acaoCancelar();

		}
	}

}
