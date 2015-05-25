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
import java.util.List;

import javax.swing.JComponent;
import javax.swing.TransferHandler;

public class Recipe extends JComponent implements Transferable {

	private static final long serialVersionUID = -5072709853087281668L;

	protected Product product;
	protected List<Task> tasks;

	protected int padding = 0;

	public Recipe(Product product, List<Task> tasks) {
		 this.product = product;
		 this.tasks = tasks;

		 setTransferHandler(new TransferHandler("something") {
				private static final long serialVersionUID = 2002482706446636077L;

				@Override
				public int getSourceActions(JComponent c) {
					BufferedImage image = Recipe.this.tasks.get(0).getImage();
					int width = getWidth() - padding * 2;
					int height = getHeight() - padding * 2;

					double scale = Math.min(1.0 * width / image.getWidth(), 1.0
							* height / image.getHeight());

					int newWidth = (int) Math.round(scale * image.getWidth());
					int newHeight = (int) Math.round(scale * image.getHeight());

					setDragImage(image.getScaledInstance(newWidth, newHeight,
							Image.SCALE_FAST));

					return TransferHandler.COPY_OR_MOVE;
				}

				@Override
				public boolean canImport(JComponent comp,
						DataFlavor[] transferFlavors) {
					return super.canImport(comp, transferFlavors);
				}

				@Override
				protected Transferable createTransferable(JComponent c) {
					return Recipe.this;
				}
			});

			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					JComponent comp = (JComponent) e.getSource();
					TransferHandler handler = comp.getTransferHandler();
					handler.exportAsDrag(comp, e, TransferHandler.COPY);
				}
			});
	}

	public List<Task> getTasks() {
		return tasks;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Task task = tasks.get(0);

		if (task != null) {
			task.setSize(getSize());
			task.paint(g);
		}
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
}
