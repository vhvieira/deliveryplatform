//package app.details;
//
//import app.enums.PhoneType;
//
//import javax.persistence.*;
//
///**
// * Created by Rafael Leal on 12/10/2018.
// */
//@Entity
//public class Phone {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", updatable = false, nullable = false)
//    private Long id;
//
//    @Column(name = "phone_number")
//    private String number;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "phone_type")
//    private PhoneType type;
//
//    private String description;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    public PhoneType getType() {
//        return type;
//    }
//
//    public void setType(PhoneType type) {
//        this.type = type;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//}
