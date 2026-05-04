// Classe concreta che estende la classe astratta MessageDecorator

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampDecorator extends MessageDecorator {
    // Costruttore
    public TimestampDecorator(Message message) {
        super(message);
    }

    // Override dei metodi che "TimestampDecorator" eredita da "MessageDecorator"
    // che a sua volta implementa da "Message"

    // Metodo che setta il messaggio con il timestamp corrente:
    @Override
    public void setContent(String content) {
        // Istanzio un oggetto di LocalDateTime per ottenera la data corrente
        LocalDateTime orarioCorrente = LocalDateTime.now();
        // Definisco un formato valido istanziando un'oggetto di DateTimeFormmater
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        // Creo il timestamp formattato
        String timestamp = orarioCorrente.format(formatter);
        // Aggiungo il timestamp al messaggio

        this.decoratedMessage.setContent("[" + timestamp + "] " + content);
    }

    // Metodo che ritorna il messaggio modificato
    @Override
    public String getContent() {

        return this.decoratedMessage.getContent();
    }
}
