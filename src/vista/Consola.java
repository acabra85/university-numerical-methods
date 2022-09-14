package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controlador.methods.BisectionMethod;
import controlador.methods.NewtonMethod;
import controlador.methods.SecantMethod;
import functions.FuncionPolinomial;


public class Consola extends JFrame
{

	/**
	 * 
	 */
	private JPanel panelFunciones;
	private JPanel panelParametros;
	private JPanel panelResultados;
	private JButton butEjecutar, butBorrar;
	private JTextField fieldParams;
	private JRadioButton radAlgoritmo1, radAlgoritmo2, radAlgoritmo3;
	//private JScrollPane scrollResults;
	private JLabel[] myLabels;
	private JTextField fieldResults;
	private JTextField fieldTolerance;
	private JTextField fldNumIteraciones;
	private ActionListener radioControler;
	private ButtonController buttonControler;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Consola miConsola = new Consola();
		miConsola.start();
		/*//CosFunction miFuncion = new CosFunction();
		SinFunction miFuncion = new SinFunction();
		double [] myParams = new double[3];
		myParams[0]=0.0d;
		myParams[1]=0.4d;
		BisectionMethod miBisec = new BisectionMethod(miFuncion, myParams);
		miBisec.setTolerance(0.000000001d);
		miBisec.iterateMethod(5);
		System.out.println(miFuncion.evaluate(0.0125));*/
	}
	
	public Consola ()
	{		
		inciarConsola();
	}
	
	private void inciarConsola() 
	{
		setSize(new Dimension(50, 200));
		setLayout(new BorderLayout());
		setLocation(50, 50);
		panelFunciones = new JPanel();
		panelParametros = new JPanel();
		panelResultados = new JPanel();
		butEjecutar = new JButton("Ejecutar Algoritmo");
		butEjecutar.setActionCommand("Ejecutar");
		buttonControler = new ButtonController(this);
		radioControler = new RadioController();
		butEjecutar.addActionListener(buttonControler);
		butBorrar = new JButton("Borrar Datos");
		butBorrar.setActionCommand("Borrar");
		butBorrar.addActionListener(buttonControler);
		radAlgoritmo1 = new JRadioButton("Newton");	
		radAlgoritmo1.setActionCommand("Newton");
		radAlgoritmo1.addActionListener(radioControler);
		radAlgoritmo2 = new JRadioButton("Biseccion");	
		radAlgoritmo2.addActionListener(radioControler);
		radAlgoritmo2.setActionCommand("Biseccion");
		radAlgoritmo3 = new JRadioButton("Secante");	
		radAlgoritmo3.setActionCommand("Secante");
		radAlgoritmo3.addActionListener(radioControler);
		panelFunciones.add(radAlgoritmo1);
		panelFunciones.add(radAlgoritmo2);
		panelFunciones.add(radAlgoritmo3);
		panelFunciones.add(butEjecutar);
		panelFunciones.add(butBorrar);
		add(panelFunciones,BorderLayout.NORTH);
		fieldParams = new JTextField("", 10);
		fieldResults = new JTextField("", 30);
		fldNumIteraciones = new JTextField("", 10);
		fieldTolerance  = new JTextField("", 10);
		myLabels = new JLabel[10];
		myLabels[0] = new JLabel("Parametros:");
		myLabels[1] = new JLabel("Resultado:");
		myLabels[2] = new JLabel("Tolerancia 10^-:");
		myLabels[3] = new JLabel("Numero Iteraciones:");
		panelParametros.add(myLabels[0]);
		panelParametros.add(fieldParams);
		panelParametros.add(myLabels[2]);
		panelParametros.add(fieldTolerance);
		panelParametros.add(myLabels[3]);
		panelParametros.add(fldNumIteraciones);
		panelResultados.add(myLabels[1]);
		panelResultados.add(fieldResults);
		llenarInicial();
		add(panelParametros, BorderLayout.CENTER);
		add(panelResultados, BorderLayout.SOUTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
	}

	public void start()
	{
		pack();
		setVisible(true);
	}
	public String getRButtons()
	{
		if (radAlgoritmo1.isSelected()) 
			return radAlgoritmo1.getActionCommand();
		else if (radAlgoritmo2.isSelected()) 
			return radAlgoritmo2.getActionCommand();
		else if (radAlgoritmo3.isSelected())
			return radAlgoritmo3.getActionCommand();
		else
			return "blank";
	}

	public String[] getParametros() {
		return fieldParams.getText().split(",");
	}
	public class RadioController implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JRadioButton j = (JRadioButton)e.getSource();
				if(radAlgoritmo1.equals(j))
				{
					radAlgoritmo2.setSelected(false);
					radAlgoritmo3.setSelected(false);
				}
				if(radAlgoritmo2.equals(j))
				{
					radAlgoritmo1.setSelected(false);
					radAlgoritmo3.setSelected(false);
				}
				if(radAlgoritmo3.equals(j))
				{
					radAlgoritmo1.setSelected(false);
					radAlgoritmo2.setSelected(false);
				}
				
		}
		
	}
	public class ButtonController implements ActionListener 
	{
		private Consola root; 
		
		public ButtonController (Consola obj)
		{
			root = obj;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton f = (JButton )e.getSource();
			if (f.getActionCommand() == "Ejecutar")
			{
				if(validarCampos())
				{
					leerMetodo();
					return;
				}
				System.out.println("Favor Ingrese los parametros!!!!");
			}
			else if(f.getActionCommand() == "Borrar")
			{
				limpiarCampos();
			}		
		}

		private void leerMetodo() 
		{
			if(root.getRButtons() == "Newton"){
				System.out.println("***Newton***");	
				ejecutarNewton();
			}
			else if(root.getRButtons() == "Secante")
			{
				System.out.println("***Secante***");	
				ejecutarSecante();
			}
			else if (root.getRButtons() == "Biseccion")
			{
				System.out.println("***Biseccion***");	
				ejecutarBiseccion();
			}
			else
				System.out.println("Ninguno");
		}


	}
	private double[] obtenerParametros() {
		String []p = getParametros();
		double []p1 = new double [3];
		for (int i=0; i<p.length;i++)
			p1[i] = Double.parseDouble(p[i]);
		return p1;
	}
	public void limpiarCampos() 
	{
		 fldNumIteraciones.setText("");
		 fieldTolerance.setText("");
		 fieldResults.setText("");
		 fieldParams.setText("");
	}
	private void ejecutarNewton() {
		// TODO Auto-generated method stub
		double [] params = obtenerParametros();
		int numIt = Integer.parseInt(fldNumIteraciones.getText());
		double tol = 1/Math.pow(10, Double.parseDouble(fieldTolerance.getText()));
		FuncionPolinomial myF = new FuncionPolinomial(params);
		NewtonMethod n = new NewtonMethod(myF, params, tol);
		setRespuesta(n.iterateMethod(numIt));
	}
	public void ejecutarBiseccion() 
	{// TODO Auto-generated method stub
		double [] params = obtenerParametros();
		int numIt = Integer.parseInt(fldNumIteraciones.getText());
		double tol = 1/Math.pow(10, Double.parseDouble(fieldTolerance.getText()));
		FuncionPolinomial myF = new FuncionPolinomial(params);
		//CosFunction myF = new CosFunction();
		BisectionMethod n = new BisectionMethod(myF, params, tol);
		setRespuesta(n.iterateMethod(numIt));		
	}

	public void ejecutarSecante() 
	{
		double [] params = obtenerParametros();
		int numIt = Integer.parseInt(fldNumIteraciones.getText());
		double tol = 1/Math.pow(10, Double.parseDouble(fieldTolerance.getText()));
		//SecantMethod n = new SecantMethod(new SinFunction(), params, tol);
		FuncionPolinomial myF = new FuncionPolinomial(params);
		SecantMethod n = new SecantMethod(myF, params, tol);
		setRespuesta(n.iterateMethod(numIt));
	}

	private void llenarInicial() 
	{
		 fldNumIteraciones.setText("200");
		 fieldTolerance.setText("3");
		 fieldParams.setText("2,3");
	}
	
	public boolean validarCampos() 
	{
		try{
			Integer.parseInt(fldNumIteraciones.getText());
			Double.parseDouble(fieldTolerance.getText());			
			return true;
		}catch(Exception e){return false;}
	}

	public void setRespuesta(String str) 
	{
		this.fieldResults.setText(str);		
	}
}

