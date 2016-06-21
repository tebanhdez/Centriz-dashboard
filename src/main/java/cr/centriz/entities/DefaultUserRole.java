package cr.centriz.entities;

public enum DefaultUserRole {
    ADMIN   (10, "ADMIN", "Administrator user role, all privileges"),
    READ    (11, "READ", "Read user role, only read privileges"),
    WRITE   (13, "WRITE", "Write user role, read and write privileges");

    private final int id;
    private final String name;
    private final String description;

    DefaultUserRole(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.description;
    }
}
