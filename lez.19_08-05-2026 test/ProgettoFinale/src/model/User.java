package model;

//Model: rappresenta l'utente del sistema
public class User {
    private String username;
    private String password;
    private String role; // USER / ADMIN

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public boolean isAdmin() {
        // Controlla prima se il ruolo è null e poi confronta se è uguale a "ADMIN" ignorando maiuscole/minuscole
        return role != null && role.equalsIgnoreCase("ADMIN");
    }
}