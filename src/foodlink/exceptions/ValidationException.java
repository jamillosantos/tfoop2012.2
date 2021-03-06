package foodlink.exceptions;

import java.util.List;

public class ValidationException extends Exception
{
    private static final long serialVersionUID = 1L;

    private List<String> errors;

    public ValidationException(List<String> errors)
    {
            this.errors = errors;
    }

    public List<String> getErrors()
    {
            return this.errors;
    }

    @Override
    public String getMessage()
    {
        StringBuilder sb = new StringBuilder();
        for (String err : this.errors)
        {
            sb.append(err);
            sb.append("\n");
        }
        return sb.toString();
    }
}
