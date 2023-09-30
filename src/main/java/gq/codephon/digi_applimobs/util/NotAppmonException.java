package gq.codephon.digi_applimobs.util;

import net.minecraft.entity.Entity;

public class NotAppmonException extends Exception{
    public NotAppmonException() {
        super();
    }

    public NotAppmonException(String message) {
        super(message);
    }

    public NotAppmonException(Entity entity) {
        super("Caused by: " + entity);
    }

    public NotAppmonException(String message, Entity entity) {
        super(message+entity);
    }

    public NotAppmonException(String message, Throwable cause, Entity entity) {
        super(message+entity, cause);
    }
}
