package oneToOneAnn;

import jakarta.persistence.*;
import java.util.Map;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;

    @Column(name = "department_name")
    private String name;

    @ElementCollection
    @CollectionTable(
        name = "employee_names_map",
        joinColumns = @JoinColumn(name = "department_id")
    )
    @MapKeyColumn(name = "employee_id")
    @Column(name = "employee_name")
    private Map<Long, String> employeeNames;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Long, String> getEmployeeNames() {
        return employeeNames;
    }

    public void setEmployeeNames(Map<Long, String> employeeNames) {
        this.employeeNames = employeeNames;
    }
}
