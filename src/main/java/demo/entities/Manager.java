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

    // TODO аннотация @OneToOne - (отображается как внешний ключ на связанную табицу)
    // аннотация @JoinTable создаст промежуточную таблицу к этой связи
    @OneToOne
	// TODO аннотация @PrimaryKeyJoinColumn
	//@PrimaryKeyJoinColumn
	// стратегия, при которой две связанные аннотацией @OneToOne таблицы будут иметь общий первичный ключ (без внешнего ключа)
    private Singer singer;

    // TODO встроенный атрибут и переопределение имени его оригинальных полей
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

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }
}
