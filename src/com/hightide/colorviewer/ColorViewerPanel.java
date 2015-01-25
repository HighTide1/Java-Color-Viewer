/**
 * Created on 1/21/2015
 */
package com.hightide.colorviewer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * @author HighTide
 *
 */
public class ColorViewerPanel extends JPanel {
	
	/**
	 * Current Color of the ColorViewerPanel
	 */
	private Color currColor;
	
	/**
	 * JLabel of the Hex Value of currColor
	 */
	private JTextPane currColorText;
	
	/**
	 * Size of the ColorViewerPanel
	 */
	private int PANEL_WIDTH  = 100;
	private int PANEL_HEIGHT = 100;
	
	/**
	 * Default Constructor for ColorViewerPanel
	 */
	public ColorViewerPanel() {
		// TODO Auto-generated constructor stub
		currColor = new Color(0, 0, 0, 0);
		currColorText = new JTextPane();
		currColorText.setText(convertColorToHex(currColor));
		currColorText.setBackground(null);
		currColorText.setBorder(null);
		currColorText.setEditable(false);
		currColorText.setOpaque(true);
		currColorText.setVisible(true);
		this.add(currColorText);
	}
	
	public void updateColor(int currRed, int currGreen, int currBlue, int currAlpha){
		currColor = new Color(currRed, currGreen, currBlue, currAlpha);
		currColorText.setText(convertColorToHex(currColor));
	}
	
	private String convertColorToHex(Color convertColor){
		String RedConversion = "", GreenConversion = "", 
			   BlueConversion = "", AlphaConversion = "";
		
		/**
		 * Convert the Red of convertColor to Hexadecimal and add it to the
		 * beginning of the HexConversion string.
		 */
		RedConversion = (Integer.toHexString(convertColor.getRed())).toUpperCase();
		RedConversion = (RedConversion.length() < 2 ? ("0" + RedConversion) : RedConversion);
		
		/**
		 * Convert the Green of convertColor to Hexadecimal and add it to the
		 * HexConversion string.
		 */
		GreenConversion = (Integer.toHexString(convertColor.getGreen())).toUpperCase();
		GreenConversion = (GreenConversion.length() < 2 ? ("0" + GreenConversion) : GreenConversion);
		
		/**
		 * Convert the Blue of convertColor to Hexadecimal and add it to the
		 * HexConversion string.
		 */
		BlueConversion = (Integer.toHexString(convertColor.getBlue())).toUpperCase();
		BlueConversion = (BlueConversion.length() < 2 ? ("0" + BlueConversion) : BlueConversion);
		
		/**
		 * Convert the Alpha of convertColor to Hexadecimal and add it to the
		 * end of the HexConversion string.
		 */
		AlphaConversion = (Integer.toHexString(convertColor.getAlpha())).toUpperCase();
		AlphaConversion = (AlphaConversion.length() < 2 ? ("0" + AlphaConversion) : AlphaConversion);
		
		return "#" + RedConversion + GreenConversion + BlueConversion + AlphaConversion;
	}
	
	@Override
	public void paintComponent(Graphics G){
		super.paintComponent(G);
		
		PANEL_WIDTH = this.getWidth();
		PANEL_HEIGHT = this.getHeight();
		
		G.setColor(currColor);
		G.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
		
		repaint();
	}
	
}
