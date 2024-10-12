package ru.clevertec.clevertecvideohostingchannelapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "channels")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Column(name = "creation_date")
    private LocalDate creationDate = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private ChannelLanguage language;

    @Column(name = "avatar")
    private byte[] avatar;

    @Enumerated(EnumType.STRING)
    private ChannelCategory category;

    @ManyToMany(mappedBy = "subscriptions")
    private List<User> subscribers;
}
