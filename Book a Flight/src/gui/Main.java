package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTextField;

import database.Retrive;

import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main 
{

	private JFrame frame;
	private JTextField txtFlyingFrom;
	private JTextField txtFlyingTo;
	private JTextField txtDeparting;
	private JTextField txtTraveller;
	private JTextField txtReturning;
	private JTable table;
	private JLabel search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{900, 0};
		gridBagLayout.rowHeights = new int[]{179, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel banner = new JPanel();
		banner.setBorder(null);
		GridBagConstraints gbc_banner = new GridBagConstraints();
		gbc_banner.insets = new Insets(0, 0, 5, 0);
		gbc_banner.gridx = 0;
		gbc_banner.gridy = 0;
		frame.getContentPane().add(banner, gbc_banner);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/assets/banner4.jpg")));
		banner.add(lblNewLabel);
		
		JPanel main_body = new JPanel();
		GridBagConstraints gbc_main_body = new GridBagConstraints();
		gbc_main_body.insets = new Insets(0, 0, 5, 0);
		gbc_main_body.fill = GridBagConstraints.BOTH;
		gbc_main_body.gridx = 0;
		gbc_main_body.gridy = 1;
		frame.getContentPane().add(main_body, gbc_main_body);
				
		JPanel flight_options = new JPanel();
		main_body.add(flight_options);
		GridBagLayout gbl_flight_options = new GridBagLayout();
		gbl_flight_options.columnWidths = new int[]{900, 0};
		gbl_flight_options.rowHeights = new int[]{0, 0, 0};
		gbl_flight_options.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_flight_options.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		flight_options.setLayout(gbl_flight_options);
		
		JPanel options = new JPanel();
		GridBagConstraints gbc_options = new GridBagConstraints();
		gbc_options.fill = GridBagConstraints.BOTH;
		gbc_options.gridx = 0;
		gbc_options.gridy = 1;
		flight_options.add(options, gbc_options);
		GridBagLayout gbl_options = new GridBagLayout();
		gbl_options.columnWidths = new int[]{420, 425, 0};
		gbl_options.rowHeights = new int[]{10, 0};
		gbl_options.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_options.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		options.setLayout(gbl_options);
				
						
		JPanel locations = new JPanel();
		GridBagConstraints gbc_locations = new GridBagConstraints();
		gbc_locations.insets = new Insets(0, 0, 0, 5);
		gbc_locations.gridx = 0;
		gbc_locations.gridy = 0;
		options.add(locations, gbc_locations);
		GridBagLayout gbl_locations = new GridBagLayout();
		gbl_locations.columnWidths = new int[]{30, 420, 0};
		gbl_locations.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_locations.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_locations.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		locations.setLayout(gbl_locations);
		
		JLabel lblFlyingFrom = new JLabel("Flying from:");
		GridBagConstraints gbc_lblFlyingFrom = new GridBagConstraints();
		gbc_lblFlyingFrom.fill = GridBagConstraints.BOTH;
		gbc_lblFlyingFrom.insets = new Insets(0, 0, 5, 0);
		gbc_lblFlyingFrom.gridx = 1;
		gbc_lblFlyingFrom.gridy = 0;
		locations.add(lblFlyingFrom, gbc_lblFlyingFrom);
		
		txtFlyingFrom = new JTextField();
		GridBagConstraints gbc_txtFlyingFrom = new GridBagConstraints();
		gbc_txtFlyingFrom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFlyingFrom.insets = new Insets(0, 0, 5, 0);
		gbc_txtFlyingFrom.gridx = 1;
		gbc_txtFlyingFrom.gridy = 1;
		locations.add(txtFlyingFrom, gbc_txtFlyingFrom);
		txtFlyingFrom.setText("city");
		txtFlyingFrom.setColumns(10);
		
		
		JLabel lblNewLabel_9 = new JLabel("Flying to:");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 2;
		locations.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		txtFlyingTo = new JTextField();
		GridBagConstraints gbc_txtFlyingTo = new GridBagConstraints();
		gbc_txtFlyingTo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFlyingTo.insets = new Insets(0, 0, 5, 0);
		gbc_txtFlyingTo.gridx = 1;
		gbc_txtFlyingTo.gridy = 3;
		locations.add(txtFlyingTo, gbc_txtFlyingTo);
		txtFlyingTo.setText("city");
		txtFlyingTo.setColumns(10);
		
		JLabel lblDeparting = new JLabel("Departing:");
		GridBagConstraints gbc_lblDeparting = new GridBagConstraints();
		gbc_lblDeparting.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDeparting.insets = new Insets(0, 0, 5, 0);
		gbc_lblDeparting.gridx = 1;
		gbc_lblDeparting.gridy = 4;
		locations.add(lblDeparting, gbc_lblDeparting);
		
		txtDeparting = new JTextField();
		GridBagConstraints gbc_txtDeparting = new GridBagConstraints();
		gbc_txtDeparting.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDeparting.insets = new Insets(0, 0, 5, 0);
		gbc_txtDeparting.gridx = 1;
		gbc_txtDeparting.gridy = 5;
		locations.add(txtDeparting, gbc_txtDeparting);
		txtDeparting.setText("yyyy-mm-dd");
		txtDeparting.setColumns(10);
		
		JLabel lblTravellers = new JLabel("Travellers:");
		GridBagConstraints gbc_lblTravellers = new GridBagConstraints();
		gbc_lblTravellers.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTravellers.insets = new Insets(0, 0, 5, 0);
		gbc_lblTravellers.gridx = 1;
		gbc_lblTravellers.gridy = 6;
		locations.add(lblTravellers, gbc_lblTravellers);
		
		txtTraveller = new JTextField();
		GridBagConstraints gbc_txtTraveller = new GridBagConstraints();
		gbc_txtTraveller.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTraveller.gridx = 1;
		gbc_txtTraveller.gridy = 7;
		locations.add(txtTraveller, gbc_txtTraveller);
		txtTraveller.setText("1");
		txtTraveller.setColumns(10);
		
		JPanel panel_18 = new JPanel();
		GridBagConstraints gbc_panel_18 = new GridBagConstraints();
		gbc_panel_18.fill = GridBagConstraints.BOTH;
		gbc_panel_18.gridx = 1;
		gbc_panel_18.gridy = 0;
		options.add(panel_18, gbc_panel_18);
		panel_18.setLayout(new CardLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_18.add(panel_14, "name_44001182323100");
		GridBagLayout gbl_panel_14 = new GridBagLayout();
		gbl_panel_14.columnWidths = new int[]{420, 0, 0};
		gbl_panel_14.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_14.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_14.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_14.setLayout(gbl_panel_14);
		
		JLabel lblNewLabel_10 = new JLabel("Returning:");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 0;
		panel_14.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		txtReturning = new JTextField();
		txtReturning.setText("yyyy-mm-dd");
		GridBagConstraints gbc_txtReturning = new GridBagConstraints();
		gbc_txtReturning.insets = new Insets(0, 0, 5, 5);
		gbc_txtReturning.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtReturning.gridx = 0;
		gbc_txtReturning.gridy = 1;
		panel_14.add(txtReturning, gbc_txtReturning);
		txtReturning.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel_14.add(panel_1, gbc_panel_1);
		
		JLabel info = new JLabel("*either destination or return can be left empty");
		info.setBounds(10, 102, 300, 14);
		panel_1.add(info);
		
		JPanel panel_15 = new JPanel();
		panel_18.add(panel_15, "name_44053951866108");
		panel_15.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("*either destination and return can be left empty");
		lblNewLabel_2.setBounds(10, 146, 300, 14);
		panel_15.add(lblNewLabel_2);
		
		JScrollPane flight_list = new JScrollPane();
		GridBagConstraints gbc_flight_list = new GridBagConstraints();
		gbc_flight_list.fill = GridBagConstraints.BOTH;
		gbc_flight_list.gridx = 0;
		gbc_flight_list.gridy = 3;
		frame.getContentPane().add(flight_list, gbc_flight_list);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		flight_list.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Object tabs[][] = new Object[1][9];
		tabs[0][0] = "";
		tabs[0][1] = "";
		tabs[0][2] = "";
		tabs[0][3] = "";
		tabs[0][4] = "";
		tabs[0][5] = "";
		tabs[0][6] = "";
		tabs[0][7] = "";
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			tabs,
			new String[] {
				"ID", "Origin", "Destination", "Departing date", "Returns", "Return date", "Tickets", "Price $", ""
			}
		) {
			@Override
			public boolean isCellEditable(int row, int column)
			{
				if(column==8) return true;
				else return false;
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setMinWidth(0);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(130);
		table.getColumnModel().getColumn(7).setPreferredWidth(80);
			table.getColumnModel().getColumn(8).setPreferredWidth(50);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		@SuppressWarnings("serial")
		Action act = new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        
		        String data [] = new String[9];
		        for(int x=0; x<data.length-1; x++)
		        {
		        	if(table.getModel().getValueAt(modelRow, x)!=null)
		        	data[x] = table.getModel().getValueAt(modelRow, x).toString();
		        	else data[x] = "";
		        }
		        data[8] = txtTraveller.getText();
		        
		        Fly fly = new Fly(data);
		        fly.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				fly.setVisible(true);
		    }
		};
		
		panel.setLayout(new BorderLayout());
		panel.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panel.add(table, BorderLayout.CENTER);
		
		
		panel.add(table);
		
		search = new JLabel("");
		GridBagConstraints gbc_search = new GridBagConstraints();
		gbc_search.insets = new Insets(0, 0, 5, 0);
		gbc_search.gridx = 0;
		gbc_search.gridy = 2;
		frame.getContentPane().add(search, gbc_search);
		search.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@SuppressWarnings("serial")
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try
				{
					@SuppressWarnings("unused")
					int a = Integer.parseInt(txtTraveller.getText());
					info.setText("");
					
					@SuppressWarnings("rawtypes")
					ArrayList<ArrayList>data = Retrive.retriveFlightData(txtFlyingFrom.getText(), txtFlyingTo.getText(), txtDeparting.getText(), txtReturning.getText());
					
					@SuppressWarnings("unchecked")
					ArrayList<Integer>ID = data.get(0);
					@SuppressWarnings("unchecked")
					ArrayList<String>origin = data.get(1);
					@SuppressWarnings("unchecked")
					ArrayList<String>destination = data.get(2);
					@SuppressWarnings("unchecked")
					ArrayList<String>departingdate = data.get(3);
					
					@SuppressWarnings("unchecked")
					ArrayList<Boolean>returns = data.get(4);
					@SuppressWarnings("unchecked")
					ArrayList<String>returndate = data.get(5);
					@SuppressWarnings("unchecked")
					ArrayList<Integer>tickets = data.get(6);
					@SuppressWarnings("unchecked")
					ArrayList<Double>price = data.get(7);
					if(ID.isEmpty()) info.setText("No flight available");
					

					Object tabs[][] = new Object[ID.size()][data.size()+1];
					for(int x=0; x<tabs.length; x++)
					{
						tabs[x][0] = ID.get(x);
						tabs[x][1] = origin.get(x);
						tabs[x][2] = destination.get(x);
						tabs[x][3] = departingdate.get(x);
						
						if(returns.get(x).equals(true)) tabs[x][4] = "yes";
						else tabs[x][4] = "no";
						tabs[x][5] = returndate.get(x);
						tabs[x][6] = tickets.get(x);
						tabs[x][7] = price.get(x);
						tabs[x][8] = "Fly";
					}

					
					table.setModel(new DefaultTableModel(
							tabs,
							new String[] {
								"ID", "Origin", "Destination", "Departing date", "Returns", "Return date", "Tickets", "Price", ""
							}
						) {
						@Override
						public boolean isCellEditable(int row, int column)
						{
							if(column==8) return true;
							else return false;
						}
					});
					table.getColumnModel().getColumn(0).setPreferredWidth(60);
					table.getColumnModel().getColumn(1).setPreferredWidth(130);
					table.getColumnModel().getColumn(2).setPreferredWidth(130);
					table.getColumnModel().getColumn(3).setPreferredWidth(130);
					table.getColumnModel().getColumn(3).setMinWidth(0);
					table.getColumnModel().getColumn(4).setPreferredWidth(50);
					table.getColumnModel().getColumn(5).setPreferredWidth(130);
					table.getColumnModel().getColumn(7).setPreferredWidth(80);
					table.getColumnModel().getColumn(8).setPreferredWidth(50);
					table.setBorder(new LineBorder(new Color(0, 0, 0)));
					
					@SuppressWarnings("unused")
					ButtonColumn bat = new ButtonColumn(table, act, 8);
					
					panel.repaint();
					panel.revalidate();
				} catch(NumberFormatException num)
				{
					info.setText("Invalid information");
				}
				
			}
		});
		search.setIcon(new ImageIcon(Main.class.getResource("/assets/search.png")));
			
		
	}
}
