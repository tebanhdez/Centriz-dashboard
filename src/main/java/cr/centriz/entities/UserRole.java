package cr.centriz.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "UserRole", schema="public")
@XmlRootElement
public class UserRole {
    
    public UserRole(){
    }

    public UserRole(int userRoleId){
        setId(userRoleId);
    }
  
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private int userRoleId;
    public int getUserRoleId() {
        return userRoleId;
    }
    public void setId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Column(name = "name")
    private String name;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    @OneToMany(mappedBy="user_role")
	private Set<User> user;
	public Set<User> getEmployees() {
		return user;
	}
	public void setEmployees(Set<User> user) {
		this.user = user;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;
        if (userRoleId != userRole.userRoleId) return false;
        return true;
    }
}