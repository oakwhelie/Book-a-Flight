package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Retrive;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Fly extends JDialog {

	private final JPanel contentPanel = new JPanel();
	static Fly dialog;
	
	boolean booked = false;
	
	private JLabel ID;
	private JLabel traveller;
	private JLabel tickets;

	JLabel confirmation;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog = new Fly();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Fly() 
	{
		setBounds(100, 100, 330, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{160, 110, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblId = new JLabel("ID");
			GridBagConstraints gbc_lblId = new GridBagConstraints();
			gbc_lblId.anchor = GridBagConstraints.WEST;
			gbc_lblId.insets = new Insets(0, 0, 5, 5);
			gbc_lblId.gridx = 0;
			gbc_lblId.gridy = 0;
			contentPanel.add(lblId, gbc_lblId);
		}
		{
			ID = new JLabel("New label");
			GridBagConstraints gbc_ID = new GridBagConstraints();
			gbc_ID.anchor = GridBagConstraints.WEST;
			gbc_ID.insets = new Insets(0, 0, 5, 0);
			gbc_ID.gridx = 1;
			gbc_ID.gridy = 0;
			contentPanel.add(ID, gbc_ID);
		}
		{
			JLabel lblFlyingFrom = new JLabel("Flying from");
			GridBagConstraints gbc_lblFlyingFrom = new GridBagConstraints();
			gbc_lblFlyingFrom.anchor = GridBagConstraints.WEST;
			gbc_lblFlyingFrom.insets = new Insets(0, 0, 5, 5);
			gbc_lblFlyingFrom.gridx = 0;
			gbc_lblFlyingFrom.gridy = 1;
			contentPanel.add(lblFlyingFrom, gbc_lblFlyingFrom);
		}
		{
			JLabel origin = new JLabel("New label");
			GridBagConstraints gbc_origin = new GridBagConstraints();
			gbc_origin.anchor = GridBagConstraints.WEST;
			gbc_origin.insets = new Insets(0, 0, 5, 0);
			gbc_origin.gridx = 1;
			gbc_origin.gridy = 1;
			contentPanel.add(origin, gbc_origin);
		}
		{
			JLabel lblFlyingTo = new JLabel("Flying to");
			GridBagConstraints gbc_lblFlyingTo = new GridBagConstraints();
			gbc_lblFlyingTo.anchor = GridBagConstraints.WEST;
			gbc_lblFlyingTo.insets = new Insets(0, 0, 5, 5);
			gbc_lblFlyingTo.gridx = 0;
			gbc_lblFlyingTo.gridy = 2;
			contentPanel.add(lblFlyingTo, gbc_lblFlyingTo);
		}
		{
			JLabel destination = new JLabel("New label");
			GridBagConstraints gbc_destination = new GridBagConstraints();
			gbc_destination.anchor = GridBagConstraints.WEST;
			gbc_destination.insets = new Insets(0, 0, 5, 0);
			gbc_destination.gridx = 1;
			gbc_destination.gridy = 2;
			contentPanel.add(destination, gbc_destination);
		}
		{
			JLabel lblDepartingDate = new JLabel("Departing date");
			GridBagConstraints gbc_lblDepartingDate = new GridBagConstraints();
			gbc_lblDepartingDate.anchor = GridBagConstraints.WEST;
			gbc_lblDepartingDate.insets = new Insets(0, 0, 5, 5);
			gbc_lblDepartingDate.gridx = 0;
			gbc_lblDepartingDate.gridy = 3;
			contentPanel.add(lblDepartingDate, gbc_lblDepartingDate);
		}
		{
			JLabel departingdate = new JLabel("New label");
			GridBagConstraints gbc_departingdate = new GridBagConstraints();
			gbc_departingdate.anchor = GridBagConstraints.WEST;
			gbc_departingdate.insets = new Insets(0, 0, 5, 0);
			gbc_departingdate.gridx = 1;
			gbc_departingdate.gridy = 3;
			contentPanel.add(departingdate, gbc_departingdate);
		}
		{
			JLabel lblReturns = new JLabel("Returns");
			GridBagConstraints gbc_lblReturns = new GridBagConstraints();
			gbc_lblReturns.anchor = GridBagConstraints.WEST;
			gbc_lblReturns.insets = new Insets(0, 0, 5, 5);
			gbc_lblReturns.gridx = 0;
			gbc_lblReturns.gridy = 4;
			contentPanel.add(lblReturns, gbc_lblReturns);
		}
		{
			JLabel returns = new JLabel("New label");
			GridBagConstraints gbc_returns = new GridBagConstraints();
			gbc_returns.anchor = GridBagConstraints.WEST;
			gbc_returns.insets = new Insets(0, 0, 5, 0);
			gbc_returns.gridx = 1;
			gbc_returns.gridy = 4;
			contentPanel.add(returns, gbc_returns);
		}
		{
			JLabel lblReturnDate = new JLabel("Return date");
			GridBagConstraints gbc_lblReturnDate = new GridBagConstraints();
			gbc_lblReturnDate.anchor = GridBagConstraints.WEST;
			gbc_lblReturnDate.insets = new Insets(0, 0, 5, 5);
			gbc_lblReturnDate.gridx = 0;
			gbc_lblReturnDate.gridy = 5;
			contentPanel.add(lblReturnDate, gbc_lblReturnDate);
		}
		{
			JLabel returndate = new JLabel("New label");
			GridBagConstraints gbc_returndate = new GridBagConstraints();
			gbc_returndate.anchor = GridBagConstraints.WEST;
			gbc_returndate.insets = new Insets(0, 0, 5, 0);
			gbc_returndate.gridx = 1;
			gbc_returndate.gridy = 5;
			contentPanel.add(returndate, gbc_returndate);
		}
		{
			JLabel lblTickets = new JLabel("Tickets");
			GridBagConstraints gbc_lblTickets = new GridBagConstraints();
			gbc_lblTickets.anchor = GridBagConstraints.WEST;
			gbc_lblTickets.insets = new Insets(0, 0, 5, 5);
			gbc_lblTickets.gridx = 0;
			gbc_lblTickets.gridy = 6;
			contentPanel.add(lblTickets, gbc_lblTickets);
		}
		{
			tickets = new JLabel("New label");
			GridBagConstraints gbc_tickets = new GridBagConstraints();
			gbc_tickets.anchor = GridBagConstraints.WEST;
			gbc_tickets.insets = new Insets(0, 0, 5, 0);
			gbc_tickets.gridx = 1;
			gbc_tickets.gridy = 6;
			contentPanel.add(tickets, gbc_tickets);
		}
		{
			JLabel lblPrice = new JLabel("Price");
			GridBagConstraints gbc_lblPrice = new GridBagConstraints();
			gbc_lblPrice.anchor = GridBagConstraints.WEST;
			gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrice.gridx = 0;
			gbc_lblPrice.gridy = 7;
			contentPanel.add(lblPrice, gbc_lblPrice);
		}
		{
			JLabel price = new JLabel("New label");
			GridBagConstraints gbc_price = new GridBagConstraints();
			gbc_price.anchor = GridBagConstraints.WEST;
			gbc_price.insets = new Insets(0, 0, 5, 0);
			gbc_price.gridx = 1;
			gbc_price.gridy = 7;
			contentPanel.add(price, gbc_price);
		}
		{
			JLabel lblTraveller = new JLabel("Traveller");
			GridBagConstraints gbc_lblTraveller = new GridBagConstraints();
			gbc_lblTraveller.anchor = GridBagConstraints.WEST;
			gbc_lblTraveller.insets = new Insets(0, 0, 5, 5);
			gbc_lblTraveller.gridx = 0;
			gbc_lblTraveller.gridy = 8;
			contentPanel.add(lblTraveller, gbc_lblTraveller);
		}
		{
			traveller = new JLabel("New label");
			GridBagConstraints gbc_traveller = new GridBagConstraints();
			gbc_traveller.anchor = GridBagConstraints.WEST;
			gbc_traveller.insets = new Insets(0, 0, 5, 0);
			gbc_traveller.gridx = 1;
			gbc_traveller.gridy = 8;
			contentPanel.add(traveller, gbc_traveller);
		}
		{
			confirmation = new JLabel("Do you want to book this flight?");
			GridBagConstraints gbc_confirmation = new GridBagConstraints();
			gbc_confirmation.insets = new Insets(0, 0, 0, 5);
			gbc_confirmation.anchor = GridBagConstraints.WEST;
			gbc_confirmation.gridx = 0;
			gbc_confirmation.gridy = 9;
			contentPanel.add(confirmation, gbc_confirmation);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("BOOK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						if(!booked)
						{
							confirmation.setText("Flight booked!");
							okButton.setText("OK");
							booked = true;
						}
						else 
						{
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public Fly(String data[]) {
		setBounds(100, 100, 330, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblId = new JLabel("ID");
			GridBagConstraints gbc_lblId = new GridBagConstraints();
			gbc_lblId.anchor = GridBagConstraints.WEST;
			gbc_lblId.insets = new Insets(0, 0, 5, 5);
			gbc_lblId.gridx = 0;
			gbc_lblId.gridy = 0;
			contentPanel.add(lblId, gbc_lblId);
		}
		{
			ID = new JLabel(": "+data[0]);
			GridBagConstraints gbc_ID = new GridBagConstraints();
			gbc_ID.anchor = GridBagConstraints.WEST;
			gbc_ID.insets = new Insets(0, 0, 5, 0);
			gbc_ID.gridx = 1;
			gbc_ID.gridy = 0;
			contentPanel.add(ID, gbc_ID);
		}
		{
			JLabel lblFlyingFrom = new JLabel("Flying from");
			GridBagConstraints gbc_lblFlyingFrom = new GridBagConstraints();
			gbc_lblFlyingFrom.anchor = GridBagConstraints.WEST;
			gbc_lblFlyingFrom.insets = new Insets(0, 0, 5, 5);
			gbc_lblFlyingFrom.gridx = 0;
			gbc_lblFlyingFrom.gridy = 1;
			contentPanel.add(lblFlyingFrom, gbc_lblFlyingFrom);
		}
		{
			JLabel origin = new JLabel(": "+data[1]);
			GridBagConstraints gbc_origin = new GridBagConstraints();
			gbc_origin.anchor = GridBagConstraints.WEST;
			gbc_origin.insets = new Insets(0, 0, 5, 0);
			gbc_origin.gridx = 1;
			gbc_origin.gridy = 1;
			contentPanel.add(origin, gbc_origin);
		}
		{
			JLabel lblFlyingTo = new JLabel("Flying to");
			GridBagConstraints gbc_lblFlyingTo = new GridBagConstraints();
			gbc_lblFlyingTo.anchor = GridBagConstraints.WEST;
			gbc_lblFlyingTo.insets = new Insets(0, 0, 5, 5);
			gbc_lblFlyingTo.gridx = 0;
			gbc_lblFlyingTo.gridy = 2;
			contentPanel.add(lblFlyingTo, gbc_lblFlyingTo);
		}
		{
			JLabel destination = new JLabel(": "+data[2]);
			GridBagConstraints gbc_destination = new GridBagConstraints();
			gbc_destination.anchor = GridBagConstraints.WEST;
			gbc_destination.insets = new Insets(0, 0, 5, 0);
			gbc_destination.gridx = 1;
			gbc_destination.gridy = 2;
			contentPanel.add(destination, gbc_destination);
		}
		{
			JLabel lblDepartingDate = new JLabel("Departing date");
			GridBagConstraints gbc_lblDepartingDate = new GridBagConstraints();
			gbc_lblDepartingDate.anchor = GridBagConstraints.WEST;
			gbc_lblDepartingDate.insets = new Insets(0, 0, 5, 5);
			gbc_lblDepartingDate.gridx = 0;
			gbc_lblDepartingDate.gridy = 3;
			contentPanel.add(lblDepartingDate, gbc_lblDepartingDate);
		}
		{
			JLabel departingdate = new JLabel(": "+data[3]);
			GridBagConstraints gbc_departingdate = new GridBagConstraints();
			gbc_departingdate.anchor = GridBagConstraints.WEST;
			gbc_departingdate.insets = new Insets(0, 0, 5, 0);
			gbc_departingdate.gridx = 1;
			gbc_departingdate.gridy = 3;
			contentPanel.add(departingdate, gbc_departingdate);
		}
		{
			JLabel lblReturns = new JLabel("Returns");
			GridBagConstraints gbc_lblReturns = new GridBagConstraints();
			gbc_lblReturns.anchor = GridBagConstraints.WEST;
			gbc_lblReturns.insets = new Insets(0, 0, 5, 5);
			gbc_lblReturns.gridx = 0;
			gbc_lblReturns.gridy = 4;
			contentPanel.add(lblReturns, gbc_lblReturns);
		}
		{
			JLabel returns = new JLabel(": "+data[4]);
			GridBagConstraints gbc_returns = new GridBagConstraints();
			gbc_returns.anchor = GridBagConstraints.WEST;
			gbc_returns.insets = new Insets(0, 0, 5, 0);
			gbc_returns.gridx = 1;
			gbc_returns.gridy = 4;
			contentPanel.add(returns, gbc_returns);
		}
		{
			JLabel lblReturnDate = new JLabel("Return date");
			GridBagConstraints gbc_lblReturnDate = new GridBagConstraints();
			gbc_lblReturnDate.anchor = GridBagConstraints.WEST;
			gbc_lblReturnDate.insets = new Insets(0, 0, 5, 5);
			gbc_lblReturnDate.gridx = 0;
			gbc_lblReturnDate.gridy = 5;
			contentPanel.add(lblReturnDate, gbc_lblReturnDate);
		}
		{
			JLabel returndate = new JLabel(": "+data[5]);
			GridBagConstraints gbc_returndate = new GridBagConstraints();
			gbc_returndate.anchor = GridBagConstraints.WEST;
			gbc_returndate.insets = new Insets(0, 0, 5, 0);
			gbc_returndate.gridx = 1;
			gbc_returndate.gridy = 5;
			contentPanel.add(returndate, gbc_returndate);
		}
		{
			JLabel lblTickets = new JLabel("Tickets");
			GridBagConstraints gbc_lblTickets = new GridBagConstraints();
			gbc_lblTickets.anchor = GridBagConstraints.WEST;
			gbc_lblTickets.insets = new Insets(0, 0, 5, 5);
			gbc_lblTickets.gridx = 0;
			gbc_lblTickets.gridy = 6;
			contentPanel.add(lblTickets, gbc_lblTickets);
		}
		{
			tickets = new JLabel(": "+data[6]);
			GridBagConstraints gbc_tickets = new GridBagConstraints();
			gbc_tickets.anchor = GridBagConstraints.WEST;
			gbc_tickets.insets = new Insets(0, 0, 5, 0);
			gbc_tickets.gridx = 1;
			gbc_tickets.gridy = 6;
			contentPanel.add(tickets, gbc_tickets);
		}
		{
			JLabel lblPrice = new JLabel("Price");
			GridBagConstraints gbc_lblPrice = new GridBagConstraints();
			gbc_lblPrice.anchor = GridBagConstraints.WEST;
			gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrice.gridx = 0;
			gbc_lblPrice.gridy = 7;
			contentPanel.add(lblPrice, gbc_lblPrice);
		}
		{
			double prix = Double.parseDouble(data[7])*Integer.parseInt(data[8]);
			JLabel price = new JLabel(": "+prix+" (x"+Integer.parseInt(data[8])+")" );
			GridBagConstraints gbc_price = new GridBagConstraints();
			gbc_price.anchor = GridBagConstraints.WEST;
			gbc_price.insets = new Insets(0, 0, 5, 0);
			gbc_price.gridx = 1;
			gbc_price.gridy = 7;
			contentPanel.add(price, gbc_price);
		}
		{
			JLabel lblTraveller = new JLabel("Traveller");
			GridBagConstraints gbc_lblTraveller = new GridBagConstraints();
			gbc_lblTraveller.anchor = GridBagConstraints.WEST;
			gbc_lblTraveller.insets = new Insets(0, 0, 5, 5);
			gbc_lblTraveller.gridx = 0;
			gbc_lblTraveller.gridy = 8;
			contentPanel.add(lblTraveller, gbc_lblTraveller);
		}
		{
			traveller = new JLabel(": "+data[8]);
			GridBagConstraints gbc_traveller = new GridBagConstraints();
			gbc_traveller.anchor = GridBagConstraints.WEST;
			gbc_traveller.insets = new Insets(0, 0, 5, 0);
			gbc_traveller.gridx = 1;
			gbc_traveller.gridy = 8;
			contentPanel.add(traveller, gbc_traveller);
		}
		{
			confirmation = new JLabel("Do you want to book this flight?");
			GridBagConstraints gbc_confirmation = new GridBagConstraints();
			gbc_confirmation.insets = new Insets(0, 0, 0, 5);
			gbc_confirmation.anchor = GridBagConstraints.WEST;
			gbc_confirmation.gridx = 0;
			gbc_confirmation.gridy = 9;
			contentPanel.add(confirmation, gbc_confirmation);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("BOOK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						if(!booked)
						{
							Retrive.bookFlight(data[0], data[8], data[6]);
							confirmation.setText("Flight booked!");
							okButton.setText("OK");
							booked = true;
						}
						else 
						{
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
