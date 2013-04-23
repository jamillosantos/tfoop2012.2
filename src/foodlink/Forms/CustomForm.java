/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodLink.Forms;

import foodlink.controllers.Actions;
import foodlink.controllers.Collector;
import foodlink.controllers.Controller;
import foodlink.exceptions.ModelNotFoundException;
import foodlink.exceptions.ValidationException;
import foodlink.models.Model;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Eroneiffson
 */
public abstract class CustomForm<Mdl extends Model, Ctrlr extends Controller> extends JFrame
{

    private Actions currentAction;

    public CustomForm()
    {
        this.initialize();

        this.setCurrentAction(Actions.insert);
        
        this.populateTable();
    }

    /**
     * 
     */
    protected abstract void initialize();

    protected abstract Ctrlr getController();
  
    protected abstract Object[] createRow(Mdl model);

    protected abstract JTable getTblListagem();

    protected abstract void clearForm();

    protected void prepareToNew()
    {
        this.clearForm();
        this.setCurrentAction(Actions.insert);
    }
 
    protected abstract Mdl getModelFromForm();

    protected void save()
    {
        if (this.getCurrentAction().equals(Actions.insert))
        {
            try
            {
                //Retorna uma instância de Mdl com o Nome que estiver no tfNome
                Mdl model = this.getModelFromForm();
                //Adiciona a nova categoria no "BD
                this.getController().insert(model);
                ((DefaultTableModel) this.getTblListagem().getModel()).addRow(this.createRow(model));
                this.clearForm();
            }
            catch (ValidationException e)
            {
                System.out.println(e.getErrors());
            }
        }
        else if (this.getCurrentAction().equals(Actions.update))
        {
            try
            {
                Mdl model = this.getModelFromForm();
                this.getController().update(this.getController().get(this.getTblListagem().getSelectedRow()), model);
                Object[] objs = this.createRow(model);
                int i = 0;
                for (Object o : objs)
                {
                    ((DefaultTableModel) this.getTblListagem().getModel()).setValueAt(o, this.getTblListagem().getSelectedRow(), i++);
                }
            }
            catch (ModelNotFoundException e)
            {
                System.out.println(e.getMessage());
            }
            catch (ValidationException e)
            {
                System.out.println(e.getErrors());
            }
        }
    }

    protected abstract void modelToForm(Mdl model);

    protected void tableToForm()
    {
        if (this.getTblListagem().getSelectedRow() > -1)
        {
            this.modelToForm((Mdl)this.getController().get(this.getTblListagem().getSelectedRow()));
            this.setCurrentAction(Actions.update);
        }
    }

    /**
     * Popula a tabela com os dados.
     */
    protected void populateTable()
    {
        List<Mdl> models = this.getController().collect(new Collector<Mdl>());
        DefaultTableModel model = (DefaultTableModel) this.getTblListagem().getModel();
        for (Mdl m : models) {
            model.addRow(this.createRow(m));
        }
    }

    protected void remove()
    {
        if (this.getTblListagem().getSelectedRow() > -1)
        {
            try
            {
                this.getController().remove(this.getController().get(this.getTblListagem().getSelectedRow()));
                ((DefaultTableModel)this.getTblListagem().getModel()).removeRow(this.getTblListagem().getSelectedRow());
            }
            catch (ModelNotFoundException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            System.out.println("Deu néga!");
        }
    }

    public Actions getCurrentAction(){
        return this.currentAction;
    }

    public void setCurrentAction(Actions value)
    {
        this.currentAction = value;
    }
}
