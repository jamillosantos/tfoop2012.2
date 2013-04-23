package foodlink.models;

import foodlink.controllers.Actions;
import foodlink.exceptions.ValidationException;

public class Table extends Model implements IdentificableModel {

    private int id;
    private int code;

    @Override
    public void validate(Actions action) throws ValidationException {
            // TODO Auto-generated method stub

    }

    @Override
    public int getId() {
            return id;
    }

    @Override
    public void setId(int id) {
            this.id = id;
    }
    
    public int getCode() {
            return code;
    }

    public void setCode(int code) {
            this.code = code;
    }
        

}
