/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp.controller;

import emp.model.Cliente;
import emp.model.ClienteTelefone;
import emp.model.JPAutil.ConnectionFactoryJPA;
import emp.model.TableViewModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author pompeu
 */
public class FXMLClienteTelefoneController implements Initializable {

    @FXML
    private TableView<TableViewModel> tbTelefone;
    @FXML
    private TableColumn clDDD;
    @FXML
    private TableColumn clNumero;
    @FXML
    private TableColumn clOperadora;
    @FXML
    private TextField tfDdd;
    @FXML
    private TextField tfTelefone;
    @FXML
    private TextField tfOperadora;
    @FXML
    private Button btnDeletar;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnAdcionar;
    @FXML
    private Button btnGravar;
    @FXML
    private TextField tfDependente;
    @FXML
    private Label lbDependente;
    @FXML
    private TextField tfLimite;
    @FXML
    private Label lbLimite;
    @FXML
    private TextField tfDataNascimetno;
    @FXML
    private Label lbDataNascimetno;
    @FXML
    private TextField tfCpf;
    @FXML
    private Label lbCpf;
    @FXML
    private TextField tfNome;
    @FXML
    private Label lbNome;
    @FXML
    private Label iMenssagem;
    private final ObservableList<TableViewModel> dados = FXCollections.observableArrayList();

    private List<ClienteTelefone> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initItens();
    }

    private void initItens() {
        clDDD.setCellValueFactory(new PropertyValueFactory("ddd"));
        clNumero.setCellValueFactory(new PropertyValueFactory("telefone"));
        clOperadora.setCellValueFactory(new PropertyValueFactory("operadora"));

        tbTelefone.setItems(dados);

        btnAdcionar.setOnAction(e -> {
            if (unicoTelefone(tfDdd.getText(), tfTelefone.getText(), tfOperadora.getText())) {
                if (tfDdd.getText().isEmpty() || tfTelefone.getText().isEmpty()
                        || tfOperadora.getText().isEmpty()) {
                    iMenssagem.setText("Any Empty Iten!!");
                } else {
                    dados.add(new TableViewModel(tfDdd.getText(),
                            tfTelefone.getText(),
                            tfOperadora.getText()));
                    limparcampos(true);
                }

            }

        });

        btnDeletar.setOnAction(e -> {
            if (tbTelefone.getSelectionModel().getFocusedIndex() > -1) {
                dados.remove(tbTelefone.getSelectionModel()
                        .getSelectedItem());
            } else {
                iMenssagem.setText("Selecione Algum Item");
            }
        });

        tbTelefone.setOnMouseClicked(e -> {
            tfDdd.setText(tbTelefone.getSelectionModel()
                    .getSelectedItem().dddProperty().get());
            tfTelefone.setText(tbTelefone.getSelectionModel()
                    .getSelectedItem().telefoneProperty().get());
            tfOperadora.setText(tbTelefone.getSelectionModel()
                    .getSelectedItem().operadoraProperty().get());
        });

        btnAlterar.setOnAction(e -> {
            iMenssagem.setText("");
            int getindex = tbTelefone.getSelectionModel().getFocusedIndex();
            if (getindex == -1) {
                iMenssagem.setText("Selecione um linha");
            } else {
                tbTelefone.getItems().remove(getindex);
                dados.add(new TableViewModel(tfDdd.getText(),
                        tfTelefone.getText(),
                        tfOperadora.getText()));
            }

        });

        btnGravar.setOnAction(e -> {
            list = new ArrayList<>();
            Double limite = Double.parseDouble(tfLimite.getText());
            Integer dependetes = Integer.valueOf(tfDependente.getText());
            Cliente c = new Cliente(tfNome.getText(), Calendar.getInstance().getTime(), limite, tfCpf.getText(), dependetes);

            for (TableViewModel l : dados) {
                list.add(new ClienteTelefone(l.dddProperty().get(),
                        l.operadoraProperty().get(), Integer.parseInt(l.telefoneProperty().get()), c));

            }

            c.setClienteTelefoneList(list);
            ConnectionFactoryJPA.getinstance().getEntityManager().getTransaction().begin();
            ConnectionFactoryJPA.getinstance().getEntityManager().persist(c);
            ConnectionFactoryJPA.getinstance().getEntityManager().getTransaction().commit();
        });

        tfDdd.setOnMouseClicked((e -> {
            iMenssagem.setText("");
        }));
    }

    private void limparcampos(boolean valor) {
        if (valor) {
            tfDdd.setText("");
            tfTelefone.setText("");
            tfOperadora.setText("");
            iMenssagem.setText("");
        }
    }

    /**
     * esse metodo evita que seja adicionado dados repetidos toma com parametro
     * o ddd telefone e operadado retornando true se não for repetido e fasel se
     * for repetido.
     *
     * @param ddd
     * @param telefone
     * @param operadora
     * @return
     */
    private boolean unicoTelefone(String ddd, String telefone,
            String operadora) {
        return dados.stream().filter((dado) -> (ddd.equals(dado.dddProperty().get()))).filter((dado) -> (telefone.equals(dado.telefoneProperty().get()))).noneMatch((dado) -> (operadora.equals(dado.operadoraProperty().get())));
    }

}
