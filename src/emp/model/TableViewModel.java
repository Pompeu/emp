/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * eu rox
 * 
 *
 * @author pompeu
 */
public class TableViewModel {

    private StringProperty ddd;
    private StringProperty telefone;
    private StringProperty operadora;

    public TableViewModel() {
    }

    public TableViewModel(String ddd, String telefone, String operadora) {
        this.ddd = new SimpleStringProperty(ddd);
        this.telefone = new SimpleStringProperty(telefone);
        this.operadora = new SimpleStringProperty(operadora);
    }

    public StringProperty dddProperty() {
        return ddd;
    }

    public StringProperty telefoneProperty() {
        return telefone;
    }

    public StringProperty operadoraProperty() {
        return operadora;
    }

}
