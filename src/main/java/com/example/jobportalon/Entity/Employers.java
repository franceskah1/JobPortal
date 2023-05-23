package com.example.jobportalon.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employers extends BaseEntity {


    private String companyName;

    private String companyWebsite;


    private String companyDescription;
    // private blob logo;
    @ManyToOne
  //  @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
