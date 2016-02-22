package org.tinyuml.ui.diagram;

import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JScrollPane;

import org.tinyuml.draw.Scaling;
import org.tinyuml.umldraw.StructureDiagram;

import net.menthor.editor.v2.ui.app.AppSplitPane;
import net.menthor.editor.v2.util.Util;

public class ScalingComponent {
	private OntoumlEditor editor;
	
	private transient Scaling scaling;
	
	public ScalingComponent(OntoumlEditor editor, Scaling scaling){
		this.scaling = scaling;
		this.editor = editor;
	}
	
	public ScalingComponent(OntoumlEditor editor){
		this(editor,Scaling.SCALING_100);
	}
	
	public int getScalingPercentual() { 
		return (int)((scaling.getScaleFactor()*100)/100); 
	}
	
	public double getScaleFactor(){
		return scaling.getScaleFactor();
	}
	
	private StructureDiagram diagram(){
		return editor.getDiagram();
	}
	
	private OntoumlWrapper wrapper(){
		return editor.getWrapper();
	}
	
	/**
	 * Rescales the view.
	 * @param aScaling a Scaling object
	 */
	public void setScaling(Scaling aScaling) 
	{
		scaling = aScaling;
		recalculateSize();				
	}
		
	public void fitToWindow()
	{		
		double waste = 20;
		if(AppSplitPane.get().isShowProjectBrowser()) {
			waste+=240;
		}
		if(AppSplitPane.get().isShowPalette()) {
			waste+=240;
		}
		double offx = (Util.getScreenWorkingWidth()-waste)/diagram().getUsedCanvasSize().get(1).getX();
		double offy = (Util.getScreenWorkingHeight()-200)/diagram().getUsedCanvasSize().get(1).getY();
		double diffx = (diagram().getUsedCanvasSize().get(1).getX()-(Util.getScreenWorkingWidth()-waste));
		double diffy = (diagram().getUsedCanvasSize().get(1).getY()-(Util.getScreenWorkingHeight()-200));
		if(diffx < 0) {
			diffx=0;
		}
		if(diffy < 0) {
			diffy=0;
		}
		if(diffx > diffy) {	
			setScaling(getScaling(offx));			
			wrapper().getToolBar().update(getZoomPercentualValue());
		}else if (diffx < diffy){
			setScaling(getScaling(offy));			
			wrapper().getToolBar().update(getZoomPercentualValue());
		}
	}
	
	public String getZoomPercentualValue()
	{
		return scaling.toString().replace(".0","");
	}
	
	public void zoom100()
	{
		setScaling(Scaling.SCALING_100);	
		wrapper().getToolBar().update(getZoomPercentualValue());
	}
	
	public Scaling getScaling(){
		return scaling;
	}
	
	public Scaling getScaling(double value)
	{
		if (value >= 1.50) return Scaling.SCALING_150; 
		else if (value < 1.50 && value >= 1.45) return Scaling.SCALING_145;
		else if (value < 1.45 && value >= 1.40) return Scaling.SCALING_140;
		else if (value < 1.40 && value >= 1.35) return Scaling.SCALING_135;
		else if (value < 1.35 && value >= 1.30) return Scaling.SCALING_130;
		else if (value < 1.30 && value >= 1.25) return Scaling.SCALING_125;
		else if (value < 1.25 && value >= 1.20) return Scaling.SCALING_120;
		else if (value < 1.20 && value >= 1.15) return Scaling.SCALING_115;
		else if (value < 1.15 && value >= 1.10) return Scaling.SCALING_110;
		else if (value < 1.10 && value >= 1.05) return Scaling.SCALING_105;
		else if (value < 1.05 && value >= 1.00) return Scaling.SCALING_100;
		else if (value < 1.00 && value >= 0.95) return Scaling.SCALING_95;
		else if (value < 0.95 && value >= 0.90) return Scaling.SCALING_90;
		else if (value < 0.90 && value >= 0.85) return Scaling.SCALING_85;
		else if (value < 0.85 && value >= 0.80) return Scaling.SCALING_80;
		else if (value < 0.80 && value >= 0.75) return Scaling.SCALING_75;
		else if (value < 0.75 && value >= 0.70) return Scaling.SCALING_70;
		else if (value < 0.70 && value >= 0.65) return Scaling.SCALING_65;
		else if (value < 0.65 && value >= 0.60) return Scaling.SCALING_60;
		else if (value < 0.60 && value >= 0.55) return Scaling.SCALING_55;
		else if (value < 0.55) return Scaling.SCALING_50;
		return Scaling.SCALING_100;
	}
	
	public void zoomOut()
	{			
		if (scaling.equals(Scaling.SCALING_150)) setScaling(Scaling.SCALING_145); 
		else if (scaling.equals(Scaling.SCALING_145)) setScaling(Scaling.SCALING_140);
		else if (scaling.equals(Scaling.SCALING_140)) setScaling(Scaling.SCALING_135);
		else if (scaling.equals(Scaling.SCALING_135)) setScaling(Scaling.SCALING_130);
		else if (scaling.equals(Scaling.SCALING_130)) setScaling(Scaling.SCALING_125);
		else if (scaling.equals(Scaling.SCALING_125)) setScaling(Scaling.SCALING_120);
		else if (scaling.equals(Scaling.SCALING_120)) setScaling(Scaling.SCALING_115);
		else if (scaling.equals(Scaling.SCALING_115)) setScaling(Scaling.SCALING_110);
		else if (scaling.equals(Scaling.SCALING_110)) setScaling(Scaling.SCALING_105);
		else if (scaling.equals(Scaling.SCALING_105)) setScaling(Scaling.SCALING_100);		
		else if (scaling.equals(Scaling.SCALING_100)) setScaling(Scaling.SCALING_95);
		else if (scaling.equals(Scaling.SCALING_95)) setScaling(Scaling.SCALING_90);
		else if (scaling.equals(Scaling.SCALING_90)) setScaling(Scaling.SCALING_85);
		else if (scaling.equals(Scaling.SCALING_85)) setScaling(Scaling.SCALING_80);
		else if (scaling.equals(Scaling.SCALING_80)) setScaling(Scaling.SCALING_75);
		else if (scaling.equals(Scaling.SCALING_75)) setScaling(Scaling.SCALING_70);
		else if (scaling.equals(Scaling.SCALING_70)) setScaling(Scaling.SCALING_65);
		else if (scaling.equals(Scaling.SCALING_65)) setScaling(Scaling.SCALING_60);
		else if (scaling.equals(Scaling.SCALING_60)) setScaling(Scaling.SCALING_55);
		else if (scaling.equals(Scaling.SCALING_55)) setScaling(Scaling.SCALING_50);
		wrapper().getToolBar().update(getZoomPercentualValue());
	}

//	public void centeredZoomOut(Point point) {
//	    zoomOut();
//	    Point pos = wrapper().getScrollPane().getViewport().getViewPosition();
//	    double diff = (scaling.getScaleFactor()-1f);	    
//	    double rest = 1f - diff;
//	    int newX = (int)((point.x*diff)+(rest*pos.x));
//	    int newY = (int)((point.y*diff)+(rest*pos.y));
//	    wrapper().getScrollPane().getViewport().setViewPosition(new Point(newX, newY));
//	    revalidate();
//	    repaint();
//	}
//
//	public void centeredZoomIn(Point point) {
//	    zoomIn();
//	    Point pos = wrapper().getScrollPane().getViewport().getViewPosition();
//	    double diff = (scaling.getScaleFactor()-1f);	    	    
//	    int newX = (int)((point.x*diff)+(scaling.getScaleFactor()*pos.x));
//	    int newY = (int)((point.y*diff)+(scaling.getScaleFactor()*pos.y));
//	    wrapper().getScrollPane().getViewport().setViewPosition(new Point(newX, newY));
//	    revalidate();
//	    repaint();
//	}
	
	public void zoomIn()
	{	
		if (scaling.equals(Scaling.SCALING_50)) setScaling(Scaling.SCALING_55);
		else if (scaling.equals(Scaling.SCALING_55)) setScaling(Scaling.SCALING_60);
		else if (scaling.equals(Scaling.SCALING_60)) setScaling(Scaling.SCALING_65);
		else if (scaling.equals(Scaling.SCALING_65)) setScaling(Scaling.SCALING_70);
		else if (scaling.equals(Scaling.SCALING_70)) setScaling(Scaling.SCALING_75);
		else if (scaling.equals(Scaling.SCALING_75)) setScaling(Scaling.SCALING_80);
		else if (scaling.equals(Scaling.SCALING_80)) setScaling(Scaling.SCALING_85);
		else if (scaling.equals(Scaling.SCALING_85)) setScaling(Scaling.SCALING_90);
		else if (scaling.equals(Scaling.SCALING_90)) setScaling(Scaling.SCALING_95);
		else if (scaling.equals(Scaling.SCALING_95)) setScaling(Scaling.SCALING_100);
		else if (scaling.equals(Scaling.SCALING_100)) setScaling(Scaling.SCALING_105);
		else if (scaling.equals(Scaling.SCALING_105)) setScaling(Scaling.SCALING_110);
		else if (scaling.equals(Scaling.SCALING_110)) setScaling(Scaling.SCALING_115);
		else if (scaling.equals(Scaling.SCALING_115)) setScaling(Scaling.SCALING_120);		
		else if (scaling.equals(Scaling.SCALING_120)) setScaling(Scaling.SCALING_125);
		else if (scaling.equals(Scaling.SCALING_125)) setScaling(Scaling.SCALING_130);
		else if (scaling.equals(Scaling.SCALING_130)) setScaling(Scaling.SCALING_135);
		else if (scaling.equals(Scaling.SCALING_135)) setScaling(Scaling.SCALING_140);
		else if (scaling.equals(Scaling.SCALING_140)) setScaling(Scaling.SCALING_145);
		else if (scaling.equals(Scaling.SCALING_145)) setScaling(Scaling.SCALING_150);	
		
		wrapper().getToolBar().update(getZoomPercentualValue());
	}
	
	public boolean isScale50(){
		return scaling == Scaling.SCALING_50;
	}
	
	/**
	 * Scales the diagram().
	 * @param g2d the Graphics2D object
	 */
	protected void scaleDiagram(Graphics2D g2d) 
	{
		double scaleFactor = scaling.getScaleFactor();
		g2d.scale(scaleFactor, scaleFactor);		
	}
	
	/**
	 * Adjusts this component's preferredSize attribute to the diagram's size.
	 * This also influences the scroll pane which the component is contained in.
	 */
	protected void recalculateSize() 
	{
		double diagramWidth = diagram().getSize().getWidth()*getScaleFactor();		
		double diagramHeight = diagram().getSize().getHeight()*getScaleFactor();
		double width = (diagramWidth+OntoumlEditor.MARGIN_RIGHT + OntoumlEditor.MARGIN_LEFT + OntoumlEditor.ADDSCROLL_HORIZONTAL);
		double height = (diagramHeight+OntoumlEditor.MARGIN_BOTTOM + OntoumlEditor.MARGIN_TOP + OntoumlEditor.ADDSCROLL_VERTICAL);
		editor.setPreferredSize(new Dimension((int)width,(int)height));		
		editor.setSize(new Dimension((int)width,(int)height));		
		
		if(wrapper()!=null){
			if(isScale50()) {
				wrapper().getScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				wrapper().getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			}else{
				wrapper().getScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				wrapper().getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			}
			wrapper().getScrollPane().updateUI();								
		}		
	}
	
}
