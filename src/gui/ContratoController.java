package gui;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import gui.utils.Alerta;
import gui.utils.Limitacoes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modelo.entidade.Contrato;
import modelo.entidade.Parcelas;
import modelo.service.ContratoService;
import modelo.service.PayPal;

public class ContratoController implements Initializable {

	private Contrato contrato;
	
	private ContratoService service;
	
	@FXML
	private Button btOk;
	
	@FXML
	private Button btOkLimparCampos;
	
	@FXML
	private Button btOkLimparParcelas;
	
	@FXML
	private TextField txtNumero;
	
	@FXML
	private TextField txtDate;
	
	@FXML
	private TextField txtValor;
	
	@FXML
	private TextField txtParcelas;
	
	@FXML
	private TextArea txtAreaView;
		
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@FXML
	public void onBtOkAction() {
		try {
			int numero = Integer.parseInt(txtNumero.getText());
			
			Date data = sdf.parse(txtDate.getText());
			
			double valor = Double.parseDouble(txtValor.getText());
			
			int parcelas = Integer.parseInt(txtParcelas.getText());
			
			contrato =  new Contrato(numero, data, valor);
			
			service = new ContratoService(new PayPal());
			
			service.calcularContrato(contrato, parcelas);
			
			txtAreaView.appendText("Número do Cliente : "+numero+"\n");
			for(Parcelas p : contrato.getList()) {
				txtAreaView.appendText(p.toString()+"\n");
			}
			
		} catch (Exception e) {
			Alerta.mostrarAlerta("Erro",null,e.getMessage(),AlertType.ERROR);
		}
		
	}
	
	@FXML
	public void btOkLimparCamposAction() {
		txtNumero.setText("");
		txtDate.setText("");
		txtValor.setText("");
		txtParcelas.setText("");
	}
	
	@FXML
	public void btOkLimparParcelasAction() {
		txtAreaView.setText("");
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Limitacoes.setTextFieldInteger(txtNumero);
		Limitacoes.setTextFieldDouble(txtValor);
		Limitacoes.setTextFieldInteger(txtParcelas);
		
	}
	
}
