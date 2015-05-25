package es.upm.fi.emse;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.TransferHandler;

public class Part extends JComponent {

	private static final long serialVersionUID = -2991314089476390298L;

	protected BufferedImage image;
	private int padding = 10;

	protected boolean dragging;

	private List<PartListener> partListeners = new ArrayList<PartListener>();

	public Part(String filename) {
		try {
			image = ImageIO.read(getClass().getResourceAsStream(filename));

		    setTransferHandler(new TransferHandler("time"));

		    // Since JLabel does not normally support drag-and-drop, we need an
		    // event handler to detect a drag and start the transfer.
		    addMouseMotionListener(new MouseMotionAdapter() {
		      public void mouseDragged(MouseEvent e) {
		        getTransferHandler().exportAsDrag(Part.this, e, TransferHandler.COPY);
		      }
		    });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void addPartListener(PartListener partListener) {
		partListeners.add(partListener);
	}

	public synchronized void notifyPartSelected() {
		for (PartListener partListener : partListeners) {
			if (partListener != null) {
				partListener.partSelected(this);
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		int width  = getWidth() - padding * 2;
		int height = getHeight() - padding  * 2;

		double scale = Math.min(1.0 * width / image.getWidth(), 1.0 * height / image.getHeight());

		int newWidth  = (int) Math.round(scale * image.getWidth());
		int newHeight = (int) Math.round(scale * image.getHeight());

		g.drawImage(image, (getWidth() - newWidth) / 2, (getHeight() - newHeight) / 2, newWidth, newHeight, this);
	}

}
