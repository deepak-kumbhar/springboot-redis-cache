package com.example.redis.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String author;
    private String content;
    private String[] tags;
}
