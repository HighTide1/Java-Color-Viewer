/**
 * Created on 1/21/2015
 */
package com.hightide.colorviewer;

import java.awt.AWTError;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * @author HighTide
 * @version 1.0
 *
 */
public class ColorViewerFrame extends JFrame{
	
	/**
	 * Serializable ID for ColorViewerFrame
	 */
	private static final long serialVersionUID = 2025709581700051943L;
	
	/**
	 * Default Size of ColorViewerFrame if the System Toolkit
	 * is unavailable.
	 * 
	 * 
	 */
	private static final int DefaultWidth = 100;
	private static final int DefaultHeight = 100;
	
	/**
	 * Vertical Spacing on the Y-Axis of the ColorViewerFrame for the JSliders
	 */
	private static final int SLIDER_SPACING = 30;
	
	/**
	 * JPanel for the visualization of a color
	 */
	private ColorViewerPanel ColorPanel;
	
	/**
	 * JSlider's for RGBA (Red, Green, Blue, Alpha) values of a color
	 */
	private JSlider RedSlider;
	private JSlider GreenSlider;
	private JSlider BlueSlider;
	private JSlider AlphaSlider;
	
	/**
	 * JSlider Constants for RGBA
	 */
	private static final int JSLIDER_MIN = 0;
	private static final int JSLIDER_MAX = 255;
	private static final int JSLIDER_INC = 5;
	private static final int JSLIDER_MIN_TICK = 5;
	private static final int JSLIDER_MAX_TICK = 15;
	
	public ColorViewerFrame(){
		
		this.setName("Color Viewer Frame");
		this.setTitle("Color Viewer");
		try{
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			//this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		}catch(AWTError ToolkitError){
			this.setSize(DefaultWidth, DefaultHeight);
		}
		this.setPreferredSize(new Dimension(DefaultWidth, DefaultHeight));
		try{
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}catch(SecurityException ExitException){
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		}
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		prepareComponents();
		
		this.setVisible(true);
	}
	
	private void prepareComponents(){
		
		/**
		 * Initialize the ColorViewerPanel, and add it as the first object on the frame
		 */
		ColorPanel = new ColorViewerPanel();
		this.add(ColorPanel);
		
		/**
		 * Initialize the JSlider Components, then add them to the bottom of the frame
		 * with a box between each
		 */
		RedSlider = new JSlider(JSLIDER_MIN, JSLIDER_MAX, JSLIDER_INC);
		GreenSlider = new JSlider(JSLIDER_MIN, JSLIDER_MAX, JSLIDER_INC);
		BlueSlider = new JSlider(JSLIDER_MIN, JSLIDER_MAX, JSLIDER_INC);
		AlphaSlider = new JSlider(JSLIDER_MIN, JSLIDER_MAX, JSLIDER_INC);
		
		RedSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent CE){
				ColorPanel.updateColor(RedSlider.getValue(), GreenSlider.getValue(), 
									   BlueSlider.getValue(), AlphaSlider.getValue());
			}
		});
		RedSlider.setMinorTickSpacing(JSLIDER_MIN_TICK);
		RedSlider.setMajorTickSpacing(JSLIDER_MAX_TICK);
		RedSlider.setPaintLabels(true);
		RedSlider.setPaintTicks(true);
		
		GreenSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent CE){
				ColorPanel.updateColor(RedSlider.getValue(), GreenSlider.getValue(), 
									   BlueSlider.getValue(), AlphaSlider.getValue());
			}
		});
		GreenSlider.setMinorTickSpacing(JSLIDER_MIN_TICK);
		GreenSlider.setMajorTickSpacing(JSLIDER_MAX_TICK);
		GreenSlider.setPaintLabels(true);
		GreenSlider.setPaintTicks(true);
		
		BlueSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent CE){
				ColorPanel.updateColor(RedSlider.getValue(), GreenSlider.getValue(), 
									   BlueSlider.getValue(), AlphaSlider.getValue());
			}
		});
		BlueSlider.setMinorTickSpacing(JSLIDER_MIN_TICK);
		BlueSlider.setMajorTickSpacing(JSLIDER_MAX_TICK);
		BlueSlider.setPaintLabels(true);
		BlueSlider.setPaintTicks(true);
		
		AlphaSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent CE){
				ColorPanel.updateColor(RedSlider.getValue(), GreenSlider.getValue(), 
									   BlueSlider.getValue(), AlphaSlider.getValue());
			}
		});
		AlphaSlider.setMinorTickSpacing(JSLIDER_MIN_TICK);
		AlphaSlider.setMajorTickSpacing(JSLIDER_MAX_TICK);
		AlphaSlider.setPaintLabels(true);
		AlphaSlider.setPaintTicks(true);
		
		this.add(RedSlider);
		this.add(Box.createVerticalStrut(SLIDER_SPACING));
		this.add(GreenSlider);
		this.add(Box.createVerticalStrut(SLIDER_SPACING));
		this.add(BlueSlider);
		this.add(Box.createVerticalStrut(SLIDER_SPACING));
		this.add(AlphaSlider);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				ColorViewerFrame ColorViewer = new ColorViewerFrame();
			}
		});
	}

}
