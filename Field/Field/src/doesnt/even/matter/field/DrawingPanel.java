package doesnt.even.matter.field;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class DrawingPanel extends JComponent
{
	private static final int SIZE = 10;
	private static final int RADIUS = 14;
	private static final float STROKE = 3.0f;
	private static final Color COLOR = Color.YELLOW;
	private static final int REMOVE_DISTANCE = 10;

	private final java.util.List<Point> crosses = new ArrayList<>();
	private final java.util.List<Point> circles = new ArrayList<>();

	private Image backgroundImage;

	public DrawingPanel()
	{
		try
		{
			backgroundImage = ImageIO.read(getClass().getResource("/background.png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g2.drawImage(backgroundImage, 0, 0, this);
		g2.setColor(COLOR);
		g2.setStroke(new BasicStroke(STROKE));

		for (Point p : crosses)
		{
			g2.drawLine(p.x + SIZE, p.y + SIZE, p.x - SIZE, p.y - SIZE);
			g2.drawLine(p.x - SIZE, p.y + SIZE, p.x + SIZE, p.y - SIZE);
		}

		for (Point p : circles)
		{
			g2.drawOval(p.x - RADIUS, p.y - RADIUS, RADIUS * 2, RADIUS * 2);
		}
	}

	public void addCrossShape(Point point)
	{
		crosses.add(point);
		repaint();
	}

	public void addCircleShape(Point point)
	{
		circles.add(point);
		repaint();
	}

	public void removeShape(Point clickedPoint)
	{
		for (Point p : crosses)
		{
			if (p.distance(clickedPoint) <= REMOVE_DISTANCE)
			{
				crosses.remove(p);
				repaint();

				return;
			}
		}

		for (Point p : circles)
		{
			if (p.distance(clickedPoint) <= REMOVE_DISTANCE)
			{
				circles.remove(p);
				repaint();

				return;
			}
		}
	}
}
