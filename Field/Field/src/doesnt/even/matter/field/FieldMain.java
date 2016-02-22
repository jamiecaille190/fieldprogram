package doesnt.even.matter.field;

import javax.swing.*;

public class FieldMain
{
	public static void main(String[] args)
	{
		try
		{
			SwingUtilities.invokeLater(() -> {
				FieldWindow window = new FieldWindow();
				window.setVisible(true);
			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
