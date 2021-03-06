package canvasgen.app.view.canvasview.canvasObject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class EraseLine implements CanvasObject {
	
	
	private static final long serialVersionUID = 3L;
	//fields every canvas object has
	private int key; //unique identifier (may not be needed)
	private int[] coordinates = new int[2]; //2 slots for x and y. In free draw this can be initial point
	private int zIndex; //Objects with higher z-indexes appear on top of objects with lower z-indexes
	private int backgroundColor = 0; //note this should an RGB value including alpha
	private int outlineColor; //color of the outline of the shape should also be hexadecimal
	
	//fields unique to EraseLine
	private int[] xPoints; //list of all x coordinates
	private int[] yPoints; //list of all y coordinates
	private int stroke = 1; //width of the stroke
	private int mainColor;
	
	public EraseLine(int[] xPoints, int[] yPoints){
		if(xPoints.length == yPoints.length){
			this.setxPoints(xPoints);
			this.setyPoints(yPoints);
		}else{
			System.out.println("Error Mismatching set of points");
		}
	}
	
	public EraseLine(int[] xPoints, int[] yPoints, int backgroundColor, int mainColor){
		this(xPoints, yPoints);
		this.backgroundColor = backgroundColor; //black default
		this.mainColor = mainColor;
	}
	
	//this method must be in every single canvas object!!!
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public int[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(int[] coordinates) {
		this.coordinates = coordinates;
	}

	public int getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(int backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public int getOutlineColor() {
		return outlineColor;
	}

	public void setOutlineColor(int outlineColor) {
		this.outlineColor = outlineColor;
	}

	public int getzIndex() {
		return zIndex;
	}

	public void setzIndex(int zIndex) {
		this.zIndex = zIndex;
	}

	public int getKey() {
		return key;
	}

	@Override
	public double getArea() {
		return 0;
	}

	public int getStroke() {
		return stroke;
	}

	public void setStroke(int stroke) {
		this.stroke = stroke;
	}

	public int[] getyPoints() {
		return yPoints;
	}

	public void setyPoints(int[] yPoints) {
		this.yPoints = yPoints;
	}

	public int[] getxPoints() {
		return xPoints;
	}

	public void setxPoints(int[] xPoints) {
		this.xPoints = xPoints;
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 1; i < xPoints.length; i++){
			int x1 = xPoints[i-1];
			int y1 = yPoints[i-1];
			int x2 = xPoints[i];
			int y2 = yPoints[i];
			Color c = new Color(backgroundColor, true);
			Color c1 = new Color(mainColor, true);
			g2d.setColor(c);
			g2d.setStroke(new BasicStroke(5));
			g2d.drawLine(x1, y1, x2, y2);
			g2d.setStroke(new BasicStroke(1));
			g2d.setColor(c1);
		}
	}
}

