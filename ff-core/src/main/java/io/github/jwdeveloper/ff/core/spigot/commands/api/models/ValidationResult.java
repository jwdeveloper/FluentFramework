package io.github.jwdeveloper.ff.core.spigot.commands.api.models;


import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ValidationResult
{
    private boolean success;
    private String message;

    public ValidationResult(boolean success, String errorMessage)
    {
        this.success = success;
        this.message = errorMessage;
    }

    public ValidationResult(boolean success)
    {
        this.success = success;
    }

    public boolean isFail()
    {
        return !success;
    }

    public static ValidationResult success()
    {
        return new ValidationResult(true);
    }

    public static ValidationResult error(String message)
    {
        return new ValidationResult(false,message);
    }
}

