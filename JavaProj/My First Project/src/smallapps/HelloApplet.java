package smallapps;

public class HelloApplet extends java.applet.Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(java.awt.Graphics graphics) {
		graphics.drawString("Привет, Мир!", 70, 40);
	}
}