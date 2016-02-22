package doesnt.even.matter.field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FieldWindow extends JFrame
{
	private DrawingPanel drawingPanel;

	public FieldWindow() throws HeadlessException
	{
		super("Field");

		init();
	}

	private void init()
	{
		setSize(1300, 800);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		drawingPanel = new DrawingPanel();
		setContentPane(drawingPanel);

		addMouseListener(new ClickListener());
	}

	private class ClickListener implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			int button = e.getButton();
			Point clickedPoint = e.getLocationOnScreen();
			SwingUtilities.convertPointFromScreen(clickedPoint, drawingPanel);

			if (e.isShiftDown())
			{
				drawingPanel.removeShape(clickedPoint);
			}
			else
			{
				if (button == MouseEvent.BUTTON1) // Left click
				{
					drawingPanel.addCrossShape(clickedPoint);
				}
				else if (button == MouseEvent.BUTTON3) // Right click
				{
					drawingPanel.addCircleShape(clickedPoint);
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
	}
}
