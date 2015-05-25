package es.upm.fi.emse;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.TransferHandler;

public class Part extends JComponent implements Transferable {

	private static final long serialVersionUID = -2991314089476390298L;

	protected BufferedImage image;
	private int padding = 10;

	public Part(String filename) {
		try {
			image = ImageIO.read(getClass().getResourceAsStream(filename));

			setTransferHandler(new TransferHandler("something") {
				private static final long serialVersionUID = 2002482706446636077L;

				@Override
				public int getSourceActions(JComponent c) {
					int width = getWidth() - padding * 2;
					int height = getHeight() - padding * 2;

					double scale = Math.min(1.0 * width / image.getWidth(), 1.0
							* height / image.getHeight());

					int newWidth = (int) Math.round(scale * image.getWidth());
					int newHeight = (int) Math.round(scale * image.getHeight());

					setDragImage(image.getScaledInstance(newWidth, newHeight,
							Image.SCALE_FAST));

					return TransferHandler.COPY;
				}

				@Override
				public boolean canImport(JComponent comp,
						DataFlavor[] transferFlavors) {
					return super.canImport(comp, transferFlavors);
				}

				@Override
				protected Transferable createTransferable(JComponent c) {
					return Part.this;
				}
			});

			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					JComponent comp = (JComponent) e.getSource();
					TransferHandler handler = comp.getTransferHandler();
					handler.exportAsDrag(comp, e, TransferHandler.COPY);
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		return this;
	}

	protected DataFlavor getDataFlavor() {
		DataFlavor flavor = null;

		try {
			flavor = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flavor;
	}

	public DataFlavor[] getTransferDataFlavors() {
		return new DataFlavor[] { getDataFlavor() };
	}

	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return flavor.equals(getDataFlavor());
	}

	public BufferedImage getImage() {
		return image;
	}

}
