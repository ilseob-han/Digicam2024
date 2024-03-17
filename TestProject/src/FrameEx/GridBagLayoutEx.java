import java.awt.*;

public class GridBagLayoutEx extends Frame{
	GridBagLayout gb;
	GridBagConstraints gbc;
	
	public GridBagLayoutEx(){
		super("GridGabLayout Å×½ºÆ®");

		gb=new GridBagLayout();
		setLayout(gb);

		gbc=new GridBagConstraints();
		
		gbc.fill=GridBagConstraints.BOTH;

		addToFrame(new Button("ÄÄÆ÷³ÍÆ®1"), 0,0,2,1, 2.0, 1.0);
		addToFrame(new Button("ÄÄÆ÷³ÍÆ®2"), 2,0,1,1, 0.5, 1.0);
		addToFrame(new Button("ÄÄÆ÷³ÍÆ®3"), 0,1,3,1, 3.0, 1.0);
		addToFrame(new Button("ÄÄÆ÷³ÍÆ®4"), 0,2,1,2, 0.0, 1.0);
		addToFrame(new Button("ÄÄÆ÷³ÍÆ®5"), 1,2,2,1, 0.0, 1.0);
		addToFrame(new Button("ÄÄÆ÷³ÍÆ®6"), 1,3,2,1, 0.0, 1.0);

		setBounds(200,200,200,200);
		setVisible(true);
	}

	public void addToFrame(Component com, int x, int y, int width, int height, double weightx, double weighty){
		gbc.gridx=x;
		gbc.gridy=y;
		gbc.gridwidth=width;
		gbc.gridheight=height;
		gbc.weightx=weightx;
		gbc.weighty=weighty;

		add(com, gbc);
	}

	public static void main(String[] args){
		new GridBagLayoutEx();
	}
}
