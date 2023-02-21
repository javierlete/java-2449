package com.ipartek.formacion.clientes.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.ipartek.formacion.clientes.accesodatos.DaoCliente;
import com.ipartek.formacion.clientes.accesodatos.DaoClienteSQLite;
import com.ipartek.formacion.clientes.entidades.Cliente;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientesSwing {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField tfId;
	private JTextField tfNombre;
	private JTextField tfNif;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfFechaNacimiento;
	private JButton btnAceptar;

	private DaoCliente dao = new DaoClienteSQLite("sql/clientes.db");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientesSwing window = new ClientesSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scrollPane;

	// https://www.chuidiang.org/java/tablas/tablamodelo/tablamodelo.php
	// https://chuwiki.chuidiang.org/index.php?title=JTable

	public ClientesSwing() {
		initialize();

		tableModel = (DefaultTableModel) table.getModel();

		tableModel.addColumn("Id");
		tableModel.addColumn("Nombre");
		tableModel.addColumn("NIF");
		tableModel.addColumn("Teléfono");
		tableModel.addColumn("Email");
		tableModel.addColumn("Fecha de nacimiento");

		for (Cliente cliente : dao.obtenerTodos()) {
			tableModel.addRow(new Object[] { cliente.getId(), cliente.getNombre(), cliente.getNif(),
					cliente.getTelefono(), cliente.getEmail(), cliente.getFechaNacimiento() });
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.0);
		splitPane.setContinuousLayout(true);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);

		panel = new JPanel();
		splitPane.setRightComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblNewLabel = new JLabel("Id");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		tfId = new JTextField();
		GridBagConstraints gbc_tfId = new GridBagConstraints();
		gbc_tfId.insets = new Insets(0, 0, 5, 0);
		gbc_tfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfId.gridx = 1;
		gbc_tfId.gridy = 0;
		panel.add(tfId, gbc_tfId);
		tfId.setColumns(10);

		lblNewLabel_1 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 1;
		gbc_tfNombre.gridy = 1;
		panel.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);

		lblNewLabel_2 = new JLabel("NIF");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		tfNif = new JTextField();
		GridBagConstraints gbc_tfNif = new GridBagConstraints();
		gbc_tfNif.insets = new Insets(0, 0, 5, 0);
		gbc_tfNif.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNif.gridx = 1;
		gbc_tfNif.gridy = 2;
		panel.add(tfNif, gbc_tfNif);
		tfNif.setColumns(10);

		lblNewLabel_3 = new JLabel("Teléfono");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		tfTelefono = new JTextField();
		GridBagConstraints gbc_tfTelefono = new GridBagConstraints();
		gbc_tfTelefono.insets = new Insets(0, 0, 5, 0);
		gbc_tfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTelefono.gridx = 1;
		gbc_tfTelefono.gridy = 3;
		panel.add(tfTelefono, gbc_tfTelefono);
		tfTelefono.setColumns(10);

		lblNewLabel_4 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		tfEmail = new JTextField();
		GridBagConstraints gbc_tfEmail = new GridBagConstraints();
		gbc_tfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_tfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEmail.gridx = 1;
		gbc_tfEmail.gridy = 4;
		panel.add(tfEmail, gbc_tfEmail);
		tfEmail.setColumns(10);

		lblNewLabel_5 = new JLabel("Fecha de nacimiento");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);

		tfFechaNacimiento = new JTextField();
		GridBagConstraints gbc_tfFechaNacimiento = new GridBagConstraints();
		gbc_tfFechaNacimiento.insets = new Insets(0, 0, 5, 0);
		gbc_tfFechaNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFechaNacimiento.gridx = 1;
		gbc_tfFechaNacimiento.gridy = 5;
		panel.add(tfFechaNacimiento, gbc_tfFechaNacimiento);
		tfFechaNacimiento.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente(null, tfNombre.getText(), tfNif.getText(), tfTelefono.getText(),
						tfEmail.getText(), tfFechaNacimiento.getText());

				dao.insertar(cliente);

				tableModel.addRow(new Object[] { cliente.getId(), cliente.getNombre(), cliente.getNif(),
						cliente.getTelefono(), cliente.getEmail(), cliente.getFechaNacimiento() });

				table.setRowSelectionInterval(table.getRowCount() - 1, table.getRowCount() - 1);

				JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();

				javax.swing.SwingUtilities.invokeLater(() -> verticalScrollBar.setValue(Integer.MAX_VALUE));
			}
		});

		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.anchor = GridBagConstraints.WEST;
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 6;
		panel.add(btnAceptar, gbc_btnAceptar);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = table.rowAtPoint(e.getPoint());
				int columna = 0;
				if (fila > -1) {
					Long id = (Long)tableModel.getValueAt(fila, columna);
					Cliente cliente = dao.obtenerPorId(id);
					
					tfId.setText(id.toString());
					tfNombre.setText(cliente.getNombre());
					tfNif.setText(cliente.getNif());
					tfTelefono.setText(cliente.getTelefono());
					tfEmail.setText(cliente.getEmail());
					tfFechaNacimiento.setText(cliente.getFechaNacimientoTexto());
				}
			}
		});

		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		scrollPane.setAutoscrolls(true);

		splitPane.setLeftComponent(scrollPane);

	}

}
