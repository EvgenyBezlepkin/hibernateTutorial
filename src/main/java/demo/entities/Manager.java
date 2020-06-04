package demo.entities;

import javax.persistence.*;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;


    // встроенный атрибут и переопределение имени его оригинальных полей

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="name",
            column = @Column(name = "SoundRecordingStudio_name")),
            @AttributeOverride(name="address",
                    column = @Column(name = "SoundRecordingStudio_address")),
    })
    private SoundRecordingStudio soundRecordingStudio;


    public SoundRecordingStudio getSoundRecordingStudio() {
        return soundRecordingStudio;
    }

    public void setSoundRecordingStudio(SoundRecordingStudio soundRecordingStudio) {
        this.soundRecordingStudio = soundRecordingStudio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
