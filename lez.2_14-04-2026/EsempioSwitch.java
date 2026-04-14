public class EsempioSwitch {

    public static void main(String[] args) {
        // Esempio di utilizzo dell'espressione condizionale swith
        int day = 4;

        // Lo switch permette di non eseguire più if uno sotto l'altro in modo da rendere il codice più leggibile:
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;

            default:
                // Questa è l'opzione di default nel caso in cui nessuna delle opzioni di sopra trovi corrispondenza con il case
                System.out.println("Non hai inserito nessuna data");
                break;
        }
    }

}